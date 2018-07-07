package genetic;

import java.awt.Component;

import javax.swing.JOptionPane;

public class Utils {
	public static int getSolicitaInt(String msg) {
		return Integer.valueOf(JOptionPane.showInputDialog(msg));
	}

	public static double getSolicitaDouble(String msg) {
		return Double.valueOf(JOptionPane.showInputDialog(msg));
	}

	public static String getSolicitaString(String msg) {
		return JOptionPane.showInputDialog(msg);
	}

	public static void exibiMsg(Component parentComponent, String msg) {
		JOptionPane.showMessageDialog(parentComponent, msg);
	}
}