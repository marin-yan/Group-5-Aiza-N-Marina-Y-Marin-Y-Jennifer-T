import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Chef here.
 * 
 * @author (Jennifer)
 * Credit: Pinterest "basil pixel" - Pixel Art Ideas
 *         Pinterest -isoup
 *         Pinterest "主人公男ドット" - モン コワイ
 *         Pinterest "主人公女ドット" - モン コワイ
 *         code "void moveTo(), boolean at(int x, inty)" with help of ChatGPT
 * @version (a version number or a date)
 */
public class Owner extends Staff
{
    // Change # here for testing
    // Here should have a button for players to choose the character they want
    // character 2 and 3 could have special ending
    private int num;
    
    private static final int A_X = 390;
    private static final int A_Y = 275;
    
    private static final int B_X = 315;
    private static final int B_Y = 275;
    
    private static final int C_X = 315;
    private static final int C_Y = 300;
    
    private static final int D_X = 10;
    private static final int D_Y = 300;
    
    private static final int E_X = 12;
    private static final int E_Y = 205;
    
    
    private static final int COUNTER_X = 155;
    private static final int COUNTER_Y = 190;

    public Owner(int num, boolean isLeftSide){
        this.num = num;
        this.isLeftSide = isLeftSide;
        animationSpeed = 8;
        speed = 8;
        
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
        if(isLeftSide){
            goRouteLeft();
        }else{
            goRouteRight();
        }
    }
    
    public void goRouteLeft(){
        if(state == 0){
            moveTo(A_X, A_Y);
            if(at(A_X, A_Y)){
                state = 1;
            }
        }else if(state == 1){
            moveTo(B_X, B_Y);
            if(at(B_X, B_Y)){
                state = 2;
            }
        }else if(state == 2){
            moveTo(C_X, C_Y);
            if(at(C_X, C_Y)){
                state = 3;
            }
        }else if(state == 3){
            moveTo(D_X, D_Y);
            if(at(D_X, D_Y)){
                state = 4;
            }
        }else if(state == 4){
            moveTo(E_X, E_Y);
            if(at(E_X, E_Y)){
                setImage(new GreenfootImage(1, 1)); // Disappear
                getWorld().addObject(new CounterOwner(num), COUNTER_X, COUNTER_Y);
                state = 5;
            }
        }
    }
    
    public void goRouteRight(){
        if(state == 0){
            moveTo(810, A_Y);
            if(at(810, A_Y)){
                state = 1;
            }
        }else if(state == 1){
            moveTo(885, B_Y);
            if(at(885, B_Y)){
                state = 2;
            }
        }else if(state == 2){
            moveTo(885, C_Y);
            if(at(885, C_Y)){
                state = 3;
            }
        }else if(state == 3){
            moveTo(1188, D_Y);
            if(at(1188, D_Y)){
                state = 4;
            }
        }else if(state == 4){
            moveTo(1185, E_Y);
            if(at(1185, E_Y)){
                setImage(new GreenfootImage(1, 1));
                getWorld().addObject(new CounterOwner(num), 1045, COUNTER_Y);
                state = 5;
            }
        }
    }
    
    public void moveTo(int x, int y){
        double dx = x - getPreciseX();
        double dy = y - getPreciseY();
        double distance = Math.sqrt(dx * dx + dy * dy);
    
        // Stop when close enough
        if (distance < speed){
            setLocation(x, y);
            moving = false;
            return;
        }
        
        moving = true;
    
        // Decide facing direction (for animation)
        if (Math.abs(dx) > Math.abs(dy)){
            facing = (dx > 0) ? "right" : "left";
        }else{
            facing = (dy > 0) ? "down" : "up";
        }

        move();
    }
}