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
    //type is either 1 (waiter count) or 2 (waiter speed)
    private int type;
    
    public AdjustmentButton(int value, int direction, int type) {
        super(getArrowText(direction), 40);
        
        this.value = value;
        this.direction = direction;
        this.type = type;
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
        if(type == 1){
            world.changeWaiterCount(value, direction);
        }else if(type == 2){
            world.changeWaiterSpeed(value, direction);
        }
    }
}
