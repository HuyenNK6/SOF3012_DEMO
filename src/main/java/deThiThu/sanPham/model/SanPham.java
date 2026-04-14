package deThiThu.sanPham.model;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "san_pham")
public class SanPham {
    //[id]
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    //      ,[ma]
    @Column(name = "ma")
    private String ma;
    //      ,[ten]
    @Column(name = "ten")
    private String ten;
    //      ,[mota]
    @Column(name = "mota")
    private String moTa;
    //      ,[website]
    @Column(name = "website")
    private String website;
    //      ,[gia_ban]
    @Column(name = "gia_ban")
    private Double giaBan;
    //      ,[so_luong]
    @Column(name = "so_luong")
    private Integer soLuong;
    //      ,[id_loai_sp];
//    @Column(name = "ma")
//    private Integer idLoaiSp;
    @ManyToOne
    @JoinColumn(name = "id_loai_sp", referencedColumnName = "id")
    private LoaiSanPham loaiSanPham;
    //      ,[trang_thai];
    @Column(name = "trang_thai")
    private Integer trangThai;
}
