package com.example.pi08uselib;

import java.net.MalformedURLException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void buttonMethod(View button){
		String msg = "";
		
		// サンプルHTML
		String html = "<a href='http://google.co.jp/'>Google</a>\n<a href='http://yahoo.co.jp/'>Yahoo</a>";
		
		// HTMLパース
		Document doc = Jsoup.parse(html);
		Elements links = doc.select("a");
		for(int i = 0; i < links.size(); i++){
			try{
				Element link = links.get(i);
				String url = link.attr("href");
				//URL urlObj = new URL(baseUrl, url);
				// 結果追記
				msg += url + "\n";
			}
			catch(Exception ex){
				msg += "Error: " + ex.toString() + "\n";
			}
		}
		
		// 表示
		TextView text = (TextView)findViewById(R.id.textView1);
		text.setText(msg);
	}
}
