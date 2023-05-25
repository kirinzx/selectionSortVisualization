import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sort implements Runnable{
    public ArrayVisualization arrVis;
    private Timer timer;
    private final JButton stopVis;
    private JButton startVis;
    private JButton resetArray;
    private JButton randomArr;
    public AddElem addElem;
    public JSlider changeDelay;
    public int delay;
    public Sort(ArrayVisualization arrVis, JButton stopVis, JButton startVis, JButton resetArray, JButton randomArr){
        this.resetArray = resetArray;
        this.randomArr = randomArr;
        this.startVis = startVis;
        this.stopVis = stopVis;
        this.arrVis = arrVis;
    }
    @Override
    public void run(){
        selectionSort();
    }
    public void changeColor(int index, Color color, int prevIndex, int indexForChangeFlag){
        timer = new Timer(delay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                arrVis.arrColor.set(index, color);
                if (prevIndex != index && prevIndex != -1)
                    arrVis.arrColor.set(index - 1, arrVis.getBackground());
                arrVis.repaint();
            }
        });
        timer.setRepeats(false);
        timer.start();

        try {
            Thread.sleep(delay);
            if (indexForChangeFlag != -1 )
                arrVis.arrColor.set(indexForChangeFlag,arrVis.getBackground());

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void selectionSort() {
        for (int i = 0; i < arrVis.arrColor.size(); i++) {
            arrVis.arrColor.set(i, arrVis.getBackground());
        }
        if (delay != 0) {
            for (int i = 0; i < arrVis.arr.size(); i++) {
                if (i != arrVis.arr.size() - 1) {
                    int flag = i;
                    changeColor(flag, Color.RED, -1,-1);
                    for (int j = i + 1; j < arrVis.arr.size(); j++) {
                        if (j == i + 1) {
                            arrVis.arrColor.set(arrVis.arrColor.size() - 1, arrVis.getBackground());
                            changeColor(j, Color.YELLOW, flag + 1,-1);
                        }
                        else
                            changeColor(j, Color.YELLOW, flag + 1,-1);
                        if (arrVis.arr.get(j) < arrVis.arr.get(flag)) {
                            changeColor(j,Color.RED,-1,flag);
                            flag = j;
                        }
                    }
                    int helper = arrVis.arr.get(i);
                    arrVis.arr.set(i, arrVis.arr.get(flag));
                    arrVis.arr.set(flag, helper);
                    if (flag == i)
                        arrVis.arrColor.set(i, Color.GREEN);
                    else {
                        arrVis.arrColor.set(i, Color.GREEN);
                        arrVis.arrColor.set(flag, arrVis.getBackground());
                    }
                }
                else{
                    changeColor(i,Color.RED,-1,-1);
                    changeColor(i,Color.GREEN,-1,-1);
                }
            }
        }
        else {
            for (int i = 0; i < arrVis.arr.size(); i++) {
                int min = i;
                for (int j = i + 1; j < arrVis.arr.size(); j++) {
                    if (arrVis.arr.get(j) < arrVis.arr.get(min)) {
                        min = j;
                    }
                }
                int helper = arrVis.arr.get(i);
                arrVis.arr.set(i, arrVis.arr.get(min));
                arrVis.arr.set(min, helper);
            }
            for (int j = 0; j < arrVis.arrColor.size(); j++) {
                arrVis.arrColor.set(j, Color.GREEN);
            }
            arrVis.repaint();
        }
        stopVis.setEnabled(false);
        changeDelay.setEnabled(true);
        startVis.setEnabled(true);
        resetArray.setEnabled(true);
        randomArr.setEnabled(true);
        addElem.inputButton.setEnabled(true);
        addElem.editTextArea.setEnabled(true);
    }
}
