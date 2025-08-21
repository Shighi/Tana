package OOPS_tutorial;

/**
 * Student class demonstrating encapsulation in Java
 * Encapsulation: Binding data (fields) and methods together while hiding implementation details
 */
public class Student {
    // Private fields - data is hidden from outside access (encapsulation)
    private String name;
    private int age;
    private String address;
    
    /**
     * Constructor to initialize Student object
     * @param name Student's name
     * @param age Student's age
     * @param address Student's address
     */
    public Student(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
    
    // Getter methods - provide controlled access to private fields
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    public String getAddress() {
        return address;
    }
    
    // Setter methods - provide controlled modification of private fields
    public void setName(String name) {
        this.name = name;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    /**
     * Overridden toString method to provide string representation of Student object
     * @return String representation of Student
     */
    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + ", address=" + address + "]";
    }
}