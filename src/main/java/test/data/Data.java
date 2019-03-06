package test.data;

import java.util.ArrayList;
import java.util.List;

public class Data {
    public static Data create() {
        return new Data();
    }

    public List<Double> sum(List<List<Double>> a) {
        if (a == null) {
            throw new IllegalArgumentException("Data sum get null argument !!!");
        }
        List<Double> res = new ArrayList<>();
        for (int i = 0; i < a.get(0).size(); i++) {
            double m = 0;
            for (List<Double> data : a) {
                m += data.get(i);
            }
            res.add(m);
        }
        return res;
    }

    public double disp(List<Double> a, double mo) {
        double c = 0;
        for (Double b : a) {
            c += Math.pow((b - mo), 2);
        }
        return c / a.size();
    }

    public double mathO(List<Double> a) {
        double mo = 0;
        for (Double b : a) {
            mo += b;
        }
        return mo / a.size();
    }
}
