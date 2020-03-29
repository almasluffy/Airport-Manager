package cz.muni.fi.pa165.airportmanager.dao;

import cz.muni.fi.pa165.airportmanager.entity.Airplane;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.ZonedDateTime;
import java.util.Collection;

/**
 * Implementation of AirplaneDao interface
 *
 * @author Tomáš Janíček
 */

@Repository
public class AirplaneDaoImpl implements AirplaneDao{

    @PersistenceContext
    private EntityManager em;

    @Override
    public Airplane findFreePlaneInTimeInterval(ZonedDateTime from, ZonedDateTime to) {
//        ArrayList<Airplane> allAirplanes = (ArrayList<Airplane>) this.findAll();
//        allAirplanes.stream()
//                .filter(
//                        airplane -> airplane.getFlight()
//                )
        return null;
    }

    @Override
    public Airplane findById(Long id) {
        return em.find(Airplane.class, id);
    }

    @Override
    public Collection<Airplane> findAll() {
        return em.createQuery(
                "SELECT airplane FROM Airplane airplane", Airplane.class
        ).getResultList();
    }

    @Override
    public Long insertAirplane(Airplane airplane) {
        em.persist(airplane);
        return airplane.getId();
    }

    @Override
    public void updateAirplane(Airplane airplane) {
        em.merge(airplane);
    }

    @Override
    public void deleteAirplane(Airplane airplane) {
        em.remove(airplane);
    }
}
