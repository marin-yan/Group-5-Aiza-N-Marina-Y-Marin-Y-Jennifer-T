import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CustomizeWorld here.
 * 
 * @author (Jennifer and Marin)
 * Credit: Pinterest "Bg for edits" - zeee
 *         Pinterest -JUNGLORS
 * @version (a version number or a date)
 */
public class CustomizeWorld extends World
{
    // Background 
    private GreenfootImage background; // brown
    private GreenfootImage bg; // white
    private GreenfootImage bg1;
    
    // Characters
    private int character1 = 0;
    private CharacterDisplay display1;
    private int character2 = 0;
    private CharacterDisplay display2;
    
    // Waiter Count
    private int value1 = 0;
    private WaiterCount displayI;
    private int value2 = 0;
    private WaiterCount displayII;
    
    // Waiter Speed
    private int valueOne = 0;
    private WaiterCount displayOne;
    private int valueTwo = 0;
    private WaiterCount displayTwo;
    
    
    private Button readyButton;
    
    /**
     * Constructor for objects of class CustomizeWorld.
     * 
     */
    public CustomizeWorld()
    {    
        // Create a new world with 1200x800 cells with a cell size of 1x1 pixels.
        // Set up backgrounds
        super(1200, 800, 1);
        background = new GreenfootImage("images/Background/customizeWorldbg.JPG");
        bg = new GreenfootImage("images/Background/characterBg.png");
        bg1 = new GreenfootImage("images/Background/characterBg.png");
        bg1.mirrorHorizontally();
        background.drawImage(bg, -25, -100);
        background.drawImage(bg1, 575, -100);
        setBackground(background);
        
        // Black Text
        GreenfootImage textBg = getBackground();
        textBg.setColor(Color.BLACK);
        textBg.setFont(new Font(25)); //"FontName, bold, italic, size"
        textBg.drawString("Waiter Count", 140, 545);
        textBg.drawString("Waiter Speed", 140, 625);
        textBg.drawString("Waiter Count", 750, 545);
        textBg.drawString("Waiter Speed", 750, 625);
        
        // Left display 
        display1 = new CharacterDisplay(character1);
        addObject(display1, 280, 300);
        addObject(new ArrowButton(1, -1), 190, 405);
        addObject(new ArrowButton(1, 1), 395,405);
        
        displayI = new WaiterCount(value1);
        addObject(displayI, 392, 535);
        
        displayOne = new WaiterCount(valueOne);
        addObject(displayOne, 392, 615);
    
        
        // Right display
        display2 = new CharacterDisplay(character2);
        addObject(display2, 880, 300);
        addObject(new ArrowButton(2, -1), 790, 405);
        addObject(new ArrowButton(2, 1), 995, 405);
        
        displayII = new WaiterCount(value2);
        addObject(displayII, 992, 535);
        displayTwo = new WaiterCount(valueTwo);
        addObject(displayTwo, 992, 615);
        
        addObject(new AdjustmentButton(1, -1, 1), 340, 535);
        addObject(new AdjustmentButton(1, 1, 1), 445, 535);
        addObject(new AdjustmentButton(2, -1, 1), 940, 535);
        addObject(new AdjustmentButton(2, 1, 1), 1045, 535);
        
        
        addObject(new AdjustmentButton(1, -1, 2), 340, 615);
        addObject(new AdjustmentButton(1, 1, 2), 445, 615);
        
        addObject(new AdjustmentButton(2, -1, 2), 940, 615);
        addObject(new AdjustmentButton(2, 1, 2), 1045, 615);
        
        // ready Button
        readyButton = new Button("Ready", 150);
        addObject(readyButton, 1123, 772);
    }
    
    public void changeCharacter(int player, int direction){
        if(player == 1){
            character1 += direction;
            
            if(character1 > 3){
                character1 = 0;
            }
            
            if(character1 < 0){
                character1 = 3;
            }
            
            removeObject(display1);
            display1 = new CharacterDisplay(character1);
            if(character1 == 0){
                addObject(display1, 280, 300);
            }else if(character1 == 1){
                addObject(display1, 285, 285);
            }else{
                addObject(display1, 295, 290);
            }
        }
        
        if(player == 2){
            character2 += direction;
            
            if(character2 > 3){
                character2 = 0;
            }
            
            if(character2 < 0){
                character2 = 3;
            }
            
            removeObject(display2);
            display2 = new CharacterDisplay(character2);
            if(character2 == 0){
                addObject(display2, 880, 300);
            }else if(character2 == 1){
                addObject(display2, 885, 285);
            }else{
                addObject(display2, 895, 290);
            }
        }
    }
    
    public void changeWaiterCount(int value, int direction){
        // modifying waiter count for option 1
        if(value == 1){
            // increase or decrease the value based on direction
            value1 += direction;
            
            // prevent the value from going above 3
            if(value1 > 3){
                value1 = 3;
            }
            
            // prevent the value from going below 0
            if(value1 < 0){
                value1 = 0;
            }
            
            // remove the old object
            removeObject(displayI);
            
            // create a new display
            displayI = new WaiterCount(value1);
            addObject(displayI, 392, 535);
        }
        
        if(value == 2){
            value2 += direction;
            
            if(value2 > 3){
                value2 = 3;
            }
            
            if(value2 < 0){
                value2 = 0;
            }
            
            removeObject(displayII);
            displayII = new WaiterCount(value2);
            addObject(displayII, 992, 535);
        }
    }
    
    public void changeWaiterSpeed(int value, int direction){
        if(value == 1){
            valueOne += direction;
            
            if(valueOne > 3){
                valueOne = 3;
            }
            
            if(valueOne < 0){
                valueOne = 0;
            }
            
            removeObject(displayOne);
            displayOne = new WaiterCount(valueOne);
            addObject(displayOne, 392, 615);
        }
        
        if(value == 2){
            valueTwo += direction;
            
            if(valueTwo > 3){
                valueTwo = 3;
            }
            
            if(valueTwo < 0){
                valueTwo = 0;
            }
            
            removeObject(displayTwo);
            displayTwo = new WaiterCount(valueTwo);
            addObject(displayTwo, 992, 615);
        }
    }
    
    public void act(){
        if(Greenfoot.mouseClicked(readyButton)){
            Greenfoot.setWorld(new RestaurantWorld(character1, character2, value1 + 1, value2 + 1, valueOne + 1, valueTwo + 1));
        }
    }
}
