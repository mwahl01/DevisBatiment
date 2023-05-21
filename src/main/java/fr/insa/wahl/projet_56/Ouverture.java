package fr.insa.wahl.projet_56;

public class Ouverture {
     private double dimX ;
     private double dimY;
     private int idOuverture ; 
     
     Ouverture(int id, double largeur, double hauteur)
     {
         this.idOuverture=id;
         this.dimX=largeur;
         this.dimY=hauteur;
     }
     
     public int getId(){
         return idOuverture;
     }
     
     public double getX(){
         return dimX;
     }
     
     public double getY(){
         return dimY;
     }
     
    double surface()
    {
        return(this.dimX*this.dimY);
    }
    
    void afficher()
    {
        System.out.println("Ouverture : id="+this.idOuverture+" largeur="+this.dimX+" hauteur="+this.dimY);
    }
    
    @Override
    public String toString(){
        return "Ouverture{" + "idOuverture=" + idOuverture + ", dimX=" + dimX + ", dimY=" + dimY + '}';
    }
}
