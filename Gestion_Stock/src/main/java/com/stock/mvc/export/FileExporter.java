package com.stock.mvc.export;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;

public interface FileExporter {
	boolean exportDataToExcel(HttpServletResponse response, String fileName, String encodage);
	boolean ImportDataToExcel(HttpServletResponse response, String fileName, String encodage);
	//boolean MerdeDataToExcel(HttpServletResponse response, String fileName, String encodage);
}
