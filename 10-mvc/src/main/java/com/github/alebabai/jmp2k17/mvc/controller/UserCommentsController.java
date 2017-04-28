package com.github.alebabai.jmp2k17.mvc.controller;

import com.github.alebabai.jmp2k17.mvc.domain.Comment;
import com.github.alebabai.jmp2k17.mvc.domain.User;
import com.github.alebabai.jmp2k17.mvc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@Controller
public class UserCommentsController {

    private final UserRepository userRepository;

    @Autowired
    public UserCommentsController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/my-comments")
    public ModelAndView myComments(Principal principal) {
        final List<Comment> comments = userRepository.findByUsername(principal.getName())
                .map(User::getComments)
                .orElse(Collections.emptyList());
        final HashMap<String, Object> model = new HashMap<>();
        model.put("comments", comments);
        return new ModelAndView("user-comments", model);
    }

    @PostMapping("/my-comments/update-comment")
    public String updateComment() {
        return "redirect:/my-comments";
    }
}
