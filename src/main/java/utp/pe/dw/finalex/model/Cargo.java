package utp.pe.dw.finalex.model;


import jakarta.persistence.*;

@Entity
@Table(name = "cargo")
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idcargo;
    private String nomcar;

    public Cargo() {
    }

    public Cargo(Long idcargo, String nomcar) {
        this.idcargo = idcargo;
        this.nomcar = nomcar;
    }

    public Long getIdcargo() {
        return idcargo;
    }

    public void setIdcargo(Long idcargo) {
        this.idcargo = idcargo;
    }

    public String getNomcar() {
        return nomcar;
    }

    public void setNomcar(String nomcar) {
        this.nomcar = nomcar;
    }

}
