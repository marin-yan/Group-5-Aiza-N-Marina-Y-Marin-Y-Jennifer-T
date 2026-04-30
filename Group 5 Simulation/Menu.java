import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The menu allows the customers to order food.
 * 
<<<<<<< HEAD
 * @author (Marin) 
=======
<<<<<<< Updated upstream
 * @author (your name) 
=======
 * @author (Marin) (Jennifer - adjust images)
 * Credit: Pinterest - cookies, cafe
>>>>>>> Stashed changes
>>>>>>> smallChanges--Jennifer
 * @version (a version number or a date)
 */
public class Menu extends Actor
{
    /**
     * Act - do whatever the Menu wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     * Credits: https://www.freeiconspng.com/img/47942
     * https://www.vecteezy.com/
     * 
     */
    
    private String[] menuOptions = {"Cookie", "Cafe"};
    
    private GreenfootImage[] menuImages = {
        new GreenfootImage("Menu/cookie_new.png"),
        new GreenfootImage("Menu/cafe.png")
    };
    
    public void act()
    {
        // Add your action code here.
    }
    
    public String[] getMenuOptions() {
        return menuOptions;
    }

    public GreenfootImage[] getMenuImages() {
        return menuImages;
    }

    public int getMenuSize() {
        return menuOptions.length;
    }
}
