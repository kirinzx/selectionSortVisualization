import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MainMenu implements Runnable {
    private final CardLayout cardLayout;

    private final JPanel mainPanel;

    public MainMenu() {
        this.cardLayout = new CardLayout();
        this.mainPanel = createMainPanel();
    }

    @Override
    public void run() {
        JFrame frame = new JFrame("Сортировка выбором");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(mainPanel, BorderLayout.CENTER);

        frame.pack();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setMinimumSize(frame.getMinimumSize());
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    private JPanel createMainPanel() {
        JPanel panel = new JPanel(cardLayout);

        panel.add(createMenuPanel(), "menu");
        panel.add(new Visualization(), "visualization");

        return panel;
    }

    private JPanel createMenuPanel() {
        JPanel mainPanel = new JPanel(new GridLayout(0, 1, 5, 10));
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JLabel label = new JLabel("Сортировка выбором");
        label.setFont(label.getFont().deriveFont(36.0f));
        mainPanel.add(label);

        JLabel description = new JLabel(
                "<html><span>Описание какое-то сортировки</span></html>");
        description.setFont(label.getFont().deriveFont(20.0f));
        mainPanel.add(description);

        JButton visualizeButton = new JButton("Посмотреть визуализацию");
        visualizeButton.addActionListener(new ButtonListener(this));
        mainPanel.add(visualizeButton);

        return mainPanel;
    }

    public void showArrayVisualization() {
        cardLayout.show(mainPanel, "visualization");
    }
}