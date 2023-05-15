/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.wahl.projet_56;

/**
 *
 * @author Elève
 */
public class Ouverture {
     double dimX, dimY ;
     int idOuverture ; 
     
     Ouverture(int id, double largeur, double hauteur)
     {
         this.idOuverture=id;
         this.dimX=largeur;
         this.dimY=hauteur;
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
