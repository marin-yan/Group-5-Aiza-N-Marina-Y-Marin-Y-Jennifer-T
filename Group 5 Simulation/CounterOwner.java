import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CounterOwner here.
 * 
 * @author (Jennifer) 
 * @version (a version number or a date)
 */
public class CounterOwner extends Actor
{
    public CounterOwner(int num){
        if(num == 0){
            setImage("images/counterOwner/0.png");
        }else if(num == 1){
            setImage("images/counterOwner/1.png");
        }else if(num == 2){
            setImage("images/counterOwner/2.png");
        }else if(num == 3){
            setImage("images/counterOwner/3.png");
        }
        getImage().scale(100, 100);
    }
}
