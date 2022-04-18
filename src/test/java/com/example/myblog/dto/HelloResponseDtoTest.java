package com.example.myblog.dto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HelloResponseDtoTest {


    @Test
    public void 롬복_기능_테스트() {
        //given
        String name = "park";
        String nickname = "kim";

        //when
        HelloResponseDto helloResponseDto = new HelloResponseDto(name, nickname);

        //then
        assertThat(helloResponseDto.getName()).isEqualTo(name);
        assertThat(helloResponseDto.getNickname()).isEqualTo(nickname);
    }
}