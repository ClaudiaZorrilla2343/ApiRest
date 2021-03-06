package com.proof.app.sofka.controllers;

import com.proof.app.sofka.models.entities.User;
import com.proof.app.sofka.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;
import java.util.List;

@SessionAttributes("users")
@Controller
public class UserController {
    @Autowired
    UserServiceImpl userService;
    /**
    *Entra al componente spring y los metodos se van a utilizar cuando se ejecuten las respuestas http
    */
    @GetMapping("/view")
    public String view(Model model) {
        List<User> users = null;
        users = userService.findAll();
        model.addAttribute("tittle", "Create User");
        model.addAttribute("users", users);
        return "view";
    }

    @GetMapping("/form")
    public String form(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("tittle", "Create User");
        return "form";
    }
/**
 *Con este metodo cuando haya una respuesta post ya sea por medio del apiRest que infiere en postman o por un formulario
 * que inserte y se mape con los datos del usuario
 */
    @PostMapping("/form")
    public String form(@Valid User user, BindingResult bindingResult, Model model, SessionStatus status) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("tittle", "Create User");
            return "form";
        }
        userService.save(user);
        status.setComplete();
        return "redirect:/view";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        userService.deleteById(id);
        return "redirect:/view";
    }

    @GetMapping("/view/{priority}")
    public String view(@PathVariable int priority, Model model) {
        List<User> users = userService.findAllForPriority(priority);
        model.addAttribute("users", users);
        return "view";
    }
}