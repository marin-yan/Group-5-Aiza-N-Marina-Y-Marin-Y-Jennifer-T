import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Chef here.
 * 
 * @author (Jennifer)
 * Credit: Pinterest "basil pixel" - Pixel Art Ideas
 *         Pinterest -isoup
 *         Pinterest "主人公男ドット" - モン コワイ
 *         Pinterest "主人公女ドット" - モン コワイ
 * @version (a version number or a date)
 */
public class Owner extends Staff
{
    // Change # here for testing
    // Here should have a button for players to choose the character they want
    // character 2 and 3 could have special ending
    private int num = 3;
    
    public Owner(int num){
        this.num = num;
        
        // Work for all characters
        walkDown = new GreenfootImage[3];
        walkUp = new GreenfootImage[3];
        walkRight = new GreenfootImage[3];
        walkLeft = new GreenfootImage[3];
    
        // Walk down animation - set images
        for(int i = 0; i < walkDown.length; i++){
            if(num == 0){
                walkDown[i] = new GreenfootImage("images/owner0/down" + i + ".png");
            }else if(num == 1){
                walkDown[i] = new GreenfootImage("images/owner1/down" + i + ".png");
            }else if(num == 2){
                walkDown[i] = new GreenfootImage("images/owner2/down" + i + ".png");        
            }else if(num == 3){
                walkDown[i] = new GreenfootImage("images/owner3/down" + i + ".png");    
            }
            walkDown[i].scale(100, 100);
        }
        
        // Walk left animation - set images
        for(int i = 0; i < walkLeft.length; i++){
            if(num == 0){
                walkLeft[i] = new GreenfootImage("images/owner0/left" + i + ".png");
            }else if(num == 1){
                walkLeft[i] = new GreenfootImage("images/owner1/left" + i + ".png");
            }else if(num == 2){
                walkLeft[i] = new GreenfootImage("images/owner2/left" + i + ".png");          
            }else if(num == 3){
                walkLeft[i] = new GreenfootImage("images/owner3/left" + i + ".png");        
            }
            walkLeft[i].scale(100, 100);  
        }
        
        // Walk right animation - set images
        for(int i = 0; i < walkRight.length; i++){
            if(num == 0){
                walkRight[i] = new GreenfootImage("images/owner0/right" + i + ".png");
            }else if(num == 1){
                walkRight[i] = new GreenfootImage("images/owner1/right" + i + ".png");
            }else if(num == 2){
                walkRight[i] = new GreenfootImage("images/owner2/right" + i + ".png"); 
            }else if(num == 3){
                walkRight[i] = new GreenfootImage("images/owner3/right" + i + ".png");                  
            }
            walkRight[i].scale(100, 100);  
        }
        
        // Walk up animation - set images
        for(int i = 0; i < walkUp.length; i++){
            if(num == 0){
                walkUp[i] = new GreenfootImage("images/owner0/up" + i + ".png");
            }else if(num == 1){
                walkUp[i] = new GreenfootImage("images/owner1/up" + i + ".png");
            }else if(num == 2){
                walkUp[i] = new GreenfootImage("images/owner2/up" + i + ".png");         
            }else if(num == 3){
                walkUp[i] = new GreenfootImage("images/owner3/up" + i + ".png"); 
            }
            walkUp[i].scale(100, 100); 
        }
        
        setImage(walkDown[0]);
    }
    
    public void act(){
        animationSpeed = 8;
        move();
    }
}
