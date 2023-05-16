import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Sort implements Runnable{
    public ArrayVisualization arrVis;
    public boolean isSkip;
    private Timer timer;
    public Sort(ArrayVisualization arrVis){
        this.arrVis = arrVis;
        isSkip = false;
    }
    public void run(){
        selectionSort();
    }
    public void changeColor(int index,Color color, int flagIndex){
        if (isSkip == false) {
            timer = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    arrVis.arrColor.set(index, color);
                    if (flagIndex != index && flagIndex != -1)
                        arrVis.arrColor.set(index - 1, arrVis.getBackground());
                    arrVis.repaint();
                }
            });
            timer.setRepeats(false);
            timer.start();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
    public void selectionSort() {
        for(int i = 0; i<arrVis.arrColor.size(); i++){
            arrVis.arrColor.set(i,arrVis.getBackground());
        }
        for (int i = 0; i < arrVis.arr.size(); i++) {
            int min = i;
            changeColor(min,Color.RED,-1);
            for (int j = i + 1; j < arrVis.arr.size(); j++) {
                if (j == i + 1) {
                    arrVis.arrColor.set(arrVis.arrColor.size()-1,arrVis.getBackground());
                    changeColor(j, Color.YELLOW, i + 1);
                }
                else
                    changeColor(j, Color.YELLOW,i + 1);
                if (arrVis.arr.get(j) < arrVis.arr.get(min)) {
                    min = j;
                }
            }
            int helper = arrVis.arr.get(i);
            arrVis.arr.set(i,arrVis.arr.get(min));
            arrVis.arr.set(min,helper);
            if (min == i)
                arrVis.arrColor.set(min, Color.GREEN);
            else {
                arrVis.arrColor.set(i, Color.GREEN);
                arrVis.arrColor.set(min, arrVis.getBackground());
            }
        }

        arrVis.arrColor.set(arrVis.arr.size()-1, Color.GREEN);

        if (isSkip == true)
            for(int i = 0; i<arrVis.arrColor.size(); i++){
                arrVis.arrColor.set(i,Color.GREEN);
            }

        arrVis.repaint();
        isSkip = false;
    }
}
