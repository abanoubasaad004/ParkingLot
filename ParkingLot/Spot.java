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

    public boolean reserveSlot(Slot requestedSlot) {
        LocalDate today = LocalDate.now();
        LocalDate threeDaysFromNow = today.plusDays(3);

        // Check if the reservation date is within 3 days
        if (requestedSlot.getStartDate().isBefore(today) || requestedSlot.getStartDate().isAfter(threeDaysFromNow)) {
            System.out.println("Reservation can only be made within 3 days.");
            return false;
        }


        for (int i = 0; i < slotCounter; i++) {

            // Check if there is a reservation with the same date
            if (slots[i].getStartDate().isEqual(requestedSlot.getStartDate()) &&
                    (requestedSlot.getStartTime().isBefore(slots[i].getEndTime()) && requestedSlot.getEndTime().isAfter(slots[i].getStartTime()))) {
                System.out.println("Cannot reserve slot: overlapping with an existing slot.");
                return false;
            }
        }


        if (slotCounter < maxNumOfSlots) {

            slots[slotCounter] = requestedSlot; // Add the requested slot
            slotCounter++; // Increment the slot counter

            System.out.println("Reservation successful for slot on " + requestedSlot.getStartDate() + " from " + requestedSlot.getStartTime() + " to " + requestedSlot.getEndTime());
            return true;

        } else {
            System.out.println("No available slots for reservation.");
            return false;
        }
    }
}