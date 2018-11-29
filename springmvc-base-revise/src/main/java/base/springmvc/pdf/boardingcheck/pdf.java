package base.springmvc.pdf.boardingcheck;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
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
import com.itextpdf.text.pdf.GrayColor;
import com.itextpdf.text.pdf.PdfArray;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfImage;
import com.itextpdf.text.pdf.PdfIndirectObject;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfNumber;
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
            reader = new PdfReader("D:\\testpdf\\boarding\\boardingpass-new-new.pdf");
            // stamp = new PdfStamper(reader, new
            // FileOutputStream("pdf/setWatermark2.pdf"));
            ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
            stamp = new PdfStamper(reader, byteOutputStream);
            PdfContentByte over = stamp.getOverContent(1);
            over.beginText();

//            over.setFontAndSize(baseFontChinese, 15); // 设置水印字体
            Font f = new Font(baseFontChinese, 9, Font.BOLD);
            Phrase p = new Phrase("测试乘机人一", f);
//            over.setTextMatrix(100, 100);
            ColumnText.showTextAligned(over, Element.ALIGN_LEFT, p, 104, 690, 0);
            Phrase idcard = new Phrase("16525171127364432", f);
//            over.setTextMatrix(100, 100);
            ColumnText.showTextAligned(over, Element.ALIGN_LEFT, idcard, 180, 690, 0);
            Phrase phone = new Phrase("15261530518", f);
//            over.setTextMatrix(100, 100);
            ColumnText.showTextAligned(over, Element.ALIGN_LEFT, phone, 290, 690, 0);
//            over.setTextMatrix(100, 100);
            ColumnText.showTextAligned(over, Element.ALIGN_LEFT, p, 420, 690,0);
            Phrase etkt = new Phrase("9021000389503", f);
            ColumnText.showTextAligned(over, Element.ALIGN_LEFT, etkt, 220, 647,
                    0);



            //使用EAN_13编码格式进行编码
            BitMatrix bitMatrix = new MultiFormatWriter().encode("AQ1120 1417ANNG001",
                    BarcodeFormat.CODE_128, 20, 20, null);
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
//            image.scalePercent(80);
            image.scaleAbsolute(180,25);
            image.setAbsolutePosition(190, 615);
            over.addImage(image);
//            over.rectangle( 1000, 1000, 1000, 1000);
//            PdfDictionary page = reader.getPageN(1);
//            PdfNumber rotate = page.getAsNumber(PdfName.ROTATE);
//            if (rotate == null) {
//                page.put(PdfName.ROTATE, new PdfNumber(90));
//            }
//            else {
//                page.put(PdfName.ROTATE, new PdfNumber((rotate.intValue() + 90) % 360));
//            }


//            PdfDictionary page = reader.getPageN(1);
//            PdfArray media = page.getAsArray(PdfName.CROPBOX);
//            if (media == null) {
//                media = page.getAsArray(PdfName.MEDIABOX);
//            }
////            float llx = media.getAsNumber(0).floatValue() + 200;
////            float lly = media.getAsNumber(1).floatValue() + 200;
////            float w = media.getAsNumber(2).floatValue() - media.getAsNumber(0).floatValue() - 400;
//            float h = media.getAsNumber(3).floatValue() - media.getAsNumber(1).floatValue() - 400;
//            String command = String.format(Locale.ROOT,
//                    "\nq %.2f re W n\nq\n",  h);
//            stamp.getUnderContent(1).setLiteral(command);
//            stamp.getOverContent(1).setLiteral("\nQ\nQ\n");

//            PdfDictionary pageDict = reader.getPageN(1);
//            PdfArray mediabox = pageDict.getAsArray(PdfName.MEDIABOX);
//            float llx = mediabox.getAsNumber(0).floatValue();
//            float lly = mediabox.getAsNumber(1).floatValue();
//            float ury = mediabox.getAsNumber(3).floatValue();
//            mediabox.set(0, new PdfNumber(llx - 36));
//            over = stamp.getOverContent(1);
//            over.saveState();
//            over.setColorFill(new GrayColor(0.5f));
//            over.rectangle(llx - 1, lly, 36, ury - llx);
//            over.fill();
//            over.restoreState();

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
