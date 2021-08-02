package org.example.webservice.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @Test
    public void bringNotice() {

        String title = "JPA";
        String content = "Fun";
        String author = "kim";

        Posts posts = new Posts(title, content, author);
        postsRepository.save(posts);

        List<Posts> all = postsRepository.findAll();
        Posts findPosts = all.get(0);

        assertThat(findPosts.getTitle()).isEqualTo(title);
        assertThat(findPosts.getContent()).isEqualTo(content);


    }
}