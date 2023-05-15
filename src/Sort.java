import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class Sort{
    public ArrayVisualization arrVis;
    private Timer timer;
    public Sort(ArrayVisualization arrVis){
        this.arrVis = arrVis;
    }

    public void selectionSort() {
        for (int i = 0; i < arrVis.arr.size(); i++) {
            int min = i;
            int finalMin = min;
            timer = new Timer(2000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println(finalMin);
                    arrVis.arrColor.set(finalMin,Color.YELLOW);
                    arrVis.repaint();
                }
            });
            timer.setRepeats(false);
 //           timer.setDelay(200);
            timer.start();
            System.out.println("delay" + finalMin);
            delay(2000);
            System.out.println("delay2" + finalMin);
            for (int j = i + 1; j < arrVis.arr.size(); j++) {

                if (arrVis.arr.get(j) < arrVis.arr.get(min)) {
                    min = j;
                }
            }
            int helper = arrVis.arr.get(i);
            arrVis.arr.set(i,arrVis.arr.get(min));
            arrVis.arr.set(min,helper);
        }
    }
    public static void delay(long time) {// takes time in milliseconds
        long nanoseconds = time * (long) Math.pow(10, 6);
        long timepassed;
        long startTime = System.nanoTime();
        do {
            timepassed = System.nanoTime() - startTime;
        } while (timepassed < nanoseconds);
    }
}
