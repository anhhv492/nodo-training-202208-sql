package edu.poly.entity;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
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
    @Generated(n)
    private int id;

    private int maBD;
    private String ten;
    private String sdt;
    private String ngaySinh;
    private String ngayTao;
    private String hang;
}