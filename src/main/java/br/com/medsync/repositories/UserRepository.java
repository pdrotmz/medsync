package br.com.medsync.repositories;

import br.com.medsync.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {

    @Query("SELECT u.email FROM user u WHERE u.email =: email")
    User findUserByEmail(@Param("email") String email);

    @Query("SELECT u FROM user u WHERE u.name LIKE %:name% AND LOWER(u.name) = LOWER(:email)")
    List<User> findUserByNameIgnoreCase(@Param("name") String name);
}
