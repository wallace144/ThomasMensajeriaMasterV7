package co.udistrital.android.thomasmensageria.add_route;

import co.udistrital.android.thomasmensageria.add_route.events.AddRouteEvent;
import co.udistrital.android.thomasmensageria.add_route.ui.AddRouteFragmentDialog;
import co.udistrital.android.thomasmensageria.add_route.ui.AddRouteView;
import co.udistrital.android.thomasmensageria.delete_route.ui.DeleteRouteFragmentDialog;

/**
 * Created by ASUS on 13/05/2018.
 */

public class AddRoutePresenterImpl implements AddRoutePresenter {

    private AddRouteView view;

    public AddRoutePresenterImpl(AddRouteView addRouteView) {
        view = addRouteView;
    }



    @Override
    public void onShow() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void addRoute(String idRoute, String idAdmin) {

    }

    @Override
    public void onEventMaininThread(AddRouteEvent event) {

    }
}
