package com.programming;

import com.alibaba.fastjson.JSON;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CatTree2 {

    private List<Cate> loop(List<Cate> list) throws Exception {
        List<Cate> cateList = new ArrayList<>();
        Map<String,Cate> cateMap = new HashMap<>();
        for (Cate cat : list) {
            if(cateMap.get(cat.getCateId()) != null){
                //合并属性工具
                mergeObject(cateMap.get(cat.getCateId()),cat);
            }else {
                cateMap.put(cat.getCateId(),cat);
            }
            if(cat.getCatePId()!=null){
                Cate parent = cateMap.get(cat.getCatePId()) !=null ? cateMap.get(cat.getCatePId()): new Cate(cat.getCatePId(),null,"","");
                List<Cate> children = parent.getChildren() != null ? parent.getChildren():new ArrayList<>();
                children.add(cat);
                parent.setChildren(children);
                cateMap.put(cat.getCatePId(),parent);
            }else {
                cateList.add(cat);
            }
        }
        return cateList;
    }
    public static <M> void merge(M target, M destination) throws Exception {
        BeanInfo beanInfo = Introspector.getBeanInfo(target.getClass());
        for (PropertyDescriptor descriptor : beanInfo.getPropertyDescriptors()) {
            if (descriptor.getWriteMethod() != null) {
                Object defaultValue = descriptor.getReadMethod().invoke(destination);
                if(defaultValue!=null && !"".equals(defaultValue)){
                    descriptor.getWriteMethod().invoke(target, defaultValue);
                }
            }
        }
    }
    public static <T>  void mergeObject(T origin, T destination) {
        if (origin == null || destination == null){
            return;
        }
        if(!origin.getClass().equals(destination.getClass())){
            return;
        }
        Field[] fields =origin.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            try {
                fields[i].setAccessible(true);
                Object value = fields[i].get(origin);
                if (null != value) {
                    fields[i].set(destination, value);
                }
                fields[i].setAccessible(false);
            }catch (Exception e) {
            }
        }
    }


    static class Tag{
        private String tagId;
        private String cateId;
        private String tagName;

        public Tag(String tagId, String cateId, String tagName) {
            this.tagId = tagId;
            this.cateId = cateId;
            this.tagName = tagName;
        }

        public String getTagId() {
            return tagId;
        }

        public void setTagId(String tagId) {
            this.tagId = tagId;
        }

        public String getCateId() {
            return cateId;
        }

        public void setCateId(String cateId) {
            this.cateId = cateId;
        }

        public String getTagName() {
            return tagName;
        }

        public void setTagName(String tagName) {
            this.tagName = tagName;
        }
    }

    static class Cate {
        private String cateId;
        private String catePId;
        private String cateName;
        private String isLeaf;
        private List<Cate> children;
        private List<Tag> tags;

        public Cate(String cateId, String catePId, String cateName, String isLeaf) {
            this.cateId = cateId;
            this.catePId = catePId;
            this.cateName = cateName;
            this.isLeaf = isLeaf;

        }

        public List<Tag> getTags() {
            return tags;
        }

        public void setTags(List<Tag> tags) {
            this.tags = tags;
        }

        public String getCateId() {
            return cateId;
        }

        public void setCateId(String cateId) {
            this.cateId = cateId;
        }

        public String getCatePId() {
            return catePId;
        }

        public void setCatePId(String catePId) {
            this.catePId = catePId;
        }

        public String getCateName() {
            return cateName;
        }

        public void setCateName(String cateName) {
            this.cateName = cateName;
        }

        public String getIsLeaf() {
            return isLeaf;
        }

        public void setIsLeaf(String isLeaf) {
            this.isLeaf = isLeaf;
        }

        public List<Cate> getChildren() {
            return children;
        }

        public void setChildren(List<Cate> children) {
            this.children = children;
        }
    }

    public static void main(String[] args) throws Exception {
        List< Cate> cateList = new ArrayList();
        cateList.add(new  Cate("0",null,"根节点","0"));
        cateList.add(new  Cate("1","0","一级","0"));
        cateList.add(new  Cate("2","1","二级","1"));
        CatTree2 catTree2 = new CatTree2();
        //类目树
        List< Cate> cats = catTree2.loop(cateList);
        String json = JSON.toJSONString(cats);
        System.out.println(json);
//        List<CatTree.Tag> tagList = new ArrayList();
//        tagList.add(new CatTree.Tag("001","2","tag001"));
//        tagList.add(new CatTree.Tag("002","2","tag002"));
//        catTree.fullTag(cateList,tagList);
//        String catTagList = JSON.toJSONString(cateList);
//        System.out.println(catTagList);
    }
}
