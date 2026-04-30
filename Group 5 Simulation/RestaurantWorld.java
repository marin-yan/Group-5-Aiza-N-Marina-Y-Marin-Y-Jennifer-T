import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (background image, tables, ovens - Jennifer) (Buttons + stat bar -- Aiza)
 * Credit: reference Pinterest "Animal restaurant app" - Kaleidos
 *         drew and created by Michelle T. (90%) & Jennifer T. (10%)
 *         Pinterest - ovens
 *         
 * @version (a version number or a date)
 */
public class RestaurantWorld extends World
{
    private static final int[][] LEFT_TABLE_ORDER = {
        {400, 500},
        {200, 500},
        {200, 650},
        {400, 650}
    };
    private static final int[][] RIGHT_TABLE_ORDER = {
        {800, 500},
        {1000, 500},
        {1000, 650},
        {800, 650}
    };

    // Set up background image variables
    private GreenfootImage backgroundImage_player1;
    private GreenfootImage backgroundImage_player2;
    private GreenfootImage background;
    private GreenfootImage bg;
    private GreenfootImage oven1;
    private GreenfootImage oven2;
    private int middleLineThickness;
    
    //variables for buttons
    private int player1Index = 0;
    private int player2Index = 0;
    
    // level: used for (tables setup)
    private int levelLeft = 1;
    private int levelRight = 1;
    
    // Characters chosen by the user
    private int character1;
    private int character2;
    private int waiterCountLeft;
    private int waiterCountRight;
    private int waiterSpeedLeft;
    private int waiterSpeedRight;
    
    // for customers
    private int spawnCounter = 0;
    private int spawnDelay = 300;
    private int maxCustomers = 4;
    
    //variables for stat bar 
    private CoinCounter leftCounter;
    private CoinCounter rightCounter;
    
    private LevelStatBar leftBar;
    private LevelStatBar rightBar;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public RestaurantWorld(int character1, int character2)
    {
        this(character1, character2, 1, 1, 1, 1);
    }

    public RestaurantWorld(int character1, int character2, int waiterCountLeft, int waiterCountRight)
    {
        this(character1, character2, waiterCountLeft, waiterCountRight, 1, 1);
    }

    public RestaurantWorld(int character1, int character2, int waiterCountLeft, int waiterCountRight, int waiterSpeedLeft, int waiterSpeedRight)
    {    
        // Create a new world with 1200x800 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1);
        
        // Set up characters 
        this.character1 = character1;
        this.character2 = character2;
        this.waiterCountLeft = waiterCountLeft;
        this.waiterCountRight = waiterCountRight;
        this.waiterSpeedLeft = waiterSpeedLeft;
        this.waiterSpeedRight = waiterSpeedRight;
        
        // Set up background image
        background = new GreenfootImage(getWidth(), getHeight());
        backgroundImage_player1 = new GreenfootImage("images/Background/backgroundImage_player1.png");
        backgroundImage_player2 = new GreenfootImage("images/Background/backgroundImage_player2.png");
        oven1 = new GreenfootImage("images/Background/oven1.png");
        oven2 = new GreenfootImage("images/Background/oven2.png");
        background.drawImage(backgroundImage_player1, 0, 0);
        background.drawImage(backgroundImage_player2, getWidth() / 2 - 20, 0);
        background.drawImage(oven1, -25, 655);
        background.drawImage(oven2, 1075, 660);
        setBackground (background);
        
        bg = getBackground();
        bg.setColor(new Color(139, 69, 19));
        middleLineThickness = 5;
        bg.fillRect((getWidth() / 2) - (middleLineThickness / 2), 0, middleLineThickness, getHeight());

        // Add the owners
        addObject(new Owner(character1, true), 390, 210);
        addObject(new Owner(character2, false), 810, 210);
        
        addWaiters(true, waiterCountLeft, waiterSpeedLeft);
        addWaiters(false, waiterCountRight, waiterSpeedRight);
        
        //Left side
        leftCounter = new CoinCounter();
        leftBar = new LevelStatBar();
        addObject(leftCounter, 120, 30);
        addObject(leftBar, 300, 30);
        
        //Right side
        rightCounter = new CoinCounter();
        rightBar = new LevelStatBar();
        addObject(rightCounter, 720, 30);
        addObject(rightBar, 900, 30);
        
        setPaintOrder(Waiter.class, OrderIcon.class, Customer.class, CheckIcon.class, Table.class);
        
        setupTables();
    }
    
