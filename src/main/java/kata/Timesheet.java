package kata;

import kata.model.Childcare;
import kata.model.HouseSitting;
import kata.model.PostMidnight;

public class Timesheet {
    private Childcare childcare;
    private HouseSitting houseSitting;
    private PostMidnight postMidnight;

    public Timesheet(int arrivalHour, int departureHour, int bedtimeHour) {
        this.childcare = new Childcare(arrivalHour, departureHour, bedtimeHour);
        this.houseSitting = new HouseSitting(arrivalHour, departureHour, bedtimeHour);
        this.postMidnight = new PostMidnight(arrivalHour, departureHour);
    }

    public int sum(int hourlyChildcareRate, int hourlyHouseSittingRate, int hourlyPostMidnightRate) {
        return (this.childcare.getTotalHours() * hourlyChildcareRate)
                + (this.houseSitting.getTotalHours() * hourlyHouseSittingRate)
                + (this.postMidnight.getTotalHours() * hourlyPostMidnightRate);
    }

    public static int adjustHour(int hour) {
        return hour < 5 ? hour + 12 : hour;
    }
}
