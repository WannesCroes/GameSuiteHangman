package ui;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;


import domain.Cirkel;
import domain.Driehoek;
import domain.LijnStuk;
import domain.Punt;
import domain.Rechthoek;
import domain.Tekening;
import domain.Vorm;


public class TekenVenster extends Canvas {

	private static final long serialVersionUID = 1L;
	private Tekening tekening;

	public TekenVenster(Tekening tekening) {
		this.setPreferredSize(new Dimension(400, 400));
		setTekening(tekening);
	}

	private void setTekening(Tekening tekening) {
		if (tekening == null)
			throw new UiException("Tekening mag niet null zijn");
		this.tekening = tekening;
	}

	public void teken() {
		repaint();
	}

	@Override
	public void paint(Graphics graphics) {
		Graphics2D graphics2D = (Graphics2D) graphics;
		graphics2D.setStroke(new BasicStroke(5));

		for(Vorm vorm : tekening.getVormen()){
			vorm.teken(graphics);
		}
		}
}