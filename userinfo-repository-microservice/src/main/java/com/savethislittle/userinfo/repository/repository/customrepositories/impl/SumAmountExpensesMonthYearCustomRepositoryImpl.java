package com.savethislittle.userinfo.repository.repository.customrepositories.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.savethislittle.userinfo.repository.entity.SumAmountExpensesMonthYear;
import com.savethislittle.userinfo.repository.repository.customrepositories.SumAmountExpensesMonthYearCustomRepository;

@Repository
public class SumAmountExpensesMonthYearCustomRepositoryImpl implements SumAmountExpensesMonthYearCustomRepository {

	
	@Autowired
	EntityManager em;
	
	@Override
	public List<SumAmountExpensesMonthYear> searchTopExpenseViewByEmail(String email) {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<SumAmountExpensesMonthYear> criteriaQuery = criteriaBuilder.createQuery(SumAmountExpensesMonthYear.class);
		Root<SumAmountExpensesMonthYear> root = criteriaQuery.from(SumAmountExpensesMonthYear.class);
		criteriaQuery.select(root);
		criteriaQuery.where(criteriaBuilder.equal(root.get("email"), email));
		List<SumAmountExpensesMonthYear> expensesList = this.em.createQuery(criteriaQuery).getResultList();
		return expensesList;
	}
	

}
