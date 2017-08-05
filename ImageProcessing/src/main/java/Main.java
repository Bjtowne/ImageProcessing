import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.springframework.core.io.ClassPathResource;

public class Main
{
	private static final byte MAX_VAL = Byte.MAX_VALUE;

	public static void main(String[] args) throws IOException
	{
		System.out.println("TEST");
		ClassPathResource imgPath = new ClassPathResource("image1.jpg");

		BufferedImage img = ImageIO.read(imgPath.getInputStream());
		byte[] rawImg = ((DataBufferByte) img.getData().getDataBuffer()).getData();
		int[] outputArray = new int[rawImg.length];

		for (int i = 0; i < rawImg.length; i++)
		{
			int temp = rawImg[i] + 50;
			temp = (temp > MAX_VAL) ? MAX_VAL : temp;
			outputArray[i] = (byte) temp;
		}

		File outputFile = new File("output.jpg");
		BufferedImage outputImg = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
		outputImg.getRaster().setPixels(0, 0, img.getWidth(), img.getHeight(), outputArray);

		ImageIO.write(outputImg, "jpg", outputFile);
	}

}
