import java.awt.*;
import java.io.*;
import java.util.Comparator;

class MyPointCmp implements Comparator<Point>, Serializable {
    public int compare(Point p1, Point p2) {
        return 1;
    }
}

class Zigwig{}
class QQ{int a;}
class MyPoint implements Serializable {
    public MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void setComp(Comparator<MyPoint> cmp){
        this.cmp = cmp;
    }
    private transient int x,y;
    private transient Comparator<MyPoint> cmp;



    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    private void writeObject(ObjectOutputStream out)
            throws IOException{
        out.defaultWriteObject();
        out.writeInt(x);
        out.writeInt(y);
        out.writeObject(cmp);

        System.out.println("writeObject");

    }
    private void readObject(ObjectInputStream in)
            throws IOException, ClassNotFoundException{
        in.defaultReadObject();
        x = in.readInt();
        y = in.readInt();
        cmp = (Comparator<MyPoint>)in.readObject();

        System.out.println("readObject");

    }
}

public class Files {
    public static void main(String[] args)  {

//        try (FileWriter writer = new FileWriter("test.txt")) {
//            writer.write("Hello World");
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//
//        try( BufferedReader br = new BufferedReader(new FileReader("test.txt"))) {
//            while (br.ready()) {
//                System.out.print(br.readLine());
//            }
//        }
//        catch (IOException e) {
//        }

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
