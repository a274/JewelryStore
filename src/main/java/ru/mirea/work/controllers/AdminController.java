package ru.mirea.work.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mirea.work.models.*;
import ru.mirea.work.services.*;

/**
 * Данный класс является контроллером админ-панели
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    private final TypeService typeService;
    private final ProductService productService;
    private final MetalTypeService metalTypeService;
    private final MetalService metalService;
    private final UserService userService;

    @Autowired
    public AdminController(TypeService typeService,
                           ProductService productService,
                           MetalTypeService metalTypeService,
                           MetalService metalService,
                           UserService userService) {
        this.typeService = typeService;
        this.productService = productService;
        this.metalTypeService = metalTypeService;
        this.metalService = metalService;
        this.userService = userService;
    }

    @GetMapping
    public String index(Authentication authentication, Model model) {
        model.addAttribute("userName", authentication.getName());
        return "AdminController/admin";
    }

    @GetMapping("/types")
    public String types(Model model) {
        model.addAttribute("types", typeService.getAllTypes());
        return "AdminController/admin-types";
    }

    @PostMapping("/types/create")
    public String typesCreate(@RequestParam(name = "name") String name) {
        Type newType = new Type();
        newType.setName(name);
        typeService.saveType(newType);
        return "redirect:/admin/types";
    }

    @PostMapping("/types/delete")
    public String typesDelete(@RequestParam(name = "id") int id) {
        typeService.deleteById(id);
        return "redirect:/admin/types";
    }

    @GetMapping("/metal")
    public String metal(Model model) {
        model.addAttribute("metal", metalService.getAllMetal());
        return "AdminController/admin-metal";
    }

    @PostMapping("/metal/create")
    public String metalCreate(@RequestParam(name = "name") String name) {
        Metal newMetal = new Metal();
        newMetal.setName(name);
        metalService.saveMetal(newMetal);
        return "redirect:/admin/metal";
    }

    @PostMapping("/metal/delete")
    public String metalDelete(@RequestParam(name = "id") int id) {
        metalService.deleteById(id);
        return "redirect:/admin/metal";
    }

    @GetMapping("/products")
    public String products(Model model) {
        model.addAttribute("products", productService.getAll());
        return "AdminController/admin-products";
    }

    @PostMapping("/products/create")
    public String createProduct(@RequestParam(name = "typesId") int typesId,
                                @RequestParam(name = "name") String name,
                                @RequestParam(name = "price") int price,
                                @RequestParam(name = "weight") int weight,
                                @RequestParam(name = "description") String description,
                                @RequestParam(name = "metalId") int metalId) {
        Product newProduct = new Product();
        newProduct.setTypesId(typesId);
        newProduct.setName(name);
        newProduct.setPrice(price);
        newProduct.setWeight(weight);
        newProduct.setDescription(description);
        newProduct.setMetalId(metalId);
        productService.saveProduct(newProduct);
        return "redirect:/admin/products";
    }

    @PostMapping("/products/delete")
    private String deleteProduct(@RequestParam(name = "id") int id) {
        productService.deleteById(id);
        return "redirect:/admin/products";
    }

    @GetMapping("/users")
    public String users(Model model) {
        model.addAttribute("users", userService.getAll());
        return "AdminController/admin-users";
    }

    @PostMapping("/users/create")
    public String createUser(@RequestParam(name = "email") String email,
                             @RequestParam(name = "username") String username,
                             @RequestParam(name = "password") String password,
                             @RequestParam(name = "role") String role) {
        User newUser = new User();
        newUser.setEmail(email);
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setRole(role);
        userService.saveUser(newUser);
        return "redirect:/admin/users";
    }

    @PostMapping("/users/delete")
    public String deleteUser(@RequestParam(name = "id") int id) {
        userService.deleteUser(id);
        return "redirect:/admin/users";
    }

    @GetMapping("/typesMetal")
    public String typesMetal(Model model) {
        model.addAttribute("typesMetal", metalTypeService.getAll());
        return "AdminController/admin-typesMetal";
    }

    @PostMapping("/typesMetal/create")
    public String typesMetalCreate(@RequestParam(name = "typesId") int typesId,
                                   @RequestParam(name = "metalId") int metalId) {
        MetalType newMetalType = new MetalType();
        newMetalType.setTypesId(typesId);
        newMetalType.setMetalId(metalId);
        metalTypeService.saveMetalType(newMetalType);
        return "redirect:/admin/typesMetal";
    }

    @PostMapping("/typesMetal/delete")
    public String typesMetalDelete(@RequestParam(name = "id") int id) {
        metalTypeService.deleteById(id);
        return "redirect:/admin/typesMetal";
    }
}
