package org.erfan.erfanu25.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Order {
    Long id;
    int quantity;
    String itemName;
    Customer customer;
    long price;
    String status;
    Date order;

}
