package de.assessment.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import de.assessment.model.entity.Provider;
import de.assessment.model.repository.ProviderRepository;
import de.assessment.payload.SearchParameterResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Marc on 2/2/2019.
 */
@RestController
@RequestMapping("/provider")
public class ProviderController {
    private final ProviderRepository providerRepository;

    @Autowired
    public ProviderController(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    @GetMapping
    public String getProviderList(@RequestParam("max_discharges") Optional<Integer> maxDischarges,
                                          @RequestParam("min_discharges") Optional<Integer> minDischarges,
                                          @RequestParam("max_average_covered_charges") Optional<BigDecimal> maxAverageCoveredCharges,
                                          @RequestParam("min_average_covered_charges") Optional<BigDecimal> minAverageCoveredCharges,
                                          @RequestParam("max_average_medicare_payments") Optional<BigDecimal> maxAverageMedicarePayments,
                                          @RequestParam("min_average_medicare_payments") Optional<BigDecimal> minAverageMedicarePayments,
                                          @RequestParam("state") Optional<String> state,
                                          @RequestParam("required_fields") Optional<String> requiredFields) throws JsonProcessingException {
        List<Provider> providerList = providerRepository.findAll(maxDischarges, minDischarges, maxAverageCoveredCharges, minAverageCoveredCharges, maxAverageMedicarePayments, minAverageMedicarePayments, state)
                .collect(Collectors.toList());
        ObjectMapper objectMapper = new ObjectMapper();
        String json = "";
        if(requiredFields.isPresent()){
            String[] fields = requiredFields.get().split("[,]");

            FilterProvider filters = new SimpleFilterProvider().addFilter("myFilter",
                    SimpleBeanPropertyFilter.filterOutAllExcept(new HashSet<String>(Arrays
                            .asList(fields))));

            json = objectMapper.setFilterProvider(filters).writeValueAsString(providerList);
        } else {
            SimpleFilterProvider fp = new SimpleFilterProvider().setFailOnUnknownId(false);
            json = objectMapper.setFilterProvider(fp).writeValueAsString(providerList);
        }
        return json;
    }

    @GetMapping("/searchParameters")
    public ResponseEntity<SearchParameterResponse> getProviderSearchParameters(){
        long startTime = System.currentTimeMillis();
        SearchParameterResponse searchParameterResponse = new SearchParameterResponse();
        searchParameterResponse.setMaxDischarges(providerRepository.getMaxDischarges());
        searchParameterResponse.setMinDischarges(providerRepository.getMinDischarges());
        searchParameterResponse.setMaxAverageCoveredCharges(providerRepository.getMaxAverageCoveredCharges());
        searchParameterResponse.setMinAverageCoveredCharges(providerRepository.getMinAverageCoveredCharges());
        searchParameterResponse.setMaxAverageMedicareCharges(providerRepository.getMaxAverageMedicarePayments());
        searchParameterResponse.setMinAverageMedicareCharges(providerRepository.getMinAverageMedicarePayments());
        searchParameterResponse.setStates(providerRepository.getStates());
        System.out.println("Time taken: " + (System.currentTimeMillis() - startTime));
        return ResponseEntity.ok(searchParameterResponse);
    }
}
