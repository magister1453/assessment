package de.assessment.model;

import de.assessment.model.entity.Provider;
import de.assessment.model.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Marc on 2/2/2019.
 */
@Component
public class DataLoader implements ApplicationRunner {
    private final ProviderRepository providerRepository;

    @Autowired
    public DataLoader(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }
    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
//        try {
//            Files.lines(Paths.get("Inpatient_Prospective_Payment_System__IPPS__Provider_Summary_for_the_Top_100_Diagnosis-Related_Groups__DRG__-_FY2011.csv"))
//                    .forEach(s -> {
//                        String[] values = s.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
//                        providerRepository.save(
//                                new Provider().withDrgDefinition(values[0])
//                                .withProviderId(values[1])
//                                .withProviderName(values[2])
//                                .withProviderStreetAddress(values[3])
//                                .withProviderCity(values[4])
//                                .withProviderState(values[5])
//                                .withProviderZipCode(values[6])
//                                .withHospitalReferralRegionDescription(values[7])
//                                .withTotalDischarges(Integer.parseInt(values[8]))
//                                .withAverageCoveredCharges(new BigDecimal(values[9].substring(1)).setScale(2, RoundingMode.HALF_UP))
//                                .withAverageTotalPayments(new BigDecimal(values[10].substring(1)).setScale(2, RoundingMode.HALF_UP))
//                                .withAverageMedicarePayments(new BigDecimal(values[11].substring(1)).setScale(2, RoundingMode.HALF_UP))
//                        );
//                    });
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
