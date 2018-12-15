package com.graphql.example.service.impl;

import com.graphql.example.boundary.PartnerLinks;
import com.graphql.example.service.PartnerLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PartnerLinkServiceImpl implements PartnerLinkService {

    @Autowired
    @Qualifier("partnerRestTemplate")
    RestTemplate restTemplate;

    @Override
    public PartnerLinks getPartnerLinks(){

        String partnerLinkUrl = "http://demo5040956.mockable.io/partnerLinks";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> httpEntity = new HttpEntity<String>(headers);
        ResponseEntity<PartnerLinks> response =
                restTemplate.exchange(partnerLinkUrl, HttpMethod.GET, httpEntity, PartnerLinks.class);

        return response.getBody();
    }
}
