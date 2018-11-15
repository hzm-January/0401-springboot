package base.springmvc.pdf.machineproof;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfImage;
import com.itextpdf.text.pdf.PdfIndirectObject;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

/**
 * Package: base.springmvc.pdf
 * Author: houzm
 * Date: Created in 2018/9/14 13:53
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： TODO
 */
public class AddSignetToPdf {
    public static final String SRC = "D:\\testpdf\\machine\\product\\machineProof.pdf";
    public static final String DEST = "D:\\testpdf\\machine\\product\\machineProof_img.pdf";
    public static final String IMG = "D:\\testpdf\\abnormal\\signet.png";

    public static void main(String[] args) throws IOException, DocumentException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new AddSignetToPdf().manipulatePdf(SRC, DEST);
    }

    public void manipulatePdf(String src, String dest) throws IOException, DocumentException {
        PdfReader reader = new PdfReader(src);
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
        Image image = Image.getInstance(IMG);
        image.scaleAbsolute(mmTopx(35), mmTopx(35));
        PdfImage stream = new PdfImage(image, "", null);
//        stream.put(new PdfName("ITXT_SpecialId"), new PdfName("123456789"));
        PdfIndirectObject ref = stamper.getWriter().addToBody(stream);
        image.setDirectReference(ref.getIndirectReference());
        image.setAbsolutePosition(390, 250);
        PdfContentByte over = stamper.getUnderContent(1);
        over.addImage(image);
        over.saveState();

//        //在第二页插入水印
//        PdfContentByte overContent = stamper.getUnderContent(2);
//        PdfImage stream2 = new PdfImage(image, "", null);
//        PdfIndirectObject ref2 = stamper.getWriter().addToBody(stream2);
//        image.setDirectReference(ref2.getIndirectReference());
//        image.setAbsolutePosition(390, 80);
//        overContent.addImage(image);
//
//        //在第三页插入水印
//        PdfContentByte overContent3 = stamper.getUnderContent(3);
//        PdfImage stream3 = new PdfImage(image, "", null);
//        PdfIndirectObject ref3 = stamper.getWriter().addToBody(stream3);
//        image.setDirectReference(ref3.getIndirectReference());
//        image.setAbsolutePosition(390, 80);
//        overContent3.addImage(image);
//
//        //在第四页插入水印
//        PdfContentByte overContent4 = stamper.getUnderContent(4);
//        PdfImage stream4 = new PdfImage(image, "", null);
//        PdfIndirectObject ref4 = stamper.getWriter().addToBody(stream4);
//        image.setDirectReference(ref4.getIndirectReference());
//        image.setAbsolutePosition(390, 80);
//        overContent4.addImage(image);
        stamper.close();
        reader.close();
    }

    public static float mmTopx(float mm){
        mm = (float) (mm *3.33) ;
        return mm ;
    }
}
