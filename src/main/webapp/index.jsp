<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        
        <title>Testjsfa8h4</title>
        
        <link href="css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <center>
            <div align="center" style="width: 600px;">
              <h1>Авторизация</h1>
              <form role="form" action="login" method="post" accept-charset="UTF-8" >
                <div class="form-group">
                  <label for="login">Логин</label>
                  <input type="text" class="form-control" id="login" name="login" placeholder="Введите имя групппы">
                </div>
                <div class="form-group">
                  <label for="password">Пароль</label>
                  <input type="password" class="form-control" id="password" name="password" placeholder="Введите описание группы">
                </div>

                <button type="submit" class="btn btn-primary">Login</button>
              </form>
            </div>
        </center>
        
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="js/jquery-1.11.0.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
