package com.react_eshop.reacteshop.api.dao.respository;

import com.react_eshop.reacteshop.api.dao.model.Produkt;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Produkt, Long> {
    List<Produkt> findAll();

    @Query("select p from Produkt p where p.kategoria.kategoriaId = ?1")
    List<Produkt> findByKategoriaId(Integer kategoriaId);

    @Query(value="select * from Produkt p order by p.pocet_objednani DEC LIMIT 10", nativeQuery=true)
    List<Produkt> findPopular();

//    @Query(value = "select * from Produkt p join Kategoria k on p.kategoria_id = k.kategoria_id and p.kategoria_id = ?1",
//            nativeQuery = true)
//    List<Produkt> findByKategoriaId(Integer kategoriaId);
}
