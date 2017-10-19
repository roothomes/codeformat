package com.roothomes.mq.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.apec.framework.common.exception.ApecRuntimeException;
import com.apec.framework.common.pdf.XmlGenerator;
import com.lowagie.text.pdf.BaseFont;

public class Util {
	
	private static final org.slf4j.Logger LOG = LoggerFactory.getLogger( Util.class );
	
	private String templatePath;
	
	private String mapToPdf(String templateNameFtl,Map<String, Object> map,String fileName) throws Exception{
		File readFile = new File(templatePath);
		File fontPath = new File(templatePath + "simsun.ttc");
		ByteArrayOutputStream os = exportPdf(readFile, templateNameFtl, map, fontPath);
		byte[] b = os.toByteArray();
		ByteArrayInputStream in = new ByteArrayInputStream(b);
		
//		String filePath = FileUtils.getFileRelativePath(contractFtpPath);
//		ftpService.uploadFile(filePath, fileName + ".pdf", in);
//		String contractPath = filePath + fileName + ".pdf";
//		return contractPath;
		return null;
	}
	
	public static ByteArrayOutputStream generate(String xmlStr,File fontPath) throws Exception {
		Document doc = null;
		DocumentBuilder builder = null;
		ITextRenderer renderer = null;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		try {
			builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			doc = builder.parse(new ByteArrayInputStream(xmlStr.getBytes()));
			renderer = new ITextRenderer();
			renderer.setDocument(doc, null);
			//解决中文问题
			if(null != fontPath) {
				ITextFontResolver resolver = renderer.getFontResolver();
				resolver.addFont(fontPath.getPath(), BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED); 
			}
			renderer.layout();
			renderer.createPDF(os);
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("PdfGenerator.generate:case" );
			throw new ApecRuntimeException("PdfGenerator.generate", e.getMessage());
		} finally {
			doc = null;
			builder = null;
			renderer = null;
		}
		return os;
	}
	
	public static void generate(String xmlStr,OutputStream out,File fontPath) throws Exception {
		Document doc = null;
		DocumentBuilder builder = null;
		ITextRenderer renderer = null;
		try {
			builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			doc = builder.parse(new ByteArrayInputStream(xmlStr.getBytes()));
			renderer = new ITextRenderer();
			renderer.setDocument(doc, null);
			if(null != fontPath) {
				ITextFontResolver resolver = renderer.getFontResolver();
				resolver.addFont(fontPath.getPath(), BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED); 
			}
			renderer.layout();
			renderer.createPDF(out);
		} catch (Exception e) {
			LOG.error("PdfGenerator.generate:case" + e.getStackTrace());
			throw new ApecRuntimeException("PdfGenerator.generate", e.getMessage());
		} finally {
			doc = null;
			builder = null;
			renderer = null;
		}
	}
	
	
	
	/**
	 * 
	 * @param template 文件读取路径
	 * @param variables 
	 * @return 返回ftp 路径
	 * @throws Exception 
	 */
	public static ByteArrayOutputStream exportPdf(File readFile,String template, Map<String, Object> variables,File fontPath) throws Exception {

		ByteArrayOutputStream os = null;
		try {
			if(StringUtils.isEmpty(template)) {
				LOG.error("PdfGenerator.exportPdf:template is null");	
			}
			String xmlStr = XmlGenerator.generate(readFile, template, variables);
			os = generate(xmlStr,fontPath);
		}
		catch (Exception e) {
			LOG.error("PdfGenerator.exportPdf:case" + e.getStackTrace());
			throw new ApecRuntimeException("PdfGenerator.exportPdf", e.getMessage());
		}
		return os;
	
	}
	
	/**
	 * 
	 * @param template 文件读取路径
	 * @param variables 
	 * @return 返回ftp 路径
	 * @throws Exception 
	 */
	public static void exportPdf(File readFile,String template, Map<String, Object> variables,OutputStream out,File fontPath) throws Exception {
		try {
			if(StringUtils.isEmpty(template)) {
				LOG.error("PdfGenerator.exportPdf:template is null");	
			}
			String xmlStr = XmlGenerator.generate(readFile, template, variables);
			generate(xmlStr,out,fontPath);
		}
		catch (Exception e) {
			
			LOG.error("PdfGenerator.exportPdf:case" + e.getStackTrace());
			throw new ApecRuntimeException("PdfGenerator.exportPdf", e.getMessage());
		}
	}

}
