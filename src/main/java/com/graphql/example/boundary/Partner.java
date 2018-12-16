package com.graphql.example.boundary;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Partner {
    String partner;
    String link;
    List<PartnerProduct> products;
}
