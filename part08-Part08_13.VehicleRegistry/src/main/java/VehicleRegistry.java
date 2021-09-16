
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ricardo
 */
public class VehicleRegistry {

    private final HashMap<LicensePlate, String> licensePlate;

    public VehicleRegistry() {
        this.licensePlate = new HashMap<>();
    }

    public boolean add(LicensePlate licensePlate, String owner) {
        if (this.licensePlate.get(licensePlate) == null) {
            this.licensePlate.put(licensePlate, owner);
            return true;
        }
        return false;
    }

    public String get(LicensePlate licensePlate) {
        return this.licensePlate.get(licensePlate);
    }

    public boolean remove(LicensePlate licensePlate) {
        if (this.licensePlate.containsKey(licensePlate)) {
            this.licensePlate.remove(licensePlate);
            return true;
        }
        return false;
    }

    public void printLicensePlates() {
        for (LicensePlate plate : this.licensePlate.keySet()) {
            System.out.println(plate);
        }
    }

    public void printOwners() {
        List<String> checkOwner = new ArrayList<>();

        for (String owner : this.licensePlate.values()) {
            String owners = owner;
            if (!checkOwner.contains(owners)) {
                checkOwner.add(owners);
            }

        }
        for (int i = 0; i < checkOwner.size(); i++) {
            System.out.println(checkOwner.get(i));
        }

    }
}
