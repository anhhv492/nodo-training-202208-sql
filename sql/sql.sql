create table HaVietAnh_NhaXuatBan(
    IDNXB number(4) not null primary key,
    maNXB varchar2(15) unique ,
    ten varchar2(50),
    trangThai int,
    diaChi varchar2(100),
    moTa varchar2(100)
);
CREATE SEQUENCE HaVietAnh_NhaXuatBan_SEQ
    MINVALUE 0
    START WITH 0
    INCREMENT BY 1
;
-- tac gia
create table HaVietAnh_TacGia(
    IDTG number(4) not null primary key,
    maTG varchar2(15) unique,
    ten varchar2(50),
    SDT varchar2(15),
    diaChi varchar2(100),
    moTa varchar2(100)
);
CREATE SEQUENCE HaVietAnh_TacGia_SEQ
    MINVALUE 0
    START WITH 0
    INCREMENT BY 1
;
-- bang sach
create table HaVietAnh_Sach(
    IDSach number(4) not null primary key,
    maSach varchar2(15) unique,
    ten varchar2(50),
    IDNXB number(4) not null,
    IDTG number(4) not null,
    chuDe varchar2(100),
    namXuatBan date,
    moTa varchar2(100),
    soLuongConLai int,
    soLuongDangMuon int,
    tongSoSach int,
    foreign key (IDNXB) references HaVietAnh_NhaXuatBan(IDNXB),
    foreign key (IDTG) references HaVietAnh_TacGia(IDTG)
);
CREATE SEQUENCE HaVietAnh_Sach_SEQ
    MINVALUE 0
    START WITH 0
    INCREMENT BY 1
;
-- ban doc
create table HaVietAnh_BanDoc(
    IDBD number(4) not null primary key,
    maBD varchar2(15) unique,
    ten varchar2(50),
    SDT varchar2(15),
    diaChi varchar2(100),
    ngaySinh date,
    ngayTao date,
    hang int
);
CREATE SEQUENCE HaVietAnh_BanDoc_SEQ
    MINVALUE 0
    START WITH 0
    INCREMENT BY 1
;

--muon sach
create table HaVietAnh_MuonSach(
    IDMS number(4) not null primary key,
    IDBD number(4) not null,
    IDSach number(4) not null,
    soLuong int,
    ngayMuon date,
    ngayTra date,
    trangThai int,
    ghiChu varchar2(100),
    foreign key (IDBD) references HaVietAnh_BanDoc(IDBD),
    foreign key (IDSach) references HaVietAnh_Sach(IDSach)
)
    PARTITION BY RANGE(ngayMuon)
(
    PARTITION ngayMuon_jan2022 VALUES LESS THAN(TO_DATE('2022/01/01','YYYY/MM/DD')),
    PARTITION ngayMuon_feb2022 VALUES LESS THAN(TO_DATE('2022/02/01','YYYY/MM/DD')),
    PARTITION ngayMuon_mar2022 VALUES LESS THAN(TO_DATE('2022/03/01','YYYY/MM/DD'))
);
CREATE SEQUENCE HaVietAnh_MuonSach_SEQ
    MINVALUE 0
    START WITH 0
    INCREMENT BY 1
;
CREATE INDEX HaVietAnh_MuonSach_idx_idBD ON HaVietAnh_MuonSach(IDBD);
CREATE INDEX HaVietAnh_MuonSach_idx_idSach ON HaVietAnh_MuonSach(IDSach);

