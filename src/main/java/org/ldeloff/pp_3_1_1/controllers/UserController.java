package org.ldeloff.pp_3_1_1.controllers;

import org.ldeloff.pp_3_1_1.model.User;
import org.ldeloff.pp_3_1_1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class UserController {
    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String allUser(Model model) {
        model.addAttribute("users", userService.allUser());
        return "allUsers";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable("id") long id, Model model) {
        model.addAttribute("person", userService.getById(id));
        return "getById";
    }

    @GetMapping("/new")
    public String newPerson(Model model){
        model.addAttribute("person", new User());
        return "new";
    }

    @PostMapping()
    public String add(@ModelAttribute("person") User user) {
        userService.add(user);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model,@PathVariable("id") long id) {
        model.addAttribute("person", userService.getById(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") User user) {
        userService.edit(user);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id) {
        userService.delete(id);
        return "redirect:/";
    }
}
