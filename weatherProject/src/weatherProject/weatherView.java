package weatherProject;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class weatherView extends JFrame implements ActionListener
{
	//GENERAL OBJECTS
	private JPanel mainPanel = new JPanel();
	Color backgroundColor= new Color(255,255,255);

	//OBJECTS FOR MAIN Panel
	private JPanel topPanel = new JPanel();
	private JPanel midPanel = new JPanel(new BorderLayout());	
	private JPanel bottomPanel = new JPanel();


	//OBJECTS FOR TOP PANEL
	private ImageIcon topIcon = new ImageIcon("img/top.jpg");
	private JLabel topImage = new JLabel();

	//OBJECTS FOR MIDDLE PANEL
	private JPanel midUpperPanel = new JPanel(new GridBagLayout());
	private JPanel midLowerPanel = new JPanel(new BorderLayout());

	// OBJECTS FOR MIDDLE UPPER PANEL
	JTextField countryText = new JTextField(20);
	JTextField cityText = new JTextField(20);
	private JRadioButton celsiusRadio = new JRadioButton("C");
	private JRadioButton kelvinRadio = new JRadioButton("K");
	private JRadioButton fahrenneitRadio = new JRadioButton("F");
	//	private JLabel titleLabel = new JLabel("Minions Weather Project");
	private JButton goButton = new JButton("Go!");
	private JLabel locationLabel =new JLabel("Location:");
	private JLabel counteryLabel =new JLabel("countery");
	private JLabel cityLabel = new JLabel("city:");
	private JLabel viewLabel = new JLabel ("view type");
	ButtonGroup bGroup = new ButtonGroup();

	// OBJECTS FOR MIDDLE LOWER
	JTextArea resoultText = new JTextArea(17,30);	
	private ImageIcon weatherIcon ;
	private JLabel weatherImage =new JLabel();
	Font myFont = new Font("Serif", Font.BOLD, 15);

	//OBJECTS FOR BOTTOM PANEL
	private ImageIcon bottomIcon = new ImageIcon("img/bottom.jpg");	
	private JLabel bottomImage = new JLabel();



	public weatherView() {

		//GENERAL SETTINGS
		this.setSize(600, 800);
		this.add(mainPanel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		this.setTitle("Minions Weather Project : Rafi & Orly 2015");
		GridBagConstraints gridTable = new GridBagConstraints();

		//MAIN PANEL SETTINGS 
		mainPanel.add(topPanel);
		mainPanel.add(midPanel);
		mainPanel.add(bottomPanel);
		mainPanel.setBackground(backgroundColor);

		//TOP PANEL SETTINGS
		topPanel.add(topImage);
		topImage.setIcon(topIcon);
		topPanel.setBackground(backgroundColor);

		// MIDDLE PANEL SETTINGS
		midPanel.add(midUpperPanel, BorderLayout.PAGE_START);
		midPanel.add(midLowerPanel, BorderLayout.PAGE_END);
		midPanel.setBackground(backgroundColor);
		midPanel.setPreferredSize(new Dimension(590,450)); 

		//MIDDLE UPPER PANEL SETTINGS
		gridTable.anchor = GridBagConstraints.NORTHWEST;

		gridTable.fill = GridBagConstraints.HORIZONTAL;
		gridTable.gridx = 0;
		gridTable.gridy = 0;
		midUpperPanel.add(locationLabel,gridTable);

		gridTable.fill = GridBagConstraints.HORIZONTAL;
		gridTable.gridx = 0;
		gridTable.gridy = 1;
		midUpperPanel.add(counteryLabel,gridTable);

		gridTable.fill = GridBagConstraints.HORIZONTAL;
		gridTable.gridx = 0;
		gridTable.gridy = 2;
		midUpperPanel.add(cityLabel,gridTable);

		gridTable.fill = GridBagConstraints.HORIZONTAL;
		gridTable.gridx = 0;
		gridTable.gridy = 3;
		midUpperPanel.add(viewLabel,gridTable);

		gridTable.fill = GridBagConstraints.HORIZONTAL;
		gridTable.gridwidth=3;
		gridTable.gridx = 1;
		gridTable.gridy = 1;
		midUpperPanel.add(countryText,gridTable);

		gridTable.gridwidth=3;
		gridTable.gridx = 1;
		gridTable.gridy = 2;
		midUpperPanel.add(cityText,gridTable); 

		gridTable.gridwidth=1;
		gridTable.gridx = 4;
		gridTable.gridy = 3;
		midUpperPanel.add(goButton,gridTable); 

		celsiusRadio.setBackground(backgroundColor);
		celsiusRadio.setSelected(true);
		gridTable.gridwidth=1;
		gridTable.gridx=1;
		gridTable.gridy=3; 
		midUpperPanel.add(celsiusRadio, gridTable);
		celsiusRadio.setActionCommand("C");

		fahrenneitRadio.setBackground(backgroundColor);
		gridTable.gridwidth=1;
		gridTable.gridx=2;
		gridTable.gridy=3; 
		midUpperPanel.add(fahrenneitRadio, gridTable);
		fahrenneitRadio.setActionCommand("F");

		kelvinRadio.setBackground(backgroundColor);
		gridTable.gridwidth=1;
		gridTable.gridx=3;
		gridTable.gridy=3; 
		midUpperPanel.add(kelvinRadio, gridTable);
		kelvinRadio.setActionCommand("K");

		midUpperPanel.setBackground(backgroundColor);
		bGroup.add(celsiusRadio);
		bGroup.add(fahrenneitRadio);
		bGroup.add(kelvinRadio);


		//MIDDLE LOWER PANEL SETTINGS
		midLowerPanel.setBackground(backgroundColor);
		midLowerPanel.add(weatherImage, BorderLayout.EAST);
		midLowerPanel.add(resoultText,BorderLayout.CENTER);
		resoultText.setEditable(false);
		resoultText.setFont(myFont);
		midLowerPanel.setBorder(BorderFactory.createLineBorder(Color.gray,1));


		//BOTTON PANEL SETTINGS
		bottomImage.setIcon(bottomIcon);
		bottomPanel.add(bottomImage);
		bottomPanel.setBackground(backgroundColor);

	}


	@Override
	public void actionPerformed(ActionEvent arg0) {

	}


	void addListener(ActionListener buttonListener){
		goButton.addActionListener(buttonListener);

	}


	void setWeatherIcon(int picture){
		if(picture == 1)
			weatherIcon = new ImageIcon(new ImageIcon("img/snow.jpg").getImage().getScaledInstance(100, 150, BufferedImage.SCALE_DEFAULT));
		else if(picture == 2)
			weatherIcon = new ImageIcon(new ImageIcon("img/winter.jpg").getImage().getScaledInstance(100, 150, BufferedImage.SCALE_DEFAULT));
		else if(picture == 3)
			weatherIcon = new ImageIcon(new ImageIcon("img/sun.png").getImage().getScaledInstance(100, 150, BufferedImage.SCALE_DEFAULT));
		else weatherIcon = null;		
		weatherImage.setIcon(weatherIcon);
	}
}
