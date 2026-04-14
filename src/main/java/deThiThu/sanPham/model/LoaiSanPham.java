package deThiThu.sanPham.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "loai_sp")
public class LoaiSanPham
{
    //[id]
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //      ,[ma]
    @Column(name = "ma")
    private String ma;
    //      ,[ten]
    @Column(name = "ten")
    private String ten;
}
