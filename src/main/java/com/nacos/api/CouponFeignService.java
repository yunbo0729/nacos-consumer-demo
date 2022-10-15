package com.nacos.api;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("nacos-provider-demo") // mall-coupon 为调用远程服务的服务名，并且是在nacos的注册列表中可以找到的
public interface CouponFeignService {


    @GetMapping("/payment/Hello")  // 远程接口的完整 url 路径
    String SayHelloWord(@RequestParam("key")String key);
}

