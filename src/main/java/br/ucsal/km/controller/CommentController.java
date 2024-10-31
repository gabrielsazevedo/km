package br.ucsal.km.controller;

import br.ucsal.km.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;
    
    @PostMapping("/video/{id}/comment")
    public String addComment(@PathVariable Long id,
                           @RequestParam String content) {
        commentService.addComment(id, content);
        return "redirect:/video/" + id;
    }
}