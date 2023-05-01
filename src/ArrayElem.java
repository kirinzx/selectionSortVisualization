import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ArrayElem {
    public int x;
    public Color color;
    public final int y = 80;
    public int element;
    public ArrayElem(int x, Color color, int element){
        this.x = x;
        this.color = color;
        this.element = element;
    }
    public int paintComponent(Graphics g){
        g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        int width = g.getFontMetrics().stringWidth(Integer.toString(element));
        g.setColor(color);
        g.fillRect(x-10,y-40,width+20,60);
        g.setColor(Color.BLACK);
        g.drawRect(x-10,y-40,width+20,60);
        g.drawString(Integer.toString(element),x,y);
        return x;
    }
}
