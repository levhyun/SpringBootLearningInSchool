package org.zerock.ex1.sample;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SampleTests {
    private Restaurant restaurant;

    @Test
    public void test() {
        System.out.println(restaurant);
    }
}
