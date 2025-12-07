package java_exercises;

class DownloadTask extends Thread {
	String fileType;

	DownloadTask(String type) {
		this.fileType = type;
	}

	public void run() {
		try {
			System.out.println("Downloading " + fileType + "...");
			Thread.sleep(2000);
			System.out.println(fileType + "download complete!");
		} catch (Exception e) {
			System.out.println("Error downloading " + fileType);
		}
	}
}

public class MultiThreadedDownloaderApp {

	public static void main(String[] args) {
		DownloadTask pdf = new DownloadTask("PDF File");
		DownloadTask image = new DownloadTask("Image File");
		DownloadTask video = new DownloadTask("Video File");
		
		pdf.start();
		image.start();
		video.start();
		
		System.out.println("All downloads started");
	}

}
