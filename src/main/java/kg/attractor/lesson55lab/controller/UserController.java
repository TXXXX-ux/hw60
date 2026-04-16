package kg.attractor.lesson55lab.controller;

import jakarta.validation.Valid;
import kg.attractor.lesson55lab.dao.UserDao;
import kg.attractor.lesson55lab.dto.UserProfileDto;
import kg.attractor.lesson55lab.model.User;
import kg.attractor.lesson55lab.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;

@Controller
@RequestMapping("/profile")
@RequiredArgsConstructor
public class UserController {

    private final UserDao userDao;
    private final UserService userService;

    @GetMapping
    public String profilePage(Model model, Principal principal) {
        if (principal == null) {
            return "redirect:/auth/login";
        }
        String email = principal.getName();
        User user = userDao.findByEmail(email);

        if (user == null) {
            throw new RuntimeException("User not found");
        }
        model.addAttribute("user", user);
        return "profile";
    }

    @GetMapping("/edit")
    public String editPage(Model model, Principal principal) {
        String email = principal.getName();
        User user = userDao.findByEmail(email);
        model.addAttribute("user", user);
        return "edit_profile";
    }

    @PostMapping("/edit")
    public String editUser(@Valid UserProfileDto userProfileDto,
                           BindingResult bindingResult,
                           @RequestParam("photo") MultipartFile photo,
                           Principal principal,
                           Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("user", userProfileDto);
            return "edit_profile";
        }

        String email = principal.getName();

        try {
            userService.updateProfile(email, userProfileDto, photo);
        } catch (RuntimeException e) {
            model.addAttribute("status", "400");
            model.addAttribute("reason", e.getMessage());
            return "error";
        }

        return "redirect:/profile";
    }
}
