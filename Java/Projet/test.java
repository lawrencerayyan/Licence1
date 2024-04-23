import java.util.Scanner;

public class test {
 final int taille = laTaille();
int arene[][] = new int[taille][taille];
int tab_cache[][] = new int[taille][taille];
    
public static void main(String [] args) {
    //  int taille = laTaille();
    test a = new test();
    a.tour() ;
    
}
/// choisir la taille de l'arene
public int laTaille() {
    Scanner clavier = new Scanner (System.in);   
    int taille ;
    System.out.print("choisissez la taille de la arene");
    taille = clavier.nextInt()+ 1;
    while (taille <= 2){
        System.out.println("Merci de choisir une taille plus grande que 1");
     taille = clavier.nextInt() + 1;}
    return taille;
}
//////////////////////////////// Parti des joueurs//////////////////////////////////
///// chenger le tour entre les deux joueurs
public void tour() {
    // on commence avec 1 pour commencer avec le permier jouer
    int temp = 1;

    /// boucle infini tant que le fonction gagnant est false
    while (!gagnant(tab_cache)) {
        affichage(arene);
        if (temp == 3) swap(arene, tab_cache);
        if (temp % 2 != 0) joueur(arene, tab_cache, 1);
        else joueur(arene, tab_cache, 2);
        temp++;
        // pour effacer la console j'ai trouvé la commande ici : https://www.delftstack.com/howto/java/java-clear-console/
        System.out.print("\033[H\033[2J");
    }
    affichage(arene);
    termine(temp);
}
///////////////// swap//////////////////
////// on fait un échange entre les cellule après de finir le premiere tour,si le joueur 2 veut
public static void swap(int arene[][], int tab_cache[][]) {
    Scanner clavier = new Scanner (System.in);
    int temp ;
    System.out.println("J2: vous voulez échanger le cellule avec J1? (oui/1,non/2)");
    temp = clavier.nextInt ();
    if (temp == 1) chSwap(arene, tab_cache);
}

public static void chSwap(int arene[][], int tab_cache[][]) {
    for (int i = 1; i < tab_cache.length; i++) {
        for (int j = 1; j < tab_cache.length; j++) {
            if (arene[i][j] == 1) {
                arene[i][j] = 2;
                tab_cache[i][j] = 2;
                valeur(tab_cache, i, j, 2);
            } else if (arene[i][j] == 2) {
                arene[i][j] = 1;
                tab_cache[i][j] = 1;
                valeur(tab_cache, i, j, 1);
            }
        }
    }
    System.out.print("\033[H\033[2J");
    affichage(arene[][]);
}

public void joueur(int arene[][], int tab_cache[][], int j) {
    Scanner clavier = new Scanner (System.in);
    //////////////// un human contre l'ordinateur////////////////
    int x;
    int y;
    if (j == 1) {
        System.out.println("j" + j + ": cordonnee X");
        x = clavier.nextInt();
        System.out.println("j" + j + ": cordonnee Y");
        y = clavier.nextInt();
        // on envoie les cordonees au fonction vide pour tester si la cellule est disponible
        // si la cellule n'est pas disponible, on re-demande a l'utilisateur
        while (!vide(tab_cache, x, y)) {
            System.out.println("j" + j + ": Cette cellule est deja utilise. autre Cordonnee X");
            x = clavier.nextInt();
            System.out.println("j" + j + ": cordonnee Y");
            y = clavier.nextInt();
        }
    } else {
        x = random(1,taille);
        // try {
        //     Thread.sleep(200);
        // } catch (InterruptedException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }
        y = random(1, taille);
        while (!vide(tab_cache, x, y)) {
            x = random(1, taille);
            // try {
            //     Thread.sleep(200);
            // } catch (InterruptedException e) {
            //     // TODO Auto-generated catch block
            //     e.printStackTrace();
            // }
            y = random(1, taille);
        }
    }
    arene[x][y] = j;
    valeur(tab_cache, x, y, j);
    if (test4_5(tab_cache, j)) {
        if (balayage(tab_cache, j)) {
            balayage(tab_cache, j);
        }
    }
}
public int random(int min, int max){
    return (int) (Math.random()*max-min+1)+min;
}
//// test si le cellule est disponible
public static boolean vide(int tab_cache[][], int x, int y) {
    if (x < tab_cache.length
            && x > 0
            && y < tab_cache.length
            && y > 0
            && tab_cache[x][y] == 0) {
        return true;
    } else return false;
}
///// préciser la valeur de chaque cellule de l'arene cache
//// jouer 1 =4
//// jouer 2 =5
public static int valeur(int tab_cache[][], int x, int y, int j) {
    if (x == 1 && j == 1) tab_cache[x][y] = 4;
    else if (y == 1 && j == 2) tab_cache[x][y] = 5;
    else tab_cache[x][y] = j;
    return 0;
}

///////////////////////////// Parti de balayage//////////////////////////////////
public static boolean test4_5(int tab_cache[][], int t) {
    for (int i = 1; i < tab_cache.length; i++) {
        for (int j = 1; j < tab_cache.length; j++) {
            if (tab_cache[1][j] == 4 || tab_cache[i][1] == 5) return true;
        }
    }
    return false;
}

public static  boolean balayage(int[][] tab_cache, int joueur) {
    int temp;
    if (joueur == 1) temp = 4;
    else temp = 5;
    for (int i = 0; i < tab_cache.length; i++) {
        for (int j = 0; j < tab_cache[i].length; j++) {
            if (tab_cache[i][j] == joueur
                    && ((j < tab_cache[i].length - 1 && tab_cache[i][j + 1] == temp)
                            || (i > 0 && tab_cache[i - 1][j] == temp)
                            || (i > 0
                                    && j < tab_cache[i].length - 1
                                    && tab_cache[i - 1][j + 1] == temp)
                            || (j > 0 && tab_cache[i][j - 1] == temp)
                            || (j > 0
                                    && i < tab_cache[i].length - 1
                                    && tab_cache[i + 1][j - 1] == temp)
                            || (i < tab_cache[i].length - 1 && tab_cache[i + 1][j] == temp))) {
                tab_cache[i][j] = temp;
                return true;
            }
        }
    }
    return false;
}
///////////////////////////////// Parti test si il y a un gagnant///////////////////////////////

public static boolean gagnant(int tab_cache[][]) {
    for (int i = 1; i < tab_cache.length; i++) {
        for (int j = 1; j < tab_cache.length; j++) {
            if (tab_cache[tab_cache.length - 1][j] == 4
                    || tab_cache[i][tab_cache.length - 1] == 5) return true;
        }
    }
    return false;
}
/////////////////////////////////// Parti d'affichage/////////////////////////////////////
////// affichage arene 1_2
public  void affichage(int arene[][]) {
    for (int i = 0; i < arene.length; i++) {
        for (int j = 0; j < arene.length; j++) {
            if (i == 0 && j == 0) System.out.print("  ");
            else if (i == 0 && j < 10) System.out.print(j + "  ");
            else if (i == 0 && j > 9) System.out.print(j + " ");
            else if (j == 0 && i > 0) {
                bordGouche(i);
                if (i < 10) System.out.print(i + "  ");
                else if (i > 9) System.out.print(i + " ");
            } else if (j < 11) System.out.print(arene[i][j] + "  ");
            else if (j > 9) System.out.print(arene[i][j] + " ");
        }
        System.out.println();
    }
}

public static void bordGouche(int temp) {
    for (int i = 0; i < temp - 1; i++) {
        System.out.print(" ");
    }
}
////// il afiche le gagnant
public static void termine(int temp) {
    if (temp % 2 == 0) System.out.print("jouer 1 a gagné");
    else System.out.print("jouer 2 a gagné");
}
}