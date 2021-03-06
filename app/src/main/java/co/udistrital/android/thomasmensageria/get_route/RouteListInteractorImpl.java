package co.udistrital.android.thomasmensageria.get_route;

/**
 * Created by wisuarez on 08/03/2018.
 */

public class RouteListInteractorImpl implements RouteListInteractor {

    RouteListRepository repository;

    public RouteListInteractorImpl() {
        this.repository = new RouteListRepositoryImpl();
    }

    @Override
    public void removeRoute(String idRoute) {
        repository.removeRoute(idRoute);
    }

    @Override
    public void addRoute(String idRoute) {
        repository.addRoute(idRoute);
    }

    @Override
    public void approveRoute(String id_route, boolean approve) {
        repository.approveRoute(id_route, approve);
    }

    @Override
    public void destroyListener() {
        repository.destroyListener();
    }

    @Override
    public void unsubscribe() {
        repository.unSubscribeToRouteListEvents();
    }

    @Override
    public void subscribe() {
        repository.subscribeToRouteListEvents();
    }
}
