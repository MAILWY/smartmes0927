package org.jlhh.mes.utils;

import java.io.*;

/**
 * Created by wangyong on 2017/10/15.
 */
public class FileTool {
    /**
     * 读取excel模板，并复制到新文件中供写入和下载
     *
     * @return
     */
    public static File createNewFile(String prodNum) {
        // 读取模板，并赋值到新文件************************************************************
        // 文件模板路径
        File file = new File("D:\\mes_prod_test_excelTemplate.xlsx");
        File newFile = new File("D:\\ProdTestResult" + prodNum.toString() + ".xlsx");
        if (newFile.exists()) {
            newFile.delete();
        }
        try {
            newFile.createNewFile();
            // 复制模板到新文件
            fileChannelCopy(file, newFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return newFile;
    }

    /**
     * 复制文件
     *
     * @param s 源文件
     * @param t 复制到的新文件
     */
    public static void fileChannelCopy(File s, File t) {
        try {
            InputStream in = null;
            OutputStream out = null;
            try {
                in = new BufferedInputStream(new FileInputStream(s), 1024);
                out = new BufferedOutputStream(new FileOutputStream(t), 1024);
                byte[] buffer = new byte[1024];
                int len;
                while ((len = in.read(buffer)) != -1) {
                    out.write(buffer, 0, len);
                }
            } finally {
                if (null != in) {
                    in.close();
                }
                if (null != out) {
                    out.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
