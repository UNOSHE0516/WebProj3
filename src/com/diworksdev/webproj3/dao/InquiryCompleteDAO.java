package com.diworksdev.webproj3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.diworksdev.webproj3.util.DBConnector;

public class InquiryCompleteDAO {

//	「名前 (name)」「問い合わせの種類 (qtype)」「問い合わせ内容 (body)」をデータベースに入れるメソッド
	public int insert(String name, String qtype, String body) {

//		データを登録できたかチェックする変数
		int ret = 0;

//		DBConnector というクラスを使ってデータベースに接続 (con) します。
	DBConnector db = new DBConnector();
	Connection con = db.getConnection();

//	 データベースにデータを入れる (INSERT) 命令を用意します。 ? は「ここにデータを入れるよ！」という意味です。
	String sql = "insert into inquiry values(?,?,?)";

	try {
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, name);
		ps.setString(2, qtype);
		ps.setString(3, body);
		int i = ps.executeUpdate();


//		 データベースにデータを入れて (executeUpdate())、成功したら「○件登録されました」と表示します。
		if (i > 0) {
			System.out.println(i + "件登録されました");

//			ret = i; は、何件登録できたかをメソッドの結果 (return) として返すためのものです。
			ret = i;
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	try {
		con.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return ret;
	}
}
