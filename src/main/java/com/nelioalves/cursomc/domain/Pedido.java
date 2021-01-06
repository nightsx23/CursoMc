package com.nelioalves.cursomc.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
public class Pedido implements Serializable {
  public static final long serivalVersionUID = 1L;

  public Pedido(Integer id, Date instante, Cliente cliente, Endereco enderecoEntrega) {
    this.id = id;
    this.instante = instante;
    this.cliente = cliente;
    this.enderecoEntrega = enderecoEntrega;
  }

  public Pedido() {
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private Date instante;

  @OneToOne(cascade = CascadeType.ALL, mappedBy = "pedido")
  private Pagamento pagamento;

  @ManyToOne
  @JoinColumn(name = "cliente_id")
  private Cliente cliente;

  @ManyToOne
  @JoinColumn(name = "endereco_entrega_id")
  private Endereco enderecoEntrega;

}
