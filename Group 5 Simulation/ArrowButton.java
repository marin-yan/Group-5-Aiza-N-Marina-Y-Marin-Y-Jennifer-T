import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ArrowButton here.
 * 
 * @author (Aiza) (Jennifer - onclick())
 * @version (a version number or a date)
 */
public class ArrowButton extends Button
{
    //player is either 1 or 2
    private int player;
    //direction is either 1 or -1
    private int direction;
    
    public ArrowButton(int player, int direction)
    {
        super(getArrowText(direction), 60);
        
        this.player = player;
        this.direction = direction;
    }
    
    private static String getArrowText(int direction)
    {
        if (direction == -1)
            return "<";
        else
            return ">";
    }
    
    // Change display images in CustomizeWorld
    public void onClick(){
        CustomizeWorld world = (CustomizeWorld)getWorld();
        world.changeCharacter(player, direction);
    }
}
