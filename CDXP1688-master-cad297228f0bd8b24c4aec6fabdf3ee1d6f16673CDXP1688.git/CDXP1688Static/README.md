# 常德壹路巴巴前端项目

## 项目依赖说明

- 需要配置安装`nodejs`,`cnpm`,`gulp`
- 配置安装完需要启动`cnpm install`完成插件安装

## 开发模式说明

- `nginx-start.bat`和`nginx-stop.bat`是启动和停止nginx的命令
- 执行`gulp`初始打包项目
- 执行`gulp app-watch`或者`app-dev.bat`进入手机端开发模式
- 执行`gulp manage-watch`或者`manage-dev.bat`进入后台管理开发模式
- 执行`browser`会打开浏览进入首页,路径加`/app/`会打开手机端界面，路径加`/manage/`会打开后台管理界面，什么都不加默认是`cdxp1688.com`目录
- 执行`spring-start.bat`可以启动后台服务