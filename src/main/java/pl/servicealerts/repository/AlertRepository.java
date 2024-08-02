package pl.servicealerts.repository;

import lombok.extern.slf4j.Slf4j;
import pl.servicealerts.model.servicealerts.ServiceAlert;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Slf4j
public class AlertRepository {

    /**
     * Make this class available as a singleton
     */
    private static final AlertRepository singleton = new AlertRepository();

    private List<ServiceAlert> serviceAlertList = Collections.synchronizedList(new LinkedList<>());

    /**
     * Gets the singleton instance of this class.
     *
     * @return
     */
    public static AlertRepository getInstance() {
        return singleton;
    }

    /**
     * Constructor declared private to enforce only access to this singleton
     * class being getInstance()
     */
    private AlertRepository() {
    }

    /**
     * Add the alert to list.
     */

    public void addToAlertList(ServiceAlert alert) {
        log.info("Add to cache a service alert : {}", alert);
        serviceAlertList.add(alert);
    }

    public List<ServiceAlert> getServiceAlertsList() {
        return serviceAlertList;
    }

    public void cleanServiceAlertsList() {
        serviceAlertList.clear();
        log.info("List of alerts is cleared: {}", serviceAlertList.isEmpty());
    }
}
