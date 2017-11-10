var express = require('express');
var http = require('http');
var mockserver = require('mockserver');

var port = 9000;

http.createServer(mockserver('./mocks')).listen(port, function () {
  console.log('REST Mock Server listening at port %d', port);
});
