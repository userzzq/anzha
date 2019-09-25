create table TbProvince
(
  pid int auto_increment primary key comment '主键',
  province varchar(100) unique not null comment '省份名称',
  info varchar(2000) default '' not null comment '省份描述',
  lastupdate timestamp on update now() default now() not null comment '最后更新时间'
)comment '省份信息';

create table TbCity
(
  cid int auto_increment primary key comment '主键',
  pid int not null comment '所属省份',
  city varchar(500) not null comment '城市名',
  info varchar(2000) default '' not null comment '城市描述',
  lastupdate timestamp on update now() default now() not null comment '最后更新时间',
  constraint fkCityPid foreign key(pid) references TbProvince(pid)
)comment '城市信息';

insert into TbProvince(province) values('北京');
insert into TbProvince(province) values('天津');
insert into TbProvince(province) values('上海');
insert into TbProvince(province) values('重庆');
insert into TbProvince(province) values('河北');
insert into TbProvince(province) values('山西');
insert into TbProvince(province) values('辽宁');
insert into TbProvince(province) values('吉林');
insert into TbProvince(province) values('黑龙江');
insert into TbProvince(province) values('江苏');
insert into TbProvince(province) values('浙江');
insert into TbProvince(province) values('安徽');
insert into TbProvince(province) values('福建');
insert into TbProvince(province) values('江西');
insert into TbProvince(province) values('山东');
insert into TbProvince(province) values('河南');
insert into TbProvince(province) values('湖北');
insert into TbProvince(province) values('湖南');
insert into TbProvince(province) values('广东');
insert into TbProvince(province) values('海南');
insert into TbProvince(province) values('四川');
insert into TbProvince(province) values('贵州');
insert into TbProvince(province) values('云南');
insert into TbProvince(province) values('陕西');
insert into TbProvince(province) values('甘肃');
insert into TbProvince(province) values('青海');
insert into TbProvince(province) values('内蒙古');
insert into TbProvince(province) values('广西');
insert into TbProvince(province) values('西藏');
insert into TbProvince(province) values('宁夏');
insert into TbProvince(province) values('新疆维吾尔自治区');
insert into TbProvince(province) values('香港');
insert into TbProvince(province) values('澳门');
insert into TbProvince(province) values('台湾');
insert into TbCity(pid,city) values(1,'东城区');
insert into TbCity(pid,city) values(1,'西城区');
insert into TbCity(pid,city) values(1,'崇文区');
insert into TbCity(pid,city) values(1,'宣武区');
insert into TbCity(pid,city) values(1,'朝阳区');
insert into TbCity(pid,city) values(1,'海淀区');
insert into TbCity(pid,city) values(1,'丰台区');
insert into TbCity(pid,city) values(1,'石景山区');
insert into TbCity(pid,city) values(1,'房山区');
insert into TbCity(pid,city) values(1,'通州区');
insert into TbCity(pid,city) values(1,'顺义区');
insert into TbCity(pid,city) values(1,'昌平区');
insert into TbCity(pid,city) values(1,'大兴区');
insert into TbCity(pid,city) values(1,'怀柔区');
insert into TbCity(pid,city) values(1,'平谷区');
insert into TbCity(pid,city) values(1,'门头沟区');
insert into TbCity(pid,city) values(1,'密云县');
insert into TbCity(pid,city) values(1,'延庆县');
insert into TbCity(pid,city) values(2,'和平区');
insert into TbCity(pid,city) values(2,'河东区');
insert into TbCity(pid,city) values(2,'河西区');
insert into TbCity(pid,city) values(2,'南开区');
insert into TbCity(pid,city) values(2,'河北区');
insert into TbCity(pid,city) values(2,'红桥区');
insert into TbCity(pid,city) values(2,'东丽区');
insert into TbCity(pid,city) values(2,'西青区');
insert into TbCity(pid,city) values(2,'北辰区');
insert into TbCity(pid,city) values(2,'津南区');
insert into TbCity(pid,city) values(2,'武清区');
insert into TbCity(pid,city) values(2,'宝坻区');
insert into TbCity(pid,city) values(2,'滨海新区');
insert into TbCity(pid,city) values(2,'静海县');
insert into TbCity(pid,city) values(2,'宁河县');
insert into TbCity(pid,city) values(2,'蓟县');
insert into TbCity(pid,city) values(3,'黄浦区');
insert into TbCity(pid,city) values(3,'卢湾区');
insert into TbCity(pid,city) values(3,'徐汇区');
insert into TbCity(pid,city) values(3,'长宁区');
insert into TbCity(pid,city) values(3,'静安区');
insert into TbCity(pid,city) values(3,'普陀区');
insert into TbCity(pid,city) values(3,'闸北区');
insert into TbCity(pid,city) values(3,'虹口区');
insert into TbCity(pid,city) values(3,'杨浦区');
insert into TbCity(pid,city) values(3,'闵行区');
insert into TbCity(pid,city) values(3,'宝山区');
insert into TbCity(pid,city) values(3,'嘉定区');
insert into TbCity(pid,city) values(3,'浦东新区');
insert into TbCity(pid,city) values(3,'金山区');
insert into TbCity(pid,city) values(3,'松江区');
insert into TbCity(pid,city) values(3,'青浦区');
insert into TbCity(pid,city) values(3,'奉贤区');
insert into TbCity(pid,city) values(3,'崇明县');
insert into TbCity(pid,city) values(4,'渝中区');
insert into TbCity(pid,city) values(4,'大渡口区');
insert into TbCity(pid,city) values(4,'江北区');
insert into TbCity(pid,city) values(4,'南岸区');
insert into TbCity(pid,city) values(4,'北碚区');
insert into TbCity(pid,city) values(4,'渝北区');
insert into TbCity(pid,city) values(4,'巴南区');
insert into TbCity(pid,city) values(4,'长寿区');
insert into TbCity(pid,city) values(4,'双桥区');
insert into TbCity(pid,city) values(4,'沙坪坝区');
insert into TbCity(pid,city) values(4,'万盛区');
insert into TbCity(pid,city) values(4,'万州区');
insert into TbCity(pid,city) values(4,'涪陵区');
insert into TbCity(pid,city) values(4,'黔江区');
insert into TbCity(pid,city) values(4,'永川区');
insert into TbCity(pid,city) values(4,'合川区');
insert into TbCity(pid,city) values(4,'江津区');
insert into TbCity(pid,city) values(4,'九龙坡区');
insert into TbCity(pid,city) values(4,'南川区');
insert into TbCity(pid,city) values(4,'綦江县');
insert into TbCity(pid,city) values(4,'潼南县');
insert into TbCity(pid,city) values(4,'荣昌县');
insert into TbCity(pid,city) values(4,'璧山县');
insert into TbCity(pid,city) values(4,'大足县');
insert into TbCity(pid,city) values(4,'铜梁县');
insert into TbCity(pid,city) values(4,'梁平县');
insert into TbCity(pid,city) values(4,'开县');
insert into TbCity(pid,city) values(4,'忠县');
insert into TbCity(pid,city) values(4,'城口县');
insert into TbCity(pid,city) values(4,'垫江县');
insert into TbCity(pid,city) values(4,'武隆县');
insert into TbCity(pid,city) values(4,'丰都县');
insert into TbCity(pid,city) values(4,'奉节县');
insert into TbCity(pid,city) values(4,'云阳县');
insert into TbCity(pid,city) values(4,'巫溪县');
insert into TbCity(pid,city) values(4,'巫山县');
insert into TbCity(pid,city) values(4,'石柱土家族自治县');
insert into TbCity(pid,city) values(4,'秀山土家族苗族自治县');
insert into TbCity(pid,city) values(4,'酉阳土家族苗族自治县');
insert into TbCity(pid,city) values(4,'彭水苗族土家族自治县');
insert into TbCity(pid,city) values(5,'石家庄');
insert into TbCity(pid,city) values(5,'唐山');
insert into TbCity(pid,city) values(5,'秦皇岛');
insert into TbCity(pid,city) values(5,'邯郸');
insert into TbCity(pid,city) values(5,'邢台');
insert into TbCity(pid,city) values(5,'保定');
insert into TbCity(pid,city) values(5,'张家口');
insert into TbCity(pid,city) values(5,'承德');
insert into TbCity(pid,city) values(5,'沧州');
insert into TbCity(pid,city) values(5,'廊坊');
insert into TbCity(pid,city) values(5,'衡水');
insert into TbCity(pid,city) values(6,'太原');
insert into TbCity(pid,city) values(6,'大同');
insert into TbCity(pid,city) values(6,'阳泉');
insert into TbCity(pid,city) values(6,'长治');
insert into TbCity(pid,city) values(6,'晋城');
insert into TbCity(pid,city) values(6,'朔州');
insert into TbCity(pid,city) values(6,'晋中');
insert into TbCity(pid,city) values(6,'运城');
insert into TbCity(pid,city) values(6,'忻州');
insert into TbCity(pid,city) values(6,'临汾');
insert into TbCity(pid,city) values(6,'吕梁');
insert into TbCity(pid,city) values(7,'沈阳');
insert into TbCity(pid,city) values(7,'大连');
insert into TbCity(pid,city) values(7,'鞍山');
insert into TbCity(pid,city) values(7,'抚顺');
insert into TbCity(pid,city) values(7,'本溪');
insert into TbCity(pid,city) values(7,'丹东');
insert into TbCity(pid,city) values(7,'锦州');
insert into TbCity(pid,city) values(7,'营口');
insert into TbCity(pid,city) values(7,'阜新');
insert into TbCity(pid,city) values(7,'辽阳');
insert into TbCity(pid,city) values(7,'盘锦');
insert into TbCity(pid,city) values(7,'铁岭');
insert into TbCity(pid,city) values(7,'朝阳');
insert into TbCity(pid,city) values(7,'葫芦岛');
insert into TbCity(pid,city) values(8,'长春');
insert into TbCity(pid,city) values(8,'吉林');
insert into TbCity(pid,city) values(8,'四平');
insert into TbCity(pid,city) values(8,'辽源');
insert into TbCity(pid,city) values(8,'通化');
insert into TbCity(pid,city) values(8,'白山');
insert into TbCity(pid,city) values(8,'松原');
insert into TbCity(pid,city) values(8,'白城');
insert into TbCity(pid,city) values(8,'延边朝鲜族自治州');
insert into TbCity(pid,city) values(9,'哈尔滨');
insert into TbCity(pid,city) values(9,'齐齐哈尔');
insert into TbCity(pid,city) values(9,'鹤岗');
insert into TbCity(pid,city) values(9,'双鸭山');
insert into TbCity(pid,city) values(9,'鸡西');
insert into TbCity(pid,city) values(9,'大庆');
insert into TbCity(pid,city) values(9,'伊春');
insert into TbCity(pid,city) values(9,'牡丹江');
insert into TbCity(pid,city) values(9,'佳木斯');
insert into TbCity(pid,city) values(9,'七台河');
insert into TbCity(pid,city) values(9,'黑河');
insert into TbCity(pid,city) values(9,'绥化');
insert into TbCity(pid,city) values(9,'大兴安岭');
insert into TbCity(pid,city) values(10,'南京');
insert into TbCity(pid,city) values(10,'苏州');
insert into TbCity(pid,city) values(10,'无锡');
insert into TbCity(pid,city) values(10,'常州');
insert into TbCity(pid,city) values(10,'镇江');
insert into TbCity(pid,city) values(10,'南通');
insert into TbCity(pid,city) values(10,'泰州');
insert into TbCity(pid,city) values(10,'扬州');
insert into TbCity(pid,city) values(10,'盐城');
insert into TbCity(pid,city) values(10,'连云港');
insert into TbCity(pid,city) values(10,'徐州');
insert into TbCity(pid,city) values(10,'淮安');
insert into TbCity(pid,city) values(10,'宿迁');
insert into TbCity(pid,city) values(11,'杭州');
insert into TbCity(pid,city) values(11,'宁波');
insert into TbCity(pid,city) values(11,'温州');
insert into TbCity(pid,city) values(11,'嘉兴');
insert into TbCity(pid,city) values(11,'湖州');
insert into TbCity(pid,city) values(11,'绍兴');
insert into TbCity(pid,city) values(11,'金华');
insert into TbCity(pid,city) values(11,'衢州');
insert into TbCity(pid,city) values(11,'舟山');
insert into TbCity(pid,city) values(11,'台州');
insert into TbCity(pid,city) values(11,'丽水');
insert into TbCity(pid,city) values(12,'合肥');
insert into TbCity(pid,city) values(12,'芜湖');
insert into TbCity(pid,city) values(12,'蚌埠');
insert into TbCity(pid,city) values(12,'淮南');
insert into TbCity(pid,city) values(12,'马鞍山');
insert into TbCity(pid,city) values(12,'淮北');
insert into TbCity(pid,city) values(12,'铜陵');
insert into TbCity(pid,city) values(12,'安庆');
insert into TbCity(pid,city) values(12,'黄山');
insert into TbCity(pid,city) values(12,'滁州');
insert into TbCity(pid,city) values(12,'阜阳');
insert into TbCity(pid,city) values(12,'宿州');
insert into TbCity(pid,city) values(12,'巢湖');
insert into TbCity(pid,city) values(12,'六安');
insert into TbCity(pid,city) values(12,'亳州');
insert into TbCity(pid,city) values(12,'池州');
insert into TbCity(pid,city) values(12,'宣城');
insert into TbCity(pid,city) values(13,'福州');
insert into TbCity(pid,city) values(13,'厦门');
insert into TbCity(pid,city) values(13,'莆田');
insert into TbCity(pid,city) values(13,'三明');
insert into TbCity(pid,city) values(13,'泉州');
insert into TbCity(pid,city) values(13,'漳州');
insert into TbCity(pid,city) values(13,'南平');
insert into TbCity(pid,city) values(13,'龙岩');
insert into TbCity(pid,city) values(13,'宁德');
insert into TbCity(pid,city) values(14,'南昌');
insert into TbCity(pid,city) values(14,'景德镇');
insert into TbCity(pid,city) values(14,'萍乡');
insert into TbCity(pid,city) values(14,'九江');
insert into TbCity(pid,city) values(14,'新余');
insert into TbCity(pid,city) values(14,'鹰潭');
insert into TbCity(pid,city) values(14,'赣州');
insert into TbCity(pid,city) values(14,'吉安');
insert into TbCity(pid,city) values(14,'宜春');
insert into TbCity(pid,city) values(14,'抚州');
insert into TbCity(pid,city) values(14,'上饶');
insert into TbCity(pid,city) values(15,'济南');
insert into TbCity(pid,city) values(15,'青岛');
insert into TbCity(pid,city) values(15,'淄博');
insert into TbCity(pid,city) values(15,'枣庄');
insert into TbCity(pid,city) values(15,'东营');
insert into TbCity(pid,city) values(15,'烟台');
insert into TbCity(pid,city) values(15,'潍坊');
insert into TbCity(pid,city) values(15,'济宁');
insert into TbCity(pid,city) values(15,'泰安');
insert into TbCity(pid,city) values(15,'威海');
insert into TbCity(pid,city) values(15,'日照');
insert into TbCity(pid,city) values(15,'莱芜');
insert into TbCity(pid,city) values(15,'临沂');
insert into TbCity(pid,city) values(15,'德州');
insert into TbCity(pid,city) values(15,'聊城');
insert into TbCity(pid,city) values(15,'滨州');
insert into TbCity(pid,city) values(15,'菏泽');
insert into TbCity(pid,city) values(16,'郑州');
insert into TbCity(pid,city) values(16,'开封');
insert into TbCity(pid,city) values(16,'洛阳');
insert into TbCity(pid,city) values(16,'平顶山');
insert into TbCity(pid,city) values(16,'安阳');
insert into TbCity(pid,city) values(16,'鹤壁');
insert into TbCity(pid,city) values(16,'新乡');
insert into TbCity(pid,city) values(16,'焦作');
insert into TbCity(pid,city) values(16,'濮阳');
insert into TbCity(pid,city) values(16,'许昌');
insert into TbCity(pid,city) values(16,'漯河');
insert into TbCity(pid,city) values(16,'三门峡');
insert into TbCity(pid,city) values(16,'南阳');
insert into TbCity(pid,city) values(16,'商丘');
insert into TbCity(pid,city) values(16,'信阳');
insert into TbCity(pid,city) values(16,'周口');
insert into TbCity(pid,city) values(16,'驻马店');
insert into TbCity(pid,city) values(17,'武汉');
insert into TbCity(pid,city) values(17,'黄石');
insert into TbCity(pid,city) values(17,'十堰');
insert into TbCity(pid,city) values(17,'荆州');
insert into TbCity(pid,city) values(17,'宜昌');
insert into TbCity(pid,city) values(17,'襄樊');
insert into TbCity(pid,city) values(17,'鄂州');
insert into TbCity(pid,city) values(17,'荆门');
insert into TbCity(pid,city) values(17,'孝感');
insert into TbCity(pid,city) values(17,'黄冈');
insert into TbCity(pid,city) values(17,'咸宁');
insert into TbCity(pid,city) values(17,'随州');
insert into TbCity(pid,city) values(17,'恩施');
insert into TbCity(pid,city) values(18,'长沙');
insert into TbCity(pid,city) values(18,'株洲');
insert into TbCity(pid,city) values(18,'湘潭');
insert into TbCity(pid,city) values(18,'衡阳');
insert into TbCity(pid,city) values(18,'邵阳');
insert into TbCity(pid,city) values(18,'岳阳');
insert into TbCity(pid,city) values(18,'常德');
insert into TbCity(pid,city) values(18,'张家界');
insert into TbCity(pid,city) values(18,'益阳');
insert into TbCity(pid,city) values(18,'郴州');
insert into TbCity(pid,city) values(18,'永州');
insert into TbCity(pid,city) values(18,'怀化');
insert into TbCity(pid,city) values(18,'娄底');
insert into TbCity(pid,city) values(18,'湘西');
insert into TbCity(pid,city) values(19,'广州');
insert into TbCity(pid,city) values(19,'深圳');
insert into TbCity(pid,city) values(19,'珠海');
insert into TbCity(pid,city) values(19,'汕头');
insert into TbCity(pid,city) values(19,'韶关');
insert into TbCity(pid,city) values(19,'佛山');
insert into TbCity(pid,city) values(19,'江门');
insert into TbCity(pid,city) values(19,'湛江');
insert into TbCity(pid,city) values(19,'茂名');
insert into TbCity(pid,city) values(19,'肇庆');
insert into TbCity(pid,city) values(19,'惠州');
insert into TbCity(pid,city) values(19,'梅州');
insert into TbCity(pid,city) values(19,'汕尾');
insert into TbCity(pid,city) values(19,'河源');
insert into TbCity(pid,city) values(19,'阳江');
insert into TbCity(pid,city) values(19,'清远');
insert into TbCity(pid,city) values(19,'东莞');
insert into TbCity(pid,city) values(19,'中山');
insert into TbCity(pid,city) values(19,'潮州');
insert into TbCity(pid,city) values(19,'揭阳');
insert into TbCity(pid,city) values(19,'云浮');
insert into TbCity(pid,city) values(20,'海口');
insert into TbCity(pid,city) values(20,'三亚');
insert into TbCity(pid,city) values(21,'成都');
insert into TbCity(pid,city) values(21,'自贡');
insert into TbCity(pid,city) values(21,'攀枝花');
insert into TbCity(pid,city) values(21,'泸州');
insert into TbCity(pid,city) values(21,'德阳');
insert into TbCity(pid,city) values(21,'绵阳');
insert into TbCity(pid,city) values(21,'广元');
insert into TbCity(pid,city) values(21,'遂宁');
insert into TbCity(pid,city) values(21,'内江');
insert into TbCity(pid,city) values(21,'乐山');
insert into TbCity(pid,city) values(21,'南充');
insert into TbCity(pid,city) values(21,'眉山');
insert into TbCity(pid,city) values(21,'宜宾');
insert into TbCity(pid,city) values(21,'广安');
insert into TbCity(pid,city) values(21,'达州');
insert into TbCity(pid,city) values(21,'雅安');
insert into TbCity(pid,city) values(21,'巴中');
insert into TbCity(pid,city) values(21,'资阳');
insert into TbCity(pid,city) values(21,'阿坝');
insert into TbCity(pid,city) values(21,'甘孜');
insert into TbCity(pid,city) values(21,'凉山');
insert into TbCity(pid,city) values(22,'贵阳');
insert into TbCity(pid,city) values(22,'六盘水');
insert into TbCity(pid,city) values(22,'遵义');
insert into TbCity(pid,city) values(22,'安顺');
insert into TbCity(pid,city) values(22,'铜仁');
insert into TbCity(pid,city) values(22,'毕节');
insert into TbCity(pid,city) values(22,'黔西南');
insert into TbCity(pid,city) values(22,'黔东南');
insert into TbCity(pid,city) values(22,'黔南');
insert into TbCity(pid,city) values(23,'昆明');
insert into TbCity(pid,city) values(23,'曲靖');
insert into TbCity(pid,city) values(23,'玉溪');
insert into TbCity(pid,city) values(23,'保山');
insert into TbCity(pid,city) values(23,'昭通');
insert into TbCity(pid,city) values(23,'丽江');
insert into TbCity(pid,city) values(23,'普洱');
insert into TbCity(pid,city) values(23,'临沧');
insert into TbCity(pid,city) values(23,'德宏');
insert into TbCity(pid,city) values(23,'怒江');
insert into TbCity(pid,city) values(23,'迪庆');
insert into TbCity(pid,city) values(23,'大理');
insert into TbCity(pid,city) values(23,'楚雄');
insert into TbCity(pid,city) values(23,'红河');
insert into TbCity(pid,city) values(23,'文山');
insert into TbCity(pid,city) values(23,'西双版纳');
insert into TbCity(pid,city) values(24,'西安');
insert into TbCity(pid,city) values(24,'铜川');
insert into TbCity(pid,city) values(24,'宝鸡');
insert into TbCity(pid,city) values(24,'咸阳');
insert into TbCity(pid,city) values(24,'渭南');
insert into TbCity(pid,city) values(24,'延安');
insert into TbCity(pid,city) values(24,'汉中');
insert into TbCity(pid,city) values(24,'榆林');
insert into TbCity(pid,city) values(24,'安康');
insert into TbCity(pid,city) values(24,'商洛');
insert into TbCity(pid,city) values(25,'兰州');
insert into TbCity(pid,city) values(25,'嘉峪关');
insert into TbCity(pid,city) values(25,'金昌');
insert into TbCity(pid,city) values(25,'白银');
insert into TbCity(pid,city) values(25,'天水');
insert into TbCity(pid,city) values(25,'武威');
insert into TbCity(pid,city) values(25,'酒泉');
insert into TbCity(pid,city) values(25,'张掖');
insert into TbCity(pid,city) values(25,'庆阳');
insert into TbCity(pid,city) values(25,'平凉');
insert into TbCity(pid,city) values(25,'定西');
insert into TbCity(pid,city) values(25,'陇南');
insert into TbCity(pid,city) values(25,'临夏');
insert into TbCity(pid,city) values(25,'甘南');
insert into TbCity(pid,city) values(26,'西宁');
insert into TbCity(pid,city) values(26,'海东');
insert into TbCity(pid,city) values(26,'海北');
insert into TbCity(pid,city) values(26,'海南');
insert into TbCity(pid,city) values(26,'黄南');
insert into TbCity(pid,city) values(26,'果洛');
insert into TbCity(pid,city) values(26,'玉树');
insert into TbCity(pid,city) values(26,'海西');
insert into TbCity(pid,city) values(27,'呼和浩特');
insert into TbCity(pid,city) values(27,'包头');
insert into TbCity(pid,city) values(27,'乌海');
insert into TbCity(pid,city) values(27,'赤峰');
insert into TbCity(pid,city) values(27,'通辽');
insert into TbCity(pid,city) values(27,'鄂尔多斯');
insert into TbCity(pid,city) values(27,'呼伦贝尔');
insert into TbCity(pid,city) values(27,'巴彦淖尔');
insert into TbCity(pid,city) values(27,'乌兰察布');
insert into TbCity(pid,city) values(27,'锡林郭勒盟');
insert into TbCity(pid,city) values(27,'兴安盟');
insert into TbCity(pid,city) values(27,'阿拉善盟');
insert into TbCity(pid,city) values(28,'南宁');
insert into TbCity(pid,city) values(28,'柳州');
insert into TbCity(pid,city) values(28,'桂林');
insert into TbCity(pid,city) values(28,'梧州');
insert into TbCity(pid,city) values(28,'北海');
insert into TbCity(pid,city) values(28,'防城港');
insert into TbCity(pid,city) values(28,'钦州');
insert into TbCity(pid,city) values(28,'贵港');
insert into TbCity(pid,city) values(28,'玉林');
insert into TbCity(pid,city) values(28,'百色');
insert into TbCity(pid,city) values(28,'贺州');
insert into TbCity(pid,city) values(28,'河池');
insert into TbCity(pid,city) values(28,'来宾');
insert into TbCity(pid,city) values(28,'崇左');
insert into TbCity(pid,city) values(29,'拉萨');
insert into TbCity(pid,city) values(29,'那曲');
insert into TbCity(pid,city) values(29,'昌都');
insert into TbCity(pid,city) values(29,'林芝');
insert into TbCity(pid,city) values(29,'山南');
insert into TbCity(pid,city) values(29,'日喀则');
insert into TbCity(pid,city) values(29,'阿里');
insert into TbCity(pid,city) values(30,'银川');
insert into TbCity(pid,city) values(30,'石嘴山');
insert into TbCity(pid,city) values(30,'吴忠');
insert into TbCity(pid,city) values(30,'固原');
insert into TbCity(pid,city) values(30,'中卫');
insert into TbCity(pid,city) values(31,'乌鲁木齐');
insert into TbCity(pid,city) values(31,'克拉玛依');
insert into TbCity(pid,city) values(31,'吐鲁番');
insert into TbCity(pid,city) values(31,'哈密');
insert into TbCity(pid,city) values(31,'和田');
insert into TbCity(pid,city) values(31,'阿克苏');
insert into TbCity(pid,city) values(31,'喀什');
insert into TbCity(pid,city) values(31,'克孜勒苏');
insert into TbCity(pid,city) values(31,'巴音郭楞');
insert into TbCity(pid,city) values(31,'昌吉');
insert into TbCity(pid,city) values(31,'博尔塔拉');
insert into TbCity(pid,city) values(31,'伊犁');
insert into TbCity(pid,city) values(31,'塔城');
insert into TbCity(pid,city) values(31,'阿勒泰');
insert into TbCity(pid,city) values(32,'香港岛');
insert into TbCity(pid,city) values(32,'九龙东');
insert into TbCity(pid,city) values(32,'九龙西');
insert into TbCity(pid,city) values(32,'新界东');
insert into TbCity(pid,city) values(32,'新界西');
insert into TbCity(pid,city) values(33,'澳门半岛');
insert into TbCity(pid,city) values(33,'离岛');
insert into TbCity(pid,city) values(34,'台北');
insert into TbCity(pid,city) values(34,'高雄');
insert into TbCity(pid,city) values(34,'基隆');
insert into TbCity(pid,city) values(34,'新竹');
insert into TbCity(pid,city) values(34,'台中');
insert into TbCity(pid,city) values(34,'嘉义');
insert into TbCity(pid,city) values(34,'台南市');

select pid,province,info,lastupdate from TbProvince;
select cid,pid,city,info,lastupdate from TbCity;