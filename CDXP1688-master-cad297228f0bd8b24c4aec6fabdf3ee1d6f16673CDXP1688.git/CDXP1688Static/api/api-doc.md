# 后台 api 接口文档

- user 接口

  - 用户登录 `/user/login` `{"tbUser":{"phone":"15973637383",password:"md5加密后的密码"}}`
  - 用户登出 `/user/logout` `{}`
  - 用户信息获取 `/user/queryUser` `{}`
  - 用户信息修改 `/user/modify` `{"tbUser": {"password":"md5加密后的密码","name":"用户姓名","address":"用户地址"}}` 全部参数都可以省略
  - 用户注册 `/user/reg` `{"phoneCode":"电话校验码","tbUser":{"phone":"电话","password":"md5加密后的密码","name":"用户姓名，可选","address":"用户地址，可选"}}`
  - 我要修 `/userfixinfo/fix` `{"tbUserFixInfo":{"info":"报修信息","phone":"联系电话","address":"地图api获取的","lat":"地图api获取的","lng":"地图api获取的","addressInfo","可选附件地址信息"}}` 上传文件信息请参考页面演示
  - 我要洗 `/userfixinfo/wash` `{"tbUserFixInfo":{"info":"报修信息","phone":"联系电话","address":"地图api获取的","lat":"地图api获取的","lng":"地图api获取的","addressInfo","可选附件地址信息"}}` 上传文件信息请参考页面演示
  - 我要装 `/userfixinfo/install` `{"tbUserFixInfo":{"info":"报修信息","phone":"联系电话","address":"地图api获取的","lat":"地图api获取的","lng":"地图api获取的","addressInfo","可选附件地址信息"}}` 上传文件信息请参考页面演示
  - 用户进行中下单查询 `/userfixinfo/query` `{分页参数}` 状态码请参考后台管理的用户下单查询说明
  - 用户已完成下单查询 `/userfixinfo/queryFinish` `{分页参数}`
  - 用户取消下单 `/userfixinfo/cancelOrder` `{"tbUserFixInfo.ufid":订单编号}`
  - 用户确认报价 `/userfixinfo/price` `{"tbUserFixInfo.ufid":订单编号}`
  - 用户支付 `/userfixinfo/pay` `{"tbUserFixInfo.ufid":订单编号}`
  - 找回密码发送验证码 `/util/sendFindPwd` `{"phone":"电话号码"}`
  - 找回密码 `/user/modifyPwd` `{"tbUser.phone":"电话号码","tbUser.password":"md5加密后的密码","phoneCode":"电话校验码"}`

- worker 接口

  - 师傅登入 `/worker/login` `{"tbWorker.phone":"电话","tbWorker.password":"md5加密后的密码"}`
  - 师傅登出 `/worker/logout` `{}`
  - 获取登录信息 `/worker/queryWork` `{}`
  - 师傅接入接单状态 `/worker/inwork` `{}`
  - 师傅退出接单状态 `/worker/notinwork` `{}`
  - 待处理接单信息查询 `/workerfixinfo/queryWorkerFixinfo` `{分页参数}`
  - 师傅进行中接单信息查询 `/workerfixinfo/queryOrder` `{分页参数}`
  - 师傅已完成接单信息查询 `/workerfixinfo/queryFinishOrder` `{分页参数}`
  - 师傅接单 `/workerfixinfo/pickOrder` `{"tbUserFixOrder.ufid":订单编号}`
  - 师傅报价 `/workerfixinfo/orderPrice` `{"tbUserFixOrder.ufoid":接单编号,"tbFixOrderDetail.price":报价}`
  - 师傅报价修改 `/workerfixinfo/modifyOrderPrice` `{"tbUserFixOrder.ufoid":接单编号,"tbFixOrderDetail.price":新报价}`
  - 师傅维修完成 `/workerfixinfo/finishWork` `{"tbUserFixOrder.ufoid":接单编号}`
  - 师傅订单完成 `/workerfixinfo/finish` `{"tbUserFixOrder.ufoid":接单编号}`
  - 指定订单的图片列表查询 `/workerfixinfo/queryObjectNamesByUserFixInfo` `{"tbUserFixInfo.ufid":订单id}`
  - 找回密码发送验证码 `/util/sendFindPwd` `{"phone":"电话号码"}`
  - 找回密码 `/worker/modifyPwd` `{"tbWorker.phone":"电话号码","tbWorker.password":"md5加密后的密码","phoneCode":"电话校验码"}`
  - 查询打款信息 `/worker/queryPay` `{"page":"分页参数"}`

- manage 接口

  - 管理员登录 `/adminuser/login` `{"tbAdminUser":{"username":"admin","password":"md5加密后的密码"}}`
  - 管理员密码修改 `/adminuser/modifyPwd` `{"oldPwd":"md5加密后的旧密码",tbAdminUser:{"password":"md5加密后的密码"}}`
  - 师傅查询 `/admin/worker/queryAll` `{"tbWorker":{"isEnable":"y或者n","phone":"电话模糊查询","name":"姓名模糊查询"}}` 全部参数都可以省略
  - 冻结师傅 `/admin/worker/disable` `{"tbWorker":{"wid":"师傅id"}}`
  - 启用师傅 `/admin/worker/enable` `{"tbWorker":{"wid":"师傅id"}}`
  - 用户查询 `/admin/user/queryAll` `{"tbUser":{"isEnable":"y或者n","phone":"电话模糊查询","name":"姓名模糊查询"}}` 全部参数都可以省略
  - 冻结用户 `/admin/user/disable` `{"tbUser":{"uid":"用户id"}}`
  - 启用用户 `/admin/user/enable` `{"tbUser":{"uid":"用户id"}}`
  - 报备查询 `/admin/workerReport/queryAll` `{"tbWorkerReport":{"username":"姓名模糊","phone":"电话模糊查询","worker":{"name":"报备师傅姓名模糊","phone":"报备师傅电话模糊查询"}}` 全部参数都可以省略
  - 用户下单查询 `/admin/userfixinfo/queryAll` `{"tbUserFixInfo":{"phone","电话号码模糊查询","fixtype":"维修类型，10：我要修，11：我要洗，12：我要装","status":"维修状态，10：已经下单，11，已经接单，12，用户取消，13，已经定价，14，维修完成，15，已经支付，99，订单完成}}` 全部参数都可以省略
  - 指定订单的图片列表查询 `/admin/userfixinfo/queryObjectNamesByUserFixInfo` `{"tbUserFixInfo.ufid":订单id}`
  - 师傅打款 `/adminpayrecode/add` `{"tbPayRecode":{"wid":3,"price":0.01}}`
  - 师傅信息查询 `/adminpayrecode/queryWorker` `{"page":"分页参数","tbWorker":{"phone":"电话模糊查询","name":"姓名模糊查询"}}` tbWorker参数可以省略
  - 师傅打款信息查询 `/adminpayrecode/queryByWorker` `{"page":"分页参数","tbPayRecode":{"wid":师傅id}`

- 通用接口
  - oss 信息查询 `/util/getOssObjUrl` `{"tbOssInfo.objectName":"对象的名称"}`
