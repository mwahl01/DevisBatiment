/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package fr.insa.wahl.projet_56;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Elève
 */
public class Projet_56 {

    public static void main(String[] args) {
        Numeroteur<Revetement> pourMur=new Numeroteur();
        Numeroteur<Revetement> pourSol=new Numeroteur();
        Numeroteur<Revetement> pourPlafond=new Numeroteur();
        try{
            String[] info;
            BufferedReader lecture=new BufferedReader(new FileReader("CatalogueRevetement.txt"));
            String lignelue;// Ligne lue depuis le fichier
            while((lignelue=lecture.readLine())!=null){
                info = lignelue.split(";");
                int idRevetement=Integer.parseInt(info[0]);
                String designation=info[1];
                boolean mur=Boolean.parseBoolean(info[2]);
                boolean sol=Boolean.parseBoolean(info[3]);
                boolean plafond=Boolean.parseBoolean(info[4]);
                double prixUnitaire=Double.parseDouble(info[5]);
                
                Revetement revetement=new Revetement(idRevetement, designation, mur, sol, plafond, prixUnitaire);
                
                if (mur){
                    pourMur.add(revetement);
                }
                if (sol){
                    pourSol.add(revetement);
                }
                if (plafond){
                    pourPlafond.add(revetement);
                }
            }
        lecture.close();
        }
        catch(FileNotFoundException err){
            System.out.println( "Erreur :le fichier n’existe pas!\n "+err);}
        catch (IOException err){
            System.out.println(" Erreur :\n "+err);}
        
        /*System.out.println(pourMur.toString());
        System.out.println(pourSol.toString());
        System.out.println(pourPlafond.toString());*/
        Numeroteur<Coin> listeCoin=new Numeroteur<Coin>();
        Numeroteur<Mur> listeMur=new Numeroteur<Mur>();
        
        System.out.println("Souhaitez-vous créer quelque chose ? oui/non");
        String S=Lire.S();
        while (S.equals("oui")){
        System.out.println("Que souhaitez-vous céer ?"+"\n"+"1-coin"+"\n"+"2-mur"+"\n"+"3-sol"+"\n"+"4-plafond"+"\n"+"5-pièce"+"\n"+"6-appartement"+"\n"+"7-niveau"+"\n"+"Entrer le numéro correspondant");
        int c=Lire.i();
        if (c==1){
            System.out.println("Entrer CREER pour créer un coin, entrer STOP pour arrêter");
            String reponseC=Lire.S();
            while (reponseC.equals("CREER")){
                System.out.println("Donner l'identifiant du coin");
                int id=Lire.i();
                System.out.println("Donner l'abscisse du coin");
                double x=Lire.d();
                System.out.println("Donner l'ordonnée du coin");
                double y=Lire.d();
                Coin coin=new Coin(id,x,y);
                listeCoin.add(coin);
                System.out.println("Voulez-vous continuer ?");
                reponseC=Lire.S();
            }
        }
        //System.out.println(listeCoin.toString());
        if (c==2){
            System.out.println("Entrer CREER pour créer un mur, entrer STOP pour arrêter");
            String reponseM=Lire.S();
            while (reponseM.equals("CREER")){
                if (listeCoin.size()<2){
                    System.out.println("Vous devez créer un coin supplémentaire");
                    System.out.println("Donner l'identifiant du coin");
                    int id=Lire.i();
                    System.out.println("Donner l'abscisse du coin");
                    double x=Lire.d();
                    System.out.println("Donner l'ordonnée du coin");
                    double y=Lire.d();
                    Coin coin=new Coin(id,x,y);
                    listeCoin.add(coin);
                }
                else{
                    System.out.println("Entrer l'identifiant du mur");
                    int id=Lire.i();
                    System.out.println("Quel est le coin de départ ?"+"\n"+listeCoin.toString()+"\n"+"Donner l'indexe");
                    int i=Lire.i();
                    Coin debut=listeCoin.getObject(i);
                    System.out.println("Quel est le coin de fin ?"+"\n"+listeCoin.toString()+"\n"+"Donner l'indexe");
                    i=Lire.i();
                    Coin fin=listeCoin.getObject(i);
                    System.out.println("Entrer le nombre de portes sur le mur");
                    int nbrePorte=Lire.i();
                    System.out.println("Entrer le nombre de fenêtres sur le mur");
                    int nbreFenetre=Lire.i();
                    Mur mur=new Mur(id,debut,fin,nbrePorte,nbreFenetre);
                    listeMur.add(mur);
                }
                System.out.println("Voulez-vous continuer ?");
                reponseM=Lire.S();
            }
        }
        }
        }
        /*Coin c1;
        System.out.println(" Identifiant du Coin");
        int id=Lire.i();
        System.out.println(" Abscisse du Coin");
        double x=Lire.d();
        System.out.println(" Ordonnée du Coin");
        double y=Lire.d();
        c1=new Coin(id,x,y);
        
        // Pour afficher textuellement le coin c1
        c1.afficher();
                
         Coin c2;
         System.out.println(" Identifiant du Coin");
         id=Lire.i();
         System.out.println(" Abscisse du Coin");
         x=Lire.d();
         System.out.println(" Ordonnée du Coin");
         y=Lire.d();
         c2=new Coin(id,x,y);
         
         Mur m1;
         System.out.println(" Identifiant du Mur");
         id=Lire.i();
         m1=new Mur(id,c1,c2);
         m1.afficher();
//         System.out.println(c2.toString());
//         System.out.println(m1.toString());
         System.out.println("Longueur du mur ="+m1.longueur());
         
         //Formattage de l'affichage
         System.out.format("\nLongueur du mur =%.2f",m1.longueur());
//         System.out.printf("\nLongueur du mur =%.3f\n",m1.longueur());
 /*         
// Exemple         
         double dval=7.1475;
         System.out.format("\nLongueur du mur =%.2f",dval);
         System.out.format("\nLongueur du mur =%.3f",dval);
         */
 
         // Calcul et affichage de la surface d'un mur
         //double surface=m1.surface();
         //System.out.println(m1.toString()+"\nSurface :"+m1.surface());
         //System.out.format(m1.toString()+"\nSurface :%.2f",m1.surface());
         
         /*calcul du coût de revêtement d'un mur
         System.out.println("Entrez revêtement");
         Revetement r ;
         System.out.println("Identifiant du revêtement");
         id=Lire.i();
         System.out.println("Prix du revêtement");
         double p=Lire.d();
         r =  new Revetement(id, p);
         double montantRevetement = calculMontantRevetement(m1,r);
         System.out.format("\nSurface :%.2f", montantRevetement);*/
      
         
         
    }//fin de la méthode main
    