-- insert bang nha xuat ban--------------------------------------------------
insert into HaVietAnh_NhaXuatBan(IDNXB, maNXB, ten, trangThai, diaChi, moTa)
VALUES (HaVietAnh_NhaXuatBan_SEQ.nextval,'NXB0001','vanhvs',0,'Trịnh Văn Bô, Hà Nội','Mô tả thứ nhất');
insert into HaVietAnh_NhaXuatBan(IDNXB, maNXB, ten, trangThai, diaChi, moTa)
VALUES (HaVietAnh_NhaXuatBan_SEQ.nextval,'NXB0002','vanhvs2',0,'Trịnh Văn Bô, Hà Nội 0','Mô tả thứ hai');
insert into HaVietAnh_NhaXuatBan(IDNXB, maNXB, ten, trangThai, diaChi, moTa)
VALUES (HaVietAnh_NhaXuatBan_SEQ.nextval,'NXB0003','vanhvs3',1,'Trịnh Văn Bô, Hà Nội 1','Mô tả thứ ba');
insert into HaVietAnh_NhaXuatBan(IDNXB, maNXB, ten, trangThai, diaChi, moTa)
VALUES (HaVietAnh_NhaXuatBan_SEQ.nextval,'NXB0004','vanhvs4',1,'Trịnh Văn Bô, Hà Nội 2','Mô tả thứ tư');
insert into HaVietAnh_NhaXuatBan(IDNXB, maNXB, ten, trangThai, diaChi, moTa)
VALUES (HaVietAnh_NhaXuatBan_SEQ.nextval,'NXB0005','vanhvs5',0,'123 Trịnh Văn Bô, Hà Nội 3','Mô tả thứ năm');
insert into HaVietAnh_NhaXuatBan(IDNXB, maNXB, ten, trangThai, diaChi, moTa)
VALUES (HaVietAnh_NhaXuatBan_SEQ.nextval,'NXB0006','vanhvs6',0,'132 Trịnh Văn Bô, Hà Nội','Mô tả thứ nhất');
insert into HaVietAnh_NhaXuatBan(IDNXB, maNXB, ten, trangThai, diaChi, moTa)
VALUES (HaVietAnh_NhaXuatBan_SEQ.nextval,'NXB0007','vanhvs7',0,'222 Trịnh Văn Bô, Hà Nội','Mô tả thứ nhất');

-- insert tac gia--------------------------------------------------
insert into HaVietAnh_TacGia(IDTG, maTG, ten, SDT, diaChi, moTa)
VALUES (HaVietAnh_TacGia_SEQ.nextval,'TG0001','Việt Anh Hạ','0984297473','Vĩnh Tường, Vĩnh Phúc 1','Mô tả 1');
insert into HaVietAnh_TacGia(IDTG, maTG, ten, SDT, diaChi, moTa)
VALUES (HaVietAnh_TacGia_SEQ.nextval,'TG0002','Hạ Anh Hạ','0984297444','Vĩnh Tường, Vĩnh Phúc 2','Mô tả 2');
insert into HaVietAnh_TacGia(IDTG, maTG, ten, SDT, diaChi, moTa)
VALUES (HaVietAnh_TacGia_SEQ.nextval,'TG0003','Anh Hạ','0984297123','Vĩnh Tường, Vĩnh Phúc 3','Mô tả 3');
insert into HaVietAnh_TacGia(IDTG, maTG, ten, SDT, diaChi, moTa)
VALUES (HaVietAnh_TacGia_SEQ.nextval,'TG0004','Hạ Anh','0984297321','Vĩnh Tường, Vĩnh Phúc 4','Mô tả 4');
insert into HaVietAnh_TacGia(IDTG, maTG, ten, SDT, diaChi, moTa)
VALUES (HaVietAnh_TacGia_SEQ.nextval,'TG0005','Hạ Việt Anh','0984297111','Vĩnh Tường, Vĩnh Phúc 5','Mô tả 5');

-- INSERT SACH--------------------------------------------------
insert into HaVietAnh_Sach (IDSach, maSach, ten, IDNXB,
                            IDTG, chuDe, namXuatBan, moTa,
                            soLuongConLai, soLuongDangMuon, tongSoSach)
values (HaVietAnh_Sach_SEQ.nextval,'S0001','Văn học',1,
        2,'Công nghệ thông tin',TO_DATE('2022/01/12','YYYY/MM/DD'),'Mô tả sách 1',
        200,50,420);
insert into HaVietAnh_Sach (IDSach, maSach, ten, IDNXB,
                            IDTG, chuDe, namXuatBan, moTa,
                            soLuongConLai, soLuongDangMuon, tongSoSach)
values (HaVietAnh_Sach_SEQ.nextval,'S0002','Công nghệ thông tin',2,
        3,'Công nghệ thông tin',TO_DATE('2022/02/12','YYYY/MM/DD'),'Mô tả sách 2',
        210,40,520);
insert into HaVietAnh_Sach (IDSach, maSach, ten, IDNXB,
                            IDTG, chuDe, namXuatBan, moTa,
                            soLuongConLai, soLuongDangMuon, tongSoSach)
