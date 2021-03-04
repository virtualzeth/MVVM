package main.mvvm.view;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import main.mvvm.model.MainModel;

public class MainViewModel extends ViewModel {
    private final MutableLiveData<String> headerMutableLiveData = new MutableLiveData<>();
    private final MainModel mainModel = new MainModel();

    public MainViewModel() {
        initializeViewModelObservers(mainModel);
        headerMutableLiveData.setValue(capitalizeFirstLetter(mainModel.getHeader()));
    }

    private void initializeViewModelObservers(MainModel model) {
        model.addObserver((o, arg) -> {
            String text = ((MainModel) o).getHeader();
            headerMutableLiveData.setValue(capitalizeFirstLetter(text));
        });
    }

    private String capitalizeFirstLetter(String text) {
        return text.substring(0,1).toUpperCase() + text.substring(1).toLowerCase();
    }

    public MutableLiveData<String> getHeaderMutableLiveData() {
        return headerMutableLiveData;
    }

    public void setHeader(String text) {
        mainModel.setHeader(text);
    }
}
