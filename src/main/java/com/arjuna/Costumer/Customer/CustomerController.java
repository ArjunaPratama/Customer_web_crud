package com.arjuna.Costumer.Customer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired private CustomerService customerService;

    @GetMapping("/customer")
    public String showListCustomer(Model model){
        List<Customer> listCustomer = customerService.customerList();
        model.addAttribute("listCustomer", listCustomer);
        System.out.println(listCustomer);
        return "customer";
    }

    @GetMapping("/customer/new")
    public String showNewForm(Model model){
        model.addAttribute("customer", new Customer());
        model.addAttribute("pageTitle", "Form Input Customer");
        return "customer_form_input";
    }

    @PostMapping("/customer/save")
    public String saveCustomer(Customer customer) {
        customerService.save(customer);
        return "redirect:/customer";
    }

    @GetMapping("/customer/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {

       Customer customer = customerService.getId(id);
       model.addAttribute("customer", customer);
       model.addAttribute("pageTitle", "Form Edit Customer ID : "+ id+" ");
       return "customer_form_input";
    }

    @GetMapping("/customer/delete/{id}")
    public String deleteCustomer(@PathVariable("id") Long id) {
        customerService.deleteCustomer(id);
        return "redirect:/customer";
    }
}
