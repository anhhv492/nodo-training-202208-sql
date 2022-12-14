create table HaVietAnh_NhaXuatBan(
    IDNXB number(4) not null primary key,
    maNXB varchar2(15) unique ,
    ten varchar2(50),
    trangThai int,
    diaChi varchar2(100),
    moTa varchar2(100)
);
CREATE SEQUENCE HaVietAnh_NXB_SEQ
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
CREATE SEQUENCE HaVietAnh_TG_SEQ
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
CREATE SEQUENCE HaVietAnh_SachTB_SEQ
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
CREATE SEQUENCE HaVietAnh_BD_SEQ
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
CREATE SEQUENCE HaVietAnh_MS_SEQ
    MINVALUE 0
    START WITH 0
    INCREMENT BY 1
;
CREATE INDEX HaVietAnh_MuonSach_idx_idBD ON HaVietAnh_MuonSach(IDBD);
CREATE INDEX HaVietAnh_MuonSach_idx_idSach ON HaVietAnh_MuonSach(IDSach);

-- insert bang nha xuat ban--------------------------------------------------
insert into HaVietAnh_NhaXuatBan(IDNXB, maNXB, ten, trangThai, diaChi, moTa)
VALUES (HaVietAnh_NXB_SEQ.nextval,'NXB0001','vanhvs',0,'Tr???nh V??n B??, H?? N???i','M?? t??? th??? nh???t');
insert into HaVietAnh_NhaXuatBan(IDNXB, maNXB, ten, trangThai, diaChi, moTa)
VALUES (HaVietAnh_NXB_SEQ.nextval,'NXB0002','vanhvs2',0,'Tr???nh V??n B??, H?? N???i 0','M?? t??? th??? hai');
insert into HaVietAnh_NhaXuatBan(IDNXB, maNXB, ten, trangThai, diaChi, moTa)
VALUES (HaVietAnh_NXB_SEQ.nextval,'NXB0003','vanhvs3',1,'Tr???nh V??n B??, H?? N???i 1','M?? t??? th??? ba');
insert into HaVietAnh_NhaXuatBan(IDNXB, maNXB, ten, trangThai, diaChi, moTa)
VALUES (HaVietAnh_NXB_SEQ.nextval,'NXB0004','vanhvs4',1,'Tr???nh V??n B??, H?? N???i 2','M?? t??? th??? t??');
insert into HaVietAnh_NhaXuatBan(IDNXB, maNXB, ten, trangThai, diaChi, moTa)
VALUES (HaVietAnh_NXB_SEQ.nextval,'NXB0005','vanhvs5',0,'123 Tr???nh V??n B??, H?? N???i 3','M?? t??? th??? n??m');
insert into HaVietAnh_NhaXuatBan(IDNXB, maNXB, ten, trangThai, diaChi, moTa)
VALUES (HaVietAnh_NXB_SEQ.nextval,'NXB0006','vanhvs6',0,'132 Tr???nh V??n B??, H?? N???i','M?? t??? th??? nh???t');
insert into HaVietAnh_NhaXuatBan(IDNXB, maNXB, ten, trangThai, diaChi, moTa)
VALUES (HaVietAnh_NXB_SEQ.nextval,'NXB0007','vanhvs7',0,'222 Tr???nh V??n B??, H?? N???i','M?? t??? th??? nh???t');
select* from HAVIETANH_NHAXUATBAN;
-- insert tac gia--------------------------------------------------
insert into HaVietAnh_TacGia(IDTG, maTG, ten, SDT, diaChi, moTa)
VALUES (HaVietAnh_TG_SEQ.nextval,'TG0001','Vi???t Anh H???','0984297473','V??nh T?????ng, V??nh Ph??c 1','M?? t??? 1');
insert into HaVietAnh_TacGia(IDTG, maTG, ten, SDT, diaChi, moTa)
VALUES (HaVietAnh_TG_SEQ.nextval,'TG0002','H??? Anh H???','0984297444','V??nh T?????ng, V??nh Ph??c 2','M?? t??? 2');
insert into HaVietAnh_TacGia(IDTG, maTG, ten, SDT, diaChi, moTa)
VALUES (HaVietAnh_TG_SEQ.nextval,'TG0003','Anh H???','0984297123','V??nh T?????ng, V??nh Ph??c 3','M?? t??? 3');
insert into HaVietAnh_TacGia(IDTG, maTG, ten, SDT, diaChi, moTa)
VALUES (HaVietAnh_TG_SEQ.nextval,'TG0004','H??? Anh','0984297321','V??nh T?????ng, V??nh Ph??c 4','M?? t??? 4');
insert into HaVietAnh_TacGia(IDTG, maTG, ten, SDT, diaChi, moTa)
VALUES (HaVietAnh_TG_SEQ.nextval,'TG0005','H??? Vi???t Anh','0984297111','V??nh T?????ng, V??nh Ph??c 5','M?? t??? 5');
insert into HaVietAnh_TacGia(IDTG, maTG, ten, SDT, diaChi, moTa)
VALUES (HaVietAnh_TG_SEQ.nextval,'TG0006','H??? Vi???t Anh','0984297111','V??nh T?????ng, V??nh Ph??c 6','M?? t??? 5');
select* from HaVietAnh_TacGia;
-- INSERT SACH--------------------------------------------------

