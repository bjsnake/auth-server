package com.landongnet.auth;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Slf4j
@SpringBootTest(classes = AuthApplication.class)
public class AuthServerApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void  generatePwd(){
        String pwd = "rock_cloud";
        String encode = passwordEncoder.encode(pwd);
        log.info(encode);
    }

    public static void main(String[] args) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encode = passwordEncoder.encode("123456");
        System.out.println(encode);
    }

}
