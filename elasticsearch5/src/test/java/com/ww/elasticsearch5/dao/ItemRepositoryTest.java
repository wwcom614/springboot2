package com.ww.elasticsearch5.dao;

import com.ww.elasticsearch5.model.ItemDocument;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemRepositoryTest {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void saveItem(){
        ItemDocument itemDocument = new ItemDocument();
        itemDocument.setItemId("00003");
        itemDocument.setCategoryId(1);
        itemDocument.setItemName("萌鸡小队");
        itemDocument.setItemDesc("四只小二鸡卡通片");
        itemDocument.setItemPrice(34.56);

        itemRepository.save(itemDocument);
    }

    @Test
    public void findById(){
        ItemDocument itemDocument = itemRepository.findById("00001").get();
        System.out.println(itemDocument.toString());
    }


    @Test
    public void findByItemName() throws Exception {
        Page<ItemDocument> itemDocumentPage = itemRepository.findByItemName("鸡", new PageRequest(0, 10));
        itemDocumentPage.forEach(x -> System.out.println(x));
    }

    @Test
    public void findByItemDesc() throws Exception {
    }


}