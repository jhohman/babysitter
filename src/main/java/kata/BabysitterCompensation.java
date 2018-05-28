package kata;


public class BabysitterCompensation {
    private final int hourlyChildcareRate = 10;
    private final int hourlyHouseSittingRate = 6;
    private final int hourlyPostMidnightRate = 8;
    
    public int calculate(int arrivalHour, int departureHour, int bedtimeHour) {
        int childcareHours = getChildcareHours(arrivalHour, departureHour, bedtimeHour);
        int houseSittingHours = getHouseSittingHours(bedtimeHour, departureHour);
        int postMidnightHours = getPostMidnightHours(departureHour);
        
        return sum(childcareHours, houseSittingHours, postMidnightHours);
    }

    private int getChildcareHours(int arrivalHour, int departureHour, int bedtimeHour) {
        return Math.min(bedtimeHour, departureHour) - arrivalHour;
    }

    private int getHouseSittingHours(int bedtimeHour, int departureHour) {
        if (departureHour < bedtimeHour) {
            return 0;
        }
        return 12 - bedtimeHour;
    }

    private int getPostMidnightHours(int departureHour) {
        return departureHour < 5 ? departureHour : 0;
    }

    private int sum(int childcareHours, int houseSittingHours, int postMidnightHours) {
        return (childcareHours * hourlyChildcareRate) 
                + (houseSittingHours * hourlyHouseSittingRate) 
                + (postMidnightHours * hourlyPostMidnightRate);
    }
}
