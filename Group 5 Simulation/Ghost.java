import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ghost here.
 * 
 * @author (Jennifer)
 * Credit: Pinterest "Hollow Knight | Ghost | animation sheet" - Harbista|STU
 * @version (a version number or a date)
 */
public class Ghost extends Customer
{
    public Ghost(){
        walkDown = new GreenfootImage[6];
        walkUp = new GreenfootImage[6];
        walkRight = new GreenfootImage[9];
        walkLeft = new GreenfootImage[9];
        GreenfootImage[] runRight = new GreenfootImage[9]; // This can be used for a special event
        
        // Walk down animation - set images
        for(int i = 0; i < walkDown.length; i++){
            walkDown[i] = new GreenfootImage("images/Ghost/down" + i + ".png");
        }
        
        // Walk up animation - set images
        for(int i = 0; i < walkUp.length; i++){
            walkUp[i] = new GreenfootImage("images/Ghost/up" + i + ".png");
        }
        
        // Walk right animation - set images
        for(int i = 0; i < walkRight.length; i++){
            walkRight[i] = new GreenfootImage("images/Ghost/right" + i + ".png");
        }
        
        // Walk left animation - set images
        for(int i = 0; i < walkLeft.length; i++){
            walkLeft[i] = new GreenfootImage("images/Ghost/right" + i + ".png");
            walkLeft[i].mirrorHorizontally();
        }
    
        setImage(walkDown[0]);
    }
    
    public void act(){
        animationSpeed = 12;
        super.act();
    }
}
