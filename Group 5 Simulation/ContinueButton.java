import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ContinueButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ContinueButton extends Button
{
    private StoryWorld storyWorld;
        
    public ContinueButton(StoryWorld world)
    {
        super("Continue", 120);
        this.storyWorld = world;
    }

    public void onClick()
    {
        storyWorld.nextDialogue();
    }
}
