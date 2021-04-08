package com.msagres.devisMarker2.Controller;

import com.msagres.devisMarker2.Model.Quotation;
import com.msagres.devisMarker2.Repository.QuotationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class QuotationController {

    @Autowired
    private QuotationRepository repository;

    @GetMapping("/quotation")
    public String getAllQuotations(Model model){
        List<Quotation> quotationList = repository.findAll();
        model.addAttribute("quotationList", quotationList);
        return "Vue/quotation";
    }

    @GetMapping("/quotation/new")
    public String createQuotationForm(Model model){
        model.addAttribute("quotation", new Quotation());
        return "Vue/quotation_form";
    }

    @PostMapping("/quotation/save")
    public String saveQuotation(Quotation quotation){
        repository.save(quotation);
        return "redirect:/quotation";
    }
}
