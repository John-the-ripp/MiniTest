package com.testBfor.jackpotMicroService.Controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CustomErrorController implements ErrorController {
    private static final String PATH = "/error";

    @RequestMapping(PATH)
    public ResponseEntity<String> error() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("La ressource demandée n'est pas disponible.");
    }



}