values (HaVietAnh_Sach_SEQ.nextval,'S0003','Văn học',3,
        5,'Văn học',TO_DATE('2022/02/12','YYYY/MM/DD'),'Mô tả sách 3',
        110,20,420);
insert into HaVietAnh_Sach (IDSach, maSach, ten, IDNXB,
                            IDTG, chuDe, namXuatBan, moTa,
                            soLuongConLai, soLuongDangMuon, tongSoSach)
values (HaVietAnh_Sach_SEQ.nextval,'S0004','Văn học',5,
        5,'Văn học',TO_DATE('2022/03/12','YYYY/MM/DD'),'Mô tả sách 4',
        210,40,520);
insert into HaVietAnh_Sach (IDSach, maSach, ten, IDNXB,
                            IDTG, chuDe, namXuatBan, moTa,
                            soLuongConLai, soLuongDangMuon, tongSoSach)
values (HaVietAnh_Sach_SEQ.nextval,'S0005','Toán học',2,
        2,'Toán học',TO_DATE('2022/01/12','YYYY/MM/DD'),'Mô tả sách 5',
        110,10,320);
insert into HaVietAnh_Sach (IDSach, maSach, ten, IDNXB,
                            IDTG, chuDe, namXuatBan, moTa,
                            soLuongConLai, soLuongDangMuon, tongSoSach)
values (HaVietAnh_Sach_SEQ.nextval,'S0006','Văn học',1,
        2,'Văn học',TO_DATE('2022/01/12','YYYY/MM/DD'),'Mô tả sách 1',
        200,50,420);
insert into HaVietAnh_Sach (IDSach, maSach, ten, IDNXB,
                            IDTG, chuDe, namXuatBan, moTa,
                            soLuongConLai, soLuongDangMuon, tongSoSach)
values (HaVietAnh_Sach_SEQ.nextval,'S0007','Công nghệ thông tin',2,
        3,'Công nghệ thông tin',TO_DATE('2022/02/12','YYYY/MM/DD'),'Mô tả sách 2',
        210,40,520);
insert into HaVietAnh_Sach (IDSach, maSach, ten, IDNXB,
                            IDTG, chuDe, namXuatBan, moTa,
                            soLuongConLai, soLuongDangMuon, tongSoSach)
values (HaVietAnh_Sach_SEQ.nextval,'S0008','Văn học',3,
        5,'Văn học',TO_DATE('2022/02/12','YYYY/MM/DD'),'Mô tả sách 3',
        110,20,420);
insert into HaVietAnh_Sach (IDSach, maSach, ten, IDNXB,
                            IDTG, chuDe, namXuatBan, moTa,
                            soLuongConLai, soLuongDangMuon, tongSoSach)
values (HaVietAnh_Sach_SEQ.nextval,'S0009','Văn học',5,
        5,'Văn học',TO_DATE('2022/03/12','YYYY/MM/DD'),'Mô tả sách 4',
        210,40,520);
insert into HaVietAnh_Sach (IDSach, maSach, ten, IDNXB,
                            IDTG, chuDe, namXuatBan, moTa,
                            soLuongConLai, soLuongDangMuon, tongSoSach)
values (HaVietAnh_Sach_SEQ.nextval,'S0010','Toán học',2,
        2,'Toán học',TO_DATE('2022/01/12','YYYY/MM/DD'),'Mô tả sách 5',
        110,10,320);
insert into HaVietAnh_Sach (IDSach, maSach, ten, IDNXB,
                            IDTG, chuDe, namXuatBan, moTa,
                            soLuongConLai, soLuongDangMuon, tongSoSach)
values (HaVietAnh_Sach_SEQ.nextval,'S0011','Văn học',1,
        2,'Văn học',TO_DATE('2022/01/12','YYYY/MM/DD'),'Mô tả sách 1',
        200,50,420);
insert into HaVietAnh_Sach (IDSach, maSach, ten, IDNXB,
                            IDTG, chuDe, namXuatBan, moTa,
                            soLuongConLai, soLuongDangMuon, tongSoSach)
values (HaVietAnh_Sach_SEQ.nextval,'S0012','Công nghệ thông tin',2,
        3,'Công nghệ thông tin',TO_DATE('2022/02/12','YYYY/MM/DD'),'Mô tả sách 2',
        210,40,520);
