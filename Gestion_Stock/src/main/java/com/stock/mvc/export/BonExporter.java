package com.stock.mvc.export;


import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.axis.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stock.mvc.bean.Article;
import com.stock.mvc.bean.CommandeClient;
import com.stock.mvc.service.CommandeClientService;
import com.stock.mvc.utils.ApplicationConstants;
import com.stock.mvc.utils.ApplicationConstants2;

import jxl.CellView;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.Label;
import jxl.write.WritableCellFeatures;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

@Component("bonExporter")
public class BonExporter implements FileExporter{

	//private ArticleService articleService;
	@Autowired
	private CommandeClientService commandeclientService;
	private static final String FILE_NAME = "Liste des commandes";
	
	@Override
	public boolean exportDataToExcel(HttpServletResponse response, String fileName, String encodage) {
		if(StringUtils.isEmpty(fileName)) {
			fileName = FILE_NAME;
		}
		if(StringUtils.isEmpty(encodage)) {
			encodage = ApplicationConstants2.DEFAULT_ENCODAGE;
		}
		response.setContentType(ApplicationConstants2.EXCEL_CONTENT_TYPE);
		response.setHeader(ApplicationConstants.CONTENET_DISPOSITION, "attachment; filename=" + fileName + ".xls");
		WorkbookSettings workBookSettings = new WorkbookSettings();
		workBookSettings.setEncoding(encodage);
		try {
			WritableWorkbook workbook = Workbook.createWorkbook(response.getOutputStream(),workBookSettings);
			WritableSheet sheet = workbook.createSheet(fileName, 0);
			/**
			 *  sheet Header
			 */
			Label labelCode = new Label(0, 0, ApplicationConstants2.CODE_COMMANDE);
			labelCode.setCellFeatures(new WritableCellFeatures());
			labelCode.getCellFeatures().setComment("");
			sheet.addCell(labelCode);
			
			Label labelLibelle = new Label(1, 0, ApplicationConstants2.DATE);
			labelLibelle.setCellFeatures(new WritableCellFeatures());
			labelLibelle.getCellFeatures().setComment("");
			sheet.addCell(labelLibelle);
			
			Label labelPrixUnitaireHT = new Label(2, 0, ApplicationConstants2.CLIENTS);
			labelPrixUnitaireHT.setCellFeatures(new WritableCellFeatures());
			labelPrixUnitaireHT.getCellFeatures().setComment("");
			sheet.addCell(labelPrixUnitaireHT);
			
			int currentRow = 1;
			List<CommandeClient> commandes = commandeclientService.selectAll();
			if(commandes !=null && !commandes.isEmpty()) {
				/**
				 * Writting in the sheet
				 */
				for(CommandeClient commande : commandes) {
					sheet.addCell(new  Label(0, currentRow , commande.getCode()));
					sheet.addCell(new  Label(1, currentRow , commande.getDateCommande().toGMTString()));
					sheet.addCell(new  Label(2, currentRow , commande.getClient().getNom()));

					currentRow++;
				}
				CellView cellView = new CellView();
				cellView.setAutosize(true);
				//cellView.setSize(500);
				sheet.setColumnView(0, cellView);
				sheet.setColumnView(1, cellView);
				sheet.setColumnView(2, cellView);
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
