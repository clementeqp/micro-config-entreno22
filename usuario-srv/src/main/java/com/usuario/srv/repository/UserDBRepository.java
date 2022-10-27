package com.usuario.srv.repository;


import com.usuario.srv.entity.UserDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserDBRepository extends JpaRepository<UserDB, Long> {

    Optional<UserDB> findOneByEmail(String email);
}
