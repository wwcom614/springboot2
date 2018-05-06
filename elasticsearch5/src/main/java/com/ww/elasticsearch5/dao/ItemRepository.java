package com.ww.elasticsearch5.dao;

import com.ww.elasticsearch5.model.ItemDocument;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ItemRepository extends ElasticsearchRepository<ItemDocument, String> {

    Page<ItemDocument> findByItemName(String itemName, Pageable pageable);

    Page<ItemDocument> findByItemDesc(String itemDesc, Pageable pageable);
}
