package app;

public class App {

    
    public static void main(String[] args) throws Exception {
        int[] input = Input.input;
        int fuelNeeded = calculateFuelNeeded(input);
        System.out.println(String.valueOf(fuelNeeded));
    }

    static int calculateFuelNeededPerModule(int mass, int fuelNeeded) {
        if (mass < 3 ){
            return fuelNeeded;
        } 
        else{
            int new_mass = mass / 3 - 2;
            if(new_mass < 0){
                new_mass = 0;
            }
            fuelNeeded += new_mass;
            return calculateFuelNeededPerModule(new_mass, fuelNeeded);
        }

    }

    static int calculateFuelNeeded(int[] totalMass) {
        int finalFuel = 0;
        for (int i = 0; i < totalMass.length; i++) {
            finalFuel += calculateFuelNeededPerModule(totalMass[i], 0);
        }
        return finalFuel;
    }



}

