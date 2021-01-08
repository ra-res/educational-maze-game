package Assignment2.Shapes;

public class ShapeFactory {

    public Shape getShape(char shapeType) {
        if (shapeType == '#') {
            return new MazeWall();

        } else if (shapeType == 'X') {
            return new Player();

        } else if (shapeType == 'C') {
            return new Covid();

        } else if (shapeType == ' ') {
            return new Path();
        } else if (shapeType == 'G') {
            return new EscapeGate();
        }
        return null;
    }
}
