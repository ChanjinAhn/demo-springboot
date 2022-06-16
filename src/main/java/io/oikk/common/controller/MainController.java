package io.oikk.common.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * @param name String testName
     * @param model model
     * @return page
     */
    @GetMapping("/main")
    public String main(@RequestParam(name = "name", required = false, defaultValue = "Wolrd") String name, Model model){
        model.addAttribute("name", name);
        System.out.println("ddd");
        System.out.println("zz");
        System.out.println("ddd");
        System.out.println("ddd");
        logger.info("hello");
        logger.debug("hello");
        logger.warn("hello");
        logger.trace("hello");
        logger.error("hello");
        logger.info("hello");

        return "test/main";
    }


    @GetMapping("/common")
    public String main(){
        return "common_header";
    }

    @GetMapping("/inputFile")
    public String testInputFile(){
        return "test/inputFile";
    }
}
