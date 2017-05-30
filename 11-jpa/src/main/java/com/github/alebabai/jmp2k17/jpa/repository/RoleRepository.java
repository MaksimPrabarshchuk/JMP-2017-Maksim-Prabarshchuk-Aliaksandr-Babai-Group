package com.github.alebabai.jmp2k17.jpa.repository;

import com.github.alebabai.jmp2k17.jpa.domain.Role;
import com.github.alebabai.jmp2k17.jpa.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "roles", collectionResourceRel = "roles", itemResourceRel = "role")
public interface RoleRepository extends PagingAndSortingRepository<Role, Integer> {
}
