package main.mvvm.viewModel;

import java.util.Observable;

import main.mvvm.model.MainModel;

public class MainViewModel extends Observable {
    private final MainModel mainModel = new MainModel();

    private String header;

    public MainViewModel() {
        observeModel(mainModel);
    }

    private void observeModel(MainModel model) {
        model.addObserver((o, arg) -> {
            String header = ((MainModel) o).getHeader();
            this.header = capitalizeFirstLetter(header);

            MainViewModel.super.setChanged();
            MainViewModel.super.notifyObservers();
        });
    }

    private String capitalizeFirstLetter(String str) {
        return str.substring(0,1).toUpperCase() + str.substring(1).toLowerCase();
    }

    public String getHeader() {
        return this.header;
    }

    public void setHeader(String str) {
        this.mainModel.setHeader(str);
    }
}
