package com.savethislittle.userinfo.repository.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.savethislittle.userinfo.repository.entity.User;
import com.savethislittle.userinfo.repository.repository.UserInfoCustomRepository;

@Repository
public class UserInfoCustomRepositoryImpl implements UserInfoCustomRepository{

	@Autowired
	EntityManager em;

	
	
	public User checkIfUserExist(String email) {
		// TODO Auto-generated method stub
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
		Root<User> root = criteriaQuery.from(User.class);
		criteriaQuery.select(root);
		criteriaQuery.select(root);
		criteriaQuery.where(criteriaBuilder.equal(root.get("email"), email));
		User userCheck = this.em.createQuery(criteriaQuery).getSingleResult();
		
		if (userCheck!=null)
			return userCheck;
		else
			return null;

	}

	

	
}
