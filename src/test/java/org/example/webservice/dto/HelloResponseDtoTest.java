package org.example.webservice.dto;

import org.assertj.core.api.Assertions;
import org.junit.Test;


public class HelloResponseDtoTest {

    @Test
    public void lombokTest() {

        String name = "title";
        int amount = 1000;

        HelloResponseDto helloResponseDto = new HelloResponseDto(name, amount);

        Assertions.assertThat(helloResponseDto.getName()).isEqualTo(name);
        Assertions.assertThat(helloResponseDto.getAmount()).isEqualTo(amount);
    }
}