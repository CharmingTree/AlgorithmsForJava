package DynamicBeat.dynamic_beat;

import javazoom.jl.player.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

public class Music extends Thread{

    private Logger logger;
    private Player player;
    private boolean isLoop;
    private File file;
    private FileInputStream fis;
    private BufferedInputStream bis;

    public Music(String name, boolean isLoop) {
        logger = LoggerFactory.getLogger(this.getClass());
        try {
            this.isLoop = isLoop;
            file = new File(dyMain.class.getResource("../music/" + name).toURI());
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            player = new Player(bis);

        }catch (Exception e) {
            e.printStackTrace();
            logger.info("{}", e.getMessage());
        }
    }

    public int getTime() {
        if (player == null)
            return 0;
        return player.getPosition();
    }

    public void close() {
        this.isLoop = false;
        player.close();
        this.interrupt();
    }

    @Override
    public void run() {
        try
        {
            do {
                player.play();
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                player = new Player(bis);
            }while(isLoop);
        }catch (Exception e) {
            e.printStackTrace();
            logger.info("{}", e.getMessage());
        }
    }
}
