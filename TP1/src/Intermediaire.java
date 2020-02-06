/**
 * Cette classe introduit un intermédiaire entre la classe utilisatrice
 * et l'implémentation du traitement des chaînes.
 * Au début cette classe se contente de logger ce qui se passe puis
 * elle va évoluer pour accéder au service à distance.
 * Le comportement de cette classe est totalement transparent pour la
 * classe Utilisatrice qui au final utilise les mêmes méthodes que si elle
 * appelait directement la classe AlaChaine.
 */
public class Intermediaire implements AlaChaineInterface{

    private AccesService as;
    private Client cli;

    public Intermediaire() {
        as = new AccesService();
        cli = new Client("localhost", 20003);
    }

    public int nombreMots(String chaine) {
        String[] result = cli.envoyer("CALL:nombreMots:param[string,\""+chaine+"\"]").split(":");
        return Integer.parseInt(result[1]);
    }

    public String asphyxie(String chaine) {
        String[] result = cli.envoyer("CALL:asphyxie:param[string,\""+chaine+"\"]").split(":");
        return result[1];
    }

    public String leetSpeak(String chaine) {
        String[] result = cli.envoyer("CALL:leetSpeak:param[string,\""+chaine+"\"]").split(":");
        return result[1];
    }

    public int compteChar(String chaine, char c) {
        String[] result = cli.envoyer("CALL:compteChar:param[string,\""+chaine+"\"]:param[char,\""+c+"\"]").split(":");
        return Integer.parseInt(result[1]);
    }

}