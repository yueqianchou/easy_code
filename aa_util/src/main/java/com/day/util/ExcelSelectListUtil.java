package com.day.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * excel下拉框工具类
 * Created by Administrator on 2019/10/25 0025 10:50
 */
public class ExcelSelectListUtil {

    /**
     * firstRow 開始行號 根据此项目，默认为2(下标0开始)
     * lastRow  根据此项目，默认为1000 最大65535
     * firstCol 区域中第一个单元格的列号 (下标0开始)
     * lastCol 区域中最后一个单元格的列号
     * strings 下拉内容
     */
    public static void selectList(Workbook workbook, int firstCol, int lastCol, String[] strings) {
        selectList(workbook, firstCol, lastCol, strings, 0);
    }

    /**
     * firstRow 開始行號 根据此项目，默认为2(下标0开始)
     * lastRow  根据此项目，默认为1000 最大65535
     * firstCol 区域中第一个单元格的列号 (下标0开始)
     * lastCol 区域中最后一个单元格的列号
     * strings 下拉内容
     * index sheet页序号
     */
    public static void selectList(Workbook workbook, int firstCol, int lastCol, String[] strings, int index) {
        if (strings != null && StringUtils.join(strings).length() > 250) {
            addRefereneceSheet(workbook, firstCol, lastCol, Arrays.asList(strings), index);
        } else {
            Sheet sheet = workbook.getSheetAt(index);
            //  生成下拉列表
            //  只对(x，x)单元格有效
            CellRangeAddressList cellRangeAddressList = new CellRangeAddressList(1, 1000, firstCol, lastCol);
            //  生成下拉框内容
            DVConstraint dvConstraint = DVConstraint.createExplicitListConstraint(strings != null ? strings : new String[]{});
            HSSFDataValidation dataValidation = new HSSFDataValidation(cellRangeAddressList, dvConstraint);
            //  对sheet页生效
            sheet.addValidationData(dataValidation);
        }
    }

    /**
     * 解决下拉框大小大于255 ASCII
     *
     * @param workbook
     * @param firstCol
     * @param lastCol
     * @param strings
     * @param index    sheet页序号
     */
    public static void selectListForBig(Workbook workbook, int firstCol, int lastCol, String[] strings, int index) {
        if (CommonUtils.isEmpty(strings)) {
            return;
        }
        addRefereneceSheet(workbook, firstCol, lastCol, Arrays.asList(strings), index);
    }

    /**
     * 解决下拉框大小大于255 ASCII
     *
     * @param workbook
     * @param firstCol
     * @param lastCol
     * @param strings
     */
    public static void selectListForBig(Workbook workbook, int firstCol, int lastCol, String[] strings) {
        selectListForBig(workbook, firstCol, lastCol, strings, 0);
    }

    /**
     * 解决下拉框大小大于255 ASCII
     *
     * @param workbook
     * @param firstCol
     * @param lastCol
     * @param list
     */
    public static void selectListForBig(Workbook workbook, int firstCol, int lastCol, List<String> list) {
        String[] strings = list.toArray(new String[]{});
        selectListForBig(workbook, firstCol, lastCol, strings);
    }

    /**
     * firstRow 開始行號 根据此项目，默认为2(下标0开始)
     * lastRow  根据此项目，默认为1000 最大65535
     * firstCol 区域中第一个单元格的列号 (下标0开始)
     * lastCol 区域中最后一个单元格的列号
     * strings 下拉内容
     */
    public static void selectList(Workbook workbook, int firstCol, int lastCol, List<String> strings) {
        if (CommonUtils.isEmpty(strings)) {
            return;
        }
        if (!CollectionUtils.isEmpty(strings) && StringUtils.join(strings).length() > 250) {
            addRefereneceSheet(workbook, firstCol, lastCol, strings);
        } else {
            selectList(workbook, firstCol, lastCol, strings, 0);
        }
    }

    /**
     * firstRow 開始行號 根据此项目，默认为2(下标0开始)
     * lastRow  根据此项目，默认为1000 最大65535
     * firstCol 区域中第一个单元格的列号 (下标0开始)
     * lastCol 区域中最后一个单元格的列号
     * strings 下拉内容
     * index sheet页序号
     */
    public static void selectList(Workbook workbook, int firstCol, int lastCol, List<String> strings, int index) {
        if (!CollectionUtils.isEmpty(strings) && strings.size() > 250) {
            addRefereneceSheet(workbook, firstCol, lastCol, strings, index);
        } else {
            Sheet sheet = workbook.getSheetAt(index);
            //  生成下拉列表
            //  只对(x，x)单元格有效
            CellRangeAddressList cellRangeAddressList = new CellRangeAddressList(1, 1000, firstCol, lastCol);
            //  生成下拉框内容
            DVConstraint dvConstraint = DVConstraint.createExplicitListConstraint(strings.stream().toArray(String[]::new));
            HSSFDataValidation dataValidation = new HSSFDataValidation(cellRangeAddressList, dvConstraint);
            //  对sheet页生效
            sheet.addValidationData(dataValidation);
        }
    }

