package utp.pe.dw.finalex.model;

import jakarta.persistence.*;

@Entity
@Table(name = "comentario")
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idcomentario;
    private String titulocom;
    private String resenacom;
    private String fechacom;

    public Comentario() {
    }

    public Comentario(Long idcomentario, String titulocom, String resenacom, String fechacom) {
        this.idcomentario = idcomentario;
        this.titulocom = titulocom;
        this.resenacom = resenacom;
        this.fechacom = fechacom;
    }

    public Long getIdcomentario() {
        return idcomentario;
    }

    public void setIdcomentario(Long idcomentario) {
        this.idcomentario = idcomentario;
    }

    public String getTitulocom() {
        return titulocom;
    }

    public void setTitulocom(String titulocom) {
        this.titulocom = titulocom;
    }

    public String getResenacom() {
        return resenacom;
    }

    public void setResenacom(String resenacom) {
        this.resenacom = resenacom;
    }

    public String getFechacom() {
        return fechacom;
    }

    public void setFechacom(String fechacom) {
        this.fechacom = fechacom;
    }

}
