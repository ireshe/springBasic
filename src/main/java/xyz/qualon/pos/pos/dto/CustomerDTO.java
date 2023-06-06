package xyz.qualon.pos.pos.dto;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import java.util.ArrayList;

public class CustomerDTO {
    private int customerId;
    private String customerName;
    private String customerAddress;
    private ArrayList customerNumber;
    private String nic;
    private double customerSalary;
    private boolean isActive;

    public CustomerDTO() {
    }

    public CustomerDTO(int customerId, String customerName, String customerAddress, ArrayList customerNumber, String nic, double customerSalary, boolean isActive) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerNumber = customerNumber;
        this.nic = nic;
        this.customerSalary = customerSalary;
        this.isActive = isActive;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public ArrayList getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(ArrayList customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public double getCustomerSalary() {
        return customerSalary;
    }

    public void setCustomerSalary(double customerSalary) {
        this.customerSalary = customerSalary;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", customerNumber=" + customerNumber +
                ", nic='" + nic + '\'' +
                ", customerSalary=" + customerSalary +
                ", isActive=" + isActive +
                '}';
    }
}
