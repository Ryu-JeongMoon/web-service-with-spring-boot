package org.example.webservice.controller;

import lombok.RequiredArgsConstructor;
import org.example.webservice.config.auth.LoginUser;
import org.example.webservice.config.auth.dto.SessionUser;
import org.example.webservice.dto.PostsResponseDto;
import org.example.webservice.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final PostService postService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        model.addAttribute("posts", postService.findAllDesc());

        /**
         * @LoginUser Target 이 PARAMETER 이므로 메서드 매개변수 자리에 위치할 수 있고
         * 아래 코드를 어노테이션 방식으로 대체함
         * SessionUser user = (SessionUser) httpSession.getAttribute("user");
         */

        if (user != null)
            model.addAttribute("userName", user.getName());

        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {

        PostsResponseDto dto = postService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }


}
