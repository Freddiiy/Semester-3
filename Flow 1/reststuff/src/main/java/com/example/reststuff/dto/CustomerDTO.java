package com.example.reststuff.dto;

import com.example.reststuff.entity.Customer;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class CustomerDTO {

    private Long id;
    private String first;
    private String last;

    public CustomerDTO(Long id, String first, String last) {
        this.id = id;
        this.first = first;
        this.last = last;
    }

    public CustomerDTO(String first, String last) {
        this.first = first;
        this.last = last;
    }

     public CustomerDTO(Customer customer) {
        if (customer.getId() != null) {
            this.id = customer.getId();
            this.first = customer.getFirstName();
            this.last = customer.getLastName();
        }
     }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "id=" + id +
                ", first='" + first + '\'' +
                ", last='" + last + '\'' +
                '}';
    }
}
