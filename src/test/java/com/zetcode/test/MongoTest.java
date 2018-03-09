package com.zetcode.test;

import com.zetcode.bean.Country;
import com.zetcode.repository.CountryRepository;
import java.util.List;
import static junit.framework.TestCase.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MongoTest {

    @Autowired
    CountryRepository repository;

    Country china, india, usa, indonesia, brazil, pakistan;

    static final int NUMBER_OF_COUNTRIES = 6;

    @Before
    public void init() {

        repository.deleteAll();

        this.china = repository.save(new Country("China", 1382050000));
        this.india = repository.save(new Country("India", 1313210000));
        this.usa = repository.save(new Country("USA", 324666000));
        this.indonesia = repository.save(new Country("Indonesia", 260581000));
        this.brazil = repository.save(new Country("Brazil", 207221000));
        this.pakistan = repository.save(new Country("Pakistan", 196626000));
    }

    @Test
    public void countAllCountries() {

        List<Country> countries = repository.findAll();
        assertEquals(NUMBER_OF_COUNTRIES, countries.size());
    }

    @Test
    public void countOneCountry() {

        Example<Country> example = Example.of(new Country("China", 1382050000));

        assertThat(repository.count(example)).isEqualTo(1L);
    }

    @Test
    public void setsIdOnSave() {

        Country nigeria = repository.save(new Country("Nigeria", 186988000));
        assertThat(nigeria.getId()).isNotNull();
    }

    @Test
    public void findOneCountry() {

        Example<Country> example = Example.of(new Country("India", 1313210000));

        Country country = repository.findOne(example);
        assertThat(country.getName()).isEqualTo("India");
    }
}