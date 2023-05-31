package JavaFeatures.GarbageCollection;

/**
 *`Problem Description: A new housing scheme has been announced by the government
 * according to which each citizen can register only one house, and the same house can be registered by multiple people.
 * If the house is not registered to any citizen, it will be taken by the government.
 * */

class House{
    private int houseNumber;
    public House(int houseNumber){
        this.houseNumber = houseNumber;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber){
        this.houseNumber = houseNumber;
    }
}
public class HomeAllocationDeallocation {
    public static void main(String[] args){
        House citizen1 = new House(1);
        House citizen2 = new House(2);
        House citizen3 = new House(3);
        House citizen4 = new House(4);

        citizen1 = citizen3;  // Citizen1 is registered for house no3
        citizen2 = citizen4;
        citizen3 = null;

        System.out.println("citizen3: "+citizen3.getHouseNumber());
        System.out.println("citizen1: "+citizen1.getHouseNumber());

        citizen1 = citizen4;
        System.out.println("citizen1:"+citizen1.getHouseNumber());
        System.out.println("citizen2:"+citizen2.getHouseNumber());
        System.out.println("citizen3:"+citizen3.getHouseNumber());
        System.out.println("citizen4:"+citizen4.getHouseNumber());
    }
}

/**
 * You have learned that:
 *
 * When citizen1 shifts from House(1) to House(3), then House(1) will not be referred by any citizen hence it will be garbage collected.
 * Same way, when citizen2 shifts from House(2) to House(4), then House(2) will not be referred by any citizen hence it will be garbage collected.
 * If the houses are not registered to citizen, then the houses will be taken by the government. i.e., if an object is not referred then that object will be garbage collected
 */

