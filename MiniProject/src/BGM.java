import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

class BGM extends Thread {
	private Player player; //JLabel 음악 재생 객체
	private boolean isLoop; //음악 무한 반복 재생
	
	private File file = null; //음악 파일을 담기위한 객체
	private FileInputStream fis; 
	private BufferedInputStream bis;
	
	public BGM(String name, boolean isLoop) {
		try {
			this.isLoop = isLoop;
			file = new File(name);
			fis = new FileInputStream(file); //음악 파일을 FileInputStream에 저장
			bis = new BufferedInputStream(fis); //음악 파일을 BufferInputStream에 저장할 때 사용
			player = new Player(bis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//음악 정지
	public void close() {
		isLoop = false;
		player.close();
		this.interrupt();
	}
	
	//음악 재생
	public void run() {
		try {
			do { //isLoop가 true인 동안
				player.play();
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				player = new Player(bis);
			} while (isLoop);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}