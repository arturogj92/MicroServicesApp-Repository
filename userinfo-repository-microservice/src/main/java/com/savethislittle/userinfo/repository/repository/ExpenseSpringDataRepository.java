package com.savethislittle.userinfo.repository.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.savethislittle.userinfo.repository.entity.Expenses;

@Repository
public interface ExpenseSpringDataRepository extends JpaRepository<Expenses, Long> {


	public List<Expenses> findByMonthAndYearAndEmail(String month, String year, String email);
	
	public List<Expenses> findByYearAndEmail(String year, String email);
	
}
