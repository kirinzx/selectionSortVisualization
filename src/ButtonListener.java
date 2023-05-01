import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {

    private final MainMenu view;

    public ButtonListener(MainMenu view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        view.showArrayVisualization();
    }

}
