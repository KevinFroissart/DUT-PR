/**
 * Cette classe spécifie le service proposé.
 * La classe Intermediaire devra respecter la même
 * interface pour que le client puisse être codé
 * sans changements.
 */
interface AlaChaineInterface {
    public int nombreMots(String chaine);

    public String asphyxie(String chaine) throws PasDAirException;
    
    public String leetSpeak(String chaine);
    
    public int compteChar(String chaine, char c);
}
