package org.example.juc;

import java.awt.*;
import java.awt.TrayIcon.MessageType;

public class WindowsNotificationExample {
    public static void main(String[] args) {
        if (SystemTray.isSupported()) {
            SystemTray tray = SystemTray.getSystemTray();

            Image icon = Toolkit.getDefaultToolkit().getImage("path/to/icon.png"); // 替换为你的图标路径

            PopupMenu popup = new PopupMenu();
            MenuItem exitItem = new MenuItem("Exit");
            popup.add(exitItem);

            TrayIcon trayIcon = new TrayIcon(icon, "Notification", popup);
            trayIcon.setImageAutoSize(true);

            try {
                tray.add(trayIcon);
            } catch (AWTException e) {
                System.out.println("TrayIcon could not be added.");
                return;
            }

            trayIcon.displayMessage("Title", "Notification message", MessageType.INFO);

            exitItem.addActionListener(e -> {
                tray.remove(trayIcon);
                System.exit(0);
            });
        } else {
            System.out.println("SystemTray is not supported.");
        }
    }
}
