package com.ding.util;

public class HandleAddress {
    public static String getAddress(String name,String author,String type,int min,int max){
        // 记录返回的参数给表单获取
        StringBuilder address = new StringBuilder("customer/bookServlet?action=pageByThree");
        if(!TextUtils.isEmpty(name)){
            address.append("&name=").append(name);
        }
        if(!TextUtils.isEmpty(author)){
            address.append("&author=").append(author);
        }
        if(!TextUtils.isEmpty(type)){
            address.append("&type=").append(type);
        }
        if(min != 0){
            address.append("&min=").append(min);
        }
        if(max != Integer.MAX_VALUE){
            address.append("&max=").append(max);
        }
        if(TextUtils.isEmpty(name) && TextUtils.isEmpty(author) && TextUtils.isEmpty(type) && min == 0 && max == Integer.MAX_VALUE ){
            address.delete(32,39);
        }
        // 返回代表地址的字符串
        return address.toString();
    }

    public static void main(String[] args) {
    }
}
