<%@ page import="static sun.misc.Version.print" %>
<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
​
<html>
<head>
    ​
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    ​
    <title>TrashSorter admin</title>
    ​

    <link href="vendor/bootstrap/css/bootstrap.css" rel="stylesheet">
    ​
    <!-- Custom fonts for this template -->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet">
    <link href="vendor/simple-line-icons/css/simple-line-icons.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
    ​
    <link href="css/landing-page.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    ​
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    ​
    <script
            src="https://code.jquery.com/jquery-3.4.1.js"
            integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
            crossorigin="anonymous"></script>
    ​
</head>
​
<body>
​
<nav class="navbar navbar-light bg-light static-top;" style="margin-top: -23px;">
    <div class="container">
        <a class="navbar-brand" href="#">TrashSorter admin</a>
    </div>
</nav>
​
<section class="showcase">
    <div class="container-fluid p-0">
        <div class="row no-gutters">
            ​
            <!-- здесь ссылка на QR -->
            <div class="col-lg-6 order-lg-2 my-auto showcase-text text-center">
                <section class="features-icons text-center">
                    <div class="container">
                        <img class="img-fluid" class="img-responsive" src="${tank.qr}">
                        <h3>QR код</h3>
                        <!-- <p class="lead mb-0">бумага</p> -->
                        <div class="modal fade" id="exampleModal1" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLabel1">Добавить бак</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body">
                                        <form>
                                            <div class="form-group">
                                                <label for="recipient-name1" class="col-form-label">Наименование:</label>
                                                <input type="text" class="form-control" id="recipient-name1">
                                            </div>
                                        </form>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Закрыть</button>
                                        <button type="button" class="btn btn-primary">Сохранить</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
                ​
            </div>
            <div class="col-lg-6 order-lg-1 my-auto showcase-text text-center">
                <h1>${tank.tankName}</h1>
            </div>
        </div>
        <div class="row no-gutters">
            ​
            <div class="col-lg-6 order-lg-2 my-auto showcase-text">
                <h2>Доступные категории мусора</h2>
                <p class="lead mb-0">Краткое описание категорий мусора, чем отличаются, какие варианты бывают</p>
            </div>
            <div class="col-lg-6 order-lg-1 my-auto showcase-text">
                <table class="table table-striped">
                    <tr>
                        <th class="id">ид</th>
                        <th>Категория</th>
                        <th>Выбрать</th>
                    </tr>
                    <c:forEach items="${categs}" var="categ" varStatus="status">
                        <tr>
                            <td>${categ.id}</td>
                            <td>${categ.trashCategoria}</td>
                            <td>
                                <input type="checkbox" class="editor" value=${categ.id}>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                <button type="button" class="btn btn-primary" data-toggle="modal"
                        id="sendSelectedCategory" data-target="#exampleModal2" data-whatever="@mdo">Добавить</button>
            </div>
        </div>
    </div>
</section>
​
<!-- Footer -->
<footer class="footer bg-light">
    <div class="container">
        <div class="row">
            <div class="col-lg-6 h-100 text-center text-lg-left my-auto">
                <ul class="list-inline mb-2">
                    <li class="list-inline-item">
                        <a href="#">О нас</a>
                    </li>
                    <li class="list-inline-item">&sdot;</li>
                    <li class="list-inline-item">
                        <a href="#">Контакты</a>
                    </li>
                    <li class="list-inline-item">&sdot;</li>
                    <li class="list-inline-item">
                        <a href="#">Условия</a>
                    </li>
                    <li class="list-inline-item">&sdot;</li>
                    <li class="list-inline-item">
                        <a href="#">Политика конфиденциальности</a>
                    </li>
                </ul>
                <p class="text-muted small mb-4 mb-lg-0">&copy; TrashSorter 2019. Все права защищены.</p>
            </div>
        </div>
    </div>
</footer>
​
​
<!-- Bootstrap core JavaScript -->
<script src="/js/admin.js"></script>
​
</body>
​
</html>