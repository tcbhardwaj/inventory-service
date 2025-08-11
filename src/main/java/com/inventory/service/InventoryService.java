package com.inventory.service;

import com.inventory.entity.Inventory;

import java.util.List;
import java.util.Optional;

public interface InventoryService {
    Inventory addInventory(Inventory inventory);
    Inventory updateInventory(long id, Inventory inventory);
    void deleteInventory(long id);
    List<Inventory> getAllInventories();
    Optional<Inventory> getInventoryById(long id);
    Optional<Inventory> getInventoryByProductId(String productId);
}
