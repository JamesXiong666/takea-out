package com.sky.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 封装分页查询结果
 * @Data是Lombok库中的一个注解，用于生成类的getter、setter、toString、hashCode、equals方法
 * @AllArgsConstructor会为一个类生成一个包含所有字段的构造函数，允许创建类的实例时直接为所有字段赋予初始值
 * 而无需手动创建构造函数
 * @NoArgsConstructor会为一个类生成一个无参的构造函数
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResult implements Serializable {

    private long total; //总记录数

    private List records; //当前页数据集合

}
