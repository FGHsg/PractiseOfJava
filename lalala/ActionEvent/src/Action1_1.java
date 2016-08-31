/*    范例名称：Java事件处理举例
 *     源文件名称：TestActionEvent.java
 *    要  点：
 *      1. Java事件处理机制
 *        2. 事件源、事件监听器概念及作用
 *        3. 如何在一个现有组件上注册监听器
 */

import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;

public class Action1_1 {
    public static void main(String args[]) {
            Frame f = new Frame("Test");
            Button b = new Button("Press Me!");
            Monitor bh = new Monitor();
            b.addActionListener(bh);
            f.add(b,BorderLayout.CENTER);
            f.setSize(200, 100);
            f.setLocation(320, 120);
            f.pack();
            f.setVisible(true);
    }
}

class Monitor implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        System.out.println("a button has been pressed");    
    }
}