import java.io.IOException;

import javax.imageio.ImageIO;

import org.springframework.core.io.ClassPathResource;

public class Main {

	public static void main(String[] args) throws IOException {
		System.out.println("TEST");
		ClassPathResource imgPath = new ClassPathResource("image1.jpg");
		System.out.println(ImageIO.read(imgPath.getInputStream()).getType());
	}

}
