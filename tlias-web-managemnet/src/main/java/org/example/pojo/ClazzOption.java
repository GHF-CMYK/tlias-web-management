package org.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 班级人数统计结果
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClazzOption {
    private List clazzList;
    private List dataList;
}
