package com.csj.cn.whr.utils;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author chensijia
 * @Date 2020/4/1517:32
 */
public class ExcelListener extends AnalysisEventListener {

    /**
     * 自定义用于暂时存储data。
     * 可以通过实例获取该值
     */
    private List<Object> datas = new ArrayList<Object>();
    private static final int BATCH_COUNT = 5;
    private static int count = 1;

    @Override
    public void invoke(Object object, AnalysisContext analysisContext) {
        //数据存储到list，供批量处理，或后续自己业务逻辑处理。
        datas.add(object);
        //根据自己业务做处理
        doSomething(object);
    }

    /**
     * 通过 AnalysisContext 对象还可以获取当前 sheet，当前行等数据
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        // datas.clear();//解析结束销毁不用的资源
    }

    public List<Object> getDatas() {
        return datas;
    }

    public void setDatas(List<Object> datas) {
        this.datas = datas;
    }

    private void doSomething(Object object) {
        //入库调用接口
        count++;
        if (datas.size() >= BATCH_COUNT) {
            datas.clear();
        }
    }
}

