package fr.insa.wahl.projet_56;

public class Revetement {
    int idRevetement ;
    String designation;
    boolean pourMur, pourSol, pourPlafond;
    double prixUnitaire;
    
    Revetement(int id, String nom, boolean pourMur, boolean pourSol, boolean pourPlafond, double prix)
    {
        this.idRevetement=id;
        this.designation=nom;
        this.pourMur=pourMur;
        this.pourSol=pourSol;
        this.pourPlafond=pourPlafond;
        this.prixUnitaire=prix;
    }
    
}
