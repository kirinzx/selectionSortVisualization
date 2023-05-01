import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class Visualization extends JPanel{
    private static final long serialVersionUID = 1L;
    public ArrayVisualization arrVis;
    public Sort sort;
    private JButton resetArray;
    private JButton startVis;
    private JButton randomArr;
    private JPanel buttonPanel;
    private AddElem addElem;
    private int x = 150;
    private int y = 80;

    public Visualization() {
        arrVis = new ArrayVisualization();
        resetArray = new JButton("Отчистить массив");
        startVis = new JButton("Начать сортировку");
        randomArr = new JButton("Сгенерировать массив");
        buttonPanel = new JPanel();
        addElem = new AddElem(arrVis);

        buttonPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 10, 5, 25);
        gbc.fill = gbc.HORIZONTAL;
        gbc.weightx = 1;

        resetArray.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                arrVis.arr.clear();
                arrVis.repaint();
            }
        });
        randomArr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                arrVis.arr = generateRandomArray();
                arrVis.repaint();
            }
        });
        startVis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sort = new Sort(arrVis);
                sort.selectionSort();
                arrVis.arr = sort.arr;
                arrVis.repaint();
            }
        });

        buttonPanel.add(addElem, gbc);
        buttonPanel.add(startVis, gbc);
        buttonPanel.add(randomArr, gbc);
        buttonPanel.add(resetArray, gbc);

        setLayout(new BorderLayout());

        add(arrVis);
        add(buttonPanel,BorderLayout.SOUTH);
    }
    public ArrayList generateRandomArray(){
        ArrayList arr = new ArrayList();
        Random random = new Random();
        while (arr.size() <= 10){
            arr.add(random.nextInt(100)-50);
        }
        return arr;
    }
}
