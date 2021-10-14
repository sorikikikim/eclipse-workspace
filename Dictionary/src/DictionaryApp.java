
abstract class PairMap{
	protected String keyArray[] = null; //배열에 대한 레퍼런스
	protected String valueArray[] = null;
	
	public abstract String get(String key); //key값을 가진 value 리턴, 없으면 null 리턴.
	public abstract void put(String key, String value); //key와 value를 쌍으로 저장. 기존에 key가 있으면 값을 value로 수정.
	public abstract String delete(String key); //key값을 가진 아이템(value와 함께) 삭제. 삭제된 value값 리턴.
	public abstract int length(); //현재 저장된 아이템의 개수 리턴.
}

/*class Dictionary extends PairMap{
	private int len;
	
	public Dictionary(int num) {
		keyArray = new String [num];
		valueArray = new String [num];
		len = 0;
	}
	
	public String get(String key) {
		for (int i = 0; i < keyArray.length; i++) {
			if (key.equals(keyArray[i])) {
				return (valueArray[i]);
			}
		}
		return (null);
	}
	
	public void put(String key, String value) {
		for (int i = 0; i < keyArray.length; i++) {
			if (key.equals(keyArray[i])) {
				keyArray[i] = key;
				valueArray[i] = value;
				return ;
			}
		}
		keyArray[len] = key;
		valueArray[len] = value;
		len++;
	}
	
	public String delete(String key) {
		for (int i = 0; i < keyArray.length; i++) {
			if (key.equals(keyArray[i])) {
				String save = valueArray[i];
				keyArray[i] = null;
				valueArray[i] = null;
				return (save);
			}
		}
		return (null);
	}
	
	public int length() {
		return len;
	}
}
*/
public class DictionaryApp {
	public static void main(String [] args) {
		Dictionary dic = new Dictionary(10);
		
		dic.put("황기태", "자바");
	    dic.put("이재문", "파이썬");
	    dic.put("이재문", "C++"); // 이재문의 값을 C++로 수정
	    System.out.println("이재문의 값은 "+dic.get("이재문"));
	    System.out.println("황기태의 값은 "+dic.get("황기태"));
	    String prev = dic.delete("황기태"); // 황기태 아이템 삭제
	    System.out.println("황기태의 이전 값은 "+ prev); //삭제된 아이템 접근
	    System.out.println("황기태의 값은 "+dic.get("황기태")); //삭제된 아이템 접근
	    
	    System.out.println(dic.length());
	}
}
