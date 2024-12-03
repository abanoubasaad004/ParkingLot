import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
public class Slot {

    protected LocalTime startTime;
    protected LocalTime endTime;
    public double fees;
    protected LocalDate startDate;
    protected LocalDate endDate;

    public Slot(int startHours , int startMinutes, int endHours, int endMinutes, double fees, int startYear, int startMonth, int startDay,int endYear, int endMonth, int endDay) {
        startTime = LocalTime.of(startHours,startMinutes);
        endTime = LocalTime.of(endHours,endMinutes);
        this.fees = fees;
        startDate = LocalDate.of(startYear,startMonth,startDay);
        endDate = LocalDate.of(endYear,endMonth,endDay);
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
