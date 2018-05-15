package co.udistrital.android.thomasmensageria.delete_route.ui;

/**
 * Created by ASUS on 14/05/2018.
 */

public interface DeleteRouteView {

    void showInput();
    void hideInput();
    void showProgress();
    void hideProgress();

    void routeDeleted();
    void routeNotDeleted();
}
