package de.assessment.model.customrepository;

import de.assessment.model.entity.Provider;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by Marc on 2/3/2019.
 */
public interface ProviderRepositoryCustom {
    Stream<Provider> findAll(Optional<Integer> maxDischarges,
                             Optional<Integer> minDischarges,
                             Optional<BigDecimal> maxAverageCoveredCharges,
                             Optional<BigDecimal> minAverageCoveredCharges,
                             Optional<BigDecimal> maxAverageMedicarePayments,
                             Optional<BigDecimal> minAverageMedicarePayments,
                             Optional<String> state);
}
