package com.example.demo.common;

import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import javax.sql.DataSource;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.AbstractView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

@Component
public class PdfView extends AbstractView {
	
	@Autowired
	DataSource datasource;

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Connection conn = datasource.getConnection();
		String reportFile = (String) model.get("filename");
		HashMap<String, Object> map = (HashMap<String, Object>) model.get("param");
		InputStream jasperStream = getClass().getResourceAsStream(reportFile);
		JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, conn);
		conn.close();
		
		response.setContentType(MediaType.APPLICATION_PDF_VALUE); //깨져서 나오는 경우 추가
		JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
	}
}


