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
        
        //Lecture du fichier CatalogueRevetement et répartition dans les différentes listes
        
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
        Numeroteur<Sol> listeSol=new Numeroteur<Sol>();
        Numeroteur<Plafond> listePlafond=new Numeroteur<Plafond>();
        Numeroteur<Piece> listePiece=new Numeroteur<Piece>();
        Numeroteur<Appartement> listeAppart=new Numeroteur<Appartement>();
        Numeroteur<Niveau> listeNiveau=new Numeroteur<Niveau>();

        System.out.println("Souhaitez-vous créer quelque chose ? oui/non");
        String S=Lire.S();
        while (S.equals("oui")){
        System.out.println("Que souhaitez-vous céer ?"+"\n"+"1-coin"+"\n"+"2-mur"+"\n"+"3-sol"+"\n"+"4-plafond"+"\n"+"5-pièce"+"\n"+"6-appartement"+"\n"+"7-niveau"+"\n"+"Entrer le numéro correspondant");
        int c=Lire.i();
        
//Création d'un coin
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
        }// Fin création coin
        
        
//Création d'un mur
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
        }//Fin création mur
        
//Création d'un sol
        if (c==3){
            System.out.println("Entrer CREER pour créer un sol, entrer STOP pour arrêter");
            String reponseS=Lire.S();
            while (reponseS.equals("CREER")){
                System.out.println("Entrer l'identifiant du sol");
                int idSol=Lire.i();
                Numeroteur<Coin> petiteListe=new Numeroteur<Coin>();
                while (petiteListe.size()!=4){
                    if(listeCoin.size()<4){
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
                    for (int i=0;i<4;i++){
                        System.out.println("Choisissez un coin constituant le sol"+"\n"+listeCoin.toString()+"\n"+"Donnez l'indexe");
                        int index=Lire.i();
                        petiteListe.add(listeCoin.getObject(index));
                    }
                    }
                }
                System.out.println("Entrez le nombre de tremie présent sur le sol");
                int nbreTremie=Lire.i();
                Sol sol=new Sol(idSol,nbreTremie,petiteListe);
                listeSol.add(sol);
                System.out.println("Voulez-vous continuer ?");
                reponseS=Lire.S();
            }
        }//Fin création sol
        
//Création d'un plafond
        if(c==4){
            System.out.println("Entrer CREER pour créer un plafond, entrer STOP pour arrêter");
            String reponseP=Lire.S();
            while (reponseP.equals("CREER")){
                System.out.println("Entrer l'identifiant du plafond");
                int idPlafond=Lire.i();
                Numeroteur<Coin> petiteListe=new Numeroteur<Coin>();
                while (petiteListe.size()!=4){
                    if(listeCoin.size()<4){
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
                    for (int i=0;i<4;i++){
                        System.out.println("Choisissez un coin constituant le plafond"+"\n"+listeCoin.toString()+"\n"+"Donnez l'indexe");
                        int index=Lire.i();
                        petiteListe.add(listeCoin.getObject(index));
                    }
                    }
                }
                System.out.println("Entrez le nombre de tremie présent sur le plafond");
                int nbreTremie=Lire.i();
                Plafond plafond=new Plafond(idPlafond,nbreTremie,petiteListe);
                listePlafond.add(plafond);
                System.out.println("Voulez-vous continuer ?");
                reponseP=Lire.S();
            }
        }//Fin création Plafond
        
