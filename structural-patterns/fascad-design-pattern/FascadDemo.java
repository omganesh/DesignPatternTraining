interface Media {
	public void play();
	public void pause();
	public void stop();
}


class FileLoader {
	public void load(){
		System.out.println(" Loading file...");
	}
	public void unload(){
		System.out.println(" Unloading file...");
	}
}

class Sound {
	public void on(){
		System.out.println(" Sound is coming ");
	}
	public void off(){
		System.out.println(" Sound is not coming");
	}
}

class Decoder {
	public void decode(){
		System.out.println(" Decoding started");
	}
}


class MediaPlayer{
	FileLoader fl ;
	Sound sound;
	Decoder decod;
	public MediaPlayer(){
		fl = new FileLoader();
		sound= new Sound();
		decod= new Decoder();
	}
	public void play(){
		fl.load();
		decod.decode();
		sound.on();
	}

	public void stop(){
		sound.off();
		fl.unload();
	}
}

public class FascadDemo {
	public static void main(String[] args){
		MediaPlayer mp = new MediaPlayer();

		mp.play();
		mp.stop();
	}
}