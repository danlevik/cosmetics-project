package com.project.cosmetics_store.controllers;

import com.project.cosmetics_store.models.Favorites;
import com.project.cosmetics_store.models.User;
import com.project.cosmetics_store.service.*;
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
 * Class for favorites page logic
 * @author Natalia Tuchina
 */
@Controller
@RequestMapping("/")
public class FavoritesController {

    @Autowired
    private ItemsService itemsService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private UserService userService;

    @Autowired
    private BasketService basketService;


    @Autowired
    private FavoritesService favService;


    /**
     * method for rendering favorites page
     * @param model - holder of model attributes
     * @param user - current user
     * @return rendered favorites page
     * @author Natalia Tuchina
     */
    @GetMapping("/favorites")
    public String favorites(Model model,
                         @AuthenticationPrincipal User user){

        int userId = user.getId();
        model.addAttribute("types", typeService.getAllTypes());

        List<Favorites> adds = favService.getAddsByUserId(userId);

        model.addAttribute("favorites", adds);
        model.addAttribute("clothesService", itemsService);

        return "favorites";
    }

    /**
     * method for deleting item from favorites
     * @param addId - item id
     * @return rendered favorites page via redirect
     * @author Natalia Tuchina
     */
    @PostMapping("/favoritesDeleteAdd")
    public String deleteAdd(@RequestParam(value = "delButton") int addId){
        favService.deleteAddById(addId);
        return "redirect:/favorites";
    }


}

