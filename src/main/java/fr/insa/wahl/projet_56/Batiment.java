package fr.insa.wahl.projet_56;

public class Batiment {
    private String idBatiment;
    private Numeroteur<Niveau> listeNiveau;
    
    Batiment(String nom, Numeroteur<Niveau> listeNiveau){
        this.idBatiment=nom;
        this.listeNiveau=listeNiveau;
    }
    
    public String getId(){
        return idBatiment;
    }
    
    public Numeroteur<Niveau> getListe(){
        return listeNiveau;
    }
}
