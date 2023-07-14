package com.zincat.springapi.customer.controller;

import com.zincat.springapi.common.response.GenericResponse;
import com.zincat.springapi.customer.dto.CustomerDto;
import com.zincat.springapi.customer.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

/**
 * author: Menaka Lakshan
 */

@CrossOrigin
@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public GenericResponse getAllCustomers() {
        System.out.println("get request received");
        return new GenericResponse(200, "customers were fetched", customerService.getAllCustomers());
    }

    @PostMapping
    public GenericResponse saveCustomer(@RequestBody CustomerDto customerDto) throws ParseException {
        System.out.println("received");
        System.out.println();
        if (customerService.saveCustomer(customerDto))
            return new GenericResponse(200, "customer Saved successfully", null);
        else return new GenericResponse(200, "there is an error while saving the customer", null);
    }

    @DeleteMapping(params = {"id"})
    public GenericResponse deleteCustomerById(Long id) {
        GenericResponse response = new GenericResponse();
        if (customerService.deleteCustomerById(id)) {
            response.setStatusCode(200);
            response.setMessage("Customer has been deleted successfully");
        }
        response.setStatusCode(500);
        response.setMessage("There is an error with this...");
        return response;
    }

    @GetMapping(path = "/search", params = {"keywords"})
    public GenericResponse searchCustomersByAll(String keywords) {
        System.out.println("request received for search");
        return new GenericResponse(200, "success", customerService.searchCustomerByAll(keywords));
    }
}
