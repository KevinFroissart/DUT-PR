import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Cette classe démarre une socket serveur et
 * attend les connexions des clients.
 * Quand un client se connecte, elle délègue
 * le travail à la classe AccesService.
 */
public class Serveur {
	private ServerSocket serveurSocket = null;
	private AccesService accesService = null;


	public Serveur(int port) {
		try {
			// Création de la Socket Serveur qui permettra d'attendre les connexions
			serveurSocket = new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public void miseEnService() {
		Socket unClient = null;

		// Boucle d'attente des clients
		while (true ) {
			try {
				// accept() est bloquant. Quand on en sort, on a un nouveau
				// client avec une nouvelle instance de socket
				unClient = serveurSocket.accept();
				Thread t = new AccesService(unClient);
				t.run();
			} catch (IOException e) {
				e.printStackTrace();
				System.exit(1);
			}
			// quand on a un client, on peut instancier la
			// classe AccesService et lui demander de traiter
			// la requête.
		}
	}

	// La classe doit être exécutée en passant le port serveur à utiliser en paramètre
	public static void main(String[] args) {
		Serveur serveur = new Serveur(20003);
		serveur.miseEnService();
	}   
}