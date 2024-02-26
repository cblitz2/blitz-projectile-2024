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
    private ProjectileGraph graph;

    public ProjectileFrame()
    {
        setSize(400, 600);
        setTitle("Projectile Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel main = new JPanel();
        main.setLayout(new BorderLayout());
        // tells the JFrame to use this JPanel
        setContentPane(main);

        JPanel west = new JPanel();
        main.add(west, BorderLayout.WEST);

        west.setLayout(new GridLayout(8, 2));

        angleField = new JSlider(0, 90);
        add(angleField);
        JLabel angleLabel = new JLabel("Angle");
        west.add(angleLabel);
        west.add(angleField);

        velocityField = new JTextField();
        JLabel velocityLabel = new JLabel("Velocity");
        west.add(velocityLabel);
        west.add(velocityField);

        JLabel secondsLabel = new JLabel("Seconds");
        west.add(secondsLabel);
        secondsField = new JTextField();
        west.add(secondsField);

        JLabel labelX = new JLabel("X");
        west.add(labelX);
        labX = new JLabel();
        west.add(labX);

        JLabel labelY = new JLabel("Y");
        west.add(labelY);
        labY = new JLabel();
        west.add(labY);

        JLabel peakLabelY = new JLabel("Peak Y");
        west.add(peakLabelY);
        peakY = new JLabel();
        west.add(peakY);

        JLabel interceptLabelX = new JLabel("Intercept X");
        west.add(interceptLabelX);
        interceptX = new JLabel();
        west.add(interceptX);

        west.add(new JLabel());
        JButton calculateButton = new JButton("Calculate");
        west.add(calculateButton);

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

        graph = new ProjectileGraph();
        main.add(graph, BorderLayout.CENTER);

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
        graph.setProjectile(projectile);

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