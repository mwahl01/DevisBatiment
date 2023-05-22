package fr.insa.wahl.projet_56;

public class Revetement {
    private int idRevetement ;
    private String designation;
    private boolean pourMur, pourSol, pourPlafond;
    private double prixUnitaire;
    
    Revetement(int id, String nom, boolean pourMur, boolean pourSol, boolean pourPlafond, double prix)
    {
        this.idRevetement=id;
        this.designation=nom;
        this.pourMur=pourMur;
        this.pourSol=pourSol;
        this.pourPlafond=pourPlafond;
        this.prixUnitaire=prix;
    }
    
    public int getId(){
        return idRevetement;
    }
    
    public double getPrix(){
        return prixUnitaire;
    }
    
    public String getNom(){
        return designation;
    }
    
    public boolean isPourMur(){
        return pourMur;
    }
    
    public boolean isPourSol(){
        return pourSol;
    }
    
    public boolean isPourPlafond(){
        return pourPlafond;
    }
}
