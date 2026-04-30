import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Small order icon shown above a seated customer.
 * Author: Marin
 */
public class OrderIcon extends Actor
{
    private GreenfootImage baseImage;

    public OrderIcon()
    {
        baseImage = new GreenfootImage("Menu/order.png");
        baseImage.scale(150, 150);
        setImage(baseImage);
    }

    public void setFoodImage(GreenfootImage foodImage)
    {
        GreenfootImage combinedImage = new GreenfootImage(baseImage);
        GreenfootImage scaledFoodImage = new GreenfootImage(foodImage);
        scaledFoodImage.scale(60, 60);
        combinedImage.drawImage(scaledFoodImage, 47, 33);
        setImage(combinedImage);
    }
}
