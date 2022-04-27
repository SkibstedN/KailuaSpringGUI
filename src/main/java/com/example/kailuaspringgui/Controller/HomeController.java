package com.example.kailuaspringgui.Controller;

import com.example.kailuaspringgui.Model.Customer;
import com.example.kailuaspringgui.Service.KailuaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    KailuaService kailuaService;

    @GetMapping("/")
    public String index (Model model){
        List<Customer> customerList = kailuaService.fetchCustomers();
        model.addAttribute("customers",customerList);
        return "/Index";
    }
    @GetMapping("/createCustomer")
    public String createCustomer(){
        return ("/createCustomer");
    }

    @PostMapping ("/createCustomer")
    public String createCustomer(@ModelAttribute Customer customer){
        kailuaService.addCustomer(customer);
        return "redirect:/";
    }

    @GetMapping("/deleteCustomer/{id}")
    public String deleteCustomer(@PathVariable("id") int id){
        kailuaService.deleteCustomer(id);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String updateCustomer(@PathVariable("id")int id, Model model){
        model.addAttribute("customer", kailuaService.findCustomerByID(id));
        return "updateCustomer";
    }


    @PostMapping("/updateCustomer")
        public String updateCustomer(@ModelAttribute Customer customer){
        kailuaService.updateCustomer(customer);
        return "redirect:/";

    }
}
