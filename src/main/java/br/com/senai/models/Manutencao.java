package br.com.senai.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
@Entity
@Table(name="descrição")
@EqualsAndHashCode(of="id")
public class Manutencao implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false)
        private String name;

        @Column(nullable = false)
        private Double price;

        @Getter
        @Setter
        @Entity
        @Table(name = "descricao")
        @EqualsAndHashCode(of = "id")
        public class Descricao implements Serializable {
            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            private Long id;

            @Column(nullable = false)
            private String text;

            @Getter
            @Setter
            @Entity
            @Table(name = "data_agendamento")
            @EqualsAndHashCode(of = "id")
            public class Data_Agendamento implements Serializable {
                @Id
                @GeneratedValue(strategy = GenerationType.IDENTITY)
                private Long id;

                @Column(nullable = false)
                private String text;
            }
        }
    }

