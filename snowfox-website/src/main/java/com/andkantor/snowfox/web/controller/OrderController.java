package com.andkantor.snowfox.web.controller;

import static com.andkantor.snowfox.web.model.base.Price.price;
import static com.andkantor.snowfox.web.model.cart.CalculatedCart.calculatedCart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.andkantor.snowfox.web.model.base.Currency;
import com.andkantor.snowfox.web.model.base.Product;
import com.andkantor.snowfox.web.model.cart.CalculatedCart;
import com.andkantor.snowfox.web.model.order.Order;
import com.andkantor.snowfox.web.response.OrderSubmissionResponse;
import com.andkantor.snowfox.web.service.Cart;
import com.andkantor.snowfox.web.service.OrderService;
import com.andkantor.snowfox.web.service.ProductService;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private Cart cart;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String indexAction(Model model) {
        Order order = prepareOrder();

        model.addAttribute("order", order);

        return "order";
    }

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public String submitAction(Model model) {
        Order order = prepareOrder();

        OrderSubmissionResponse response = orderService.submitOrder(order);

        if (response.isSuccess()) {
            return "redirect:/";
        }

        model.addAttribute("errorMessage", response.getMessage());

        return indexAction(model);
    }

    private Order prepareOrder() {
        List<Product> products = productService.getProducts(cart.getProductIds());
        CalculatedCart calculatedCart = calculatedCart(cart, products);
        return Order.builder()
                .cart(calculatedCart)
                .shipping(price(10.0, Currency.EUR))
                .build();
    }

}
