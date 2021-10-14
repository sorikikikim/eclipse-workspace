public class Dictionary extends PairMap{
	private int capacity = 0;
	private int count = 0;
	
	//!!!@Override 공부
	public Dictionary(int capacity) {
		this.capacity = capacity;
		keyArray = new String [capacity];
		valueArray = new String [capacity];
	}
	
	public String get(String key) { //오버라이딩
		int i;
		for (i = 0; i < count; i++) { //현재 있는 원소중에서 찾기
			if (keyArray[i].equals(key)) { //발견
				return valueArray[i];
			}
		}
		return null; //발견하지 못함
	}
	
	public void put(String key, String value) { //추상메소드에 대해 구현
		int i;
		for (i = 0; i < count; i++) { //현재 있는 원소중에서 찾기
			if (keyArray[i].equals(key)) { //발견
				break ;
			}
		}
	
		// 2가지 경우 : 발견, 끝까지 발견 못함
		if (i == count) { //발견 x
			if (count < capacity) {
				keyArray[i] = key;
				valueArray[i] = value;
				count++;
			}
			else { //꽉 찬 경우
			//아무 것도 하지 않는다.
			}
		}
		else { // 발견 o 
			valueArray[i] = value;
		}
	}
	
	public String delete(String key) {
		int i;
		for (i = 0; i < count; i++) { //현재 있는 원소중에서 찾기
			if (keyArray[i].equals(key)) { //발견
				break;
			}
		}
		// 2가지 경우 : 발견, 끝까지 발견 못함
		if (i == count) { //발견 x
			return null;			
		}
		String ret = valueArray[i]; //리턴할 값
		//발견 o , i번째 항목
		for (int j = i; j < count - 1; j++) { //삭제한 값 자리로 한칸씩 당기기
			keyArray[j] = keyArray[j + 1];
			valueArray[j] = valueArray[j + 1];
		}
		return ret;
	}
	
	public int length() {
		return count;
	}
}