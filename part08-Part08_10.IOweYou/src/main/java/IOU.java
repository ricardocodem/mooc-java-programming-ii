
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ricardo
 */
public class IOU {

    private HashMap<String, Double> iouMap;

    public IOU() {
        this.iouMap = new HashMap<>();
    }

    public void setSum(String toWhom, double amount) {
        this.iouMap.put(toWhom, amount);
    }

    public double howMuchDoIOweTo(String toWhom) {
        // return iouMap.getOrDefault(toWhom, 0.0);
        for (String key : iouMap.keySet()) {
            if (key.contains(toWhom)) {
                return iouMap.get(key);
            }
        }
        return 0;
    }
}
