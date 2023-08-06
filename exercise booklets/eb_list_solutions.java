//

//Using SLL's getAt and set functions with index. Not creating a new list
void reverse(){
	for(int i= 0; i<size; i++){
		int rear = size - i - 1; //to trace the linked list from back
		if(i < rear){
			E temp = getAt(i);
			set(i, getAt(rear));
			set(rear, temp);
		}else
			break;
	}
}

//create a new list for reverse()
void reverse(){
	SLL<E> newList = new SLL<E>();
	Node<E> current = head;
	int newListIndex = size - 1;
	while(current!=null)
	{
		newList.add(current.data, newListIndex);
		newListIndex --;
		current = current.next;
	}
	this = newList;
}

//Exercise 6 - append two lists
SLL<E> append(SLL<E> l2){
	Node<E> l2Node = l2.head;
	while(l2Node!=null){
		this.add(l2Node.data, size);
		l2Node = l2Node.next;
	}
}

//Exercise 13 -zipL
public SLL<E> zipL(SLL<E> l2){
	if(this.isEmpty())
		return l2;
	if(l2.isEmpty())
		return this;
	SLL<E> newList = new SLL<E>(this.size+l2.size);
	Node<E> l1Node = this.head;
	Node<E> l2Node = l2.head;
	int newListIndex = 0;
	while(l1Node!=null && l2Node!=null){
		if(l1Node.data < l2Node.data)
		{
			newList.add(l1Node.data, newListIndex);
			l1Node = l1Node.next;
		}else{
			newList.add(l2Node.data, newListIndex);
			l2Node = l2Node.next;
		}
		newListIndex++;
	}
	//This will work because we get out of the loop because at least one of them is null
	//If there are remaining elements in one of the list,add them till reaching end of the list
	while(l1Node!=null){
		newList.add(l1Node.data, newListIndex);
		newListIndex++;
		l1Node = l1Node.next;
	}
	while(l2Node!=null){
		newList.add(l2Node.data, newListIndex);
		newListIndex++;
		l2Node = l2Node.next;
	}
	return newList;
}

