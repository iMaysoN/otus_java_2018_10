/**
 * @author Igor on 13.03.19.
 */
public class SynchExample {
    private volatile String thr = "t2";

    public static void main(String[] args) {
        SynchExample exercise = new SynchExample();
        new Thread(() -> exercise.action("t1")).start();
        new Thread(() -> exercise.action("t2")).start();
    }

    private void action(String message) {
        boolean inc = false;
        int i = 1;
        StringBuilder sb = new StringBuilder(message + ":");
        while (true) {
            synchronized (this) {
                if (!thr.equals(message)) {
                    inc = (i == 10 || i == 1) != inc;
                    sb.append(" ").append(inc ? i++ : i--);
                    System.out.println(sb.toString());
                    thr = message;
                    sleep(1000);
                }
            }
        }
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
