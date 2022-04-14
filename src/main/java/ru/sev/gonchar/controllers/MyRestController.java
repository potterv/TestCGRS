package ru.sev.gonchar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sev.gonchar.generations.Generation;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class MyRestController {

//@Autowired
//    GenerateService generateService;

    @RequestMapping(method = RequestMethod.GET, path = "/api")
    public ResponseEntity api() {
        Generation generation = new Generation();
        generation.setLength(10);

        return ResponseEntity.ok(generation.getSequence());
    }


}
