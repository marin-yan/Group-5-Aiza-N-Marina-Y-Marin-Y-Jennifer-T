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
    private boolean occupied = false;
    
    public Table(int level){
        setLevel(level);
        tableImage.scale(85, 85);
        setImage(tableImage);
    }
    
    public void act()
    {
        // Add your action code here.
    }
    
    public void setLevel (int level){
        // Set image
        if(level == 1){   
            tableImage = new GreenfootImage("images/Table1.png");
        }else if(level == 2){
            tableImage = new GreenfootImage("images/Table2.png");
        }else if(level == 3){
            tableImage = new GreenfootImage("images/Table3.png");
        }
        setImage(tableImage);
    }
    
    public boolean isOccupied() {
        return occupied;
    }
    
    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }
}
