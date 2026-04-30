import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Small order icon shown above a seated customer.
 * 
 * Credits: 
 *  orderSound - zapsplat.com Cartoon bubble pop, also good as a pop up tone 7
 */
public class OrderIcon extends Actor
{
    private GreenfootImage baseImage;
    
    private GreenfootSound[] orderSound;
    private int orderSoundIndex = 0;
    
    public OrderIcon()
    {
        baseImage = new GreenfootImage("Menu/order.png");
        baseImage.scale(150, 150);
        setImage(baseImage);
        
        orderSound = new GreenfootSound[10]; 
        for (int i = 0; i < orderSound.length; i++) {
            orderSound[i] = new GreenfootSound("order.wav");
            orderSound[i].setVolume(70); 
        }
        
        orderSound[orderSoundIndex].play();
        orderSoundIndex++;
        if (orderSoundIndex >= orderSound.length) {
            orderSoundIndex = 0;
        }
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
