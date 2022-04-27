package com.example.kailuaspringgui.Repository;

import com.example.kailuaspringgui.Model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class KailuaRepo {

    @Autowired
    JdbcTemplate template;
    int antalCustomers = 0;

    public List<Customer> fetchCustomers() {
        String sql = " SELECT c.customer_id as customerID, c.customer_first_name as fName, c.customer_last_name as lName, r.customer_address as address, " +
                "r.customer_zip_code as zipCode,  r.customer_city as city, cc.customer_phonenumber as phoneNumber,  cc.customer_email as eMail," +
                "c.customer_licensenumber as driverLicenseNumber, c.customer_driver_since_date as driverSinceDate " +
                "FROM customer c JOIN residence r ON c.customer_id = r.customerResidence_id " +
                "JOIN contact cc ON r.customerResidence_id = cc.customerContact_id ";
        RowMapper<Customer> rowMapper = new BeanPropertyRowMapper<>(Customer.class);
        antalCustomers = template.query(sql, rowMapper).size();
        return template.query(sql, rowMapper);

    }

    public void addCustomer(Customer customer){
        String sqlCustomer = "INSERT INTO customer (customer_first_name, customer_last_name, customer_licensenumber," +
                " customer_driver_since_date)" + "VALUES(?,?,?,?)";
        template.update(sqlCustomer, customer.getfName(), customer.getlName(), customer.getDriverLicenseNumber(), customer.getDriverSinceDate());

        String sqlResidence ="INSERT INTO residence (FK_Residence_customer_id, customer_address, customer_city," +
                " customer_zip_code)" + "VALUES (?, ?, ?, ?)";
        template.update(sqlResidence, antalCustomers+1, customer.getAddress(), customer.getCity(), customer.getZipCode());

        String sqlContact = "INSERT INTO contact (FK_Contact_customer_id, customer_phonenumber, customer_email)" +
                "VALUES (?, ?, ?)";
        template.update(sqlContact, antalCustomers+1, customer.getPhoneNumber(), customer.geteMail());
    }

    public Boolean deleteCustomer(int id){
        String sqlDeleteResidence ="DELETE FROM  residence WHERE customerResidence_id = ?";
        template.update(sqlDeleteResidence,id);
        String sqlDeleteContact ="DELETE FROM contact WHERE customerContact_id = ?";
        template.update(sqlDeleteContact,id);
        String sqlDeleteCustomer ="DELETE FROM customer WHERE customer_id = ?";
        return template.update(sqlDeleteCustomer,id) > 0;


    }

    public Customer findCustomerByID(int id){
        String sqlCustomer = " SELECT c.customer_id as customerID, c.customer_first_name as fName, c.customer_last_name as lName, r.customer_address as address, " +
                "r.customer_zip_code as zipCode,  r.customer_city as city, cc.customer_phonenumber as phoneNumber,  cc.customer_email as eMail," +
                "c.customer_licensenumber as driverLicenseNumber, c.customer_driver_since_date as driverSinceDate " +
                "FROM customer c JOIN residence r ON c.customer_id = r.customerResidence_id " +
                "JOIN contact cc ON r.customerResidence_id = cc.customerContact_id " +
                " WHERE c.customer_id = ?";
        RowMapper<Customer> rowMapper = new BeanPropertyRowMapper<>(Customer.class);
        Customer customer = template.queryForObject(sqlCustomer, rowMapper, id);
                return customer;
    }

    public void updateCustomer( Customer customer){
        String sqlUpdateCustomer = "UPDATE customer SET customer_first_name = ?, customer_last_name = ?, customer_licensenumber = ?, customer_driver_since_date = ? WHERE customer_id = ?";
            template.update(sqlUpdateCustomer, customer.getfName(), customer.getlName(), customer.getDriverLicenseNumber(), customer.getDriverSinceDate(), customer.getCustomerID());
        String sqlUpdateResidence = "UPDATE residence SET customer_address = ?, customer_city = ?, customer_zip_code = ? WHERE customerResidence_id = ?";
            template.update(sqlUpdateResidence, customer.getAddress(), customer.getCity(), customer.getZipCode(), customer.getCustomerID());
        String sqlUpdateContact = " UPDATE contact SET customer_phonenumber = ?, customer_email = ? WHERE customerContact_id = ?";
            template.update(sqlUpdateContact, customer.getPhoneNumber(), customer.geteMail(), customer.getCustomerID());


    }
}

/*



 String sqlUpdate = "UPDATE customer c, residence r, contact cc " +
                "SET c.customer_first_name = ?, c.customer_last_name = ?, c.customer_licensenumber = ?, " +
                "c.customer_driver_since_date = ?, " +
                "r.customer_address = ?, r.customer_city = ?, r.customer_zip_code = ?, " +
                "cc.customer_phonenumber = ?, cc.customer_email = ? " +
                "WHERE c.customer_id = ? AND r.customerResidence_id AND cc.customerContact_id = ?";
        template.update(sqlUpdate,customer.getfName(),customer.getlName(),customer.getDriverLicenseNumber(),
        customer.getDriverSinceDate(),customer.getAddress(),customer.getCity(),customer.getZipCode(),
        customer.getPhoneNumber(), customer.geteMail(),customer.getCustomerID(),
        customer.getCustomerID(),customer.getCustomerID());

 */
