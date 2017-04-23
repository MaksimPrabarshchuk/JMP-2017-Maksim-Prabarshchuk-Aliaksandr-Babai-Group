package com.github.alebabai.jmp2k17.tomcat.repository;

import com.github.alebabai.jmp2k17.tomcat.domain.Post;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "posts", collectionResourceRel = "posts", itemResourceRel = "post")
public interface PostRepository extends PagingAndSortingRepository<Post, Integer> {
}
