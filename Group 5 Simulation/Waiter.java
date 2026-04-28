import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Waiter here.
 * 
 * @author (Jennifer)
 * Credit: Pinterest -Trang yury
 *         code "void moveTo(), serveCustomer()" with help of ChatGPT
 * @version (a version number or a date)
 */
public class Waiter extends Staff
{   
    private Customer targetCustomer;
    
    public Waiter(){
        animationSpeed = 7;
        speed = 2;
        
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
        serveCustomer();
    }
    
    public void serveCustomer(){
        if(state == 0){
            findCustomer();
        }else if(state == 1){
            moveTo(targetCustomer.getX(), targetCustomer.getY());
            if(at(targetCustomer.getX(), targetCustomer.getY())){
                state = 2;
            }
        }else if(state == 2){
            // Go to a sace zone
            moveTo(400, 390);
            if(at(400, 390)){
                state = 3;
            }
        }else if(state == 3){
            // Kitchen area - left side
            moveTo(0, 390);
            if(at(0, 390)){
                state = 4;
            }
        }else if(state == 4){
            moveTo(targetCustomer.getX(), targetCustomer.getY());
            if(at(targetCustomer.getX(), targetCustomer.getY())){
                targetCustomer.setOrdered(false);
                targetCustomer.setServed(true);
                
                targetCustomer = null;
                state = 0;
            }
        }
    }
    
    public void findCustomer(){
        List<Customer> customers = getWorld().getObjects(Customer.class);
        
        for(int i = 0; i < customers.size(); i++){
            Customer customer = customers.get(i);
            
            if(customer.hasOrdered()){
                targetCustomer = customer;
                state = 1;
                return;
            }
        }
    }
    
    public void moveTo(int x, int y){
        int dx = x - getX();
        int dy = y - getY();

        // Move horizontally first
        if(Math.abs(dx) > 2){
            moving = true;

            if (dx > 0){
                facing = "right";
                setLocation(getX() + speed, getY());
            }else{
                facing = "left";
                setLocation(getX() - speed, getY());
            }
        }else if(Math.abs(dy) > 2){ // Then move vertically
            moving = true;
    
            if(dy > 0){
                facing = "down";
                setLocation(getX(), getY() + speed);
            }else{
                facing = "up";
                setLocation(getX(), getY() - speed);
            }
        }else{
            moving = false;
        }
        
        move();
    }
}
