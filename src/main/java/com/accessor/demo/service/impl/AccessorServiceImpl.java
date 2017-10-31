package com.accessor.demo.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.accessor.demo.dao.impl.CSVAccessorDaoImpl;
import com.accessor.demo.dao.impl.DBAccessorDaoImpl;
import com.accessor.demo.service.AccessorService;

@Service("accessorService")
public class AccessorServiceImpl implements AccessorService{
	
	@Autowired
	@Qualifier("accessorDaoDB")
	DBAccessorDaoImpl accessorDaoDB;
	
	@Autowired
	@Qualifier("accessorDaoCSV")
	CSVAccessorDaoImpl accessorDaoCSV;
	
	private Map<String,String> cache = new HashMap<String, String>();
	
	@Override
	public String processCriteria(Map<String, String> criteriaObj){
		if(cache.containsKey(criteriaObj.get("field_value"))) {
			return cache.get(criteriaObj.get("field_value"));
		}else {
			String result = null;
			try {
				Object dbObj = accessorDaoDB.processCriteria(criteriaObj);
				Object csvObj = accessorDaoCSV.processCriteria(criteriaObj);
				result = "\n  Record Displaying from Redshift Databse \n\n"+dbObj.toString() + "\n\n  Rrecord displaying from CSV file  \n\n  "+
				csvObj.toString();
			}catch(Exception ex) {
				System.out.println("no record found in database ");
				return "NO data";
			}
			cache.put(criteriaObj.get("name"), result);
			return result;
		}
	}
} 
