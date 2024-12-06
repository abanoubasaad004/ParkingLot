import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.Scanner;

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

        Scanner Input = new Scanner(System.in);

        int startHour, endHour, startMonth, startDay, endMonth, endDay;
        double fees;

        System.out.println("Enter the start hour of the slot :");
        startHour = Input.nextInt();

        System.out.println("Enter the start month of the slot :");
        startMonth = Input.nextInt();

        System.out.println("Enter the start day of the slot :");
        startDay = Input.nextInt();

        System.out.println("Enter the end hour of the slot :");
        endHour = Input.nextInt();

        System.out.println("Enter the end month of the slot :");
        endMonth = Input.nextInt();

        System.out.println("Enter the end day of the slot :");
        endDay = Input.nextInt();

        System.out.println("Enter the fees for this slot :");
        fees = Input.nextDouble();



        // Check for overlapping slots
        for (int i = 0; i < slotCounter; i++) {
            // Check if the reservation dates overlap
            if (slots[i].getStartDate().isEqual(slot.getStartDate()) && (slot.getStartTime().isBefore(slots[i].getEndTime()) && slot.getEndTime().isAfter(slots[i].getStartTime()))) {
                return 3; // Overlapping slot
            }
        }

        // Add the slot if there are no issues
        if (slotCounter < maxNumOfSlots) {
            slots[slotCounter] =  new Slot(startHour,endHour,fees,startMonth,startDay,endMonth,endDay);
            slotCounter++;
            return 0; // Added
        } else {
            return 4; // No more slots available
        }
    }

    public boolean reserveSlot(Slot requestedSlot) {
        LocalDate today = LocalDate.now();
        LocalDate threeDaysFromNow = today.plusDays(3);

        // Check if the reservation is within 3 days
        if (requestedSlot.getStartDate().isBefore(today) || requestedSlot.getStartDate().isAfter(threeDaysFromNow)) {
            System.out.println("Reservation can only be made within 3 days.");
            return false;
        }


        for (int i = 0; i < slotCounter; i++) {

            // Check if the reservation date is overlapped
            if (slots[i].getStartDate().isEqual(requestedSlot.getStartDate()) && (requestedSlot.getStartTime().isBefore(slots[i].getEndTime()) && requestedSlot.getEndTime().isAfter(slots[i].getStartTime()))) {
                System.out.println("Cannot reserve slot: overlapping with an existing slot.");
                return false;
            }
        }


        if (requestedSlot.getStartHour() == requestedSlot.getEndHour()){
            System.out.println("Invalid");
            return false;
        }

        // Check if the reservation is not less than an hour
        if (Math.abs(requestedSlot.getStartMinute()-requestedSlot.getEndMinute())<60 && Math.abs(requestedSlot.getStartMinute()-requestedSlot.getEndMinute())!=0){
            System.out.println("Reservation date can not be less than an hour");
            return false;
        }

        // Check if there is an available slot
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