insert into HaVietAnh_Sach (IDSach, maSach, ten, IDNXB,
                            IDTG, chuDe, namXuatBan, moTa,
                            soLuongConLai, soLuongDangMuon, tongSoSach)
values (HaVietAnh_SachTB_SEQ.nextval,'S0001','V??n h???c',1,
        2,'C??ng ngh??? th??ng tin',TO_DATE('2022/01/12','YYYY/MM/DD'),'M?? t??? s??ch 1',
        200,50,420);
insert into HaVietAnh_Sach (IDSach, maSach, ten, IDNXB,
                            IDTG, chuDe, namXuatBan, moTa,
                            soLuongConLai, soLuongDangMuon, tongSoSach)
values (HaVietAnh_SachTB_SEQ.nextval,'S0002','C??ng ngh??? th??ng tin',2,
        3,'C??ng ngh??? th??ng tin',TO_DATE('2022/02/12','YYYY/MM/DD'),'M?? t??? s??ch 2',
        210,40,520);
insert into HaVietAnh_Sach (IDSach, maSach, ten, IDNXB,
                            IDTG, chuDe, namXuatBan, moTa,
                            soLuongConLai, soLuongDangMuon, tongSoSach)
values (HaVietAnh_SachTB_SEQ.nextval,'S0003','V??n h???c',2,
        5,'V??n h???c',TO_DATE('2022/02/12','YYYY/MM/DD'),'M?? t??? s??ch 3',
        110,20,420);
insert into HaVietAnh_Sach (IDSach, maSach, ten, IDNXB,
                            IDTG, chuDe, namXuatBan, moTa,
                            soLuongConLai, soLuongDangMuon, tongSoSach)
values (HaVietAnh_SachTB_SEQ.nextval,'S0004','V??n h???c',5,
        5,'V??n h???c',TO_DATE('2022/03/12','YYYY/MM/DD'),'M?? t??? s??ch 4',
        210,40,520);
insert into HaVietAnh_Sach (IDSach, maSach, ten, IDNXB,
                            IDTG, chuDe, namXuatBan, moTa,
                            soLuongConLai, soLuongDangMuon, tongSoSach)
values (HaVietAnh_SachTB_SEQ.nextval,'S0005','To??n h???c',2,
        2,'To??n h???c',TO_DATE('2022/01/12','YYYY/MM/DD'),'M?? t??? s??ch 5',
        110,10,320);
insert into HaVietAnh_Sach (IDSach, maSach, ten, IDNXB,
                            IDTG, chuDe, namXuatBan, moTa,
                            soLuongConLai, soLuongDangMuon, tongSoSach)
values (HaVietAnh_SachTB_SEQ.nextval,'S0006','V??n h???c',1,
        2,'V??n h???c',TO_DATE('2022/01/12','YYYY/MM/DD'),'M?? t??? s??ch 1',
        200,50,420);
insert into HaVietAnh_Sach (IDSach, maSach, ten, IDNXB,
                            IDTG, chuDe, namXuatBan, moTa,
                            soLuongConLai, soLuongDangMuon, tongSoSach)
values (HaVietAnh_SachTB_SEQ.nextval,'S0007','C??ng ngh??? th??ng tin',2,
        3,'C??ng ngh??? th??ng tin',TO_DATE('2022/02/12','YYYY/MM/DD'),'M?? t??? s??ch 2',
        210,40,520);
