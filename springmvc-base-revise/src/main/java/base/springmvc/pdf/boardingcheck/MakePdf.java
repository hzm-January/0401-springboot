package base.springmvc.pdf.boardingcheck;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfImage;
import com.itextpdf.text.pdf.PdfIndirectObject;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfNumber;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

/**
 * Package: base.springmvc.pdf.boardingcheck
 * Author: houzm
 * Date: Created in 2018/10/26 14:48
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： MakePdf
 */
public class MakePdf {
    public static final String SRC = "D:\\testpdf\\boarding\\white.pdf";
    public static final String DEST = "D:\\testpdf\\boarding\\white_image_rotate.pdf";
    public static final String IMG = "D:\\testpdf\\boarding\\image.png";

    public static void main(String[] args) throws IOException, DocumentException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        manipulatePdf(SRC, DEST);
    }

    public static void manipulatePdf(String src, String dest) throws IOException, DocumentException {
        PdfReader reader = new PdfReader(src);
        PdfDictionary page = reader.getPageN(1);
        PdfNumber rotate = page.getAsNumber(PdfName.ROTATE);
        if (rotate == null) {
            page.put(PdfName.ROTATE, new PdfNumber(90));
        }
        else {
            page.put(PdfName.ROTATE, new PdfNumber((rotate.intValue() + 90) % 360));
        }
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
        Image image = Image.getInstance(IMG);
        image.scaleAbsolute(mmTopx(250), mmTopx(100));
        PdfImage stream = new PdfImage(image, "", null);
        PdfIndirectObject ref = stamper.getWriter().addToBody(stream);
        image.setDirectReference(ref.getIndirectReference());
        image.setAbsolutePosition(0, 10);
        PdfContentByte over = stamper.getOverContent(1);
        over.addImage(image);
        stamper.close();
        reader.close();
    }

    public static float mmTopx(float mm){
        mm = (float) (mm *3.33) ;
        return mm ;
    }
}
