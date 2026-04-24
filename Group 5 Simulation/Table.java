import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Table here.
 * 
 * @author (Jennifer)
 * Credit: Pinterest "Animal Restaurant app" - Kaleidos
 * @version (a version number or a date)
 */
public class Table extends Actor
{
    private GreenfootImage tableImage;
    
    public Table(){
        // Set image
        tableImage = new GreenfootImage("images/Table.png");
        tableImage.scale(85, 85);
        setImage(tableImage);
    }
    
    public void act()
    {
        // Add your action code here.
    }
}
