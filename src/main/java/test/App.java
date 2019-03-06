package test;


import test.data.Data;
import test.threads.ThreadCreator;
import test.window.Window;

import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Double> data =
                Data.create().sum(ThreadCreator.create().startThread(64, 6, 1200));
        double mo = Data.create().mathO(data);
        double disp = Data.create().disp(data, mo);
        Window.create().paint(data, mo, disp);
    }
}