    // Set up tables' positions according to the level
    public void setupTables(){
        if(levelLeft == 1){
            addObject(new Table(), 200, 500);
            addObject(new Table(), 400, 500);
            addObject(new Table(), 200, 650);
            addObject(new Table(), 400, 650);
        }else if(levelLeft == 2){
            addObject(new Table(), 150, 500);
            addObject(new Table(), 300, 500);
            addObject(new Table(), 450, 500);
            addObject(new Table(), 150, 650);
            addObject(new Table(), 300, 650);
            addObject(new Table(), 450, 650);
        }else if(levelLeft == 3){
            addObject(new Table(), 120, 500);
            addObject(new Table(), 240, 500);
            addObject(new Table(), 360, 500);
            addObject(new Table(), 480, 500);
            addObject(new Table(), 120, 650);
            addObject(new Table(), 240, 650);
            addObject(new Table(), 360, 650);
            addObject(new Table(), 480, 650);
        }
        
        if(levelRight == 1){
            addObject(new Table(), 800, 500);
            addObject(new Table(), 1000, 500);
            addObject(new Table(), 800, 650);
            addObject(new Table(), 1000, 650);
        }else if(levelRight == 2){
            addObject(new Table(), 750, 500);
            addObject(new Table(), 900, 500);
            addObject(new Table(), 1050, 500);
            addObject(new Table(), 750, 650);
            addObject(new Table(), 900, 650);
            addObject(new Table(), 1050, 650);
        }else if(levelRight == 3){
            addObject(new Table(), 720, 500);
            addObject(new Table(), 840, 500);
            addObject(new Table(), 960, 500);
            addObject(new Table(), 1080, 500);
            addObject(new Table(), 720, 650);
            addObject(new Table(), 840, 650);
            addObject(new Table(), 960, 650);
            addObject(new Table(), 1080, 650);
        }
    }
    
    public void changeBackground(int player, int direction)
    {
        if (player == 1)
        {
            player1Index += direction;
        }
        else
        {
            player2Index += direction;
        }
    
        //all the logic after this
    }
    
    public void act() {
        spawnCounter++;
        
        if (spawnCounter >= spawnDelay) {
            if (countCustomersOnSide(true) < maxCustomers) {
                spawnRandomCustomer(true);
            }
            
            if (countCustomersOnSide(false) < maxCustomers) {
                spawnRandomCustomer(false);
            }
            
            spawnCounter = 0;
        }
    }

    private void addWaiters(boolean isLeftSide, int waiterCount, int waiterSpeed) {
        int baseX = isLeftSide ? 100 : 1100;
        int baseY = 390;
        int spacing = 60;

        for (int i = 0; i < waiterCount; i++) {
            int waiterX = isLeftSide ? baseX + (i * spacing) : baseX - (i * spacing);
            addObject(new Waiter(isLeftSide, waiterSpeed), waiterX, baseY);
        }
    }
    
    private void spawnRandomCustomer(boolean isLeftSide) {
        Customer customer;
        int randomCustomer = Greenfoot.getRandomNumber(2) +1 ;
        
        if (randomCustomer == 1) {
            customer = new Frog();
        } else {
            customer = new Ghost();
        }
        
        customer.configureSide(isLeftSide);
        addObject(customer, isLeftSide ? 405 : 810, 210);
        Table nextTable = getNextTableInOrder(isLeftSide);

        if (nextTable != null) {
            customer.setTargetTable(nextTable);
        } else {
            removeObject(customer);
        }
    }
    
    public Table getNextTableInOrder(boolean isLeftSide) {
        java.util.List<Table> tables = getObjects(Table.class);
        int[][] tableOrder = isLeftSide ? LEFT_TABLE_ORDER : RIGHT_TABLE_ORDER;
        
        for (int i = 0; i < tableOrder.length; i++) {
            int targetX = tableOrder[i][0];
            int targetY = tableOrder[i][1];
            
            for (Table table : tables) {
                if (table.getX() == targetX && table.getY() == targetY && !table.isOccupied()) {
                    return table;
                }
            }
        }
        
        return null;
    }

    private int countCustomersOnSide(boolean isLeftSide) {
        java.util.List<Customer> customers = getObjects(Customer.class);
        int count = 0;
        
        for (Customer customer : customers) {
            if (customer.isOnLeftSide() == isLeftSide) {
                count++;
            }
        }
        
        return count;
    }
    
    //helper method
    public void addCoins(boolean isLeftTeam, int amount) {
        if(isLeftTeam) {
            leftCounter.addCoins(amount);
            leftBar.addCoins(amount);
        } else {
            rightCounter.addCoins(amount);
            rightBar.addCoins(amount);
        }
    }
}
