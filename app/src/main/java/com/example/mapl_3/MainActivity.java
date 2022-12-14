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
    @SuppressLint("StaticFieldLeak")
    static TextView textWindow;
    TextView equationWindow;
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
        buttonOne.setOnClickListener(v -> { infinityDelete(); textWindow.setText(textWindow.getText() + "1");});
        buttonTwo.setOnClickListener(v -> { infinityDelete(); textWindow.setText(textWindow.getText() + "2");});
        buttonThree.setOnClickListener(v -> { infinityDelete();  textWindow.setText(textWindow.getText() + "3");});
        buttonFour.setOnClickListener(v -> { infinityDelete();  textWindow.setText(textWindow.getText() + "4");});
        buttonFive.setOnClickListener(v -> { infinityDelete();  textWindow.setText(textWindow.getText() + "5");});
        buttonSix.setOnClickListener(v -> { infinityDelete();  textWindow.setText(textWindow.getText() + "6");});
        buttonSeven.setOnClickListener(v -> { infinityDelete();  textWindow.setText(textWindow.getText() + "7");});
        buttonEight.setOnClickListener(v -> { infinityDelete();  textWindow.setText(textWindow.getText() + "8");});
        buttonNine.setOnClickListener(v -> { infinityDelete();  textWindow.setText(textWindow.getText() + "9");});
        buttonZero.setOnClickListener(v -> { infinityDelete();  textWindow.setText(textWindow.getText() + "0");});

        buttonDot.setOnClickListener(v ->  { infinityDelete(); textWindow.setText(textWindow.getText() + ".");});
//memory block
//        clear
        buttonMC.setOnClickListener(v -> memoryValue = 0);
//add memory
        buttonMR.setOnClickListener(v -> {
            infinityDelete();
            if (textWindow.getText().equals("")){ textWindow.setText(Double.toString(memoryValue));}
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
            infinityDelete();
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
            infinityDelete();
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
            infinityDelete();
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
        buttonC.setOnClickListener(v -> {infinityDelete(); textWindow.setText("");});

//        delete last number
        buttonCE.setOnClickListener(v -> {
            infinityDelete();
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
            infinityDelete();
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
        buttonPlus.setOnClickListener(v -> { infinityDelete(); textWindow.setText(textWindow.getText()+"+");});
        buttonMinus.setOnClickListener(v ->{infinityDelete(); textWindow.setText(textWindow.getText()+"-");});
        buttonMultiply.setOnClickListener(v -> {infinityDelete(); textWindow.setText(textWindow.getText()+"*");});
        buttonDivision.setOnClickListener(v -> {infinityDelete(); textWindow.setText(textWindow.getText()+"/");});
        buttonPercent.setOnClickListener(v -> {infinityDelete(); textWindow.setText(textWindow.getText()+"%");});

        buttonOneX.setOnClickListener(v ->{
            infinityDelete();
                String value = textWindow.getText().toString();
        boolean errorChecker =checkSysError(value);

        if (errorChecker) {
            textWindow.setText("1/"+"("+value+")");
        } else {
            equationWindow.setText("Syntax Error! ");
            Toast.makeText(this, "Try again)\n Please, enter clean mathematical expression before such operation!", Toast.LENGTH_SHORT).show();
        }



        });

//        change sign
        buttonPlusMinus.setOnClickListener(v -> {
            infinityDelete();
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
            infinityDelete();
            String value = textWindow.getText().toString();
            boolean errorChecker =checkSysError(value);
            if (value.equals("")) {
                Toast.makeText(this, "No value for sqrt operations!", Toast.LENGTH_SHORT).show();
            } else if (errorChecker){
                double result = eval(value);
                double root = Math.sqrt(result);
                textWindow.setText(String.valueOf(root));
                equationWindow.setText("\u221a" + "(" + value +") = ");
            }
            else {
                equationWindow.setText("Syntax Error! ");
                Toast.makeText(this, "Try C button or try again)\n Please, enter clean mathematical expression!", Toast.LENGTH_SHORT).show();
            }

        });



//equal
        buttonEqual.setOnClickListener(v -> {
            infinityDelete();
            String value = textWindow.getText().toString();
            boolean errorChecker =checkSysError(value);

                if (errorChecker) {
                    double result = eval(value);
                    textWindow.setText((String.valueOf(result)));
                    equationWindow.setText(value + "= ");
                } else {
                    equationWindow.setText("Syntax Error! ");
                    Toast.makeText(this, "Try C button or try again)\n Please, enter clean mathematical expression!", Toast.LENGTH_SHORT).show();
                }

            }

        );}
public static void infinityDelete(){
        String value = textWindow.getText().toString();
        if(value.equals("Infinity")){
            textWindow.setText("");
        }

    }
    public static boolean checkSysError(final String str) {
        boolean syntaxErrorChecker = false;
        if (str.equals("")) {
           System.out.println("Noting should happened!");
        } else {
            syntaxErrorChecker = true;
            int c = 0;
            for (int i = 0; i < str.length(); i++) {
                c = c + 1;
                char thisChar = str.charAt(i);

                char nextChar;

                if (i < c && c < str.length()) {
                    nextChar = str.charAt(i + 1);


                } else {
                    nextChar = ' ';
                }
//good expression rules
                //first char review
                if (str.charAt(0) == '*' || str.charAt(0) == '%' || str.charAt(0) == '/' || str.charAt(0) == '.') {
                    syntaxErrorChecker = false;

                }
                //last char review
                if ((nextChar == ' ') && (thisChar == '/' || thisChar == '*' || thisChar == '%' || thisChar == '+' || thisChar == '-' || thisChar == ' ' || thisChar == '.')) {
                    syntaxErrorChecker = false;

                }
                //double signs review
                if ((thisChar == nextChar) && (nextChar == '/' || nextChar == '*' || nextChar == '%'  || nextChar == ' ' || nextChar == '.')) {
                    syntaxErrorChecker = false;

                }
            }
        }
        return syntaxErrorChecker;
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
                double x = parseTerm();
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                return x;
            }


            double parseTerm() {
                double x = parseFactor();
                for (;;) {
                    if      (eat('*')) x *= parseFactor();
                    else if (eat('/')) x /= parseFactor();
                    else if (eat('%')) x %= parseFactor();
                    else if (eat('+')) x += parseFactor();
                    else if (eat('-')) x -= parseFactor();
                    else return x;
                }
            }



            double parseFactor() {

               if (eat('+')) return parseFactor();
               if (eat('-')) return -parseFactor();


                double x;
                int startPos = this.pos;

                if (eat('(')) { // parentheses
                    x = parseTerm();
                    eat(')');
                } else if (ch >= '0' && ch <= '9' || ch == '.') {
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } else {
                    throw new RuntimeException("Unexpected: " + (char)ch);


                }

                return x;
            }
        }.parse();
    }
}