//Création d'une pièce
        if (c==5){
            System.out.println("Entrer CREER pour créer une pièce, entrer STOP pour arrêter");
            String reponsePc=Lire.S();
            while (reponsePc.equals("CREER")){
                System.out.println("Entrer l'identifiant de la pièce");
                int idPiece=Lire.i();
                if (listeSol.size()==0){
                    System.out.println("Vous devez créer un sol supplémentaire");
                    System.out.println("Entrer l'identifiant du sol");
                    int idSol=Lire.i();
                    Numeroteur<Coin> petiteListe=new Numeroteur<Coin>();
                    while (petiteListe.size()!=4){
                        if(listeCoin.size()<4){
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
                            for (int i=0;i<4;i++){
                            System.out.println("Choisissez un coin constituant le sol"+"\n"+listeCoin.toString()+"\n"+"Donnez l'indexe");
                            int index=Lire.i();
                            petiteListe.add(listeCoin.getObject(index));
                            }
                        }
                    }
                    System.out.println("Entrez le nombre de tremie présent sur le sol");
                    int nbreTremie=Lire.i();
                    Sol sol=new Sol(idSol,nbreTremie,petiteListe);
                    listeSol.add(sol);
                }
                System.out.println("Choisissez le sol constitutant la pièce"+"\n"+listeSol.toString()+"\n"+"Donnez l'index");
                int index=Lire.i();
                Sol solPiece=listeSol.getObject(index);
                if (listePlafond.size()==0){
                    System.out.println("Vous devez créer un plafond supplémentaire");
                    System.out.println("Entrer l'identifiant du plafond");
                    int idPlafond=Lire.i();
                    Numeroteur<Coin> petiteListe=new Numeroteur<Coin>();
                    while (petiteListe.size()!=4){
                        if(listeCoin.size()<4){
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
                            for (int i=0;i<4;i++){
                                System.out.println("Choisissez un coin constituant le plafond"+"\n"+listeCoin.toString()+"\n"+"Donnez l'indexe");
                                int indexe=Lire.i();
                                petiteListe.add(listeCoin.getObject(indexe));
                            }
                        }
                    }
                    System.out.println("Entrez le nombre de tremie présent sur le plafond");
                    int nbreTremie=Lire.i();
                    Plafond plafond=new Plafond(idPlafond,nbreTremie,petiteListe);
                    listePlafond.add(plafond);
                }
                System.out.println("Choisissez le plafond constitutant la pièce"+"\n"+listePlafond.toString()+"\n"+"Donnez l'index");
                int indx=Lire.i();
                Plafond plafondPiece=listePlafond.getObject(indx);
                System.out.println("Combien de murs possède la pièce ?");
                int nbreMur=Lire.i();
                Numeroteur<Mur> listeMurPiece=new Numeroteur<Mur>();
                while(listeMur.size()<nbreMur){
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
                }
                for(int k=0;k<nbreMur;k++){
                    System.out.println("Choisissez un mur constituant la pièce"+"\n"+listeMur.toString()+"\n"+"Donnez l'indexe");
                    int inx=Lire.i();
                    listeMurPiece.add(listeMur.getObject(inx));
                }
                Piece piece=new Piece(idPiece,solPiece,plafondPiece,listeMurPiece);
                listePiece.add(piece);
                System.out.println("Voulez-vous continuer ?");
                reponsePc=Lire.S();
            }
        }//Fin création pièce
        
