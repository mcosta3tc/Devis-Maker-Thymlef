package com.msagres.devisMarker2.Repository;

import com.msagres.devisMarker2.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}
