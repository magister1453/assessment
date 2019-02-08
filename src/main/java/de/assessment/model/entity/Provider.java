package de.assessment.model.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import de.assessment.controller.BigDecimalToCurrencyConverter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

/**
 * Created by Marc on 2/2/2019.
 */
@Entity
@JsonFilter("myFilter")
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private long id;
    @NotBlank
    @JsonIgnore
    private String drgDefinition;
    @NotBlank
    @JsonIgnore
    private String providerId;
    @NotBlank
    @JsonProperty("Provider Name")
    private String providerName;
    @NotBlank
    @JsonProperty("Provider Street Address")
    private String providerStreetAddress;
    @NotBlank
    @JsonProperty("Provider City")
    private String providerCity;
    @NotBlank
    @JsonProperty("Provider State")
    private String providerState;
    @NotBlank
    @JsonProperty("Provider Zip Code")
    private String providerZipCode;
    @NotBlank
    @JsonProperty("Hospital Referral Region Description")
    private String hospitalReferralRegionDescription;
    @Min(0)
    @JsonProperty("Total Discharges")
    private int totalDischarges;
    @DecimalMin("0.00")
    @JsonSerialize(converter = BigDecimalToCurrencyConverter.class)
    @JsonProperty("Average Covered Charges")
    private BigDecimal averageCoveredCharges;
    @DecimalMin("0.00")
    @JsonSerialize(converter = BigDecimalToCurrencyConverter.class)
    @JsonProperty("Average Total Payments")
    private BigDecimal averageTotalPayments;
    @DecimalMin("0.00")
    @JsonSerialize(converter = BigDecimalToCurrencyConverter.class)
    @JsonProperty("Average Medicare Payments")
    private BigDecimal averageMedicarePayments;

    public Provider(){};

    public String getDrgDefinition() {
        return drgDefinition;
    }

    public void setDrgDefinition(String drgDefinition) {
        this.drgDefinition = drgDefinition;
    }

    public Provider withDrgDefinition(String drgDefinition){
        this.drgDefinition = drgDefinition;
        return this;
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public Provider withProviderId(String providerId){
        this.providerId = providerId;
        return this;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public Provider withProviderName(String providerName){
        this.providerName = providerName;
        return this;
    }

    public String getProviderStreetAddress() {
        return providerStreetAddress;
    }

    public void setProviderStreetAddress(String providerStreetAddress) {
        this.providerStreetAddress = providerStreetAddress;
    }

    public Provider withProviderStreetAddress(String providerStreetAddress){
        this.providerStreetAddress = providerStreetAddress;
        return this;
    }

    public String getProviderCity() {
        return providerCity;
    }

    public void setProviderCity(String providerCity) {
        this.providerCity = providerCity;
    }

    public Provider withProviderCity(String providerCity){
        this.providerCity = providerCity;
        return this;
    }

    public String getProviderState() {
        return providerState;
    }

    public void setProviderState(String providerState) {
        this.providerState = providerState;
    }

    public Provider withProviderState(String providerState){
        this.providerState = providerState;
        return this;
    }

    public String getProviderZipCode() {
        return providerZipCode;
    }

    public void setProviderZipCode(String providerZipCode) {
        this.providerZipCode = providerZipCode;
    }

    public Provider withProviderZipCode(String providerZipCode){
        this.providerZipCode = providerZipCode;
        return this;
    }

    public String getHospitalReferralRegionDescription() {
        return hospitalReferralRegionDescription;
    }

    public void setHospitalReferralRegionDescription(String hospitalReferralRegionDescription) {
        this.hospitalReferralRegionDescription = hospitalReferralRegionDescription;
    }

    public Provider withHospitalReferralRegionDescription(String hospitalReferralRegionDescription){
        this.hospitalReferralRegionDescription = hospitalReferralRegionDescription;
        return this;
    }

    public int getTotalDischarges() {
        return totalDischarges;
    }

    public void setTotalDischarges(int totalDischarges) {
        this.totalDischarges = totalDischarges;
    }

    public Provider withTotalDischarges(int totalDischarges){
        this.totalDischarges = totalDischarges;
        return this;
    }

    public BigDecimal getAverageCoveredCharges() {
        return averageCoveredCharges;
    }

    public void setAverageCoveredCharges(BigDecimal averageCoveredCharges) {
        this.averageCoveredCharges = averageCoveredCharges;
    }

    public Provider withAverageCoveredCharges(BigDecimal averageCoveredCharges){
        this.averageCoveredCharges = averageCoveredCharges;
        return this;
    }

    public BigDecimal getAverageTotalPayments() {
        return averageTotalPayments;
    }

    public void setAverageTotalPayments(BigDecimal averageTotalPayments) {
        this.averageTotalPayments = averageTotalPayments;
    }

    public Provider withAverageTotalPayments(BigDecimal averageTotalPayments){
        this.averageTotalPayments = averageTotalPayments;
        return this;
    }

    public BigDecimal getAverageMedicarePayments() {
        return averageMedicarePayments;
    }

    public void setAverageMedicarePayments(BigDecimal averageMedicarePayments) {
        this.averageMedicarePayments = averageMedicarePayments;
    }

    public Provider withAverageMedicarePayments(BigDecimal averageMedicarePayments){
        this.averageMedicarePayments = averageMedicarePayments;
        return this;
    }
}
