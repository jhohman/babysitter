package kata.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ChildcareTest {
    
    @Test
    public void arriveBeforeBedtime() {
        Childcare childcare = new Childcare(5, 9, 8);
        
        int result = childcare.getTotalHours();
        
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void arriveAfterBedtime() {
        Childcare childcare = new Childcare(8, 10, 7);
        
        int result = childcare.getTotalHours();

        assertThat(result).isEqualTo(0);
    }

    @Test
    public void departBeforeBedtime() {
        Childcare childcare = new Childcare(5, 8, 9);

        int result = childcare.getTotalHours();

        assertThat(result).isEqualTo(3);
    }
    
}
