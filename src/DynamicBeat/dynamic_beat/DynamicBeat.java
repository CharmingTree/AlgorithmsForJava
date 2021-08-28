package DynamicBeat.dynamic_beat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class DynamicBeat extends JFrame {


    private Logger logger;

    private Image screenImage;
    private Graphics screenGraphic;
    private Image background = new ImageIcon(dyMain.class.getResource("../../images/intro_background.jpg")).getImage();
    private Image gameInfoImg = new ImageIcon(dyMain.class.getResource("../../images/gameInfo.png")).getImage();
    private Image judgementLineImg = new ImageIcon(dyMain.class.getResource("../../images/judgementLine.png")).getImage();
    private Image noteRouteImg = new ImageIcon(dyMain.class.getResource("../../images/noteRoute.png")).getImage();
    private Image noteRouteLineImg = new ImageIcon(dyMain.class.getResource("../../images/noteRouteLine.png")).getImage();
    private Image beatNoteImg = new ImageIcon(dyMain.class.getResource("../../images/beatNote.png")).getImage();

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

    private ImageIcon easyButtonUnEnteredImage = new ImageIcon(dyMain.class.getResource("../../images/easyMode_unEntered.png"));
    private ImageIcon easyButtonEnteredImage = new ImageIcon(dyMain.class.getResource("../../images/easyMode_entered.png"));

    private ImageIcon hardButtonUnEnteredImage = new ImageIcon(dyMain.class.getResource("../../images/hardMode_unEntered.png"));
    private ImageIcon hardButtonEnteredImage = new ImageIcon(dyMain.class.getResource("../../images/hardMode_entered.png"));

    private ImageIcon backButtonUnEnteredImage = new ImageIcon(dyMain.class.getResource("../../images/backBtn_unEntered_img.png"));
    private ImageIcon backButtonEnteredImage = new ImageIcon(dyMain.class.getResource("../../images/backBtn_entered_img.png"));

    private JButton exitButton = new JButton(exitButtonUnEnteredImage);
    private JButton startButton = new JButton(startButtonUnEnteredImage);
    private JButton stopButton = new JButton(stopButtonUnEnteredImage);
    private JButton leftButton = new JButton(leftButtonUnEnteredImage);
    private JButton rightButton = new JButton(rightButtonUnEnteredImage);

    private JButton easyModeButton = new JButton(easyButtonUnEnteredImage);
    private JButton hardModeButton = new JButton(hardButtonUnEnteredImage);

    private JButton backButton = new JButton(backButtonUnEnteredImage);

    private int mouseX, mouseY;

    private boolean isMainScreen = false;
    private boolean isGameScreen = false;

    private java.util.List<Track> trackList = new ArrayList<>();

    private Image selectedImage;
    private Image titleImage;
    private Music selectedMusic;
    private Music introMusic = new Music("spell.mp3", true);
    private int nowSelected = 0;

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
        setLayout(null);


        introMusic.start();

        trackList.add(
                new Track("Alile - Evening Sky",
                        "evening_sky_title_img.png",
                            "start_img_evening_sky.png",
                            "game_img_evening_sky.jpg",
                            "evening_sky_highlight.mp3",
                                    "evening_sky.mp3")
        );

        trackList.add(
                new Track("Luna - It was Love",
                        "it_was_love_title_img.png",
                        "start_img_it_was_love.jpg",
                        "game_img_it_was_love.jpg",
                        "it_was_love_highlight.mp3",
                        "it_was_love.mp3")
        );



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
                enterMain();
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


        leftButton.setBounds( 200,280,60,60);
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
                selectLeft();
            }
        });
        panel.add(leftButton);

        rightButton.setBounds(1000,280,60,60);
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
                selectRight();
            }
        });
        panel.add(rightButton);

        easyModeButton.setVisible(false);
        easyModeButton.setBounds(375, 580, 250, 67);
        easyModeButton.setBorderPainted(false);
        easyModeButton.setContentAreaFilled(false);
        easyModeButton.setFocusPainted(false);
        easyModeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                easyModeButton.setIcon(easyButtonEnteredImage);
                easyModeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music buttonEnteredMusic = new Music("mouse_hover.mp3", false);
                buttonEnteredMusic.start();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                easyModeButton.setIcon(easyButtonUnEnteredImage);
                easyModeButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                //super.mousePressed(e);
                gameStart(nowSelected, "easy");
            }
        });
        panel.add(easyModeButton);


        hardModeButton.setVisible(false);
        hardModeButton.setBounds(655, 580, 250, 67);
        hardModeButton.setBorderPainted(false);
        hardModeButton.setContentAreaFilled(false);
        hardModeButton.setFocusPainted(false);
        hardModeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                hardModeButton.setIcon(hardButtonEnteredImage);
                hardModeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music buttonEnteredMusic = new Music("mouse_hover.mp3", false);
                buttonEnteredMusic.start();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hardModeButton.setIcon(hardButtonUnEnteredImage);
                hardModeButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                //super.mousePressed(e);
                gameStart(nowSelected, "hard");
            }
        });
        panel.add(hardModeButton);

        setContentPane(panel);


        backButton.setVisible(false);
        backButton.setBounds(20, 50, 60, 60);
        backButton.setBorderPainted(false);
        backButton.setContentAreaFilled(false);
        backButton.setFocusPainted(false);
        backButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                backButton.setIcon(backButtonEnteredImage);
                backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music buttonEnteredMusic = new Music("mouse_hover.mp3", false);
                buttonEnteredMusic.start();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                backButton.setIcon(backButtonUnEnteredImage);
                backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                backMain();
            }
        });
        panel.add(backButton);

        setContentPane(panel);


        //introBackground = new ImageIcon(dyMain.class.getResource("../../images/intro_background.jpg")).getImage();


    }

    public void paint(Graphics g) {
        screenImage = createImage(dyMain.SCREEN_WIDTH, dyMain.SCREEN_HEIGHT);
        screenGraphic = screenImage.getGraphics();
        screenDraw((Graphics2D)screenGraphic);
        g.drawImage(screenImage, 0, 0, null);
        //logger.info("paint");
    }

    public void screenDraw(Graphics2D g) {
        //logger.info("repaint");
        g.drawImage(background, 0, 0, null);
        super.paintComponents(g);

        if (isMainScreen) {
            // logger.info("into");
            g.drawImage(selectedImage, 340, 100, null);
            g.drawImage(titleImage, 360, 120, null);
        }

        if (isGameScreen) {
            //g.drawImage(noteRouteImg, 240, 50, null);

            g.drawImage(noteRouteImg,228,30, 100, 763, null);
            g.drawImage(noteRouteImg,332,30, 100, 763, null);
            g.drawImage(noteRouteImg,436,30, 100, 763, null);
            g.drawImage(noteRouteImg,540,30, 100, 763, null);
            g.drawImage(noteRouteImg,640,30, 100, 763, null);
            g.drawImage(noteRouteImg,744,30, 100, 763, null);
            g.drawImage(noteRouteImg,848,30, 100, 763, null);
            g.drawImage(noteRouteImg,952,30, 100, 763, null);

            g.drawImage(noteRouteLineImg, 224, 30, null);
            g.drawImage(noteRouteLineImg, 328, 30, null);
            g.drawImage(noteRouteLineImg, 432, 30, null);
            g.drawImage(noteRouteLineImg, 536, 30, null);
            g.drawImage(noteRouteLineImg, 740, 30, null);
            g.drawImage(noteRouteLineImg, 844, 30, null);
            g.drawImage(noteRouteLineImg, 948, 30, null);
            g.drawImage(noteRouteLineImg, 1052, 30, null);

            g.drawImage(beatNoteImg, 228, 120, null);
            g.drawImage(beatNoteImg, 332, 580, null);
            g.drawImage(beatNoteImg, 436, 500, null);
            g.drawImage(beatNoteImg, 540, 340, null);
            g.drawImage(beatNoteImg, 640, 340, null);
            g.drawImage(beatNoteImg, 744, 325, null);
            g.drawImage(beatNoteImg, 848, 305, null);
            g.drawImage(beatNoteImg, 952, 305, null);

            g.drawImage(gameInfoImg, 0, 793, null);
            g.drawImage(judgementLineImg, 0, 713, null);

            g.setColor(Color.white);
            g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            g.setFont(new Font("Arial", Font.BOLD, 30));
            g.drawString(trackList.get(nowSelected).getMusicTitleName(), 20, 832);
            g.drawString("Easy", 1190, 832);
            g.setFont(new Font("Araial", Font.PLAIN, 26));
            g.setColor(Color.darkGray);
            g.drawString("S", 270, 745);
            g.drawString("D", 374, 745);
            g.drawString("F", 478, 745);
            g.drawString("Space Bar", 580, 745);
            g.drawString("J", 784, 745);
            g.drawString("K", 889, 745);
            g.drawString("L", 993, 745);
            g.setColor(Color.lightGray);
            g.setFont(new Font("Elephant", Font.BOLD, 30));
            g.drawString("000000", 565, 832);

        }

        this.repaint();


    }

    public void selectTrack(int nowSelected) {
        if (selectedMusic != null)
            selectedMusic.close();

        titleImage = new ImageIcon(dyMain.class.getResource("../../images/" + trackList.get(nowSelected).getTitleImage())).getImage();
        selectedImage = new ImageIcon(dyMain.class.getResource("../../images/" + trackList.get(nowSelected).getStartImage())).getImage();
        selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(), true);
        selectedMusic.start();

    }

    public void selectLeft() {
        if (nowSelected == 0)
            nowSelected = trackList.size()-1;
        else
            nowSelected--;

        selectTrack(nowSelected);
    }

    public void selectRight() {
        if (nowSelected == trackList.size()-1)
            nowSelected = 0;
        else
            nowSelected++;

        selectTrack(nowSelected);
    }

    public void gameStart(int nowSelected, String difficulty) {
        if (selectedMusic != null) {
            selectedMusic.close();
        }
        isMainScreen = false;
        leftButton.setVisible(false);
        rightButton.setVisible(false);
        easyModeButton.setVisible(false);
        hardModeButton.setVisible(false);
        backButton.setVisible(true);
        isGameScreen = true;
        background = new ImageIcon(dyMain.class.getResource("../../images/" +trackList.get(nowSelected).getGameImage())).getImage();

    }

    public void backMain() {
        isMainScreen = true;
        leftButton.setVisible(true);
        rightButton.setVisible(true);
        easyModeButton.setVisible(true);
        hardModeButton.setVisible(true);
        backButton.setVisible(false);
        isGameScreen = false;
        background = new ImageIcon(dyMain.class.getResource("../../images/main_background2.jpg")).getImage();
        selectTrack(nowSelected);
    }

    public void enterMain() {
        background = new ImageIcon(dyMain.class.getResource("../../images/main_background2.jpg")).getImage();
        isMainScreen = true;

        startButton.setVisible(false);
        stopButton.setVisible(false);

        leftButton.setVisible(true);
        rightButton.setVisible(true);

        easyModeButton.setVisible(true);
        hardModeButton.setVisible(true);

        introMusic.close();
        selectTrack(0);
    }
}
