/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.wahl.projet_56;

/**
 *
 * @author Elève
 */
public class Maison extends Batiment{
    
    Maison(String id, Numeroteur<Niveau> listeNiveau){
        super(id,1,listeNiveau);
    }
    
    @Override
    public String toString(){
        return "Maison{"+"identifiant de la maison="+idBatiment+"Niveau du bâtiment="+listeNiveau.toString()+"}";
    }
}
