package com.mana.spring.domain;

import javax.persistence.*;

@Entity
@Table(name = "taxrate")
public class TaxRate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "taxrate_id")
    private long taxRateId;

    @Column(name = "taxrate_location", nullable = false)
    private String taxRateLocation;

    @Column(name = "taxrate_percent", nullable = false)
    private double taxRatePercent;

    @Column(name = "taxrate_other_tax_percent", nullable = false)
    private double taxRateOtherTaxPercent;

    public TaxRate() {
    }

    public long getTaxRateId() {
        return taxRateId;
    }

    public void setTaxRateId(long taxRateId) {
        this.taxRateId = taxRateId;
    }

    public String getTaxRateLocation() {
        return taxRateLocation;
    }

    public void setTaxRateLocation(String taxRateLocation) {
        this.taxRateLocation = taxRateLocation;
    }

    public double getTaxRatePercent() {
        return taxRatePercent;
    }

    public void setTaxRatePercent(double taxRatePercent) {
        this.taxRatePercent = taxRatePercent;
    }

    public double getTaxRateOtherTaxPercent() {
        return taxRateOtherTaxPercent;
    }

    public void setTaxRateOtherTaxPercent(double taxRateOtherTaxPercent) {
        this.taxRateOtherTaxPercent = taxRateOtherTaxPercent;
    }


}

