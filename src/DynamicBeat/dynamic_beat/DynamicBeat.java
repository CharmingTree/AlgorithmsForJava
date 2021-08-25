package DynamicBeat.dynamic_beat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.ImageIcon;

public class DynamicBeat extends JFrame {


    private Logger logger;

    private Image screenImage;
    private Graphics screenGraphic;

    //private Image introBackground;
    private Image introBackground = new ImageIcon(dyMain.class.getResource("../../images/intro_background.jpg")).getImage();
    private JLabel menuBar = new JLabel(new ImageIcon(dyMain.class.getResource("../../images/menuBar.png")));


    private ImageIcon exitButtonEnteredImage = new ImageIcon(dyMain.class.getResource("../../images/exit_entered.png"));
    private ImageIcon exitButtonUnEnteredImage = new ImageIcon(dyMain.class.getResource("../../images/exit_unEntered.png"));

    private JButton exitButton = new JButton(exitButtonUnEnteredImage);

    private int mouseX, mouseY;

    public DynamicBeat() {

        logger = LoggerFactory.getLogger(this.getClass());
        setUndecorated(true);
        setTitle("Dynamic Beat");
        setSize(dyMain.SCREEN_WIDTH, dyMain.SCREEN_HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setBackground(new Color(0,0,0,0));
        //setIconImage(introBackground);
        setLayout(null);

        JPanel panel = new JPanel(){
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(introBackground, 0, 0, this);
            }
        };

        panel.setLayout(null);

        menuBar.setBounds(0,0, 1280,30);
        menuBar.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
            }
        });
        menuBar.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int x = e.getXOnScreen();
                int y = e.getYOnScreen();
                setLocation(x - mouseX, y - mouseY);
            }
        });
        panel.add(menuBar);
        //add(menuBar);

        exitButton.setBounds(1200,50,50,50);
        exitButton.setBorderPainted(false);
        exitButton.setContentAreaFilled(false);
        exitButton.setFocusPainted(false);
        exitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                exitButton.setIcon(exitButtonEnteredImage);
                exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music buttonEnteredMusic = new Music("mouse_hover.mp3", false);
                buttonEnteredMusic.start();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                exitButton.setIcon(exitButtonUnEnteredImage);
                exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                System.exit(0);
            }
        });

        panel.add(exitButton);
        //add(exitButton);

        setContentPane(panel);



        //introBackground = new ImageIcon(dyMain.class.getResource("../../images/intro_background.jpg")).getImage();

        Music introMusic = new Music("spell.mp3", true);
        introMusic.start();
    }

    public void paint(Graphics g) {
        screenImage = createImage(dyMain.SCREEN_WIDTH, dyMain.SCREEN_HEIGHT);
        screenGraphic = screenImage.getGraphics();
        screenDraw(screenGraphic);
        g.drawImage(screenImage, 0, 0, null);
        //logger.info("paint");
    }

    public void screenDraw(Graphics g) {
        //logger.info("repaint");
        g.drawImage(introBackground, 0, 0, null);
        super.paintComponents(g);
        this.repaint();


    }
}
