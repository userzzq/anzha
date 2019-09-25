use CDXP1688;

create table TbOssConfig
(
  ocid varchar(100) primary key not null comment '主键',
  endpoint varchar(255) not null comment 'endpoint',
  accessKeyId varchar(255) not null comment 'accessKeyId',
  accessKeySecret varchar(255) not null comment 'accessKeySecret',
  bucketName varchar(255) not null comment 'bucketName',
  expiration bigint not null comment '链接过期时间',
  enable enum('y','n') default 'y' not null comment '是否启用',
  lastupdate timestamp not null on update now() default now() comment '最后更新时间'
)comment 'oss配置信息';

create table TbOssInfo
(
  oiid int auto_increment primary key not null comment '主键',
  ocid varchar(100) not null comment '外键,配置信息',
  objectName varchar(255) not null comment '文件对象名称',
  filename varchar(255) not null comment '原始文件名称',
  contentType varchar(255) not null comment '文件类型',
  filesize bigint not null comment '文件大小',
  fileinfo varchar(200) not null comment '文件描述',
  lastupdate timestamp on update now() default now() not null comment '最后更新时间'
)comment 'oss文件信息';

create table TbAdminUser
(
  auid integer auto_increment primary key not null comment '主键',
  username varchar(50) unique not null comment '登录用户名',
  password varchar(100) not null comment '登录密码',
  nickname varchar(200) not null default '' comment '用户昵称',
  isEnable enum('y','n') default 'y' not null comment '是否启用',
  lastupdate timestamp on update now() default now() not null comment '最后更新时间'
)comment '后台管理员信息';

create table TbUser
(
  uid integer auto_increment primary key not null comment '主键',
  phone varchar(50) unique not null comment '电话',
  password varchar(100) not null comment '密码',
  name varchar(100) not null default '' comment '用户姓名',
  address varchar(100) not null default '' comment '用户地址',
  isEnable enum('y','n') default 'y' not null comment '是否启用',
  lastupdate timestamp on update now() default now() not null comment '最后更新时间'
)comment '用户信息';

create table TbWorkerType
(
  wtid integer auto_increment primary key not null comment '主键',
  typeName varchar(50) unique not null comment '类型名称',
  typeInfo varchar(50) unique not null comment '类型描述',
  isEnable enum('y','n') default 'y' not null comment '是否启用',
  lastupdate timestamp on update now() default now() not null comment '最后更新时间'
)comment '职业身份';

create table TbWorker
(
  wid integer auto_increment primary key not null comment '主键',
  wtid integer not null comment '外键，所属职业身份',
  cid integer not null comment '外键，所属城市',
  address varchar(200) not null default '' comment '详细地址',
  phone varchar(20) unique not null comment '手机号',
  name varchar(20) not null comment '姓名',
  password varchar(100) not null comment '密码',
  recommend varchar(20) not null default '' comment '推荐码',
  isEnable enum('y','n') default 'n' not null comment '是否启用',
  inWork enum('y','n') default 'n' not null comment '接单中',
  lastupdate timestamp on update now() default now() not null comment '最后更新时间',
  constraint fkTbWorker_wtid foreign key(wtid) references TbWorkerType(wtid),
  constraint fkTbWorker_cid foreign key(cid) references TbCity(cid)
)comment '师傅信息（需要后台认证，可能需要收件信息 收件人，电话，所在地区，详细地址）';

create table TbWorkerReport
(
  wrid integer auto_increment primary key not null comment '主键',
  wid integer not null comment '外键，报备师傅',
  cid integer not null comment '外键，所属城市',
  address varchar(200) not null default '' comment '详细地址',
  username varchar(200) not null comment '业主姓名',
  phone varchar(50) not null comment '联系方式',
  areainfo varchar(200) not null comment '面积详情',
  opendate timestamp not null comment '开工日期',
  decorate varchar(200) not null default '' comment '装修公司',
  lastupdate timestamp on update now() default now() not null comment '最后更新时间',
  constraint fkTbWorkerReport_cid foreign key(cid) references TbCity(cid),
  constraint fkTbWorkerReport_wid foreign key(wid) references TbWorker(wid)
)comment '师傅报备信息';

create table TbReporterType
(
  rtid integer auto_increment primary key not null comment '主键',
  typeName varchar(50) unique not null comment '类型名称',
  typeInfo varchar(50) unique not null comment '类型描述',
  isEnable enum('y','n') default 'y' not null comment '是否启用',
  lastupdate timestamp on update now() default now() not null comment '最后更新时间'
)comment '报备相关人员类型(项目经理，瓦匠)';

create table TbReportPeople
(
  rpid integer auto_increment primary key not null comment '主键',
  wrid integer not null comment '外键，报备信息',
  rtid integer not null comment '外键，报备人员类型',
  username varchar(200) not null comment '姓名',
  phone varchar(50) not null comment '联系方式',
  lastupdate timestamp on update now() default now() not null comment '最后更新时间',
  constraint fkTbReportPeople_wrid foreign key(wrid) references TbWorkerReport(wrid),
  constraint fkTbReportPeople_rtid foreign key(rtid) references TbReporterType(rtid)
)comment '报备相关人员信息';

