package kata;

import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public class BabysitterKataStoryTest {
    public BabysitterCompensation babysitterCompensation = new BabysitterCompensation();
    
    @Test
    public void minArrival_MaxDeparture_MaxBedtime() {
        int result = babysitterCompensation.calculate(5,4,12);
        
        assertThat(result).isEqualTo(102);
    }
    
    @Test
    public void minArrival_MaxDepature_NormalBedtime() {
        int result = babysitterCompensation.calculate(5, 4, 9);

        assertThat(result).isEqualTo(90);
    }
}
    