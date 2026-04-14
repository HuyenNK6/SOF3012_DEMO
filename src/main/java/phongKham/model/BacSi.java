package phongKham.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity //Đánh dấu class này là 1 bảng trong database
@Table(name = "BacSi") //Map class -> bảng BacSi
public class BacSi {
    @Id //Đánh dấu đây là khóa chính
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Tự động tăng ID, Không cần set id khi insert
    private Integer id;
    @Column(name = "ten")//@Column dùng để đặt tên cột trong DB -> Map:   field ten <-> cột ten
    private String ten;
    @Column(name = "diaChi")
    private String diaChi;
    @Column(name = "luong")
    private Float luong;

    @ManyToOne //Quan hệ: Nhiều bác sĩ – 1 phòng khám
    @JoinColumn(name = "idPhongKham", referencedColumnName = "id")
    //Cột khóa ngoại idPhongKham trong bảng BacSi -> Tham chiếu tới cột id của bảng PhongKham
    private PhongKham phongKham;
}
