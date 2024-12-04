import java.time.LocalDate;

public class Spot {

    public static final int maxNumOfSlots=72;

    protected int spotID;
    protected String type;
    protected Slot [] slots= new Slot[maxNumOfSlots];
    public int slotCounter;



    public Spot(int spotID, String type) {
        this.spotID = spotID;
        this.type = type;
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


        // Check if the slot's reservation date is before today
        if (slot.getStartDate().isBefore(today)){
            return 1; // Invalid date
        }
        // Check if the slot's reservation date is within the allowed range
        if (slot.getStartDate().isAfter(ThreeDaysFromNow)) {
            return 2; // Cannot add a slot more than 3 days in advance
        }

        // Check for overlapping slots
        for (int i = 0; i < slotCounter; i++) {
            // Check if the reservation dates overlap
            if (slots[i].getStartDate().isEqual(slot.getStartDate()) && (slot.getStartTime().isBefore(slots[i].getEndTime()) && slot.getEndTime().isAfter(slots[i].getStartTime()))) {
                return 3; // Overlapping slot
            }
        }

        // Add the slot if there are no issues
        if (slotCounter < maxNumOfSlots) {
            slots[slotCounter] = slot;
            slotCounter++;
            return 0; // Added
        } else {
            return 4; // No more slots available
        }
    }
}