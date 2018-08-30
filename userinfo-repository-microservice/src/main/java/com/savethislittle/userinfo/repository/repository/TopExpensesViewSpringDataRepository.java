package com.savethislittle.userinfo.repository.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.savethislittle.userinfo.repository.entity.TopExpensesView;

@Repository
public interface TopExpensesViewSpringDataRepository extends JpaRepository<TopExpensesView, String> {

	public List<TopExpensesView> findByEmail(String email);
	
	public List<TopExpensesView> findByEmailAndMonthAndYear(String email, String month, String year);

	public List<TopExpensesView> findByEmailAndYear(String email, String year);
}
