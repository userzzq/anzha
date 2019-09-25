const browser = '"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe" http://127.0.0.1:25000 http://127.0.0.1:25000/app/#!/route/page/user/flash http://127.0.0.1:25000/app/#!/route/page/worker/flash http://127.0.0.1:25000/manage/';
var exec = require('child_process').exec;
exec(browser, function(error, std, err) {
  console.log(error, std, err);
});
