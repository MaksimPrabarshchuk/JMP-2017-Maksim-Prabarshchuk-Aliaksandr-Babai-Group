package com.github.alebabai.jmp2k17.mvc.controller;

import com.github.alebabai.jmp2k17.mvc.domain.Comment;
import com.github.alebabai.jmp2k17.mvc.domain.User;
import com.github.alebabai.jmp2k17.mvc.repository.CommentRepository;
import com.github.alebabai.jmp2k17.mvc.repository.UserRepository;
import com.github.alebabai.jmp2k17.mvc.util.CommentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.criteria.Order;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Controller
public class WallController {

    private final UserRepository userRepository;
    private final CommentRepository commentRepository;

    @Autowired
    public WallController(UserRepository userRepository, CommentRepository commentRepository) {
        this.userRepository = userRepository;
        this.commentRepository = commentRepository;
    }

    @GetMapping("/")
    public ModelAndView page(@RequestParam(name = "filter", required = false) String filterQuery) {
        final HashMap<String, Object> model = new HashMap<>();
        final List<Comment> comments = Optional.ofNullable(filterQuery)
                .map(commentRepository::findAllByUser_Username_Containing)
                .orElseGet(() -> (List<Comment>)commentRepository.findAll(new Sort(Sort.Direction.DESC, "createdAt")));
        model.put("comments", comments);
        return new ModelAndView("wall", model);
    }

    @PostMapping(value = "/send-comment")
    public String sendComment(@RequestParam("username") String username, @RequestParam("text") String text) {
        final String validUsername = CommentUtils.getValidUsername(username);
        final User user = userRepository.findByUsername(validUsername)
                .orElseGet(() -> userRepository.save(new User(validUsername)));
        commentRepository.save(new Comment(text, user));
        return "redirect:/";
    }
}
