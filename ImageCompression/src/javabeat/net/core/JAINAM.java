package javabeat.net.core;

import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;

import javax.imageio.*;
import javax.imageio.stream.ImageOutputStream;

public class JAINAM 
{

	public static void main(String[] args) throws IOException {
		
		Scanner sc=new Scanner( System.in);
		
		System.out.println(" Enter the path of the image[jpeg format] ");
		String ip=sc.nextLine();
		File imageFile = new File(ip);
		System.out.println(" Enter the path where you want to save the compressed image[jpeg format] ");
		String op=sc.nextLine();
		File compressedImageFile = new File(op);

		InputStream is = new FileInputStream(imageFile);
		OutputStream os = new FileOutputStream(compressedImageFile);

		float quality = 0.5f;

		BufferedImage image = ImageIO.read(is);   // create a BufferedImage as the result of decoding the supplied InputStream
		
		// get all image writers for JPG format
		Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("jpg");

		if (!writers.hasNext())
			throw new IllegalStateException("No writers found");

		ImageWriter writer = (ImageWriter) writers.next();
		ImageOutputStream ios = ImageIO.createImageOutputStream(os);
		writer.setOutput(ios);

		ImageWriteParam param = writer.getDefaultWriteParam();

		// compress to a given quality
		param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
		param.setCompressionQuality(quality);

		// appends a complete image stream containing a single image and
	    //associated stream and image metadata and thumbnails to the output
		writer.write(null, new IIOImage(image, null, null), param);

		// close all streams
		is.close();
		os.close();
		ios.close();
		writer.dispose();

	}

}