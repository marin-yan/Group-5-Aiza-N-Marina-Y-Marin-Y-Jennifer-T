import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends Actor
{
    private String[] menuOptions = {"Cookie", "Stack of Cookies"};
    
    private GreenfootImage[] menuImages = {
        new GreenfootImage("Menu/cookie.png"),
        new GreenfootImage("Menu/cookiestack.webp")
    };
    
    public void act()
    {
        // Add your action code here.
    }
    
    public String[] getMenuOptions()
    {
        return menuOptions;
    }

    public GreenfootImage[] getMenuImages() {
        return menuImages;
    }
    
    public String getMenuOption(int index)
    {
        return menuOptions[index];
    }
    
    public int getMenuSize()
    {
        return menuOptions.length;
    }
}
