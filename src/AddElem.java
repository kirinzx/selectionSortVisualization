import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.JOptionPane.showMessageDialog;

public class AddElem extends JPanel {
    private String element;
    private final JButton startVis;
    private JSlider changeDelay;
    private JButton resetArray;
    public Sort sort;
    public final JButton inputButton = new JButton("Добавить элемент в массив");
    public final JTextField editTextArea = new JTextField();
    public ArrayVisualization arrVis;

    public AddElem(ArrayVisualization arrVis,JButton startVis, JSlider changeDelay,JButton resetArray) {
        this.startVis = startVis;
        this.resetArray = resetArray;
        this.changeDelay = changeDelay;
        this.arrVis = arrVis;
        ActionListener action = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                element = editTextArea.getText();

                editTextArea.setText("");
                if (arrVis.arr.size() <= 10) {
                    try {
                        int intElement = Integer.parseInt(element);
                        if (intElement > 400){
                            arrVis.arr.add(400);
                        }
                        else if (intElement < -100){
                            arrVis.arr.add(-100);
                        }
                        else {
                            arrVis.arr.add(intElement);
                        }
                        arrVis.arrColor.add(arrVis.getBackground());
                        startVis.setEnabled(true);
                        changeDelay.setEnabled(true);
                        resetArray.setEnabled(true);
                        arrVis.arrColor.replaceAll(ignored -> arrVis.getBackground());
                        arrVis.repaint();
                    } catch (NumberFormatException ex) {
                        showMessageDialog(null, "Некорректные данные");
                    }
                } else
                    showMessageDialog(null, "Максимальный размер массива 10. Лимит превыщен");
            }
        };
        setLayout(new GridLayout(1, 2));

        Border border = BorderFactory.createLineBorder(Color.BLACK);
        editTextArea.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(1, 1, 1, 1)));

        add(editTextArea, BorderLayout.SOUTH);
        add(inputButton, BorderLayout.WEST);

        inputButton.addActionListener(action);
        editTextArea.addActionListener(action);
        setVisible(true);
    }
}
