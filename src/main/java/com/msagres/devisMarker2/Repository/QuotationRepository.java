package com.msagres.devisMarker2.Repository;

import com.msagres.devisMarker2.Model.Quotation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface QuotationRepository extends JpaRepository<Quotation, UUID> {
}
