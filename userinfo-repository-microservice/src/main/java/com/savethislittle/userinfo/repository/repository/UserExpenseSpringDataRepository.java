package com.savethislittle.userinfo.repository.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.savethislittle.userinfo.repository.entity.Expenses;
import com.savethislittle.userinfo.repository.entity.User;

@Repository
public interface UserExpenseSpringDataRepository extends JpaRepository<Expenses, Long> {


}
