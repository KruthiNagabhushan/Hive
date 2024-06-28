package world;

import bee.Drone;
import bee.Queen;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * The queen's chamber is where the mating ritual between the queen and her drones is conducted.
 * The drones will enter the chamber in order. I
 * f the queen is ready and a drone is in here, the first drone will be summoned and mate with the queen.
 * Otherwise the drone has to wait.
 * After a drone mates they perish, which is why there is no routine for exiting (like with the worker bees and the flower field).
 *
 * @author kruthinagabhushan
 * @author Sreenivas Reddy Sagili
 *
 */
public class QueensChamber {

    private ConcurrentLinkedQueue<Drone> droneList;

    /**
     * constructor to initialize the list to hold all drones entering the chamber
     */
    public QueensChamber() {
        droneList = new ConcurrentLinkedQueue<>();
    }

    /**
     * A drone enters the chamber.
     *
     * @param drone drone that has entered
     */
    public synchronized void enterChamber(Drone drone) {
        System.out.println("*QC* " + drone + " enters chamber");
        droneList.add(drone);
        //loop to check if the drone has to wait or ready to wait
        while (!Queen.queenReady || !drone.equals(droneList.peek())) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // drone exiting
        droneList.remove();
        System.out.println("*QC* " + drone + " leaves chamber");
    }

    /**
     * When the queen is ready, they will summon the next drone from the collection (if at least one is there).
     */
    public synchronized void summonDrone() {
        if (!droneList.isEmpty()) {
            System.out.println("*QC* Queen mates with" + droneList.peek());
            notifyAll();
            droneList.peek().setMated();

        }
    }

    /**
     * At the end of the simulation the queen uses this routine repeatedly to dismiss all the drones that were waiting to mate.
     */
    public synchronized void dismissDrone() {
        notifyAll();
    }


    /**
     * method to check if there are drones in list.
     *
     * @return boolean true if list is not empty
     */
    public boolean hasDrone() {
        return !droneList.isEmpty();
    }


}
