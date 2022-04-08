package com.swwan.research.design.pattern.behavioral.templatemethod.frame;

import javax.swing.*;
import java.awt.*;

/**
 * @author swwan
 * @date 2022/4/8 - 22:55
 */
public class MyFrame extends JFrame {

    private static final long serialVersionUID = 165327880231073137L;

    public MyFrame(String title) throws HeadlessException {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setSize(300, 300);
        this.setVisible(true);
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        String msg = "I rule!";
        graphics.drawString(msg, 100, 100);
    }

    public static void main(String[] args) {
        MyFrame myFrame = new MyFrame("Head First Design Patterns");
    }
}
