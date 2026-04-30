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
    
    private CheckIcon checkL = new CheckIcon();
    private CheckIcon checkR = new CheckIcon();
    
    // Path Points 
    private static final int kitchenLX = 119;
    private static final int kitchenLY = 733;
    private static final int middleLX = 300;
    private static final int middleLY = 555;
    private static final int upperLX = middleLX;
    private static final int upperLY = 390;
    
    private static final int kitchenRX = 1072;
    private static final int kitchenRY = 740;
    private static final int middleRX = 900;
    private static final int middleRY = 555;
    private static final int upperRX = middleRX;
    private static final int upperRY = 390;
    
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
            // Starting point - go to the customer directly
            if(at(100, 390)){
                state = 3;
            }
            
            int middleDistance = distance(middleLX, middleLY, targetCustomerL.getX(), targetCustomerL.getY());
            int upperDistance  = distance(upperLX, upperLY, targetCustomerL.getX(), targetCustomerL.getY());
            
            if(upperDistance < middleDistance){
                state = 2;
            }else{
                moveTo(middleLX, middleLY);
                if(at(middleLX, middleLY)){
                    if(targetCustomerL.getY() < 555){
                        state = 2;
                    }else{
                        state = 3;
                    }
                }
            }
        }else if(state == 2){
            // Upper point
            moveTo(upperLX, upperLY);
            if(at(upperLX, upperLY)){
                state = 3;
            }
        }else if(state == 3){
            moveTo(targetCustomerL.getX(), targetCustomerL.getY() - 15);
            if(at(targetCustomerL.getX(), targetCustomerL.getY() - 15)){
                getWorld().addObject(checkL, targetCustomerL.getX(), targetCustomerL.getY() + 65);
                
                int customerDistance = distance(targetCustomerL.getX(), targetCustomerL.getY(), kitchenLX, kitchenLY);
                int middleDistance = distance(middleLX, middleLY, kitchenLX, kitchenLY);
    
                if(customerDistance < middleDistance){
                    state = 5;
                }else{
                    state = 4;
                }
            }
        }else if(state == 4){
            // Middle point
            moveTo(middleLX, middleLY);
            if(at(middleLX, middleLY)){
                state = 5;
            }
        }else if(state == 5){
            // Kitchen area - left side 
            moveTo(kitchenLX, kitchenLY);
            if(at(kitchenLX, kitchenLY)){
                state = 6;
            }
        }else if(state == 6){
            // Middle point
            moveTo(middleLX, middleLY);
            if(at(middleLX, middleLY)){
                if(targetCustomerL.getY() < 555){
                    state = 7;
                }else{
                    state = 8;
                }
            }
        }else if(state == 7){
            // Upper point - Move up if customers are on upper lane
            moveTo(upperLX, upperLY);
            if(at(upperLX, upperLY)){
                state = 8;
            }
        }else if(state == 8){
            moveTo(targetCustomerL.getX(), targetCustomerL.getY() - 15);
            if(at(targetCustomerL.getX(), targetCustomerL.getY() - 15)){
                getWorld().removeObject(checkL);
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
            // Starting point - go to the customer directly
            if(at(100, 390)){
                state = 3;
            }
            
            int middleDistance = distance(middleRX, middleRY, targetCustomerR.getX(), targetCustomerR.getY());
            int upperDistance  = distance(upperRX, upperRY, targetCustomerR.getX(), targetCustomerR.getY());
            
            if(upperDistance < middleDistance){
                state = 2;
            }else{
                moveTo(middleRX, middleRY);
                if(at(middleRX, middleRY)){
                    if(targetCustomerR.getY() < 555){
                        state = 2;
                    }else{
                        state = 3;
                    }
                }
            }
        }else if(state == 2){
            // Upper point
            moveTo(upperRX, upperRY);
            if(at(upperRX, upperRY)){
                state = 3;
            }
        }else if(state == 3){
            moveTo(targetCustomerR.getX(), targetCustomerR.getY() - 15);
            if(at(targetCustomerR.getX(), targetCustomerR.getY() - 15)){
                getWorld().addObject(checkR, targetCustomerR.getX(), targetCustomerR.getY() + 65);
                
                int customerDistance = distance(targetCustomerR.getX(), targetCustomerR.getY(), kitchenRX, kitchenRY);
                int middleDistance = distance(middleRX, middleRY, kitchenRX, kitchenRY);
    
                if(customerDistance < middleDistance){
                    state = 5;
                }else{
                    state = 4;
                }
            }
        }else if(state == 4){
            // Middle point
            moveTo(middleRX, middleRY);
            if(at(middleRX, middleRY)){
                state = 5;
            }
        }else if(state == 5){
            // Kitchen area - left side 
            moveTo(kitchenRX, kitchenRY);
            if(at(kitchenRX, kitchenRY)){
                state = 6;
            }
        }else if(state == 6){
            // Middle point
            moveTo(middleRX, middleRY);
            if(at(middleRX, middleRY)){
                if(targetCustomerR.getY() < 555){
                    state = 7;
                }else{
                    state = 8;
                }
            }
        }else if(state == 7){
            // Upper point - Move up if customers are on upper lane
            moveTo(upperRX, upperRY);
            if(at(upperRX, upperRY)){
                state = 8;
            }
        }else if(state == 8){
            moveTo(targetCustomerR.getX(), targetCustomerR.getY() - 15);
            if(at(targetCustomerR.getX(), targetCustomerR.getY() - 15)){
                getWorld().removeObject(checkR);
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

            if(dx > 0){
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
    
    public int distance(int x1, int y1, int x2, int y2){
        return (x1 - x2)*(x1 - x2) + (y1 - y2)*(y1 - y2);
    }
}
