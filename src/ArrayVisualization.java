import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ArrayVisualization extends JPanel {

    private static final long serialVersionUID = 1L;

    public ArrayList<Integer> arr;
    public ArrayList<Color> arrColor;
    private int x = 150;
    private int y = 80;
    public ArrayList<Integer> elemCoords;

    public ArrayVisualization() {
        elemCoords = new ArrayList<>();
        arrColor = new ArrayList<>();
        this.arr = new ArrayList<>();
        setLayout(new BorderLayout());
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        elemCoords.clear();
        x = 150;
        g.setColor(Color.BLACK);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        int widthOfDef = g.getFontMetrics().stringWidth("array = ");
        g.drawString("array = ", x - widthOfDef - 10, y);
        for (int i = 0;i<arr.size();i++){
            int element = arr.get(i);
            ArrayElem arrElem = new ArrayElem(x,arrColor.get(i),element);
            elemCoords.add(arrElem.paintComponent(g));

            int width = g.getFontMetrics().stringWidth(Integer.toString(element));
            x += width + 20;
        }
    }

}
