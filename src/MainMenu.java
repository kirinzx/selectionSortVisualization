import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MainMenu extends JFrame {
    private final CardLayout cardLayout;

    private final JPanel mainPanel;

    public MainMenu() {
        this.cardLayout = new CardLayout();
        this.mainPanel = createMainPanel();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(mainPanel, BorderLayout.CENTER);

        pack();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setMinimumSize(this.getMinimumSize());
        setLocationByPlatform(true);
        setTitle("Сортировка выбором");
        setVisible(true);
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
                "<html><span>Алгоритм сортировки. Может быть как устойчивый, так и неустойчивый. На массиве из n элементов имеет время выполнения в худшем, среднем и лучшем случае O(n^2), предполагая что сравнения делаются за постоянное время.</span></html>");
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