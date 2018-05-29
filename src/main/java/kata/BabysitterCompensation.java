package kata;


public class BabysitterCompensation {
    private final int hourlyChildcareRate = 10;
    private final int hourlyHouseSittingRate = 6;
    private final int hourlyPostMidnightRate = 8;
    
    public int calculate(int arrivalHour, int departureHour, int bedtimeHour) {
        BabysitterValidator.validate(arrivalHour, departureHour, bedtimeHour);
        Timesheet timesheet = new Timesheet(arrivalHour, departureHour, bedtimeHour);
        return timesheet.sum(hourlyChildcareRate, hourlyHouseSittingRate, hourlyPostMidnightRate);
    }
}
