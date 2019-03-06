package test.threads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThreadCreator {
    private List<List<Double>> res =
            Collections.synchronizedList(new ArrayList<List<Double>>());

    public static ThreadCreator create() {
        return new ThreadCreator();
    }

    public List<List<Double>> startThread(int t, int n, int wp) {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            threads.add(new Thread(new MyThread((wp / (i + 1)), t,
                    this)));
        }
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return res;
    }

    public List<List<Double>> getRes() {
        return res;
    }

    public void setRes(List<Double> a) {
        this.res.add(a);
    }
}