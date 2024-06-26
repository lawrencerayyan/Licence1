package CC;

import javax.swing.JOptionPane;

public class puissance {
    int taille;
    int[][] arene;
    int[][] tab_cache;

    public puissance() {
        this.taille = Integer.valueOf(JOptionPane.showInputDialog("choisissez la taille de la arene ?")) + 1;
        while (this.taille < 5) {
            this.taille = Integer
                    .valueOf(JOptionPane.showInputDialog("Merci de choisir une taille plus grande que 3 ?")) + 1;
        }

        arene = new int[taille][taille];
        tab_cache = new int[taille][taille];
    }

    public void tour() {
        int temp = 1;
        while (!gagnant()) {
            affichage(arene);

            if (temp % 2 != 0)
                joueur(arene, tab_cache, 1);
            else
                joueur(arene, tab_cache, 2);
            temp++;
            System.out.print("\033[H\033[2J");
        }
        affichage(arene);
        termine(temp);
    }

    public static void affichage(int arene[][]) {
        for (int i = 0; i < arene.length; i++) {
            for (int j = 0; j < arene.length; j++) {
                if (i == 0 && j == 0)
                    System.out.print("  ");
                else if (i == 0 && j < 10)
                    System.out.print(j + "  ");
                else if (i == 0 && j > 9)
                    System.out.print(j + " ");
                else if (j == 0 && i > 0) {

                    if (i < 10)
                        System.out.print(i + "  ");
                    else if (i > 9)
                        System.out.print(i + " ");
                } else if (j < 11)
                    System.out.print(arene[i][j] + "  ");
                else if (j > 9)
                    System.out.print(arene[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public void joueur(int arene[][], int tab_cache[][], int j) {
        int x;
        int y;
        if (j == 1) {
            x = Integer.valueOf(JOptionPane.showInputDialog("j" + j + ": cordonnee X"));
            y = Integer.valueOf(JOptionPane.showInputDialog("j" + j + ": cordonnee Y"));
            while (!vide(tab_cache, x, y)) {

                x = Integer.valueOf(
                        JOptionPane.showInputDialog("j" + j
                                + ": Cette cellule est deja utilise. veuillez recommencer avec autre Cordonnee X"));
                y = Integer.valueOf(
                        JOptionPane.showInputDialog("j" + j + ": Autre Cordonnee y"));
            }
        } else {
            x = Random(1, taille);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            y = Random(1, this.taille);
            while (!vide(tab_cache, x, y)) {
                x = Random(1, this.taille);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                y = Random(1, this.taille);
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

    public boolean gagnant() {
        for (int i = 1; i < tab_cache.length; i++) {
            for (int j = 1; j < tab_cache.length; j++) {
                if (tab_cache[tab_cache.length - 1][j] == 4 || tab_cache[i][tab_cache.length - 1] == 5)
                    return true;
            }
        }
        return false;
    }

    public static void termine(int temp) {
        if (temp % 2 == 0)
            System.out.print("jouer 1 a gagné");
        else
            System.out.print("jouer 2 a gagné");
    }

    public static boolean vide(int tab_cache[][], int x, int y) {
        if (x < tab_cache.length
                && x > 0
                && y < tab_cache.length
                && y > 0
                && tab_cache[x][y] == 0) {
            return true;
        } else
            return false;
    }

    public static int valeur(int tab_cache[][], int x, int y, int j) {
        if (x == 1 && j == 1)
            tab_cache[x][y] = 4;
        else if (y == 1 && j == 2)
            tab_cache[x][y] = 5;
        else
            tab_cache[x][y] = j;
        return 0;
    }

  
    static boolean test4_5(int tab_cache[][], int t) {
        for (int i = 1; i < tab_cache.length; i++) {
            for (int j = 1; j < tab_cache.length; j++) {
                if (tab_cache[1][j] == 4 || tab_cache[i][1] == 5)
                    return true;
            }
        }
        return false;
    }

    static boolean balayage(int[][] tab_cache, int joueur) {
        int temp;
        if (joueur == 1)
            temp = 4;
        else
            temp = 5;
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

    public int Random(int min, int max) {
        return (int) (Math.random() * max - min) + min;
    }

}
