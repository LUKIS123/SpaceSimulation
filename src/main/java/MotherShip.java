public class MotherShip {
    private int positionX;
    private int positionY;
    private int recourses;

    public void visitSolarSystem(SolarSystem solarSystem) {
    }

    public MotherShip(int positionX, int positionY, int recourses) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.recourses = recourses;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getRecourses() {
        return recourses;
    }

    public void setRecourses(int recourses) {
        this.recourses = recourses;
    }
}
