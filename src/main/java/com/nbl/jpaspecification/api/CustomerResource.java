package com.nbl.jpaspecification.api;

import com.nbl.jpaspecification.domain.entity.Customer;
import com.nbl.jpaspecification.domain.repository.CustomerRepository;
import com.nbl.jpaspecification.domain.service.AdvanceSearchService;
import com.nbl.jpaspecification.model.SearchCriteriaRequest;
import com.nbl.jpaspecification.model.SearchResponse;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/demo-service")
public class CustomerResource {
    private final AdvanceSearchService advanceSearchService;
    private final CustomerRepository customerRepository;

    @PostMapping("/advance-search")
    public ResponseEntity<List<SearchResponse>> searchByCriteria(@RequestBody SearchCriteriaRequest searchCriteria) {
        return ResponseEntity.ok(advanceSearchService.searchCustomerByCriteria(searchCriteria));
    }

    @PostMapping("/create")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        return ResponseEntity.ok(customerRepository.save(customer));
    }

    @GetMapping("findAll")
    public ResponseEntity<List<Customer>> getCarts(){
        List<Customer> customers = (List<Customer>) customerRepository.findAll();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
}
