package com.wangye.newcalculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    String number1 = "0";
    String number2 = "0";
    char fuHao = ' ';
    String result = "";
    String result2 = "";
    String input = "";
    boolean first = true; //判断是否第一次输入数字
    boolean Outed = false;

    protected void Clean() {
        number1 = "0";
        number2 = "0";
        fuHao = ' ';
        result = "";
        result2 = "";
        input = "";
        first = true;
        Outed = false;

    }

    protected boolean LastFuHao(String result) {
        char fh = result.charAt(result.length() - 1);
        if (fh != '+' && fh != '-' && fh != '/' && fh != '×')
            return false;
        else
            return true;
    }


    protected String Output(String number1, String number2, char fuHao) {
        String answer = "";
        String answer2 = "";

        int dian;
            switch (fuHao) {
                case '+':
                    answer = String.valueOf((Double.parseDouble(number1)) + Double.parseDouble(number2));
                    break;

                case '-':
                    answer = String.valueOf((Double.parseDouble(number1)) - Double.parseDouble(number2));
                    break;

                case '*':
                    answer = String.valueOf((Double.parseDouble(number1)) * Double.parseDouble(number2));
                    break;

                case '/':
                    answer = String.valueOf((Double.parseDouble(number1)) / Double.parseDouble(number2));
                    break;
            }
        for (dian = 0;dian<answer.length();dian++){
            if (answer.charAt(dian)=='.')
                break;
        }
        if (dian !=answer.length()-1) {
            for (int i = dian; i < answer.length() - 2; i++) {
                if (answer.substring(i, i + 3).equals("000")) {
                    answer = answer.substring(0, i);
                    break;
                }
            }
        }
        answer2 = answer.substring(0,dian);
        if (Double.parseDouble(answer)-Integer.parseInt(answer2)<0.00001)
            answer = String.valueOf(Integer.parseInt(answer2));

        return answer;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView show = (TextView) findViewById(R.id.text);
        final TextView show2 = (TextView) findViewById(R.id.answer);
        Button b1 = (Button) findViewById(R.id.one);
        Button b2 = (Button) findViewById(R.id.two);
        Button b3 = (Button) findViewById(R.id.three);
        Button b4 = (Button) findViewById(R.id.four);
        Button b5 = (Button) findViewById(R.id.five);
        Button b6 = (Button) findViewById(R.id.six);
        Button b7 = (Button) findViewById(R.id.seven);
        Button b8 = (Button) findViewById(R.id.eight);
        Button b9 = (Button) findViewById(R.id.nine);
        Button b0 = (Button) findViewById(R.id.zero);
        Button bCl = (Button) findViewById(R.id.Clear);
        Button bJia = (Button) findViewById(R.id.jia);
        Button bJian = (Button) findViewById(R.id.div);
        Button bCheng = (Button) findViewById(R.id.mul);
        Button bChu = (Button) findViewById(R.id.chu);
        Button bDian = (Button) findViewById(R.id.dian);
        Button bEqual = (Button) findViewById(R.id.equal);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                if (Outed)
                    Clean();
                input += '1';
                result += '1';
                show.setText(result);
                show2.setText(result2);

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Outed)
                    Clean();
                input += '2';
                result += '2';
                show.setText(result);
                show2.setText(result2);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Outed)
                    Clean();
                input += '3';
                result += '3';
                show.setText(result);
                show2.setText(result2);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Outed)
                    Clean();
                input += '4';
                result += '4';
                show.setText(result);
                show2.setText(result2);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Outed)
                    Clean();
                input += '5';
                result += '5';
                show.setText(result);
                show2.setText(result2);
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Outed)
                    Clean();
                input += '6';
                result += '6';
                show.setText(result);
                show2.setText(result2);
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Outed)
                    Clean();
                input += '7';
                result += '7';
                show.setText(result);
                show2.setText(result2);
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Outed)
                    Clean();
                input += '1';
                result += '1';
                show.setText(result);
                show2.setText(result2);
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Outed)
                    Clean();
                input += '9';
                result += '9';
                show.setText(result);
                show2.setText(result2);
            }
        });
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Outed)
                    Clean();
                input += '0';
                result += '0';
                show.setText(result);
                show2.setText(result2);
            }
        });
        bJia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!result.equals("")) {
                    if (first) {
                        number1 = input;
                        input = "";
                        first = false;
                    } else {
                        if (!LastFuHao(result)) {
                            number1 = Output(number1, input, fuHao);
                            input = "";
                            Outed = false;
                        }
                    }
                    if (!LastFuHao(result)) {
                        fuHao = '+';
                        result += '+';
                        show.setText(result);
                    }
                }
            }
        });
        bJian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!result.equals("")) {
                    if (first) {
                        number1 = input;
                        input = "";
                        first = false;
                    } else {
                        if (!LastFuHao(result)) {
                            number1 = Output(number1, input, fuHao);
                            input = "";
                            Outed = false;
                        }
                    }
                    if (!LastFuHao(result)) {
                        fuHao = '-';
                        result += '-';
                        show.setText(result);
                    }
                }
            }
        });
        bCheng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!result.equals("")) {
                    if (first) {
                        number1 = input;
                        input = "";
                        first = false;
                    } else {
                        if (!LastFuHao(result)) {
                            number1 = Output(number1, input, fuHao);
                            input = "";
                            Outed = false;
                        }
                    }
                    if (!LastFuHao(result)) {
                        fuHao = '*';
                        result += '×';
                        show.setText(result);
                    }
                }
            }
        });
        bChu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!result.equals("")) {
                    if (first) {
                        number1 = input;
                        input = "";
                        first = false;
                    } else {
                        if (!LastFuHao(result)) {
                            number1 = Output(number1, input, fuHao);
                            input = "";
                            Outed = false;
                        }
                    }
                    if (!LastFuHao(result)) {
                        fuHao = '/';
                        result += '÷';
                        show.setText(result);
                    }
                }
            }
        });
        bCl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Clean();
                //show.setText("Mackenzie is SB \n哈哈哈哈哈");
                show.setText(" ");
                show2.setText(" ");
            }
        });
        bDian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Outed)
                    Clean();
                show.setText(result);
                show2.setText(result2);
                if (result.equals("")) {
                    input = "0.";
                    result = "0.";
                    show.setText(result);
                } else {
                    if (!LastFuHao(result)) {
                        input += ".";
                        result += ".";
                        show.setText(result);
                        show2.setText(result2);
                    }
                }
            }
        });
        bEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!LastFuHao(result)) {
                    Outed = true;
                    number2 = input;
                    result2 = Output(number1, number2, fuHao);
                    show2.setText(result2);
                } else {
                    Outed = true;
                    result2 = number1;
                    result = result.substring(0, result.length() - 1);
                    show.setText(result);
                    show2.setText(result2);
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
