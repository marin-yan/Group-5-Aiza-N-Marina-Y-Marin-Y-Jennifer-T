import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Waiter here.
 * 
 * @author (Jennifer) 
 * @version (a version number or a date)
 */
public class Waiter extends Staff
{
    public Waiter(){
        // Set variables
        walkDown = new GreenfootImage[5];
        walkUp = new GreenfootImage[5];
        walkRight = new GreenfootImage[5];
        walkLeft = new GreenfootImage[5];
        
        // Walk down animation - set images
        for(int i = 0; i < walkDown.length; i++){
            walkDown[i] = new GreenfootImage("images/waiter1/down" + i + ".png");
            //walkDown[i].scale(65, 90);//77,161
        }
        
        // Walk up animation - set images
        for(int i = 0; i < walkUp.length; i++){
            walkUp[i] = new GreenfootImage("images/waiter1/up" + i + ".png");
            //walkUp[i].scale(65, 90);
        }
        
        // Walk right animation - set images
        for(int i = 0; i < walkRight.length; i++){
            walkRight[i] = new GreenfootImage("images/waiter1/right" + i + ".png");
        }
        
        // Walk left animation - set images
        for(int i = 0; i < walkLeft.length; i++){
            walkLeft[i] = new GreenfootImage("images/waiter1/left" + i + ".png");
        }
    
        setImage(walkDown[0]);
    }
    
    public void act(){
         counter++;
        if(counter % 12 == 0){
            if(facing.equals("down")){
                walkingDown();
            }else if(facing.equals("up")){
                walkingUp();
            }else if(facing.equals("right")){
                walkingRight();
            }else if(facing.equals("left")){
                walkingLeft();
            }
        }
    }
}
