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
    private EditText editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        header = (TextView) findViewById(R.id.header);
        editor = (EditText) findViewById(R.id.editor);

        observer(headerModel);

        editor.setText(headerModel.getText());
    }

    private void observer(HeaderModel headerModel) {
        headerModel.addObserver((o, arg) -> {
            String text = ((HeaderModel) o).getText();
            header.setText(text);
        });
    }

    public void editText(View view) {
        String text = editor.getText().toString();
        headerModel.setText(text);
    }
}