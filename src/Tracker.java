/**
 * Created with IntelliJ IDEA.
 * User: Nick
 * Date: 25/02/13
 * Time: 19:39
 * To change this template use File | Settings | File Templates.
 */
public class Tracker {

    private int taskNum;
    private boolean complete;

    public Tracker (int task) {
        this.taskNum = task;
        this.complete = false;
    }

    public void setComplete() {
        this.complete = true;
    }

    public boolean isComplete() {
        return this.complete;
    }

    public int taskNumber() {
        return this.taskNum;
    }
}
