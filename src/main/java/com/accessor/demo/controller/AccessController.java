package com.accessor.demo.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accessor.demo.service.AccessorService;

@RestController
public class AccessController {
	private final static Logger logger = LoggerFactory.getLogger(AccessController.class);
	
	@Autowired
	AccessorService accessorService;
	
	@RequestMapping(value="/process", method = RequestMethod.POST)
	public ResponseEntity<?> processCriteria(@RequestBody Map<String, String> criteriaObj){
		logger.info("Criteria given to process : "+criteriaObj);
		return new ResponseEntity<>(accessorService.processCriteria(criteriaObj),HttpStatus.OK);
	}
}
