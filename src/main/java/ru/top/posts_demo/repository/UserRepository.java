package ru.top.posts_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.top.posts_demo.entity.User;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
