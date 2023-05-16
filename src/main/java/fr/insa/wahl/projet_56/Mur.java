package fr.insa.wahl.projet_56;

public class Mur {
    int idMur, nbrePortes, nbreFenetres;
    Coin debut, fin;
    
    
    
    Mur(int id, Coin dc, Coin fc)
    {
        this.idMur=id;
        this.debut=dc;
        this.fin=fc;
    }
    
    void afficher()
    {System.out.println("==== Mur =====");
        this.debut.afficher();
        this.fin.afficher();    
    }
    
    double longueur()
    {
        return(Math.sqrt((this.fin.cx-this.debut.cx)*(this.fin.cx-this.debut.cx) + (this.fin.cy-this.debut.cy)*(this.fin.cy-this.debut.cy)));
    }
    
    double surface()
    {
        System.out.println("\nEntrer la Hauteur du mur (hauteur sous-plafond)");
        double hsp=Lire.d();
        return(this.longueur()*hsp);
    }
    
    /*double montantRevetement(){
        System.out.println("Entrer le nombre de porte présente sur le mur");
        nbrePortes=Lire.i();
        System.out.println("Entrer le nombre de fenêtre présente sur le mur");
        nbreFenetres=Lire.i();
        return((this.surface()-(porte.surface())*nbrePortes-(fenetre.surface())*nbreFenetre)*x.prix);
    }
    */
    @Override
    public String toString() {
        return "Mur{" + "idMur=" + idMur + ", debut=" + debut + ", fin=" + fin + '}';
    }
    
}
