package algorithm4gui.selectionsort;

import DynamicBeat.dynamic_beat.dyMain;

import javax.swing.*;
import java.awt.*;

public class SelectSortDisplay extends JFrame {

    final static int DISPLAY_SCREEN_HEIGHT = 100;
    final static int DISPLAY_SCREEN_WIDTH = 1000;
    private Graphics screenGraphic;

    SelectSortDisplay() {

        setSize(DISPLAY_SCREEN_WIDTH, DISPLAY_SCREEN_HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        GridLayout grid = new GridLayout(1,10,5,5);
        //grid.setVgap(2);
        //grid.setHgap(2);
        setLayout(grid);

        JLabel[] elementLabel = new JLabel[10];

        for (int i = 0; i < 10; ++i) {
            elementLabel[i] = new JLabel(i+"");
            elementLabel[i].setBackground(new Color(0,10,5,10));
            elementLabel[i].
            add(elementLabel[i]);
        }

        setVisible(true);

        //setLayout(mainLayout, BorderLayout.WEST);
        //add(centerPane, BorderLayout.CENTER);
        //add(centerPane);
    }

    public void paint(Graphics g) {

    }

    public void screenDraw(Graphics2D g) {

    }
}
