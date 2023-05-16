import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Visualization extends JPanel{
    private static final long serialVersionUID = 1L;
    public final ArrayVisualization arrVis;
    public Sort sort;
    private final JButton resetArray;
    private final JButton startVis;
    private final JButton randomArr;
    private final JButton skipVis;
    private final JPanel buttonPanel;
    private final AddElem addElem;

    public Visualization() {
        arrVis = new ArrayVisualization();
        resetArray = new JButton("Отчистить массив");
        startVis = new JButton("Начать сортировку");
        randomArr = new JButton("Сгенерировать массив");
        skipVis = new JButton("Пропустить визуалицию");
        buttonPanel = new JPanel();
        addElem = new AddElem(arrVis);

        buttonPanel.setLayout(new GridBagLayout());

        skipVis.setEnabled(false);

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
            }
        });
        randomArr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                arrVis.arr.clear();
                arrVis.arrColor.clear();
                generateRandomArray();
                arrVis.repaint();
            }
        });
        startVis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sort = new Sort(arrVis);
                (new Thread(sort)).start();
                skipVis.setEnabled(true);
                skipVis.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        sort.isSkip = true;
                    }
                });

            }
        });

        buttonPanel.add(addElem, gbc);
        buttonPanel.add(startVis, gbc);
        buttonPanel.add(randomArr, gbc);
        buttonPanel.add(resetArray, gbc);
        buttonPanel.add(skipVis,gbc);

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
