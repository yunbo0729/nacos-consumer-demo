package com.nacos.controller;

import com.nacos.api.CouponFeignService;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.constraints.NotEmpty;

@RestController
@Slf4j
@RequestMapping("/consumer/")
public class OrderNacosController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CouponFeignService couponFeignService;

    @Value("${service-url.nacos-user-service}")
    private String serverURL;

    @GetMapping(value = "payment/nacos")
    public String paymentInfo(@RequestParam("id") Integer id) {
        return restTemplate.getForObject(serverURL+"/payment/Hello?id="+id,String.class);
    }

    @GetMapping(value = "payment/redis")
    public String redis(@RequestParam("key") String key) {
        return restTemplate.getForObject(serverURL+"/payment/Hello?key="+key,String.class);
    }

    @GetMapping("test2")
    public String test2(@RequestParam("userName") @Length(min = 6, max = 20, message = "字段不满足长度校验") String userName,
                            @RequestParam("type") @NotEmpty(message = "type不能为null") String type) {
        log.info("222222222222222");
        return restTemplate.getForObject(serverURL+"/test2?userName="+userName+"&type="+type,String.class);
    }

    @GetMapping(value = "tets3")
    public String tets3(@RequestParam("key") String key) {
        return couponFeignService.SayHelloWord(key);
    }
}
