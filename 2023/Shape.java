interface Shape {
    final double Pi = 3.14;
    double getArea();   
    double getPerimeter();
}
class Rectangle implements Shape {
    private int length = 5;
    private int width = 6;
    public void setLength(int length) {
        this.length = length;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public double getArea() {
        return length * width;
    }
    public double getPerimeter() {
        return 2 * (length + width);
    }
}
class Circle implements Shape {
    private int radius;
    public void setRadius(int radius) {
        this.radius = radius;
    }
    public double getArea() {
        return radius * radius * Pi;
    }
    public double getPerimeter() {
        return 2 * Pi * radius;
    }
}
class Main {
    public static void main(String[] args) {
        Rectangle r = new Rectangle();
        r.setLength(5);
        r.setWidth(6);
        Circle c = new Circle();
        c.setRadius(3);
        System.out.println(r.getArea() + " is rectangle's area.");
        System.out.println(c.getArea() + " is circle's area.");
        System.out.println(r.getPerimeter() + " is rectangle's perimeter.");
        System.out.println(c.getPerimeter() + " is circle's perimeter.");
    }
}
