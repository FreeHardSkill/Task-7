package ru.freehardskill.springmvctask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.freehardskill.springmvctask.model.User;
import ru.freehardskill.springmvctask.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String mainPage(Model model) {
        model.addAttribute("users",userService.getAllUsers());
        return "user/user";
    }

    @GetMapping("/{id}")
    public String getUserFromId(@PathVariable("id")long id, Model model) {
        model.addAttribute("user",userService.getUserFromId(id));
        return "user/id";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "user/new";
    }
    @PostMapping("")
    public String createUser(@ModelAttribute("user") User user) {
        if(user.getEmail() !=null) userService.createUser(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String updatingUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("user",userService.getUserFromId(id));
        return "/user/edit";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/users/{id}";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id) {
        userService.deleteUserById(id);
        return "redirect:/users";
    }
}
