package kata;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TimesheetTest {
    
    @Test
    public void sumCorrectly() {
        Timesheet timesheet = new Timesheet(5, 4, 9);

        int result = timesheet.sum(10, 6, 8);

        assertThat(result).isEqualTo(90);
    }
}
