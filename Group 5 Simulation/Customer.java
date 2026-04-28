import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Customer here.
 * 
 * @author (Jennifer, Marin) 
 * @version (a version number or a date)
 */
public class Customer extends SuperSmoothMover
{
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
    
    // Initial direction
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
    private int pathStage = 0;
    private boolean isLeftSide = true;
    private int entryX = LEFT_ENTRY_X;
    
    private Menu menu = new Menu();
    private OrderIcon orderIcon;
    private int orderedFoodIndex;
    private boolean ordered = false;
    private boolean served = false;
    private boolean gaveMoney = false;

    
    public Customer() {
        setImage("customer.png");
    }
    
    public void addedToWorld(World world) {
        setLocation(entryX, ENTRY_Y);
    }
    
    public void act()  {
        if (!seated && targetTable != null ){
            moveToTable();
        }else if (served){
            leaveRestaurant();
        }else if (seated){
            showOrderIcon();
            orderFood();
        }
    }
    
    private void walkToCounter() {
        if (atCounter)
        {
            return;
        }
        
        double dx = COUNTER_X - getPreciseX();
        double dy = COUNTER_Y - getPreciseY();
        double distance = Math.sqrt(dx * dx + dy * dy);
        
        if (distance <= WALK_SPEED)
        {
            setLocation(COUNTER_X, COUNTER_Y);
            atCounter = true;
            return;
        }
        
        double stepX = (dx / distance) * WALK_SPEED;
        double stepY = (dy / distance) * WALK_SPEED;
        setLocation(getPreciseX() + stepX, getPreciseY() + stepY);
    }
    
    public void orderFood() {
        if(ordered){
            return;
        }
        
        orderedFoodIndex = Greenfoot.getRandomNumber(menu.getMenuSize());
        int randomOrder = Greenfoot.getRandomNumber(menu.getMenuSize()) + 1;
        
        if (randomOrder == 1) {
            orderedFoodIndex = 0;
        } else if (randomOrder == 2) {
            orderedFoodIndex = 1;
        }
        
        GreenfootImage orderedImage = menu.getMenuImages()[orderedFoodIndex];
        orderIcon.setImage(orderedImage);
        
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
    
    public void setTargetTable (Table table) {
        targetTable = table;
        pathStage = 0;
        if (targetTable != null) {
            targetTable.setOccupied(true);
        }
    }
    
    public void configureSide(boolean isLeftSide) {
        this.isLeftSide = isLeftSide;
        entryX = isLeftSide ? LEFT_ENTRY_X : RIGHT_ENTRY_X;
    }
    
    public void moveToTable() {
        if (isTopSpecialTableTarget()) {
            followTopSpecialTablePath();
            return;
        }
        
        if (isBottomSpecialTableTarget()) {
            followBottomSpecialTablePath();
            return;
        }
        
        int targetX = targetTable.getX();
        int targetY = targetTable.getY() - 40;
        
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
        }
    }
    
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
    
    private void moveDirectlyToTargetTable() {
        int targetX = targetTable.getX() - 60;
        int targetY = targetTable.getY() - 30;
        
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
        }
    }
    
    private void showOrderIcon() {
        if (orderIcon == null) {
            orderIcon = new OrderIcon();
            getWorld().addObject(orderIcon, getX() + 70, getY() - 70);
        }
    }
    
    public boolean hasOrdered(){
        return ordered;
    }
    
    public void setOrdered(boolean value){
        ordered = value;
    }
    
    public void setServed(boolean value){
        served = value;
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
