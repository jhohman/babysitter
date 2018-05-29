package kata.model;

import static kata.Timesheet.adjustHour;

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
            totalHoursPostMidnight = adjustHour(departureHour) - Math.max(adjustHour(arrivalHour), 12);
        }
        return totalHoursPostMidnight;
    }

    private boolean departAfterMidnight() {
        return (adjustHour(departureHour) > 12);
    }
}
