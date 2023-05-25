package fr.insa.wahl.projet_56;

public class Mur {
    private int idMur, nbrePorte, nbreFenetre;
    private Coin debut, fin;
    private Numeroteur<Revetement> listeRevetement;
    
    Mur(int id, Coin dc, Coin fc, int nbrePorte, int nbreFenetre, Numeroteur<Revetement> listeRevetement)
    {
        this.idMur=id;
        this.debut=dc;
        this.fin=fc;
        this.nbrePorte=nbrePorte;
        this.nbreFenetre=nbreFenetre;
        this.listeRevetement=listeRevetement;
    }
    
    public int getId(){
        return idMur;
    }
    
    public Coin getDebut(){
        return debut;
    }
    
    public Coin getFin(){
        return fin;
    }
    
    public int getPorte(){
        return nbrePorte;
    }
    
    public int getFenetre(){
        return nbreFenetre;
    }
    
    public Numeroteur<Revetement> getListe(){
        return listeRevetement;
    }
    
    void afficher()
    {System.out.println("==== Mur =====");
        this.debut.afficher();
        this.fin.afficher();    
    }
    
    double longueur()
    {
        double xdebut= debut.getX();
        double xfin= fin.getX();
        double ydebut= debut.getY();
        double yfin= fin.getY();
        return(Math.sqrt((xfin-xdebut)*(xfin-xdebut) + (yfin-ydebut)*(yfin-ydebut)));
    }
    
    double surface()
    {
        System.out.println("\nEntrer la Hauteur du mur (hauteur sous-plafond)");
        double hsp=Lire.d();
        return(this.longueur()*hsp);
    }
    
    double montantRevetement(){
        Porte porte=new Porte(0);
        Fenetre fenetre=new Fenetre(0);
        double surfaceRecouvrable=this.surface()-(porte.surface()*nbrePorte)-(fenetre.surface()*nbreFenetre);
        System.out.println("Voulez-vous utiliser plusieurs revêtements ? oui(1)/non(0)");
        int reponse=Lire.i();
        if (reponse==0){
            System.out.println("Quel revêtement souhaitez-vous utiliser ? Indiquer l'index "+"\n"+listeRevetement.toString());
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
                System.out.println("Quel revêtement souhaitez-vous utiliser ? Indiquer l'index "+"\n"+listeRevetement.toString());
                int indexRevetement=Lire.i();
                double prix=listeRevetement.getObject(indexRevetement).getPrix();
                sommeTotale=sommeTotale+(surfaceDivise*prix);
            }
            return sommeTotale;
        }
    }
    @Override
    public String toString() {
        return "Mur{" + "idMur=" + idMur + ", debut=" + debut + ", fin=" + fin + '}';
    }
    
}
