package com.lun.calculator;

import java.text.DecimalFormat;

import android.R.color;
import android.app.Activity;
import android.app.Notification.Action;
import android.app.usage.UsageEvents.Event;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

	private Button BtnAC;
	private Button BtnDelete;
	private Button BtnDivide;
	private Button BtnMultiply;
	private Button Btn7;
	private Button Btn8;
	private Button Btn9;
	private Button BtnMinors;
	private Button Btn4;
	private Button Btn5;
	private Button Btn6;
	private Button BtnPlus;
	private Button Btn1;
	private Button Btn2;
	private Button Btn3;
	private Button BtnEqual;
	private Button BtnNightMode;
	private Button Btn0;
	private Button BtnDot;
	
	private TextView Text1, Text2, Text3, Text4, CurrentText, resultText;
	private String inputString, inputSymbol;
	
	private LinearLayout texts;
	private RelativeLayout main;
	
	private double result;
	private boolean isFinished, isNightMode;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		inputString ="0";
		inputSymbol = "";
		result = 0;
		isFinished = false;
		isNightMode = false;
		
		Text1 =(TextView)findViewById(R.id.text1);
		Text2 =(TextView)findViewById(R.id.text2);
		Text3 =(TextView)findViewById(R.id.text3);
		Text4 = (TextView)findViewById(R.id.text4);
		CurrentText =(TextView)findViewById(R.id.currentText);
		resultText =(TextView)findViewById(R.id.resultText);
		CurrentText.setText(inputString);
		
		texts = (LinearLayout)findViewById(R.id.texts);
		main = (RelativeLayout)findViewById(R.id.main);
		
		BtnAC = (Button)findViewById(R.id.BtnAC);
		BtnDelete = (Button)findViewById(R.id.BtnDelete);
		BtnDivide = (Button)findViewById(R.id.BtnDivide);
		BtnMultiply = (Button)findViewById(R.id.BtnMultiply);
		Btn7 = (Button)findViewById(R.id.Btn7);
		Btn8 = (Button)findViewById(R.id.Btn8);
		Btn9 = (Button)findViewById(R.id.Btn9);
		BtnMinors = (Button)findViewById(R.id.BtnMinors);
		Btn4 = (Button)findViewById(R.id.Btn4);
		Btn5 = (Button)findViewById(R.id.Btn5);
		Btn6 = (Button)findViewById(R.id.Btn6);
		BtnPlus = (Button)findViewById(R.id.BtnPlus);
		Btn1 = (Button)findViewById(R.id.Btn1);
		Btn2 = (Button)findViewById(R.id.Btn2);
		Btn3 = (Button)findViewById(R.id.Btn3);
		BtnNightMode = (Button)findViewById(R.id.BtnNightMode);
		Btn0 = (Button)findViewById(R.id.Btn0);
		BtnDot = (Button)findViewById(R.id.BtnDot);
		BtnEqual = (Button)findViewById(R.id.BtnEqual);
		
		ButtonListener listener = new ButtonListener();
		BtnAC.setOnTouchListener(listener);
		BtnDelete.setOnTouchListener(listener);
		BtnDivide.setOnTouchListener(listener);
		BtnMultiply.setOnTouchListener(listener);
		Btn7.setOnTouchListener(listener);
		Btn8.setOnTouchListener(listener);
		Btn9.setOnTouchListener(listener);
		BtnMinors.setOnTouchListener(listener);
		Btn4.setOnTouchListener(listener);
		Btn5.setOnTouchListener(listener);
		Btn6.setOnTouchListener(listener);
		BtnPlus.setOnTouchListener(listener);
		Btn1.setOnTouchListener(listener);
		Btn2.setOnTouchListener(listener);
		Btn3.setOnTouchListener(listener);
		BtnEqual.setOnTouchListener(listener);
		BtnNightMode.setOnTouchListener(listener);
		Btn0.setOnTouchListener(listener);
		BtnDot.setOnTouchListener(listener);
		
		CangeModeButtonListener formulaListener = new CangeModeButtonListener();
		BtnNightMode.setOnTouchListener(formulaListener);
	}

	public class CangeModeButtonListener implements OnTouchListener{
		@Override
		public boolean onTouch(View v, MotionEvent event) {
			if(!isNightMode){
				if(event.getAction()==MotionEvent.ACTION_DOWN){
					v.setBackground(getResources().getDrawable(R.drawable.buttontouched, null));
				}
				if(event.getAction()==MotionEvent.ACTION_UP){
					v.setBackground(getResources().getDrawable(R.drawable.buttonstyle, null));
					isNightMode = true;
					
					texts.setBackgroundColor(Color.DKGRAY);
					main.setBackgroundColor(Color.DKGRAY);
					
					Text1.setTextColor(Color.WHITE);
					Text2.setTextColor(Color.WHITE);
					Text3.setTextColor(Color.WHITE);
					Text4.setTextColor(Color.WHITE);
					CurrentText.setTextColor(Color.WHITE);
					resultText.setTextColor(Color.WHITE);
					
					Btn0.setBackground(getResources().getDrawable(R.drawable.nightbuttonstyle,null));
					Btn0.setTextColor(Color.WHITE);
					Btn1.setBackground(getResources().getDrawable(R.drawable.nightbuttonstyle,null));
					Btn1.setTextColor(Color.WHITE);
					Btn2.setBackground(getResources().getDrawable(R.drawable.nightbuttonstyle,null));
					Btn2.setTextColor(Color.WHITE);
					Btn3.setBackground(getResources().getDrawable(R.drawable.nightbuttonstyle,null));
					Btn3.setTextColor(Color.WHITE);
					Btn4.setBackground(getResources().getDrawable(R.drawable.nightbuttonstyle,null));
					Btn4.setTextColor(Color.WHITE);
					Btn5.setBackground(getResources().getDrawable(R.drawable.nightbuttonstyle,null));
					Btn5.setTextColor(Color.WHITE);
					Btn6.setBackground(getResources().getDrawable(R.drawable.nightbuttonstyle,null));
					Btn6.setTextColor(Color.WHITE);
					Btn7.setBackground(getResources().getDrawable(R.drawable.nightbuttonstyle,null));
					Btn7.setTextColor(Color.WHITE);
					Btn8.setBackground(getResources().getDrawable(R.drawable.nightbuttonstyle,null));
					Btn8.setTextColor(Color.WHITE);
					Btn9.setBackground(getResources().getDrawable(R.drawable.nightbuttonstyle,null));
					Btn9.setTextColor(Color.WHITE);
					BtnAC.setBackground(getResources().getDrawable(R.drawable.nightbuttonstyle,null));
					BtnAC.setTextColor(Color.WHITE);
					BtnDelete.setBackground(getResources().getDrawable(R.drawable.nightbuttonstyle,null));
					BtnDelete.setTextColor(Color.WHITE);
					BtnDivide.setBackground(getResources().getDrawable(R.drawable.nightbuttonstyle,null));
					BtnDivide.setTextColor(Color.WHITE);
					BtnDot.setBackground(getResources().getDrawable(R.drawable.nightbuttonstyle,null));
					BtnDot.setTextColor(Color.WHITE);
					BtnEqual.setBackground(getResources().getDrawable(R.drawable.nightbuttonstyle,null));
					BtnEqual.setTextColor(Color.WHITE);
					BtnMinors.setBackground(getResources().getDrawable(R.drawable.nightbuttonstyle,null));
					BtnMinors.setTextColor(Color.WHITE);
					BtnMultiply.setBackground(getResources().getDrawable(R.drawable.nightbuttonstyle,null));
					BtnMultiply.setTextColor(Color.WHITE);
					BtnNightMode.setBackground(getResources().getDrawable(R.drawable.nightbuttonstyle,null));
					BtnNightMode.setTextColor(Color.WHITE);
					BtnPlus.setBackground(getResources().getDrawable(R.drawable.nightbuttonstyle,null));
					BtnPlus.setTextColor(Color.WHITE);
					
					BtnNightMode.setText("日间");
				}
			}
			else{
				if(event.getAction()==MotionEvent.ACTION_DOWN){
					v.setBackground(getResources().getDrawable(R.drawable.nightbuttontouchedstyle, null));
				}
				if(event.getAction()==MotionEvent.ACTION_UP){
					v.setBackground(getResources().getDrawable(R.drawable.nightbuttonstyle, null));
					isNightMode = false;
					
					texts.setBackgroundColor(Color.WHITE);
					main.setBackgroundColor(Color.WHITE);
					
					Text1.setTextColor(Color.BLACK);
					Text2.setTextColor(Color.BLACK);
					Text3.setTextColor(Color.BLACK);
					Text4.setTextColor(Color.BLACK);
					CurrentText.setTextColor(Color.BLACK);
					resultText.setTextColor(Color.BLACK);
					
					Btn0.setBackground(getResources().getDrawable(R.drawable.buttonstyle,null));
					Btn0.setTextColor(Color.BLACK);
					Btn1.setBackground(getResources().getDrawable(R.drawable.buttonstyle,null));
					Btn1.setTextColor(Color.BLACK);
					Btn2.setBackground(getResources().getDrawable(R.drawable.buttonstyle,null));
					Btn2.setTextColor(Color.BLACK);
					Btn3.setBackground(getResources().getDrawable(R.drawable.buttonstyle,null));
					Btn3.setTextColor(Color.BLACK);
					Btn4.setBackground(getResources().getDrawable(R.drawable.buttonstyle,null));
					Btn4.setTextColor(Color.BLACK);
					Btn5.setBackground(getResources().getDrawable(R.drawable.buttonstyle,null));
					Btn5.setTextColor(Color.BLACK);
					Btn6.setBackground(getResources().getDrawable(R.drawable.buttonstyle,null));
					Btn6.setTextColor(Color.BLACK);
					Btn7.setBackground(getResources().getDrawable(R.drawable.buttonstyle,null));
					Btn7.setTextColor(Color.BLACK);
					Btn8.setBackground(getResources().getDrawable(R.drawable.buttonstyle,null));
					Btn8.setTextColor(Color.BLACK);
					Btn9.setBackground(getResources().getDrawable(R.drawable.buttonstyle,null));
					Btn9.setTextColor(Color.BLACK);
					BtnAC.setBackground(getResources().getDrawable(R.drawable.buttonstyle,null));
					BtnAC.setTextColor(Color.rgb(255, 140, 0));
					BtnDelete.setBackground(getResources().getDrawable(R.drawable.buttonstyle,null));
					BtnDelete.setTextColor(Color.BLACK);
					BtnDivide.setBackground(getResources().getDrawable(R.drawable.buttonstyle,null));
					BtnDivide.setTextColor(Color.BLACK);
					BtnDot.setBackground(getResources().getDrawable(R.drawable.buttonstyle,null));
					BtnDot.setTextColor(Color.BLACK);
					BtnEqual.setBackground(getResources().getDrawable(R.drawable.equalbuttonstyle,null));
					BtnEqual.setTextColor(Color.WHITE);
					BtnMinors.setBackground(getResources().getDrawable(R.drawable.buttonstyle,null));
					BtnMinors.setTextColor(Color.BLACK);
					BtnMultiply.setBackground(getResources().getDrawable(R.drawable.buttonstyle,null));
					BtnMultiply.setTextColor(Color.BLACK);
					BtnNightMode.setBackground(getResources().getDrawable(R.drawable.buttonstyle,null));
					BtnNightMode.setTextColor(Color.BLACK);
					BtnPlus.setBackground(getResources().getDrawable(R.drawable.buttonstyle,null));
					BtnPlus.setTextColor(Color.BLACK);
					
					BtnNightMode.setText("夜间");
				}
				
			}
			
			return false;
		}
	}
	
	
	
	public class ButtonListener implements OnTouchListener{
		@SuppressWarnings("deprecation")
		@Override
		public boolean onTouch(View v, android.view.MotionEvent event) {
			if(!isNightMode){
				if(event.getAction()==MotionEvent.ACTION_DOWN){
					if(v.getId()==R.id.BtnEqual){
						v.setBackground(getResources().getDrawable(R.drawable.equalbuttontouchedstyle, null));
					}
					else{
						v.setBackground(getResources().getDrawable(R.drawable.buttontouched, null));
					}
				} 
				if(event.getAction()==MotionEvent.ACTION_UP){
					if(v.getId()==R.id.BtnEqual){
						v.setBackground(getResources().getDrawable(R.drawable.equalbuttonstyle, null));
					}
					else{
						v.setBackground(getResources().getDrawable(R.drawable.buttonstyle, null));
					}
				}
			}
			else{
				if(event.getAction()==MotionEvent.ACTION_DOWN){
					v.setBackground(getResources().getDrawable(R.drawable.nightbuttontouchedstyle, null));
				} 
				if(event.getAction()==MotionEvent.ACTION_UP){
					v.setBackground(getResources().getDrawable(R.drawable.nightbuttonstyle, null));
				}
			}	
				

			if(event.getAction()==MotionEvent.ACTION_UP){
				if(inputString.length()<9 && !isFinished){
					if(v.getId()==R.id.Btn0){
						if(!inputString.equals("0")){
							inputString += "0";
						}
					}
					if(v.getId()==R.id.Btn1){
						if(inputString.equals("0")){
							inputString = "1";
						}
						else{
							inputString += "1";
						}
					}
					if(v.getId()==R.id.Btn2){
						if(inputString.equals("0")){
							inputString = "2";
						}
						else{
							inputString += "2";
						}
					}
					if(v.getId()==R.id.Btn3){
						if(inputString.equals("0")){
							inputString = "3";
						}
						else{
							inputString += "3";
						}
					}
					if(v.getId()==R.id.Btn4){
						if(inputString.equals("0")){
							inputString = "4";
						}
						else{
							inputString += "4";
						}
					}
					if(v.getId()==R.id.Btn5){
						if(inputString.equals("0")){
							inputString = "5";
						}
						else{
							inputString += "5";
						}
					}
					if(v.getId()==R.id.Btn6){
						if(inputString.equals("0")){
							inputString = "6";
						}
						else{
							inputString += "6";
						}
					}
					if(v.getId()==R.id.Btn7){
						if(inputString.equals("0")){
							inputString = "7";
						}
						else{
							inputString += "7";
						}
					}
					if(v.getId()==R.id.Btn8){
						if(inputString.equals("0")){
							inputString = "8";
						}
						else{
							inputString += "8";
						}
					}
					if(v.getId()==R.id.Btn9){
						if(inputString.equals("0")){
							inputString = "9";
						}
						else{
							inputString += "9";
						}
					}
				}
				
				if(v.getId()==R.id.BtnPlus){
					doCalculation();
					inputSymbol = "+";
					inputString = "";
					isFinished=false;
				}
				if(v.getId()==R.id.BtnEqual){
					doCalculation();
					inputSymbol = "=";
					inputString = result+"";
					//去除不必要的小数点 （如30.0）
					if(inputString.substring(inputString.length()-2, inputString.length()).equals(".0")){
						inputString = inputString.substring(0, inputString.length()-2);
					} 
					//限制最长长度
			/*		if(inputString.length()>9){
						inputString = inputString.substring(0, 9);
					}  */
					resultText.setText("");
					isFinished=true;
				}
				if(v.getId()==R.id.BtnDivide){
					doCalculation();
					inputSymbol = "÷";
					inputString = "";
					isFinished=false;
				}
				if(v.getId()==R.id.BtnMultiply){
					doCalculation();
					inputSymbol = "×";
					inputString = "";
					isFinished=false;
				}
				if(v.getId()==R.id.BtnMinors){
					doCalculation();
					inputSymbol = "-";
					inputString = "";
					isFinished=false;
				}
				if(v.getId()==R.id.BtnAC){
					inputSymbol = "";
					inputString = "0";
					Text1.setText("");
					Text2.setText("");
					Text3.setText("");
					Text4.setText("");
					resultText.setText("");
					result=0;
					isFinished=false;
				}
				if(v.getId()==R.id.BtnDelete){
					if(inputString.length()>0 && !isFinished){
						if(inputString.length()!=1){
							inputString = inputString.substring(0, inputString.length()-1);
						}
						else{
							inputString = "0";
						}
					}
				}
				if(v.getId()==R.id.BtnDot){
					inputString+=".";
				}
				CurrentText.setText(inputSymbol + inputString);
			}
			return true;	
		}
	}
	
	public void doCalculation(){
		if(inputString.length()==0){
			return;
		}
		Text1.setText(Text2.getText());
		Text2.setText(Text3.getText());
		Text3.setText(Text4.getText());
		Text4.setText(CurrentText.getText());
		
		if(inputSymbol.equals("")){
			result = Double.parseDouble(inputString);
		}
		else if(inputSymbol.equals("+")){
			result += Double.parseDouble(inputString);
		}
		else if(inputSymbol.equals("÷")){
			result /= Double.parseDouble(inputString);
		}
		else if(inputSymbol.equals("×")){
			result *= Double.parseDouble(inputString);
		}
		else if(inputSymbol.equals("-")){
			result -= Double.parseDouble(inputString);
		}
		String resultString = "";
		if(result==(int)result){
			resultString = (int)result+"";
		}
		else{
			resultString = result+"";
		}
		
	/*	if(resultString.length()>9){
			resultString=resultString.substring(0,9);
		}   */
		resultText.setText("="+resultString);
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
