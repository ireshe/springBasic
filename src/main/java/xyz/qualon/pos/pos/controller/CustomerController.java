package xyz.qualon.pos.pos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.qualon.pos.pos.dto.CustomerDTO;
import xyz.qualon.pos.pos.dto.request.CustomerUpdateDTO;
import xyz.qualon.pos.pos.service.CustomerService;
import xyz.qualon.pos.pos.service.impl.CustomerServiceIMPL;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/save")
    public String saveCustomer(@RequestBody CustomerDTO customerDTO){
//        CustomerServiceIMPL customerServiceIMPL = new CustomerServiceIMPL();
//        customerServiceIMPL.saveCustomer(customerDTO);
        return customerService.saveCustomer(customerDTO);
    }

    @PutMapping("/update")
    public String updateCustomer(@RequestBody CustomerUpdateDTO customerUpdateDTO){
        return customerService.updateCustomer(customerUpdateDTO);
    }

    @GetMapping(
            path = "/get-by-id",
            params = "id"
    )
    public CustomerDTO getCustomerById(@RequestParam(value="id") int customerId){
        System.out.println("print value of customer "+ customerId);
        CustomerDTO customerDTO = customerService.getCustomerById(customerId);
        return customerDTO;
    }

}
