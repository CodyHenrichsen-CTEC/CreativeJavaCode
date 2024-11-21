package create.view;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SpringLayout;
import javax.swing.JTextField;

import java.awt.GridLayout;
import java.awt.Color;

import create.controller.Controller;

public class ColorPanel extends JPanel
{
	private Controller app;
	private JButton changeColorButton;
	private JButton setColorButton;
	private JLabel colorInfoLabel;
	
	private JTextField redField;
	private JTextField greenField;
	private JTextField blueField;
	
	private JPanel gridPanel;
	private SpringLayout layout;
	
	private int redAmount;
	private int greenAmount;
	private int blueAmount;
	
	private String colorLabelText;
	
	public ColorPanel(Controller app)
	{
		super();
		this.app = app;
		
		this.colorLabelText = "The current color is: CYAN";
		
		this.gridPanel = new JPanel(new GridLayout(0,1));
		this.changeColorButton = new JButton("Click to change");
		this.setColorButton = new JButton("Click to set color");
		this.colorInfoLabel = new JLabel(colorLabelText);
		
		this.redField = new JTextField("0");
		this.greenField = new JTextField("0");
		this.blueField = new JTextField("0");
		
		this.layout = new SpringLayout();
		
		setupPanel();
		setupListeners();
		setupLayout();
	}
	
	private void setupPanel()
	{
		setBackground(Color.CYAN);
		setLayout(layout);
		add(gridPanel);
		
		gridPanel.add(changeColorButton);
		gridPanel.add(colorInfoLabel);
		gridPanel.add(setColorButton);
		gridPanel.add(redField);
		gridPanel.add(greenField);
		gridPanel.add(blueField);
		
	}
	
	private void setupListeners()
	{
		changeColorButton.addActionListener(click -> updateBackground());
		setColorButton.addActionListener(click -> setBackgroundColor());
	}
	
	private void setupLayout()
	{
		layout.putConstraint(SpringLayout.NORTH, gridPanel, 50, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.EAST, gridPanel, -250, SpringLayout.EAST, this);
		layout.putConstraint(SpringLayout.SOUTH, gridPanel, -650, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.WEST, gridPanel, 250, SpringLayout.WEST, this);
	}
	
	private void setBackgroundColor()
	{
		try
		{
			redAmount = Integer.parseInt(redField.getText());
		}
		catch (NumberFormatException error)
		{
			redAmount = (int) (Math.random() * 256);
		}
		try
		{
			greenAmount = Integer.parseInt(greenField.getText());
		}
		catch (NumberFormatException error)
		{
			greenAmount = (int) (Math.random() * 1123124) % 256;
			
		}
		try
		{
			blueAmount = Integer.parseInt(blueField.getText());
		}
		catch (NumberFormatException error)
		{
			blueAmount = (int) (Math.random() * 256);
			
		}

		updateFields();
		
		setBackground(new Color(redAmount, greenAmount, blueAmount));
	}
	
	private void updateFields()
	{
		redField.setText(redAmount + "");
		greenField.setText(greenAmount + "");
		blueField.setText(blueAmount + "");
		
		colorLabelText = "The current color has Red: " + redAmount + " Green: " + greenAmount + " Blue: " + blueAmount;
		colorInfoLabel.setText(colorLabelText);
	}
	
	private void updateBackground()
	{
		Color current = generateRandomColor();
		setBackground(current);
		
		redAmount = current.getRed();
		blueAmount = current.getBlue();
		greenAmount = current.getGreen();
		
		updateFields();
	}
	
	private Color generateRandomColor()
	{
		redAmount = (int) (Math.random() * 256);
		greenAmount = (int) (Math.random() * 123456) % 256;
		blueAmount = (int) (Math.random() * 256);
		
		Color randomColor = new Color(redAmount, greenAmount, blueAmount);
		
		return randomColor;
	}

}
