package graficas;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Primitiva {

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }

    public Tipo getTipo() {
        return tipo;
    }
    
    public int getAncho(){
        return Math.abs(x1 - x2);
    }
    
    public int getAlto(){
        return Math.abs(y1 - y2);
    }

    private int x1, y1, x2, y2;
    private Tipo tipo;

    public Primitiva(int x1, int y1, int x2, int y2, Tipo tipo) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.tipo = tipo;
    }

    public void dibujar(JPanel pnl) {
        Graphics g = pnl.getGraphics();
        g.setColor(Color.blue);
        switch (tipo) {
            case LINEA:
                g.drawLine(x1, y1, x2, y2);
                break;
            case RECTANGULO:
                g.drawRect(x1, y1, getAncho(), getAlto());
                break;
            case CIRCULO:
                g.drawOval(x1, y1, getAncho(), getAlto());
                break;
        }
       
    }

    public boolean contiene(int x, int y) {
        return ((x1 <= x && x <= x2 && x1 <= x2) || (x1 >= x && x >= x2 && x1 > x2))
                && ((y1 <= y && y <= y2 && y1 <= y2) || (y1 >= y && y >= y2 && y1 > y2));

    }

}
