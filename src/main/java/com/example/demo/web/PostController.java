package com.example.demo.web;

import com.example.demo.domain.Post;
import com.example.demo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RequestMapping("/post")
@Controller
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @RequestMapping("/list")
    public String list(@RequestParam(value = "page", defaultValue = "1") int page, Model model) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        int size = 5;
        if (page < 1) {
            page = 1;
        }
        Pageable pageable = new PageRequest(page - 1, size, sort);
        model.addAttribute("posts", postRepository.findAll(pageable));
        model.addAttribute("page", page);
        Long count = postRepository.count();
        System.out.println("count:"+count);
        int totalPage = (int) Math.ceil((double)count / size);
        System.out.println("totalPage:"+totalPage);
        model.addAttribute("count", count);
        model.addAttribute("totalPage", totalPage);
        return "list";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String add(Model model, @RequestParam(value = "id", defaultValue = "0") Integer id) {
        model.addAttribute("id", id);
        return "edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(@RequestParam(value = "title") String title, @RequestParam(value = "content") String content, Model model) {
        int userId = 0;
        if (title.isEmpty() || content.isEmpty()) {
            model.addAttribute("error", true);
            model.addAttribute("errorMsg", "信息为空！");
        }
        Post post = new Post(title, content, userId);
        try {
            postRepository.save(post);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        model.addAttribute("error", false);
        model.addAttribute("title", title);
        model.addAttribute("content", content);
        return "detail";
    }
}
