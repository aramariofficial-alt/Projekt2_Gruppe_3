package dk.kea.projekt2_gruppe_3.controller;

import dk.kea.projekt2_gruppe_3.model.Wishlist;
import dk.kea.projekt2_gruppe_3.repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class WishlistController {
    @Autowired
    private WishlistRepository wishlistRepository;


    @GetMapping ("/")
        public String mainPage(Model model){
            List<Wishlist> wishlists = wishlistRepository.getAllWishlists();
            model.addAttribute("wishlists", wishlists);
        return "index";
    }
}