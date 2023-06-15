package snakegame;

import java.awt.*;
import java.util.LinkedList;

public class Cell {
    private int x, y;
    private int size;
    private Color color;

    public Cell(int x, int y, int size, Color color) {
        setXY(x, y);
        setSize(size);
        setColor(color);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSize() {
        return size;
    }

    public Color getColor() {
        return color;
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void paint(Graphics2D g) {             // object rendering
        g.setColor(color);
        g.fillOval(x * size, y * size,      // upper left corner
                    size, size);                  // width and height
    }
}
