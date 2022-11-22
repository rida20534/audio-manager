package com.rdasystems.audiomanager.web;

import com.rdasystems.audiomanager.dao.InventoryRepository;
import com.rdasystems.audiomanager.model.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminRestController {
    @Autowired
    InventoryRepository inventoryRepository;
    @GetMapping("/inventories")
    public List<Inventory> showInventories(){
        return inventoryRepository.findAll();
    }
}
