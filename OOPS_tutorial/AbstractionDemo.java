package OOPS_tutorial;

/**
 * Abstract class GraphicObject demonstrating abstraction
 * Abstraction: Hiding implementation details and showing only functionality
 */
abstract class GraphicObject {
    int x, y;
    
    // Concrete method with implementation
    void moveTo(int newX, int newY) {
        x = newX;
        y = newY;
    }
    
    // Abstract methods - no implementation, must be implemented by subclasses
    abstract void draw();
    abstract void resize();
}

/**
 * Concrete class Circle extending GraphicObject
 * Must implement all abstract methods from parent
 */
class Circle extends GraphicObject {
    @Override
    void draw() {
        System.out.println("Drawing a circle");
    }
    
    @Override
    void resize() {
        System.out.println("Resizing a circle");
    }
}

/**
 * Concrete class Rectangle extending GraphicObject
 * Must implement all abstract methods from parent
 */
class Rectangle extends GraphicObject {
    @Override
    void draw() {
        System.out.println("Drawing a rectangle");
    }
    
    @Override
    void resize() {
        System.out.println("Resizing a rectangle");
    }
}

/**
 * Main class to demonstrate abstraction concept
 */
public class AbstractionDemo {
    public static void main(String[] args) {
        // Create objects but reference them as GraphicObject (abstraction)
        GraphicObject circle = new Circle();
        GraphicObject rectangle = new Rectangle();
        
        // Call methods without knowing specific implementation
        circle.draw();
        circle.resize();
        
        rectangle.draw();
        rectangle.resize();
    }
}