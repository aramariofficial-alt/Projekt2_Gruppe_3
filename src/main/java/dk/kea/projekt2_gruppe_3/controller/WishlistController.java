package dk.kea.projekt2_gruppe_3.controller;

import dk.kea.projekt2_gruppe_3.model.Wishlist;
import dk.kea.projekt2_gruppe_3.repository.WishlistRepository;
import dk.kea.projekt2_gruppe_3.service.WishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class WishlistController {
    @Autowired
    private WishlistRepository wishlistRepository;

    @Autowired
    private WishService wishService;


    @GetMapping ("/")
    public String mainPage(Model model){
        List<Wishlist> wishlists = wishlistRepository.getAllWishlists();
        System.out.println("Antal ønskelister fundet: " + wishlists.size()); // Tjek konsollen!
        model.addAttribute("wishlists", wishlists);
        return "index";
    }

    @GetMapping ("/getCreateWishlist")
    public String createWishlist(){
        return "createWishlist";
    }

    @PostMapping ("/saveCreateWishlist")
    public String postCreateWishlist (@RequestParam("name")String name){
        String img = "/static/img/wishlist.png";

        Wishlist wishlist = new Wishlist(name,img);
        wishlistRepository.createWishlist(wishlist);
    return "redirect:/";
    }

    @PostMapping("/deleteWishlist")
    public String deleteWishlist(@RequestParam("id") int id){
        wishlistRepository.deleteWishlist(id);
        return "redirect:/";
    }


    @GetMapping("/getUpdateWishlist")
    public String updateWishlist(@RequestParam("id") int id, Model model){
        Wishlist wishlist = wishlistRepository.getWishlistById(id);
        model.addAttribute(wishlist);
        return "updateWishlist";
    }

    @PostMapping("/saveUpdateWishlist")
    public String postUpdateWishlist(@RequestParam("id") int id, @RequestParam("name") String name){
        String img = "/static/img/wishlist.png";
        Wishlist wishlist = new Wishlist(name, img);
        wishlist.setId(id);
        wishlistRepository.updateWishlist(wishlist);
        return "redirect:/";
    }

    @GetMapping("/wishlist/{id}")
    public String viewWishlistDetail(@PathVariable int id, Model model) {
        // Hent den specifikke ønskeliste baseret på id
         Wishlist wishlist = wishlistRepository.getWishlistById(id);
         model.addAttribute("wishlist", wishlist);

        return "wishlist"; // Den side der viser selve indholdet
    }

    @GetMapping("/aboutus")
    public String aboutUs() {
        return "AboutUs";
    }

}