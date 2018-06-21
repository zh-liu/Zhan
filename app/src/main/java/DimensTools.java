import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

/**
 * Created by liuzhenghao on 2018/6/6.
 */

public class DimensTools {
    public static void gen() {
        //以此文件夹下的dimens.xml文件内容为初始值参照
        File file = new File("./app/src/main/res/values/dimens.xml");

        BufferedReader reader = null;

        StringBuilder sw480 = new StringBuilder();
        StringBuilder sw600 = new StringBuilder();
        StringBuilder sw720 = new StringBuilder();
        StringBuilder sw1080 = new StringBuilder();

        try {

            System.out.println("生成不同分辨率：");

            reader = new BufferedReader(new FileReader(file));

            String tempString;

            int line = 1;

            // 一次读入一行，直到读入null为文件结束

            while ((tempString = reader.readLine()) != null) {


                if (tempString.contains("</dimen>")) {

                    //tempString = tempString.replaceAll(" ", "");

                    String start = tempString.substring(0, tempString.indexOf(">") + 1);

                    String end = tempString.substring(tempString.lastIndexOf("<") - 2);
                    //截取<dimen></dimen>标签内的内容，从>右括号开始，到左括号减2，取得配置的数字
                    Double num = Double.parseDouble
                            (tempString.substring(tempString.indexOf(">") + 1,
                                    tempString.indexOf("</dimen>") - 2));

                    //根据不同的尺寸，计算新的值，拼接新的字符串，并且结尾处换行。

                    sw480.append(start).append( num * 0.75).append(end).append("\r\n");
                    sw600.append(start).append( num * 0.8).append(end).append("\r\n");
                    sw720.append(start).append(num * 0.9).append(end).append("\r\n");
                    sw1080.append(start).append(num * 1.0).append(end).append("\r\n");



                } else {


                    sw480.append(tempString).append("");


                    sw600.append(tempString).append("");


                    sw720.append(tempString).append("");
                    sw1080.append(tempString).append("");



                }

                line++;

            }

            reader.close();

//
//
//
//







            String sw480file = "./app/src/main/res/values-800x480/dimens.xml";


            String sw600file = "./app/src/main/res/values-800x600/dimens.xml";


            String sw720file = "./app/src/main/res/values-720x1280/dimens.xml";

            String sw1080file = "./app/src/main/res/values-1920x1080/dimens.xml";





            File file480directory = new File("./app/src/main/res","values-800x480");

            if(!file480directory.exists()){
                file480directory.mkdirs();

            }

            File file480 = new File("./app/src/main/res","values-800x480/dimens.xml");

            if(!file480.exists()){
                file480.createNewFile();

            }

            //
            File file600directory = new File("./app/src/main/res","values-800x600");

            if(!file600directory.exists()){
                file600directory.mkdirs();

            }

            File file600 = new File("./app/src/main/res","values-800x600/dimens.xml");

            if(!file600.exists()){
                file600.createNewFile();

            }


            //
            File file1280directory = new File("./app/src/main/res","values-720x1280");

            if(!file1280directory.exists()){
                file1280directory.mkdirs();

            }

            File file1280 = new File("./app/src/main/res","values-720x1280/dimens.xml");

            if(!file1280.exists()){
                file1280.createNewFile();

            }

            //
            File file1080directory = new File("./app/src/main/res","values-1920x1080");

            if(!file1080directory.exists()){
                file1080directory.mkdirs();

            }

            File file1080 = new File("./app/src/main/res","values-1920x1080/dimens.xml");

            if(!file1080.exists()){
                file1080.createNewFile();

            }



            //将新的内容，写入到指定的文件中去

            writeFile(sw480file, sw480.toString());


            writeFile(sw600file, sw600.toString());


            writeFile(sw720file, sw720.toString());

            writeFile(sw1080file, sw1080.toString());

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            if (reader != null) {

                try {

                    reader.close();

                } catch (IOException e1) {

                    e1.printStackTrace();

                }

            }

        }

    }


    /**
     * 写入方法
     *
     */

    public static void writeFile(String file, String text) {

        PrintWriter out = null;

        try {

            out = new PrintWriter(new BufferedWriter(new FileWriter(file)));

            out.println(text);

        } catch (IOException e) {

            e.printStackTrace();

        }




        out.close();

    }
    public static void main(String[] args) {

        gen();

    }
}
