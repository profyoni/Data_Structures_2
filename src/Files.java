import java.io.*;

class MyPoint implements Serializable {
    public MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
    final private int x,y;

    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

public class Files {
    public static void main(String[] args)  {

        try (FileWriter writer = new FileWriter("test.txt")) {
            writer.write("Hello World");
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        try( BufferedReader br = new BufferedReader(new FileReader("test.txt"))) {
            while (br.ready()) {
                System.out.print(br.readLine());
            }
        }
        catch (IOException e) {
        }

        MyPoint myPoint = new MyPoint(4,5);
        try (FileOutputStream fos = new FileOutputStream("point.obj");
             BufferedOutputStream bos = new BufferedOutputStream(fos);
             ObjectOutputStream oos = new ObjectOutputStream(bos)) {

            oos.writeObject(myPoint);  // Serializes entire object graph

        } catch (IOException e) {
            e.printStackTrace();
        }


        try (FileInputStream fis = new FileInputStream("point.obj");
             BufferedInputStream bis = new BufferedInputStream(fis);
             ObjectInputStream ois = new ObjectInputStream(bis)) {

            MyPoint p = (MyPoint) ois.readObject();  // Must cast to correct type
            System.out.println(p);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
