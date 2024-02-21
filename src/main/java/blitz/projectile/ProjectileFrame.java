package blitz.projectile;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProjectileFrame extends JFrame
{
    private JTextField velocityField;
    private JTextField secondsField;
    private JSlider angleField;
    private JLabel labX;
    private JLabel labY;
    private JLabel peakY;
    private JLabel interceptX;

    public ProjectileFrame()
    {
        setSize(400, 600);
        setTitle("Projectile Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new GridLayout(8, 2));

        angleField = new JSlider(0, 90);
        add(angleField);
        JLabel angleLabel = new JLabel("Angle");
        add(angleLabel);
        add(angleField);

        velocityField = new JTextField();
        JLabel velocityLabel = new JLabel("Velocity");
        add(velocityLabel);
        add(velocityField);

        JLabel secondsLabel = new JLabel("Seconds");
        add(secondsLabel);
        secondsField = new JTextField();
        add(secondsField);

        JLabel labelX = new JLabel("X");
        add(labelX);
        labX = new JLabel();
        add(labX);

        JLabel labelY = new JLabel("Y");
        add(labelY);
        labY = new JLabel();
        add(labY);

        JLabel peakLabelY = new JLabel("Peak Y");
        add(peakLabelY);
        peakY = new JLabel();
        add(peakY);

        JLabel interceptLabelX = new JLabel("Intercept X");
        add(interceptLabelX);
        interceptX = new JLabel();
        add(interceptX);

        add(new JLabel());
        JButton calculateButton = new JButton("Calculate");
        add(calculateButton);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculate();
            }
        });

        velocityField.getDocument().addDocumentListener(new SimpleDocumentListener()
        {
            @Override
            public void update(DocumentEvent e) {
                calculate();
            }
        });

        secondsField.getDocument().addDocumentListener(new SimpleDocumentListener()
        {
            @Override
            public void update(DocumentEvent e) {
                calculate();
            }
        });

        angleField.addChangeListener(e ->
                calculate());
    }

    private void calculate() {
        Projectile projectile = new Projectile(angleField.getValue(),
                Double.parseDouble(velocityField.getText())
        );

        projectile.setTime(Double.parseDouble(secondsField.getText()));
        labX.setText(Double.toString(projectile.getX()));
        labY.setText(Double.toString(projectile.getY()));
        peakY.setText(Double.toString(projectile.getPeakY()));
        interceptX.setText(Double.toString(projectile.getInterceptX()));
    }


    public interface SimpleDocumentListener extends DocumentListener {
        void update(DocumentEvent e);

        @Override
        default void insertUpdate(DocumentEvent e) {
            update(e);
        }

        @Override
        default void removeUpdate(DocumentEvent e) {
            update(e);
        }

        @Override
        default void changedUpdate(DocumentEvent e) {
            update(e);
        }
    }
}