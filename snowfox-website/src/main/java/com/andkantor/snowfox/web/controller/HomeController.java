package com.andkantor.snowfox.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.andkantor.snowfox.web.model.base.Product;
import com.andkantor.snowfox.web.model.stock.Warehouse;
import com.andkantor.snowfox.web.service.ProductService;
import com.andkantor.snowfox.web.service.StockService;

@Controller
public class HomeController {

    @Autowired
    private ProductService productService;

    @Autowired
    private StockService stockService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String indexAction(Model model) {
        List<Product> products = productService.getProducts();
        Warehouse warehouse = stockService.getStockInfo(products);

        model.addAttribute("products", products);
        model.addAttribute("warehouse", warehouse);

        return "index";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchAction(@RequestParam String criteria, Model model) {
        List<Product> products = productService.searchProducts(criteria);
        Warehouse warehouse = stockService.getStockInfo(products);

        model.addAttribute("products", products);
        model.addAttribute("warehouse", warehouse);

        return "search";
    }

}
