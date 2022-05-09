package com.ark.jwtstudy;

import com.ark.jwtstudy.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
class JwtStudyApplicationTests {

    @Test
    void contextLoads() {
        User user = new User();
        user.setAge(18);
        System.out.println(user);
    }

}
