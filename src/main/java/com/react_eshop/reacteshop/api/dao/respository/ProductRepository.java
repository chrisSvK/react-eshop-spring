package com.react_eshop.reacteshop.api.dao.respository;

import com.react_eshop.reacteshop.api.dao.model.Produkt;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Produkt, Long> {
//    List<Produkt> findAll(String column, String mode);

    //    @Query("select p from Produkt p order by :column")
    List<Produkt> findAll(Sort s);

    @Query("select p from Produkt p JOIN Atribut a on p.produktId = a.produktId order by a.cena ASC")
    List<Produkt> findAllValueASC();

    @Query("select p from Produkt p JOIN Atribut a on p.produktId = a.produktId order by a.cena DESC")
    List<Produkt> findAllValueDESC();

    @Query("select p from Produkt p where p.kategoria.kategoriaId = ?1")
    List<Produkt> findByKategoriaId(Integer kategoriaId, Sort s);

    @Query(value = "select * from Produkt p order by p.pocet_objednani DESC LIMIT 10", nativeQuery = true)
    List<Produkt> findPopular();

    @Query("select p from Produkt p  JOIN Atribut a on p.produktId = a.produktId where p.kategoria.kategoriaId = ?1 order by a.cena ASC")
    List<Produkt> findByKategoriaIdValueASC(Integer kategoriaId);

    @Query("select p from Produkt p JOIN Atribut a on p.produktId = a.produktId where p.kategoria.kategoriaId = ?1 order by a.cena DESC")
    List<Produkt> findByKategoriaIdValueDESC(Integer kategoriaId);

//    @Query(value = "select * from Produkt p join Kategoria k on p.kategoria_id = k.kategoria_id and p.kategoria_id = ?1",
//            nativeQuery = true)
//    List<Produkt> findByKategoriaId(Integer kategoriaId);
}
