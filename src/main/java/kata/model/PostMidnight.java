package kata.model;

import kata.Timesheet;

public class PostMidnight {
    private final int arrivalHour;
    private final int departureHour;

    public PostMidnight(int arrivalHour, int departureHour) {
        this.arrivalHour = arrivalHour;
        this.departureHour = departureHour;
    }

    public int getTotalHours() {
        int totalHoursPostMidnight = 0;
        if (departAfterMidnight()) {
            totalHoursPostMidnight = Timesheet.adjustHour(departureHour) - Math.max(Timesheet.adjustHour(arrivalHour), 12);
        }
        return totalHoursPostMidnight;
    }

    private boolean departAfterMidnight() {
        return (Timesheet.adjustHour(departureHour) > 12);
    }
}
