import java.io.FileWriter;
import java.io.IOException;

public class Player {
	private String id;
	private int level;
	private int score;
	
	public Player() {
	}
	
	public Player(String id, int level, int score) {
		this.id  = id;
		this.level = level;
		this.score = score;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public String getId() {
		return id;
	}
	
	public int getLevel() {
		return level;
	}
	
	public int getScore() {
		return score;
	}
	
	//player가 입력한 정보와 점수를 player.txt에 저장
	public void backupPlayer() {
		String fileName = "player.txt";
		try {
			FileWriter fileWriter = new FileWriter(fileName, true);
			String data = id + " level" + level + " " + score + "점\n";
			fileWriter.write(data);
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
 }
