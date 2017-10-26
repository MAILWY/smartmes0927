package org.jlhh.mes.controller;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jlhh.mes.model.MesProdTest;
import org.jlhh.mes.model.RetModel;
import org.jlhh.mes.service.MesprodtestService;
import org.jlhh.mes.utils.FileTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Created by wangyong on 2017/9/27.
 */
@RestController
public class MesprodtestController {
    RetModel retModel = new RetModel();
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private MesprodtestService mesprodtestService;

    @RequestMapping(value = "/mesprodtest/select")
    public Object selectMesprodtest(HttpServletRequest request, HttpServletResponse response, @RequestParam String prodNum) {
        MesProdTest mesProdTest = new MesProdTest();
        try {
            try {
                mesProdTest = this.mesprodtestService.getMesprodtestRepository().selectByProdnum(prodNum);
                logger.trace("selectMesprodtest begining..111...." + mesProdTest.getTestDate().toString());
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            if (mesProdTest == null) {
                return retModel.fail("999", "该条码无记录!");
            }

            File newFile = FileTool.createNewFile(prodNum);
            // 新文件写入数据，并下载*****************************************************
            InputStream is = null;
            XSSFWorkbook workbook = null;
            XSSFSheet sheet = null;

            is = new FileInputStream(newFile);// 将excel文件转为输入流
            workbook = new XSSFWorkbook(is);// 创建个workbook
            // 获取第一个sheet
            sheet = workbook.getSheet("Sheet1");
            if (sheet != null) {
                try {
                    //第二行
                    XSSFRow row = sheet.getRow(1);
                    XSSFCell cell = row.getCell(0);

                    //生成日期
                    cell = row.createCell(4);
                    cell.setCellValue(mesProdTest.getTestDate().trim());

                    //生产工单
                    cell = row.createCell(8);
                    cell.setCellValue(mesProdTest.getProdNum().trim());

                    //第三行
                    row = sheet.getRow(2);
                    //产品编号
                    cell = row.createCell(4);
                    cell.setCellValue(mesProdTest.getWorkOrder().trim());
                    //当日台号
                    cell = row.createCell(8);
                    cell.setCellValue(mesProdTest.getTestMach().trim());

                    //第四行
                    row = sheet.getRow(3);
                    //校核
                    cell = row.createCell(4);
                    cell.setCellValue(mesProdTest.getAdjId().trim());
                    //批准
                    cell = row.createCell(8);
                    cell.setCellValue(mesProdTest.getApproId().trim());

                    //第6行
                    row = sheet.getRow(5);
                    //判定结果
                    cell = row.createCell(6);
                    cell.setCellValue(mesProdTest.getChargeResult().trim());
                    //第七行
                    row = sheet.getRow(6);
                    //最高单体
                    cell = row.createCell(3);
                    cell.setCellValue(mesProdTest.getChargeHeight().trim());
                    //最低单体
                    cell = row.createCell(4);
                    cell.setCellValue(mesProdTest.getChargeLow().trim());
                    //压差
                    cell = row.createCell(5);
                    cell.setCellValue(mesProdTest.getChargeDiff().trim());

                    //第8行
                    row = sheet.getRow(7);
                    //判定结果
                    cell = row.createCell(6);
                    cell.setCellValue(mesProdTest.getDischargeResult().trim());

                    //第9行
                    row = sheet.getRow(8);
                    //最高单体
                    cell = row.createCell(3);
                    cell.setCellValue(mesProdTest.getDischargeHeight().trim());
                    //最低单体
                    cell = row.createCell(4);
                    cell.setCellValue(mesProdTest.getDischargeLow().trim());
                    //压差
                    cell = row.createCell(5);
                    cell.setCellValue(mesProdTest.getDischargeDiff().trim());


                    //第10行
                    row = sheet.getRow(9);
                    //放电至3.0V时，电池包压差
                    cell = row.createCell(3);
                    cell.setCellValue(mesProdTest.getDischargeDiff_3().trim());
                    //放电至3.0V时，电池包压差判定结果
                    cell = row.createCell(6);
                    cell.setCellValue(mesProdTest.getDischargeDiffResult().trim());

                    //第11行
                    row = sheet.getRow(10);
                    //充放电过程中温差
                    cell = row.createCell(3);
                    cell.setCellValue(mesProdTest.getDischargeTempdiff().trim());
                    //充放电过程中温差判定结果
                    cell = row.createCell(6);
                    cell.setCellValue(mesProdTest.getDischargeTempResult().trim());

                    //第12行
                    row = sheet.getRow(11);
                    //补电50%时，电池包电压
                    cell = row.createCell(3);
                    cell.setCellValue(mesProdTest.getChargeHalfVolt().trim());
                    //补电50%时，电池包电压判定结果
                    cell = row.createCell(6);
                    cell.setCellValue(mesProdTest.getChargeHalfResult().trim());

                    //第13行
                    row = sheet.getRow(12);
                    //补电50%时，电池包的SOC
                    cell = row.createCell(3);
                    cell.setCellValue(mesProdTest.getChargeHalfSoc().trim());
                    //补电50%时，电池包的SOC判定结果
                    cell = row.createCell(6);
                    cell.setCellValue(mesProdTest.getChargeHalfSoc_r().trim());

                    //第14行
                    row = sheet.getRow(13);
                    //最终判定
                    cell = row.createCell(2);
                    cell.setCellValue(mesProdTest.getLastJudgement().trim());

                    response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
                    response.setHeader("Content-disposition", "attachment;filename=" + newFile.getName());//默认Excel名称
                    response.flushBuffer();
                    workbook.write(response.getOutputStream());
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (null != is) {
                            is.close();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return retModel.fail("009", "操作异常,详细错误信息请查看控制台日志!");
        }
        return retModel.success();
    }

}
