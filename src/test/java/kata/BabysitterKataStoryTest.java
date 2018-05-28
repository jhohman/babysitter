package kata;

import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public class BabysitterKataStoryTest {
    
    @Test
    public void calculateCompensatation_For_MinArrival_MaxDeparture_MaxBedtime() {
        BabysitterCompensation babysitterCompensation = new BabysitterCompensation();

        int result = babysitterCompensation.calculate(5,4,12);
        
        assertThat(result).isEqualTo(102);
    }
    
    @Test
    public void calculateCompensation_BedtimeBeforeMidnight() {
        BabysitterCompensation babysitterCompensation = new BabysitterCompensation();

        int result = babysitterCompensation.calculate(6, 12, 9);
        
        assertThat(result).isEqualTo(48);
    }
    
    @Test
    public void calculateCompensation_DepartBeforeBedtime() {
        BabysitterCompensation babysitterCompensation = new BabysitterCompensation();
        int result = babysitterCompensation.calculate(8, 9, 10);

        assertThat(result).isEqualTo(10);
    }
    
    @Test
    public void calculateCompensation_ArriveAfterBedtime() {
        BabysitterCompensation babysitterCompensation = new BabysitterCompensation();

        int result = babysitterCompensation.calculate(10, 11, 9);

        assertThat(result).isEqualTo(6);
    }
}
