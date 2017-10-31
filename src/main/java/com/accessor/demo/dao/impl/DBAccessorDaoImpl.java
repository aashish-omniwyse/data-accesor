package com.accessor.demo.dao.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service("accessorDaoDB")
public class DBAccessorDaoImpl {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public Object processCriteria(Map<String, String> criteriaObj) {
		System.out.println("called dao...");
		StringBuffer DBQuery = new StringBuffer("SELECT * FROM ")
				.append(criteriaObj.get("item"))
				.append(" where ")
				.append(criteriaObj.get("field_name"))
				.append(" = '")
				.append(criteriaObj.get("field_value").toUpperCase())
				.append("'");
		return jdbcTemplate.queryForList(DBQuery.toString());
	}
}