insert into HaVietAnh_Sach (IDSach, maSach, ten, IDNXB,
                            IDTG, chuDe, namXuatBan, moTa,
                            soLuongConLai, soLuongDangMuon, tongSoSach)
values (HaVietAnh_SachTB_SEQ.nextval,'S0008','V??n h???c',3,
        5,'V??n h???c',TO_DATE('2022/02/12','YYYY/MM/DD'),'M?? t??? s??ch 3',
        110,20,420);
insert into HaVietAnh_Sach (IDSach, maSach, ten, IDNXB,
                            IDTG, chuDe, namXuatBan, moTa,
                            soLuongConLai, soLuongDangMuon, tongSoSach)
values (HaVietAnh_SachTB_SEQ.nextval,'S0009','V??n h???c',5,
        5,'V??n h???c',TO_DATE('2022/03/12','YYYY/MM/DD'),'M?? t??? s??ch 4',
        210,40,520);
insert into HaVietAnh_Sach (IDSach, maSach, ten, IDNXB,
                            IDTG, chuDe, namXuatBan, moTa,
                            soLuongConLai, soLuongDangMuon, tongSoSach)
values (HaVietAnh_SachTB_SEQ.nextval,'S0010','To??n h???c',2,
        2,'To??n h???c',TO_DATE('2022/01/12','YYYY/MM/DD'),'M?? t??? s??ch 5',
        110,10,320);
insert into HaVietAnh_Sach (IDSach, maSach, ten, IDNXB,
                            IDTG, chuDe, namXuatBan, moTa,
                            soLuongConLai, soLuongDangMuon, tongSoSach)
values (HaVietAnh_SachTB_SEQ.nextval,'S0011','V??n h???c',1,
        2,'V??n h???c',TO_DATE('2022/01/12','YYYY/MM/DD'),'M?? t??? s??ch 1',
        200,50,420);
insert into HaVietAnh_Sach (IDSach, maSach, ten, IDNXB,
                            IDTG, chuDe, namXuatBan, moTa,
                            soLuongConLai, soLuongDangMuon, tongSoSach)
values (HaVietAnh_SachTB_SEQ.nextval,'S0012','C??ng ngh??? th??ng tin',2,
        3,'C??ng ngh??? th??ng tin',TO_DATE('2022/02/12','YYYY/MM/DD'),'M?? t??? s??ch 2',
        210,40,520);
insert into HaVietAnh_Sach (IDSach, maSach, ten, IDNXB,
                            IDTG, chuDe, namXuatBan, moTa,
                            soLuongConLai, soLuongDangMuon, tongSoSach)
values (HaVietAnh_SachTB_SEQ.nextval,'S0013','V??n h???c',3,
        5,'V??n h???c',TO_DATE('2022/02/12','YYYY/MM/DD'),'M?? t??? s??ch 3',
        110,20,420);
insert into HaVietAnh_Sach (IDSach, maSach, ten, IDNXB,
                            IDTG, chuDe, namXuatBan, moTa,
                            soLuongConLai, soLuongDangMuon, tongSoSach)
values (HaVietAnh_SachTB_SEQ.nextval,'S0014','V??n h???c',5,
        5,'V??n h???c',TO_DATE('2022/03/12','YYYY/MM/DD'),'M?? t??? s??ch 4',
        210,40,520);
insert into HaVietAnh_Sach (IDSach, maSach, ten, IDNXB,
                            IDTG, chuDe, namXuatBan, moTa,
                            soLuongConLai, soLuongDangMuon, tongSoSach)
values (HaVietAnh_SachTB_SEQ.nextval,'S0015','To??n h???c',2,
        2,'To??n h???c',TO_DATE('2022/01/12','YYYY/MM/DD'),'M?? t??? s??ch 5',
        110,10,320);

--insert ban doc---------------------------------------------------
select * from HaVietAnh_BanDoc;
insert into HaVietAnh_BanDoc(IDBD, maBD, ten, SDT,
                             diaChi, ngaySinh, ngayTao, hang)
VALUES (HaVietAnh_BD_SEQ.nextval,'BD0001','H??? vi???t','09876543210',
        'V??nh T?????ng, V??nh Ph??c 1',TO_DATE('2002/01/01','YYYY/MM/DD'),sysdate,0);

insert into HaVietAnh_BanDoc(IDBD, maBD, ten, SDT,
                             diaChi, ngaySinh, ngayTao, hang)
