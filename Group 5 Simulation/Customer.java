import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Customer here.
 * 
 * @author (Jennifer -- customer movement images,  & leaveRestaurant()
 * Marin -- the rest of the methods) 
 * @version (a version number or a date)
 */
public class Customer extends SuperSmoothMover
{
    // the coordinates for the customers
    private static final int LEFT_ENTRY_X = 405;
    private static final int RIGHT_ENTRY_X = 810;
    private static final int ENTRY_Y = 210;
    private static final int LEFT_SPECIAL_X = 200;
    private static final int RIGHT_SPECIAL_X = 1000;
    private static final int TOP_ROW_Y = 500;
    private static final int BOTTOM_ROW_Y = 650;
    private static final int COUNTER_X = 225;
    private static final int COUNTER_Y = 275;
    private static final double WALK_SPEED = 2.2;
    
    // Initial direction, the direction that the customer is facing
    String facing = "down";
    String lastFacing = "";
    
    // Track index of walking
    protected int walkingIndex = 0;
    
    // Make the animation slower / more precise
    protected int counter = 0;
    
    // Speed of the customer
    protected int speed = 4;
    protected int animationSpeed;
    
    // Track moving
    protected boolean moving = false;
    
    // Initializing the arrays
    protected GreenfootImage[] walkDown;
    protected GreenfootImage[] walkUp;
    protected GreenfootImage[] walkRight;
    protected GreenfootImage[] walkLeft;
    private boolean atCounter;
    
    protected Table targetTable;
    protected boolean seated = false;
    
    // used for the movement to special tables
    private int pathStage = 0;
    private boolean isLeftSide = true;
    private int entryX = LEFT_ENTRY_X;
    
    // letting the customer know the menu
    private Menu menu = new Menu();
    private OrderIcon orderIcon;
    private int orderedFoodIndex;
    private boolean ordered = false;
    private boolean served = false;
    private boolean gaveMoney = false;
    private boolean claimedByWaiter = false;

    
    public Customer() {
        setImage("customer.png");
    }
    
    public void addedToWorld(World world) {
        setLocation(entryX, ENTRY_Y);
    }
    
    public void act()  {
        // moves to table if not yet seated
        if (!seated && targetTable != null ){
            moveToTable();
        }else if (served){
            // leaves the restaurant
            leaveRestaurant();
        }else if (seated){
            showOrderIcon();
            orderFood();
        }
    }
    
    
    public void orderFood() {
        // order once
        if(ordered){
            return;
        }
        
        orderedFoodIndex = Greenfoot.getRandomNumber(menu.getMenuSize());
        // lets the customers order randomly
        int randomOrder = Greenfoot.getRandomNumber(menu.getMenuSize()) + 1;
        
        if (randomOrder == 1) {
            orderedFoodIndex = 0;
        } else if (randomOrder == 2) {
            orderedFoodIndex = 1;
        }
        
        GreenfootImage orderedImage = menu.getMenuImages()[orderedFoodIndex];
        orderIcon.setFoodImage(orderedImage);
        // shows the order in a picture
        ordered = true;
    }
        
    public void walkingDown(){
        setLocation(getX(), getY() + speed);
        setImage(walkDown[walkingIndex]);
        walkingIndex = (walkingIndex + 1) % walkDown.length;
    }
    
    public void walkingUp(){
        setLocation(getX(), getY() - speed);
        setImage(walkUp[walkingIndex]);
        walkingIndex = (walkingIndex + 1) % walkUp.length;
    }
    
    public void walkingRight(){
        move(speed);
        setImage(walkRight[walkingIndex]);
        walkingIndex = (walkingIndex + 1) % walkRight.length;
    }
    
    public void walkingLeft(){
        move(-speed);
        setImage(walkLeft[walkingIndex]);
        walkingIndex = (walkingIndex + 1) % walkLeft.length;
    }
    
