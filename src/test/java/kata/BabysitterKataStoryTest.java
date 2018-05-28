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
}
