// Jasraj Chhina
//03-20-2018


//import required materials
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Anpanman extends JApplet implements Runnable, Actionlistener
{
//Create our global variables
Thread runner;
JButton expand;
JButton contract;
Image [] pics = new Image[11]
int total = 0;
int count = 0;

//Loading our images and creating our array of images
public void init()
{
for(int i = 0; i < 11; i++)
{
String img = null;
img = getParameter("Anpanman-" + i); //Create Anpanman images as a gif file
if(img != null)
{
pics[i] = getImage(getCodeBase(), img);
total++;
}

}

//Setting the background
Container contentArea = getContentPane();
GridLayout grid = new GridLayout(1,2);
contentArea.setLayout(grid);
contentArea.setBackground(Color.white);

//Create our animation
HeadPanel animation = new Headpanel();

//Create our label components
JPanel console = new JPanel();
FlowLayout flow = new FlowLayout();
console.setLayout(flow);
console.setBackground(Color.white);

//Creating the expand button
expand = new JButton("Click to Expand Anpanman's head");
expand.addActionListener(this);

//Creating the retract button
contract = new JButton("Click to bring Anpanman's head back to normal");
stop.addActionListener(this);

//Add the components
console.add(expand);
console.add(retract);
contentArea.add(animation);
contentArea.add(console);
setContentPane(contentArea);
}

public void actionPerformed(ActionEvent event)
{
if(event.getSource() == expand)
  expand();

if(event.getSource() == contract)
  contract();
}

class HeadPanel extends JPanel
{
public void paintComponent(Graphics painter)
{
if(pics[count] != null)
  painter.drawImage(pic[count],0,0,this);
}

}

public void expand()
{
if(runner == null)
{
runner = new Thread(this);
expand();
}
}

public void contract()
{
if(runner != null)
  runner = null;
}

public void run()
{
while(runner == Thread.currentThread())
{
repaint();
count++;
if(count >= total)
  count = 0;
try
{
Thread.sleep(100);
}
catch(InterruptedException e)
{

}

}
}
}
