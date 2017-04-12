package com.example.lananh.maytinh;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;

import com.example.lananh.maytinh.databinding.ActivityMainBinding;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements OnClickListener {
    ActivityMainBinding binding;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.btn0.setOnClickListener((OnClickListener) this);
        binding.btn1.setOnClickListener((OnClickListener) this);
        binding.btn2.setOnClickListener((OnClickListener) this);
        binding.btn3.setOnClickListener((OnClickListener) this);
        binding.btn4.setOnClickListener((OnClickListener) this);
        binding.btn5.setOnClickListener((OnClickListener) this);
        binding.btn6.setOnClickListener((OnClickListener) this);
        binding.btn7.setOnClickListener((OnClickListener) this);
        binding.btn8.setOnClickListener((OnClickListener) this);
        binding.btn9.setOnClickListener((OnClickListener) this);
        binding.btnCham.setOnClickListener((OnClickListener) this);
        binding.btnChia.setOnClickListener((OnClickListener) this);
        binding.btnCong.setOnClickListener((OnClickListener) this);
        binding.btnTru.setOnClickListener((OnClickListener) this);
        binding.btnNhan.setOnClickListener((OnClickListener) this);
        binding.btnKetQua.setOnClickListener((OnClickListener) this);
        binding.btnDel.setOnClickListener((OnClickListener) this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn0:
                binding.textView1.append("0");
                break;
            case R.id.btn1:
                binding.textView1.append("1");
                break;
            case R.id.btn2:
                binding.textView1.append("2");
                break;
            case R.id.btn3:
                binding.textView1.append("3");
                break;
            case R.id.btn4:
                binding.textView1.append("4");
                break;
            case R.id.btn5:
                binding.textView1.append("5");
                break;
            case R.id.btn6:
                binding.textView1.append("6");
                break;
            case R.id.btn7:
                binding.textView1.append("7");
                break;
            case R.id.btn8:
                binding.textView1.append("8");
                break;
            case R.id.btn9:
                binding.textView1.append("9");
                break;
            case R.id.btnCong:
                binding.textView1.append("+");
                break;
            case R.id.btnTru:
                binding.textView1.append("-");
                break;
            case R.id.btnNhan:
                binding.textView1.append("*");
                break;
            case R.id.btnChia:
                binding.textView1.append("/");
                break;
            case R.id.btnCham:
                binding.textView1.append(".");
                break;
            case R.id.btnDel:
                binding.textView1.setText(null);
                break;
            case R.id.btnKetQua:
                DecimalFormat df = new DecimalFormat("###.##");
                double ketqua = 0;
                addPhepTinh(binding.textView1.getText().toString());
                addNumber(binding.textView1.getText().toString());
                if (ArrPhepTinh.size() >= ArrNumber.size() || ArrPhepTinh.size() < 1)
                {
                    binding.textView2.setText("Sai cu phap");
                }
                else {
                    for (int i = 0; i < (ArrNumber.size() - 1); i++) {
                        switch (ArrPhepTinh.get(i)) {
                            case "+":
                                if (i == 0) {
                                    ketqua = ArrNumber.get(i) + ArrNumber.get(i + 1);
                                } else {
                                    ketqua = ketqua + ArrNumber.get(i + 1);
                                }
                                break;
                            case "-":
                                if (i == 0) {
                                    ketqua = ArrNumber.get(i) - ArrNumber.get(i + 1);
                                } else {
                                    ketqua = ketqua - ArrNumber.get(i + 1);
                                }
                                break;
                            case "*":
                                if (i == 0) {
                                    ketqua = ArrNumber.get(i) * ArrNumber.get(i + 1);
                                } else {
                                    ketqua = ketqua * ArrNumber.get(i + 1);
                                }
                                break;
                            case "/":
                                if (i == 0) {
                                    ketqua = ArrNumber.get(i) / ArrNumber.get(i + 1);
                                } else {
                                    ketqua = ketqua / ArrNumber.get(i + 1);
                                }
                                break;
                            default:
                                break;
                        }
                    }
                    binding.textView2.setText(df.format(ketqua) + "");
                }
                break;
            default:
                break;

        }

    }

    public ArrayList<String> ArrPhepTinh;

    public ArrayList<Double> ArrNumber;

    public int addPhepTinh(String input) {
        ArrPhepTinh = new ArrayList<>();

        char[] cArray = input.toCharArray();
        for (int i = 0; i < cArray.length; i++) {
            switch (cArray[i]) {
                case '+':
                    ArrPhepTinh.add(cArray[i] + "");
                    break;
                case '-':
                    ArrPhepTinh.add(cArray[i] + "");
                    break;
                case '*':
                    ArrPhepTinh.add(cArray[i] + "");
                    break;
                case '/':
                    ArrPhepTinh.add(cArray[i] + "");
                    break;
                default:
                    break;
            }
        }
        return 0;
    }

    public void addNumber(String stringInput) {
        ArrNumber = new ArrayList<>();
        Pattern regex = Pattern.compile("(\\d+(?:\\.\\d+)?)");
        Matcher matcher = regex.matcher(stringInput);
        while (matcher.find()) {
            ArrNumber.add(Double.valueOf(matcher.group(1)));
        }
    }
}
