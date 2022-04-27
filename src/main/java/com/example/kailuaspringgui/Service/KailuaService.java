package com.example.kailuaspringgui.Service;

import com.example.kailuaspringgui.Model.Customer;
import com.example.kailuaspringgui.Repository.KailuaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KailuaService {

    @Autowired
    KailuaRepo kailuaRepo;

    public List<Customer> fetchCustomers() {return kailuaRepo.fetchCustomers();}

    public void addCustomer(Customer customer){kailuaRepo.addCustomer(customer);}

    public Boolean deleteCustomer(int id){
        return kailuaRepo.deleteCustomer(id);
    }

    public Customer findCustomerByID(int id){
        return kailuaRepo.findCustomerByID(id);
    }


    public void updateCustomer(Customer customer){kailuaRepo.updateCustomer(customer) ;}
}
