package class_Carte;

public class Position {
    protected int x;
    protected int y;
    

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }


    //getters et setters
    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

}