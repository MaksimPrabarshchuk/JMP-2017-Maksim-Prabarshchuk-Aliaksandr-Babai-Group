package com.github.alebabai.jmp2k17.jpa.repository;

import com.github.alebabai.jmp2k17.jpa.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
        path = "users",
        collectionResourceRel = "users",
        itemResourceRel = "user"
)
public interface UserRepository extends PagingAndSortingRepository<User, Integer> {
}
