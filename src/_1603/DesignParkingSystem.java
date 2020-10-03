package _1603;
/*
* Created by Rebecca Dsouza on 10/3/20
*/
public class DesignParkingSystem {
    public static void main(String[] args){
        ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);
        System.out.println(parkingSystem.addCar(1)); // return true because there is 1 available slot for a big car
        System.out.println(parkingSystem.addCar(2)); // return true because there is 1 available slot for a medium car
        System.out.println(parkingSystem.addCar(3)); // return false because there is no available slot for a small car
        System.out.println(parkingSystem.addCar(1)); // return false because there is no available slot for a big car. It is already occupied.
    }
}
class ParkingSystem {
    int[] space;
    public ParkingSystem(int big, int medium, int small) {
        space = new int[]{big,medium,small};
    }
    public boolean addCar(int carType) {
        int index = carType-1;
        if(space[index]>0){
            space[index]--;
            return true;
        }
        else return false;
    }
}