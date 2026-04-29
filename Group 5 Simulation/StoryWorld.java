import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class StoryWorld here.
 * 
 * @author (Marina with help from Aiza) 
 * @version (a version number or a date)
 */
public class StoryWorld extends World
{
    private GreenfootImage ownerImage;
    private TextLine[] fullText = {
        new TextLine("Gordon Ramsay", "Welcome back to the long awaited finale of the 25th season of Hell's Kitchen! I hope you're hungry because our 2 finalist will be cooking up some delicious dished for everyone."),
        new TextLine("Gordon Ramsay", "Today the two owners will be competing against each other to prove they have what it takes to be the best restaurant, taking home the 'I won season 25 of Hell's Kitchen sponsored by Raid: Shadow Legends, Grammarly, Hello Fresh, and Honey' award."),
        new TextLine("Gordon Ramsay", "BUT! There will be challenges... food poisoning, angry customers, and more suprises. How will they handle it? Will they overcome the challenges? Where is the lamb sauce? So many questions but I guess we'll find out the answers in a few minutes."),
        new TextLine("Gordon Ramsay", "Now, are you ready to compete to become this season's winner?"),
        new TextLine("Owner", "YES CHEF!"),
        new TextLine("Gordon Ramsay", "Let's begin by choosing some customization! Be careful and don't be an idiot sandwich with your choices. Each option may change your fate... But before that let's hear a few words from our sponsors!")
    };
    private int currentLine = 0;
    private String displayedText = "";
    // counts characters displayed in current line 
    private int charCount = 0;
    // controls dialogue speed
    private int delayCounter = 0;
    private GreenfootImage background;
    private boolean lineComplete = false;
    
    // position of text displayed
    private int textStartX = 130;
    private int textStartY = 570;
    // max characters in a line before continues in next line
    private int charsPerLine = 68; 
    private int lineHeight = 40;
    
    private ContinueButton continueButton;
    private boolean buttonAdded = false;
    
    private GreenfootSound[] dialogueSound;
    private int dialogueSoundIndex = 0;
    
    /**
     * Constructor for objects of class StoryWorld.
     * 
     */
    public StoryWorld()
    {    
        // Create a new world with 1200x800 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1); 
        background = new GreenfootImage("images/Background/StoryWorld.png");
        setBackground(background);
        Greenfoot.setWorld(this);
        
        dialogueSound = new GreenfootSound[20]; 
        for (int i = 0; i < dialogueSound.length; i++) {
            dialogueSound[i] = new GreenfootSound("dialogue.wav");
            dialogueSound[i].setVolume(60);
        }
        
        addObject (new GordonRamsay(), 350, 300);
        
        ownerImage = new GreenfootImage("images/owner0/down1.png");
        ownerImage.scale(370, 380); 
        // make the image an actor in order to resize and add into world without changing animation and sizes in RestaurantWorld
        Actor owner = new Actor() { }; 
        owner.setImage(ownerImage);
        addObject(owner, 850, 340);
        
        continueButton = new ContinueButton(this);
    }
    
    public void act() {
        // checks if line not completed and if there's more characters to type
        if (!lineComplete && charCount < fullText[currentLine].message.length()) {
            delayCounter++;
            // delay each character display by 1 frame
            if (delayCounter >= 1) {
                delayCounter = 0;
                charCount++;
                displayedText = fullText[currentLine].message.substring(0, charCount);
                updateWorldText();
                
                dialogueSound[dialogueSoundIndex].play();
                dialogueSoundIndex++;
                if (dialogueSoundIndex >= dialogueSound.length) {
                    dialogueSoundIndex = 0;
                }
            }
            
        } else if (!lineComplete && charCount >= fullText[currentLine].message.length()) {
            lineComplete = true;
            updateWorldText();
            
            // checks if button is added and adds one if it isn't
            if (!buttonAdded && continueButton != null) {
                addObject(continueButton, getWidth() - 100, getHeight() - 40);
                buttonAdded = true;
            }
        }
    }
    
    public void nextDialogue() {
        buttonAdded = false;
        currentLine++;
        
        // switches to CustomizeWorld once no more lines left 
        if (currentLine >= fullText.length) {
            Greenfoot.setWorld(new CustomizeWorld());
            return;
        }
        
        // resets variables for new dialogue
        charCount = 0;
        displayedText = "";
        lineComplete = false;
        updateWorldText();
    }
    
    private void updateWorldText() {
        setBackground(new GreenfootImage(background));
        
        GreenfootImage bg = getBackground();
        bg.setFont(new Font("Courier New", true, false, 20));
        
        // Draw speaker name
        bg.setFont(new Font("Courier New", false, false, 24));
        bg.setColor(Color.BLACK);        
        bg.drawString(fullText[currentLine].speaker + ":", textStartX, textStartY);
        
        // Draw message
        bg.setFont(new Font("Courier New", false, false, 24));
        bg.setColor(Color.BLACK);
        
        String[] lines = wrapText(displayedText, charsPerLine);
        int y = textStartY + lineHeight;
        
        for (String line: lines) {
            bg.drawString(line, textStartX, y);
            y += lineHeight;
        }
        
    }
    
    private String[] wrapText(String text, int charsPerLine) {
        if (text.length() <= charsPerLine) {
            return new String[] {text};
        }
        
        ArrayList<String> lines = new ArrayList<>();
        int start = 0;
        
        while (start < text.length()) {
            int end = Math.min(start + charsPerLine, text.length());
            
            if (end < text.length() && text.charAt(end) != ' ') {
                int lastSpace = text.lastIndexOf(' ', end);
                if (lastSpace > start) {
                    end = lastSpace;
                }
            }
            
            lines.add(text.substring(start, end));
            start = end;
            if (start < text.length() && text.charAt(start) == ' ') {
                start++;
            }
        }
        return lines.toArray (new String[0]);
    }
    
    // Helper class for text lines
    private class TextLine {
        String speaker;
        String message;
        
        TextLine(String speaker, String message) {
            this.speaker = speaker;
            this.message = message;
        }
    }
}