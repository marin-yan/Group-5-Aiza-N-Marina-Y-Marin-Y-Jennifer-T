import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Chef here.
 * 
 * @author (Jennifer) 
 * @version (a version number or a date)
 */
public class Owner extends Staff
{
    private int num;
    
    public Owner(){
        if(num == 0){
            walkDown = new GreenfootImage[3];
            walkUp = new GreenfootImage[3];
            walkRight = new GreenfootImage[3];
            walkLeft = new GreenfootImage[3]; 
        }
        
        // Walk down animation - set images
        for(int i = 0; i < walkDown.length; i++){
            if(num == 0){
                walkDown[i] = new GreenfootImage("images/owner0/down" + i + ".png");
            }
            walkDown[i].scale(100, 100);
        }
        
        // Walk left animation - set images
        for(int i = 0; i < walkLeft.length; i++){
            if(num == 0){
                walkLeft[i] = new GreenfootImage("images/owner0/left" + i + ".png");
            }
            walkLeft[i].scale(100, 100);
        }
        
        // Walk right animation - set images
        for(int i = 0; i < walkRight.length; i++){
            if(num == 0){
                walkRight[i] = new GreenfootImage("images/owner0/right" + i + ".png");
            }
            walkRight[i].scale(100, 100);
        }
        
        // Walk up animation - set images
        for(int i = 0; i < walkUp.length; i++){
            if(num == 0){
                walkUp[i] = new GreenfootImage("images/owner0/up" + i + ".png");
            }
            walkUp[i].scale(100, 100);
        }
        
        setImage(walkDown[0]);
    }
    
    public void act(){
        animationSpeed = 7;
        move();
    }
}
