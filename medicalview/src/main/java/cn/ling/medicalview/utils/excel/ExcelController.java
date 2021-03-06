package cn.ling.medicalview.utils.excel;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("downloadExcel")
public class ExcelController {
    /**
     * 下载Excel模板

     * @param request request
     * @param response response
     * @throws IOException IOException
     */
    @RequestMapping(value = "/template/{filename}")
    public void downloadTemplate (HttpServletRequest request, HttpServletResponse response,
                                  @PathVariable("filename")String filename) throws IOException {
        //String path = request.getSession().getServletContext().getRealPath("/")+"static/excel/";
       String path=ExcelController.class.getResource("").toString();
       int index=path.indexOf("medicalview");
       path=path.substring(5,index+11)+"\\src\\main\\resources\\static\\excel";
       System.out.println(path+"==========="+filename);
        FileUtil.download(filename,path,request,response);
    }
}
