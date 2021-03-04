package main.mvvm.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

import main.mvvm.R;

public class MainView extends AppCompatActivity {
    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeObservers();

        EditText inputField = findViewById(R.id.inputField);
        inputField.setText(mainViewModel.getHeaderMutableLiveData().getValue());
    }

    private void initializeObservers() {
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        final Observer<String> headerObserver = text -> {
            TextView header = findViewById(R.id.header);
            header.setText(text);
        };

        mainViewModel.getHeaderMutableLiveData().observe(this, headerObserver);
    }

    public void editText(View view) {
        EditText inputField = findViewById(R.id.inputField);
        String text = inputField.getText().toString();
        mainViewModel.setHeader(text);
    }
}