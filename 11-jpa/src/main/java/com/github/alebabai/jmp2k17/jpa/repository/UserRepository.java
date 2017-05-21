package com.github.alebabai.jmp2k17.jpa.repository;

import com.github.alebabai.jmp2k17.jpa.domain.User;
import com.github.alebabai.jmp2k17.jpa.projection.UserWithRolesProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
        path = "users",
        collectionResourceRel = "users",
        itemResourceRel = "user",
        excerptProjection = UserWithRolesProjection.class
)
public interface UserRepository extends PagingAndSortingRepository<User, Integer> {
}
