package kata.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PostMidnightTest {

    @Test
    public void departAfterMidnight() {
        PostMidnight postMidnight = new PostMidnight(5, 3);

        int result = postMidnight.getTotalHours();

        assertThat(result).isEqualTo(3);
    }
    
    @Test
    public void arriveAfterMidnight() {
        PostMidnight postMidnight = new PostMidnight(1, 4);

        int result = postMidnight.getTotalHours();

        assertThat(result).isEqualTo(3);
    }
    
    @Test
    public void arriveAtMidnight() {
        PostMidnight postMidnight = new PostMidnight(12, 2);

        int result = postMidnight.getTotalHours();

        assertThat(result).isEqualTo(2);
    } 
}
