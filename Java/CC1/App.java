package CC1;

public class App {
    public static void main(String[] args) {
        Etudiant [] tab = new Etudiant[3];
        tab[0]=new Etudiant("Sebastian", 20 , "Licence informatique");
        tab[1]= new Etudiant("Farah" , 25 , "Eco");
        tab[2]= new Etudiant ("Sarah" , 23 , "Science");
        tab[1].vieillir(5);
        tab[1].devenirPaul();
        tab[0].toString();
        tab[1].toString();
        tab[2].toString();
    }
}
