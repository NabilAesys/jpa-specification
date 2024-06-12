package com.nbl.jpaspecification.model;

import java.util.List;

import lombok.Data;

@Data
public class SearchCriteriaRequest {
    List<SearchCriteria> searchCriteria;

    public List<SearchCriteria> getSearchCriteria() {
        return searchCriteria;
    }

    public void setSearchCriteria(List<SearchCriteria> searchCriteria) {
        this.searchCriteria = searchCriteria;
    }
}
