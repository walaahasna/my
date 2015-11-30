package com.example.walaa_p.myresturent;


import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class CTextView extends TextView {

	public CTextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		setcustomfont(context);
	}

	public CTextView(Context context, AttributeSet attrs) {

		super(context, attrs);
		// TODO Auto-generated constructor stub
		setcustomfont(context);

	}

	public CTextView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		setcustomfont(context);
	}

	public void setcustomfont(Context _context) {

		Typeface font = Typeface.createFromAsset(_context.getAssets(),
				"FontAwesome.otf");
		this.setTypeface(font);
		
		

	}

}
