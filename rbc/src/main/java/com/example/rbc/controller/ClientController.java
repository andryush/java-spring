package com.example.rbc.controller;

import com.example.rbc.model.Client;
import com.example.rbc.service.ClientService;
import com.example.rbc.validator.ClientValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ClientController {

    private final ClientService clientService;
    private final ClientValidator clientValidator;

    @Autowired
    public ClientController(ClientService clientService, ClientValidator clientValidator) {
        this.clientService = clientService;
        this.clientValidator = clientValidator;
    }

    @GetMapping({"/", "/welcome"})
    public String getAll(Model model) {

        List<Client> clients = clientService.getAll();

        model.addAttribute("clients",clients);

        return "welcome";
    }

    @GetMapping("/clients/showClientForm")
    public String showClientForm(Model model) {

        model.addAttribute("clientForm", new Client());
        return "showClientForm";

    }

    @GetMapping("/clients/showClientFormForUpdate")
    public String showClientFormForUpdate(@RequestParam("clientId") Long id, Model model) {

        Client clientForm = clientService.getById(id);

        model.addAttribute("clientForm", clientForm);

        return "showClientForm";

    }

    @PostMapping("/clients/save")
    public String saveClient(@ModelAttribute("clientForm") Client clientForm, BindingResult bindingResult) {

        clientValidator.validate(clientForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "showClientForm";
        }

        clientService.save(clientForm);

        return "redirect:/welcome";
    }

    @GetMapping("/clients/delete")
    public String delete(@RequestParam("clientId") Long id) {
        clientService.delete(id);

        return "redirect:/welcome";
    }

}
