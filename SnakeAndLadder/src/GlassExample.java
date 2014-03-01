import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GlassExample extends JFrame {
    
  JPanel glass = new JPanel(new GridLayout(0, 1));
  // add a label to help trap focus while the glass pane is active
  JLabel padding = new JLabel();
  JProgressBar waiter = new JProgressBar(0, 100);
  Timer timer;

  public GlassExample() {
    super("GlassPane Demo");
    setSize(500, 300);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    // Set up the glass pane with a little message and a progress bar...
    JPanel controlPane = new JPanel(new GridLayout(2,1));
    controlPane.setOpaque(false);
    controlPane.add(new JLabel("Please wait..."));
    controlPane.add(waiter);
    glass.setOpaque(false);
    glass.add(padding);
    glass.add(new JLabel());
    glass.add(controlPane);
    glass.add(new JLabel());
    glass.add(new JLabel());

    // trap both mouse and key events.  Could provide a smarter key handler
    // if you wanted to allow things like a keystroke that would cancel the
    // long-running operation.
    glass.addMouseListener(new MouseAdapter() {});
    glass.addMouseMotionListener(new MouseMotionAdapter() {});
    glass.addKeyListener(new KeyAdapter() {});

    // make sure the focus won't leave the glass pane
    // glass.setFocusCycleRoot(true);  // 1.4
    padding.setNextFocusableComponent(padding);  // 1.3
    setGlassPane(glass);

    // Now set up a few buttons & images for the main application
    JPanel mainPane = new JPanel();
    mainPane.setBackground(Color.white);
    JButton redB = new JButton("Red");
    JButton blueB = new JButton("Blue");
    JButton greenB = new JButton("Green");
    mainPane.add(redB);
    mainPane.add(greenB);
    mainPane.add(blueB);
    mainPane.add(new JLabel(new ImageIcon("oreilly.gif")));

    // Attach the popup debugger to the main app buttons so you
    // see the effect of making a glass pane visible
    PopupDebugger pd = new PopupDebugger(this);
    redB.addActionListener(pd);
    greenB.addActionListener(pd);
    blueB.addActionListener(pd);

    // And last but not least, our button to launch the glass pane
    JButton startB = new JButton("Start the big operation!");
    startB.addActionListener(new ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent A) {
          glass.setVisible(true);
	  padding.requestFocus();  // required to trap key events
          startTimer();
        }
      });

    Container contentPane = getContentPane();
    contentPane.add(mainPane, BorderLayout.CENTER);
    contentPane.add(startB, BorderLayout.SOUTH);
  }

  // A quick method to start up a 10 second timer and update the
  // progress bar
  public void startTimer() {
    if (timer == null) {
      timer = new Timer(1000, new ActionListener() {
          int progress = 0;
          public void actionPerformed(ActionEvent A) {
            progress += 10;
            waiter.setValue(progress);

            // Once we hit 100%, remove the glass pane and reset the
            // progress bar stuff
            if (progress >= 100) {
              progress = 0;
              timer.stop();
              glass.setVisible(false);
              waiter.setValue(0);
            }
          }
        });
    }
    if (timer.isRunning()) {
      timer.stop();
    }
    timer.start();
  }

  // A graphical debugger that pops up anytime a button is pressed
  public class PopupDebugger implements ActionListener {
    private JFrame parent;
    public PopupDebugger(JFrame f) {
      parent = f;
    }
    public void actionPerformed(ActionEvent ae) {
      JOptionPane.showMessageDialog(parent, ae.getActionCommand());
    }
  }

  public static void main(String[] args) {
    GlassExample ge = new GlassExample();
    ge.setVisible(true);
  }
}