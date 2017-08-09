package com.herohuang.framework.bean;

import com.herohuang.framework.util.CastUtil;
import com.herohuang.framework.util.CollectionUtil;
import com.herohuang.framework.util.StringUtil;

import java.net.FileNameMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 封装请求参数
 *
 * @author Acheron
 * @date 25/07/2017
 * @since 1.0.0
 */
public class Param {

    private List<FormParam> formParamList;
    private List<FileParam> fileParamList;

    public Param(List<FormParam> formParamList) {
        this.formParamList = formParamList;
    }

    public Param(List<FormParam> formParamList, List<FileParam> fileParamList) {
        this.formParamList = formParamList;
        this.fileParamList = fileParamList;
    }

    /**
     * 获取请求参数映射
     */
    public Map<String, Object> getFieldMap() {
        Map<String, Object> fieldMap = new HashMap<>();
        if (CollectionUtil.isNotEmpty(formParamList)) {
            for (FormParam formParam : formParamList) {
                String fieldName = formParam.getFieldName();
                Object fieldValue = formParam.getFieldValue();
                if (fieldMap.containsKey(fieldName)) {
                    fieldValue = fieldMap.get(fieldName) + StringUtil.SEPARATOR + fieldValue;
                }
                fieldMap.put(fieldName, fieldValue);
            }
        }
        return fieldMap;
    }

    /**
     * 获取上传文件映射
     */
    public Map<String, List<FileParam>> getFileMap() {
        Map<String, List<FileParam>> fileMap = new HashMap<>();
        if (CollectionUtil.isNotEmpty(fileParamList)) {
            for (FileParam fileParam : fileParamList) {
                String fieldName = fileParam.getFieldName();
                List<FileParam> fileParamList;
                if (fileMap.containsKey(fieldName)) {
                    fileParamList = fileMap.get(fieldName);
                } else {
                    fileParamList = new ArrayList<>();
                }
                fileParamList.add(fileParam);
                fileMap.put(fieldName, fileParamList);
            }
        }
        return fileMap;
    }

    /**
     * 验证是否为空
     *
     * @param
     * @return
     */
    public boolean isEmpty() {
        return CollectionUtil.isEmpty(paramMap);
    }


    public long getLong(String name) {
        return CastUtil.castLong(paramMap.get(name));
    }

    public int getInt(String name) {
        return CastUtil.castInt(paramMap.get(name));
    }

    public String getString(String name) {
        return CastUtil.castString(paramMap.get(name));
    }

    public boolean getBoolean(String name) {
        return CastUtil.castBoolean(paramMap.get(name));
    }

    public double getDouble(String name) {
        return CastUtil.castDouble(paramMap.get(name));
    }

}
