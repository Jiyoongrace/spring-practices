package com.poscodx.container.config.videosystem;

import com.poscodx.container.videosystem.Avengers;
import com.poscodx.container.videosystem.DVDPlayer;
import com.poscodx.container.videosystem.DigitalVideoDisc;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DVDPlayerConfig {
    @Bean
    public DigitalVideoDisc avengers() {
        return new Avengers();
    }


    // 주입(Injection)하기 1
    // Bean 생성 메서드를 직접 호출하는 방법
    @Bean("dvdPlayer01") // () 생략하면 메서드 이름이 id가 된다.
    public DVDPlayer dvdPlayer1() {
        return new DVDPlayer(avengers());
    }

    // 주입(Injection)하기 2
    // Parameter 로 bean을 전달하는 방법
    @Bean
    public DVDPlayer dvdPlayer2(DigitalVideoDisc dvd) {
        return new DVDPlayer(dvd);
    }
}
