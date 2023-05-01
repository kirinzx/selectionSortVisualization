import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.JOptionPane.showMessageDialog;

public class AddElem extends JPanel {
    private String element;
    public final JButton inputButton = new JButton("Добавить элемент в массив");
    public final JTextArea editTextArea = new JTextArea(1, 6);
    public final JTextArea uneditTextArea = new JTextArea();
    public ArrayVisualization arrVis;

    public AddElem(ArrayVisualization arrVis) {
        this.arrVis = arrVis;
        setLayout(new GridLayout(1, 2));

        uneditTextArea.setEditable(false);

        Border border = BorderFactory.createLineBorder(Color.BLACK);
        editTextArea.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(1, 1, 1, 1)));

        add(uneditTextArea, BorderLayout.CENTER);
        add(editTextArea, BorderLayout.SOUTH);
        add(inputButton, BorderLayout.WEST);

        inputButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                element = editTextArea.getText();

                editTextArea.setText("");
                if (arrVis.arr.size() <= 10) {
                    try {
                        arrVis.arr.add(Integer.parseInt(element));
                        arrVis.repaint();
                    }
                    catch (NumberFormatException ex){
                        showMessageDialog(null, "Некорректные данные");
                    }
                }
            }
        });
        setVisible(true);
    }
}
