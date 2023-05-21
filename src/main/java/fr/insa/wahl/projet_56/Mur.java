package fr.insa.wahl.projet_56;

public class Mur {
    private int idMur;
    private Coin debut, fin;
    
    
    
    Mur(int id, Coin dc, Coin fc)
    {
        this.idMur=id;
        this.debut=dc;
        this.fin=fc;
    }
    
    public int getId(){
        return idMur;
    }
    
    public Coin getDebut(){
        return debut;
    }
    
    public Coin getFin(){
        return fin;
    }
    
    void afficher()
    {System.out.println("==== Mur =====");
        this.debut.afficher();
        this.fin.afficher();    
    }
    
    double longueur()
    {
        double xdebut= debut.getX();
        double xfin= fin.getX();
        double ydebut= debut.getY();
        double yfin= fin.getY();
        return(Math.sqrt((xfin-xdebut)*(xfin-xdebut) + (yfin-ydebut)*(yfin-ydebut)));
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
