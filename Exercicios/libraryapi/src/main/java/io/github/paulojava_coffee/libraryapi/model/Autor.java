/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.paulojava_coffee.libraryapi.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
//import jakarta.persistence.Transient;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 *
 * @author barbo
 */
@ToString(exclude = "livros")
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "autor", schema = "public")
@EntityListeners(AuditingEntityListener.class)
public class Autor {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @Column(name = "nacionalidade", length = 50, nullable = false)
    private String nacionalidade;
    
    @CreatedDate
    @Column(columnDefinition = "timestamp")
    private LocalDateTime dataCadastro;
    
    @LastModifiedDate
    @Column(columnDefinition = "timestamp")
    private LocalDateTime dataAtualizacao;
    
    //@Column(columnDefinition = "UUID")
    @JoinColumn
    @ManyToOne
    private  Usuario  usuario;
    

    @OneToMany(mappedBy = "autor", fetch = FetchType.LAZY
     //       cascade = CascadeType.ALL
    )
    //@Transient
    private List<Livro> livros;

    @Deprecated
    public Autor() {
        //PARA USO DO FRAMEWORK 
    }

}
