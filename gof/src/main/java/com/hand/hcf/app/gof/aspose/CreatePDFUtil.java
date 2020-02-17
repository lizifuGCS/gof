package com.hand.hcf.app.gof.aspose;

import com.aspose.words.Document;
import com.aspose.words.License;
import com.aspose.words.SaveFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @Description
 * @Author zifu.li@hand-china.com
 * @Date 2020/2/13 20:03
 * @Version 1.0
 */
@Controller
public class CreatePDFUtil {

    private static final Logger log = LoggerFactory.getLogger(CreatePDFUtil.class);
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private static final String SUCCESS ="success";
    private static final String ERROR ="error";
    private static boolean FLAG;

    //真实场景使用，测试可换掉
 /*   @Value("${polars.file.save-path:/u01/fileData/}")
    private String path;*/


    @RequestMapping("/getPDF")
    @ResponseBody
    private String  createPDF( @RequestParam("fileName") String fileName,
                          @RequestParam("context") String context){

        //设置生成pdf文件名和文件地址
        String uuid = UUID.randomUUID().toString();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        String lastPath = formatter.format(new Date());
        lastPath = lastPath + fileName  + uuid + ".pdf";
        String fullPath = /*this.path + */  lastPath;

        //具体生成方法
        log.info("生成PDF开始");
        FLAG =makePDF(fullPath, context);
        if (FLAG){
            return SUCCESS;
        } else{
            log.info("生成PDF失败");
            return ERROR ;
        }
    }

    //生成pdf文件
    public boolean makePDF(String fullPath,String context) {

        // 验证License
        if (!getLicense()) {
            log.error("验证License失败！");
            return false;
        }
        try {
            InputStream file = new ByteArrayInputStream(context.getBytes());
            Document doc = new Document(file); // Address是将要被转化的word文档
            doc.save(fullPath, SaveFormat.PDF);
        } catch (Exception e) {
            e.printStackTrace();
            return false ;
        }
        return true ;
    }

    //获取鉴权  去掉水印
    /**
     * 获取license
     *
     * @return
     */
    private static boolean getLicense() {
        boolean result = false;
        try {
            // 凭证
            String licenseStr =
                    "<License>\n" +
                            "  <Data>\n" +
                            "    <Products>\n" +
                            "      <Product>Aspose.Total for Java</Product>\n" +
                            "      <Product>Aspose.Words for Java</Product>\n" +
                            "    </Products>\n" +
                            "    <EditionType>Enterprise</EditionType>\n" +
                            "    <SubscriptionExpiry>20991231</SubscriptionExpiry>\n" +
                            "    <LicenseExpiry>20991231</LicenseExpiry>\n" +
                            "    <SerialNumber>8bfe198c-7f0c-4ef8-8ff0-acc3237bf0d7</SerialNumber>\n" +
                            "  </Data>\n" +
                            "  <Signature>0nRuwNEddXwLfXB7pw66G71MS93gW8mNzJ7vuh3Sf4VAEOBfpxtHLCotymv1PoeukxYe31K441Ivq0Pkvx1yZZG4O1KCv3Omdbs7uqzUB4xXHlOub4VsTODzDJ5MWHqlRCB1HHcGjlyT2sVGiovLt0Grvqw5+QXBuinoBY0suX0=</Signature>\n" +
                            "</License>";
            InputStream license = new ByteArrayInputStream(licenseStr.getBytes(UTF_8));
            License asposeLic = new License();
            asposeLic.setLicense(license);
            result = true;
        } catch (Exception e) {
            log.error("error:", e);
        }
        return result;
    }
}
