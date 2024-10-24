package pe.com.cibertec.lp2_EF_CharquiYuriko.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_categoria")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class CategoriaEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_categoria;

    @Column(nullable = false)
    private String nombreCategoria;  
    
}
