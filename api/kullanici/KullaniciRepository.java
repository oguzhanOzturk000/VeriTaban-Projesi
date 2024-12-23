package com.oguzhan.api.kullanici;

import org.springframework.data.repository.ListCrudRepository;

public interface KullaniciRepository extends ListCrudRepository<kullanici , Integer> {
    kullanici findBymail(String mail);

}
