use CDXP1688;

drop table if exists TbConfig;
drop table if exists TbToken;
drop table if exists TbTokenInfo;

create table TbConfig
(
  configKey varchar(50) primary key comment '配置键名，主键',
  configValue varchar(2000) not null comment '配置键值',
  lastupdate timestamp on update now() default now() not null comment '配置最后更新时间'
)comment '系统配置表';

create table TbToken
(
  token varchar(50) primary key comment '令牌值，自然主键',
  lastupdate timestamp on update now() default now() not null comment '令牌环最后更新时间'
)comment 'Token追踪表';

create table TbTokenInfo
(
  token varchar(50) comment '令牌值',
  infokey varchar(50) comment '令牌附加信息key',
  info varchar(2000) comment '令牌附加信息',
  lastupdate timestamp on update now() default now() not null comment '令牌环最后更新时间',
  constraint pkTbTokenInfo primary key(token,infokey)
)comment 'Token附加信息表';

/* token过期时间配置 */
insert into TbConfig(configKey,configValue) values('token.timeout','30');
/* 短信校验码验证配置 */
insert into TbConfig(configKey,configValue) values('SmsConfig','{"accesskeyid":"LTAITTlZcoYVygXQ","accesskeysecret":"Pw6wWbgJQbBBko3pTL7rXsqDGeRU3O","domain":"dysmsapi.aliyuncs.com","product":"Dysmsapi","region1":"cn-hangzhou","region2":"cn-hangzhou","sign":"壹路巴巴服务平台","template":{"validateCode":"SMS_154588044","workerNotify":"SMS_160306585","userNotify":"SMS_160306586","cancelOrder":"SMS_160306587","findpwd":"SMS_163621137"}}');
/* 图片服务器地址配置 */
insert into TbConfig(configKey,configValue) values('upfile.server','https://klcxy.top/uploadfiles/');
/* 师傅在线模式配置 */
insert into TbConfig(configKey,configValue) values('worker.online','inwork');
/* 支付配置 */
insert into TbConfig(configKey,configValue) values('PayConfig','{"appid":"wxc108799082cbbae8","backUrl":"http://127.0.0.1:20000/pay/payback","body":"壹路巴巴-维修订单结算","key":"cdxp1688payappkeyinfom1234567890","mch_id":"1512123271","notify_url":"https://cdxp1688.com/pay/","payUrl":"https://api.mch.weixin.qq.com/pay/unifiedorder","scene_info":{"type":"Wap","wap_name":"壹路巴巴","wap_url":"https://cdxp1688.com/app/"},"trade_type":"MWEB"}');
/* 微信配置 */
insert into TbConfig(configKey,configValue) values('WxConfig','{"appid":"wxc108799082cbbae8","key":"cdxp1688payappkeyinfom1234567890","mch_id":"1512123271","openidCodeUrl":"https://open.weixin.qq.com/connect/oauth2/authorize?redirect_uri=%s&appid=%s&response_type=code&scope=snsapi_base&state=1#wechat_redirect","openidUrl":"https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&grant_type=authorization_code&code=%s","payUrl":"https://api.mch.weixin.qq.com/pay/unifiedorder","secret":"f5b888f67dd0dfe2a36f1ce299e865be","tokenUrl":"https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s"}');
/* 回调url配置 */
insert into TbConfig(configKey,configValue) values('CallbackUrlsConfig','{"openid":"https://cdxp1688.com/testpay/wx/openidBack","openidBack":"https://cdxp1688.com/testapp/#!/route/page/user/openidBack?openid=%s","pay":"https://cdxp1688.com/testapp/#!/route/page/user/weixiudingdan","payNotify":"https://cdxp1688.com/testpay/pay/notify","wxpay":"https://cdxp1688.com/testapp/#!/route/page/user/wxpay?%s"}');
/* 微信支付基本信息配置 */
insert into TbConfig(configKey,configValue) values('WxPayInfo','{"body":"壹路巴巴-维修订单结算","scene_info":{"wap_name":"壹路巴巴","wap_url":"https://cdxp1688.com/app/"}}');

select configKey,configValue,lastupdate from TbConfig;
select token,lastupdate from TbToken;
select token,infokey,info,lastupdate from TbTokenInfo;
