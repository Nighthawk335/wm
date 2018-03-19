import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.Timer;

public class WalkingFrame extends JFrame  implements ActionListener
{
	private Man man;
	private Ball ball;
	private ArrayList<Ball> manyBalls;
	public  WalkingFrame()
	{
		setBounds(100,100,600,400);
		setLayout(null);
		man = new Man(0,0);
		manyBalls = new ArrayList<Ball>();
		add(man);
		add(ball);
		Timer timer = new Timer(10, this);
		timer.start();
		addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) 
			{
				if(e.getKeyCode()==e.VK_W)
				{
					man.setDY(-2);
				}
				if(e.getKeyCode()==e.VK_S)
				{
					man.setDY(2);
				}
				if(e.getKeyCode()==e.VK_A)
				{
					man.setDX(-2);
				}
				if(e.getKeyCode()==e.VK_D)
				{
					man.setDX(2);
				}
				if(e.getKeyCode()==e.VK_SPACE)
				{
					manyBalls.add(new Ball(man.getX(), man.getY()));
					add(manyBalls.get(manyBalls.size()-1));
					manyBalls.get(manyBalls.size()-1).setDX(4);
				}
				
				
			}

			@Override
			public void keyReleased(KeyEvent e) 
			{
				 
					if(e.getKeyCode()==e.VK_W)
					{
						man.setDY(0);
					}
					if(e.getKeyCode()==e.VK_S)
					{
						man.setDY(0);
					}
					if(e.getKeyCode()==e.VK_A)
					{
						man.setDX(0);
					}
					if(e.getKeyCode()==e.VK_D)
					{
						man.setDX(0);
					}
				
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public  static void main(String[] args)
	{
		new WalkingFrame();
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		man.update();
		for (int i = manyBalls.size() - 1; i >= 0; i--)
		{
			manyBalls.get(i).update();
		}
		repaint();
		
	}
	
}