VALUES (HaVietAnh_BD_SEQ.nextval,'BD0002','H??? vi???t anh','09876543123',
        'V??nh T?????ng, V??nh Ph??c 2',TO_DATE('2002/02/01','YYYY/MM/DD'),sysdate,1);

insert into HaVietAnh_BanDoc(IDBD, maBD, ten, SDT,
                             diaChi, ngaySinh, ngayTao, hang)
VALUES (HaVietAnh_BD_SEQ.nextval,'BD0003','H??? vi???t','09876543210',
        'V??nh T?????ng, V??nh Ph??c 4',TO_DATE('2002/03/01','YYYY/MM/DD'),sysdate,2);

insert into HaVietAnh_BanDoc(IDBD, maBD, ten, SDT,
                             diaChi, ngaySinh, ngayTao, hang)
VALUES (HaVietAnh_BD_SEQ.nextval,'BD0004','H??? vi???t','09876543210',
        'V??nh T?????ng, V??nh Ph??c 5',TO_DATE('2001/05/01','YYYY/MM/DD'),sysdate,3);
insert into HaVietAnh_BanDoc(IDBD, maBD, ten, SDT,
                             diaChi, ngaySinh, ngayTao, hang)
VALUES (HaVietAnh_BD_SEQ.nextval,'BD0005','H??? vi???t','09876543210',
        'V??nh T?????ng, V??nh Ph??c 3',TO_DATE('2001/01/01','YYYY/MM/DD'),sysdate,5);
insert into HaVietAnh_BanDoc(IDBD, maBD, ten, SDT,
                             diaChi, ngaySinh, ngayTao, hang)
VALUES (HaVietAnh_BD_SEQ.nextval,'BD0006','L?? V??n Luy???n','09876543210',
        'V??nh T?????ng, V??nh Ph??c 3',TO_DATE('2001/01/01','YYYY/MM/DD'),sysdate,5);
insert into HaVietAnh_BanDoc(IDBD, maBD, ten, SDT,
                             diaChi, ngaySinh, ngayTao, hang)
VALUES (HaVietAnh_BD_SEQ.nextval,'BD0007','Ch??u Tinh Tr??','09876543210',
        'V??nh T?????ng, V??nh Ph??c 3',TO_DATE('2001/01/01','YYYY/MM/DD'),sysdate,5);
select *from HaVietAnh_Sach;
-- insert muon sach
insert into HaVietAnh_MuonSach(IDMS, IDBD, IDSach, soLuong,
                               ngayMuon, ngayTra, trangThai, ghiChu)
VALUES (HaVietAnh_MS_SEQ.nextval,1,14,20,
        TO_DATE('2022/01/01','YYYY/MM/DD'),TO_DATE('2022/04/01','YYYY/MM/DD'),0,'ghi chu 1');
insert into HaVietAnh_MuonSach(IDMS, IDBD, IDSach, soLuong,
                               ngayMuon, ngayTra, trangThai, ghiChu)
VALUES (HaVietAnh_MS_SEQ.nextval,1,14,20,
        TO_DATE('2022/02/01','YYYY/MM/DD'),TO_DATE('2022/04/11','YYYY/MM/DD'),1,'ghi chu 2');
insert into HaVietAnh_MuonSach(IDMS, IDBD, IDSach, soLuong,
                               ngayMuon, ngayTra, trangThai, ghiChu)
VALUES (HaVietAnh_MS_SEQ.nextval,3,11,20,
        TO_DATE('2022/02/01','YYYY/MM/DD'),TO_DATE('2022/07/22','YYYY/MM/DD'),1,'ghi chu 3');
insert into HaVietAnh_MuonSach(IDMS, IDBD, IDSach, soLuong,
                               ngayMuon, ngayTra, trangThai, ghiChu)
VALUES (HaVietAnh_MS_SEQ.nextval,4,9,10,
        TO_DATE('2022/02/12','YYYY/MM/DD'),TO_DATE('2022/09/11','YYYY/MM/DD'),1,'ghi chu 2');
insert into HaVietAnh_MuonSach(IDMS, IDBD, IDSach, soLuong,
                               ngayMuon, ngayTra, trangThai, ghiChu)
VALUES (HaVietAnh_MS_SEQ.nextval,4,7,20,
        TO_DATE('2022/01/21','YYYY/MM/DD'),TO_DATE('2022/10/22','YYYY/MM/DD'),1,'ghi chu 3');

