package kata;


public class BabysitterCompensation {
    private final int hourlyChildcareRate = 10;
    private final int hourlyHouseSittingRate = 6;
    private final int hourlyPostMidnightRate = 8;
    
    public int calculate(int arrivalHour, int departureHour, int bedtimeHour) {
        Timesheet timesheet = new Timesheet(arrivalHour, departureHour, bedtimeHour);
        int childcareHours = timesheet.getTotalHoursForChildcare();
        int houseSittingHours = timesheet.getTotalHoursForHouseSitting();
        int postMidnightHours = timesheet.getTotalHoursForPostMidnight();
        
        return sum(childcareHours, houseSittingHours, postMidnightHours);
    }

    private int sum(int childcareHours, int houseSittingHours, int postMidnightHours) {
        return (childcareHours * hourlyChildcareRate) 
                + (houseSittingHours * hourlyHouseSittingRate) 
                + (postMidnightHours * hourlyPostMidnightRate);
    }
}
