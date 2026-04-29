import greenfoot.*;

public class LevelDisplay extends Actor
{
    private int level;
    private LevelDisplay levelDisplay;

    public LevelDisplay(int level)
    {
        this.level = level;
        updateImage();
    }

    public void setLevel(int level)
    {
        this.level = level;
        updateImage();
    }

    private void updateImage()
    {
        GreenfootImage img = new GreenfootImage("Level " + level, 20, Color.BLACK, new Color(0,0,0,0));
        setImage(img);
    }

    public void setLevelDisplay(LevelDisplay display)
    {
        this.levelDisplay = display;
    }
}