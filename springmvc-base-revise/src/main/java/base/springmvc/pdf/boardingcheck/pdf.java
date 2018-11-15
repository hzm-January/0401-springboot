package base.springmvc.pdf.boardingcheck;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import io.swagger.annotations.ApiOperation;

/**
 * Package: base.springmvc
 * Author: houzm
 * Date: Created in 2018/9/7 18:24
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： TODO
 */
@RestController
@RequestMapping(value = "/api/pdf/")
public class pdf {

    @RequestMapping(value = "/create", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ApiOperation(value = "/create")
    public Boolean createPdf(HttpServletRequest request, HttpServletResponse response) {
        PdfReader reader = null;
        PdfStamper stamp = null;

        try {
            BaseFont baseFontChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
//             Font fontChinese = new Font(baseFontChinese , 10 , Font.NORMAL);
            reader = new PdfReader("D:\\boardingpass-test.pdf");
            // stamp = new PdfStamper(reader, new
            // FileOutputStream("pdf/setWatermark2.pdf"));
            ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
            stamp = new PdfStamper(reader, byteOutputStream);
            PdfContentByte over = stamp.getOverContent(1);
            over.beginText();

//            over.setFontAndSize(baseFontChinese, 15); // 设置水印字体
            Font f = new Font(baseFontChinese, 14, Font.BOLD);
            Phrase p = new Phrase("测试乘机人一", f);
//            over.setTextMatrix(100, 100);
            ColumnText.showTextAligned(over, Element.ALIGN_LEFT, p, 104, 380,
                    0);
            Phrase idcard = new Phrase("16525171127364432", f);
//            over.setTextMatrix(100, 100);
            ColumnText.showTextAligned(over, Element.ALIGN_LEFT, idcard, 230, 380,
                    0);
            Phrase phone = new Phrase("15261530518", f);
//            over.setTextMatrix(100, 100);
            ColumnText.showTextAligned(over, Element.ALIGN_LEFT, phone, 420, 380,
                    0);
//            over.setTextMatrix(100, 100);
            ColumnText.showTextAligned(over, Element.ALIGN_LEFT, p, 630, 380,
                    0);
            Phrase etkt = new Phrase("9021000389503", f);
            ColumnText.showTextAligned(over, Element.ALIGN_LEFT, etkt, 277, 301,
                    0);
            if (stamp != null) {
                stamp.close();
            }
            over.endText();

            IOUtils.write(byteOutputStream.toByteArray(), response.getOutputStream());
            System.out.println(Arrays.toString(byteOutputStream.toByteArray()));
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stamp != null) {
                    stamp.close();
                }
            } catch (DocumentException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (reader != null) {
                    reader.close();
                }
            }

        }
        return true;
    }

}
