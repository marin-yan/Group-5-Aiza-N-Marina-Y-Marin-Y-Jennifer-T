import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Frog here.
 * 
 * @author (Jennifer)
 * Credit: Pinterest "Frog boy sprite sheet" - Ziggy
 * @version (a version number or a date)
 */
public class Frog extends Customer
{
    public Frog(){
        // Set variables
        walkDown = new GreenfootImage[4];
        walkUp = new GreenfootImage[4];
        walkRight = new GreenfootImage[2];
        walkLeft = new GreenfootImage[2];
        
        // Walk down animation - set images
        for(int i = 0; i < walkDown.length; i++){
            walkDown[i] = new GreenfootImage("images/frog/down" + i + ".png");
            walkDown[i].scale(75, 75);
        }

        // Walk up animation - set images
        for(int i = 0; i < walkUp.length; i++){
            walkUp[i] = new GreenfootImage("images/frog/up" + i + ".png");
            walkUp[i].scale(75, 75);
        }

        // Walk right animation - set images
        for(int i = 0; i < walkRight.length; i++){
            walkRight[i] = new GreenfootImage("images/frog/right" + i + ".png");
            walkRight[i].scale(75, 75);
        }

        // Walk left animation - set images
        for(int i = 0; i < walkLeft.length; i++){
            walkLeft[i] = new GreenfootImage("images/frog/left" + i + ".png");
            walkLeft[i].scale(75, 75);
        }

        //For testing
        setImage(walkDown[0]);
        //setImage(walkUp[0]);
        //setImage(walkRight[0]);
        //setImage(walkLeft[0]);
    }

    public void act(){
        animationSpeed = 6;
        facing = "down";
        move(5);
        facing = "left";
        move(5);
    }
}