import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Customer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Customer extends SuperSmoothMover {
    /**
     * Act - do whatever the Customer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private Menu menu;
    private boolean hasOrdered = false;
    private int orderedFoodIndex;
    
    public void act() {
        if (!hasOrdered)
        {
            orderFood();
        }
    }
    
    public Customer(Menu menu) {
        this.menu = menu;
        setImage("customer.png");
    }
    
    public void orderFood() {
        orderedFoodIndex = Greenfoot.getRandomNumber(menu.getMenuSize());
        hasOrdered = true;
        displayOrder(orderedFoodIndex);
    }
    
    
    public void displayOrder(int index) {
        GreenfootImage orderedImage = menu.getMenuImages() [orderedFoodIndex];
    }
}