create table TbUserFixInfo
(
  ufid integer auto_increment primary key not null comment '主键',
  uid integer not null comment '外键，叫修人员',
  info varchar(500) not null  comment '叫修信息',
  address varchar(500) not null  comment '地址信息',
  addressInfo varchar(200) not null default '' comment '地址附件信息',
  lat varchar(50) not null  comment '地址lat信息',
  lng varchar(50) not null  comment '地址lng信息',
  phone varchar(50) not null  comment '联系方式',
  images varchar(500) not null default '' comment '上传的图片ids',
  fixtype varchar(2) not null  comment '维修类型，10：我要修，11：我要洗，12：我要装',
  status varchar(2) not null default '10' comment '维修状态，10：已经下单，11，已经接单，12，用户取消，13，已经定价，14，维修完成，15，已经支付，99，订单完成',
  out_trade_no varchar(50) not null default '' comment '交易订单号',
  lastupdate timestamp on update now() default now() not null comment '最后更新时间',
  constraint fkTbUserFixInfo_uid foreign key(uid) references TbUser(uid)
)comment '用户修理信息';

create table TbUserFixOrder
(
  ufoid int auto_increment primary key not null comment '主键',
  wid integer not null comment '外键，接单师傅id',
  ufid integer not null comment '外键，修理信息id',
  info varchar(500) not null default '' comment '描述信息',
  lastupdate timestamp on update now() default now() not null comment '最后更新时间'
)comment '用户修理订单信息';

create table TbFixOrderDetail
(
  fodid int auto_increment primary key not null comment '主键',
  ufoid integer not null comment '外键，用户修理订单信息id',
  detail varchar(20) not null comment '描述信息',
  price decimal(10,2) not null default 0 comment '维修价格',
  lastupdate timestamp on update now() default now() not null comment '最后更新时间'
)comment '用户修理订单价格明细信息';

create table TbUserFixInfoImages
(
  imgid integer auto_increment primary key not null comment '主键',
  ufid  integer not null comment '外键，微信信息id',
  filename varchar(255) not null comment '图片文件名称',
  contentType varchar(255) not null comment '图片文件类型',
  filesize bigint not null comment '图片文件大小',
  lastupdate timestamp on update now() default now() not null comment '最后更新时间',
  constraint fkTbUserFixInfoImages_ufid foreign key(ufid) references TbUserFixInfo(ufid)
)comment '用户修理信息相关图片信息（已经废弃，转oss）';

create table TbMessage
(
  mid integer auto_increment primary key not null comment '主键',
  mtype varchar(2) not null  comment '消息类型，10：师傅消息，11：用户消息',
  uid integer not null comment '消息的用户id',
  info varchar(255) not null comment '消息内容',
  readed enum('y','n') default 'n' not null comment '是否已读',
  lastupdate timestamp on update now() default now() not null comment '最后更新时间'
)comment '消息通知';

create table TbPayRecode
(
  prid integer auto_increment primary key not null comment '主键',
  wid integer not null comment '外键，接单师傅id',
  price decimal(10,2) not null default 0 comment '维修价格'
  lastupdate timestamp on update now() default now() not null comment '最后更新时间'
)comment '师傅打款记录';

/*oss配置*/
insert into TbOssConfig(ocid,endpoint,accessKeyId,accessKeySecret,bucketName,expiration) values('40d7d814-4ce9-4aa1-a90f-2b910b451888','oss-cn-shenzhen.aliyuncs.com','LTAITTlZcoYVygXQ','Pw6wWbgJQbBBko3pTL7rXsqDGeRU3O','images-cdxp1688','36000000');

insert into TbAdminUser(username,password,nickname) values('admin','4dc6dceeb03a1e683d7dc66c240243cd','内置管理员');
insert into TbUser(phone,password,name) values('15973637383','b1493a406bdbfbca2511de3619a71055','内置测试用户');

insert into TbWorkerType(typeName,typeInfo) values('公司职员','公司职员');
insert into TbWorkerType(typeName,typeInfo) values('自由职业','自由职业');
insert into TbWorkerType(typeName,typeInfo) values('公司老板','公司老板');

insert into TbReporterType(typeName,typeInfo) values('项目经理','项目经理');
insert into TbReporterType(typeName,typeInfo) values('瓦匠','瓦匠');

insert into TbWorker (wtid, cid, address, name, phone, password) values( 2, 265, '武陵区白马湖街道', 'DarkKnight', '15115788049', 'e10adc3949ba59abbe56e057f20f883e');
insert into TbWorker (wtid, cid, address, name, phone, password) values( 3, 265, '汉寿县一中', 'joker', '13027421874', 'e10adc3949ba59abbe56e057f20f883e');
insert into TbWorker (wtid, cid, address, name, phone, password) values( 1, 265, '澧县一中', '黑暗骑士', '15173620490', 'e10adc3949ba59abbe56e057f20f883e');
insert into TbWorker (wtid, cid, address, name, phone, password) values( 3, 265, '桃源一中', '叶欢', '17607363495', 'e10adc3949ba59abbe56e057f20f883e');

select auid,username,password,nickname,isEnable,lastupdate from TbAdminUser;
select wtid,typeName,typeInfo,isEnable,lastupdate from TbWorkerType;
select wid,wtid,cid,address,phone,password,recommend,isEnable,lastupdate from TbWorker;
select wrid,wid,cid,address,username,phone,areainfo,opendate,decorate,lastupdate from TbWorkerReport;
select rtid,typeName,typeInfo,isEnable,lastupdate from TbReporterType;
select rpid,wrid,rtid,username,phone,lastupdate from TbReportPeople;
select ufid,uid,info,address,addressInfo,lat,lng,phone,fixtype,status,lastupdate from TbUserFixInfo;
select imgid,ufid,filename,contentType,filesize,lastupdate from TbUserFixInfoImages;

