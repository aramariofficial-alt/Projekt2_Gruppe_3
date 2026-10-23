package dk.kea.projekt2_gruppe_3.controller;

import dk.kea.projekt2_gruppe_3.model.Wish;
import dk.kea.projekt2_gruppe_3.repository.WishRepository;
import dk.kea.projekt2_gruppe_3.service.WishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class WishController {
    @Autowired
    WishRepository wishRepository;

    @Autowired
    WishService wishService;

    @GetMapping("/getCreateWish")
    public String createWish(@RequestParam("wishListId") int wishListId, Model model) {
        model.addAttribute("wishListId", wishListId);
        return "createWish";
    }
    @GetMapping("/getUpdateWish")
    public String updateCar(@RequestParam("id") int id, Model model){
        Wish wish = wishRepository.findWishById(id);
        model.addAttribute("wish",wish);
        return "updateWish";
    }

    @PostMapping("/saveCreateWish")
    public String postCreateWish(@RequestParam("name") String name,
                                 @RequestParam("description") String description,
                                 @RequestParam("price") double price,
                                 @RequestParam("link") String link,
                                 @RequestParam("category") String category,
                                 @RequestParam("wishListId")int wishListId) {
        String img = wishService.getImg(category);

        Wish wish = new Wish(name, description, price, link, category, img, wishListId);
        wishRepository.createWish(wish);
        return "redirect:/getWishlist?id=" + wishListId;
    }
    @PostMapping("/deleteWish")
    public String deleteWish(@RequestParam("id") int id, @RequestParam("wishListId") int wishListId) {
        wishRepository.deleteWish(id);
        return "redirect:/getWishlist?id=" + wishListId;
    }

    @PostMapping("/saveUpdateCar")
    public String postUpdateCar(@RequestParam("id") int id,
                                @RequestParam("name") String name,
                                @RequestParam("description")String description,
                                @RequestParam("price")double price,
                                @RequestParam("link")String link,
                                @RequestParam("category")String category,
                                @RequestParam("wishListId")int wishListId){

        String img = wishService.getImg(category);
        Wish wish = new Wish(name, description, price, link, category, img, wishListId);
        wish.setId(id);
        wishRepository.updateWish(wish);
        return "redirect:/getWishlist?id=" + wishListId;
    }
}
