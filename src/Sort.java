import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Sort {
    public ArrayVisualization arrVis;
    public ArrayList<Integer> elemCoords;
    private Timer timer;
    public Sort(ArrayVisualization arrVis){
        this.arrVis = arrVis;
        this.elemCoords = arrVis.elemCoords;
    }

    public void selectionSort() {
        for (int i = 0; i < arrVis.arr.size(); i++) {
            int min = i;
            int finalMin = min;
//            Thread thread = new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    arrVis.arrColor.set(finalMin,Color.GREEN);
//                    arrVis.repaint();
//                    try {
//                        Thread.sleep(10000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            });
//            thread.start();
            arrVis.arrColor.set(finalMin,Color.GREEN);
            arrVis.repaint();
            delay(3000);
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
    public static void delay(long time) {
        long nanoseconds = time * (long) Math.pow(10, 6);
        long timepassed;
        long startTime = System.nanoTime();
        do {
            timepassed = System.nanoTime() - startTime;
        } while (timepassed < nanoseconds);
    }
}
