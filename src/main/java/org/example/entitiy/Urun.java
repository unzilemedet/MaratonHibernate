package org.example.entitiy;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
@Data
@NoArgsConstructor
public class Urun {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    private String urunAdi;
    private Integer fiyat;


    public Urun(String urunAdi, Integer fiyat) {
        this.urunAdi = urunAdi;
        this.fiyat = fiyat;
    }

    @Override
    public String toString() {

        return "Urun{" +
                "id=" + id +
                ", urunAdi='" + urunAdi + '\'' +
                ", fiyat=" + fiyat +
                '}';

    }

}
