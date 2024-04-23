package Tm7;

public class Tm7 {
    int x=1 , y=2 ;
    String z ="soe" ;

    
    public static String methode1(String g) {
        return g+g ;
        
    }
    public int Somme() {
        if (z.equals("somme"))return this.x+this.y ;
        else return 0 ;
    }
    public Tm7() {
    
    }
    public Tm7 (int x , int y , String z) {
        this.x = x ;
        this.y = y ; 
        this.z = z ;
    }
    public Tm7 (int x , int y ) {
        this.x = x ;
        this.y = y ; 
        this.z = "somme";
    }
    public Tm7 (int x ) {
        this.x = x ;
        this.y = x ; 
        this.z = "toto" ;
    }

    public String toString() {
        return "Les valeur intialises sont : " + this.x + ',' +this.y + ","+this.z ;
    }
    
}
