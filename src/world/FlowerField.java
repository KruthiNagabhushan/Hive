package world;
import bee.Worker;

/**
 * The field of flowers that are ripe for the worker bees to gather the nectar and pollen resources.
 * The bees can arrive in any order and they are immediately allowed to start gathering, as long as there is a free flower.
 * Otherwise the bee must wait until a flower becomes free.
 *
 * @author Kruthi Nagabhushan
 * @author Sreenivas Reddy Sagili
 */
public class FlowerField {
    /** the maximum number of workers allowed in the field at the same time */
    public static final int MAX_WORKERS = 10;

    /** counter variable to check maximum workers */
    public static int bee_count;

    /**
     * class constructor
     */
    public FlowerField() {
    bee_count=0;
    }

    /**
     * method where worker bee enters flower field
     * @param worker worker
     */
    public synchronized void enterField(Worker worker) {
        System.out.println("*FF* " + worker + " enters field");
        while (bee_count >= MAX_WORKERS) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        bee_count += 1;

    }

    /**
     * method for the worker bee to exit flower field
     * @param worker worker
     */
    public synchronized void exitField(Worker worker) {
        bee_count--;
        this.notifyAll();
        System.out.println("*FF* " + worker + " leaves field");

    }

}
