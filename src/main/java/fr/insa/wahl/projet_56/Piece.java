package fr.insa.wahl.projet_56;

public class Piece {
    private int idPiece;
    private Sol solPiece;
    private Plafond plafondPiece;
    private Numeroteur<Mur> listeMurPiece;
    
    Piece (int id, Sol sol, Plafond plafond, Numeroteur<Mur> listeMurPiece){
        this.idPiece=id;
        this.solPiece=sol;
        this.plafondPiece=plafond;
        this.listeMurPiece=listeMurPiece;
    }
    
    public int getId(){
        return idPiece;
    }
    
    public Numeroteur<Mur> getListe(){
        return listeMurPiece;
    }
    
    public Sol getSol(){
        return solPiece;
    }
    
    public Plafond getPlafond(){
        return plafondPiece;
    }
    
    void afficher(){
        System.out.println("---Piece "+idPiece+"---");
        System.out.println("Sol");
        solPiece.toString();
        System.out.println("Plafond");
        plafondPiece.toString();
        System.out.println("Murs");
        listeMurPiece.toString();
    }
    
    double surface(){
        return solPiece.surface();
    }
    
    double montantRevetement(){
        double montantMur=0;
        for (int i=0;i<listeMurPiece.size();i++){
            montantMur=montantMur+listeMurPiece.getObject(i).montantRevetement();
        }
        return montantMur+solPiece.montantRevetement()+plafondPiece.montantRevetement();
    }
    
    @Override
    public String toString(){
        return "Pièce{"+"identifiant de la pièce="+idPiece+"Sol de la pièce"+solPiece.toString()+"Plafond de la pièce"+plafondPiece.toString()+"Murs de la pièce"+listeMurPiece.toString()+"}";
    }
}
