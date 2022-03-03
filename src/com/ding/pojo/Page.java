package com.ding.pojo;


import java.util.List;

// 分页对象

/**
 * Page分页模型对象
 * @param <T> 泛型具体的类对象javabean
 */
public class Page<T> {

    public static final int PAGE_SIZE = 4;
    // 当前页码
    private int pageNo;
    // 总页码
    private int pageTotal;
    // 当前页显示数量
    private int pageSize = PAGE_SIZE;
    // 总记录数
    private int pageTotalCount;
    // 当前页面数据
    private List<T> items;
    // 分页条的请求地址(sql语句和不同角色决定)
    private String url;
    public Page() {

    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        // 进行越界检查

        this.pageNo = pageNo;
    }

    public int getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(int pageTotal) {
        this.pageTotal = pageTotal;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageTotalCount() {
        return pageTotalCount;
    }

    public void setPageTotalCount(int pageTotalCount) {
        this.pageTotalCount = pageTotalCount;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                ", pageTotal=" + pageTotal +
                ", pageSize=" + pageSize +
                ", pageTotalCount=" + pageTotalCount +
                ", items=" + items +
                ", url='" + url + '\'' +
                '}';
    }

//    public Page(int pageNo, int pageTotal, int pageSize, int pageTotalCount, List<T> items) {
//        this.pageNo = pageNo;
//        this.pageTotal = pageTotal;
//        this.pageSize = pageSize;
//        this.pageTotalCount = pageTotalCount;
//        this.items = items;
//    }
}
