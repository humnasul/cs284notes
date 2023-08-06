package hashing;

import java.util.ArrayList;

//hashnode -> hashnode.next -> ...
class HashNode<K, V> {
	K key;
	V value;
	int hashCode;

	HashNode<K, V> next;

	public HashNode(K key, V value, int hashCode){
		this.key = key;
		this.value = value;
		this.hashCode = hashCode;
	}
}

public class HashTable<K, V> {
	//our hash table is essentially an array of linkedlists
	private ArrayList<HashNode<K, V> > bucketArray;

	//capacity of array
	private int numBuckets;

	//current size of array
	private int size;


	public HashTable(){
		bucketArray = new ArrayList<>();
		numBuckets = 10;
		size = 0;

		//initalize the arraylist to contain empty linkedlists
		for (int i = 0; i < numBuckets; i++)
			bucketArray.add(null);
	}

	public int getSize() { 
		return size; 
	}
	public boolean isEmpty() { 
		return getSize() == 0; 
	}

	//sets an index in the array for an item (the hashcode)
	private int getIndex(K key){
		int code = key.hashCode();
		int index = code % numBuckets;
		//index must be postive, so fix if the index is negative
		return index < 0 ? index * -1 : index;
	}

	//returns the value for the specified key
	public V get(K key){
		int bucketIndex = getIndex(key);
		//int hashCode = key.hashCode();
		
		HashNode<K,V> head = bucketArray.get(bucketIndex);
		//search for the key in the linkedlist
		while (head != null) {
			if (head.key.equals(key)) {
				return head.value;
			}
			head = head.next;
		}
		return null;
	}

	//add K, V pair to hash table
	public void put(K key, V value){
		int bucketIndex = getIndex(key);
		int hashCode = key.hashCode();
		
		HashNode<K, V> head = bucketArray.get(bucketIndex);
		//check if the key is already in the linkedlist
		while (head != null) {
			if (head.key.equals(key)) {
				head.value = value;
				return;
			}
			head = head.next;
		}
		//if the key doesn't already exist we have to add it to the list
		size++;
		//get the head of the linkedlist at the appropriate index
		head = bucketArray.get(bucketIndex);
		HashNode<K, V> newNode = new HashNode<K, V>(key, value, hashCode);
		newNode.next = head;
		
		//built-in function for arraylist to replace an element at an index with a new element
		bucketArray.set(bucketIndex, newNode);

		//we can double the size of the hashtable if we have time at the end
	}

	public static void main(String[] args){
		HashTable<Integer, String> ht = new HashTable<Integer, String>();
		ht.put(4, "Jacob is dumb");
		ht.put(7, "hahahaha jacob");
		ht.put(5,  "Jacob ");
		System.out.println(ht.get(5));
	}
}
