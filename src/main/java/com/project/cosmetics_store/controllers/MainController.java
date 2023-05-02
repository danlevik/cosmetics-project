package com.project.cosmetics_store.controllers;

import com.project.cosmetics_store.models.*;
import com.project.cosmetics_store.repo.ItemsRepository;
import com.project.cosmetics_store.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * Main Controller class for main page and interacting with items
 * @author Anastasia Ovcharenko
 */
@Controller
public class MainController {

    @Autowired
    private ItemsRepository itemsRepository;

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
     * method for sending main page to client
     * @param user - user, that sent request
     * @param typeId - item type
     * @param model - holder of model attributes
     * @return rendered main page
     * @author Anastasia Ovcharenko
     */
    @GetMapping("/")
    public String mainPage(
            @AuthenticationPrincipal User user,
            @RequestParam(name = "typeId", required = false) Integer typeId,
            Model model) {

        String auth = user.getAuthorities().toString();


        model.addAttribute("authority", auth);
        model.addAttribute("types", typeService.getAllTypes());
        model.addAttribute("typeId", typeId);
        model.addAttribute("title", "Каталог");
        Iterable<Items> items = itemsRepository.findAll();
        model.addAttribute("clothes", items);


        if (typeId == null) {
//            model.addAttribute("products", products);
            model.addAttribute("clothes", items);
        }
        else{
            model.addAttribute("clothes", itemsService.getAllItemsByTypeId(typeId));
        }

        return "index";
    }

    /**
     * Class for items manipulation for admins
     * @author Daniil Levitsky
     */
    @Controller
    public class ItemsController {

//        @GetMapping("/page/{id}")
//        public String clothesPage(
//                @AuthenticationPrincipal User user,
//                @PathVariable(value="id") int id,
//                Model model) {
//
//            Clothes item = clothesService.getItemById(id);
//
//            model.addAttribute("item", item);
//            model.addAttribute("itemId", id);
//            model.addAttribute("item_type", typeService.getTypeById(item.getTypeId()));
//            model.addAttribute("types", typeService.getAllTypes());
//
//            Optional<Clothes> clothes = Optional.ofNullable(clothesRepository.findById(id));
//            ArrayList<Clothes> res = new ArrayList<>();
//            clothes.ifPresent(res::add);
//            model.addAttribute("clothes", res);
//
//            return "item-desc";
//        }

        /**
         * method for sending page with add form to client
         * @param model - holder of model attributes
         * @return rendered page with form for items adding
         * @author Daniil Levitsky
         */
        @GetMapping("/add")
        public String itemAddForm(Model model){
            return "itemAdd";
        }

        /**
         * method to send data about new item from client form to database
         * @param item_name - name of an item
         * @param cover_link - link to cover image for item
         * @param price - price of item
         * @param typeId - type of item
         * @param model - holder of model attributes
         * @return rendered main page via redirect
         * @author Daniil Levitsky
         */
        @PostMapping("/add")
        public String itemSave(@RequestParam String item_name,
                               @RequestParam String cover_link, @RequestParam int price,
                               @RequestParam int typeId, Model model){
            Items item = new Items(
                    item_name,
                    cover_link,
                    price,
                    typeId);

            itemsRepository.save(item);

            return "redirect:/";
        }

    }

    /**
     * method for getting user id from user authentication
     * @param authentication - user authentication
     * @return user id
     * @author Natalia Tuchina
     */
    private int getUserId(Authentication authentication) {
        if (authentication == null)
            return 0;
        else
            return ((User)userService.loadUserByUsername(authentication.getName())).getId();
    }

    /**
     * method for adding chosen item to basket table in database
     * @param authentication - user authentication
     * @param itemId - id of added item
     * @return rendered main page via redirect
     * @author Daniil Levitsky
     */
    @PostMapping("/page/{id}")
    public String addItemToBasket(
            Authentication authentication,
            @PathVariable(value = "id") int itemId
    ) {
            int userId = getUserId(authentication);
            Basket basket = basketService.getPurchaseByUserIdAndItemId(userId, itemId);
            if (basket == null){
                Basket newBasket = new Basket();
                newBasket.setUserId(userId);
                newBasket.setItemId(itemId);
                newBasket.setItemCount(1);
                basketService.savePurchase(newBasket);
//                return "redirect:/page/" + itemId;
                return "redirect:/";
            }
            else{
                basket.setItemCount(basket.getItemCount() + 1);
                basketService.savePurchase(basket);
//                return "redirect:/page/" + itemId;
                return "redirect:/";
//            }
        }
    }

    /**
     * method for adding chosen item to favorite table in database
     * @param authentication - user authentication
     * @param itemId - id of added item
     * @return rendered main page via redirect
     * @author Daniil Levitsky
     */
    @PostMapping("/favorites/{id}")
    public String addItemToFavs(
            Authentication authentication,
            @PathVariable(value = "id") int itemId,
            Model model
    ) {
        int userId = getUserId(authentication);
        Favorites favs = favService.getAddByUserIdAndItemId(userId, itemId);
        if (favs == null){
            Favorites newFavorites = new Favorites();
            newFavorites.setUserId(userId);
            newFavorites.setItemId(itemId);
            favService.saveAdd(newFavorites);
//                return "redirect:/page/" + itemId;
            return "redirect:/";
        }
        else{
            return "redirect:/";
//            }
        }
    }


    }
