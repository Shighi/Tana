package OOPS_tutorial;

/**
 * Base class Bicycle demonstrating inheritance concept
 * Inheritance: Mechanism where one class acquires properties and behaviors of another class
 */
class Bicycle {
    // Protected fields - accessible to subclasses
    protected int gear;
    protected int speed;
    
    /**
     * Bicycle constructor
     * @param startSpeed Initial speed
     * @param startGear Initial gear
     */
    public Bicycle(int startSpeed, int startGear) {
        gear = startGear;
        speed = startSpeed;
    }
    
    public void setGear(int newValue) {
        gear = newValue;
    }
    
    public void applyBrake(int decrement) {
        speed -= decrement;
    }
    
    public void speedUp(int increment) {
        speed += increment;
    }
}

/**
 * Derived class MountainBike extending Bicycle
 * Demonstrates inheritance: MountainBike inherits from Bicycle
 */
class MountainBike extends Bicycle {
    private int seatHeight;
    
    /**
     * MountainBike constructor
     * @param startHeight Initial seat height
     * @param startSpeed Initial speed (passed to parent)
     * @param startGear Initial gear (passed to parent)
     */
    public MountainBike(int startHeight, int startSpeed, int startGear) {
        // super() calls the parent class constructor
        super(startSpeed, startGear);
        seatHeight = startHeight;
    }
    
    public void setHeight(int newValue) {
        seatHeight = newValue;
    }
    
    public int getSeatHeight() {
        return seatHeight;
    }
}

/**
 * Main class to demonstrate inheritance concept
 */
public class InheritanceDemo {
    public static void main(String[] args) {
        // Create MountainBike object which inherits from Bicycle
        MountainBike mb = new MountainBike(20, 10, 1);
        
        // Access inherited properties from Bicycle
        System.out.println("Gear is: " + mb.gear);
        System.out.println("Seat height is: " + mb.getSeatHeight());
        System.out.println("Bike speed is: " + mb.speed);
        
        // Call inherited method from Bicycle
        mb.applyBrake(1);
        System.out.println("Bike speed after applying brakes: " + mb.speed);
    }
}