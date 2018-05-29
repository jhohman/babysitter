package kata;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class BabysitterValidatorTest {

    @Test
    public void cannotArriveBeforeFive() {
        assertThatExceptionOfType(BabysitterValidationException.class)
                .isThrownBy(() -> {BabysitterValidator.validate(4, 9, 9);})
                .withMessage("Cannot arrive before 5");
    }

    @Test
    public void cannotDepartAfterFour() {
        assertThatExceptionOfType(BabysitterValidationException.class)
                .isThrownBy(() -> {BabysitterValidator.validate(5, 5, 9);})
                .withMessage("Cannot depart after 4");
    }

    @Test
    public void bedtimeCannotBeAfterMidnight() {
        assertThatExceptionOfType(BabysitterValidationException.class)
                .isThrownBy(() -> {BabysitterValidator.validate(5, 2, 1);})
                .withMessage("Bedtime cannot be after midnight");
    }
}