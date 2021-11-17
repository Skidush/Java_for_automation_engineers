import java.util.Scanner;

// TODO FOR HOMEWORK: Write the entire Equilateral Triangle Class
//    NOTE: We will be expecting a correct Triangle class even though we aren't spelling out what to do.
//          Use all the information within the project and your knowledge base.
//          Feel free to get fancy and explore here, as long as you have the basics we won't discount anything extra
//          you might get wrong.
//    NOTE: An EquilateralTriangle has the same base for all 3 sides, and the height is always (sqrt(3)/2) * the base.
//          So the important thing to note is you will only need the base and you can calculate the height
public class EquilateralTriangle {
    private double base;

    /**
     * Creates an instance of the Triangle class
     * NOTE: Do not touch this method!
     */
    public EquilateralTriangle() {
    }

    public void setBase(double base) {
        if (base > 0) {
            this.base = base;
        }
    }

    public double getBase() {
        return base;
    }

    public double area() {
//        return (Math.sqrt(3)/4) * Math.pow(this.getBase(), 2);
        return ((Math.sqrt(3) * this.getBase() / 2) * this.getBase()) / 2;
    }

    public double perimeter() {
        return 3 * this.getBase();
    }

    public static void main(String[] args) {
        EquilateralTriangle et = new EquilateralTriangle();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the Equilateral Triangle's base length: ");

        double baseLength = scanner.nextDouble();

        et.setBase(baseLength);

        double area = et.area();
        double perimeter = et.perimeter();

        System.out.println("An Equilateral Triangle with a side length of " + et.getBase() + " has an area of: " + area);
        System.out.println("An Equilateral Triangle with a side length of " + et.getBase() + " has a perimeter of: " + perimeter);
    }

}