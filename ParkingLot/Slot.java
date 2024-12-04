import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
public class Slot {

    protected LocalTime startTime;
    protected LocalTime endTime;
    protected int startHour;
    protected int endHour;
    protected int startMinute;
    protected int endMinute;
    public double fees;
    protected LocalDate startDate;
    protected LocalDate endDate;

    public Slot(int startHour, int startMinute, int endHour, int endMinute, double fees, int startYear, int startMonth, int startDay,int endYear, int endMonth, int endDay) {

        this.startHour = startHour;
        this.startMinute = startMinute;
        this.endHour = endHour;
        this.endMinute = endMinute;

        startTime=LocalTime.of(this.startHour,this.startMinute);
        endTime=LocalTime.of(this.endHour,this.endMinute);
        this.fees = fees;
        startDate = LocalDate.of(startYear,startMonth,startDay);
        endDate = LocalDate.of(endYear,endMonth,endDay);
    }

    public static final Slot NULL_SLOT = new Slot();


    private Slot() {
        this.startTime = LocalTime.MIN;
        this.endTime = LocalTime.MIN;
        this.fees = 0.0;
        this.startDate = LocalDate.MIN;
        this.endDate = LocalDate.MIN;
    }

    public static void removeSlot(Slot slot){
        slot.startTime=LocalTime.MIN;
        slot.endTime = LocalTime.MIN;
        slot.fees = 0.0;
        slot.startDate = LocalDate.MIN;
        slot.endDate = LocalDate.MIN;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public int getStartHour() {
        return startHour;
    }

    public int getEndHour() {
        return endHour;
    }

    public int getStartMinute() {
        return startMinute;
    }

    public int getEndMinute() {
        return endMinute;
    }
}
