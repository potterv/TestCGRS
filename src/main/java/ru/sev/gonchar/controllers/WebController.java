package ru.sev.gonchar.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.sev.gonchar.generations.Generation;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


@Controller

public class WebController {


    private Generation generation = new Generation();
    ;

    private Map<String,List<Integer>> array = new HashMap<>();

    //
    @RequestMapping("/index")
    public String index() {
        generation.setCount(5);
        return "index";
    }

//    @PostMapping("/index")
//    public String index(@RequestParam(required = false, name = "num") Integer num, Model model) {
//
//        List<Integer> array = new LinkedList<>();
//        if (count <= 5 && count>=1) {
//        System.out.println(count);
//            generation = new Generation();
//            generation.setLength(num);
//             array = generation.generate();
//            if (array != null) {
//                model.addAttribute("label", "Полученая последовательность:");
//                model.addAttribute("array", array);
//            } else {
//                model.addAttribute("label", "");
//                model.addAttribute("array", array);
//            }
//            count--;
//            return "index";
//        }else{
//            model.addAttribute("label", "Сгенерировано 5 последовательностей");
////            model.addAttribute("array", array[0] = 0);
//            return "index";
//        }
//
//    }

    @PostMapping("/index")
    public String index(@RequestParam(required = false, name = "num") Integer num, Model model) {

        generation.setLength(num);
        array = generation.getSequence();
        if (array != null) {
            model.addAttribute("label", "Полученая последовательность:");
            model.addAttribute("array", array);
        } else {
            model.addAttribute("label", "Вы сгенерировали 5 последовательностей случайных простых чисел");
            model.addAttribute("array", array);
        }
        return "index";
    }

}

