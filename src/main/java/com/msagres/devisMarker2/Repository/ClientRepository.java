package com.msagres.devisMarker2.Repository;

import com.msagres.devisMarker2.Model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, UUID> {
}
