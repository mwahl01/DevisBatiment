package fr.insa.wahl.projet_56;

public class Plafond {
    
    private int idPlafond, nbreTremie;
    private Numeroteur<Coin> listeCoinPlafond;
    private Numeroteur<Revetement> listeRevetement;
    
    Plafond(int id, int tremie, Numeroteur<Coin> listeCoinPlafond)
    {
        this.idPlafond=id;
        this.nbreTremie=tremie;
        this.listeCoinPlafond=listeCoinPlafond;
    }
   
    Plafond(int id, int tremie, Numeroteur<Coin> listeCoinPlafond, Numeroteur<Revetement> listeRevetement)
    {
        this.idPlafond=id;
        this.nbreTremie=tremie;
        this.listeCoinPlafond=listeCoinPlafond;
        this.listeRevetement=listeRevetement;
    }
    
    public int getId(){
        return idPlafond;
    }
    
    public int getTremie(){
        return nbreTremie;
    }
    
    public Numeroteur<Coin> getListeC(){
        return listeCoinPlafond;
    }
    
    public Numeroteur<Revetement> getListeR(){
        return listeRevetement;
    }
    void afficher()
    {System.out.println("==== Sol =====");
        this.listeCoinPlafond.toString();
    }
    
    
    double longueur()
    {
        if (listeCoinPlafond.size()<2){
            return 0.0;
        }
        Coin coinInfGauche=listeCoinPlafond.getObject(0);
        Coin coinInfDroit=listeCoinPlafond.getObject(1);
        double xcoinInfGauche=coinInfGauche.getX();
        double ycoinInfGauche=coinInfGauche.getY();
        double xcoinInfDroit=coinInfDroit.getX();
        double ycoinInfDroit=coinInfDroit.getY();
        return(Math.sqrt((xcoinInfDroit-xcoinInfGauche)*(xcoinInfDroit-xcoinInfGauche) + (ycoinInfDroit-ycoinInfGauche)*(ycoinInfDroit-ycoinInfGauche)));
    }
    
    double largeur()
    {
        if (listeCoinPlafond.size()<2){
            return 0.0;
        }
        Coin coinInfGauche=listeCoinPlafond.getObject(0);
        Coin coinSupGauche=listeCoinPlafond.getObject(1);
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
        return "Plafond{" + "idPlafond=" + idPlafond + ", Coins du plafond =" + listeCoinPlafond.toString() +')';
    }
    
}
