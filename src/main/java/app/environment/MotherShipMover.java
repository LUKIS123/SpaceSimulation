package app.environment;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Class with methods for moving the mother ship.
 */
public class MotherShipMover {

    private static final Random random = new Random();


    public class Move {
        private int x;
        private int y;

        public Move(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }

    /**
     * Method for moving the ship to a given position.
     * @param motherShip The mother ship that is moved.
     * @param galaxy The galaxy in which the mother ship is moved.
     * @param deltaX Number answering how many x positions to move the ship.
     * @param deltaY Number answering how many y positions to move the ship.
     */
    public void move(MotherShip motherShip, Galaxy galaxy, int deltaX, int deltaY) {
        int x = motherShip.getPositionX();
        int y = motherShip.getPositionY();
        galaxy.getGrid().get(x).get(y).getMotherShips().remove(motherShip);
        motherShip.setPositionX(x + deltaX);
        motherShip.setPositionY(y + deltaY);
        galaxy.getGrid().get(x + deltaX).get(y + deltaY).getMotherShips().add(motherShip);

        int newX = motherShip.getPositionX();
        int newY = motherShip.getPositionY();
        System.out.println("\t\tShip moved from x=" + x + " y=" + y + " to x=" + newX + " y=" + newY);
    }

    /**
     * Randomly moves the ship +1 or 0 or -1 in both directions.
     * @param ship The mother ship that is moved.
     * @param galaxy The galaxy in which the mother ship is moved.
     */
    void randomMove(MotherShip ship, Galaxy galaxy) {
        List<Move> moves = new ArrayList<>();
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (ship.getPositionX() + i == -1 || ship.getPositionX() + i >= galaxy.getSizeX())
                    continue;
                if (ship.getPositionY() + j == -1 || ship.getPositionY() + j >= galaxy.getSizeY())
                    continue;
                moves.add(new Move(i, j));
            }
        }

        Move move = moves.get(random.nextInt(moves.size()));
        move(ship, galaxy, move.getX(), move.getY());
    }
}