package com.hand.hcf.app.gof.itextpdf;

import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description
 * @Author zifu.li@hand-china.com
 * @Date 2020/2/13 21:38
 * @Version 1.0
 */
@Controller
public class PdfUtils {


    @RequestMapping("/text")
    @ResponseBody
    public void getPDF(@RequestParam("context") String context) {
        try {
            //创建文件
            Document document = new Document();
            //建立一个书写器
            String path = "lzf666" + ".pdf";
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(path));

            //打开文件
            document.open();

            //中文字体,解决中文不能显示问题
            BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);

            Font font = new Font(bfChinese);//正常字体
            Font fontBold = new Font(bfChinese, 12, Font.BOLD);//正常加粗字体
            Font fontBig = new Font(bfChinese, 20);//大字体
            Font fontBigBold = new Font(bfChinese, 20, Font.BOLD);//加粗大字体

            //添加主题  标题
            Paragraph theme = new Paragraph("还款计划表");
            theme.setAlignment(Element.ALIGN_CENTER);
            document.add(theme);

            //借款信息   context为接收的内容  生成pdf的内容
            Paragraph peopleInfo = new Paragraph(context,font);
            peopleInfo.setAlignment(Element.ALIGN_CENTER);
            document.add(peopleInfo);
            /*
            * 以下还可以增加pdf的一些其他内容   详情CSDN见文档
            * */

            //关闭文档
            document.close();
            //关闭书写器
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
