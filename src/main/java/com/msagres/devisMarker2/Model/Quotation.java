package com.msagres.devisMarker2.Model;

import com.msagres.devisMarker2.utils.PostgresIdUUIDType;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@TypeDefs({@TypeDef(name = "pg-id-uuid", typeClass = PostgresIdUUIDType.class)})
public class Quotation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Type(type = "pg-id-uuid", parameters = @org.hibernate.annotations.Parameter(name = "column", value = "id"))
    private UUID id;

    @Column(nullable = false)
    private String product;

    @Column(nullable = false)
    private Float price;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
}