insert into HaVietAnh_Sach (IDSach, maSach, ten, IDNXB,
                            IDTG, chuDe, namXuatBan, moTa,
                            soLuongConLai, soLuongDangMuon, tongSoSach)
values (HaVietAnh_Sach_SEQ.nextval,'S0013','Văn học',3,
        5,'Văn học',TO_DATE('2022/02/12','YYYY/MM/DD'),'Mô tả sách 3',
        110,20,420);
insert into HaVietAnh_Sach (IDSach, maSach, ten, IDNXB,
                            IDTG, chuDe, namXuatBan, moTa,
                            soLuongConLai, soLuongDangMuon, tongSoSach)
values (HaVietAnh_Sach_SEQ.nextval,'S0014','Văn học',5,
        5,'Văn học',TO_DATE('2022/03/12','YYYY/MM/DD'),'Mô tả sách 4',
        210,40,520);
insert into HaVietAnh_Sach (IDSach, maSach, ten, IDNXB,
                            IDTG, chuDe, namXuatBan, moTa,
                            soLuongConLai, soLuongDangMuon, tongSoSach)
values (HaVietAnh_Sach_SEQ.nextval,'S0015','Toán học',2,
        2,'Toán học',TO_DATE('2022/01/12','YYYY/MM/DD'),'Mô tả sách 5',
        110,10,320);

--insert ban doc---------------------------------------------------
select * from HaVietAnh_BanDoc;
insert into HaVietAnh_BanDoc(IDBD, maBD, ten, SDT,
                             diaChi, ngaySinh, ngayTao, hang)
VALUES (HaVietAnh_BanDoc_SEQ.nextval,'BD0001','Hạ việt','09876543210',
        'Vĩnh Tường, Vĩnh Phúc 1',TO_DATE('2002/01/01','YYYY/MM/DD'),sysdate,0);

insert into HaVietAnh_BanDoc(IDBD, maBD, ten, SDT,
                             diaChi, ngaySinh, ngayTao, hang)
VALUES (HaVietAnh_BanDoc_SEQ.nextval,'BD0002','Hạ việt anh','09876543123',
        'Vĩnh Tường, Vĩnh Phúc 2',TO_DATE('2002/02/01','YYYY/MM/DD'),sysdate,1);

insert into HaVietAnh_BanDoc(IDBD, maBD, ten, SDT,
                             diaChi, ngaySinh, ngayTao, hang)
VALUES (HaVietAnh_BanDoc_SEQ.nextval,'BD0003','Hạ việt','09876543210',
        'Vĩnh Tường, Vĩnh Phúc 4',TO_DATE('2002/03/01','YYYY/MM/DD'),sysdate,2);

insert into HaVietAnh_BanDoc(IDBD, maBD, ten, SDT,
                             diaChi, ngaySinh, ngayTao, hang)
VALUES (HaVietAnh_BanDoc_SEQ.nextval,'BD0004','Hạ việt','09876543210',
        'Vĩnh Tường, Vĩnh Phúc 5',TO_DATE('2001/05/01','YYYY/MM/DD'),sysdate,3);
insert into HaVietAnh_BanDoc(IDBD, maBD, ten, SDT,
                             diaChi, ngaySinh, ngayTao, hang)
VALUES (HaVietAnh_BanDoc_SEQ.nextval,'BD0005','Hạ việt','09876543210',
        'Vĩnh Tường, Vĩnh Phúc 3',TO_DATE('2001/01/01','YYYY/MM/DD'),sysdate,5);

-- insert muon sach
insert into HaVietAnh_MuonSach(IDMS, IDBD, IDSach, soLuong,
                               ngayMuon, ngayTra, trangThai, ghiChu)
VALUES (HaVietAnh_MuonSach_SEQ.nextval,1,14,20,
        TO_DATE('2022/01/01','YYYY/MM/DD'),TO_DATE('2022/04/01','YYYY/MM/DD'),0,'ghi chu 1');
insert into HaVietAnh_MuonSach(IDMS, IDBD, IDSach, soLuong,
                               ngayMuon, ngayTra, trangThai, ghiChu)
VALUES (HaVietAnh_MuonSach_SEQ.nextval,1,14,20,
        TO_DATE('2022/02/01','YYYY/MM/DD'),TO_DATE('2022/04/11','YYYY/MM/DD'),1,'ghi chu 2');
