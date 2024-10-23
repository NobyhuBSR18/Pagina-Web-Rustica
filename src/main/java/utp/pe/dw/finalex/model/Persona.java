package utp.pe.dw.finalex.model;

import jakarta.persistence.*;

@Entity
@Table(name = "persona")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idpersona;
    private String nomper;
    private String apeper;

    @ManyToOne
    @JoinColumn(name = "codcar")
    private Cargo cargo;

    public Persona() {
    }

    public Persona(Long idpersona, String nomper, String apeper, Cargo cargo) {
        this.idpersona = idpersona;
        this.nomper = nomper;
        this.apeper = apeper;
        this.cargo = cargo;
    }

    public Long getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(Long idpersona) {
        this.idpersona = idpersona;
    }

    public String getNomper() {
        return nomper;
    }

    public void setNomper(String nomper) {
        this.nomper = nomper;
    }

    public String getApeper() {
        return apeper;
    }

    public void setApeper(String apeper) {
        this.apeper = apeper;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

}
