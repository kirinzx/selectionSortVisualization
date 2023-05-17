import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ArrayVisualization extends JPanel {

    private static final long serialVersionUID = 1L;

    public ArrayList<Integer> arr;
    public ArrayList<Color> arrColor;
    private int x = 450;
    private final int y = 400;

    public ArrayVisualization() {
        arrColor = new ArrayList<>();
        arr = new ArrayList<>();
        setLayout(new BorderLayout());
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = this.x;
        g.setColor(Color.BLACK);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        int widthOfDef = g.getFontMetrics().stringWidth("array = ");
        g.drawString("array = ", x - widthOfDef - 10, y);
        for (int i = 0;i<arr.size();i++){
            int element = arr.get(i);
            Color color = arrColor.get(i);
            int width = g.getFontMetrics().stringWidth(Integer.toString(element));
            paintElement(g,element,color, x);
            x += width + 20;
        }
    }
    public void paintElement(Graphics g,int element, Color color, int x){
        g.setColor(color);
        int width = g.getFontMetrics().stringWidth(Integer.toString(element));
        g.fillRect(x-10,y-40,width+20,60);
        g.setColor(Color.BLACK);
        g.drawRect(x-10,y-40,width+20,60);
        g.drawString(Integer.toString(element),x,y);
    }

}
