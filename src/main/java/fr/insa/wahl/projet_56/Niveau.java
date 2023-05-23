package fr.insa.wahl.projet_56;

public class Niveau {
    private int idNiveau;
    private double hauteurSousPlafond;
    private Numeroteur<Appartement> listeAppartement;
    
    Niveau(int id, double hauteur, Numeroteur<Appartement> listeAppartement){
        this.idNiveau=id;
        this.hauteurSousPlafond=hauteur;
        this.listeAppartement=listeAppartement;
    }
    
    public int getId(){
        return idNiveau;
    }
    
    public double getHauteur(){
        return hauteurSousPlafond;
    }
    
    public Numeroteur<Appartement> getListe(){
        return listeAppartement;
    }
    
    double surface(){
        double surface=0;
        for (int i=0; i<listeAppartement.size();i++){
            surface=surface+listeAppartement.getObject(i).surface();
        }
        return surface;
    }
    
    double montantRevetement(){
        double sommeTotale=0;
        for(int i=0;i<listeAppartement.size();i++){
            sommeTotale=sommeTotale+listeAppartement.getObject(i).montantRevetement();
        }
        return sommeTotale;
    }
    
    @Override
    public String toString(){
        return "Niveau{"+"identifiant du niveau ="+idNiveau+"hauteur sous plafond="+hauteurSousPlafond+"Appartements du niveau="+listeAppartement.toString()+"}";
    }
}
