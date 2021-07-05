package com.example.demo;


import java.util.LinkedList;

public class Hash {

	LinkedList<Entry>[] table;
	private   LinkedList<Entry>[] TABLE_LIST =  new LinkedList[20];
////	private   int num = 10;
	public Hash(int num){
		this.table = new LinkedList[num];
	}
	public Hash(){
		this.table = TABLE_LIST;
	}

//	LinkedList<Entry>[] tables = new LinkedList[998];
	// 如果hashCode相同的对象链表结合中
//	@SuppressWarnings("unchecked")
	public void put(String key, String value) throws Exception {
		Entry newEntry = new Entry(key, value);
		if(key ==null){
			throw new Exception("未添加资产,请重新添加");
		}

		int hashCode = key.hashCode();// 97
		// hash取模，获取余数
		int hash = hashCode % table.length;// 998 998以内 00997
		// 1.获取该下标元素,是否有LinkedList
		LinkedList<Entry> entryLinkedList = table[hash];
		if (entryLinkedList == null) {
			// 没有hash冲突
			entryLinkedList = new LinkedList<Entry>();
			entryLinkedList.add(newEntry);
			// tables数组
			table[hash] = entryLinkedList;
		} else {
			for (Entry entry : entryLinkedList) {
				if (entry.key.equals(key)) {
					// equals相等,hashCode 一定相同 说明:是同一个对象
					entry.value = value;// 直接覆盖
				} else {
					// hashCode 相同，对象的值不一定相同
					// 发生hash冲突问题，直接在后面继续添加链表节点
					entryLinkedList.add(newEntry);
				}
			}
		}
	}

	// hash算法
	// System.out.println(hash);
	// 两个对象做比较的时候,如果hashCode相同，对象的值是否一定相同 不一定相同
	// 两个对象做比较的时候,如果 equals比较相同，对象的值是否一定相同 相同

	// 查询直接使用hash值直接定位在数组那个位置
	public String get(String  key) {
		int hashCode = key.hashCode();// 97
		// hash取模，获取余数
		int modelVal = hashCode % table.length;// 998 998以内 00997
		LinkedList<Entry> linkedList = table[modelVal];
		if(linkedList == null){
			return null;
		}
		for (Entry entry : linkedList) {
			if (entry.key.equals(key)) {
				return (String) entry.value;
			}
		}
		return null;
	}


//	public Object  get2(Object key) {
//		int hashCode = key.hashCode();// 97
//		// hash取模，获取余数
//		int hash = hashCode % tables.length;// 998 998以内 00997
//		LinkedList<Entry> linkedList = tables[hash];
//
//		for (Entry entry : linkedList) {
//			if (entry.key.equals(key)) {
//				return entry.value;
//			}
//		}
//		return tables[hash];
//	}



	public static void main(String[] args) throws Exception {
		Hash linkedListHashMap = new Hash();
		Hash linkedListHashMap2 = new Hash();
		Hash linkedListHashMap3 = new Hash(3);
		linkedListHashMap.put("a", "aaaa");
		linkedListHashMap.put("c", "ccccc");// 覆盖
		linkedListHashMap.put("e", "22");
		System.out.println(linkedListHashMap.get("a"));
		System.out.println(linkedListHashMap.get("b"));
//		System.out.println(linkedListHashMap.get(null));null

//		System.out.println(linkedListHashMap.get("a"));
//		System.out.println(linkedListHashMap.get("b"));
//
//		linkedListHashMap2.put("a", "1111");
//		linkedListHashMap2.put("d", "222");// 覆盖
//		System.out.println(linkedListHashMap2.get("a"));
//		System.out.println(linkedListHashMap2.get("e"));
//
//		System.out.println(linkedListHashMap.get("a"));
//
//		linkedListHashMap3.put("a", "333");
//		System.out.println(linkedListHashMap3.get("a"));
	}

	class Entry<Key, Value> {

		// hashMap集合存储的key
		Key key;
		// hashMap集合存储的value
		Value value;

		public Entry(Key key, Value value) {
			super();
			this.key = key;
			this.value = value;
		}
	}

}


