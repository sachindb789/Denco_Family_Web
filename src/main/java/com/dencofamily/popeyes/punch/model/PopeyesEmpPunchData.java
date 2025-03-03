package com.dencofamily.popeyes.punch.model;

import java.sql.Date;
import java.sql.Timestamp;

public class PopeyesEmpPunchData {
    private int id;
    private String storeName;
    private Date reportDate;
    private String empName;
    private String empDesignation;
    private String exportId;
    private Integer empNumber; // Nullable field
    private Date workDate;
    private String inTime;
    private String outTime;
    private String breakInTime;
    private String breakOutTime;
    private Integer pdBreakMin;
    private Integer unpdBreakMin;
    private Double rate;
    private Double regHrs;
    private Double regPay;
    private Double otRate;
    private Double otHours;
    private Double otPay;
    private Double totalHrs;
    private Double totalPay;
    private Double ccTips;
    private Double declTips;
    private Double tippableSales;
    private Double tipSales008;
    private Integer status;
    private String filename;
    private Timestamp createdAt;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpDesignation() {
        return empDesignation;
    }

    public void setEmpDesignation(String empDesignation) {
        this.empDesignation = empDesignation;
    }

    public String getExportId() {
        return exportId;
    }

    public void setExportId(String exportId) {
        this.exportId = exportId;
    }

    public Integer getEmpNumber() {
        return empNumber;
    }

    public void setEmpNumber(Integer empNumber) {
        this.empNumber = empNumber;
    }

    public Date getWorkDate() {
        return workDate;
    }

    public void setWorkDate(Date workDate) {
        this.workDate = workDate;
    }

    public String getInTime() {
        return inTime;
    }

    public void setInTime(String inTime) {
        this.inTime = inTime;
    }

    public String getOutTime() {
        return outTime;
    }

    public void setOutTime(String outTime) {
        this.outTime = outTime;
    }

    public String getBreakInTime() {
        return breakInTime;
    }

    public void setBreakInTime(String breakInTime) {
        this.breakInTime = breakInTime;
    }

    public String getBreakOutTime() {
        return breakOutTime;
    }

    public void setBreakOutTime(String breakOutTime) {
        this.breakOutTime = breakOutTime;
    }

    public Integer getPdBreakMin() {
        return pdBreakMin;
    }

    public void setPdBreakMin(Integer pdBreakMin) {
        this.pdBreakMin = pdBreakMin;
    }

    public Integer getUnpdBreakMin() {
        return unpdBreakMin;
    }

    public void setUnpdBreakMin(Integer unpdBreakMin) {
        this.unpdBreakMin = unpdBreakMin;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Double getRegHrs() {
        return regHrs;
    }

    public void setRegHrs(Double regHrs) {
        this.regHrs = regHrs;
    }

    public Double getRegPay() {
        return regPay;
    }

    public void setRegPay(Double regPay) {
        this.regPay = regPay;
    }

    public Double getOtRate() {
        return otRate;
    }

    public void setOtRate(Double otRate) {
        this.otRate = otRate;
    }

    public Double getOtHours() {
        return otHours;
    }

    public void setOtHours(Double otHours) {
        this.otHours = otHours;
    }

    public Double getOtPay() {
        return otPay;
    }

    public void setOtPay(Double otPay) {
        this.otPay = otPay;
    }

    public Double getTotalHrs() {
        return totalHrs;
    }

    public void setTotalHrs(Double totalHrs) {
        this.totalHrs = totalHrs;
    }

    public Double getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(Double totalPay) {
        this.totalPay = totalPay;
    }

    public Double getCcTips() {
        return ccTips;
    }

    public void setCcTips(Double ccTips) {
        this.ccTips = ccTips;
    }

    public Double getDeclTips() {
        return declTips;
    }

    public void setDeclTips(Double declTips) {
        this.declTips = declTips;
    }

    public Double getTippableSales() {
        return tippableSales;
    }

    public void setTippableSales(Double tippableSales) {
        this.tippableSales = tippableSales;
    }

    public Double getTipSales008() {
        return tipSales008;
    }

    public void setTipSales008(Double tipSales008) {
        this.tipSales008 = tipSales008;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
