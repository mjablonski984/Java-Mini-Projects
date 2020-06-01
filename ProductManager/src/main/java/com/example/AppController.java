package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

//@Controller annotation indicates that a particular class serves the role of a controller
@Controller
public class AppController {

    @Autowired
    private ProductService service;

    // @RequestMapping describes a route
    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<Product> listProducts = service.listAll();
        model.addAttribute("listProducts", listProducts);

        return "index";
    }

    @RequestMapping("/new")
    public String showNewProductPage(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);

        return "new_product";
    }

    // Http post request to a /save endpoint with a product object
    // @ModelAttribute("name") is the same as the name of an object from a template
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") Product product) {
        service.save(product);
        // After the product is inserted into the database, redirects to the homepage.
        return "redirect:/";
    }

    // ModelAndView - Represents a model and view returned by a handler,
    // to be resolved by a DispatcherServlet.
    // @PathVariable indicates that a method parameter should be bound to a URI
    // template variable.
    @RequestMapping("/edit/{id}")
    public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_product");
        // send the product data to: edid/productID
        Product product = service.get(id);
        mav.addObject("product", product);

        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/";
    }

}