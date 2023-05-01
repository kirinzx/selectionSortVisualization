import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Sort {
    public ArrayVisualization arrVis;
    public ArrayList<Integer> arr;
    public ArrayList<Integer> elemCoords;
    private Timer timer;
    public Sort(ArrayVisualization arrVis){
        this.arr = arrVis.arr;
        this.arrVis = arrVis;
        this.elemCoords = arrVis.elemCoords;
    }

    public void selectionSort() {
        for (int i = 0; i < arr.size(); i++) {
            int min = i;
            ArrayElem arrElem = new ArrayElem(elemCoords.get(min),new Color(255,0,0),arr.get(min));
            for (int j = i + 1; j < arr.size(); j++) {
                ArrayElem arrElem2 = new ArrayElem(elemCoords.get(j),new Color(0,100,0),arr.get(j));
                if (arr.get(j) < arr.get(min)) {
                    ArrayElem arrElem3 = new ArrayElem(elemCoords.get(j),new Color(0,255,100),arr.get(j));
                    min = j;
                }
            }
            int helper = arr.get(i);
            arr.set(i,arr.get(min));
            arr.set(min,helper);
            ArrayElem arrElem4 = new ArrayElem(elemCoords.get(min),new Color(0,0,255),arr.get(min));
        }
    }
}
