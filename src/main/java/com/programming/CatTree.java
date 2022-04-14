package com.programming;

import com.alibaba.fastjson.JSON;
import java.util.ArrayList;
import java.util.List;

public class CatTree {

    private List<Cate> cateList = new ArrayList<>();

    public CatTree(List<Cate> cateList) {
        this.cateList = cateList;
    }

    public List<Cate> builTree(){
        List<Cate> treeCates =new  ArrayList<Cate>();
        for(Cate cateNode : getRootNode()) {
            cateNode =buildChilTree(cateNode);
            treeCates.add(cateNode);
        }
        return treeCates;
    }

    public Cate buildChilTree(Cate pNode){
        List<Cate> chilCates =new  ArrayList<Cate>();
        for(Cate cateNode : cateList) {
            if(pNode.getCateId().equals(cateNode.getCatePId())) {
                chilCates.add(buildChilTree(cateNode));
            }
        }
        pNode.setChildren(chilCates);
        return pNode;
    }

    public List<Cate> getRootNode() {
        List<Cate> rootCateLists =new  ArrayList<Cate>();
        for(Cate cateNode : cateList) {
            if(cateNode.getCatePId() == null) {
                rootCateLists.add(cateNode);
            }
        }
        return rootCateLists;
    }

    public void fullTag(List<Cate> treeCates,List<Tag> tagList){
        for (Cate cate:treeCates) {
            if("1".equals(cate.getIsLeaf())){
                List<Tag> tags = new ArrayList<>();
                for (Tag tag : tagList) {
                    if(tag.getCateId().equals(cate.getCateId())){
                        tags.add(tag);
                    }
                    cate.setTags(tags);
                }
            }else {
                fullTag(cate.getChildren(),tagList);
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

    public static void main(String[] args) {
        List<Cate> cateList = new ArrayList();
        cateList.add(new Cate("0",null,"根节点","0"));
        cateList.add(new Cate("1","0","一级","0"));
        cateList.add(new Cate("2","1","二级","1"));
        CatTree catTree = new CatTree(cateList);
        //类目树
        cateList = catTree.builTree();
        String json = JSON.toJSONString(cateList);
        System.out.println(json);
        List<Tag> tagList = new ArrayList();
        tagList.add(new Tag("001","2","tag001"));
        tagList.add(new Tag("002","2","tag002"));
        catTree.fullTag(cateList,tagList);
        String catTagList = JSON.toJSONString(cateList);
        System.out.println(catTagList);
    }
}
