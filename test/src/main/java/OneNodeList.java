import java.awt.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

class OneNodeList {
    OneNodeList next;

    private boolean hasNext() {

        return next != null;
    }

    public void invertAll(OneNodeList previous) {
        if (this.hasNext()) {
            this.next.invertAll(this);
        }
        this.next = previous;
//        Singleton.INSTANCE.getKHljlkj();
        final Queue<String> sg = new ArrayBlockingQueue<String>(10);
    }

    @Override
    public String toString() {
        return "OneNodeList{" +
                "next=" + next +
                '}';
    }
}
