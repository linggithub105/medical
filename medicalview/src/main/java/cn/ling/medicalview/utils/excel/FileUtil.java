package cn.ling.medicalview.utils.excel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class FileUtil {
    /**
     * 下载文件工具
     *
     * @param fileName 文件名
     * @param path 文件路径
     * @param response 响应
     * @throws IOException io异常
     */
    public static void download (String fileName, String path, HttpServletRequest request, HttpServletResponse response) throws IOException {
        File file = new File(path +"\\"+fileName+".xlsx");
        fileName=fileName+".xlsx";
        if (file.exists()) {
            response.setContentType("application/x-msdownload");
            response.setHeader("Content-disposition", "attachment; filename="
                    + new String(fileName.getBytes("utf-8"), "ISO8859-1"));
            InputStream inputStream = new FileInputStream(file);
            OutputStream outputStream = response.getOutputStream();
            byte[] b = new byte[2020];
            int n;
            while((n=inputStream.read(b)) != -1){
                outputStream.write(b, 0, n);
            }
            outputStream.close();
            inputStream.close();
        } else {
            throw new RuntimeException("找不到文件：" + fileName);
        }
    }
}
