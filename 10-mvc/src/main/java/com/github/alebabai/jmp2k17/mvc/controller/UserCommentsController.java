package com.github.alebabai.jmp2k17.mvc.controller;

import com.github.alebabai.jmp2k17.mvc.domain.Comment;
import com.github.alebabai.jmp2k17.mvc.domain.User;
import com.github.alebabai.jmp2k17.mvc.repository.CommentRepository;
import com.github.alebabai.jmp2k17.mvc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Controller
public class UserCommentsController {

    private final UserRepository userRepository;
    private final CommentRepository commentRepository;

    @Autowired
    public UserCommentsController(UserRepository userRepository, CommentRepository commentRepository) {
        this.userRepository = userRepository;
        this.commentRepository = commentRepository;
    }

    @GetMapping("/my-comments")
    public ModelAndView myComments(Principal principal) {
        final List<Comment> comments = Optional.ofNullable(principal)
                .map(Principal::getName)
                .flatMap(userRepository::findByUsername)
                .map(User::getComments)
                .orElse(Collections.emptyList());
        final HashMap<String, Object> model = new HashMap<>();
        model.put("comments", comments);
        return new ModelAndView("user-comments", model);
    }

    @PostMapping("/my-comments/update-comment")
    public String updateComment(@RequestParam("comment_id") Integer id, @RequestParam String text) {
        final Comment comment = commentRepository.findOne(id);
        Assert.notNull(comment, "Comment should be not null!");
        comment.setText(text);
        commentRepository.save(comment);
        return "redirect:/my-comments";
    }
}
