package Tm7;

public class MyTableau {
    int [] tab ;
    int size ;
    public MyTableau(int taille){
        tab = new int [taille] ;
        size = 0 ;
    }
    public void add ( int val) {
        if(this.size>this.tab.length){
            int [] temp= new int [size*2];
            for (int i = 0; i < size; i++) {
                temp[i] = tab[i];
                tab = temp ;
            }
        }
        this.tab[size] = val ;
        this.size++ ;
    }

    public void delete (int pos ){
        for ( int i = pos ; i<size ; i++ ){
            tab[i] = tab[i+1];
        }
        size-- ;
    }

    public int get ( int pos ){
        return this.tab[pos];
    }

    public String toString() {
        String s = "";
        s= s + "[";
        for(int i =0 ; i < this.size -1 ; i++){
            s = s + this.tab[i] + ","; 
        } 
        if (size > 0){
            s = s + this.tab[size - 1];
            s=s + "]";
            
        }
         return s ;
      }   
   
    public static void main(String[] args) {
     MyTableau mt = new MyTableau (25);
     mt.add(2);
     mt.add(4);
     mt.add(24);
     int x = mt.get(2);
     System.out.println(x);
     System.out.println(mt.toString());
}
}
