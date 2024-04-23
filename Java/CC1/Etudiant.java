package CC1;

public class Etudiant {
    String nom ;
    int age ;
    String filiere ;

    public Etudiant (String nom , int age , String filiere){
        this.nom = nom ;
        this.age = age ;
        this.filiere = filiere ;
    }
    public Etudiant(String nom , int age ){
        this.nom = nom ;
        this.age = age ;
        this.filiere = "Informatique" ;
    }
    public String toString(){
        
            System.out.println("Nom : " + this.nom);
            System.out.println("Age : " + this.age);
            System.out.println("Filiere : " + this.filiere);
            System.out.println("______________________________");
            return null;
        
    }
    
    public void vieillir (int plus){
        this.age= this.age + plus ;
    }

    public void devenirPaul (){
        this.nom = "Paul" ;
    }

}
