package test.signal;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenerateSignal {
    private Random random;
    private double ap;
    private double w;
    private double fip;


    public GenerateSignal() {
        random = new Random();
        ap = getRandom(1);
        fip = getRandom(2 * Math.PI);
    }

    public static GenerateSignal get() {
        return new GenerateSignal();
    }

    public List<Double> garm(double t, double w) {
        List<Double> res = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            res.add(ap * Math.sin(w * i + fip));
        }
        return res;
    }

    private double getRandom(double max) {
        double res = random.nextDouble();
        if (res > max) {
            return getRandom(max);
        } else {
            return res;
        }
    }
}
