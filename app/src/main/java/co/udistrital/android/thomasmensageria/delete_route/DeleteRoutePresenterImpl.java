package co.udistrital.android.thomasmensageria.delete_route;

import co.udistrital.android.thomasmensageria.delete_route.events.DeleteRouteEvent;
import co.udistrital.android.thomasmensageria.delete_route.ui.DeleteRouteView;


/**
 * Created by ASUS on 14/05/2018.
 */

public class DeleteRoutePresenterImpl implements DeleteRoutePresenter {

    private DeleteRouteView view;

    public DeleteRoutePresenterImpl(DeleteRouteView routeView) {
        view = routeView;
    }

    @Override
    public void onShow() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void deleteRoute(String idRoute, String idAdmin) {

    }

    @Override
    public void onEventMaininThread(DeleteRouteEvent event) {

    }
}
