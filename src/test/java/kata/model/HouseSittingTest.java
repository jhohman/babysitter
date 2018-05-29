package kata.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HouseSittingTest {

    @Test
    public void arriveBeforeMidnight() {
        HouseSitting houseSitting = new HouseSitting(8, 3, 9);

        int result = houseSitting.getTotalHours();
        
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void arriveAfterBedtime() {
        HouseSitting houseSitting = new HouseSitting(9, 10, 8);

        int result = houseSitting.getTotalHours();

        assertThat(result).isEqualTo(1);
    } 
    
    @Test
    public void departAfterBedtime() {
        HouseSitting houseSitting = new HouseSitting(5, 10, 8);

        int result = houseSitting.getTotalHours();

        assertThat(result).isEqualTo(2);
    }

    @Test
    public void noHouseSittingHours() {
        HouseSitting houseSitting = new HouseSitting(12, 4, 8);

        int result = houseSitting.getTotalHours();

        assertThat(result).isEqualTo(0);
    } 
}
