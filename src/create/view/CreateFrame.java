package create.view;

import javax.swing.JFrame;

import create.controller.Controller;

public class CreateFrame extends JFrame
{
	private Controller app;
	private ColorPanel panel;
	
	public CreateFrame(Controller app)
	{
		super();
		this.app = app;
		
		this.panel = new ColorPanel(app);
		setupFrame();
	}
	
	private void setupFrame()
	{
		setSize(1000, 1000);
		setContentPane(panel);
		setTitle("Creativity in Code");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}
