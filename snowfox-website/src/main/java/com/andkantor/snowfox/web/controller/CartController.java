package com.andkantor.snowfox.web.controller;

import javax.validation.Valid;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.andkantor.snowfox.web.model.cart.CalculatedCart;
import com.andkantor.snowfox.web.model.cart.Cart;
import com.andkantor.snowfox.web.model.cart.CartAddRequest;
import com.andkantor.snowfox.web.model.cart.CartRemoveRequest;
import com.andkantor.snowfox.web.model.product.Product;
import com.andkantor.snowfox.web.model.product.ProductService;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private Cart cart;

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String indexAction(Model model) {
        List<Product> products = productService.getProducts(cart.getProductIds());

        model.addAttribute("cart", new CalculatedCart(cart, products));

        return "cart";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addAction(@Valid CartAddRequest request) {
        cart.addProduct(request.getProductId(), request.getQuantity());

        return "redirect:/cart";
    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public String removeAction(@Valid CartRemoveRequest request) {
        cart.removeProduct(request.getProductId());

        return "redirect:/cart";
    }

}
