package com.graphql.example.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graphql.example.boundary.PartnerLink;
import com.graphql.example.boundary.PartnerLinks;
import com.graphql.example.service.PartnerLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GraphQueryResolver implements GraphQLQueryResolver {

    @Autowired
    PartnerLinkService partnerLinkService;

    public List<PartnerLink> partnerLinks() {
        return partnerLinkService.getPartnerLinks().getLinks();
    }
}
