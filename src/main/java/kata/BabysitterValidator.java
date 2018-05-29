package kata;

public class BabysitterValidator {
    public static void validate(int arrivalHour, int depatureHour, int bedtimeHour) {
        if (arrivalHour < 5) {
            throw new BabysitterValidationException("Cannot arrive before 5");
        }

        if (depatureHour == 5) {
            throw new BabysitterValidationException("Cannot depart after 4");
        }

        if (bedtimeHour < 5) {
            throw new BabysitterValidationException("Bedtime cannot be after midnight");
        }
    }
}
