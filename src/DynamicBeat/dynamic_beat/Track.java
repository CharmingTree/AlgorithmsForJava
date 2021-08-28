package DynamicBeat.dynamic_beat;

public class Track {

    private String musicTitleName;
    private String titleImage;
    private String startImage;
    private String gameImage;
    private String startMusic;
    private String gameMusic;

    public Track(String musicTitleName, String titleImage, String startImage, String gameImage, String startMusic, String gameMusic) {
        this.musicTitleName = musicTitleName;
        this.titleImage = titleImage;
        this.startImage = startImage;
        this.gameImage = gameImage;
        this.startMusic = startMusic;
        this.gameMusic = gameMusic;
    }

    public String getMusicTitleName() {
        return musicTitleName;
    }

    public void setMusicTitleName(String musicTitleName) {
        this.musicTitleName = musicTitleName;
    }

    public void setTitleImage(String titleImage) {
        this.titleImage = titleImage;
    }

    public void setStartImage(String startImage) {
        this.startImage = startImage;
    }

    public void setGameImage(String gameImage) {
        this.gameImage = gameImage;
    }

    public void setStartMusic(String startMusic) {
        this.startMusic = startMusic;
    }

    public void setGameMusic(String gameMusic) {
        this.gameMusic = gameMusic;
    }

    public String getTitleImage() {
        return titleImage;
    }

    public String getStartImage() {
        return startImage;
    }

    public String getGameImage() {
        return gameImage;
    }

    public String getStartMusic() {
        return startMusic;
    }

    public String getGameMusic() {
        return gameMusic;
    }
}
