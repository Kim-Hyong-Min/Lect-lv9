package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Panel extends Util {
	private Random rn = new Random();

	private JButton reset = new JButton();
	private JButton newGame = new JButton();
	private JButton[] levelBtn = new JButton[4];
	private JLabel text = new JLabel();
	private JLabel timer = new JLabel();

	private final int TILE = 1;
	private final int STONE = 2;
	private final int USER = 3;
	private final int BOX = 4;
	private final int GOAL = 5;
	private final int BOXIN = 6;

	public Item[][] gameMap;
	public Item[] imageList = new Item[6];
	private int Px;
	private int Py;

	private boolean start;
	private int ms;
	private int level = 0;
	private boolean win;

	public Panel() {
		setLayout(null);
		setBounds(0, 0, 1000, 1000);

		setResetButton();
		setNewGameButton();
		setLevelBtn();
		setTimer();
		setText();
		addKeyListener(this);
	}

	private void setLevelBtn() {
		int x = 230;
		int y = 850;

		for (int i = 0; i < this.levelBtn.length; i++) {
			this.levelBtn[i] = new JButton();
			this.levelBtn[i].setText(String.format("LEVEL %d", i + 1));
			this.levelBtn[i].setBounds(x, y, 100, 30);
			this.levelBtn[i].addActionListener(this);
			add(this.levelBtn[i]);
			x += 150;
		}
	}

	private void setNewGameButton() {
		this.newGame.setText("New Game");
		this.newGame.setBounds(800, 40, 120, 30);
		this.newGame.addActionListener(this);
		add(this.newGame);
	}

	private void setText() {
		this.text.setText("[조작법] 이동 : 상(↑) 하(↓) 좌(←) 우(→)");
		this.text.setBounds(230, 900, 800, 60);
		this.text.setFont(new Font("", Font.BOLD, 30));
		add(this.text);
	}

	private void setTimer() {
		this.timer.setText("READY");
		this.timer.setBounds(450, 20, 100, 30);
		this.timer.setFont(new Font("", Font.BOLD, 20));
		add(this.timer);
	}

	private void setResetButton() {
		this.reset.setText("Reset");
		this.reset.setBounds(80, 40, 80, 30);
		this.reset.addActionListener(this);
		add(this.reset);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawRect(100, 100, 800, 800);
		if (this.level == 0) {
			setLevel1();// <<<< 시작 레벨 조정 (1~4)
			this.level = 1;//<< 시작 레벨 조정 (1~4)
		}
		int check = -1;

		for (int i = 0; i < gameMap.length; i++) {
			for (int j = 0; j < gameMap[i].length; j++) {
				if (gameMap[i][j].getState() == TILE && gameMap[i][j].isGoal()) {
					gameMap[i][j].setState(GOAL);
					gameMap[i][j].setImage(imageList[GOAL - 1].getImage());
				}

				if (gameMap[i][j].isGoal() && gameMap[i][j].getState() != BOXIN) {
					check++;
				}
				g.drawImage(gameMap[i][j].getImage().getImage(), gameMap[i][j].getX(), gameMap[i][j].getY(), null);
			}
		}

		if (check == -1) {
			this.start = false;
			g.setFont(new Font("", Font.BOLD, 50));
			g.setColor(Color.red);
			g.drawString("Level Clear! Press Enter", 200, 100);
			this.win = true;
		}

		requestFocusInWindow();
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == e.VK_UP) {
			moving(0, -1);
		} else if (e.getKeyCode() == e.VK_DOWN) {
			moving(0, 1);
		} else if (e.getKeyCode() == e.VK_LEFT) {
			moving(-1, 0);
		} else if (e.getKeyCode() == e.VK_RIGHT) {
			moving(1, 0);
		} else if (e.getKeyCode() == e.VK_ENTER) {
			if (this.win) {
				while (true) {
					int rNum = rn.nextInt(4) + 1;

					if (rNum != this.level) {
						if (rNum == 1) {
							setLevel1();
							this.level = 1;
						}
						if (rNum == 2) {
							setLevel2();
							this.level = 2;
						}
						if (rNum == 3) {
							setLevel3();
							this.level = 3;
						}
						if (rNum == 4) {
							setLevel4();
							this.level = 4;
						}
						break;
					}
				}
				this.ms = 0;
				this.start = false;
				this.win = false;
				this.timer.setText("READY");
			}
		}
	}

	private void moving(int x, int y) {
		this.start = true;
		boolean check = false;

		if (x == 1 && y == 0) {// 오른쪽
			if (Px < gameMap[0].length && gameMap[Py + y][Px + x].getState() != STONE) {
				check = true;
			}
		} else if (x == -1 && y == 0) { // 왼쪽
			if (Px >= 0 && gameMap[Py + y][Px + x].getState() != STONE) {
				check = true;
			}
		} else if (x == 0 && y == -1) { // 위
			if (Py >= 0 && gameMap[Py + y][Px + x].getState() != STONE) {
				check = true;
			}
		} else if (x == 0 && y == 1) { // 아래
			if (Py < gameMap.length && gameMap[Py + y][Px + x].getState() != STONE) {
				check = true;
			}
		}

		if (check) {
			for (int i = 0; i < gameMap.length; i++) {
				for (int j = 0; j < gameMap[i].length; j++) {
				}
			}

			if (gameMap[Py + y][Px + x].getState() == TILE) {
				gameMap[Py][Px].setState(TILE);
				gameMap[Py + y][Px + x].setState(USER);
				gameMap[Py][Px].setImage(imageList[TILE - 1].getImage());
				gameMap[Py + y][Px + x].setImage(imageList[USER - 1].getImage());
				Px += x;
				Py += y;
			} else if (gameMap[Py + y][Px + x].getState() == BOX) {
				if (gameMap[Py + y + y][Px + x + x].getState() == TILE) {
					gameMap[Py][Px].setState(TILE);
					gameMap[Py + y][Px + x].setState(USER);
					gameMap[Py + y + y][Px + x + x].setState(BOX);
					gameMap[Py][Px].setImage(imageList[TILE - 1].getImage());
					gameMap[Py + y][Px + x].setImage(imageList[USER - 1].getImage());
					gameMap[Py + y + y][Px + x + x].setImage(imageList[BOX - 1].getImage());
					Px += x;
					Py += y;
				} else if (gameMap[Py + y + y][Px + x + x].getState() == GOAL) {
					gameMap[Py][Px].setState(TILE);
					gameMap[Py + y][Px + x].setState(USER);
					gameMap[Py + y + y][Px + x + x].setState(BOXIN);
					gameMap[Py][Px].setImage(imageList[TILE - 1].getImage());
					gameMap[Py + y][Px + x].setImage(imageList[USER - 1].getImage());
					gameMap[Py + y + y][Px + x + x].setImage(imageList[BOXIN - 1].getImage());
					Px += x;
					Py += y;
				}
			} else if (gameMap[Py + y][Px + x].getState() == BOXIN) {
				if (gameMap[Py + y + y][Px + x + x].getState() == TILE) {
					gameMap[Py][Px].setState(TILE);
					gameMap[Py + y][Px + x].setState(USER);
					gameMap[Py + y + y][Px + x + x].setState(BOX);
					gameMap[Py][Px].setImage(imageList[TILE - 1].getImage());
					gameMap[Py + y][Px + x].setImage(imageList[USER - 1].getImage());
					gameMap[Py + y + y][Px + x + x].setImage(imageList[BOX - 1].getImage());
					Px += x;
					Py += y;
				} else if (gameMap[Py + y + y][Px + x + x].getState() == GOAL) {
					gameMap[Py][Px].setState(TILE);
					gameMap[Py + y][Px + x].setState(USER);
					gameMap[Py + y + y][Px + x + x].setState(BOXIN);
					gameMap[Py][Px].setImage(imageList[TILE - 1].getImage());
					gameMap[Py + y][Px + x].setImage(imageList[USER - 1].getImage());
					gameMap[Py + y + y][Px + x + x].setImage(imageList[BOXIN - 1].getImage());
					Px += x;
					Py += y;
				}
			} else if (gameMap[Py + y][Px + x].getState() == GOAL) {
				gameMap[Py][Px].setState(TILE);
				gameMap[Py + y][Px + x].setState(USER);
				gameMap[Py][Px].setImage(imageList[TILE - 1].getImage());
				gameMap[Py + y][Px + x].setImage(imageList[USER - 1].getImage());
				Px += x;
				Py += y;
			}
		}
	}

	private void setLevel1() {
		int size = 80;
		int[][]mapState = {{1,1,2,2,2,2,2,1},
						   {2,2,2,1,1,1,2,1},
						   {2,5,3,4,1,1,2,1},
					   	   {2,2,2,1,4,5,2,1},
						   {1,5,2,2,4,1,2,1},
						   {2,1,2,1,5,1,2,2},
						   {2,4,1,6,4,4,5,2},
						   {2,1,1,1,5,1,1,2},
						   {2,2,2,2,2,2,2,2}};

		for (int i = 0; i < this.imageList.length; i++) {
			Image im = new ImageIcon(String.format("image/tile%d.png", i + 1)).getImage().getScaledInstance(size, size,
					Image.SCALE_SMOOTH);
			ImageIcon image = new ImageIcon(im);
			this.imageList[i] = new Item(0, 0, i + 1, image);
		}

		this.gameMap = new Item[9][8]; // 35*9 = 315 / 35*8 = 280
		int x = 180;
		int y = 120;

		for (int i = 0; i < this.gameMap.length; i++) {
			for (int j = 0; j < this.gameMap[i].length; j++) {
				Image im = new ImageIcon(String.format("image/tile%d.png", mapState[i][j])).getImage()
						.getScaledInstance(size, size, Image.SCALE_SMOOTH);
				ImageIcon image = new ImageIcon(im);
				this.gameMap[i][j] = new Item(x, y, mapState[i][j], image);// int x, int y, int state, ImageIcon image
				if (this.gameMap[i][j].getState() == GOAL || this.gameMap[i][j].getState() == BOXIN) {
					this.gameMap[i][j].setGoal(true);
				}
				if (this.gameMap[i][j].getState() == USER) {
					this.Px = j;
					this.Py = i;
				}
				x += size;
			}
			x = 180;
			y += size;
		}
	}

	private void setLevel2() {
		int size = 35;
		int[][]mapState = {{1,1,1,1,2,2,2,2,2,1,1,1,1,1,1,1,1,1,1,1,1,1},
						   {1,1,1,1,2,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1},
						   {1,1,1,1,2,4,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1},
					   	   {1,1,2,2,2,1,1,4,2,2,2,1,1,1,1,1,1,1,1,1,1,1},
						   {1,1,2,1,1,4,1,1,4,1,2,1,1,1,1,1,1,1,1,1,1,1},
						   {2,2,2,1,2,1,2,2,2,1,2,1,1,1,1,1,2,2,2,2,2,2},
						   {2,1,1,1,2,1,2,2,2,1,2,2,2,2,2,2,2,1,1,5,5,2},
						   {2,1,4,1,1,4,1,1,1,1,1,1,1,1,1,1,1,1,1,5,5,2},
						   {2,2,2,2,2,1,2,2,2,2,1,2,3,2,2,2,2,1,1,5,5,2},
						   {1,1,1,1,2,1,1,1,1,1,1,2,2,2,1,1,2,2,2,2,2,2},
						   {1,1,1,1,2,2,2,2,2,2,2,2,1,1,1,1,1,1,1,1,1,1}};

		for (int i = 0; i < this.imageList.length; i++) {
			Image im = new ImageIcon(String.format("image/tile%d.png", i + 1)).getImage().getScaledInstance(size, size,
					Image.SCALE_SMOOTH);
			ImageIcon image = new ImageIcon(im);
			this.imageList[i] = new Item(0, 0, i + 1, image);
		}

		this.gameMap = new Item[11][22];
		int x = 120;
		int y = 330;

		for (int i = 0; i < this.gameMap.length; i++) {
			for (int j = 0; j < this.gameMap[i].length; j++) {
				Image im = new ImageIcon(String.format("image/tile%d.png", mapState[i][j])).getImage()
						.getScaledInstance(size, size, Image.SCALE_SMOOTH);
				ImageIcon image = new ImageIcon(im);
				this.gameMap[i][j] = new Item(x, y, mapState[i][j], image);// int x, int y, int state, ImageIcon image
				if (this.gameMap[i][j].getState() == GOAL || this.gameMap[i][j].getState() == BOXIN) {
					this.gameMap[i][j].setGoal(true);
				}
				if (this.gameMap[i][j].getState() == USER) {
					this.Px = j;
					this.Py = i;
				}
				x += size;
			}
			x = 120;
			y += size;
		}

	}

	private void setLevel3() {
		int size = 55;
		int[][]mapState = {{2,2,2,2,2,2,2,2,2,2,2,2,1,1},
						   {2,5,1,1,1,2,1,1,1,1,1,2,2,2},
						   {2,5,1,1,1,2,1,1,1,1,1,1,1,2},
					   	   {2,5,1,1,1,2,4,2,2,2,2,1,1,2},
						   {2,5,1,1,1,1,1,1,3,2,2,1,1,2},
						   {2,5,1,1,1,2,1,2,1,1,4,1,2,2},
						   {2,2,2,2,2,2,1,2,2,4,1,4,1,2},
						   {1,1,2,1,4,1,1,1,1,1,1,1,1,2},
						   {1,1,2,1,1,1,1,2,1,1,1,1,1,2},
						   {1,1,2,2,2,2,2,2,2,2,2,2,2,2}};

		for (int i = 0; i < this.imageList.length; i++) {
			Image im = new ImageIcon(String.format("image/tile%d.png", i + 1)).getImage().getScaledInstance(size, size,
					Image.SCALE_SMOOTH);
			ImageIcon image = new ImageIcon(im);
			this.imageList[i] = new Item(0, 0, i + 1, image);
		}

		this.gameMap = new Item[10][14];
		int x = 117;
		int y = 250;

		for (int i = 0; i < this.gameMap.length; i++) {
			for (int j = 0; j < this.gameMap[i].length; j++) {
				Image im = new ImageIcon(String.format("image/tile%d.png", mapState[i][j])).getImage()
						.getScaledInstance(size, size, Image.SCALE_SMOOTH);
				ImageIcon image = new ImageIcon(im);
				this.gameMap[i][j] = new Item(x, y, mapState[i][j], image);// int x, int y, int state, ImageIcon image
				if (this.gameMap[i][j].getState() == GOAL || this.gameMap[i][j].getState() == BOXIN) {
					this.gameMap[i][j].setGoal(true);
				}
				if (this.gameMap[i][j].getState() == USER) {
					this.Px = j;
					this.Py = i;
				}
				x += size;
			}
			x = 117;
			y += size;
		}
	}

	private void setLevel4() {
		int size = 45;
		int[][]mapState = {{1,1,1,1,1,1,1,1,2,2,2,2,2,2,2,2,1},
						   {1,1,1,1,1,1,1,1,2,1,1,1,1,1,3,2,1},
						   {1,1,1,1,1,1,1,1,2,1,1,2,4,1,2,2,1},
					   	   {1,1,1,1,1,1,1,1,2,1,1,1,1,4,2,1,1},
						   {1,1,1,1,1,1,1,1,2,2,1,1,1,1,2,1,1},
						   {2,2,2,2,2,2,2,2,2,1,4,1,2,1,2,2,2},
						   {2,5,5,1,1,1,1,2,2,1,1,1,1,4,1,1,2},
						   {2,2,5,1,1,1,1,1,1,4,1,1,1,1,1,1,2},
						   {2,5,5,1,1,1,1,2,2,2,2,2,2,2,2,2,2},
						   {2,2,2,2,2,2,2,2,1,1,1,1,1,1,1,1,1}};

		for (int i = 0; i < this.imageList.length; i++) {
			Image im = new ImageIcon(String.format("image/tile%d.png", i + 1)).getImage().getScaledInstance(size, size,
					Image.SCALE_SMOOTH);
			ImageIcon image = new ImageIcon(im);
			this.imageList[i] = new Item(0, 0, i + 1, image);
		}

		this.gameMap = new Item[10][17];
		int x = 117;
		int y = 250;

		for (int i = 0; i < this.gameMap.length; i++) {
			for (int j = 0; j < this.gameMap[i].length; j++) {
				Image im = new ImageIcon(String.format("image/tile%d.png", mapState[i][j])).getImage()
						.getScaledInstance(size, size, Image.SCALE_SMOOTH);
				ImageIcon image = new ImageIcon(im);
				this.gameMap[i][j] = new Item(x, y, mapState[i][j], image);// int x, int y, int state, ImageIcon image
				if (this.gameMap[i][j].getState() == GOAL || this.gameMap[i][j].getState() == BOXIN) {
					this.gameMap[i][j].setGoal(true);
				}
				if (this.gameMap[i][j].getState() == USER) {
					this.Px = j;
					this.Py = i;
				}
				x += size;
			}
			x = 117;
			y += size;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (this.reset == e.getSource()) {
			if (this.level == 1) {
				setLevel1();
			}
			if (this.level == 2) {
				setLevel2();
			}
			if (this.level == 3) {
				setLevel3();
			}
			if (this.level == 4) {
				setLevel4();
			}
			this.ms = 0;
			this.start = false;
			this.win = false;
			this.timer.setText("READY");
		}

		if (this.newGame == e.getSource()) {
			this.level = 1;
			setLevel1();
			this.ms = 0;
			this.start = false;
			this.timer.setText("READY");
		}
		
		for (int i = 0; i < this.levelBtn.length; i++) {
			if(this.levelBtn[i] == e.getSource()) {
				if(i==0)
					setLevel1();
				else if(i==1)
					setLevel2();
				else if(i==2)
					setLevel3();
				else if(i==3)
					setLevel4();
				this.level = i+1;
				this.ms = 0;
				this.start = false;
				this.win = false;
				this.timer.setText("READY");
			}
		}
	}

	@Override
	public void run() {
		while (true) {

			if (start) {
				this.ms++;
				this.timer.setText(String.format("%d.%d", this.ms / 1000, this.ms % 1000));
			}
			try {
				Thread.sleep(1);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
