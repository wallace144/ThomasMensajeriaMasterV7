package co.udistrital.android.thomasmensageria.delete_route;

import co.udistrital.android.thomasmensageria.delete_route.events.DeleteRouteEvent;

/**
 * Created by ASUS on 14/05/2018.
 */

public interface DeleteRoutePresenter {
    void onShow();
    void onDestroy();

    void deleteRoute(String idRoute, String idAdmin);
    void onEventMaininThread(DeleteRouteEvent event);
}
