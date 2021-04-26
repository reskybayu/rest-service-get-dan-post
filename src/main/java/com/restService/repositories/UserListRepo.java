package com.restService.repositories;

import com.restService.model.UserList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserListRepo extends JpaRepository<UserList, Long> {
}
