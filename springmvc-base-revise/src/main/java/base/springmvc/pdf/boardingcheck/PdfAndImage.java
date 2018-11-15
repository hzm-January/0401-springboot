package base.springmvc.pdf.boardingcheck;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfImage;
import com.itextpdf.text.pdf.PdfIndirectObject;
import com.itextpdf.text.pdf.PdfName;
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
@RequestMapping(value = "/api/pdfimg/")
public class PdfAndImage {

    @RequestMapping(value = "/create", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ApiOperation(value = "/create")
    public Boolean createPdf(HttpServletRequest request, HttpServletResponse response) {
        PdfReader reader = null;
        PdfStamper stamp = null;

        try {
            BaseFont baseFontChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
//             Font fontChinese = new Font(baseFontChinese , 10 , Font.NORMAL);
            reader = new PdfReader("D:\\testpdf\\boarding.pdf");
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
            ColumnText.showTextAligned(over, Element.ALIGN_LEFT, p, 98, 380,
                    0);
            Phrase idcard = new Phrase("16525171127364432", f);
//            over.setTextMatrix(100, 100);
            ColumnText.showTextAligned(over, Element.ALIGN_LEFT, idcard, 224, 380,
                    0);
            Phrase phone = new Phrase("15261530518", f);
//            over.setTextMatrix(100, 100);
            ColumnText.showTextAligned(over, Element.ALIGN_LEFT, phone, 415, 380,
                    0);
//            over.setTextMatrix(100, 100);
            ColumnText.showTextAligned(over, Element.ALIGN_LEFT, p, 623, 380,
                    0);
            Font f2 = new Font(baseFontChinese, 14, Font.BOLD);
            Phrase etkt = new Phrase("9021000389503", f2);
            ColumnText.showTextAligned(over, Element.ALIGN_LEFT, etkt, 277, 295,
                    0);
            //使用EAN_13编码格式进行编码
            BitMatrix bitMatrix = new MultiFormatWriter().encode("AQ1120-1516ANKG001",
                    BarcodeFormat.CODE_128, 200, 40, null);
            //生成png格式的图片保存到imgPath路径
            ByteArrayOutputStream byteOutputStream2 = new ByteArrayOutputStream();
            MatrixToImageWriter.writeToStream(bitMatrix, "png",
                    byteOutputStream2);
            System.out.println("======"+byteOutputStream2.toByteArray());
            Image image = Image.getInstance(byteOutputStream2.toByteArray());
            PdfImage stream = new PdfImage(image, "", null);
            stream.put(new PdfName("ITXT_SpecialId"), new PdfName("123456789"));
            PdfIndirectObject ref = stamp.getWriter().addToBody(stream);
            image.setDirectReference(ref.getIndirectReference());
            image.setAbsolutePosition(240, 245);
            over.addImage(image);
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
        } catch (WriterException e) {
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
