public class Hexagone {
    int x , y , size ;

    public Hexagone ( int x , int y , int size){
        this.x= x ;
        this.y = y ;
        this.size = size ;
    }
    public void draw() {
        Line l1= new Line (this.x+15-this.size*Math.sqrt(2)/2,
        this.y-this.size*Math.sqrt(2)/2,
        this.x+this.size*Math.sqrt(2)/2,
        this.y-this.size*Math.sqrt(2)/2
        );
        l1.draw();
        Line l2= new Line (this.x+this.size*Math.sqrt(2)/2,
        this.y-this.size*Math.sqrt(2)/2,
        this.x+this.size,
        this.y);
        l2.draw();
        Line l3= new Line (this.x+55-this.size*Math.sqrt(2)/2,
        this.y+this.size*Math.sqrt(2)/2,
        this.x+this.size,
        this.y);
        l3.draw();

        Line l4 = new Line (this.x+55-this.size*Math.sqrt(2)/2,
        this.y+this.size*Math.sqrt(2)/2,
        this.x-42+this.size*Math.sqrt(2)/2,
        this.y+56-this.size*Math.sqrt(2)/2);
        l4.draw();

        Line l5 = new Line (this.x-42+this.size*Math.sqrt(2)/2,
        this.y+56-this.size*Math.sqrt(2)/2,
        this.x+3-this.size*Math.sqrt(2)/2,
        this.y);
        l5.draw();

        Line l6 = new Line (this.x+3-this.size*Math.sqrt(2)/2,
        this.y,
        this.x+15-this.size*Math.sqrt(2)/2,
        this.y-this.size*Math.sqrt(2)/2);
        l6.draw();
    }
}
