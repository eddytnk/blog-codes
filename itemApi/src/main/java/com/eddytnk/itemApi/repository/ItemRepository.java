package com.eddytnk.itemApi.repository;

import com.eddytnk.itemApi.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Author: Edward Tanko <br/>
 * Date: 12/24/19 3:40 PM <br/>
 */
@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
