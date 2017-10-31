package com.accessor.demo.dao.impl;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;

import com.accessor.demo.dao.AccessorDao;

@Component("accessorDaoCSV")
public class CSVAccessorDaoImpl implements AccessorDao {

	@Override
	public Object processCriteria(Map<String, String> criteriaObj) {
		try {
			Reader reader = new FileReader(
					getClass().getClassLoader().getResource(criteriaObj.get("item") + ".csv").getFile());
			Iterable<CSVRecord> records = null;
			try {
				records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(reader);
			} catch (IOException e) {
				e.printStackTrace();
			}
			for (CSVRecord re : records) {
				if (re.get(criteriaObj.get("field_name")).equalsIgnoreCase(criteriaObj.get("field_value"))) {

					return re.toMap();
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return "";
	}

}
