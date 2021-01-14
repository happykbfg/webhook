package com.springcloud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@FeignClient( name="webhook", url="${config_server_host:http://localhost:9001}" )
public interface IWebhookController {
    @PostMapping("/actuator/bus-refresh")
    @ApiOperation(value="Notify config changes to config server")
    public String notifyConfigChanges();
}

