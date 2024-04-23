package TM6;

public class Exo2 {
    public static void main(String[] args) {
        // String s =JOptionPane.showInputDialog("donnez une phrase ?");
        // String new_s = s.replace('e' , 'a');
        // System.out.println(s.replace('e' , 'a'));
        // System.out.println(remplaceLettre(s));
        // s = remplaceLettre(s);
        // remplaceLettre(s, 't');
        // System.out.println(remplaceLettre(s,'a'));
        String s = "Blanche-Neige et les sept nains";
        String [] mots = decomposePhrase(s);
        for (int i = 0; i < mots.length; i++) {
            System.out.println(mots[i]);
            
        }
        mots = remplaceMot(s,"nains", "maison");
            for (int j = 0; j < mots.length; j++) {
                System.out.println(mots[j]+ " ");
            }
            
        
    }


    //     public static String remplaceLettre(String s) {
    //    String new_s = s.replace('a' , 'e');
    //         return new_s;
    //     }

        public static void remplaceLettre(String s, char a) {
            char e = 'e' ;
            String new_s = s.replace( a , e );
            System.out.println(new_s);
        }


        //avec la fonction prédéfinie split
   public static String [] decomposePhrase(String s) {

    String[] mots = s.split(" ");;
    
    //split divise la chaine en un ensemble de mots
    //s'il y a un espace et les mis dans un tableau
    return mots;
 }

 static String [] remplaceMot( String s , String mot1 , String mot2){
     String [] mots = decomposePhrase(s);
     for (int i = 0; i < mots.length; i++) {
         if (mots[i].equals(mot1) ){
             mots[i]=mot2;
         }
     }
     return mots ;
 }

}