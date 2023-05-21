package fr.insa.wahl.projet_56;

public class Plafond {
    
    private int idPlafond;
    private Numeroteur<Coin> listeCoinPlafond;
    
   
    Plafond(int id, Numeroteur<Coin> listeCoinPlafond)
    {
        this.idPlafond=id;
        this.listeCoinPlafond=listeCoinPlafond;
    }
    
    public int getId(){
        return idPlafond;
    }
    
    public Numeroteur<Coin> getListe(){
        return listeCoinPlafond;
    }
    void afficher()
    {System.out.println("==== Sol =====");
        this.listeCoinPlafond.toString();
    }
    
    
    double longueur()
    {
        if (listeCoinPlafond.size()<2){
            return 0.0;
        }
        Coin coinInfGauche=listeCoinPlafond.getObject(0);
        Coin coinInfDroit=listeCoinPlafond.getObject(1);
        double xcoinInfGauche=coinInfGauche.getX();
        double ycoinInfGauche=coinInfGauche.getY();
        double xcoinInfDroit=coinInfDroit.getX();
        double ycoinInfDroit=coinInfDroit.getY();
        return(Math.sqrt((xcoinInfDroit-xcoinInfGauche)*(xcoinInfDroit-xcoinInfGauche) + (ycoinInfDroit-ycoinInfGauche)*(ycoinInfDroit-ycoinInfGauche)));
    }
    
    double largeur()
    {
        if (listeCoinPlafond.size()<2){
            return 0.0;
        }
        Coin coinInfGauche=listeCoinPlafond.getObject(0);
        Coin coinSupGauche=listeCoinPlafond.getObject(1);
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
        return "Sol{" + "idSol=" + idPlafond + ", Coins du sol =" + listeCoinPlafond.toString() +')';
    }
    
}