insert into HaVietAnh_MuonSach(IDMS, IDBD, IDSach, soLuong,
                               ngayMuon, ngayTra, trangThai, ghiChu)
VALUES (HaVietAnh_MS_SEQ.nextval,4,12,10,
        TO_DATE('2022/02/12','YYYY/MM/DD'),TO_DATE('2022/09/11','YYYY/MM/DD'),1,'ghi chu 2');
insert into HaVietAnh_MuonSach(IDMS, IDBD, IDSach, soLuong,
                               ngayMuon, ngayTra, trangThai, ghiChu)
VALUES (HaVietAnh_MS_SEQ.nextval,3,15,20,
        TO_DATE('2022/01/21','YYYY/MM/DD'),TO_DATE('2022/10/22','YYYY/MM/DD'),1,'ghi chu 3');
insert into HaVietAnh_MuonSach(IDMS, IDBD, IDSach, soLuong,
                               ngayMuon, ngayTra, trangThai, ghiChu)
VALUES (HaVietAnh_MS_SEQ.nextval,1,12,20,
        TO_DATE('2021/01/21','YYYY/MM/DD'),TO_DATE('2021/10/22','YYYY/MM/DD'),1,'ghi chu 3');
-- select from
-- drop table HaVietAnh_MuonSach;
-- drop table HaVietAnh_BanDoc;
-- drop table HaVietAnh_Sach;
-- drop table HaVietAnh_TacGia;
-- drop table HaVietAnh_NhaXuatBan;
--------------------------------------------------------------------------------------------------
--	5 Hi???n th??? d??ch s??ch t??c gi??? v?? t???ng s??? l?????ng s??ch c???a t??c gi??? g???m c??c tr?????ng th??ng tin:
--M?? T??c Gi???, T??n T??c Gi???, Ch??? ?????, S??? L?????ng S??ch, S???p x???p theo s??? l?????ng s??ch gi???m d???n.
select maTG,HaVietAnh_TacGia.ten,chuDe,tongSoSach from HaVietAnh_TacGia
    join HaVietAnh_Sach on HaVietAnh_TacGia.IDTG = HaVietAnh_Sach.IDTG
    order by tongSoSach desc;

-- 6	Hi???n th??? 10 quy???n s??ch c?? s??? l?????ng ???????c m?????n nhi???u nh???t g???m c??c tr?????ng th??ng tin:
-- M?? S??ch, T??n S??ch, T??n Nh?? Xu???t B???n, T??n T??c Gi???,
-- Ch??? ?????, N??m Xu???t B???n, S??? L?????ng C??n L???i, S??? L?????ng ???? M?????n, T???ng S???
select maSach,sach.ten as tenSach,nxb.ten as tenNXB,tacgia.ten as tenTacGia, chuDe,
       namXuatBan,soLuongConLai,soLuongDangMuon,tongSoSach
from HaVietAnh_Sach sach join HaVietAnh_NhaXuatBan nxb on sach.IDNXB = nxb.IDNXB
                        join HaVietAnh_TacGia tacgia on sach.IDTG = tacgia.IDTG
where ROWNUM<11
order by soLuongDangMuon desc ;

-- 7.	Hi???n th???  th??ng tin b???n ?????c v?? s??ch ???????c m?????n t??? ng??y ?????u th??ng hi???n t???i ?????n th???i ??i???m hi???n t???i.
-- M?? B???n ?????c, T??n B???n ?????c, M?? S??ch, T??n S??ch, Ng??y Gi??? M?????n, S??? l?????ng
-- S???p x???p theo ng??y gi??? m?????n gi???m d???n, T??n b???n ?????c t??ng d???n.
select maBD,bandoc.ten,maSach,sach.ten,ngayMuon,soLuongDangMuon from HaVietAnh_MuonSach muonsach
    join HaVietAnh_BanDoc bandoc on muonsach.IDBD = bandoc.IDBD
    join HaVietAnh_Sach sach on muonsach.IDSach = sach.IDSach
order by ngayMuon desc ;

