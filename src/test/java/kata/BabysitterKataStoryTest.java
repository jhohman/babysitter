package kata;

import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public class BabysitterKataStoryTest {
    public BabysitterCompensation babysitterCompensation = new BabysitterCompensation();
    
    @Test
    public void calculateCompensatation_For_MinArrival_MaxDeparture_MaxBedtime() {
        int result = babysitterCompensation.calculate(5,4,12);
        
        assertThat(result).isEqualTo(102);
    }
    
    @Test
    public void calculateCompensation_BedtimeBeforeMidnight() {
        int result = babysitterCompensation.calculate(6, 12, 9);
        
        assertThat(result).isEqualTo(48);
    }
    
    @Test
    public void calculateCompensation_DepartBeforeBedtime() {
        int result = babysitterCompensation.calculate(8, 9, 10);

        assertThat(result).isEqualTo(10);
    }
    
    @Test
    public void calculateCompensation_ArriveAfterBedtime() {
        int result = babysitterCompensation.calculate(10, 11, 9);

        assertThat(result).isEqualTo(6);
    }
    
    @Test
    public void calculateCompensation_ArriveAtBedtime() {
        int result = babysitterCompensation.calculate(9, 11, 9);

        assertThat(result).isEqualTo(12);
    }

}
