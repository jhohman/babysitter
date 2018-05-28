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

    public int getTotalHoursForChildcare() {
        if (arrivedAfterBedtime()) {
            return 0;
        }
        return Math.min(bedtimeHour, adjustHour(departureHour)) - arrivalHour;
    }
    
    public int getTotalHoursForHouseSitting() {
        if(arrivedAfterMidnight(arrivalHour)) {
            return 0;
        }
        if (departedBeforeBedtime()) {
            return 0;
        }
        if (arrivedAfterBedtime()) {
            return departureHour - arrivalHour;
        }
        return 12 - bedtimeHour;
    }
    
    public int getTotalHoursForPostMidnight() {
        if (arrivedAfterMidnight(arrivalHour)) {
            return departureHour - (arrivalHour == 12 ? 0 : arrivalHour);
        }
        return departureHour < 5 ? departureHour : 0;
    }

    private boolean arrivedAfterMidnight(int arrivalHour) {
        return (adjustHour(arrivalHour) >= 12);
    }

    private boolean departedBeforeBedtime() {
        return adjustHour(departureHour) <= bedtimeHour;
    }

    private boolean arrivedAfterBedtime() {
        return adjustHour(arrivalHour) >= bedtimeHour ;
    }

    private int adjustHour(int hour) {
        return hour < 5 ? hour + 12 : hour;
    }
}
