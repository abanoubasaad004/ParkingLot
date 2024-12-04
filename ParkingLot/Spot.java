import java.time.LocalDate;

public class Spot {


    protected int spotID;
    protected String type;
    protected Slot [] slots;
    public int slotCounter;

    public static final int maxNumOfSlots=72;


    public Spot(int spotID, String type) {
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

    public int addSlot(Slot slot) {
        LocalDate today = LocalDate.now();
        LocalDate ThreeDaysFromNow = today.plusDays(3);

        // Check if the slot's reservation date is within the allowed range
        if (slot.getStartDate().isAfter(ThreeDaysFromNow)) {
            return 1; // Cannot add a slot more than 3 days in advance
        }

        // Check for overlapping slots
        for (int i = 0; i < slotCounter; i++) {
            // Check if the reservation dates overlap
            if (slots[i].getStartDate().isEqual(slot.getStartDate()) && (slot.getStartTime().isBefore(slots[i].getEndTime()) && slot.getEndTime().isAfter(slots[i].getStartTime()))) {
                return 2; // Overlapping slot
            }
        }

        // Add the slot if there are no issues
        if (slotCounter < maxNumOfSlots) {
            slots[slotCounter] = slot;
            slotCounter++;
            return 0;
        } else {
            return 3; // No more slots available
        }
    }
}