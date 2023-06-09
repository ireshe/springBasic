package xyz.qualon.pos.pos.service;

import xyz.qualon.pos.pos.dto.CustomerDTO;
import xyz.qualon.pos.pos.dto.request.CustomerUpdateDTO;

import java.util.List;

public interface CustomerService {

    CustomerDTO getCustomerById(int customerId);

    public String saveCustomer(CustomerDTO customerDTO);

    String updateCustomer(CustomerUpdateDTO customerUpdateDTO);

    List<CustomerDTO> getAllCustomers();

    String deleteCustomer(int customerId);

    List<CustomerDTO> getAllCustomersByActiveStatus(boolean activeStatus);
}
