package com.react_eshop.reacteshop.api.dao.respository;

import com.react_eshop.reacteshop.api.dao.model.Produkt;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Produkt, Long> {

    Produkt findByproduktId(Integer id);

    List<Produkt> findAll(Sort s);

    @Query("select p from Produkt p JOIN Atribut a on p.produktId = a.produktId where a.cena<= ?1")
    List<Produkt> findAll(Sort s, Float priceRange);

    @Query("select p from Produkt p JOIN Atribut a on p.produktId = a.produktId where a.cena<= ?1 order by a.cena ASC")
    List<Produkt> findAllValueASC(Float priceRange);

    @Query("select p from Produkt p JOIN Atribut a on p.produktId = a.produktId where a.cena<= ?1 order by a.cena DESC")
    List<Produkt> findAllValueDESC(Float priceRange);

    @Query("select p from Produkt p JOIN Atribut a on p.produktId = a.produktId where p.kategoria.kategoriaId = ?1  and a.cena<= ?2 ")
    List<Produkt> findByKategoriaId(Integer kategoriaId, Sort s, Float pricerange);

    @Query("select p from Produkt p  JOIN Atribut a on p.produktId = a.produktId where p.kategoria.kategoriaId = ?1 and a.cena<= ?2 order by a.cena ASC")
    List<Produkt> findByKategoriaIdValueASC(Integer kategoriaId, Float pricerange);

    @Query("select p from Produkt p JOIN Atribut a on p.produktId = a.produktId where p.kategoria.kategoriaId = ?1  and a.cena<= ?2 order by a.cena DESC")
    List<Produkt> findByKategoriaIdValueDESC(Integer kategoriaId, Float pricerange);

    @Query("select p from Produkt p JOIN Atribut a on p.produktId = a.produktId where " +
            "p.kategoria.kategoriaId = 5 OR p.kategoria.kategoriaId = 6 " +
            "OR p.kategoria.kategoriaId = 7 OR p.kategoria.kategoriaId = 8  and a.cena<= ?1 ")
    List<Produkt> findByCaj(Sort s, Float pricerange);

    @Query("select p from Produkt p  JOIN Atribut a on p.produktId = a.produktId where p.kategoria.kategoriaId = 5 OR p.kategoria.kategoriaId = 6 " +
            "            OR p.kategoria.kategoriaId = 7 OR p.kategoria.kategoriaId = 8 and a.cena<= ?1 order by a.cena ASC")
    List<Produkt> findByCajASC(Float pricerange);

    @Query(value = "select * from Produkt p order by p.pocet_objednani DESC LIMIT 6", nativeQuery = true)
    List<Produkt> findPopular();

    @Query(value = "select * from Produkt p order by p.datum_pridania DESC LIMIT 6", nativeQuery = true)
    List<Produkt> findNew();


//    @Query(value = "select * from Produkt p join Kategoria k on p.kategoria_id = k.kategoria_id and p.kategoria_id = ?1",
//            nativeQuery = true)
//    List<Produkt> findByKategoriaId(Integer kategoriaId);
}
