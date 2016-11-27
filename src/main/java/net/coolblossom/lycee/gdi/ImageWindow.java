package net.coolblossom.lycee.gdi;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ImageWindow extends Frame {

	protected Image image;
	protected WindowAdapter adapter;
	protected Canvas canvas;

	public ImageWindow() throws HeadlessException {
		super();
		this.canvas = new Canvas();
		this.setImage(null);
		this.adapter = new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		};
		this.addWindowListener(this.adapter);
		this.add(canvas);
		this.canvas.setVisible(true);
		this.canvas.setBackground(Color.CYAN);
		this.setResizable(false);
	}


	@Override
	public void paint(Graphics g) {
		Graphics graphic = canvas.getGraphics();
		graphic.drawImage(this.image, 0, 0, this);
		graphic.dispose();
	}

	public void setImage(Image image) {
		this.image = image;
		adjustSize();
	}

	public void setClientRect(int width, int height) {
		this.canvas.setPreferredSize(new Dimension(width, height));
		this.pack();

	}

	public void adjustSize() {
		if(this.image==null)return;
		this.setClientRect(image.getWidth(null), image.getHeight(null));
	}

}