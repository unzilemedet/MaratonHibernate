package org.example.entitiy;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class SiparisKalemi {
    int total;
    int masstotal;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    private Urun urun;

    private int adet;

    public SiparisKalemi(Urun urun, int adet) {
        this.urun = urun;
        this.adet = adet;

    }

    @Override
    public String toString() {
        return "SiparisKalemi{" +
                "total=" + total +
                ", masstotal=" + masstotal +
                ", id=" + id +
                ", urun=" + urun +
                ", adet=" + adet +
                '}';
    }
}
