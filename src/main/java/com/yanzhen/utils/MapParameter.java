package com.yanzhen.utils;

import java.util.HashMap;
import java.util.Map;

//保证满足连写，一样的都是做代码复用
public class MapParameter {

    //私有构造，满足单例形式，对外提供一个方法

    private Map<String,Object> paramMap = new HashMap<>();

    private MapParameter(){

    }

    //
    public static MapParameter getInstance(){
        return new MapParameter();
    }

    public Map<String,Object> getMap(){
        return  paramMap;
    }

    public MapParameter put(Map<String,Object> map){
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            paramMap.put(entry.getKey(),entry.getValue());
        }
        return this;
    }

    public MapParameter put(String key,Object val){
        paramMap.put(key,val);
        return this;
    }

    public MapParameter add(String key,Object val){
       return this.put(key,val);
    }

    public MapParameter addId(Object val){
        return this.put("id",val);
    }

    //减少定义，采用map的方法去调用
    public static void main(String[] args) {
        Map<String, Object> map = MapParameter.getInstance().put("name", "hua").put("age", 30).getMap();
        System.out.println(map);
    }

}
