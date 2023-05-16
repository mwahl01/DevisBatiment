package fr.insa.wahl.projet_56;

public class Sol {
    int idSol;
    Coin coinSupDr, coinSupGa, coinInfDr , coinInfGa;
    
   
    Sol(int id, Numeroteur<Coin> listeCoinSol)
    {
        this.idSol=id;
        this.coinSupGa=listeCoinSol.getObject(0);
        this.coinSupDr=listeCoinSol.getObject(1);
        this.coinInfGa=listeCoinSol.getObject(2);
        this.coinInfDr=listeCoinSol.getObject(3);
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
        return "Sol{" + "idSol=" + idSol + ", Coin supérieur gauche=" + coinSupGa + ", coin supérieur droit=" + coinSupDr + ", Coin inférieur gauche=" + coinInfGa + ", coin inférieur droit=" + coinInfDr + ')';
    }
    
}

   
