package fr.insa.wahl.projet_56;

public class Sol {
    private int idSol, nbreTremie;
    private Numeroteur<Coin> listeCoinSol;
    private Numeroteur<Revetement> listeRevetement;
    
    Sol(int id, int tremie, Numeroteur<Coin> listeCoinSol, Numeroteur<Revetement> listeRevetement)
    {
        this.idSol=id;
        this.nbreTremie=tremie;
        this.listeCoinSol=listeCoinSol;
        this.listeRevetement=listeRevetement;
    }
    
    public int getId(){
        return idSol;
    }
    
    public int getTremie(){
        return nbreTremie;
    }
    
    public Numeroteur<Coin> getListeC(){
        return listeCoinSol;
    }
    
    public Numeroteur<Revetement> getListeR(){
        return listeRevetement;
    }
    
    void afficher()
    {System.out.println("==== Sol =====");
        this.listeCoinSol.toString();
    }
    
    
    double longueur()
    {
        if (listeCoinSol.size()<2){
            return 0.0;
        }
        Coin coinInfGauche=listeCoinSol.getObject(0);
        Coin coinInfDroit=listeCoinSol.getObject(1);
        double xcoinInfGauche=coinInfGauche.getX();
        double ycoinInfGauche=coinInfGauche.getY();
        double xcoinInfDroit=coinInfDroit.getX();
        double ycoinInfDroit=coinInfDroit.getY();
        return(Math.sqrt((xcoinInfDroit-xcoinInfGauche)*(xcoinInfDroit-xcoinInfGauche) + (ycoinInfDroit-ycoinInfGauche)*(ycoinInfDroit-ycoinInfGauche)));
    }
    
    double largeur()
    {
        if (listeCoinSol.size()<2){
            return 0.0;
        }
        Coin coinInfGauche=listeCoinSol.getObject(0);
        Coin coinSupGauche=listeCoinSol.getObject(1);
        double xcoinInfGauche=coinInfGauche.getX();
        double ycoinInfGauche=coinInfGauche.getY();
        double xcoinSupGauche=coinSupGauche.getX();
        double ycoinSupGauche=coinSupGauche.getY();
        return(Math.sqrt((xcoinSupGauche-xcoinInfGauche)*(xcoinSupGauche-xcoinInfGauche) + (ycoinSupGauche-ycoinInfGauche)*(ycoinSupGauche-ycoinInfGauche)));    }
    
    double surface()
    {
        return(this.longueur()*this.largeur());
    }
    
    double montantRevetement(){
        Tremie tremie=new Tremie(0);
        double surfaceRecouvrable=this.surface()-(nbreTremie*tremie.surface());
        System.out.println("Voulez-vous utiliser plusieurs revêtements ? oui(1)/non(0)");
        int reponse=Lire.i();
        if (reponse==0){
            System.out.println("Quel revêtement souhaitez-vous utiliser ? Indiquer l'index ");
            listeRevetement.toString();
            int indexRevetement=Lire.i();
            double prix=listeRevetement.getObject(indexRevetement).getPrix();
            return surfaceRecouvrable*prix;
        }
        else{
            System.out.println("En combien de parties souhaitez-vous diviser le mur ?");
            int n=Lire.i();
            double surfaceDivise=surfaceRecouvrable/n;
            double sommeTotale=0;
            for (int i=0;i<n;i++){
                System.out.println("Quel revêtement souhaitez-vous utiliser ? Indiquer l'index ");
                listeRevetement.toString();
                int indexRevetement=Lire.i();
                double prix=listeRevetement.getObject(indexRevetement).getPrix();
                sommeTotale=sommeTotale+(surfaceDivise*prix);
            }
            return sommeTotale;
        }
    }
    
    @Override
    public String toString() {
        return "Sol{" + "idSol=" + idSol + ", Coins du sol =" + listeCoinSol.toString() +')';
    }
    
}

   
