package com.graphql.example.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graphql.example.boundary.Partner;
import com.graphql.example.boundary.PartnerLink;
import com.graphql.example.boundary.PartnerLinks;
import com.graphql.example.boundary.PartnerProduct;
import com.graphql.example.service.PartnerLinkService;
import com.graphql.example.service.PartnerProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class GraphQueryResolver implements GraphQLQueryResolver {

    @Autowired
    PartnerLinkService partnerLinkService;

    @Autowired
    PartnerProductService partnerProductService;

    public List<Partner> partners() {
        List<PartnerLink> partnerLinks = partnerLinkService.getPartnerLinks().getLinks();
        List<PartnerProduct> partnerProducts = partnerProductService.getPartnerProducts().getProducts();

        List<Partner> partnerList = new ArrayList<Partner>();

        partnerLinks.forEach(partnerLink -> {

            Partner partner = Partner.builder()
                    .partner(partnerLink.getPartner())
                    .link(partnerLink.getLink())
                    .products(partnerProducts.stream()
                                             .filter(partnerProduct -> partnerProduct.getPartner().equals(partnerLink.getPartner()))
                                             .collect(Collectors.toList()))
                    .build();

            partnerList.add(partner);
        });

        return partnerList;

    }
}
