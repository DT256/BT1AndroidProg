package com.ducthang.bttuan2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Khởi tạo view
        Button buttonProcessArray = findViewById(R.id.buttonProcessArray);
        Button buttonProcessString = findViewById(R.id.buttonProcessString);
        EditText editTextInput = findViewById(R.id.editTextInput);

        // Nút xử lý mảng
        buttonProcessArray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processArray();
            }
        });

        // Nút xử lý chuỗi
        buttonProcessString.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processString(editTextInput);
            }
        });
    }

    private void processArray() {
        // Mảng số
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        ArrayList<Integer> evenNumbers = new ArrayList<>();
        ArrayList<Integer> oddNumbers = new ArrayList<>();

        for (int num : numbers) {
            if (num % 2 == 0) {
                evenNumbers.add(num);
            } else {
                oddNumbers.add(num);
            }
        }

        // Log kết quả
        Log.d("EvenNumbers", evenNumbers.toString());
        Log.d("OddNumbers", oddNumbers.toString());

    }

    private void processString(EditText inputView) {
        String input = inputView.getText().toString();

        if (!input.isEmpty()) {
            // Đảo ngược và in hoa
            String[] words = input.split(" ");
            StringBuilder reversedString = new StringBuilder();
            for (int i = words.length - 1; i >= 0; i--) {
                reversedString.append(words[i]).append(" ");
            }

            String result = reversedString.toString().trim().toUpperCase();

            // Hiển thị kết quả
            Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Vui lòng nhập chuỗi", Toast.LENGTH_SHORT).show();
        }
    }

}