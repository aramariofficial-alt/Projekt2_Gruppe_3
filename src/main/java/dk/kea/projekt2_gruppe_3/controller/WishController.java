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
    public String createWish(@RequestParam("wishlistId") int wishlistId, Model model) {
        model.addAttribute("wishlistId", wishlistId);
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
                                 @RequestParam("wishlistId")int wishlistId) {
        String img = wishService.getImg(category);

        Wish wish = new Wish(name, description, price, link, category, img, wishlistId);
        wishRepository.createWish(wish);
        return "redirect:/getWishlist?id=" + wishlistId;
    }
    @PostMapping("/deleteWish")
    public String deleteWish(@RequestParam("id") int id, @RequestParam("wishlistId") int wishlistId) {
        wishRepository.deleteWish(id);
        return "redirect:/getWishlist?id=" + wishlistId;
    }

    @PostMapping("/saveUpdateCar")
    public String postUpdateCar(@RequestParam("id") int id,
                                @RequestParam("name") String name,
                                @RequestParam("description")String description,
                                @RequestParam("price")double price,
                                @RequestParam("link")String link,
                                @RequestParam("category")String category,
                                @RequestParam("wishlistId")int wishlistId){

        String img = wishService.getImg(category);
        Wish wish = new Wish(name, description, price, link, category, img, wishlistId);
        wish.setId(id);
        wishRepository.updateWish(wish);
        return "redirect:/getWishlist?id=" + wishlistId;
    }
}
