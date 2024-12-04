import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
public class Slot {

    protected LocalTime startTime;
    protected LocalTime endTime;
    public double fees;
    protected LocalDate startDate;
    protected LocalDate endDate;

    public Slot(int startHour, int startMinute, int endHour, int endMinute, double fees, int startYear, int startMonth, int startDay,int endYear, int endMonth, int endDay) {
        startTime = LocalTime.of(startHour,startMinute);
        endTime = LocalTime.of(endHour,endMinute);
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
}
