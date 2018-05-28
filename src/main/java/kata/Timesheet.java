package kata;

public class Timesheet {
    private int arrivalHour;
    private int departureHour;
    private int bedtimeHour;

    public Timesheet(int arrivalHour, int departureHour, int bedtimeHour) {
        this.arrivalHour = arrivalHour;
        this.departureHour = departureHour;
        this.bedtimeHour = bedtimeHour;
    }

    public int sum(int hourlyChildcareRate, int hourlyHouseSittingRate, int hourlyPostMidnightRate) {
        return (getTotalHoursForChildcare() * hourlyChildcareRate)
                + (getTotalHoursForHouseSitting() * hourlyHouseSittingRate)
                + (getTotalHoursForPostMidnight() * hourlyPostMidnightRate);
    }

    private int getTotalHoursForChildcare() {
        int totalHoursForChildcare = 0;
        if (arrivedBeforeBedtime()) {
            totalHoursForChildcare = Math.min(bedtimeHour, adjustHour(departureHour)) - arrivalHour;
        }
        return totalHoursForChildcare;
    }
    
    private int getTotalHoursForHouseSitting() {
        int totalHoursForHouseSitting = 0;
        if(hasHouseSittingHours()) {
            totalHoursForHouseSitting = Math.min(adjustHour(departureHour), 12) - Math.max(arrivalHour, bedtimeHour);
        }
        return totalHoursForHouseSitting;
    }
    
    private int getTotalHoursForPostMidnight() {
        int totalHoursPostMidnight = 0;
        if (departAfterMidnight()) {
            totalHoursPostMidnight = adjustHour(departureHour) - Math.max(adjustHour(arrivalHour), 12);
        }
        return totalHoursPostMidnight;
    }
    
    private boolean arrivedBeforeBedtime() {
        return adjustHour(arrivalHour) < bedtimeHour;
    }

    private boolean hasHouseSittingHours() {
        return arrivedBeforeMidnight() && (arrivedAterBedtime() || departedAfterBedtime());
    }

    private boolean arrivedBeforeMidnight() {
        return adjustHour(arrivalHour) < 12;
    }

    private boolean arrivedAterBedtime() {
        return arrivalHour >= bedtimeHour;
    }

    private boolean departedAfterBedtime() {
        return adjustHour(departureHour) > bedtimeHour;
    }

    private boolean departAfterMidnight() {
        return (adjustHour(departureHour) > 12);
    }

    private int adjustHour(int hour) {
        return hour < 5 ? hour + 12 : hour;
    }
}
