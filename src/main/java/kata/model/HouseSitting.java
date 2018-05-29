package kata.model;

import kata.Timesheet;

public class HouseSitting {
    private final int arrivalHour;
    private final int departureHour;
    private final int bedtimeHour;

    public HouseSitting(int arrivalHour, int departureHour, int bedtimeHour) {
        this.arrivalHour = arrivalHour;
        this.departureHour = departureHour;
        this.bedtimeHour = bedtimeHour;
    }
    
    public int getTotalHours() {
        int totalHoursForHouseSitting = 0;
        if(hasHouseSittingHours()) {
            totalHoursForHouseSitting = Math.min(Timesheet.adjustHour(departureHour), 12) - Math.max(arrivalHour, bedtimeHour);
        }
        return totalHoursForHouseSitting;
    }

    private boolean hasHouseSittingHours() {
        return arrivedBeforeMidnight() && (arrivedAfterBedtime() || departedAfterBedtime());
    }

    private boolean arrivedBeforeMidnight() {
        return Timesheet.adjustHour(arrivalHour) < 12;
    }

    private boolean arrivedAfterBedtime() {
        return arrivalHour >= bedtimeHour;
    }

    private boolean departedAfterBedtime() {
        return Timesheet.adjustHour(departureHour) > bedtimeHour;
    }
}
