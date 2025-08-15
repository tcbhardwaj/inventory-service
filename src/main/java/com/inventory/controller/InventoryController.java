package com.inventory.controller;

import com.inventory.entity.Inventory;
import com.inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
    // Define endpoints for inventory operations here
    // For example:
    @Autowired
    private InventoryService inventoryService;

    @PostMapping
    public ResponseEntity<Inventory> addInventory(@RequestBody Inventory inventory) {
        return ResponseEntity.ok(inventoryService.addInventory(inventory));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inventory> getInventoryById(@PathVariable long id) {
        return inventoryService.getInventoryById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    // Add other CRUD operations as needed
    @PutMapping("/{id}")
    public ResponseEntity<Inventory> updateInventory(@PathVariable long id, @RequestBody Inventory inventory) {
        return inventoryService.updateInventory(id, inventory)
            .map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInventory(@PathVariable long id) {
        inventoryService.deleteInventory(id);
        return ResponseEntity.noContent().build();
    }

    //get inventory details by productId
    @GetMapping("/product/{productId}")
    public ResponseEntity<Inventory> getInventoryByProductId(@PathVariable String productId) {
        return inventoryService.getInventoryByProductId(productId)
            .map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
