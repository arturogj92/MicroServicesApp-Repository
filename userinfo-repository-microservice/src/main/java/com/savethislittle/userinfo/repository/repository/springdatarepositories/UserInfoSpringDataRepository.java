package com.savethislittle.userinfo.repository.repository.springdatarepositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.savethislittle.userinfo.repository.entity.User;

@Repository
public interface UserInfoSpringDataRepository extends JpaRepository<User, Long> {

}
