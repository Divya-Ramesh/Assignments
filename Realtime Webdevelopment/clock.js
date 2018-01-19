var app = require('express')();
var http = require('http').Server(app);
var io = require('socket.io')(http);

app.get('/', function(req, res) {
   res.sendfile('clock.html');
});

io.on('connection', function(socket) {
   socket.on('clientEvent', function(data) {
	   console.log(data);
      io.sockets.emit('broadcast',data)
   });
});


io.on('connection', function(socket) {
   socket.on('clientEvent1', function(data) {
	   console.log(data);
      io.sockets.emit('broadcast1',data)
   });
});



http.listen(3001, function() {
   console.log('listening on localhost:3001');
});