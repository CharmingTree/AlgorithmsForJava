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
    private Image background = new ImageIcon(dyMain.class.getResource("../../images/intro_background.jpg")).getImage();
    private Image selectedImage = new ImageIcon(dyMain.class.getResource("../../images/start_img_evening_sky.png")).getImage();

    private Image titleImage = new ImageIcon(dyMain.class.getResource("../../images/evening_sky_title_img.png")).getImage();

    private JLabel menuBar = new JLabel(new ImageIcon(dyMain.class.getResource("../../images/menuBar.png")));


    private ImageIcon exitButtonEnteredImage = new ImageIcon(dyMain.class.getResource("../../images/exit_entered.png"));
    private ImageIcon exitButtonUnEnteredImage = new ImageIcon(dyMain.class.getResource("../../images/exit_unEntered.png"));

    private ImageIcon startButtonUnEnteredImage = new ImageIcon(dyMain.class.getResource("../../images/start_unEntered_btn_img.png"));
    private ImageIcon startButtonEnteredImage = new ImageIcon(dyMain.class.getResource("../../images/start_Entered_btn_img.png"));

    private ImageIcon stopButtonUnEnteredImage = new ImageIcon(dyMain.class.getResource("../../images/stop_unEntered_btn_img.png"));
    private ImageIcon stopButtonEnteredImage = new ImageIcon(dyMain.class.getResource("../../images/stop_Entered_btn_img.png"));

    private ImageIcon leftButtonUnEnteredImage = new ImageIcon(dyMain.class.getResource("../../images/left_unEntered_img.png"));
    private ImageIcon leftButtonEnteredImage = new ImageIcon(dyMain.class.getResource("../../images/left_Entered_img.png"));

    private ImageIcon rightButtonUnEnteredImage = new ImageIcon(dyMain.class.getResource("../../images/right_unEntered_img.png"));
    private ImageIcon rightButtonEnteredImage = new ImageIcon(dyMain.class.getResource("../../images/right_Entered_img.png"));



    private JButton exitButton = new JButton(exitButtonUnEnteredImage);
    private JButton startButton = new JButton(startButtonUnEnteredImage);
    private JButton stopButton = new JButton(stopButtonUnEnteredImage);
    private JButton leftButton = new JButton(leftButtonUnEnteredImage);
    private JButton rightButton = new JButton(rightButtonUnEnteredImage);

    private int mouseX, mouseY;

    private boolean isMainScreen = false;

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
                g.drawImage(background, 0, 0, this);
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

        startButton.setBounds(40,200,400,100);
        startButton.setBorderPainted(false);
        startButton.setContentAreaFilled(false);
        startButton.setFocusPainted(false);
        startButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                startButton.setIcon(startButtonEnteredImage);
                startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music buttonEnteredMusic = new Music("mouse_hover.mp3", false);
                buttonEnteredMusic.start();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                startButton.setIcon(startButtonUnEnteredImage);
                startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                startButton.setVisible(false);
                stopButton.setVisible(false);
                leftButton.setVisible(true);
                rightButton.setVisible(true);
                background = new ImageIcon(dyMain.class.getResource("../../images/main_background.jpg")).getImage();
                isMainScreen = true;
            }
        });
        panel.add(startButton);


        stopButton.setBounds(40,330,400,100);
        stopButton.setBorderPainted(false);
        stopButton.setContentAreaFilled(false);
        stopButton.setFocusPainted(false);
        stopButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                stopButton.setIcon(stopButtonEnteredImage);
                stopButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music buttonEnteredMusic = new Music("mouse_hover.mp3", false);
                buttonEnteredMusic.start();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                stopButton.setIcon(stopButtonUnEnteredImage);
                stopButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                System.exit(0);
            }
        });
        panel.add(stopButton);


        leftButton.setBounds(500,550,60,60);
        leftButton.setVisible(false);
        leftButton.setBorderPainted(false);
        leftButton.setContentAreaFilled(false);
        leftButton.setFocusPainted(false);
        leftButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                leftButton.setIcon(leftButtonEnteredImage);
                leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music buttonEnteredMusic = new Music("mouse_hover.mp3", false);
                buttonEnteredMusic.start();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                leftButton.setIcon(leftButtonUnEnteredImage);
                leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                //
            }
        });
        panel.add(leftButton);

        rightButton.setBounds(700,550,60,60);
        rightButton.setVisible(false);
        rightButton.setBorderPainted(false);
        rightButton.setContentAreaFilled(false);
        rightButton.setFocusPainted(false);
        rightButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                rightButton.setIcon(rightButtonEnteredImage);
                rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music buttonEnteredMusic = new Music("mouse_hover.mp3", false);
                buttonEnteredMusic.start();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                rightButton.setIcon(rightButtonUnEnteredImage);
                rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                //
            }
        });
        panel.add(rightButton);

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
        g.drawImage(background, 0, 0, null);
        super.paintComponents(g);

        if (isMainScreen) {
            // logger.info("into");
            g.drawImage(selectedImage, 340, 100, null);
            g.drawImage(titleImage, 360, 120, null);
        }
        this.repaint();


    }
}
