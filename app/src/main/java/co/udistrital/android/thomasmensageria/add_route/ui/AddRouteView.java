package co.udistrital.android.thomasmensageria.add_route.ui;

/**
 * Created by wisuarez on 10/05/2018.
 */

public interface AddRouteView {
    void showInput();
    void hideInput();
    void showProgress();
    void hideProgress();

    void routeAdded();
    void routeNotAdded();
}
