package com.cos.securityex01.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.securityex01.model.User;

//JpaRepository 를 상속하면 자동 컴포넌트 스캔됨.
public interface UserRepository extends JpaRepository<User, Integer>{
 
	
	//Jpa Naming 전략 
	//SELECT * FROM user WHERE username = 1 ?

     User findByUsername(String username);
}
