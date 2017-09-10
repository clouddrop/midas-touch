package design.parking;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by samar.kumar on 9/10/17.
 */
public class ParkingLot {



    Map<ParkingType, Integer> parkingCapacityCache= new HashMap<>();
    Map<Vehicle, ParkingType> vehicleParkingMap  = new HashMap<>();

    private  Validator validator ;


    public  void ParkingLot(List<ParkingType> listOfParking, List<Integer>  parkingSlots ){
        int index = 0;
        for (ParkingType eachParking : listOfParking){
            parkingCapacityCache.put(eachParking, parkingSlots.get(index++));
        }


    }


    boolean addToParking(Vehicle vehicle){

        for (ParkingType eachParking: parkingCapacityCache.keySet()){
            if (parkingCapacityCache.get(eachParking) == 0 ){
                System.out.println("ParkingType Full for Type " + eachParking.);
            }else if(validator.isAllowd(vehicle , eachParking)){
                parkingCapacityCache.put(eachParking , parkingCapacityCache.get(eachParking) -1);
                vehicleParkingMap.put(vehicle , eachParking);
                return true;
            }

        }
        return false;

    }


    boolean removeFromParking(Vehicle vehicle){
        if (vehicleParkingMap.containsKey(vehicle)){
            ParkingType parkingType = vehicleParkingMap.get(vehicle);
            parkingCapacityCache.put(parkingType , parkingCapacityCache.get(parkingType) -1);
            vehicleParkingMap.remove(vehicle);

        }else {
            return false;
        }
    }
}
