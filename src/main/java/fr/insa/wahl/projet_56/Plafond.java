/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.wahl.projet_56;
/**
 *
 * @author Elève
 */
public class Plafond {
    
    int idPlafond;
    Coin c1, c2, c3, c4;
    
    Plafond (int id,Coin a,Coin b, Coin c,Coin d){
        this.idPlafond=id;
        this.c1=a;
        this.c2=b;
        this.c3=c;
        this.c4=d;
    }
    
    double longeur(){
        return(Math.sqrt((this.c2.cx-this.c1.cx)*(this.c2.cx-this.c1.cx) + (this.c2.cy-this.c1.cy)*(this.c2.cy-this.c1.cy)));
    }
    
    double largeur(){
        return(Math.sqrt((this.c4.cx-this.c1.cx)*(this.c4.cx-this.c1.cx) + (this.c4.cy-this.c1.cy)*(this.c4.cy-this.c1.cy)));
    }
    
    double surface(){
        return (this.longeur()*this.largeur());
    }
    
}
