package 자바강의2023.week13;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStreamDemo {

	public static void main(String[] args) {
		try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("C:\\Temp\\data.dat"));
			 DataInputStream dis = new DataInputStream(new FileInputStream("C:\\Temp\\data.dat"))){
			
			dos.writeDouble(1.0);
			dos.writeInt(1);
			dos.writeUTF("one");
			
			dos.flush(); // dos에 write 시켜준다. 없으면 안 시켜줌
			
			System.out.println(dis.readDouble());
			System.out.println(dis.readInt());
			System.out.println(dis.readUTF());
			
		} catch (IOException e) {
			// TODO: handle exception
		}

	}

}
