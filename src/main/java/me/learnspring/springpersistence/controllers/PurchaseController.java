package me.learnspring.springpersistence.controllers;

import me.learnspring.springpersistence.model.Purchase;
import me.learnspring.springpersistence.repositories.PurchaseRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    private final PurchaseRepository purchaseRepository;

    public PurchaseController(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    @PostMapping
    public void storePurchase(@RequestBody Purchase purchase) {
        purchaseRepository.addPurchase(purchase);
    }

    @GetMapping
    public List<Purchase> getPurchases() {
        return purchaseRepository.findAllPurchases();
    }
}
