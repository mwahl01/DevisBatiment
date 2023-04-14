/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.wahl.projet_56;

/**
 *
 * @author thoma
 */
public class Sol {
    int idSol;
    Coin a, b, c , d;
    
   
    Sol(int id, Coin ac, Coin bc, Coin cc, Coin dc)
    {
        this.idSol=id;
        this.a=ac;
        this.b=bc;
        this.c=cc;
        this.d=dc;
    }
    
    
    void afficher()
    {System.out.println("==== Sol =====");
        this.a.afficher();
        this.b.afficher();    
        this.c.afficher();
        this.d.afficher(); 
    }
    
    
    double longueur()
    {
        return(Math.sqrt((this.b.cx-this.a.cx)*(this.b.cx-this.a.cx) + (this.b.cy-this.a.cy)*(this.b.cy-this.a.cy)));
    }
    
    double largeur()
    {
        return(Math.sqrt((this.c.cx-this.a.cx)*(this.c.cx-this.a.cx) + (this.c.cy-this.a.cy)*(this.c.cy-this.a.cy)));
    }
    
    double surface()
    {
        return(this.longueur()*this.largeur());
    }
    
    @Override
    public String toString() {
        return "Sol{" + "idSol=" + idSol + ", Coin a=" + a + ", coin b=" + b + ", Coin c=" + c + ", coin d=" + d + ')';
    }
    
}

   
