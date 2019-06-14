package com.stock.mvc.export;


import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.axis.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stock.mvc.bean.Article;
import com.stock.mvc.bean.MouvementStock;
import com.stock.mvc.service.MouvementStockService;
import com.stock.mvc.utils.ApplicationConstants;
import com.stock.mvc.utils.ApplicationConstants3;

import jxl.CellView;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.Label;
import jxl.write.WritableCellFeatures;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

@Component("stockExporter")
public class StockExporter implements FileExporter{
	@Autowired
	private MouvementStockService stockService;
	private static final String FILE_NAME = "Liste des stocks";

	@Override
	public boolean MerdeDataToExcel(HttpServletResponse response, String fileName, String encodage) {
		if(StringUtils.isEmpty(fileName)) {
			fileName = FILE_NAME;
		}
		if(StringUtils.isEmpty(encodage)) {
			encodage = ApplicationConstants3.DEFAULT_ENCODAGE;
		}
		response.setContentType(ApplicationConstants3.EXCEL_CONTENT_TYPE);
		response.setHeader(ApplicationConstants.CONTENET_DISPOSITION, "attachment; filename=" + fileName + ".xls");
		//response.addHeader("Content-Disposition", "attachment; filename="+fileName);
		WorkbookSettings workBookSettings = new WorkbookSettings();
		workBookSettings.setEncoding(encodage);
		try {
			WritableWorkbook workbook = Workbook.createWorkbook(response.getOutputStream(),workBookSettings);
			WritableSheet sheet = workbook.createSheet(fileName, 0);
			/**
			 *  sheet Header
			 */
			Label labelDate = new Label(0, 0, ApplicationConstants3.DATE);
			labelDate.setCellFeatures(new WritableCellFeatures());
			labelDate.getCellFeatures().setComment("");
			sheet.addCell(labelDate);
			
			Label labelQuantiteLivree = new Label(1, 0, ApplicationConstants3.QUANTITELIVREE);
			labelQuantiteLivree.setCellFeatures(new WritableCellFeatures());
			labelQuantiteLivree.getCellFeatures().setComment("");
			sheet.addCell(labelQuantiteLivree);
			
			Label labelSortie = new Label(2, 0, ApplicationConstants3.QUANTITESORTIE);
			labelSortie.setCellFeatures(new WritableCellFeatures());
			labelSortie.getCellFeatures().setComment("");
			sheet.addCell(labelSortie);
		/*	
			Label labelArticle = new Label(3, 0, ApplicationConstants3.ARTICLE);
			labelArticle.setCellFeatures(new WritableCellFeatures());
			labelArticle.getCellFeatures().setComment("");
			sheet.addCell(labelArticle);*/
			
			Label labelFournisseur = new Label(4, 0, ApplicationConstants3.FOURNISSEURS);
			labelFournisseur.setCellFeatures(new WritableCellFeatures());
			labelFournisseur.getCellFeatures().setComment("");
			sheet.addCell(labelFournisseur);
			
			Label labelQuantiteRestante= new Label(5, 0, ApplicationConstants3.QUANTITERESTANTE);
			labelQuantiteRestante.setCellFeatures(new WritableCellFeatures());
			labelQuantiteRestante.getCellFeatures().setComment("");
			sheet.addCell(labelQuantiteRestante);
			int currentRow = 1;
			List<MouvementStock> stocks =  stockService.selectAll();;
			if(stocks !=null && !stocks.isEmpty()) {
				/**
				 * Writting in the sheet
				 */
				for(MouvementStock stock : stocks) {
					sheet.addCell(new  Label(0, currentRow , stock.getDate().toGMTString()));
					sheet.addCell(new  Label(1, currentRow , stock.getQuantiteLivre().toString()));
					sheet.addCell(new  Label(2, currentRow , stock.getQuantiteSortie().toString()));
					//sheet.addCell(new  Label(3, currentRow , stock.getArticle().getLibelle()));
					sheet.addCell(new  Label(4, currentRow , stock.getFournisseur().getNom()));
					sheet.addCell(new  Label(5, currentRow , stock.getQuantiteRestante().toString()));
					currentRow++;
				}
				CellView cellView = new CellView();
				cellView.setAutosize(true);
				//cellView.setSize(500);
				sheet.setColumnView(0, cellView);
				sheet.setColumnView(1, cellView);
				sheet.setColumnView(2, cellView);
				//sheet.setColumnView(3, cellView);
				sheet.setColumnView(4, cellView);
				sheet.setColumnView(5, cellView);
				/**
				 * Writting to excel  sheet
				 */
				workbook.write();
				/**
				 * closing the workbook
				 */
				workbook.close();
				
				response.getOutputStream().flush();
				response.getOutputStream().close();
			}
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	@Override
	public boolean exportDataToExcel(HttpServletResponse response, String fileName, String encodage) {
		// TODO Auto-generated method stub
				return false;
	}

	@Override
	public boolean ImportDataToExcel(HttpServletResponse response, String fileName, String encodage) {
		// TODO Auto-generated method stub
		return false;
	}


}