insert into HaVietAnh_MuonSach(IDMS, IDBD, IDSach, soLuong,
                               ngayMuon, ngayTra, trangThai, ghiChu)
VALUES (HaVietAnh_MuonSach_SEQ.nextval,3,11,20,
        TO_DATE('2022/02/01','YYYY/MM/DD'),TO_DATE('2022/07/22','YYYY/MM/DD'),1,'ghi chu 3');
insert into HaVietAnh_MuonSach(IDMS, IDBD, IDSach, soLuong,
                               ngayMuon, ngayTra, trangThai, ghiChu)
VALUES (HaVietAnh_MuonSach_SEQ.nextval,4,9,10,
        TO_DATE('2022/02/12','YYYY/MM/DD'),TO_DATE('2022/09/11','YYYY/MM/DD'),1,'ghi chu 2');
insert into HaVietAnh_MuonSach(IDMS, IDBD, IDSach, soLuong,
                               ngayMuon, ngayTra, trangThai, ghiChu)
VALUES (HaVietAnh_MuonSach_SEQ.nextval,5,8,20,
        TO_DATE('2022/01/21','YYYY/MM/DD'),TO_DATE('2022/10/22','YYYY/MM/DD'),1,'ghi chu 3');

insert into HaVietAnh_MuonSach(IDMS, IDBD, IDSach, soLuong,
                               ngayMuon, ngayTra, trangThai, ghiChu)
VALUES (HaVietAnh_MuonSach_SEQ.nextval,4,12,10,
        TO_DATE('2022/02/12','YYYY/MM/DD'),TO_DATE('2022/09/11','YYYY/MM/DD'),1,'ghi chu 2');
insert into HaVietAnh_MuonSach(IDMS, IDBD, IDSach, soLuong,
                               ngayMuon, ngayTra, trangThai, ghiChu)
VALUES (HaVietAnh_MuonSach_SEQ.nextval,5,15,20,
        TO_DATE('2022/01/21','YYYY/MM/DD'),TO_DATE('2022/10/22','YYYY/MM/DD'),1,'ghi chu 3');
insert into HaVietAnh_MuonSach(IDMS, IDBD, IDSach, soLuong,
                               ngayMuon, ngayTra, trangThai, ghiChu)
VALUES (HaVietAnh_MuonSach_SEQ.nextval,1,12,20,
        TO_DATE('2021/01/21','YYYY/MM/DD'),TO_DATE('2021/10/22','YYYY/MM/DD'),1,'ghi chu 3');
-- select from
select * from HaVietAnh_NhaXuatBan;
select * from HaVietAnh_TacGia;
select * from HaVietAnh_Sach;
-- drop table HaVietAnh_MuonSach;
-- drop table HaVietAnh_BanDoc;
-- drop table HaVietAnh_Sach;
-- drop table HaVietAnh_TacGia;
-- drop table HaVietAnh_NhaXuatBan;
--------------------------------------------------------------------------------------------------
--	5 Hiển thị dách sách tác giả và tổng số lượng sách của tác giả gồm các trường thông tin:
--Mã Tác Giả, Tên Tác Giả, Chủ Đề, Số Lượng Sách, Sắp xếp theo số lượng sách giảm dần.
select maTG,HaVietAnh_TacGia.ten,chuDe,tongSoSach from HaVietAnh_TacGia
    join HaVietAnh_Sach on HaVietAnh_TacGia.IDTG = HaVietAnh_Sach.IDTG
    order by tongSoSach desc;

-- 6	Hiển thị 10 quyển sách có số lượng được mượn nhiều nhất gồm các trường thông tin:
-- Mã Sách, Tên Sách, Tên Nhà Xuất Bản, Tên Tác Giả,
-- Chủ Đề, Năm Xuất Bản, Số Lượng Còn Lại, Số Lượng Đã Mượn, Tổng Số
select maSach,sach.ten as tenSach,nxb.ten as tenNXB,tacgia.ten as tenTacGia, chuDe,
       namXuatBan,soLuongConLai,soLuongDangMuon,tongSoSach
from HaVietAnh_Sach sach join HaVietAnh_NhaXuatBan nxb on sach.IDNXB = nxb.IDNXB
                        join HaVietAnh_TacGia tacgia on sach.IDTG = tacgia.IDTG
where ROWNUM<11
order by soLuongDangMuon desc ;

