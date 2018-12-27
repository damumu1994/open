/**
 * Copyright (c) @2016,cmct 版权所有
 */
package util;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;


@Data
@Builder
public class JsonPage<T> {

    private List<T> rows;
    private int page;//当前页
    private int total;//总页数
    private Long records;//总条数

    public JsonPage() {
    }

    /**
     * 通过List生成JsonPage
     *
     * @param rows
     * @param page
     * @param total
     * @param records
     */
    public JsonPage(List<T> rows, int page, int total, Long records) {
        this.rows = rows;
        this.page = page;
        this.total = total;
        this.records = records;
    }


}
