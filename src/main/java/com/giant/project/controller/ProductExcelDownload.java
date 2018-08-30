package com.giant.project.controller;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.giant.project.model.Board;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
  * @FileName : ProductExcelDownload.java
  * @Project : �룷�듃�뤃由ъ삤
  * @Date : 2018. 5. 27. 
  * @�옉�꽦�옄 : �쑀�쁽�옱
  * @蹂�寃쎌씠�젰 :
  * @�봽濡쒓렇�옩 �꽕紐� : �뿊�� �떎�슫濡쒕뱶瑜� �쐞�븳 �쑀�떥 硫붿꽌�뱶
  */
public class ProductExcelDownload extends AbstractExcelView {
	
	@SuppressWarnings("unlikely-arg-type")
	@Override
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		/*�뿊���뙆�씪�뿉 �궇�옄瑜� 遺숈씠湲� �쐞�빐 SimpleDateFormat�쓣 �궗�슜�븯�뿬 �뙆�씪 �씠由� �꽕�젙*/
		String firstName = null;
		String fullName = "";
		firstName = new SimpleDateFormat("yyyyMMdd").format(new Date());
		fullName = firstName + "_�긽�뭹由ъ뒪�듃_�뿊���떎�슫濡쒕뱶.xls";
		/*�씠由꾩꽕�젙�걹*/
		
		/*�뿊���뙆�씪�뿉 sheet�� Row留뚮뱾湲�*/
		Sheet workSheet = null;
		Row row = null;
		
		/*productController �뿉�꽌 model�뿉 �떞�� �긽�뭹由ъ뒪�듃瑜� model.get(List)瑜� �넻�빐 媛��졇�삤湲�*/
		List<Board> productExcelList = (List<Board>) model.get("list");
		
		/*workSheet瑜� �씠�슜�븯�뿬 sheet留뚮뱾湲�*/
		workSheet = workbook.createSheet("�긽�뭹由ъ뒪�듃");
		
		/*0踰덉㎏ Row�뿉 紐⑹감留뚮뱾湲�*/
		row = workSheet.createRow(0);
		
		row.createCell(0).setCellValue("�긽�뭹踰덊샇");
		row.createCell(1).setCellValue("�긽�뭹�씠由�");
		row.createCell(2).setCellValue("�긽�뭹�꽦蹂�");
		row.createCell(3).setCellValue("�긽�뭹�뭹醫�");
		row.createCell(4).setCellValue("�긽�뭹媛�寃�");
		row.createCell(5).setCellValue("�긽�뭹遺꾩뼇�뿬遺�");
		row.createCell(6).setCellValue("�긽�뭹�삁諛⑹젒醫�");
		row.createCell(7).setCellValue("�긽�뭹�깮�뀈�썡�씪");
		row.createCell(8).setCellValue("�긽�뭹�씠誘몄�");
		row.createCell(9).setCellValue("�긽�뭹�벑濡앹씪");
		
		/*1踰덉㎏ Row遺��꽣 model�쓣 �넻�빐 媛��졇�삩 �긽�뭹由ъ뒪�듃瑜� 諛섎났臾몄쓣 �넻�빐 �븯�굹�뵫 �엯�젰*/
		int rowIndex = 1;
		for(Board list : productExcelList) {
			row = workSheet.createRow(rowIndex);
			row.createCell(0).setCellValue(list.getPost_no());
			row.createCell(1).setCellValue(list.getD_job());
			row.createCell(2).setCellValue(list.getMem_id());
			row.createCell(3).setCellValue(list.getPost_no());
			row.createCell(4).setCellValue(list.getStatus());
			row.createCell(7).setCellValue(list.getContent());
			row.createCell(8).setCellValue(list.getSubject());
			/*DATE ���엯�씠 �젣��濡� �엯�젰�릺吏��븡�븘 SimpleDateFormat�쓣 �넻�빐 �룷硫㏉빐�꽌 �엯�젰*/
			rowIndex++;
			
		}
		
		/*�뿊�� 而щ읆�궗�씠利�*/
		for (int i = 0; i <  productExcelList.size(); i++){ 
        	workSheet.autoSizeColumn(i); 
        	workSheet.setColumnWidth(i, (workSheet.getColumnWidth(i)) + 2000); 
        }
		
		try {
			/*header遺�遺�*/
			response.setHeader("Content-Disposition", "attachement; filename=\""
	                + java.net.URLEncoder.encode(fullName, "UTF-8") + "\";charset=\"UTF-8\"");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
}
