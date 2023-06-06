package xyz.qualon.pos.pos.entity;

import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.vladmihalcea.hibernate.type.json.JsonType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;

@Entity
@Table(name = "customer")
@TypeDefs({
        @TypeDef(name = "json",typeClass = JsonType.class)
})
public class Customer {

    @Id
    @Column(name = "customer_id",length = 45)
    private int customerId;

    @Column(name = "customer_Name",length = 100,nullable = false)
    private String customerName;

    @Column(name = "customer_address",length = 255)
    private String customerAddress;

    @Type(type="json")
    @Column(name = "customer_number",columnDefinition = "json",length = 10)
    private ArrayList customerNumber;

    @Column(name = "nic",length = 12)
    private String nic;

    @Column(name = "customer_salary",length = 15)
    private double customerSalary;

    @Column(name = "active_status",columnDefinition = "TINYINT default 0")
    private boolean isActive;

    public Customer() {
    }

    public Customer(int customerId, String customerName, String customerAddress, ArrayList customerNumber, String nic, double customerSalary, boolean isActive) {
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
        return "Customer{" +
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