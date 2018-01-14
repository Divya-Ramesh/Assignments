import java.util.Arrays;

public class Arraylist1<T> {
	private Object[] array;
	private int count = 0;
	private int size = 10;
	
	public Arraylist1(){
		array = new Object[this.size];
	}
	
	@SuppressWarnings("unchecked")
	public T get(int index) {
		if (index < count) {
			return (T) array[index];
		} else {
			throw new ArrayIndexOutOfBoundsException();
		}
	}
	
	public void add(T obj) {
		if (array.length - count <= array.length / 2) {
			this.reSizeArray();
		}

		array[count++] = obj;
	}
	
	private void reSizeArray(){
		array = Arrays.copyOf(array, array.length * 2);
	}
	
	public T remove(int index){
		if (index < count) {
			@SuppressWarnings("unchecked")
			T obj = (T) array[index];
			int temp = index;
			array[index] = null;

			while (temp < count) {
				array[temp] = array[temp + 1];
				array[temp + 1] = null;
				temp++;
			}

			count--;
			return obj;
		}
		return null;
	}
}
