package com.spring.crud.controller;

import com.spring.crud.entity.Customer;
import com.spring.crud.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("list")
    public String listCustomers(Model model){
        List<Customer> customers = customerService.getCustomers();
        model.addAttribute("customers", customers);
        return "list-customers";
    }

    @GetMapping("showFormForAdd")
    public String showFormForAdd(Model  model){
        Customer customer = new Customer();

        model.addAttribute("customer", customer);

        return "customer-form";
    }
    @PostMapping("saveCustomer")
    public  String saveCustomer(@ModelAttribute("customer") Customer customer){
            customerService.saveCustomer(customer);
        return "redirect:/customer/list";
    }
    @GetMapping("delete")
    public  String deleteCustomer(@ModelAttribute("id") int id){
            customerService.deleteCustomer(id);
        return "redirect:/customer/list";
    }

    @GetMapping("showFormForUpdate")
    public String showFormForUpdate (@RequestParam("customerId") int id,
                                     Model model){
        Customer customer = customerService.getCustomer(id);
        model.addAttribute("customer", customer);

        return "customer-form";
    }
}
