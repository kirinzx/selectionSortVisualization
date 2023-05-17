import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.Hashtable;

public class ChangeDelayPanel extends JPanel{
    public JSlider changeDelay;
    public Sort sort;
    private JLabel changeDelayLabel;
    public ChangeDelayPanel(Sort sort){
        this.sort = sort;
        changeDelay = new JSlider(JSlider.HORIZONTAL,6,1);
        changeDelayLabel = new JLabel("Время паузы между итерациями в сек.", JLabel.CENTER);

        Hashtable<Integer,JLabel> labelTable = new Hashtable<>();
        labelTable.put( 0, new JLabel("0.0"));
        labelTable.put( 1, new JLabel("0.5"));
        labelTable.put( 2, new JLabel("1.0"));
        labelTable.put( 3, new JLabel("1.5"));
        labelTable.put( 4, new JLabel("2.0"));
        labelTable.put( 5, new JLabel("2.5"));
        labelTable.put( 6, new JLabel("3.0"));

        changeDelay.setLabelTable(labelTable);
        changeDelay.setPaintTicks(true);
        changeDelay.setPaintLabels(true);

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        changeDelay.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider)e.getSource();
                if (!source.getValueIsAdjusting()){
                    int value = changeDelay.getValue();
                    double sliderValue = value / 2.0;
                    sort.delay = (int)(sliderValue * 1000);
                }
            }
        });

        add(changeDelayLabel);
        add(changeDelay);
    }
}
