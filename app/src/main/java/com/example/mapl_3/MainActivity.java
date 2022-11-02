package com.example.mapl_3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Button buttonMC, buttonMR, buttonMP, buttonMS,
            buttonMM, buttonArrow, buttonCE, buttonC,
            buttonPlusMinus, buttonSqrt, buttonDot,
            buttonPlus, buttonMinus, buttonEqual,
            buttonMultiply, buttonDivision, buttonPercent,
            buttonOneX, buttonZero, buttonOne, buttonTwo,
            buttonThree, buttonFour, buttonFive,
            buttonSix, buttonSeven, buttonEight, buttonNine;
    TextView textWindow, equationWindow;
    double memoryValue =0.0 ;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//memory buttons
        buttonMC = findViewById(R.id.button10);
        buttonMR = findViewById(R.id.button7);
        buttonMP = findViewById(R.id.button);
        buttonMS = findViewById(R.id.button8);
        buttonMM = findViewById(R.id.button9);

//        clear
        buttonArrow = findViewById(R.id.button14);
        buttonCE = findViewById(R.id.button13);
        buttonC = findViewById(R.id.button12);
//actions
        buttonPlusMinus = findViewById(R.id.button11);
        buttonSqrt = findViewById(R.id.button15);
        buttonDot = findViewById(R.id.button26);
        buttonPlus = findViewById(R.id.button30);
        buttonMinus = findViewById(R.id.button31);
        buttonEqual = findViewById(R.id.button32);
        buttonMultiply = findViewById(R.id.button21);
        buttonDivision = findViewById(R.id.button16);
        buttonPercent = findViewById(R.id.button20);
        buttonOneX = findViewById(R.id.button25);
//numbers
        buttonZero = findViewById(R.id.button27);
        buttonOne = findViewById(R.id.button34);
        buttonTwo = findViewById(R.id.button35);
        buttonThree = findViewById(R.id.button29);
        buttonFour = findViewById(R.id.button24);
        buttonFive = findViewById(R.id.button23);
        buttonSix = findViewById(R.id.button22);
        buttonSeven = findViewById(R.id.button19);
        buttonEight = findViewById(R.id.button18);
        buttonNine = findViewById(R.id.button17);
//text
        textWindow = findViewById(R.id.screen);
        equationWindow = findViewById(R.id.equationDisplay);

//        add numbers
        buttonOne.setOnClickListener(v -> textWindow.setText(textWindow.getText() + "1"));
        buttonTwo.setOnClickListener(v -> textWindow.setText(textWindow.getText() + "2"));
        buttonThree.setOnClickListener(v -> textWindow.setText(textWindow.getText() + "3"));
        buttonFour.setOnClickListener(v -> textWindow.setText(textWindow.getText() + "4"));
        buttonFive.setOnClickListener(v -> textWindow.setText(textWindow.getText() + "5"));
        buttonSix.setOnClickListener(v -> textWindow.setText(textWindow.getText() + "6"));
        buttonSeven.setOnClickListener(v -> textWindow.setText(textWindow.getText() + "7"));
        buttonEight.setOnClickListener(v -> textWindow.setText(textWindow.getText() + "8"));
        buttonNine.setOnClickListener(v -> textWindow.setText(textWindow.getText() + "9"));
        buttonZero.setOnClickListener(v -> textWindow.setText(textWindow.getText() + "0"));

        buttonDot.setOnClickListener(v -> textWindow.setText(textWindow.getText() + "."));
//memory block
//        clear
        buttonMC.setOnClickListener(v -> memoryValue = 0);
//add memory
        buttonMR.setOnClickListener(v -> { if (textWindow.getText().equals("")){ textWindow.setText(Double.toString(memoryValue));}
            else{
            String value = textWindow.getText().toString();
            String checker = value.substring(value.length() - 1);
            if (checker.equals("-")|| checker.equals("+") || checker.equals("/") || checker.equals("%") || checker.equals("*")){
                textWindow.setText(textWindow.getText().toString()+ memoryValue);
            } else
            {
                Toast.makeText(this, "You did not enter a sign!", Toast.LENGTH_SHORT).show();}

            }});


//plus to memory
        buttonMP.setOnClickListener(v -> { if (textWindow.getText().equals("")){

            Toast.makeText(this, "You can not add nothing!", Toast.LENGTH_SHORT).show();
        }
        else{
            String memoryResult = textWindow.getText().toString();
            double result = eval(memoryResult);
            memoryValue = memoryValue + result;
            textWindow.setText("");}
        });
