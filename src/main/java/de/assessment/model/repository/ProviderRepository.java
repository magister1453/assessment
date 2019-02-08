package de.assessment.model.repository;

import de.assessment.model.customrepository.ProviderRepositoryCustom;
import de.assessment.model.entity.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

/**
 * Created by Marc on 2/2/2019.
 */
public interface ProviderRepository extends JpaRepository<Provider, Long>, ProviderRepositoryCustom {
    @Query("select max(p.totalDischarges) from Provider p")
    int getMaxDischarges();
    @Query("select min(p.totalDischarges) from Provider p")
    int getMinDischarges();
    @Query("select max(p.averageCoveredCharges) from Provider p")
    BigDecimal getMaxAverageCoveredCharges();
    @Query("select min(p.averageCoveredCharges) from Provider p")
    BigDecimal getMinAverageCoveredCharges();
    @Query("select max(p.averageMedicarePayments) from Provider p")
    BigDecimal getMaxAverageMedicarePayments();
    @Query("select min(p.averageMedicarePayments) from Provider p")
    BigDecimal getMinAverageMedicarePayments();
    @Query("select DISTINCT(p.providerState) from Provider p")
    List<String> getStates();
}
