package org.sid.customerservice.config;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
@RefreshScope
public class ConfigTestRestControlller {

    @Value("${global.params.p1}")
    private String p1;

    @Value("${global.params.p2}")
    private String p2;

    @Autowired
    private CustomerConfigParams customerConfigParams;

    @PostConstruct
    public void init() {
        System.out.println("p1: " + p1);
        System.out.println("p2: " + p2);
    }

    @GetMapping("/testConfig1")
    public Map<String, String> configTest() {
        return Map.of("p1", p1, "p2", p2);
    }

    @GetMapping("/testConfig2")
    public CustomerConfigParams configTest2() {
        return customerConfigParams;
    }

}