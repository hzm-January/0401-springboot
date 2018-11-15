package base.springmvc.pdf.itinerary;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

/**
 * Package: base.springmvc.pdf.itinerary
 * Author: hzm_dream@163.com
 * Date: Created in 2018/11/8 16:41
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： AddFontToPdf
 */
public class AddFontToPdf {
    public static final String SRC = "D:\\testpdf\\itinerary\\pdfTemplate.pdf";
    public static final String DEST = "D:\\testpdf\\itinerary\\pdfTemplate_test.pdf";
    public static void main(String[] args) throws Exception {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        manipulatePdf(SRC, DEST);
    }

    public static void manipulatePdf(String src, String dest) throws Exception {
        BaseFont baseFontChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
        // Font fontChinese = new Font(baseFontChinese , 10 , Font.NORMAL);
        PdfReader reader = new PdfReader(src);
        // stamp = new PdfStamper(reader, new
        // FileOutputStream("pdf/setWatermark2.pdf"));
        PdfStamper stamp = new PdfStamper(reader,  new FileOutputStream(dest));
        PdfContentByte over = stamp.getOverContent(1);
        over.beginText();
        over.setFontAndSize(baseFontChinese, 8); // 设置水印字体
        over.setTextMatrix(30, 30);
        over.showTextAligned(Element.ALIGN_LEFT, "国际(I)", 100, 260, 0);
        over.showTextAligned(Element.ALIGN_LEFT, "印刷序号:", 535, 270, 0);
        over.showTextAligned(Element.ALIGN_LEFT, "1231231231", 580, 265, 0);
        over.showTextAligned(Element.ALIGN_LEFT, "SERIAL NUMBER:", 507, 260, 0);
        over.endText();
        if (stamp != null) {
            stamp.close();
        }
        if (reader != null) {
            reader.close();
        }
    }
}
