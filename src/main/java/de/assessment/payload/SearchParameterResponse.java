package de.assessment.payload;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Marc on 2/7/2019.
 */
public class SearchParameterResponse {
    private int minDischarges;
    private int maxDischarges;
    private BigDecimal minAverageCoveredCharges;
    private BigDecimal maxAverageCoveredCharges;
    private BigDecimal minAverageMedicareCharges;
    private BigDecimal maxAverageMedicareCharges;
    private List<String> states;

    public int getMinDischarges() {
        return minDischarges;
    }

    public void setMinDischarges(int minDischarges) {
        this.minDischarges = minDischarges;
    }

    public int getMaxDischarges() {
        return maxDischarges;
    }

    public void setMaxDischarges(int maxDischarges) {
        this.maxDischarges = maxDischarges;
    }

    public BigDecimal getMinAverageCoveredCharges() {
        return minAverageCoveredCharges;
    }

    public void setMinAverageCoveredCharges(BigDecimal minAverageCoveredCharges) {
        this.minAverageCoveredCharges = minAverageCoveredCharges;
    }

    public BigDecimal getMaxAverageCoveredCharges() {
        return maxAverageCoveredCharges;
    }

    public void setMaxAverageCoveredCharges(BigDecimal maxAverageCoveredCharges) {
        this.maxAverageCoveredCharges = maxAverageCoveredCharges;
    }

    public BigDecimal getMinAverageMedicareCharges() {
        return minAverageMedicareCharges;
    }

    public void setMinAverageMedicareCharges(BigDecimal minAverageMedicareCharges) {
        this.minAverageMedicareCharges = minAverageMedicareCharges;
    }

    public BigDecimal getMaxAverageMedicareCharges() {
        return maxAverageMedicareCharges;
    }

    public void setMaxAverageMedicareCharges(BigDecimal maxAverageMedicareCharges) {
        this.maxAverageMedicareCharges = maxAverageMedicareCharges;
    }

    public List<String> getStates() {
        return states;
    }

    public void setStates(List<String> states) {
        this.states = states;
    }
}
