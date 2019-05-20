package com.stock.mvc.export;


import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.axis.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stock.mvc.bean.Article;
import com.stock.mvc.service.ArticleService;
import com.stock.mvc.utils.ApplicationConstants;

import jxl.CellView;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.Label;
import jxl.write.WritableCellFeatures;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

@Component("articleExporter")
public class ArticleExporter implements FileExporter{
	@Autowired
	private ArticleService articleService;
	private static final String FILE_NAME = "Liste des articles";
	
	@Override
	public boolean exportDataToExcel(HttpServletResponse response, String fileName, String encodage) {
		if(StringUtils.isEmpty(fileName)) {
			fileName = FILE_NAME;
		}
		if(StringUtils.isEmpty(encodage)) {
			encodage = ApplicationConstants.DEFAULT_ENCODAGE;
		}
		response.setContentType(ApplicationConstants.EXCEL_CONTENT_TYPE);
		response.setHeader(ApplicationConstants.CONTENET_DISPOSITION, "attachment; filename=" + fileName + ".xls");
		WorkbookSettings workBookSettings = new WorkbookSettings();
		workBookSettings.setEncoding(encodage);
		try {
			WritableWorkbook workbook = Workbook.createWorkbook(response.getOutputStream(),workBookSettings);
			WritableSheet sheet = workbook.createSheet(fileName, 0);
			/**
			 *  sheet Header
			 */
			Label labelCode = new Label(0, 0, ApplicationConstants.CODE_ARTICLE);
			labelCode.setCellFeatures(new WritableCellFeatures());
			labelCode.getCellFeatures().setComment("");
			sheet.addCell(labelCode);
			
			Label labelLibelle = new Label(1, 0, ApplicationConstants.LIBELLE);
			labelLibelle.setCellFeatures(new WritableCellFeatures());
			labelLibelle.getCellFeatures().setComment("");
			sheet.addCell(labelLibelle);
			
			Label labelPrixUnitaireHT = new Label(2, 0, ApplicationConstants.PRIX_UNITAIRE_HT);
			labelPrixUnitaireHT.setCellFeatures(new WritableCellFeatures());
			labelPrixUnitaireHT.getCellFeatures().setComment("");
			sheet.addCell(labelPrixUnitaireHT);
			
			Label labelPrixUnitaireTTC = new Label(3, 0, ApplicationConstants.PRIX_UNITAIRE_TTC);
			labelPrixUnitaireTTC.setCellFeatures(new WritableCellFeatures());
			labelPrixUnitaireTTC.getCellFeatures().setComment("");
			sheet.addCell(labelPrixUnitaireTTC);
			
			Label labelTva = new Label(4, 0, ApplicationConstants.TVA);
			labelTva .setCellFeatures(new WritableCellFeatures());
			labelTva .getCellFeatures().setComment("");
			sheet.addCell(labelTva);
			
			Label labelCategorie = new Label(5, 0, ApplicationConstants.CATEGORIE);
			labelCategorie .setCellFeatures(new WritableCellFeatures());
			labelCategorie .getCellFeatures().setComment("");
			sheet.addCell(labelCategorie);
			int currentRow = 1;
			List<Article> articles = articleService.selectAll();
			if(articles !=null && !articles.isEmpty()) {
				/**
				 * Writting in the sheet
				 */
				for(Article article : articles) {
					sheet.addCell(new  Label(0, currentRow , article.getCode()));
					sheet.addCell(new  Label(1, currentRow , article.getLibelle()));
					sheet.addCell(new  Label(2, currentRow , article.getPrixUnitaireHT().toString()));
					sheet.addCell(new  Label(3, currentRow , article.getPrixUnitaireTTC().toString()));
					sheet.addCell(new  Label(4, currentRow , article.getTauxTVA().toString()));
					sheet.addCell(new  Label(5, currentRow , article.getCategory().getCode()));
					currentRow++;
				}
				CellView cellView = new CellView();
				cellView.setAutosize(true);
				//cellView.setSize(500);
				sheet.setColumnView(0, cellView);
				sheet.setColumnView(1, cellView);
				sheet.setColumnView(2, cellView);
				sheet.setColumnView(3, cellView);
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
	public boolean ImportDataToExcel() {
		// TODO Auto-generated method stub
		return false;
	}

}
