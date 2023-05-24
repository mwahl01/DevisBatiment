/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.wahl.projet_56;

/**
 *
 * @author Elève
 */
public class Immeuble extends Batiment {
    
    Immeuble(String id, int nbreNiveau,  Numeroteur<Niveau> listeNiveau){
            super(id,nbreNiveau,listeNiveau);
    }        
}
