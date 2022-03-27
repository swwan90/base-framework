package com.swwan.research.design.pattern.structural.decorator.io;

import java.io.*;

/**
 * @author swwan
 * @date 2022/3/27 - 16:35
 */
public class InputTest {

    public static void main(String[] args) {
        int c;

        try {
            InputStream in = new LowerCastInputStream(new BufferedInputStream(new FileInputStream("D:\\searchspace\\base-framework\\research-design-patterns\\pom.xml")));

            while ((c = in.read()) >= 0) {
                System.out.print((char) c);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
