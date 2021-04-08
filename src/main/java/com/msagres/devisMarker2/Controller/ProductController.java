package com.msagres.devisMarker2.Controller;

import com.msagres.devisMarker2.Model.Product;
import com.msagres.devisMarker2.Model.Quotation;
import com.msagres.devisMarker2.Repository.ProductRepository;
import com.msagres.devisMarker2.Repository.QuotationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.UUID;

@Controller
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    QuotationRepository quotationRepository;

    @GetMapping("/product")
    public String listProducts(Model model) {
        List<Product> productList = productRepository.findAll();
        model.addAttribute("productList", productList);

        return "Vue/product";
    }

    @GetMapping("/product/new")
    public String showNewProductForm(Model model) {
        List<Quotation> quotationList = quotationRepository.findAll();
        model.addAttribute("product", new Product());
        model.addAttribute("quotationList", quotationList);

        return "Vue/product_form";
    }

    @PostMapping("/product/save")
    public String saveProduct(Product product) {
        productRepository.save(product);

        return "redirect:/product";
    }

    @GetMapping("/product/edit/{id}")
    public String showEditProductForm(@PathVariable("id") UUID id, Model model) {
        Product product = productRepository.findById(id).get();
        model.addAttribute("product", product);

        List<Quotation> quotationList = quotationRepository.findAll();
        model.addAttribute("quotationList", quotationList);

        return "Vue/product_form";
    }

    @GetMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable("id") UUID id, Model model){
        productRepository.deleteById(id);

        return "redirect:/product";
    }
}
