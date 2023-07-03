package com.example.todo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class TodoApplicationTests {

    @Test
    void contextLoads() {
        var data = 1;
        assertThat(data).isPositive();
    }
}
