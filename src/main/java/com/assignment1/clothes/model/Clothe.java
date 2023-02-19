package com.assignment1.clothes.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Table
@Data
@Builder
public class Clothe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String name;

    @NotNull
    @Min(10)
    @Max(500)
    private Double price;

    @NotBlank
    private String yearOfCreation;

    @NotBlank
    private String brand;

    public enum Brand {
        BALENCIAGA("Balenciaga"),
        STONE_ISLAND("Stone Island"),
        DIOR("Dior");

        private String name;

        private Brand(String name) {
            this.name = name;
        }

        public String getBrandName() {
            return name;
        }
    }
}
