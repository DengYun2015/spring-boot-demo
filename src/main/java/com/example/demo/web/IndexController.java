package com.example.demo.web;

import com.example.demo.domain.Post;
import com.example.demo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by dengyun on 2017/9/4.
 */
@RestController
@RequestMapping("/")
public class IndexController {

    @Autowired
    private PostRepository postRepository;

    @RequestMapping({"/index","/"})
    public List<Post> index()
    {
        Post post = new Post("测试标题","测试内容",123);
        postRepository.save(post);
        return postRepository.findAll();
    }
}
