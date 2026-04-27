import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

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
        animationSpeed = 7;
        
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
        moveToCustomer();
    }
    
    public void moveToCustomer(){
        // A list of customers 
        List<Customer> customers = getWorld().getObjects(Customer.class);
        
        if(!customers.isEmpty()){
            for(int i = 0; i < customers.size(); i++){
                Customer customer = customers.get(i);
                if(customer.hasOrdered()){
                    moveTo(customer.getX(), customer.getY());
                    return;
                }
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
