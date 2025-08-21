package OOPS_tutorial;

/**
 * Interface BicycleInterface demonstrating interface concept
 * Interface: Contract that defines methods a class must implement
 */
interface BicycleInterface {
    // Interface methods (implicitly public and abstract)
    void applyBrake(int decrement);
    void speedUp(int increment);
}

/**
 * Class MountainBikeInterface implementing BicycleInterface
 * Must implement all methods defined in the interface
 */
class MountainBikeInterface implements BicycleInterface {
    private int seatHeight;
    private int gear;
    private int speed;
    
    public MountainBikeInterface(int startHeight, int startSpeed, int startGear) {
        seatHeight = startHeight;
        speed = startSpeed;
        gear = startGear;
    }
    
    // Implementing interface methods
    @Override
    public void applyBrake(int decrement) {
        speed -= decrement;
    }
    
    @Override
    public void speedUp(int increment) {
        speed += increment;
    }
    
    // Additional methods specific to this class
    public int getSeatHeight() {
        return seatHeight;
    }
    
    public int getGear() {
        return gear;
    }
    
    public int getSpeed() {
        return speed;
    }
}

/**
 * Main class to demonstrate interface concept
 */
public class InterfaceDemo {
    public static void main(String[] args) {
        MountainBikeInterface mb = new MountainBikeInterface(20, 10, 1);
        
        System.out.println("Gear: " + mb.getGear());
        System.out.println("Seat height: " + mb.getSeatHeight());
        System.out.println("Speed: " + mb.getSpeed());
        
        // Using interface methods
        mb.applyBrake(1);
        System.out.println("Speed after brake: " + mb.getSpeed());
        
        mb.speedUp(10);
        System.out.println("Speed after acceleration: " + mb.getSpeed());
    }
}