//store new result
        buttonMS.setOnClickListener(v ->{
            if (textWindow.getText().equals("")){

                Toast.makeText(this, "You can not store nothing!", Toast.LENGTH_SHORT).show();
            }
            else{

            String memoryResult = textWindow.getText().toString();
            memoryValue = eval(memoryResult);
            textWindow.setText("");}
        } );

//memory minus
        buttonMM.setOnClickListener(v ->{
            if (textWindow.getText().equals("")) {
                Toast.makeText(this, "You can not subtract nothing!", Toast.LENGTH_SHORT).show();
            }
            else{
                String memoryResult = textWindow.getText().toString();
        double result = eval(memoryResult);
        memoryValue = memoryValue - result;
            textWindow.setText("");}
        });


//        clear all
        buttonC.setOnClickListener(v -> textWindow.setText(""));

//        delete last number
        buttonCE.setOnClickListener(v -> {

            String value = textWindow.getText().toString();
            int fulfillment = value.length();
            if(fulfillment >0){
            char lastSing = value.charAt(fulfillment-1);
                while (((lastSing >= '0' && lastSing <= '9')|| lastSing == '.') && fulfillment>0){
                    value =value.substring(0,  fulfillment-1);
                    fulfillment = value.length();
                    if(fulfillment >0){
                   lastSing = value.charAt(fulfillment-1);}

                }
                textWindow.setText(value);
                }
            else{
                textWindow.setText("");
            }

        });

//      arrow delete last char

        buttonArrow.setOnClickListener(v -> {

            String value = textWindow.getText().toString();
            int fulfillment = value.length();
            if(fulfillment >0){
            value =value.substring(0,  fulfillment- 1);
            textWindow.setText(value);}
            else{
                textWindow.setText("");
            }
        });

//        math operations
        buttonPlus.setOnClickListener(v -> textWindow.setText(textWindow.getText()+"+"));
        buttonMinus.setOnClickListener(v -> textWindow.setText(textWindow.getText()+"-"));
        buttonMultiply.setOnClickListener(v -> textWindow.setText(textWindow.getText()+"*"));
        buttonDivision.setOnClickListener(v -> textWindow.setText(textWindow.getText()+"/"));
        buttonPercent.setOnClickListener(v -> textWindow.setText(textWindow.getText()+"%"));
        buttonOneX.setOnClickListener(v -> textWindow.setText("1/"+"("+textWindow.getText()+")"));

//        change sign
        buttonPlusMinus.setOnClickListener(v -> {
            if (textWindow.getText().equals("")) {
                Toast.makeText(this, "No value for this operations!", Toast.LENGTH_SHORT).show();
            } else {
                String changer = textWindow.getText().toString();
                double result = eval(changer);
                if (result < 0) {
                    textWindow.setText(String.valueOf(-result));

                } else if (result >= 0) {
                    textWindow.setText(String.valueOf(-result));
                }
            }
        });


//        sqrt root
        buttonSqrt.setOnClickListener(v -> {
            String value = null;
            if (textWindow.getText().equals("")) {
                Toast.makeText(this, "No value for sqrt operations!", Toast.LENGTH_SHORT).show();
            } else {
                value = textWindow.getText().toString();
                double result = eval(value);
                double root = Math.sqrt(result);
                textWindow.setText(String.valueOf(root));
            }
            equationWindow.setText("\u221a" + "(" + value +") = ");
        });



//equal
        buttonEqual.setOnClickListener(v -> {
            if (textWindow.getText().equals("")){
                Toast.makeText(this, "You enter nothing!", Toast.LENGTH_SHORT).show();
            }      else
            {
            String value = textWindow.getText().toString();
            double result = eval(value);
            textWindow.setText((String.valueOf(result)));
            equationWindow.setText(value + "= ");}
        });


    }

// math operation function
    public static double eval(final String str) {

        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                return x;
            }


            double parseExpression() {
                double x = parseTerm();
                for (;;) {
                    if      (eat('+')) x += parseTerm();
                    else if (eat('-')) x -= parseTerm();
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (;;) {
                    if      (eat('*')) x *= parseFactor();
                    else if (eat('/')) x /= parseFactor();
                    else if (eat('%')) x %=parseFactor();
                    else return x;
                }
            }

            double parseFactor() {
                if (eat('+')) return parseFactor();
                if (eat('-')) return -parseFactor();

                double x;
                int startPos = this.pos;

                if (eat('(')) { // parentheses
                    x = parseExpression();
                    eat(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') {
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } else {
                    throw new RuntimeException("Unexpected: " + (char)ch);
                }

                if (eat('^')) x = Math.pow(x, parseFactor());

                return x;
            }
        }.parse();
    }
}