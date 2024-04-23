package TicTac ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


/**
 * TicTac
 */
public class TicTac {

        static ArrayList <Integer> pos = new ArrayList <Integer>();
        static ArrayList <Integer> cpupos = new ArrayList <Integer>();

    public static void main(String[] args) {

        //Suite Etape 7
        
        // 3 espace à droite et 3 espace en bas 
        // 2D 
        // char car c'est des sympoles 
        // {} 3 row et 3 colonnes 
        // à l'interieru de ces lignes on va avoir notre colonnes mais les colonnes aussi séparés avec des lignes c'est pour ça on a fait 5 {}
        //Etape 1 créé le forme de jeux
        char [] [] gameBoard = {{' ', '|' , ' ', '|',' '},
        {'-', '+' , '-', '+','-'},
        {' ', '|' , ' ', '|',' '},
        {'-', '+' , '-', '+','-'},
        {' ', '|' , ' ', '|',' '}} ;
        
        printGameBoard(gameBoard);
    
    //Etape 3 demander aux joueurs la position : on a besoin de place dans notre gameBoard pour mettre le chois du joueurs. On a 3 place dans chaque lignes on va leur donner de numeros de 0 à 9
    // System.in = dans le terminal
    
        //Etape 7 : while true c'est pour qu'on puisse jouer jusqu'a la fin
    while (true) {
        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("Choisissez votre emplacement (1-9) :");
            int pos = scan.nextInt();
            System.out.println(pos);
            swap(gameBoard, pos, "joueur");
        }
         //Etape 6 : ici on va donner le tour à l'ordi pour jouer et il faut pas qu'il joue on on a deja jouer 'on peut utiliser de l'intelligance et aller ver le librarie api et chercher une méthode '
        Random rand = new Random();
        int cpupos = rand.nextInt(9)+ 1 ;
        swap(gameBoard, cpupos , "cpu");

        printGameBoard(gameBoard);
    }
   
    
    }
    public static void printGameBoard(char[][] gameBoard) {
        //Etpae 2 print le : for pour chaque row inside(:) the gameBoard et for pour chaque c=sympoles inside(:) the row
        for(char [] row : gameBoard){
            for(char c : row ){
                System.out.print(c);
            }
            System.out.println();
        }
    }
    public static void swap(char [][] gameBoard , int pos , String user ) {
        
        //Etape 5 : on va dire si le user est un jouer le sypmole sera X sinon O
        char sympole = ' ';
        if(user.equals("joueur")){
            sympole= 'X';
        }else if (user.equals("cpu")){
            sympole ='O';
        }


        //Etape4 maintenant on va changer les espace dans le place vide entre (x et o )
    switch (pos) {
        case 1:
            gameBoard [0][0] = sympole ;
            break;
        case 2:
            gameBoard [0][2] = sympole;
            break;
        case 3:
            gameBoard [0][4] = sympole;
            break;
        case 4:
            gameBoard [2][0] = sympole;
            break;
        case 5:
            gameBoard [2][2] = sympole;
            break;
        case 6:
            gameBoard [2][4] = sympole;
            break;
        case 7:
            gameBoard [4][0] = sympole;
            break;
        case 8:
            gameBoard [4][2] = sympole;
            break;
        case 9:
            gameBoard [4][4] = sympole;
            break;
            default :
                break ;
        
        }
       
    }
    // Etape 7 checker s'il a un gagniant 
    public static String checkWinner() {
        java.awt.List topRow  = (java.awt.List)Arrays.asList(1,2,3);
        java.awt.List midRow  = (java.awt.List)Arrays.asList(4,5,6);
        java.awt.List botRow  =(java.awt.List) Arrays.asList(7,8,9);
        java.awt.List leftCol  = (java.awt.List)Arrays.asList(1,2,3);
        java.awt.List midCol  = (java.awt.List) Arrays.asList(2,5,8);
        java.awt.List rightCol  = (java.awt.List)Arrays.asList(3,6,9);
        java.awt.List cross1 = (java.awt.List)Arrays.asList(1,5,9);
        java.awt.List cross2  = (java.awt.List)Arrays.asList(7,5,3);
        
        List<java.awt.List> winning = new ArrayList<java.awt.List>();
        winning.add(topRow);
        winning.add(midRow);
        winning.add(botRow);
        winning.add(midCol);
        winning.add(leftCol);
        winning.add(rightCol);
        winning.add(cross1);
        winning.add(cross2);
        for(java.awt.List l : winning){
            if(pos.containsAll((Collection<?>) l)){
                return "Félicitation vous avez gagné";
            }else if (cpupos.containsAll((Collection<?>) l)){
                return "CPU a gagné ! Désolé ";
            }else if (pos.size()+cpupos.size() == 9) 
            return " C'est finit" ;
        }
       return "" ; 
    }
}
    