//Création d'un appartement
        if (c==6){
            System.out.println("Entrer CREER pour créer un appartement, entrer STOP pour arrêter");
            String reponseA=Lire.S();
            while (reponseA.equals("CREER")){
                System.out.println("Entrer l'identifiant de l'appartement");
                int idAppart=Lire.i();
                System.out.println("Entrer le niveau auquel est situé l'appartement");
                int idNiveauAppart=Lire.i();
                System.out.println("Combien de pièces possède l'appartement ?");
                int nbrePiece=Lire.i();
                Numeroteur<Piece> listePieceAppart=new Numeroteur<Piece>();
                while (listePiece.size()<nbrePiece){
                    System.out.println("Vous devez créer une pièce supplémentaire");
                    System.out.println("Entrer l'identifiant de la pièce");
                int idPiece=Lire.i();
                if (listeSol.size()==0){
                    System.out.println("Vous devez créer un sol supplémentaire");
                    System.out.println("Entrer l'identifiant du sol");
                    int idSol=Lire.i();
                    Numeroteur<Coin> petiteListe=new Numeroteur<Coin>();
                    while (petiteListe.size()!=4){
                        if(listeCoin.size()<4){
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
                            for (int i=0;i<4;i++){
                            System.out.println("Choisissez un coin constituant le sol"+"\n"+listeCoin.toString()+"\n"+"Donnez l'indexe");
                            int index=Lire.i();
                            petiteListe.add(listeCoin.getObject(index));
                            }
                        }
                    }
                    System.out.println("Entrez le nombre de tremie présent sur le sol");
                    int nbreTremie=Lire.i();
                    Sol sol=new Sol(idSol,nbreTremie,petiteListe);
                    listeSol.add(sol);
                }
                System.out.println("Choisissez le sol constitutant la pièce"+"\n"+listeSol.toString()+"\n"+"Donnez l'index");
                int index=Lire.i();
                Sol solPiece=listeSol.getObject(index);
                if (listePlafond.size()==0){
                    System.out.println("Vous devez créer un plafond supplémentaire");
                    System.out.println("Entrer l'identifiant du plafond");
                    int idPlafond=Lire.i();
                    Numeroteur<Coin> petiteListe=new Numeroteur<Coin>();
                    while (petiteListe.size()!=4){
                        if(listeCoin.size()<4){
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
                            for (int i=0;i<4;i++){
                                System.out.println("Choisissez un coin constituant le plafond"+"\n"+listeCoin.toString()+"\n"+"Donnez l'indexe");
                                int indexe=Lire.i();
                                petiteListe.add(listeCoin.getObject(indexe));
                            }
                        }
                    }
                    System.out.println("Entrez le nombre de tremie présent sur le plafond");
                    int nbreTremie=Lire.i();
                    Plafond plafond=new Plafond(idPlafond,nbreTremie,petiteListe);
                    listePlafond.add(plafond);
                }
                System.out.println("Choisissez le plafond constitutant la pièce"+"\n"+listePlafond.toString()+"\n"+"Donnez l'index");
                int indx=Lire.i();
                Plafond plafondPiece=listePlafond.getObject(indx);
                System.out.println("Combien de murs possède la pièce ?");
                int nbreMur=Lire.i();
                Numeroteur<Mur> listeMurPiece=new Numeroteur<Mur>();
                while(listeMur.size()<nbreMur){
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
                }
                for(int k=0;k<nbreMur;k++){
                    System.out.println("Choisissez un mur constituant la pièce"+"\n"+listeMur.toString()+"\n"+"Donnez l'indexe");
                    int inx=Lire.i();
                    listeMurPiece.add(listeMur.getObject(inx));
                }
                Piece piece=new Piece(idPiece,solPiece,plafondPiece,listeMurPiece);
                listePiece.add(piece);
                }
            for (int k=0;k<nbrePiece;k++){
                System.out.println("Choisissez une pièce constituant l'appartement"+"\n"+listePiece.toString()+"\n"+"Donnez l'indexe");
                int idx=Lire.i();
                listePieceAppart.add(listePiece.getObject(idx));
            }
            Appartement appart=new Appartement(idAppart, idNiveauAppart, listePieceAppart);
            listeAppart.add(appart);
            System.out.println("Voulez-vous continuer ?");
            reponseA=Lire.S();
            }
        }//Fin création appartement
        
