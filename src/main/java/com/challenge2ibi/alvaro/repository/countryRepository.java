package com.challenge2ibi.alvaro.repository;

import com.challenge2ibi.alvaro.model.country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface countryRepository extends JpaRepository<country, Long> {
    @Override
    Optional<country> findById(Long id);

}
