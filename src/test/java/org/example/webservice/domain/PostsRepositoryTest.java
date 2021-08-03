package org.example.webservice.domain;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
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

    @Test
    void BaseTimeEntity() {
        LocalDateTime longTimeAgo = LocalDateTime.of(2021, 3, 24, 0, 0, 0);
        postsRepository.save(Posts.builder()
                .title("title")
                .content("iphone")
                .author("jobs")
                .build());

        List<Posts> postsList = postsRepository.findAll();

        Posts posts = postsList.get(0);

        assertThat(posts.getCreateDate().isAfter(longTimeAgo));
        assertThat(posts.getModifiedDate().isAfter(longTimeAgo));

    }
}