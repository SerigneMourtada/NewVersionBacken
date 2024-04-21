package com.example.gestionvaccinationtestfirst.repository;

import com.example.gestionvaccinationtestfirst.model.Carnet;
import org.hibernate.annotations.processing.SQL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import static javax.swing.text.html.HTML.Tag.SELECT;
import static org.hibernate.FetchMode.JOIN;
import static org.hibernate.grammars.hql.HqlParser.FROM;
import static org.hibernate.sql.ast.Clause.WHERE;

@Repository
public interface CarnetRepository extends JpaRepository<Carnet,Long> {

    @Query("select c from Carnet c where c.parent.id = ?1")
    Carnet findByParent_Id(Long id);

    //@Query("select c from Carnet c where c.parent.id = ?1 ")
    List<Carnet> findCarnetByParent_Id(Long id);

   @SQL(value = "SELECT * FROM carnet c " +
          "JOIN enfant e " +
           "JOIN utilisateur u WHERE c.parent_id = u.id and c.enfant_id = e.id and u.id = ?")
  Carnet findCarnetById(Long parentId);
}
