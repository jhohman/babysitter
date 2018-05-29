package kata.model;

import static kata.Timesheet.adjustHour;

public class Childcare {
    private final int arrivalHour;
    private final int departureHour;
    private final int bedtimeHour;

    public Childcare(int arrivalHour, int departureHour, int bedtimeHour) {
        this.arrivalHour = arrivalHour;
        this.departureHour = departureHour;
        this.bedtimeHour = bedtimeHour;
    }
    public int getTotalHours() {
        int totalHoursForChildcare = 0;
        if (arrivedBeforeBedtime()) {
            totalHoursForChildcare = Math.min(bedtimeHour, adjustHour(departureHour)) - arrivalHour;
        }
        return totalHoursForChildcare;
    }

    private boolean arrivedBeforeBedtime() {
        return adjustHour(arrivalHour) < bedtimeHour;
    }
}
