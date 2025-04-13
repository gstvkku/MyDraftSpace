package io.codeforall.bootcamp.controller;

import io.codeforall.bootcamp.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CardController {

    @RequestMapping(method = RequestMethod.GET, value = "/card")
    public String init(Model model) {

        Customer customer = new Customer();

        customer.setFirstName("Wafelda");
        customer.setLastName("Batata");
        customer.setEmail("wafel_batatinha@gmail.com");
        customer.setPhone("945678394");

        model.addAttribute("firstName", customer.getFirstName());
        model.addAttribute("lastName", customer.getLastName());
        model.addAttribute("email", customer.getEmail());
        model.addAttribute("phone", customer.getPhone());

        return "card-view";

    }
}