//Création d'un niveau
        if (c==7){
            System.out.println("Entrer CREER pour créer un niveau, entrer STOP pour arrêter");
            String reponseN=Lire.S();
            while (reponseN.equals("CREER")){
                System.out.println("Entrer l'identifiant du niveau");
                int idNiveau=Lire.i();
                System.out.println("Entrer l'hauteur sous plafond du niveau");
                double hsp=Lire.d();
                Numeroteur<Appartement> listeAppartNiveau=new Numeroteur<Appartement>();
                for (int j=0;j<listeAppart.size();j++){
                    if (listeAppart.getObject(j).getNiveau()==idNiveau){
                        listeAppartNiveau.add(listeAppart.getObject(j));
                    }
                }
                if (listeAppartNiveau.size()==0){
                    System.out.println("Vous devez créer un appartement supplémentaire pour ce niveau");
                    System.out.println("Entrer l'identifiant de l'appartement");
                int idAppart=Lire.i();
                System.out.println("Combien de pièces possède l'appartement ?");
                int nbrePiece=Lire.i();
                Numeroteur<Piece> listePieceAppart=new Numeroteur<Piece>();
                while (listePiece.size()<nbrePiece){
                    System.out.println("Vous devez créer une pièce supplémentaire");
                    System.out.println("Entrer l'identifiant de la pièce");
                int idPiece=Lire.i();
                if (listeSol.size()==0){
                    System.out.println("Vous devez créer un sol supplémentaire");
                    System.out.println("Entrer l'identifiant du sol");
                    int idSol=Lire.i();
                    Numeroteur<Coin> petiteListe=new Numeroteur<Coin>();
                    while (petiteListe.size()!=4){
                        if(listeCoin.size()<4){
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
                            for (int i=0;i<4;i++){
                            System.out.println("Choisissez un coin constituant le sol"+"\n"+listeCoin.toString()+"\n"+"Donnez l'indexe");
                            int index=Lire.i();
                            petiteListe.add(listeCoin.getObject(index));
                            }
                        }
                    }
                    System.out.println("Entrez le nombre de tremie présent sur le sol");
                    int nbreTremie=Lire.i();
                    Sol sol=new Sol(idSol,nbreTremie,petiteListe);
                    listeSol.add(sol);
                }
                System.out.println("Choisissez le sol constitutant la pièce"+"\n"+listeSol.toString()+"\n"+"Donnez l'index");
                int index=Lire.i();
                Sol solPiece=listeSol.getObject(index);
                if (listePlafond.size()==0){
                    System.out.println("Vous devez créer un plafond supplémentaire");
                    System.out.println("Entrer l'identifiant du plafond");
                    int idPlafond=Lire.i();
                    Numeroteur<Coin> petiteListe=new Numeroteur<Coin>();
                    while (petiteListe.size()!=4){
                        if(listeCoin.size()<4){
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
                            for (int i=0;i<4;i++){
                                System.out.println("Choisissez un coin constituant le plafond"+"\n"+listeCoin.toString()+"\n"+"Donnez l'indexe");
                                int indexe=Lire.i();
                                petiteListe.add(listeCoin.getObject(indexe));
                            }
                        }
                    }
                    System.out.println("Entrez le nombre de tremie présent sur le plafond");
                    int nbreTremie=Lire.i();
                    Plafond plafond=new Plafond(idPlafond,nbreTremie,petiteListe);
                    listePlafond.add(plafond);
                }
                System.out.println("Choisissez le plafond constitutant la pièce"+"\n"+listePlafond.toString()+"\n"+"Donnez l'index");
                int indx=Lire.i();
                Plafond plafondPiece=listePlafond.getObject(indx);
                System.out.println("Combien de murs possède la pièce ?");
                int nbreMur=Lire.i();
                Numeroteur<Mur> listeMurPiece=new Numeroteur<Mur>();
                while(listeMur.size()<nbreMur){
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
                }
                for(int k=0;k<nbreMur;k++){
                    System.out.println("Choisissez un mur constituant la pièce"+"\n"+listeMur.toString()+"\n"+"Donnez l'indexe");
                    int inx=Lire.i();
                    listeMurPiece.add(listeMur.getObject(inx));
                }
                Piece piece=new Piece(idPiece,solPiece,plafondPiece,listeMurPiece);
                listePiece.add(piece);
                }
            for (int k=0;k<nbrePiece;k++){
                System.out.println("Choisissez une pièce constituant l'appartement"+"\n"+listePiece.toString()+"\n"+"Donnez l'indexe");
                int idx=Lire.i();
                listePieceAppart.add(listePiece.getObject(idx));
            }
            Appartement appart=new Appartement(idAppart, idNiveau, listePieceAppart);
            listeAppartNiveau.add(appart);
                }
            Niveau niveau=new Niveau(idNiveau,hsp,listeAppartNiveau);
            listeNiveau.add(niveau);
            System.out.println("Voulez-vous continuer ?");
            reponseN=Lire.S();
            }
        }//Fin création niveau
        }
        }//fin de la méthode main
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
      
         
         
    }//fin de la classe
    