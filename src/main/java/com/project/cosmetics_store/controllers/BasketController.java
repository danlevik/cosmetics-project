package com.project.cosmetics_store.controllers;

import com.project.cosmetics_store.models.Basket;
import com.project.cosmetics_store.models.User;
import com.project.cosmetics_store.service.BasketService;
import com.project.cosmetics_store.service.ItemsService;
import com.project.cosmetics_store.service.TypeService;
import com.project.cosmetics_store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Class for basket logic
 * @author Vasilisa Murunova
 */
@Controller
@RequestMapping("/")
public class BasketController {

    @Autowired
    private ItemsService itemsService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private UserService userService;

    @Autowired
    private BasketService basketService;


    /**
     * method for getting price of all items in user's basket
     * @param purchases - list of items in user basket
     * @return total price of items
     * @author Vasilisa Murunova
     */
    private int getBasketPrice(List<Basket> purchases) {
        int total = 0;
        for (Basket basket: purchases){
            total += itemsService.getItemById(basket.getItemId()).getPrice() * basket.getItemCount();
        }
        return total;
    }

    /**
     * method for rendering basket page
     * @param model - holder of model attributes
     * @param user - current user
     * @return rendered basket page
     * @author Vasilisa Murunova
     */
    @GetMapping("/basket")
    public String basket(Model model,
                         @AuthenticationPrincipal User user){

        int userId = user.getId();
        model.addAttribute("basketPrice", getBasketPrice(basketService.getPurchasesByUserId(userId)));
        model.addAttribute("types", typeService.getAllTypes());

        List<Basket> purchases = basketService.getPurchasesByUserId(userId);

        model.addAttribute("basket", purchases);
        model.addAttribute("clothesService", itemsService);

        return "basket";
    }

    /**
     * method for deleting item from basket by item id
     * @param purchaseId - item id
     * @return rendered basket page via redirect
     * @author Vasilisa Murunova
     */
    @PostMapping("/basketDeletePurchase")
    public String deletePurchase(@RequestParam(value = "delButton") int purchaseId){
        basketService.deletePurchaseById(purchaseId);
        return "redirect:/basket";
    }

    /**
     * method for increasing item amount in basket
     * @param purchaseId - item id
     * @return rendered basket page via redirect
     * @author Vasilisa Murunova
     */
    @PostMapping("/basketIncrPurchase")
    public String increasePurchase(@RequestParam(value = "incrButton") int purchaseId){
        Basket purchase = basketService.getPurchaseById(purchaseId);
        purchase.setItemCount(purchase.getItemCount() + 1);
        basketService.savePurchase(purchase);
        return "redirect:/basket";
    }

    /**
     * method for decreasing item amount in basket
     * @param purchaseId - item id
     * @return rendered basket page via redirect
     * @author Vasilisa Murunova
     */
    @PostMapping("/basketDecrPurchase")
    public String decreasePurchase(@RequestParam(value = "decrButton") int purchaseId){
        Basket purchase = basketService.getPurchaseById(purchaseId);
        purchase.setItemCount(purchase.getItemCount() - 1);
        basketService.savePurchase(purchase);
        if (purchase.getItemCount() <= 0){
            basketService.deletePurchase(purchase);
        }
        return "redirect:/basket";
    }

}
