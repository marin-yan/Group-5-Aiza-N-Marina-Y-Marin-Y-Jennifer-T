import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Waiter here.
 * 
 * @author (Jennifer)
 * Credit: Pinterest -Trang yury
 * @version (a version number or a date)
 */
public class Waiter extends Staff
{
    public Waiter(){
        // Set variables
        walkDown = new GreenfootImage[4];
        walkUp = new GreenfootImage[4];
        walkRight = new GreenfootImage[4];
        walkLeft = new GreenfootImage[4]; 
        
        // Walk down animation - set images
        for(int i = 0; i < walkDown.length; i++){
            walkDown[i] = new GreenfootImage("images/waiter/down" + i + ".png");
            walkDown[i].scale(49, 102);
        }
        
        // Walk up animation - set images
        for(int i = 0; i < walkUp.length; i++){
            walkUp[i] = new GreenfootImage("images/waiter/up" + i + ".png");
            walkUp[i].scale(49, 102);
        }
        
        // Walk right animation - set images
        for(int i = 0; i < walkRight.length; i++){
            walkRight[i] = new GreenfootImage("images/waiter/right" + i + ".png");
            walkRight[i].scale(49, 102);
        }
        
        // Walk left animation - set images
        for(int i = 0; i < walkLeft.length; i++){
            walkLeft[i] = new GreenfootImage("images/waiter/left" + i + ".png");
            walkLeft[i].scale(49, 102);
        }
    
        setImage(walkDown[0]);
    }
    
    public void act(){
        animationSpeed = 7;
        move();
    }
}
