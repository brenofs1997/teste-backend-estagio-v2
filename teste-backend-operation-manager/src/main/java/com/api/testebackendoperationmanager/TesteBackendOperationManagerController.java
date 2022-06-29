package com.api.testebackendoperationmanager;

import org.springframework.web.bind.annotation.GetMapping;

public class TesteBackendOperationManagerController {
    @GetMapping("/hello")
    public String hello(){
        return "Hello - DOcker";
    }
}
