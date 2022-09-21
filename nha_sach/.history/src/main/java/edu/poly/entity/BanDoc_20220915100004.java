package edu.poly.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="bandoc")
public class BanDoc{
    @Column(name="IDBD")
    @GeneratedValue(va)
    private int id;

    private int maBD;
    private String ten;
    private String sdt;
    private String ngaySinh;
    private String ngayTao;
    private String hang;
}