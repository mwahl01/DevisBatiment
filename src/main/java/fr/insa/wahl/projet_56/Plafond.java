package fr.insa.wahl.projet_56;

public class Plafond {
    
    int idPlafond;
    Coin coinSupDr, coinSupGa, coinInfDr , coinInfGa;
    
   
    Plafond(int id, Numeroteur<Coin> listeCoinPlafond)
    {
        this.idPlafond=id;
        this.coinSupGa=listeCoinPlafond.getObject(0);
        this.coinSupDr=listeCoinPlafond.getObject(1);
        this.coinInfGa=listeCoinPlafond.getObject(2);
        this.coinInfDr=listeCoinPlafond.getObject(3);
    }
    
    
    void afficher()
    {System.out.println("==== Sol =====");
        this.coinSupGa.afficher();
        this.coinSupDr.afficher();    
        this.coinInfGa.afficher();
        this.coinInfDr.afficher(); 
    }
    
    
    double longueur()
    {
        return(Math.sqrt((this.coinSupDr.cx-this.coinSupGa.cx)*(this.coinSupDr.cx-this.coinSupGa.cx) + (this.coinSupDr.cy-this.coinSupGa.cy)*(this.coinSupDr.cy-this.coinSupGa.cy)));
    }
    
    double largeur()
    {
        return(Math.sqrt((this.coinInfGa.cx-this.coinSupGa.cx)*(this.coinInfGa.cx-this.coinSupGa.cx) + (this.coinInfGa.cy-this.coinSupGa.cy)*(this.coinInfGa.cy-this.coinSupGa.cy)));
    }
    
    double surface()
    {
        return(this.longueur()*this.largeur());
    }
    
    @Override
    public String toString() {
        return "Plafond{" + "idPlafond=" + idPlafond + ", Coin supérieur gauche=" + coinSupGa + ", coin supérieur droit=" + coinSupDr + ", Coin inférieur gauche=" + coinInfGa + ", coin inférieur droit=" + coinInfDr + ')';
    }
    
}
