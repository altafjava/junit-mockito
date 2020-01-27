package com.altaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.altaf.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, String> {

}
