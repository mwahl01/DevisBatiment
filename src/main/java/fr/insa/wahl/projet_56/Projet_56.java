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
        Numeroteur<Batiment> listeBatiment=new Numeroteur<Batiment>();
        
        System.out.println("Que souhaitez-vous faire ?"+"\n"+"Créer un objet? CREER"+"\n"+"Sauvegarder un bâtiment ? SAUVEGARDER"+"\n"+"Calculer un devis ? DEVIS"+"\n"+"Quitter ? QUITTER");
        String S=Lire.S();
        //Création d'objets
        while (!S.equals("QUITTER")){
        if (S.equals("CREER")){
        System.out.println("Que souhaitez-vous céer ?"+"\n"+"1-coin"+"\n"+"2-mur"+"\n"+"3-sol"+"\n"+"4-plafond"+"\n"+"5-pièce"+"\n"+"6-appartement"+"\n"+"7-niveau"+"\n"+"8-bâtiment"+"\n"+"Entrer le numéro correspondant");
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
                    reponseM="STOP";
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
                    Numeroteur<Revetement> listeRevetement=new Numeroteur<Revetement>();
                    Mur mur=new Mur(id,debut,fin,nbrePorte,nbreFenetre,listeRevetement);
                    listeMur.add(mur);
                    System.out.println("Voulez-vous continuer ?");
                    reponseM=Lire.S();
                }
            }
        }//Fin création mur
        
//Création d'un sol
        if (c==3){
            System.out.println("Entrer CREER pour créer un sol, entrer STOP pour arrêter");
            String reponseS=Lire.S();
            while (reponseS.equals("CREER")){
                Numeroteur<Coin> petiteListe=new Numeroteur<Coin>();
                if(listeCoin.size()<4){
                        System.out.println("Vous devez créer un coin supplémentaire");
                        reponseS="STOP";
                    }
                else{
                    System.out.println("Entrer l'identifiant du sol");
                    int idSol=Lire.i();
                    while (petiteListe.size()!=4){
                        for (int i=0;i<4;i++){
                            System.out.println("Choisissez un coin constituant le sol"+"\n"+listeCoin.toString()+"\n"+"Donnez l'indexe");
                            int index=Lire.i();
                            petiteListe.add(listeCoin.getObject(index));
                        }
                    }
                    System.out.println("Entrez le nombre de tremie présent sur le sol");
                    int nbreTremie=Lire.i();
                    Numeroteur<Revetement> listeRevetement=new Numeroteur<Revetement>();
                    Sol sol=new Sol(idSol,nbreTremie,petiteListe,listeRevetement);
                    listeSol.add(sol);
                    System.out.println("Voulez-vous continuer ?");
                    reponseS=Lire.S();   
                }  
            }
        }//Fin création sol
        
//Création d'un plafond
        if(c==4){
            System.out.println("Entrer CREER pour créer un plafond, entrer STOP pour arrêter");
            String reponseP=Lire.S();
            while (reponseP.equals("CREER")){
                Numeroteur<Coin> petiteListe=new Numeroteur<Coin>();
                if(listeCoin.size()<4){
                        System.out.println("Vous devez créer un coin supplémentaire");
                        reponseP="STOP";
                    }
                else{
                    System.out.println("Entrer l'identifiant du plafond");
                    int idPlafond=Lire.i();
                    while (petiteListe.size()!=4){  
                        for (int i=0;i<4;i++){
                            System.out.println("Choisissez un coin constituant le plafond"+"\n"+listeCoin.toString()+"\n"+"Donnez l'indexe");
                            int index=Lire.i();
                            petiteListe.add(listeCoin.getObject(index));
                        }
                    }
                    System.out.println("Entrez le nombre de tremie présent sur le plafond");
                    int nbreTremie=Lire.i();
                    Numeroteur<Revetement> listeRevetement=new Numeroteur<Revetement>();
                    Plafond plafond=new Plafond(idPlafond,nbreTremie,petiteListe,listeRevetement);
                    listePlafond.add(plafond);
                    System.out.println("Voulez-vous continuer ?");
                    reponseP=Lire.S();
                }
            }
        }//Fin création Plafond
        
