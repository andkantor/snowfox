package com.andkantor.snowfox.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.andkantor.snowfox.web.service.ProductService;

@Controller
public class HomeController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String indexAction(Model model) {
        model.addAttribute("products", productService.getProducts());

        return "index";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchAction(@RequestParam String criteria, Model model) {
        model.addAttribute("products", productService.searchProducts(criteria));

        return "search";
    }

}
