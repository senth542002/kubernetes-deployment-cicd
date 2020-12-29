
package com.cicd.example.kubernetesdeployment.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class HelloController {

    @GetMapping("/sayHello")
    public String sayHelloTo(@RequestParam("name") String name) {
        return "Hello "+name+"!!!";
    }

}
