package com.api.KnowYourNeighborhood.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.api.KnowYourNeighborhood.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	User findByUsername (String username);
	
	@Query(value="SELECT * FROM user WHERE username = :username AND password = :password",
			 nativeQuery = true)

	List<User> search(@Param("username") String username, @Param("password") String password);
	
	void deleteUserById(Long id);
}
