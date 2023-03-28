

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.image.*;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class FruitsForm extends JFrame implements ActionListener {

	List<Fruit> fruits = new ArrayList<>();
	private JTable table;
	private DefaultTableModel tableModel;
	private JTextField nameField;
	private JLabel nameLabel;
	private JButton addBtn;
	private JButton buyBtn;
	public Image SCALE_DEFAULT;

	public FruitsForm() throws IOException {

		fruits = new ArrayList<>();

		displayTable();

		Fruit[] fruitArray = new Fruit[9];
		addFruitArray(fruitArray);

		Cart<Fruit> cart = new Cart<>();

		addBtn.addActionListener(e -> {
			String name = nameField.getText();
			for (Fruit fruit : fruitArray) {
				if (name.equals(fruit.getName())) {

					cart.addItem(new Fruit(name, fruit.getPrice())); // 카드에 과일 담기

					Object[] row = { name, fruit.getPrice() };
					tableModel.addRow(row);
					nameField.setText("");

					System.out.println("카트에 " + name + "을(를) 담았습니다.");
				}
			}
		});

		buyBtn.addActionListener(e -> {
			System.out.println(cart.getItems());
		});

		fruitImage(fruitArray);

	}

	private void displayTable() {
		String[] columnNames = { "이름", "가격" };
		Object[][] data = new Object[0][2];
		tableModel = new DefaultTableModel(data, columnNames);
		table = new JTable(tableModel);

		nameField = new JTextField(10);
		nameLabel = new JLabel("장바구니에 담을 과일");
		addBtn = new JButton("담기");
		buyBtn = new JButton("구입하기");
		table.setRowHeight(40);

	}

	private void fruitImage(Fruit[] fruitArray) throws IOException {
		JPanel frutiPanel = new JPanel();
		frutiPanel.setLayout(new GridLayout(3, 3));
		frutiPanel.setPreferredSize(new Dimension(440, 300));
		for (Fruit fruit : fruitArray) {
			JPanel inner = new JPanel();
			frutiPanel.add(inner);
			JLabel f = new JLabel(fruit.getName() + String.valueOf(fruit.getPrice()));
			BufferedImage fruitsImage = ImageIO.read(new File("C:\\filetest\\images\\" + fruit.getName() + ".jpg"));
			JLabel flabel = new JLabel(new ImageIcon(fruitsImage));

			flabel.setPreferredSize(new Dimension(100, 100));
			inner.add(f);
			inner.add(flabel);
		}
		mainpanelSwing(frutiPanel);
	}

	private void mainpanelSwing(JPanel frutiPanel) {
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(new JScrollPane(table), BorderLayout.EAST);
		mainPanel.add(frutiPanel, BorderLayout.WEST);
		JPanel inputPanel = new JPanel();
		inputPanel.add(nameLabel);
		inputPanel.add(nameField);
		inputPanel.add(addBtn);
		inputPanel.add(buyBtn);
		mainPanel.add(inputPanel, BorderLayout.SOUTH);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(mainPanel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void addFruitArray(Fruit[] fruitArray) {
		fruitArray[0] = new Fruit("사과", 1500);
		fruitArray[1] = new Fruit("오렌지", 2500);
		fruitArray[2] = new Fruit("멜론", 4500);
		fruitArray[3] = new Fruit("바나나", 5500);
		fruitArray[4] = new Fruit("포도", 3500);
		fruitArray[5] = new Fruit("키위", 7500);
		fruitArray[6] = new Fruit("코코넛", 1500);
		fruitArray[7] = new Fruit("파파야", 3500);
		fruitArray[8] = new Fruit("복숭아", 2500);
	}

	public static void main(String[] args) throws IOException {
		new FruitsForm();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	// 모듈화 하기
}
