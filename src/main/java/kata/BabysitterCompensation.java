package kata;


public class BabysitterCompensation {
    private final int hourlyChildcareRate = 10;
    private final int hourlyHouseSittingRate = 6;
    private final int hourlyPostMidnightRate = 8;
    
    public int calculate(int arrivalHour, int departureHour, int bedtimeHour) {
        int childcareHours = getChildcareHours(arrivalHour, departureHour, bedtimeHour);
        int houseSittingHours = getHouseSittingHours(arrivalHour, departureHour, bedtimeHour);
        int postMidnightHours = getPostMidnightHours(arrivalHour, departureHour);
        
        return sum(childcareHours, houseSittingHours, postMidnightHours);
    }

    private int getChildcareHours(int arrivalHour, int departureHour, int bedtimeHour) {
        if (arrivedAfterBedtime(arrivalHour, bedtimeHour)) {
            return 0;
        }
        int departureHourAdjusted = departureHour < 5 ? departureHour + 12 : departureHour;
        return Math.min(bedtimeHour, departureHourAdjusted) - arrivalHour;
    }

    private int getHouseSittingHours(int arrivalHour, int departureHour, int bedtimeHour) {
        if(arrivedAfterMidnight(arrivalHour)) {
            return 0;
        }
        if (arrivedAfterBedtime(arrivalHour, bedtimeHour)) {
            return departureHour - arrivalHour;
        }
        if (departedBeforeBedtime(departureHour, bedtimeHour)) {
            return 0;
        }
        return 12 - bedtimeHour;
    }

    private int getPostMidnightHours(int arrivalHour, int departureHour) {
        if (arrivedAfterMidnight(arrivalHour)) {
            return departureHour - (arrivalHour == 12 ? 0 : arrivalHour);
        }
        return departureHour < 5 ? departureHour : 0;
    }

    private int sum(int childcareHours, int houseSittingHours, int postMidnightHours) {
        return (childcareHours * hourlyChildcareRate) 
                + (houseSittingHours * hourlyHouseSittingRate) 
                + (postMidnightHours * hourlyPostMidnightRate);
    }

    private boolean arrivedAfterMidnight(int arrivalHour) {
        if (arrivalHour == 12 || arrivalHour < 5) {
            return true;
        }
        return false;
    }

    private boolean departedBeforeBedtime(int departureHour, int bedtimeHour) {
        int departureHourAdjustd = departureHour < 5 ? departureHour + 12 : departureHour;
        return departureHourAdjustd <= bedtimeHour;
    }

    private boolean arrivedAfterBedtime(int arrivalHour, int bedtimeHour) {
        int arrivalHourAdjusted = arrivalHour < 5 ? arrivalHour + 12 : arrivalHour;
        return arrivalHourAdjusted >= bedtimeHour ;
    }
}
