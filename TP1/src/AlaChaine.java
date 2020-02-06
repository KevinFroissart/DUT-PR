/**
 * Cette classe représente le service que nous allons rendre
 * accessible à distance.
 * Elle ne doit pas être modifiée
 */
public class AlaChaine implements AlaChaineInterface {

    public int nombreMots(String chaine) {
	return chaine.split("\\s+").length;
    }
    
    public String asphyxie(String chaine) throws PasDAirException {
	if ( chaine.contains("r") || chaine.contains("R") ) {
	    return chaine.replaceAll("[rR]", "");
	}
	else throw new PasDAirException("Déjà asphyxiée");
    }

    public String leetSpeak(String chaine) {
	String tmp = chaine.replaceAll("[aA]", "4");
	tmp = tmp.replaceAll("[eE]", "3");
	tmp = tmp.replaceAll("[iI]", "1");
	tmp = tmp.replaceAll("[oO]", "0");

	return tmp;
    }

    public int compteChar(String chaine, char c) {
        return chaine.split(""+c).length - 1;
    }
}

