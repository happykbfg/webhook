package com.springcloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RefreshScope
public class Controller {
    @Value("${greeting:Hi}")
    private String greeting;
   
    @GetMapping("/greeting/{message}")
    @ApiOperation(value="Test Spring cloud bus")
    public String echo(@PathVariable String message) {
        return greeting + " => " + message;
    } 
}
