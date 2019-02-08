package de.assessment.model.customrepository;

import de.assessment.model.entity.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by Marc on 2/3/2019.
 */
@Repository
public class ProviderRepositoryImpl implements ProviderRepositoryCustom{

    private final EntityManager em;

    @Autowired
    public ProviderRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Stream<Provider> findAll(Optional<Integer> maxDischarges, Optional<Integer> minDischarges,
                                    Optional<BigDecimal> maxAverageCoveredCharges, Optional<BigDecimal> minAverageCoveredCharges,
                                    Optional<BigDecimal> maxAverageMedicarePayments, Optional<BigDecimal> minAverageMedicarePayments,
                                    Optional<String> state) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Provider> cq = cb.createQuery(Provider.class);

        Root<Provider> providerRoot = cq.from(Provider.class);
        List<Predicate> predicates = new ArrayList<>();

        minDischarges.ifPresent(integer -> predicates.add(cb.ge(providerRoot.get("totalDischarges"), integer)));
        maxDischarges.ifPresent(integer -> predicates.add(cb.le(providerRoot.get("totalDischarges"), integer)));
        maxAverageCoveredCharges.ifPresent(integer -> predicates.add(cb.le(providerRoot.get("averageCoveredCharges"), integer)));
        minAverageCoveredCharges.ifPresent(integer -> predicates.add(cb.ge(providerRoot.get("averageCoveredCharges"), integer)));
        maxAverageMedicarePayments.ifPresent(integer -> predicates.add(cb.le(providerRoot.get("averageMedicarePayments"), integer)));
        minAverageMedicarePayments.ifPresent(integer -> predicates.add(cb.ge(providerRoot.get("averageMedicarePayments"), integer)));
        state.ifPresent(s -> predicates.add(cb.equal(providerRoot.get("providerState"), s)));

        cq.where(predicates.toArray(new Predicate[0]));
        return em.createQuery(cq).getResultList().stream();

    }
}
