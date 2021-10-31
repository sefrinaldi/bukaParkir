package com.bukaParkir.common.auditable;

import lombok.Data;

import javax.persistence.*;

@MappedSuperclass
@Data
public class ModelBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @Column
    private Long id;
}