    public void move(){
        counter++;
        
        // Reset animation when direction changes 
        if(!facing.equals(lastFacing)){
            walkingIndex = 0;
            lastFacing = facing;
        }
        
        if(counter % animationSpeed == 0){
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
    
    // assigns a table to the customer
    public void setTargetTable (Table table) {
        targetTable = table;
        pathStage = 0;
        
        // marks the table as occupied
        if (targetTable != null) {
            targetTable.setOccupied(true);
        }
    }
    
    // decides which side of the restaurant the customer belongs to
    public void configureSide(boolean isLeftSide) {
        this.isLeftSide = isLeftSide;
        entryX = isLeftSide ? LEFT_ENTRY_X : RIGHT_ENTRY_X;
    }
    
    // moves the customers to their assigned table
    public void moveToTable() {
        // for the tables on the left: tables in the first column
        // for the tables on the right: tables in the second column
        if (isTopSpecialTableTarget()) {
            followTopSpecialTablePath();
            return;
        }
        
        if (isBottomSpecialTableTarget()) {
            followBottomSpecialTablePath();
            return;
        }
        
        // sets the final position of the customers
        
        int targetX = targetTable.getX();
        int targetY = targetTable.getY() - 75;
        
        // moves horizontally
        if (Math.abs(getX() - targetX) > 2) {
            if (getX() < targetX) {
                facing = "right";
                move();
            } else {
                facing = "left";
                move();
            }
            // vertically
        } else if (Math.abs(getY() - targetY) > 2) {
        
        if (getY() < targetY) {
            facing = "down";
            move();
        } else {
            facing = "up";
            move();
        }
        } else {
            // sits down
            seated = true;
            faceFront();
        }
    }
    
    // determines the path of the special tables
    private boolean isTopSpecialTableTarget() {
        return targetTable != null
            && targetTable.getX() == getSpecialTableX()
            && targetTable.getY() == TOP_ROW_Y;
    }
    
    private boolean isBottomSpecialTableTarget() {
        return targetTable != null
            && targetTable.getX() == getSpecialTableX()
            && targetTable.getY() == BOTTOM_ROW_Y;
    }
    
    private void followTopSpecialTablePath() {
        if (pathStage == 0) {
            if (Math.abs(getY() - TOP_ROW_Y) > 2) {
                facing = "down";
                move();
                return;
            }
            pathStage = 1;
        }
        
        if (pathStage == 1) {
            if (Math.abs(getX() - getSpecialTableX()) > 2) {
                facing = isLeftSide ? "left" : "right";
                move();
                return;
            }
            pathStage = 2;
        }
        
        moveDirectlyToTargetTable();
    }
    
    // the pathways
    private void followBottomSpecialTablePath() {
        if (pathStage == 0) {
            if (Math.abs(getY() - TOP_ROW_Y) > 2) {
                facing = "down";
                move();
                return;
            }
            pathStage = 1;
        }
        
        if (pathStage == 1) {
            if (Math.abs(getX() - getSpecialTableX()) > 2) {
                facing = isLeftSide ? "left" : "right";
                move();
                return;
            }
            pathStage = 2;
        }
        
        moveDirectlyToTargetTable();
    }
    
    // the pathways
    private void moveDirectlyToTargetTable() {
        int targetX = targetTable.getX();
        int targetY = targetTable.getY() - 80;
        
        if (Math.abs(getX() - targetX) > 2) {
            if (getX() < targetX) {
                facing = "right";
                move();
            } else {
                facing = "left";
                move();
            }
        } else if (Math.abs(getY() - targetY) > 2) {
            if (getY() < targetY) {
                facing = "down";
                move();
            } else {
                facing = "up";
                move();
            }
        } else {
            seated = true;
            faceFront();
        }
    }
    
    private void showOrderIcon() {
        if (orderIcon == null) {
            orderIcon = new OrderIcon();
            getWorld().addObject(orderIcon, getX() + 70, getY() - 70);
        }
    }

    private void faceFront() {
        facing = "down";
        lastFacing = "down";
        walkingIndex = 0;
        if (walkDown != null && walkDown.length > 0) {
            setImage(walkDown[0]);
        }
    }
    
    public boolean hasOrdered(){
        return ordered;
    }
    
    public void setOrdered(boolean value){
        ordered = value;
        if (!value) {
            claimedByWaiter = false;
        }
    }
    
    public void setServed(boolean value){
        served = value;
    }

    public boolean isClaimedByWaiter() {
        return claimedByWaiter;
    }

    public void setClaimedByWaiter(boolean value) {
        claimedByWaiter = value;
    }
    
    public void leaveRestaurant(){
        if(orderIcon != null){
            getWorld().removeObject(orderIcon);
            orderIcon = null;
        }
        
        if (targetTable != null) {
            targetTable.setOccupied(false);
        }
        
        if(!gaveMoney){
            // Add the coin
            getWorld().addObject(new Money(), getX() + 40, getY());
            gaveMoney = true;
        }
        
        if(!at(entryX, ENTRY_Y)){
            moveTo(entryX, ENTRY_Y);
        }else{
            getWorld().removeObject(this);
        }
        }

    public boolean isOnLeftSide() {
        return isLeftSide;
    }

    private int getSpecialTableX() {
        return isLeftSide ? LEFT_SPECIAL_X : RIGHT_SPECIAL_X;
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
    
    public boolean at(int x, int y){
        return Math.abs(getPreciseX() - x) < 5 && Math.abs(getPreciseY() - y) < 5;
    }
}
