package kata.model;

import kata.Timesheet;

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
        if (arrivedBeforeBedtime(arrivalHour, bedtimeHour)) {
            totalHoursForChildcare = Math.min(bedtimeHour, Timesheet.adjustHour(departureHour)) - arrivalHour;
        }
        return totalHoursForChildcare;
    }

    private boolean arrivedBeforeBedtime(int arrivalHour, int bedtimeHour) {
        return Timesheet.adjustHour(arrivalHour) < bedtimeHour;
    }
}