    /**
     * 添加外部引用sheet，避免下拉框255字数限制导致的bug
     *
     * @param workbook
     * @param dataReferenceList 下拉框限制具体字符串list
     * @param firstCol          下拉框所在开始列
     * @param lastCol
     */
    public static void addRefereneceSheet(Workbook workbook, Integer firstCol, Integer lastCol, List<String> dataReferenceList) {
        addRefereneceSheet(workbook, firstCol, lastCol, dataReferenceList, 0);
    }

    /**
     * 添加外部引用sheet，避免下拉框255字数限制导致的bug
     *
     * @param workbook
     * @param dataReferenceList 下拉框限制具体字符串list
     * @param firstCol          下拉框所在开始列
     * @param lastCol
     * @param index             sheet序号
     */
    public static void addRefereneceSheet(Workbook workbook, Integer firstCol, Integer lastCol, List<String> dataReferenceList, int index) {
        int numberOfSheets = workbook.getNumberOfSheets();
        numberOfSheets++;
        String sheetName = "dataReference" + numberOfSheets;
        Sheet dataReferenceSheet = workbook.createSheet(sheetName);
        workbook.setSheetHidden(workbook.getSheetIndex(sheetName), true);
        for (int j = 0; j < dataReferenceList.size(); j++) {
            Row row = dataReferenceSheet.createRow(j);
            Cell cell = row.createCell(0);
            cell.setCellValue(dataReferenceList.get(j));
        }
        Name name = workbook.createName();
        name.setRefersToFormula(sheetName + "!$A$1:$A$" + dataReferenceList.size());

        String dataReferenceNameName = "dataReferenceNameName" + numberOfSheets;
        name.setNameName(dataReferenceNameName);
        DVConstraint dvConstraint = DVConstraint.createFormulaListConstraint(dataReferenceNameName);
        CellRangeAddressList addressList = new CellRangeAddressList(1, 1000, firstCol, lastCol);
        HSSFDataValidation dataValidation = new HSSFDataValidation(addressList, dvConstraint);
        Sheet indexSheet = workbook.getSheetAt(index);
        indexSheet.addValidationData(dataValidation);
    }

    public static void addCascadedRefLimit(Workbook workbook, Map<String, List<String>> referList, String oneLevelMsg, String twoLevelMsg
            , int level1col, int level2col) {
        addCascadedRefLimit(workbook, referList, oneLevelMsg, twoLevelMsg, level1col, level2col, 1000);
    }

    /**
     * 添加外部引用sheet，避免下拉框255字数限制导致的bug
     *
     * @param workbook
     * @param referList   下拉框限制具体字符串list
     * @param oneLevelMsg
     * @param twoLevelMsg
     * @param level1col
     * @param level2col
     * @param maxRow
     */
    public static void addCascadedRefLimit(Workbook workbook, Map<String, List<String>> referList, String oneLevelMsg, String twoLevelMsg
            , int level1col, int level2col, int maxRow) {
        addCascadedRefLimit(workbook, referList, oneLevelMsg, twoLevelMsg, level1col, level2col, maxRow, 0);
    }

