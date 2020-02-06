/**
 * Cette classe va utiliser notre service.
 * Elle permettra de vérifier que notre service
 * est toujours accessible de manière transparente
 * même quand il sera sur une autre machine.
 */
public class Utilisatrice {

	public static void main(String[] args) throws Exception {
		// On trouve ici la seule modification par rapport à une
		// utilisation normale.
		// On instancie la classe Intermediaire au lieu
		// d'instancier directement AlaChaine.
		Intermediaire i = new Intermediaire();

		i.nombreMots("Travail à la  chaîne");

		i.asphyxie("La moRale de l'histoire");
		i.asphyxie("j'ai soif");

		i.leetSpeak("l'Elite de la nation");

		i.compteChar("arrête ton char", 'a');
	}
}