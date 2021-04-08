package com.msagres.devisMarker2.Controller;

import com.msagres.devisMarker2.Model.Client;
import com.msagres.devisMarker2.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/client")
    public String getAllClient(Model model) {
        List<Client> clientList = clientRepository.findAll();
        model.addAttribute("clientList", clientList);
        return "Vue/client";
    }

    @GetMapping("/client/new")
    public String createClientForm(Model model) {
        model.addAttribute("client", new Client());
        return "Vue/client_form";
    }

    @PostMapping("/client/save")
    public String saveQuotation(Client client) {
        clientRepository.save(client);
        return "redirect:/client";
    }
}
