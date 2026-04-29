import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AdjustmentButton here.
 * 
 * @author (Marin) 
 * @version (a version number or a date)
 */
public class AdjustmentButton extends Button
{
    //player is either 1 or 2
    private int value;
    //direction is either 1 or -1
    private int direction;
    
    public AdjustmentButton(int value, int direction) {
        super(getArrowText(direction), 40);
        
        this.value = value;
        this.direction = direction;
    }
    
    private static String getArrowText(int direction)
    {
        if (direction == -1)
            return "-";
        else
            return "+";
    }
    
    // Change display images in CustomizeWorld
    public void onClick(){
        CustomizeWorld world = (CustomizeWorld)getWorld();
        world.changeWaiterCount(value, direction);
    }
}