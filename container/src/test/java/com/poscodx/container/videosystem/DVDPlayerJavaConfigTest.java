package com.poscodx.container.videosystem;

import com.poscodx.container.config.videosystem.DVDPlayerConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes={DVDPlayerConfig.class})
public class DVDPlayerJavaConfigTest {
    @Autowired
    // 같은 타입의 빈이 2개 이상이 있는 경우
    // 설정 클래스의 빈 생성 메서드의 @Bean의 name(default) 속성으로 Qualifier 하기
    @Qualifier("dvdPlayer01") // id 이름 명시
    private DVDPlayer dvdPlayer01;

    @Autowired
    // 같은 타입의 빈이 2개 이상이 있는 경우
    // 설정 클래스의 빈 생성 메서드의 이름으로 Qualifier 하기
    @Qualifier("dvdPlayer2")
    private DVDPlayer dvdPlayer02;

    @Autowired
    @Qualifier("dvdPlayer03")
    private DVDPlayer dvdPlayer03;

    @Test
    public void testDVDPlayer01NotNull() {
        assertNotNull(dvdPlayer01);
    }

    @Test
    public void testPlay01() {
        assertEquals("Playing Movie Marvel's Avengers", dvdPlayer01.play());
    }

    @Test
    public void testDVDPlayer02NotNull() {
        assertNotNull(dvdPlayer02);
    }

    @Test
    public void testPlay02() {
        assertEquals("Playing Movie Marvel's Avengers", dvdPlayer02.play());
    }

    @Test
    public void testDVDPlayer03NotNull() {
        assertNotNull(dvdPlayer03);
    }

    @Test
    public void testPlay03() {
        assertEquals("Playing Movie Marvel's Avengers", dvdPlayer03.play());
    }
}