-- 8.	Hi???n th??? 10 quy???n s??ch c?? s??? l?????ng ???????c m?????n nhi???u nh???t t??nh t??? ?????u n??m 2022
-- M?? S??ch, T??n S??ch, S??? L?????ng ???? ???????c M?????n.
select maSach,sach.ten as tenSach,sum(soLuongDangMuon)
from HaVietAnh_Sach sach join HaVietAnh_MuonSach on sach.IDSach = HaVietAnh_MuonSach.IDSach
where ROWNUM<11 and to_char(ngayMuon,'yyyy')>=2022
group by maSach, sach.ten
order by sum(soLuongDangMuon) desc ;

--9.	Hi???n th??? danh s??ch b???n ?????c v?? s??? l???n m?????n s??ch t??nh t??? ?????u n??m 2022 s???p x???p theo t??n b???n ?????c t??ng d???n:
--M?? B???n ?????c, T??n B???n ?????c, S??? L???n M?????n
select maBD,ten,count(soLuong) as soLanMuon
from HAVIETANH_BANDOC bandoc
join HaVietAnh_MuonSach on bandoc.IDBD = HaVietAnh_MuonSach.IDBD
where to_char(ngayMuon,'yyyy')>=2022
group by maBD,ten
order by ten asc;

-- 10.	Hi???n th??? th??ng tin b???n ?????c g???m c??:
-- M?? B???n ?????c, T??n B???n ?????c, Tu???i (???????c t??nh d???a v??o tr?????ng ng??y sinh)
select maBD,ten,(to_char(sysdate,'yyyy')-to_char(ngaySinh,'yyyy')) as tuoi
from HAVIETANH_BANDOC;

-- 11.	Th???ng k?? t???ng s??? b???n ?????c theo ????? tu???i
-- Tu???i, T???ng s??? B???n ?????c
select (to_char(sysdate,'yyyy')-to_char(ngaySinh,'yyyy')) as tuoi, count(IDBD) as tongSoBanDoc
from HAVIETANH_BANDOC group by (to_char(sysdate,'yyyy')-to_char(ngaySinh,'yyyy'));

-- 12.	Th???ng k?? s??? l?????ng s??ch ???????c xu???t b???n theo Nh?? Xu???t B???n, Theo n??m xu???t b???n.
-- N??m Xu???t B???n, M?? Nh?? Xu???t B???n,T??n Nh?? Xu???t B???n, S??? L?????ng S??ch
-- S???p x???p theo N??m xu???t b???n gi???m d???n, T??n Nh?? xu???t b???n t??ng d???n.
select namXuatBan,maNXB,nxb.ten,tongSoSach
from HaVietAnh_Sach sach join HaVietAnh_NhaXuatBan nxb on sach.IDNXB = nxb.IDNXB
                         join HaVietAnh_TacGia tacgia on sach.IDTG = tacgia.IDTG
order by namXuatBan desc, ten asc ;
select * from HAVIETANH_BANDOC

-- 13.	Hi???n th??? 5 quy???n s??ch ???????c c??c b???n ?????c c?? ????? tu???i t??? 18 ?????n 25 m?????n nhi???u nh???t
-- t??nh t??? ?????u n??m 2022. (T??nh theo tr?????ng s??? l?????ng m?????n c???a s??ch)
-- M?? S??ch, T??n S??ch, S??? L?????ng ???????c M?????n
select maSach,sach.ten,sum(soLuong) as soLuongDuocMuon
from HaVietAnh_MuonSach muonsach
    join HaVietAnh_Sach sach on sach.IDSach = muonsach.IDSach
    join HaVietAnh_BanDoc bandoc on muonsach.IDBD = bandoc.IDBD
where to_char(ngayMuon,'yyyy')>=2022 and ROWNUM <6
  and (to_char(sysdate,'yyyy')-to_char(ngaySinh,'yyyy')) between 18 and 25
group by maSach,sach.ten;
-- 14.	Hi???n th??? to??n b??? b???n ?????c v?? s??ch m?? b???n ?????c ?????y m?????n,
-- s??? c?? b???n ch??a m?????n v???n c???n hi???n th??? v?? t??n s??ch ????? l?? null.
-- M?? b???n ?????c, t??n ban ?????c, t??n s??ch
select maBD,bandoc.ten as tenBanDoc, sach.ten as tenSach
from HaVietAnh_MuonSach muonsach
    left join HaVietAnh_Sach sach on sach.IDSach = muonsach.IDSach
    right join HaVietAnh_BanDoc bandoc on muonsach.IDBD = bandoc.IDBD
where bandoc.ten in (select ten from HAVIETANH_BANDOC );