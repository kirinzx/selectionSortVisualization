import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Visualization extends JPanel{
    private static final long serialVersionUID = 1L;
    public final ArrayVisualization arrVis;
    public Sort sort;
    private ChangeDelayPanel changeDelayPanel;
    private final JButton resetArray;
    private final JButton startVis;
    private final JButton randomArr;
    private final JButton stopVis;
    private final JPanel buttonPanel;
    private final AddElem addElem;

    public Visualization() {
        arrVis = new ArrayVisualization();
        resetArray = new JButton("Очистить массив");
        startVis = new JButton("Начать сортировку");
        randomArr = new JButton("Сгенерировать массив");
        stopVis = new JButton("Остановить визуалицию");
        buttonPanel = new JPanel();

        sort = new Sort(arrVis,stopVis,startVis,resetArray,randomArr);
        changeDelayPanel = new ChangeDelayPanel(sort);
        sort.changeDelay = changeDelayPanel.changeDelay;
        addElem = new AddElem(arrVis,startVis,changeDelayPanel.changeDelay,resetArray);
        sort.addElem = addElem;
        addElem.sort = sort;


        buttonPanel.setLayout(new GridBagLayout());

        resetArray.setEnabled(false);
        changeDelayPanel.changeDelay.setEnabled(false);
        stopVis.setEnabled(false);
        startVis.setEnabled(false);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 10, 5, 25);
        gbc.fill = gbc.HORIZONTAL;
        gbc.weightx = 1;

        resetArray.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                arrVis.arr.clear();
                arrVis.arrColor.clear();
                arrVis.repaint();
                startVis.setEnabled(false);
                changeDelayPanel.changeDelay.setEnabled(false);
                randomArr.setEnabled(true);
                resetArray.setEnabled(false);
            }
        });
        randomArr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                arrVis.arr.clear();
                arrVis.arrColor.clear();
                generateRandomArray();
                arrVis.repaint();
                startVis.setEnabled(true);
                changeDelayPanel.changeDelay.setEnabled(true);
                resetArray.setEnabled(true);
            }
        });
        startVis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Thread thread = new Thread(sort);
                startVis.setEnabled(false);
                stopVis.setEnabled(true);
                resetArray.setEnabled(false);
                randomArr.setEnabled(false);
                addElem.editTextArea.setEnabled(false);
                addElem.inputButton.setEnabled(false);
                changeDelayPanel.changeDelay.setEnabled(false);
                thread.start();
                stopVis.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        thread.stop();
                        changeDelayPanel.changeDelay.setEnabled(true);
                        startVis.setEnabled(true);
                        stopVis.setEnabled(false);
                        resetArray.setEnabled(true);
                        randomArr.setEnabled(true);
                        addElem.editTextArea.setEnabled(true);
                        addElem.inputButton.setEnabled(true);
                    }
                });

            }
        });

        buttonPanel.add(addElem, gbc);
        buttonPanel.add(randomArr, gbc);
        buttonPanel.add(resetArray, gbc);
        buttonPanel.add(startVis, gbc);
        buttonPanel.add(stopVis,gbc);
        buttonPanel.add(changeDelayPanel,gbc);

        setLayout(new BorderLayout());

        add(arrVis);
        add(buttonPanel,BorderLayout.SOUTH);
    }
    public void generateRandomArray(){
        Random random = new Random();
        while (arrVis.arr.size() <= 10){
            arrVis.arr.add(random.nextInt(100)-50);
            arrVis.arrColor.add(arrVis.getBackground());
        }
    }
}
