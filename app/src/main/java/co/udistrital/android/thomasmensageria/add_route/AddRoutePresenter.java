package co.udistrital.android.thomasmensageria.add_route;

import co.udistrital.android.thomasmensageria.add_route.events.AddRouteEvent;

/**
 * Created by wisuarez on 10/05/2018.
 */

public interface AddRoutePresenter {
    void onShow();
    void onDestroy();

    void addRoute(String idRoute, String idAdmin);
    void onEventMaininThread(AddRouteEvent event);


}
