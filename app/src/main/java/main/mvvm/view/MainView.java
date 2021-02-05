package main.mvvm.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

import main.mvvm.R;

import main.mvvm.model.HeaderModel;

public class MainView extends AppCompatActivity {
    private final HeaderModel headerModel = new HeaderModel();

    private TextView header;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        header = (TextView) findViewById(R.id.header);
        editText = (EditText) findViewById(R.id.editText);

        header.setText(headerModel.getText());
        editText.setText(headerModel.getText());
    }

    public void editText(View view) {
        String text = editText.getText().toString();
        headerModel.setText(text);
        header.setText(text);
    }
}