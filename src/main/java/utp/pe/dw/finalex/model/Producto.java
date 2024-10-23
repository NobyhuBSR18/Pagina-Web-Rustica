package utp.pe.dw.finalex.model;


import jakarta.persistence.*;

@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idproducto;
    private String codigopro;
    private String nompro;
    private Double precpro;
    private Integer canpro;
    private String urlpro;

    @ManyToOne
    @JoinColumn(name = "codcat")
    private Categoria categoria;

    public Producto() {
    }

    public Producto(Long idproducto, String codigopro, String nompro, Double precpro, Integer canpro, String urlpro, Categoria categoria) {
        this.idproducto = idproducto;
        this.codigopro = codigopro;
        this.nompro = nompro;
        this.precpro = precpro;
        this.canpro = canpro;
        this.urlpro = urlpro;
        this.categoria = categoria;
    }

    public Long getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Long idproducto) {
        this.idproducto = idproducto;
    }

    public String getCodigopro() {
        return codigopro;
    }

    public void setCodigopro(String codigopro) {
        this.codigopro = codigopro;
    }

    public String getNompro() {
        return nompro;
    }

    public void setNompro(String nompro) {
        this.nompro = nompro;
    }

    public Double getPrecpro() {
        return precpro;
    }

    public void setPrecpro(Double precpro) {
        this.precpro = precpro;
    }

    public Integer getCanpro() {
        return canpro;
    }

    public void setCanpro(Integer canpro) {
        this.canpro = canpro;
    }

    public String getUrlpro() {
        return urlpro;
    }

    public void setUrlpro(String urlpro) {
        this.urlpro = urlpro;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

}