//Création d'une pièce
        if (c==5){
            System.out.println("Entrer CREER pour créer une pièce, entrer STOP pour arrêter");
            String reponsePc=Lire.S();
            while (reponsePc.equals("CREER")){
                System.out.println("Combien de murs possède la pièce ?");
                int nbreMur=Lire.i();
                Numeroteur<Mur> listeMurPiece=new Numeroteur<Mur>();
                if ((listeSol.size()==0)||(listePlafond.size()==0)||(listeMur.size()<nbreMur)){
                    if (listeSol.size()==0){
                    System.out.println("Vous devez créer un sol supplémentaire");
                    }
                    else if (listePlafond.size()==0){
                    System.out.println("Vous devez créer un plafond supplémentaire");
                    }
                    else if (listeMur.size()<nbreMur){
                    System.out.println("Vous devez créer un mur supplémentaire");
                    } 
                reponsePc="STOP";    
                }
                else{
                    System.out.println("Entrer l'identifiant de la pièce");
                    int idPiece=Lire.i();
                    System.out.println("Choisissez le sol constitutant la pièce"+"\n"+listeSol.toString()+"\n"+"Donnez l'index");
                    int index=Lire.i();
                    Sol solPiece=listeSol.getObject(index);
                    System.out.println("Choisissez le plafond constitutant la pièce"+"\n"+listePlafond.toString()+"\n"+"Donnez l'index");
                    int indx=Lire.i();
                    Plafond plafondPiece=listePlafond.getObject(indx);
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
                
            }
        }//Fin création pièce
        
//Création d'un appartement
        if (c==6){
            System.out.println("Entrer CREER pour créer un appartement, entrer STOP pour arrêter");
            String reponseA=Lire.S();
            while (reponseA.equals("CREER")){
                System.out.println("Combien de pièces possède l'appartement ?");
                int nbrePiece=Lire.i();
                Numeroteur<Piece> listePieceAppart=new Numeroteur<Piece>();
                if (listePiece.size()<nbrePiece){
                    System.out.println("Vous devez créer une pièce supplémentaire");
                    reponseA="STOP";
                }
                else{
                    System.out.println("Entrer l'identifiant de l'appartement");
                    int idAppart=Lire.i();
                    System.out.println("Entrer le niveau auquel est situé l'appartement");
                    int idNiveauAppart=Lire.i();
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
            }
        }//Fin création appartement
        
//Création d'un niveau
        if (c==7){
            System.out.println("Entrer CREER pour créer un niveau, entrer STOP pour arrêter");
            String reponseN=Lire.S();
            while (reponseN.equals("CREER")){
                System.out.println("Entrer l'identifiant du niveau");
                int idNiveau=Lire.i();
                Numeroteur<Appartement> listeAppartNiveau=new Numeroteur<Appartement>();
                int n=0;
                for (int j=0;j<listeAppart.size();j++){
                    if (listeAppart.getObject(j).getNiveau()==idNiveau){
                        listeAppartNiveau.add(listeAppart.getObject(j));
                        n=n+1;
                    }
                }
                if ((listeAppartNiveau.size()==0)||(n==0)){
                    System.out.println("Vous devez créer un appartement supplémentaire pour ce niveau");
                    reponseN="STOP";
                }
                else{
                    System.out.println("Entrer l'hauteur sous plafond du niveau");
                    double hsp=Lire.d();
                    Niveau niveau=new Niveau(idNiveau,hsp,listeAppartNiveau);
                    listeNiveau.add(niveau);
                    System.out.println("Voulez-vous continuer ?");
                    reponseN=Lire.S();
                }
            }
        }//Fin création niveau
        
        //Création d'un bâtiment
        if (c==8){
            System.out.println("Entrer CREER pour créer un bâtiment, entrer STOP pour arrêter");
            String reponseB=Lire.S();
            while (reponseB.equals("CREER")){
                System.out.println("Quel type de bâtiment voulez-vous créer ? maison/immeuble");
                String reponse=Lire.S();
                //Création maison
                if(reponse.equals("maison")){
                    if (listeNiveau.size()==0){
                        System.out.println("Vous devez créer un niveau supplémentaire");
                        reponseB="STOP";
                    }
                    else{
                        System.out.println("Entrez l'identifiant/le nom de la maison");
                        String idMaison=Lire.S();
                        Numeroteur<Niveau> listeNiveauMaison=new Numeroteur<Niveau>();
                        System.out.println("Choisissez quel niveau constituera la maison"+"\n"+listeNiveau.toString()+"\n"+"Donnez l'indexe");
                        int idN=Lire.i();
                        listeNiveauMaison.add(listeNiveau.getObject(idN));
                        Maison maison=new Maison (idMaison,listeNiveauMaison);
                        listeBatiment.add(maison);
                        System.out.println("Voulez-vous continuer ?");
                        reponseB=Lire.S();
                    }
                }//Fin création maison
            
//Création d'un immeuble
                else if(reponse.equals("immeuble")){
                    System.out.println("Entrez le nombre de niveau de l'immeuble");
                    int nbreNiveau=Lire.i();
                    Numeroteur<Niveau> listeNiveauImmeuble=new Numeroteur<Niveau>();
                    if(listeNiveau.size()<nbreNiveau){
                        System.out.println("Vous devez créer un niveau supplémentaire");
                        reponseB="STOP";
                    }
                    else{
                        System.out.println("Entrez l'identifiant/le nom de l'immeuble");
                        String idImmeuble=Lire.S();
                        for (int k=0;k<nbreNiveau;k++){
                            System.out.println("Choisissez quel niveau constituera l'immeuble"+"\n"+listeNiveau.toString()+"\n"+"Donnez l'indexe");
                            int idN=Lire.i();
                            listeNiveauImmeuble.add(listeNiveau.getObject(idN));
                        }
                        Immeuble immeuble=new Immeuble(idImmeuble,nbreNiveau,listeNiveauImmeuble);
                        listeBatiment.add(immeuble);
                        System.out.println("Voulez-vous continuer ?");
                        reponseB=Lire.S();
                    }
                }//Fin création immeuble
                else{
                    System.out.println("Veuillez entrer un type de bâtiment valide");
                    reponseB="STOP";
                }
            }
        }//Fin création bâtiment
        }//Fin création d'objets
        
        //Sauvegarder un bâtiment
        if (S.equals("SAUVEGARDER")){
            if (listeBatiment.size()==0){
                System.out.println("Vous devez créer un nouveau bâtiment");
            }
            else{
                System.out.println("Quel bâtiment souhaitez-vous sauvegarder ?"+"\n"+listeBatiment.toString()+"\n"+"Donnez l'indexe");
                int indexe=Lire.i();
                listeBatiment.getObject(indexe).sauvegarde();
                System.out.println("Le bâtiment a été sauvegardé");
            }
        }
        
        
        if (S.equals("DEVIS")){
            System.out.println("De quoi voulez-vous faire le devis ?"+"\n"+"D'un mur ? MUR"+"\n"+"D'un sol ? SOL"+"\n"+"D'un plafond ? PLAFOND"+"\n"+"De la surface au sol d'une pièce ? SURFACESOL"+"\n"+"D'une pièce entière (mur+sol+plafond)? PIECE"+"\n"+"De la surface au sol d'un appartement ? SURFACEAPPART"+"\n"+"D'un appartement en entier ? APPART"+"\n"+"De la surface au sol d'un niveau ? SURFACENIVEAU"+"\n"+"D'un niveau en entier NIVEAU"+"\n"+"De la surface au sol d'un bâtiment ? SURFACEBAT"+"\n"+"D'un bâtiment en entier ? BATIMENT");
            String reponse=Lire.S();
            if (reponse.equals("Mur")){
                System.out.println("De quel mur ?"+"\n"+listeMur.toString()+"\n"+"Donnez l'indexe");
                int index=Lire.i();
                listeMur.getObject(index).montantRevetement();
            }
        }
        System.out.println("Que souhaitez-vous faire ?"+"\n"+"Créer un objet? CREER"+"\n"+"Sauvegarder un bâtiment ? SAUVEGARDER"+"\n"+"Calculer un devis ? DEVIS"+"\n"+"Quitter ? QUITTER");
        S=Lire.S();
        }
        }//fin de la méthode main

    }//fin de la classe
    