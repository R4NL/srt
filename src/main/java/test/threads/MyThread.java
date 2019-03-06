package test.threads;

import test.signal.GenerateSignal;

public class MyThread implements Runnable {
    private double w;
    private double t;
    private ThreadCreator tc;

    public MyThread() {
    }

    public MyThread(double w, double t, ThreadCreator tc) {
        this.w = w;
        this.t = t;
        this.tc = tc;
    }

    @Override
    public void run() {
        tc.setRes(GenerateSignal.get().garm(t, w));
    }
}
