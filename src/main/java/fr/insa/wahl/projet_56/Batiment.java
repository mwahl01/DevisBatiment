package fr.insa.wahl.projet_56;

import java.io.*;

public class Batiment {
    private String idBatiment;
    private Numeroteur<Niveau> listeNiveau;
    
    Batiment(String nom, Numeroteur<Niveau> listeNiveau){
        this.idBatiment=nom;
        this.listeNiveau=listeNiveau;
    }
    
    public String getId(){
        return idBatiment;
    }
    
    public Numeroteur<Niveau> getListe(){
        return listeNiveau;
    }
    
    public void sauvegarde(){
        try{
            BufferedWriter batiment=new BufferedWriter(new FileWriter("Batiment.txt",true));
            }
        catch (IOException err)
        {System.out.println("Erreur :\n"+err);}
    }
}
