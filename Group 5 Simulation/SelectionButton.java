import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SelectionButton here.
 * 
 * @author (Aiza) 
 * @version (a version number or a date)
 */
public class SelectionButton extends Button
{
    public SelectionButton()
    {
        super("Select", 150);
    }

    public void onClick()
    {
        Greenfoot.setWorld(new RestaurantWorld());
    }
}
