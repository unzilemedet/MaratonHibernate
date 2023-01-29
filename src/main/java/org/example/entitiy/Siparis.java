package org.example.entitiy;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Siparis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Musteri musteri;

    @OneToMany (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<SiparisKalemi> siparisKalemi;

    public Siparis(Musteri musteri, List<SiparisKalemi> siparisKalemi) {
        this.musteri = musteri;
        this.siparisKalemi = siparisKalemi;
    }

    public Siparis(Integer id, Musteri musteri, List<SiparisKalemi> siparisKalemi) {
        this.id = id;
        this.musteri = musteri;
        this.siparisKalemi = siparisKalemi;
    }

    @Override
    public String toString() {

        return "Siparis " + "ID:" + id + " " + "Müşteri: " + musteri.getIsim() +
                " " + musteri.getSoyad() +  " Musteri Id: " + id + "\n " + siparisKalemi + "Sipariş Toplam : " +  siparisKalemi  +"\n";
    }
}
