package fr.insa.wahl.projet_56;

public class Appartement {
    private int idAppartement, idNiveauAppartement;
    private Numeroteur<Piece> listePiece;
    
    Appartement(int id, int niveau, Numeroteur<Piece> listePiece){
        this.idAppartement=id;
        this.idNiveauAppartement=niveau;
        this.listePiece=listePiece;
    }
    
    public int getId(){
        return idAppartement;
    }
    
    public int getNiveau(){
        return idNiveauAppartement;
    }
    
    public Numeroteur<Piece> getListe(){
        return listePiece;
    }
    
    double surface(){
        double surface=0;
        for(int i=0;i<listePiece.size();i++){
            surface=surface+listePiece.getObject(i).surface();
        }
        return surface;
    }
    
    double montantRevetement(){
        double sommeTotale=0;
        for(int i=0;i<listePiece.size();i++){
            sommeTotale=sommeTotale+listePiece.getObject(i).montantRevetement();
        }
        return sommeTotale;
    }
    @Override
    public String toString(){
        return "Appartement{"+"identifiant du mur"+idAppartement+"identifiant du niveau"+idNiveauAppartement+"Pièces de l'appartement"+listePiece.toString()+"}";
    }
}
