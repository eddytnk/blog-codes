package com.eddytnk.itemApi.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Author: Edward Tanko <br/>
 * Date: 12/24/19 3:37 PM <br/>
 */
@Entity
@Data
public class Item {

    @Id
    private Long id;
    private String name;
    private double price;
    private int quantity;
}
