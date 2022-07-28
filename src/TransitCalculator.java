public class TransitCalculator {
    String[] fareOptions = {"Pay-per-ride (single ride)","7-day Unlimited Rides","30-day Unlimited Rides"};
    double[] fares = {2.75,33,127};
    double days;
    int rides;
    public TransitCalculator(int numRides, double numDays) {
        rides = numRides;
        days = numDays;
    }
    public double unlimited7Price() {
        /* Calculating price per ride for 7 day unlimited pass */
        double sevenDayPassNeeded = Math.ceil(days / 7);
        //if days int - double sevenDayPassNeeded = Math.ceil(days / 7.0);- better
        double pricePerRide7D = sevenDayPassNeeded * fares[1];
        return pricePerRide7D / rides;
    }
    public double[] getRidePrices(){
        /* Calculating price per trip*/
        double singleTicket = fares[0];
        double monthlyPass = fares[2]/rides;
        return new double[]{singleTicket,unlimited7Price(), monthlyPass};
    }
    public String getBestFare(){
        double[] ridePrice = getRidePrices();
        int bestPriceIndex = 0;

        for (int i = 0; i < ridePrice.length; i++){
            if (ridePrice[i] < ridePrice[bestPriceIndex]){
                bestPriceIndex = i;
            }
        }
        return "You should get the " + fareOptions[bestPriceIndex] + " option at " + Math.round(ridePrice[bestPriceIndex]*100.0) / 100.0 + " per ride.";

    }
    public static void main(String[] args){

        TransitCalculator test1 = new TransitCalculator(20,19);
        TransitCalculator test2 = new TransitCalculator(50,22);
        TransitCalculator test3 = new TransitCalculator(14,6);
        TransitCalculator test4 = new TransitCalculator(54,26);
        TransitCalculator test5 = new TransitCalculator(12,6);
        //Testing values to check work of unlimited7Price
        System.out.println("Test1: " + test1.unlimited7Price());
        System.out.println("Test2: " + test2.unlimited7Price());
        System.out.println("Test3: " + test3.unlimited7Price());
       // Best price value test
        System.out.println("Test4: " + test4.getBestFare());
        System.out.println("Test5: " + test5.getBestFare());

    }


}
