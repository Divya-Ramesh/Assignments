
public class customLinkedHashMap {

	private Entry[] table;
	private int capacity = 4;
	private Entry header;
	private Entry last;
	
	public customLinkedHashMap() {
		table = new Entry[capacity];
	}
	
	static class Entry{
		int key, value;
		Entry after, before, next;
		
		public Entry(int key, int value, Entry next)
		{
			this.key =  key;
			this.value= value;
			this.next = next;
		}
	}
	
	public void put(int newKey, int value)
	{
		if(newKey <=0)
			return;
		
		int hash = hash(newKey);
		
		Entry newEntry = new Entry(newKey,value,null);
		if(header==null)
		{
			header = newEntry;
			last =  newEntry;
			newEntry.after = null;
			newEntry.before = null;
			
		}
		
		else{
			last.after = newEntry;
			newEntry.before = last;
			newEntry.after = null;
			last = newEntry;
		}
		
		if(table[hash]==null)
		{
			table[hash]= newEntry;
			newEntry.next =  null;
		}
		else{
			Entry temp =  table[hash];
			while(temp.next!=null)
			{
				temp =  temp.next;
			}
			temp.next= newEntry;
			
		}
	}
	
	private int hash(int key){
		return key%capacity;
	}
	
	public void display()
	{
		Entry temp =  header;
		while(temp!=null)
		{
			System.out.println(temp.value);
			temp =  temp.after;
		}
		
		for(int i =0;i<capacity;i++)
		{
			System.out.println("List for hash"+i+"=");
			temp = table[i];
			while(temp!=null)
			{
				System.out.println(temp.value);
				temp =  temp.next;
			}
			
		}
	}
	public int get(int key)
	{
		int hash =  hash(key);
		int value = -1;
		Entry temp = table[hash];
		while(temp!=null)
		{
			if(temp.key==key)
			{
				value = temp.value;
				break;
			}
			temp =  temp.next;
		}
		return value;
	}
	
	public int delete(int key)
	{
		int hash =  hash(key);
		int value = -1;
		Entry temp = table[hash];
		Entry prev = null;
		while(temp!=null)
		{
			if(temp.key==key)
			{
				if(temp==header)
				{
					header = temp.after;
				}
				if(temp.before!=null){
					temp.before.after =  temp.after;
				}
				if(temp.after!=null){
					temp.after.before =  temp.before;
				}
				if(prev==null)
				{
					table[hash]=temp.next;
				}
				else{
					prev.next = temp.next;
				}
				value =  temp.value; 
				break;
			}
			prev =  temp;
			temp = temp.next;
		}
		return value;
	}
	public static void main(String args[]){
		customLinkedHashMap ob = new customLinkedHashMap();
		ob.put(21,12);
		ob.put(20, 14);
		ob.put(17,20);
		ob.put(23,45);
		ob.display();
		int value =  ob.get(21);
		if(value==-1)
			System.out.println("Key not found");
		else
			System.out.println("The value for the key is = "+value);
		value =  ob.delete(21);
		if(value==-1)
			System.out.println("Key not found");
		else
			System.out.println("The  value for the deleted key is = "+value);
		ob.display();
		value =  ob.delete(99);
		if(value==-1)
			System.out.println("Key not found");
		else
			System.out.println("The  value for the deleted key is = "+value);
		ob.display();
		
	}
	
}
