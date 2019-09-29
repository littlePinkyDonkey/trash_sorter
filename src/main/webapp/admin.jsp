<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="ru">
<head>
    <title>Title</title>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <link href="bootstrap/css/bootstrap.css" rel="stylesheet">
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
    <!-- Bootstrap core CSS -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="fontawesome-free/css/all.min.css" rel="stylesheet">
    <link href="simple-line-icons/css/simple-line-icons.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
    <!-- Bootstrap core JavaScript -->
    <script src="jquery/jquery.min.js"></script>
    <script src="bootstrap/js/bootstrap.bundle.min.js"></script>
    <!-- Custom styles for this template -->
    <link href="css/landing-page.min.css" rel="stylesheet">
</head>
<body>


<section class="features-icons bg-light text-center">
    <div class="container">
        <div class="row no-gutters">

            <div class="col-lg-6">
                <div class="table-responsive">
                    <h2>Мусорные баки</h2>
                    <ul>
                        <li>Выберите фото со штрихкодом или сфотографируйте шрихкод на мусоре
                        </li>
                        <li>Загрузите изображение черех кнопку "Загрузить" либо из фотоальбома, либо сфоткаться
                        </li>
                        <li>Откроется дополнительное окно, для потверждения информации о мусоре
                        </li>
                        <li>После подтверждения придет уведомление можно выкинуть или нет
                        </li>
                    </ul>
                    <h4>Добавить новый бак</h4>
                    <p><form action="${pageContext.servletContext.contextPath}/admin/add" method="POST">
                    <p><label>name: <input type="text" name="tankName"></label></p>
                    <p><input type="submit" align="center" value="Submit"/></p>


                </div>
            </div>
            <div class="col-lg-6">
                <div class="text-xs-center" class="table-responsive" class="table"   >
                    <h2>Данные по бакам</h2>
                    <table border="1" cellpadding="5 " >
                        <thead class="thead-dark">
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Name</th>
                            <th scope="col">Qr-code</th>
                            <th scope="col">Function</th>
                        </tr>
                        <c:forEach items="${tanks}" var="tank" varStatus="status">
                        <tr>
                            <td>${tank.id}</td>
                            <td>${tank.tankName}</td>
                            <td>${tank.qr}</td>
                            <td>
                                <a href="${pageContext.servletContext.contextPath}/admin/edit?id=${tank.id}&item=tank">Edit</a>
                                <a href="${pageContext.servletContext.contextPath}/admin/delete?id=${tank.id}&item=tank">Delete</a>
                            </td>
                        </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
    </div>
</section>
<section class="features-icons bg-light text-center">
    <div class="container">
        <div class="row no-gutters">
            <div class="col-lg-6">
                <div class="table-responsive">
                    <h2>Категории мусора </h2>
                    <ul>
                        <li>Выберите фото со штрихкодом или сфотографируйте шрихкод на мусоре
                        </li>
                        <li>Загрузите изображение черех кнопку "Загрузить" либо из фотоальбома, либо сфоткаться
                        </li>
                        <li>Откроется дополнительное окно, для потверждения информации о мусоре
                        </li>
                        <li>После подтверждения придет уведомление можно выкинуть или нет
                        </li>
                    </ul>
                    <p><a class="btn btn-primary" href="#">Добавить новое наименование мусора</a></p>
                </div>
            </div>
            <div class="col-lg-6">
                <div class="table-responsive" id="table2" class="text-xs-center" >
                    <h2>Данные по категориям мусора</h2>
                    <table border="1" cellpadding="5 " >
                        <thead class="thead-dark">
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Name</th>

                            <th scope="col">Function</th>
                        </thead>
                        </tr>
                        <c:forEach items="${categories}" var="category" varStatus="status">
                            <tr>
                                <td>${category.id}</td>
                                <td>${category.trashCategoria}</td>
                                <td>
                                    <a href="${pageContext.servletContext.contextPath}/admin/delete?id=${category.id}&item=category">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
    </div>
</section>
<section class="features-icons bg-light text-center">
    <div class="container">
        <div class="row no-gutters">


            <div class="col-lg-6">
                <div class="table-responsive">
                    <h2>Наименования мусора</h2>
                    <ul>
                        <li>Выберите фото со штрихкодом или сфотографируйте шрихкод на мусоре
                        </li>
                        <li>Загрузите изображение черех кнопку "Загрузить" либо из фотоальбома, либо сфоткаться
                        </li>
                        <li>Откроется дополнительное окно, для потверждения информации о мусоре
                        </li>
                        <li>После подтверждения придет уведомление можно выкинуть или нет
                        </li>
                    </ul>
                </div>
            </div>



            <div class="col-lg-6">
                <div class="table-responsive" id="table3" class="text-xs-center">
                    <h2>Данные по наименованиям мусора</h2>
                    <table border="1" cellpadding="5">
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Name</th>
                            <th scope="col">Function</th>
                        </tr>
                        <c:forEach items="${trash}" var="trash" varStatus="status">
                            <tr>
                                <td>${trash.id}</td>
                                <td>${trash.name}</td>
                                <td>
                                    <a href="${pageContext.servletContext.contextPath}/admin/edit?id=${trash.id}&item=trash">Edit</a>
                                    <a href="${pageContext.servletContext.contextPath}/admin/delete?id=${trash.id}&item=trash">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
    </div>
</section>





<!-- Footer -->
<footer class="footer bg-light">
    <div class="container">
        <div class="row">
            <div class="col-lg-6 h-100 text-center text-lg-left my-auto">

                <p class="text-muted small mb-4 mb-lg-0">&copy; 2019. Все права защищены</p>
            </div>

        </div>
    </div>
</footer>
</body>
</html>
