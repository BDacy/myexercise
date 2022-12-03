package review;

import org.junit.Test;

import java.io.*;

/**
 * @BelongsPackage: review
 * @Author: yca
 * @CreateTime: 2022-12-02  22:08
 * @Description:
 */
public class IOTest {
    @Test
    public void test1(){
        try (InputStream fis = new FileInputStream("src/review/data/input.txt")){
            System.out.println("Number of remaining bytes is:" + fis.available());
            int content;
            long skip = fis.skip(2);
            System.out.println("The actual number of bytes skipped:" + skip);
            System.out.print("The content read from file:");
            while ((content = fis.read()) != -1){
                System.out.print((char) content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2(){
        try (BufferedInputStream bfi = new BufferedInputStream(new FileInputStream("src/review/data/input.txt"))){
            String str = new String(bfi.readAllBytes());
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void DataInputStreamTest(){
        try (        FileInputStream fileInputStream = new FileInputStream("input.txt");
                     //必须将fileInputStream作为构造参数才能使用
                     DataInputStream dataInputStream = new DataInputStream(fileInputStream)){
            //可以读取任意具体的类型数据
            dataInputStream.readBoolean();
            dataInputStream.readInt();
            dataInputStream.readUTF();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 对象输出流
//        ObjectInputStream input = new ObjectInputStream(new FileInputStream("object.data"));
//        MyClass object = (MyClass) input.readObject();
//        input.close();
    }

    @Test
    public void FileOutputStreamTest(){
        try (FileOutputStream out = new FileOutputStream("src/review/data/output.txt")){
            byte[] bytes = "JavaGuide".getBytes();
            out.write(bytes);
        }catch (IOException e){
            e.printStackTrace();
        }

        try (BufferedOutputStream out = new BufferedOutputStream(
                new FileOutputStream("src/review/data/output.txt"))){

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    /**
     * 流分类：
     *     1.Java的字节流：InputStream是所有字节输入流的祖先，而OutputStream是所有字节输出流的祖先。
     *     2.Java的字符流：Reader是所有读取字符串输入流的祖先，而writer是所有输出字符串的祖先。
     * 注意：InputStream，OutputStream,Reader,Writer都是抽象类。所以不能直接new。
     *
     * 为啥java要区分字节流和字符流呢？
     * 1. 如果不知道编码类型容易出现乱码的情况，例如字节流读取中文内容
     * 2. 字符流是由 Java 虚拟机将字节转换得到的，这个过程还算是比较耗时。
     * 二者区别？
     * 1. 字节流直接对文件进行操作，而字符流使用了缓冲区，只有当关闭字符流时
     *     才会对缓冲区的内容输出到文件中，而字节流即使没有关闭字节流也会对文件进行写入操作
     *
     */

    @Test
    public void ReaderTest(){
        try (FileReader fileReader = new FileReader("src/review/data/input.txt");) {
            int content;
            long skip = fileReader.skip(3);
            System.out.println("The actual number of bytes skipped:" + skip);
            System.out.print("The content read from file:");
            while ((content = fileReader.read()) != -1) {
                System.out.print((char) content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void WriterTest(){
        try (FileWriter writer = new FileWriter("src/review/data/output.txt",true);
            BufferedWriter bw = new BufferedWriter(writer)){
            bw.write("yca 好帅");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void RandomAccessFileTest(){
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(
                new File("src/review/data/input.txt"),"rw"
        )){
            System.out.println("读取之前的偏移量：" + randomAccessFile.getFilePointer() +
                    " 当前读取的字符：" + (char)randomAccessFile.read() +
                    " 读取之后的偏移量：" + randomAccessFile.getFilePointer());
            randomAccessFile.seek(6);
            System.out.println("读取之前的偏移量：" + randomAccessFile.getFilePointer() +
                    " 当前读取的字符：" + (char)randomAccessFile.read() +
                    " 读取之后的偏移量：" + randomAccessFile.getFilePointer());

            randomAccessFile.write(new byte[]{'H','I','J','k'});
            randomAccessFile.seek(0);
            System.out.println("读取之前的偏移量：" + randomAccessFile.getFilePointer() +
                    " 当前读取的字符：" + (char)randomAccessFile.read() +
                    " 读取之后的偏移量：" + randomAccessFile.getFilePointer());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}