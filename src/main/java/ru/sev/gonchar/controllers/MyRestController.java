package ru.sev.gonchar.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
public class MyRestController {

//    @GetMapping("/api/res")
    @RequestMapping(method = RequestMethod.GET, path = "/api/res")
    public ResponseEntity api() {
        List<Integer> integers = new ArrayList<>();
        for (int i=0; i<=10; i++){
            integers.add(i);
        }
        return ResponseEntity.ok(integers);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/api/res/length/{id}")
    public int apiLength(@PathVariable int length) {
        System.out.println(length);
        return (length);
    }
}
