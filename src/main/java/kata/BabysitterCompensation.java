package kata;


public class BabysitterCompensation {
    private final int hourlyChildcareRate = 10;
    private final int hourlyHouseSittingRate = 6;
    private final int hourlyPostMidnightRate = 8;
    
    public int calculate(int arrivalHour, int departureHour, int bedtimeHour) {
        int childcareHours = getChildcareHours(arrivalHour, departureHour, bedtimeHour);
        int houseSittingHours = getHouseSittingHours(arrivalHour, departureHour, bedtimeHour);
        int postMidnightHours = getPostMidnightHours(departureHour);
        
        return sum(childcareHours, houseSittingHours, postMidnightHours);
    }

    private int getChildcareHours(int arrivalHour, int departureHour, int bedtimeHour) {
        int departureHourAdjusted = departureHour < 5 ? departureHour + 12 : departureHour;
        return Math.min(bedtimeHour, departureHourAdjusted) - arrivalHour;
    }

    private int getHouseSittingHours(int arrivalHour, int departureHour, int bedtimeHour) {
        if (arrivedAfterBedtime(arrivalHour, bedtimeHour)) {
            return departureHour - arrivalHour;
        }
        if (departedBeforeBedtime(departureHour, bedtimeHour)) {
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

    private boolean departedBeforeBedtime(int departureHour, int bedtimeHour) {
        return departureHour < bedtimeHour;
    }

    private boolean arrivedAfterBedtime(int arrivalHour, int bedtimeHour) {
        return arrivalHour >= bedtimeHour ;
    }
}
