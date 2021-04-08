package com.msagres.devisMarker2.Controller;

import com.msagres.devisMarker2.Model.Client;
import com.msagres.devisMarker2.Model.Quotation;
import com.msagres.devisMarker2.Repository.QuotationRepository;
import com.msagres.devisMarker2.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.UUID;

@Controller
public class QuotationController {
    @Autowired
    QuotationRepository quotationRepository;

    @Autowired
    ClientRepository clientRepository;

    @GetMapping("/quotation")
    public String listQuotations(Model model) {
        List<Quotation> quotationList = quotationRepository.findAll();
        model.addAttribute("quotationList", quotationList);

        return "Vue/quotation";
    }

    @GetMapping("/quotation/new")
    public String showNewQuotationForm(Model model) {
        List<Client> clientList = clientRepository.findAll();
        model.addAttribute("quotation", new Quotation());
        model.addAttribute("clientList", clientList);

        return "Vue/quotation_form";
    }

    @PostMapping("/quotation/save")
    public String saveQuotation(Quotation quotation) {
        quotationRepository.save(quotation);

        return "redirect:/quotation";
    }

    @GetMapping("/quotation/edit/{id}")
    public String showEditQuotationForm(@PathVariable("id") UUID id, Model model) {
        Quotation quotation = quotationRepository.findById(id).get();
        model.addAttribute("quotation", quotation);

        List<Client> clientList = clientRepository.findAll();
        model.addAttribute("clientList", clientList);

        return "Vue/quotation_form";
    }

    @GetMapping("/quotation/delete/{id}")
    public String deleteQuotation(@PathVariable("id") UUID id, Model model) {
        quotationRepository.deleteById(id);

        return "redirect:/quotation";
    }
}
