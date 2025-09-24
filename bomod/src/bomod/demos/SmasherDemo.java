package bomod.demos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import bomod.DemoApplet;
import bomod.OSUtils;
import bomod.demos.smasher.Smasher;

/**
 * Java application wrapper around Smasher Applet demo
 * 
 * @author Benjamin Holland <bholland@iastate.edu>
 */
public class SmasherDemo extends JFrame {

	private static final long serialVersionUID = 1L;

	public SmasherDemo(boolean presentationMode) {
		init(presentationMode);
	}

	private void init(boolean presentationMode) {
		Smasher applet = new Smasher();
		
		applet.setParameter(DemoApplet.PLAY_DELAY_PARAM, new Integer(2750));
		applet.setParameter(DemoApplet.STACK_CONTENTS_COLOR_PARAM, Color.BLACK);
		applet.setParameter(DemoApplet.RETURN_POINTER_COLOR_PARAM, Color.BLACK);
		
		if(presentationMode){
			applet.setBackground(Color.WHITE);
			applet.setParameter(DemoApplet.BACKGROUND_COLOR_PARAM, Color.WHITE);
			applet.setParameter(DemoApplet.HINT_TEXT_COLOR_PARAM, Color.BLACK);
			applet.setParameter(DemoApplet.MEMORY_DEFAULT_FORGROUND_COLOR_PARAM, Color.BLACK);
			applet.setParameter(DemoApplet.MEMORY_DEFAULT_BACKGROUND_COLOR_PARAM, Color.WHITE);
			applet.setParameter(DemoApplet.CONSOLE_BACKGROUND_COLOR_PARAM, Color.WHITE);
			applet.setParameter(DemoApplet.CONSOLE_TEXT_COLOR_PARAM, Color.BLACK);
			applet.setParameter(DemoApplet.DEFAULT_CODE_COLOR_PARAM, Color.BLACK);
			applet.setParameter(DemoApplet.CODE_COLOR1_PARAM, Color.GREEN.darker());
			applet.setParameter(DemoApplet.CODE_COLOR2_PARAM, Color.RED.darker());
			applet.setParameter(DemoApplet.CODE_COLOR3_PARAM, new Color(0, 255, 255).darker()); // cyan
		} else {
			applet.setParameter(DemoApplet.BACKGROUND_COLOR_PARAM,new Color(0, 0, 128));
			applet.setParameter(DemoApplet.CODE_COLOR1_PARAM, Color.GREEN);
			applet.setParameter(DemoApplet.CODE_COLOR2_PARAM, Color.RED);
			applet.setParameter(DemoApplet.CODE_COLOR3_PARAM, new Color(255, 0, 255));
		}
		
		// initialize the applet
		applet.init();
		
		// add applet to the application window
		add(applet, BorderLayout.CENTER);
		setTitle("BOMod Smasher Interactive Demo");
		setResizable(false);
		
		if(OSUtils.isWindows()){
			setSize(Smasher.MAXWIDTH + 36, Smasher.MAXHEIGHT + 86);
		} else {
			setSize(Smasher.MAXWIDTH + (Smasher.XADD * 2), Smasher.MAXHEIGHT + 70);
		}

		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				/*Object[] options = { "Classic Color Scheme", "Presentation Mode Color Scheme"};
				int n = JOptionPane.showOptionDialog(new JFrame(), "What color scheme would you like to use? (Suggestion: Presentation Mode)",
						"Color Scheme Settings", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
						options, options[1]);
				*/
				SmasherDemo app;
                /*
				
				if(n==1){
					// presentation mode color scheme

				 */
                app = new SmasherDemo(true);
				/*} else {
					app = new SmasherDemo(false);
				}*/
				
				app.setVisible(true);
			}
		});
	}

}
