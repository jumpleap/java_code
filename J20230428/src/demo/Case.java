package demo;

public class Case {
    public static void main(String[] args) {
        drawMaps();
            /*Cycle cycle = new Cycle();
            Rect rect = new Rect();
            Flower flower = new Flower();

            drawMap(cycle);
            drawMap(rect);
            drawMap(flower);*/
    }

    public static void drawMap(Shape shape) {
        shape.draw();
    }

    public static void drawMaps1() {
        Cycle cycle = new Cycle();
        Rect rect = new Rect();
        Flower flower = new Flower();

        String[] strings = {"cycle", "rect", "cycle", "rect", "flower"};
        for (String s : strings) {
            if (s.equals("cycle")) {
                cycle.draw();
            } else if (s.equals("rect")) {
                rect.draw();
            } else {
                flower.draw();
            }
        }
    }

    public static void drawMaps() {
        Cycle cycle = new Cycle();
        Rect rect = new Rect();
        Flower flower = new Flower();
        Triangle triangle = new Triangle();

        Shape[] shapes = {cycle, rect, flower, triangle};
        for (Shape shape : shapes) {
            shape.draw();
        }
    }
}


class Shape {
    public void draw() {
        System.out.println("画图形！");
    }
}

class Rect extends Shape {
    @Override
    public void draw() {
        System.out.println("矩形");
    }
}

class Cycle extends Shape {
    @Override
    public void draw() {
        System.out.println("圆");
    }
}

class Flower extends Shape {
    @Override
    public void draw() {
        System.out.println("❀");
    }
}

class Triangle extends Shape {
    @Override
    public void draw() {
        System.out.println("△");
    }
}