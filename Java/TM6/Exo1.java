package TM6;

import javax.swing.JOptionPane;
public class Exo1 {
    public static void main(String[] args) {
        // System.out.println("Hello world");
        String s =JOptionPane.showInputDialog("Quel est votre nom ?");
        //System.out.println("Bonjour " + s);
        int x;
        x=Integer.valueOf(JOptionPane.showInputDialog("Donne-moi votre age?"));
        if (x<18) {
            System.out.println("Bonjour Junior " + s  );
        } else if ( x < 64){
            System.out.println("Bonjour M " + s  );
        }else{
            System.out.println("Bonjour senior " + s );
        }
        
    }
}