-- 7.	Hiển thị  thông tin bạn đọc và sách được mượn từ ngày đầu tháng hiện tại đến thời điểm hiện tại.
-- Mã Bạn Đọc, Tên Bạn Đọc, Mã Sách, Tên Sách, Ngày Giờ Mượn, Số lượng
-- Sắp xếp theo ngày giờ mượn giảm dần, Tên bạn đọc tăng dần.
select maBD,bandoc.ten,maSach,sach.ten,ngayMuon,soLuongDangMuon from HaVietAnh_MuonSach muonsach
    join HaVietAnh_BanDoc bandoc on muonsach.IDBD = bandoc.IDBD
    join HaVietAnh_Sach sach on muonsach.IDSach = sach.IDSach
order by ngayMuon desc ;

-- 8.	Hiển thị 10 quyển sách có số lượng được mượn nhiều nhất tính từ đầu năm 2022
-- Mã Sách, Tên Sách, Số Lượng Đã Được Mượn.
select maSach,sach.ten as tenSach,sum(soLuongDangMuon)
from HaVietAnh_Sach sach join HaVietAnh_MuonSach on sach.IDSach = HaVietAnh_MuonSach.IDSach
where ROWNUM<11 and to_char(ngayMuon,'yyyy')>=2022
group by maSach, sach.ten
order by sum(soLuongDangMuon) desc ;

--9.	Hiển thị danh sách bạn đọc và số lần mượn sách tính từ đầu năm 2022 sắp xếp theo tên bạn đọc tăng dần:
--Mã Bạn Đọc, Tên Bạn Đọc, Số Lần Mượn
select maBD,ten,count(soLuong) as soLanMuon
from HAVIETANH_BANDOC bandoc
join HaVietAnh_MuonSach on bandoc.IDBD = HaVietAnh_MuonSach.IDBD
where to_char(ngayMuon,'yyyy')>=2022
group by maBD,ten
order by ten asc;

-- 10.	Hiển thị thông tin bạn đọc gồm có:
-- Mã Bạn Đọc, Tên Bạn Đọc, Tuổi (được tính dựa vào trường ngày sinh)
select maBD,ten,(to_char(sysdate,'yyyy')-to_char(ngaySinh,'yyyy')) as tuoi
from HAVIETANH_BANDOC;

-- 11.	Thống kê tổng số bạn đọc theo độ tuổi
-- Tuổi, Tổng số Bạn Đọc
select (to_char(sysdate,'yyyy')-to_char(ngaySinh,'yyyy')) as tuoi, count(IDBD) as tongSoBanDoc
from HAVIETANH_BANDOC group by (to_char(sysdate,'yyyy')-to_char(ngaySinh,'yyyy'));

-- 12.	Thống kê số lượng sách được xuất bản theo Nhà Xuất Bản, Theo năm xuất bản.
-- Năm Xuất Bản, Mã Nhà Xuất Bản,Tên Nhà Xuất Bản, Số Lượng Sách
-- Sắp xếp theo Năm xuất bản giảm dần, Tên Nhà xuất bản tăng dần.
select namXuatBan,maNXB,nxb.ten,tongSoSach
from HaVietAnh_Sach sach join HaVietAnh_NhaXuatBan nxb on sach.IDNXB = nxb.IDNXB
                         join HaVietAnh_TacGia tacgia on sach.IDTG = tacgia.IDTG
order by namXuatBan desc, ten asc ;
select * from HAVIETANH_BANDOC

-- 13.	Hiển thị 5 quyển sách được các bạn đọc có độ tuổi từ 18 đến 25 mượn nhiều nhất
-- tính từ đầu năm 2022. (Tính theo trường số lượng mượn của sách)
-- Mã Sách, Tên Sách, Số Lượng Được Mượn
select maSach,sach.ten,sum(soLuong) as soLuongDuocMuon
from HaVietAnh_MuonSach muonsach
    join HaVietAnh_Sach sach on sach.IDSach = muonsach.IDSach
    join HaVietAnh_BanDoc bandoc on muonsach.IDBD = bandoc.IDBD
where to_char(ngayMuon,'yyyy')>=2022 and ROWNUM <6
  and (to_char(sysdate,'yyyy')-to_char(ngaySinh,'yyyy')) between 18 and 25
group by maSach,sach.ten;
