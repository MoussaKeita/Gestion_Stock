package com.stock.mvc.export;


import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.axis.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stock.mvc.bean.LigneCmdClient;
import com.stock.mvc.service.LigneCmdClientService;
import com.stock.mvc.utils.ApplicationConstants;
import com.stock.mvc.utils.ApplicationConstants4;

import jxl.CellView;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.Label;
import jxl.write.WritableCellFeatures;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

@Component("detailsExporter")
public class DetailExporter implements FileExporter{

	@Autowired
	private LigneCmdClientService ligneCmdClientService;
	private static final String FILE_NAME = "Liste des detailsCommandes";
	
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
		/*	Label labelCode = new Label(0, 0, ApplicationConstants4.CODE_ARTICLE);
			labelCode.setCellFeatures(new WritableCellFeatures());
			labelCode.getCellFeatures().setComment("");
			sheet.addCell(labelCode);*/
			
			Label labelQuantite = new Label(1, 0, ApplicationConstants4.QUANTITE);
			labelQuantite .setCellFeatures(new WritableCellFeatures());
			labelQuantite .getCellFeatures().setComment("");
			sheet.addCell(labelQuantite );
			
			Label labelPrixUnitaireTTC = new Label(2, 0, ApplicationConstants4.PRIX_UNITAIRE_TTC);
			labelPrixUnitaireTTC .setCellFeatures(new WritableCellFeatures());
			labelPrixUnitaireTTC .getCellFeatures().setComment("");
			sheet.addCell(labelPrixUnitaireTTC );
			
			Label labelTotal = new Label(3, 0, ApplicationConstants4.TOTAL);
			labelTotal .setCellFeatures(new WritableCellFeatures());
			labelTotal .getCellFeatures().setComment("");
			sheet.addCell(labelTotal);
			
			int currentRow = 1;
			List<LigneCmdClient> commandes = ligneCmdClientService.selectAll();
			if(commandes !=null && !commandes.isEmpty()) {
				/**
				 * Writting in the sheet
				 */
				for(LigneCmdClient commande : commandes) {
					BigDecimal total = commande.getQuantite().multiply(commande.getPrixUnitaireTTC());
				//	sheet.addCell(new  Label(0, currentRow , commande.getArticle().getCode()));
					sheet.addCell(new  Label(1, currentRow , commande.getQuantite().toString()));
					sheet.addCell(new  Label(2, currentRow , commande.getPrixUnitaireTTC().toString()));
					sheet.addCell(new  Label(3, currentRow , total.toString()));

					currentRow++;
				}
				CellView cellView = new CellView();
				cellView.setAutosize(true);
				//cellView.setSize(500);
				//sheet.setColumnView(0, cellView);
				sheet.setColumnView(1, cellView);
				sheet.setColumnView(2, cellView);
				sheet.setColumnView(3, cellView);
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
	public boolean ImportDataToExcel(HttpServletResponse response, String fileName, String encodage) {
		// TODO Auto-generated method stub
		return false;
	}



}
