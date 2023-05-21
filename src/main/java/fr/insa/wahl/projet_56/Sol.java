package fr.insa.wahl.projet_56;

public class Sol {
    private int idSol;
    private Numeroteur<Coin> listeCoinSol;
    
   
    Sol(int id, Numeroteur<Coin> listeCoinSol)
    {
        this.idSol=id;
        this.listeCoinSol=listeCoinSol;
    }
    
    public int getId(){
        return idSol;
    }
    
    public Numeroteur<Coin> getListe(){
        return listeCoinSol;
    }
    void afficher()
    {System.out.println("==== Sol =====");
        this.listeCoinSol.toString();
    }
    
    
    double longueur()
    {
        if (listeCoinSol.size()<2){
            return 0.0;
        }
        Coin coinInfGauche=listeCoinSol.getObject(0);
        Coin coinInfDroit=listeCoinSol.getObject(1);
        double xcoinInfGauche=coinInfGauche.getX();
        double ycoinInfGauche=coinInfGauche.getY();
        double xcoinInfDroit=coinInfDroit.getX();
        double ycoinInfDroit=coinInfDroit.getY();
        return(Math.sqrt((xcoinInfDroit-xcoinInfGauche)*(xcoinInfDroit-xcoinInfGauche) + (ycoinInfDroit-ycoinInfGauche)*(ycoinInfDroit-ycoinInfGauche)));
    }
    
    double largeur()
    {
        if (listeCoinSol.size()<2){
            return 0.0;
        }
        Coin coinInfGauche=listeCoinSol.getObject(0);
        Coin coinSupGauche=listeCoinSol.getObject(1);
        double xcoinInfGauche=coinInfGauche.getX();
        double ycoinInfGauche=coinInfGauche.getY();
        double xcoinSupGauche=coinSupGauche.getX();
        double ycoinSupGauche=coinSupGauche.getY();
        return(Math.sqrt((xcoinSupGauche-xcoinInfGauche)*(xcoinSupGauche-xcoinInfGauche) + (ycoinSupGauche-ycoinInfGauche)*(ycoinSupGauche-ycoinInfGauche)));    }
    
    double surface()
    {
        return(this.longueur()*this.largeur());
    }
    
    @Override
    public String toString() {
        return "Sol{" + "idSol=" + idSol + ", Coins du sol =" + listeCoinSol.toString() +')';
    }
    
}

   
