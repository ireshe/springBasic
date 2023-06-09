package xyz.qualon.pos.pos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.qualon.pos.pos.dto.CustomerDTO;
import xyz.qualon.pos.pos.dto.request.CustomerUpdateDTO;
import xyz.qualon.pos.pos.service.CustomerService;
import xyz.qualon.pos.pos.service.impl.CustomerServiceIMPL;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/save")
    public String saveCustomer(@RequestBody CustomerDTO customerDTO) {
//        CustomerServiceIMPL customerServiceIMPL = new CustomerServiceIMPL();
//        customerServiceIMPL.saveCustomer(customerDTO);
        return customerService.saveCustomer(customerDTO);
    }

    @PutMapping("/update")
    public String updateCustomer(@RequestBody CustomerUpdateDTO customerUpdateDTO) {
        return customerService.updateCustomer(customerUpdateDTO);
    }

    @GetMapping(
            path = "/get-by-id",
            params = "id"
    )
    public CustomerDTO getCustomerById(@RequestParam(value = "id") int customerId) {
        System.out.println("print value of customer " + customerId);
        CustomerDTO customerDTO = customerService.getCustomerById(customerId);
        return customerDTO;
    }

    @GetMapping(
            path = "/get-all-customers"
    )
    public List<CustomerDTO> getAllCustomers() {
        List<CustomerDTO> customerDTOList = customerService.getAllCustomers();
        return customerDTOList;
    }

    @DeleteMapping(
            path = "/delete-customer/{id}"
    )
    public String deleteCustomer(@PathVariable(value = "id") int customerId) {
        System.out.println("customer " + customerId + " deleted");
        String status = customerService.deleteCustomer(customerId);
        return status;
    }

    @GetMapping(
            path = "/get-all-customers-by-activestatus/{activeStatus}"
    )
    public List<CustomerDTO> getAllCustomers(@PathVariable(value = "activeStatus") boolean activeStatus) {
        List<CustomerDTO> customerDTOList = customerService.getAllCustomersByActiveStatus(activeStatus);
        return customerDTOList;
    }

}
