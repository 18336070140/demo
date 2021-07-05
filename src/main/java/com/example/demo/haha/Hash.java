package com.example.demo.haha;

import java.util.LinkedList;

public class Hash {

	LinkedList<Entry>[] table;
	private final LinkedList<Entry>[] TABLE_LIST = new LinkedList[1];

	public Hash(){
		this.table = TABLE_LIST;
	}
	public Hash(int size){
		this.table = new LinkedList[size];
	}


	public String query(String key){
		//key不能为null
		int hashCode = key.hashCode();
		//取模
		int modelVal = hashCode % table.length;
		//取数组相应下标值，若不存在返回null
		LinkedList<Entry> linkedList = table[modelVal];
		if(linkedList == null){
			return null;
		}
		for(Entry entry : linkedList){
			if(entry.key.equals(key)){
				return (String)entry.value;
			}
		}
		//不存在则返回null
		return null;
	}

	public void insert(String key,String value){

		Entry newEntry = new Entry(key, value);
		//key不能为null
		int hashCode = key.hashCode();
		int modelVal = hashCode % table.length;
		//获取该下标元素，判断是否有LinkedList
		LinkedList<Entry> entryList = table[modelVal];
		if(entryList == null) {
			//没有hash冲突
			entryList = new LinkedList<Entry>();
			entryList.add(newEntry);
			table[modelVal] = entryList;
		} else {
			for(Entry entry : entryList) {
				if(entry.key.equals(key)){
					//key相同，value覆盖
					entry.value = value;
				} else {
					//添加链表节点
					entryList.add(newEntry);
				}
			}
		}
	}

	public static void main(String[] args) {
		Hash myHash = new Hash(3);
		myHash.insert("zl","hello");
		myHash.insert("zl","word");
		myHash.insert("s","word");
		System.out.println(myHash.query("zl"));
	}

	//节点
	class Entry<Key, Value> {
		Key key;
		Value value;

		public Entry(Key key, Value value){
			super();
			this.key = key;
			this.value = value;
		}
	}
}