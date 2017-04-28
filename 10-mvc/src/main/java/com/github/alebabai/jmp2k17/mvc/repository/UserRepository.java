package com.github.alebabai.jmp2k17.mvc.repository;

import com.github.alebabai.jmp2k17.mvc.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface UserRepository extends PagingAndSortingRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}
