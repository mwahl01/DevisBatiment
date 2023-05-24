package fr.insa.wahl.projet_56;

import java.io.*;

public class Batiment {
    private String idBatiment;
    private int nbreNiveau;
    private Numeroteur<Niveau> listeNiveau;
    
    Batiment(String nom, int nbreNiveau, Numeroteur<Niveau> listeNiveau){
        this.idBatiment=nom;
        this.listeNiveau=listeNiveau;
        this.nbreNiveau=nbreNiveau;
    }
    
    public String getId(){
        return idBatiment;
    }
    
    public int getNiveau(){
        return nbreNiveau;
    }
    
    public Numeroteur<Niveau> getListe(){
        return listeNiveau;
    }
    
    public void sauvegarde(){
        try{
            BufferedWriter batiment=new BufferedWriter(new FileWriter("Batiment.txt",true));
            batiment.write(idBatiment);
            batiment.newLine();
            for (int i=0;i<listeNiveau.size();i++){
                Niveau niveau=listeNiveau.getObject(i);
                batiment.write(niveau.toString());
                batiment.newLine();
                for (int k=0;k<niveau.getListe().size();k++){
                    Appartement appart=niveau.getListe().getObject(k);
                    batiment.write(appart.toString());
                    batiment.newLine();
                    for(int j=0;j<appart.getListe().size();j++){
                        Piece piece=appart.getListe().getObject(j);
                        batiment.write(piece.toString());
                        batiment.newLine();
                        for (int l=0;l<piece.getListe().size();l++){
                            Mur mur=piece.getListe().getObject(l);
                            batiment.write(mur.toString());
                            batiment.newLine();
                            batiment.write(mur.getDebut().toString());
                            batiment.newLine();
                            batiment.write(mur.getFin().toString());
                            batiment.newLine();
                        }
                    }
            }
            }
            }
        catch (IOException err)
        {System.out.println("Erreur :\n"+err);}
    }
}
