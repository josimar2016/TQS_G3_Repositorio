package pt.ua.encontreja.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pt.ua.encontreja.entity.Service;

@Stateless
public class ServiceDAO extends AbstractFacade<Service> {

    @PersistenceContext(unitName = "encontreja")
    private EntityManager em;

    public ServiceDAO() {
        super(Service.class);
    }

    public ServiceDAO(Class<Service> entityClass) {
        super(entityClass);
    }

    public List<Service> getAllServices() {
        return super.findAll();
    }

    public int editService(Service service) {
        super.edit(service);
        return 1;
    }

    public Service getService(int id) {
        return super.find(id);
    }

    public int deleteService(int id) {
        Service service = getService(id);

        if (service == null) {
            return -1;
        }
        return 1;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
