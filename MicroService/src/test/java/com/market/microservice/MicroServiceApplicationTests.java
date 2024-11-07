package com.market.microservice;

import com.market.microservice.Repositories.CompteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MicroServiceApplicationTests {

    @Autowired
    private CompteRepository compteRepository;

    @Test
    void contextLoads() {
        
    }

}
