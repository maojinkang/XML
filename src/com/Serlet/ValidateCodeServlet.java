package com.Serlet;

import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ValidateCodeServlet
 */
@WebServlet("/ValidateCodeServlet")
public class ValidateCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ValidateCodeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("image/jpeg");
		// ��������ͼ��
		ServletOutputStream out = response.getOutputStream();
		int width = 60;
		int height = 20;
		BufferedImage imgbut = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = imgbut.createGraphics();
		// ���ñ�����ɫ
		g.setColor(getRandColor(200, 250));
		// ����ͼ����״�����
		g.fillRect(0, 0, width, height);
		// �������������
		Random r = new Random();
		g.setColor(getRandColor(160, 200));
		for (int i = 0; i < 100; i++) {
			int x = r.nextInt(width);
			int y = r.nextInt(height);
			int x1 = r.nextInt(12);
			int y1 = r.nextInt(12);
			g.drawLine(x, y, x + x1, y + y1);
		}
		// ����������ŵ�
		g.setColor(getRandColor(120, 240));
		String code = "";
		for (int i = 0; i < 100; i++) {
			int x = r.nextInt(width);
			int y = r.nextInt(height);
			g.drawOval(x, y, 0, 0);
		}
		// ����4λ������֤��
		g.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		for (int i = 0; i < 4; i++) {
			String rand = String.valueOf(r.nextInt(10));
			code+=rand;
			g.setColor(new Color(20 + r.nextInt(110), 20 + r.nextInt(110), 20 + r.nextInt(110)));
			g.drawString(rand, 13 * i + 6, 16);
		}
		request.getSession().setAttribute("VALIDATECODE", code);
		// ���ͼ��
		ImageIO.write(imgbut, "JPEG", out);
		out.close();
	}

	private Color getRandColor(int i, int j) {
		// ��ȡ�����ɫ
		Random random = new Random();
		if (i > 255)
			i = 255;
		if (j > 255)
			j = 255;
		if (i < 0)
			i = 0;
		if (j < 0)
			j = 0;
		int r = i + random.nextInt(j - i);
		int g = i + random.nextInt(j - i);
		int b = i + random.nextInt(j - i);
		return new Color(r, g, b);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
