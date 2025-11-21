package com.example.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvDisplay;
    private CalculatorEngine calculator;

    // Botones numéricos
    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;

    // Botones de operaciones
    private Button btnAdd, btnSubtract, btnMultiply, btnDivide;
    private Button btnEquals, btnClear, btnDot;
    private Button btnParenLeft, btnParenRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar el motor de la calculadora
        calculator = new CalculatorEngine();

        // Inicializar la pantalla
        tvDisplay = findViewById(R.id.tvDisplay);

        // Inicializar botones numéricos
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        // Inicializar botones de operaciones
        btnAdd = findViewById(R.id.btnAdd);
        btnSubtract = findViewById(R.id.btnSubtract);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnDivide = findViewById(R.id.btnDivide);
        btnEquals = findViewById(R.id.btnEquals);
        btnClear = findViewById(R.id.btnClear);
        btnDot = findViewById(R.id.btnDot);
        btnParenLeft = findViewById(R.id.btnParenLeft);
        btnParenRight = findViewById(R.id.btnParenRight);

        // Asignar listeners a botones numéricos
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);

        // Asignar listeners a botones de operaciones
        btnAdd.setOnClickListener(this);
        btnSubtract.setOnClickListener(this);
        btnMultiply.setOnClickListener(this);
        btnDivide.setOnClickListener(this);
        btnEquals.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        btnDot.setOnClickListener(this);
        btnParenLeft.setOnClickListener(this);
        btnParenRight.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        // Números
        if (id == R.id.btn0) {
            calculator.appendNumber("0");
        } else if (id == R.id.btn1) {
            calculator.appendNumber("1");
        } else if (id == R.id.btn2) {
            calculator.appendNumber("2");
        } else if (id == R.id.btn3) {
            calculator.appendNumber("3");
        } else if (id == R.id.btn4) {
            calculator.appendNumber("4");
        } else if (id == R.id.btn5) {
            calculator.appendNumber("5");
        } else if (id == R.id.btn6) {
            calculator.appendNumber("6");
        } else if (id == R.id.btn7) {
            calculator.appendNumber("7");
        } else if (id == R.id.btn8) {
            calculator.appendNumber("8");
        } else if (id == R.id.btn9) {
            calculator.appendNumber("9");
        }
        // Operaciones
        else if (id == R.id.btnAdd) {
            calculator.appendOperator("+");
        } else if (id == R.id.btnSubtract) {
            calculator.appendOperator("-");
        } else if (id == R.id.btnMultiply) {
            calculator.appendOperator("*");
        } else if (id == R.id.btnDivide) {
            calculator.appendOperator("/");
        }
        // Punto decimal
        else if (id == R.id.btnDot) {
            calculator.appendNumber(".");
        }
        // Paréntesis
        else if (id == R.id.btnParenLeft) {
            calculator.appendOperator("(");
        } else if (id == R.id.btnParenRight) {
            calculator.appendOperator(")");
        }
        // Igual
        else if (id == R.id.btnEquals) {
            calculator.calculate();
        }
        // Limpiar
        else if (id == R.id.btnClear) {
            calculator.clear();
        }

        // Actualizar la pantalla
        updateDisplay();
    }

    private void updateDisplay() {
        String displayText = calculator.getDisplayText();
        tvDisplay.setText(displayText);
    }
}

