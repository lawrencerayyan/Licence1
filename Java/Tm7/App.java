package Tm7;

public class App {
    public static void main(String[] args) {
        System.out.println(Tm7.methode1("to"));
        Tm7 t = new Tm7();
        int s = t.Somme();
        System.out.println(s);
        System.out.println(t.toString());

        StringBuilder sb = new StringBuilder("Hello");
        sb.append(" World");
        System.out.println(sb);
    }
}
