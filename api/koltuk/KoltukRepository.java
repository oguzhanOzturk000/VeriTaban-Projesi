package com.oguzhan.api.koltuk;

import org.springframework.data.repository.ListCrudRepository;
import java.util.List;

public interface KoltukRepository extends ListCrudRepository<koltuk , Integer> {
    List<koltuk> findAllBySalonid(int salonid);
}
