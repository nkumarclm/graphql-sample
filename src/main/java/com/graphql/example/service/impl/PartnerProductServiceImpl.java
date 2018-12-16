package com.graphql.example.service.impl;

import com.graphql.example.boundary.PartnerLinks;
import com.graphql.example.boundary.PartnerProducts;
import com.graphql.example.service.PartnerProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PartnerProductServiceImpl implements PartnerProductService {

    @Autowired
    @Qualifier("partnerRestTemplate")
    RestTemplate restTemplate;

    @Override
    public PartnerProducts getPartnerProducts() {
        String partnerProductUrl = "http://demo5040956.mockable.io/partnerProducts";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> httpEntity = new HttpEntity<String>(headers);
        ResponseEntity<PartnerProducts> response =
                restTemplate.exchange(partnerProductUrl, HttpMethod.GET, httpEntity, PartnerProducts.class);

        return response.getBody();
    }
}
