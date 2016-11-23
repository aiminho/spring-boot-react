package com.patrickgrimard.examples;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on 2016-11-22
 *
 * @author Patrick
 */
@Controller
public class IndexController {

    @GetMapping("/{path:(?!main).*$}")
    public String index(Model model) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        Map<String, Object> items = new HashMap<>();
        items.put("0", "javascript");
        items.put("1", "react");
        items.put("2", "react-router");
        items.put("3", "redux");

        model.addAttribute("state", mapper.writeValueAsString(items));

        return "index";
    }

    @GetMapping("/hello")
    public String hello(Model model) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        Map<String, Object> items = new HashMap<>();
        items.put("message", "Hello React!");

        model.addAttribute("state", mapper.writeValueAsString(items));
        return "index";
    }
}