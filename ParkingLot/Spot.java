import java.time.LocalDate;

public class Spot {


    protected int spotID;
    protected String type;
    protected Slot [] slots;
    public int slotCounter;

    public static final int maxNumOfSlots=72;


    public Spot(int spotID, String type, Slot [] slots) {
        this.spotID = spotID;
        this.type = type;
        this.slots=new Slot[maxNumOfSlots];
        slotCounter=0;

    }


    public int getSpotID() {
        return spotID;
    }

    public String getType() {
        return type;
    }

    public boolean addSlot(Slot slot){

        LocalDate today = LocalDate.now();
        LocalDate twoDays = today.plusDays(2);

        if (slotCounter==0){
            slots[slotCounter]=slot;
            slotCounter++;
            return true;
        }
        else if(slotCounter<maxNumOfSlots && !slots[slotCounter-1].getEndDate().isAfter(twoDays)){
            slots[slotCounter]=slot;
            slotCounter++;
            return true;
        }
        else {
            return false;
        }
    }
}