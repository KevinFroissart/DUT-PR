import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Cette classe se trouvera côté service
 * Elle recevra une requête sous forme de chaîne
 * de caractère conforme à votre protocole.
 * Elle transformera cette requête en une
 * invocation de méthode sur le service puis
 * renverra le résultat sous forme de chaîne
 * de caractères.
 */
public class AccesService extends Thread{
	private AlaChaine alc;
	private Socket socket;

	public AccesService(Socket socket) {
		this.socket = socket;
		alc = new AlaChaine();
	}

	public AccesService() {
		alc = new AlaChaine();
	}

	public String traiteInvocation(String invocation) {
		String reponse = "REPONSE:";
		String[] query = invocation.split(":");
		switch (query[1]) {
		case "nombreMots":
			reponse += "nombreMots:param[int,"+String.valueOf(alc.nombreMots(paramOf(query[2]))) + "]";
			break;
		case "asphyxie":
			try {
				reponse += "asphyxie:param[string,"+alc.asphyxie(paramOf(query[2])) + "]";
			} catch (PasDAirException e) {
				reponse = "EXCEPTION:asphyxie["+e.getMessage() + "]";
			}
			break;
		case "leetSpeak":
			reponse += "leetSpeak:param[string,"+alc.leetSpeak(paramOf(query[2])) + "]";
			break;
		case "compteChar":
			reponse += "compteChar:param[int,"+String.valueOf(alc.compteChar(paramOf(query[2]), paramOf(query[3]).charAt(0))) + "]";
		}
		return reponse;
	}

	private String paramOf(String param) {
		char split = '"';
		String[] decoupe = param.split(String.valueOf(split));
		return decoupe[1];
	}

	public void request() {
		try {
			System.out.println("Connecté");
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while(bufferedReader.toString() != "quit") {
				bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter printwriter = new PrintWriter(socket.getOutputStream());
				String line;
				if((line = bufferedReader.readLine()).equals("quit")) {
					System.out.println("Déconnecté");
					System.exit(0);
				}
				printwriter.println(this.traiteInvocation(line));
				printwriter.flush();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		this.request();
	}

}