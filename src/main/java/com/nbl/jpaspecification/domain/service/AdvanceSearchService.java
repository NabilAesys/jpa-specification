package com.nbl.jpaspecification.domain.service;



import com.nbl.jpaspecification.domain.entity.Customer;
import com.nbl.jpaspecification.domain.repository.CustomerRepository;
import com.nbl.jpaspecification.model.SearchCriteriaRequest;
import com.nbl.jpaspecification.model.SearchResponse;
import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdvanceSearchService {

    private final CustomerRepository customerRepository;

    private final ModelMapper modelMapper;



    public List<SearchResponse> searchCustomerByCriteria(SearchCriteriaRequest searchCriteriaRequest) {
        List<Customer> customers = customerRepository.findAll(
                SearchSpecification.createSpecification(searchCriteriaRequest.getSearchCriteria()));
        return customers.stream().map(i -> modelMapper.map(i, SearchResponse.class)).toList();
    }

}
