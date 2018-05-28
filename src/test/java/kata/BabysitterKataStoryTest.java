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
    
    @Test
    public void bedtimeBeforeMidnight() {
        int result = babysitterCompensation.calculate(6, 12, 9);
        
        assertThat(result).isEqualTo(48);
    }
    
    @Test
    public void departBeforeBedtime() {
        int result = babysitterCompensation.calculate(8, 9, 10);

        assertThat(result).isEqualTo(10);
    }
    
    @Test
    public void departAtBedtime() {
        int result = babysitterCompensation.calculate(8, 9, 9);

        assertThat(result).isEqualTo(10);
    }
    
    @Test
    public void arriveAfterBedtime() {
        int result = babysitterCompensation.calculate(10, 11, 9);

        assertThat(result).isEqualTo(6);
    }
    
    @Test
    public void arriveAtBedtime() {
        int result = babysitterCompensation.calculate(9, 11, 9);

        assertThat(result).isEqualTo(12);
    }
    
    @Test
    public void arriveAtMidnight() {
        int result = babysitterCompensation.calculate(12, 4, 9);

        assertThat(result).isEqualTo(32);
    }

    @Test
    public void arriveAfterMidnight() {
        int result = babysitterCompensation.calculate(1, 4, 9);

        assertThat(result).isEqualTo(24);
    }

}