    /**
     * 添加外部引用sheet，避免下拉框255字数限制导致的bug
     *
     * @param workbook
     * @param referList   下拉框限制具体字符串list
     * @param oneLevelMsg
     * @param twoLevelMsg
     * @param level1col
     * @param level2col
     * @param maxRow
     * @param index       sheet页序号
     */
    public static void addCascadedRefLimit(Workbook workbook, Map<String, List<String>> referList, String oneLevelMsg, String twoLevelMsg
            , int level1col, int level2col, int maxRow, int index) {
        int numberOfSheets = workbook.getNumberOfSheets();
        numberOfSheets++;
        String dataSheet = "data" + numberOfSheets;
        Sheet dataReferenceSheet = workbook.createSheet(dataSheet);
        workbook.setSheetHidden(workbook.getSheetIndex(dataReferenceSheet), true);

        int rowId = 0;
        // 设置第一行，存省的信息
//		Row proviRow = dataReferenceSheet.createRow(rowId++);
        Iterator<String> keyIterator = referList.keySet().iterator();
        while (keyIterator.hasNext()) {
            String key = keyIterator.next();
            List<String> indexTwoValueList = referList.get(key);

            Row row = dataReferenceSheet.createRow(rowId++);
            row.createCell(0).setCellValue(key);
            for (int i = 0; i < indexTwoValueList.size(); i++) {
                Cell cell = row.createCell(i + 1);
                cell.setCellValue(indexTwoValueList.get(i));
            }

            // 添加名称管理器
            int size = indexTwoValueList.size();
            if (size == 0) {
                continue;
            }
            String range = getRange(1, rowId, indexTwoValueList.size());
            Name name = workbook.createName();
            name.setNameName("" + key);
            String formula = dataSheet + "!" + range;
            name.setRefersToFormula(formula);
        }

        HSSFWorkbook xssfWorkbook = (HSSFWorkbook) workbook;
        HSSFSheet sheet1 = xssfWorkbook.getSheetAt(index);
        HSSFDataValidationHelper dvHelper = new HSSFDataValidationHelper(sheet1);

        // 一级指标规则
        //屏蔽以前代码
        //DataValidationConstraint provConstraint = dvHelper.createExplicitListConstraint(referList.keySet().toArray(new String[]{}));
        //CellRangeAddressList provRangeAddressList = new CellRangeAddressList(1, 1000, level1col, level1col);
        //DataValidation provinceDataValidation = dvHelper.createValidation(provConstraint, provRangeAddressList);
        //provinceDataValidation.createErrorBox("error", oneLevelMsg);
        //sheet1.addValidationData(provinceDataValidation);
        ////ExcelSelectListUtil.selectListForBig(workbook,level1col,level1col,referList.keySet().toArray(new String[]{}));
        //provinceDataValidation.setShowErrorBox(true);
        //provinceDataValidation.setSuppressDropDownArrow(true);

        //解决下拉问题
        addRefereneceSheet(workbook, level1col, level1col, Arrays.asList(referList.keySet().toArray(new String[]{})), index);


        // 二级指标规则
        // "INDIRECT($A$" + 2 + ")" 表示规则数据会从名称管理器中获取key与单元格 A2 值相同的数据，如果A2是浙江省，那么此处就是
        for (int i = 0; i < maxRow; i++) {
            DataValidationConstraint formula = dvHelper.createFormulaListConstraint("INDIRECT($" +
                    CommonUtils.numberToLetter(level1col + 1) + "$" + (i + 2) + ")");
            CellRangeAddressList rangeAddressList = new CellRangeAddressList(i + 1, i + 1, level2col, level2col);
            DataValidation cacse = dvHelper.createValidation(formula, rangeAddressList);
            cacse.createErrorBox("error", twoLevelMsg);
            sheet1.addValidationData(cacse);
        }

    }


    /**
     * @param offset   偏移量，如果给0，表示从A列开始，1，就是从B列
     * @param rowId    第几行
     * @param colCount 一共多少列
     * @return 如果给入参 1,1,10. 表示从B1-K1。最终返回 $B$1:$K$1
     * @author denggonghai 2016年8月31日 下午5:17:49
     */
    public static String getRange(int offset, int rowId, int colCount) {
        char start = (char) ('A' + offset);
        if (colCount <= 25) {
            char end = (char) (start + colCount - 1);
            return "$" + start + "$" + rowId + ":$" + end + "$" + rowId;
        } else {
            char endPrefix = 'A';
            char endSuffix = 'A';
            if ((colCount - 25) / 26 == 0 || colCount == 51) {// 26-51之间，包括边界（仅两次字母表计算）
                if ((colCount - 25) % 26 == 0) {// 边界值
                    endSuffix = (char) ('A' + 25);
                } else {
                    endSuffix = (char) ('A' + (colCount - 25) % 26 - 1);
                }
            } else {// 51以上
                if ((colCount - 25) % 26 == 0) {
                    endSuffix = (char) ('A' + 25);
                    endPrefix = (char) (endPrefix + (colCount - 25) / 26 - 1);
                } else {
                    endSuffix = (char) ('A' + (colCount - 25) % 26 - 1);
                    endPrefix = (char) (endPrefix + (colCount - 25) / 26);
                }
            }
            return "$" + start + "$" + rowId + ":$" + endPrefix + endSuffix + "$" + rowId;
        }
    }
}
