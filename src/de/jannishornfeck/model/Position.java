package de.jannishornfeck.model;

public class Position {

    private int x;
    private int y;

    public Position() {
        x = 0;
        y = 0;
    }

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position(Position position) {
        x = position.getX();
        y = position.getY();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Position position)) {
            return false;
        }

        if (object == this) {
            return true;
        }

        return this.getX() == position.getX() && this.getY() == position.getY();
    }

}
