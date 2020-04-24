package com.myapps.app;

/**
 * Import java libraries
 */
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Import google zxing libraries
 */
import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

public class App 
{
    public static void main(String[] args)
    {
        try {
			System.out.println("                                                            ");
			System.out.println("  _____   _____      _____                   _              ");
			System.out.println(" (_____) (_____)    (_____)  ____           (_)  ____  _    ");
			System.out.println("(_)   (_)(_)__(_)   (_)__(_)(____) ____   __(_) (____)(_)__ ");
			System.out.println("(_)   (_)(_____)    (_____)(_)_(_)(____) (____)(_)_(_)(____)");
			System.out.println("(_)___(_)( ) ( )    ( ) ( )(__)__( )_( )(_)_(_)(__)__ (_)   ");
			System.out.println(" (___(__)(_)  (_)   (_)  (_)(____)(__)_) (____) (____)(_)   ");
			System.out.println("       (_)                                                  ");
			System.out.println("");
            File file = new File("./image.png"); // this is where the QR code is loaded, the image naming is crucial.
            String actualMessage = parse(file);
            if(actualMessage == null) {
                System.out.println("Error: No QR code");
				System.out.println("");
            } else {
                System.out.println("The message in the QR code is: " + actualMessage);
				System.out.println("");
            }
        } catch (IOException e) {
            System.out.println("Could not decode QR Code, IOException :: " + e.getMessage());
			System.out.println("");
        }
    }
	
    public static String parse(File inputQR) throws IOException {
        BufferedImage buffer = ImageIO.read(inputQR);
        LuminanceSource source = new BufferedImageLuminanceSource(buffer);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
        try {
            Result result = new MultiFormatReader().decode(bitmap);
            return result.getText();
        } catch (NotFoundException e) {
            return null;
        }
    }	
}
