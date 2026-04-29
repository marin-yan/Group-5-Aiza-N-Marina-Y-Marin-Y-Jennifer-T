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
    private Customer targetCustomerL;
    private Customer targetCustomerR;
    
    public Waiter(boolean isLeftSide){
        this.isLeftSide = isLeftSide;
        animationSpeed = 10;
        speed = 1;
        
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
        if(isLeftSide){
            serveCustomerL();
        }else{
            serveCustomerR();
        }
    }
    
    public void serveCustomerL(){
        if(state == 0){
            findCustomerL();
        }else if(state == 1){
            moveTo(targetCustomerL.getX(), targetCustomerL.getY());
            if(at(targetCustomerL.getX(), targetCustomerL.getY())){
                state = 2;
            }
        }else if(state == 2){
            // Kitchen area - left side    //top: (70, 650)   right: () Need to adjust
            moveTo(65, 650);
            if(at(65, 650)){
                state = 3;
            }
        }else if(state == 3){
            moveTo(targetCustomerL.getX(), targetCustomerL.getY());
            if(at(targetCustomerL.getX(), targetCustomerL.getY())){
                targetCustomerL.setOrdered(false);
                targetCustomerL.setServed(true);
                
                targetCustomerL = null;
                state = 0;
            }
        }
    }
    
    public void serveCustomerR(){
        if(state == 0){
            findCustomerR();
        }else if(state == 1){
            moveTo(targetCustomerR.getX(), targetCustomerR.getY());
            if(at(targetCustomerR.getX(), targetCustomerR.getY())){
                state = 2;
            }
        }else if(state == 2){
            // Kitchen area - right side
            moveTo(1200, 400);
            if(at(1200, 400)){
                state = 3;
            }
        }else if(state == 3){
            moveTo(targetCustomerR.getX(), targetCustomerR.getY());
            if(at(targetCustomerR.getX(), targetCustomerR.getY())){
                targetCustomerR.setOrdered(false);
                targetCustomerR.setServed(true);
                
                targetCustomerR = null;
                state = 0;
            }
        }
    }
    
    public void findCustomerL(){
        List<Customer> customers = getWorld().getObjects(Customer.class);
        
        for(int i = 0; i < customers.size(); i++){
            Customer customer = customers.get(i);
            
            if(customer.hasOrdered() && customer.getX() < 600){
                targetCustomerL = customer;
                state = 1;
                return;
            }
        }
    }
    
    public void findCustomerR(){
        List<Customer> customersR = getWorld().getObjects(Customer.class);
        
        for(int i = 0; i < customersR.size(); i++){
            Customer customerR = customersR.get(i);
            
            if(customerR.hasOrdered() && customerR.getX() > 600){
                targetCustomerR = customerR;
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
