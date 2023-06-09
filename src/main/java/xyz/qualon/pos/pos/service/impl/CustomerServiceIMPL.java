package xyz.qualon.pos.pos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.qualon.pos.pos.dto.CustomerDTO;
import xyz.qualon.pos.pos.dto.request.CustomerUpdateDTO;
import xyz.qualon.pos.pos.entity.Customer;
import xyz.qualon.pos.pos.repo.CustomerRepo;
import xyz.qualon.pos.pos.service.CustomerService;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceIMPL implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public CustomerDTO getCustomerById(int customerId) {

        if (customerRepo.existsById(customerId)) {
            Customer customer = customerRepo.getReferenceById(customerId);
            CustomerDTO customerDTO = new CustomerDTO(customer.getCustomerId(), customer.getCustomerName(), customer.getCustomerAddress(), customer.getCustomerNumber(), customer.getNic(), customer.getCustomerSalary(), customer.isActive());
            return customerDTO;
        } else throw new RuntimeException("no user found");
    }

    public String saveCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer(customerDTO.getCustomerId(), customerDTO.getCustomerName(), customerDTO.getCustomerAddress(), customerDTO.getCustomerNumber(), customerDTO.getNic(), customerDTO.getCustomerSalary(), customerDTO.isActive());
//        Customer customer = new Customer();
//        customer.setCustomerId(customerDTO.getCustomerId());
//        customer.setCustomerName(customerDTO.getCustomerName());
//        customer.setCustomerAddress(customerDTO.getCustomerAddress());
//        customer.setCustomerSalary(customerDTO.getCustomerSalary());
        customerRepo.save(customer);
//        System.out.println(customerDTO.getCustomerAddress());
        return customerDTO.getCustomerName() + " user save successfully";
    }

    @Override
    public String updateCustomer(CustomerUpdateDTO customerUpdateDTO) {
        if (customerRepo.existsById(customerUpdateDTO.getCustomerId())) {
            Customer customer = customerRepo.getReferenceById(customerUpdateDTO.getCustomerId());

            customer.setCustomerName(customerUpdateDTO.getCustomerName());
            customer.setCustomerAddress(customerUpdateDTO.getCustomerAddress());
            customer.setCustomerSalary(customerUpdateDTO.getCustomerSalary());

            customerRepo.save(customer);
            return "user " + customerUpdateDTO.getCustomerId() + " updated successfully";
        } else throw new RuntimeException("record not found");
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> getAllCustomers = customerRepo.findAll();
        List<CustomerDTO> customerDTOList = new ArrayList<>();
        for (Customer customer : getAllCustomers) {
            CustomerDTO customerDTO = new CustomerDTO(customer.getCustomerId(), customer.getCustomerName(), customer.getCustomerAddress(), customer.getCustomerNumber(), customer.getNic(), customer.getCustomerSalary(), customer.isActive());
            customerDTOList.add(customerDTO);
        }
        return customerDTOList;
    }

    @Override
    public String deleteCustomer(int customerId) {
        if (customerRepo.existsById(customerId)) {
            customerRepo.deleteById(customerId);
            return "deleted successfully";
        } else throw new RuntimeException("no user found");
    }

    @Override
    public List<CustomerDTO> getAllCustomersByActiveStatus(boolean activeStatus) {
        List<Customer> getAllCustomers = customerRepo.findAllByIsActiveEquals(activeStatus);
        List<CustomerDTO> customerDTOList = new ArrayList<>();
        for (Customer customer : getAllCustomers) {
            CustomerDTO customerDTO = new CustomerDTO(customer.getCustomerId(), customer.getCustomerName(), customer.getCustomerAddress(), customer.getCustomerNumber(), customer.getNic(), customer.getCustomerSalary(), customer.isActive());
            customerDTOList.add(customerDTO);
        }
        return customerDTOList;
    }
}
