import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Nick
 * Date: 25/02/13
 * Time: 18:59
 * To change this template use File | Settings | File Templates.
 */
public class ResponsiveUI implements Runnable {

    private int runTime;
    private int taskNum;
    private static List<Tracker> tasks;


    public ResponsiveUI(int taskNum, int runFor) {
        this.taskNum = taskNum;
        this.runTime = runFor;
    }

    public static void main(String args[]) {
        tasks = new ArrayList<Tracker>();
        Scanner in = new Scanner(System.in);
        int time = 0;

        for (int task = 0; task < 7; task++) {
            System.out.print("Enter the time in ms for task " + task + ": ");
            time = in.nextInt();
            tasks.add(new Tracker(task));

            ResponsiveUI r = new ResponsiveUI(task, time);
            r.showComplete();

            Thread t = new Thread(r);
            t.start();
        }
    }

    public void run() {
        Calendar endTime = Calendar.getInstance();
        endTime.add(Calendar.MILLISECOND, this.runTime);
        while (Calendar.getInstance().before(endTime)) {
            //System.out.println(this.taskNum);
        }
        tasks.get(this.taskNum).setComplete();
    }

    public void showComplete() {
        String output = "";
        for (int x = 0; x < tasks.size(); x ++) {
            if (tasks.get(x).isComplete()) {
                if (output.length() == 0) {
                    output = "Finished tasks: ";
                }
                output += tasks.get(x).taskNumber() + " ";
            }
        }
        if (output.length() > 0) {
            System.out.println(output);
        }
    }

}
