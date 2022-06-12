<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link
    href="https://fonts.googleapis.com/css2?family=Nunito:ital,wght@0,300;0,400;0,500;0,600;0,700;1,600&display=swap"
    rel="stylesheet">
  <title>Dashboard - OCT</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"
    integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g=="
    crossorigin="anonymous" referrerpolicy="no-referrer" />
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"
    integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g=="
    crossorigin="anonymous" referrerpolicy="no-referrer" />
  <!-- CSS only -->
  <!-- JavaScript Bundle with Popper -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
    crossorigin="anonymous"></script>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
  <link rel="stylesheet" href="./css/relatorioentrada.css">
  <link rel="stylesheet" href="./css/style.css">
  <!-- Scrollbar Custom CSS -->
  <link rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/malihu-custom-scrollbar-plugin/3.1.5/jquery.mCustomScrollbar.min.css">
</head>

<body>
  <div class="wrapper">
    <!-- Sidebar  -->
    <nav id="sidebar">
      <div class="sidebar-header">
        <a href="#">
          <img src="./img/oct.png" alt="Logo Office Clean Tech" style="height:60px;">
        </a>
      </div>

      <ul class="list-unstyled components">
        <li class="active">
          <div class="icons-menu">
            <i class="fa-solid fa-house"></i>
            <a href="#homeSubmenu" data-toggle="collapse" aria-expanded="false">Dashboard</a>
          </div>

        </li>
        <li>
          <div class="icons-menu">
            <i class="fa-solid fa-box-archive"></i>
            <a href="#">Produtos</a>
          </div>
        </li>
        <li>
            <a href="#pageSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle ">Relatórios</a>

          <ul class="collapse list-unstyled" id="pageSubmenu">
            <li>
              <div class="icons-menu">
                <i class="fa-solid fa-arrow-up"></i>
                <a href="#">Entrada</a>

              </div>
            </li>
            <li>
              <div class="icons-menu">
                <i class="fa-solid fa-arrow-down"></i>
                <a href="#">Saída</a>

              </div>
            </li>
          </ul>
        </li>
        <li>
          <div class="icons-menu">

            <i class="fa-solid fa-users"></i>
            <a href="#">Fornecedores</a>
          </div>
        </li>
        <li>
          <div class="icons-menu">
            <i class="fa-solid fa-user-plus"></i>
            <a href="#">Usuários</a>
          </div>
        </li>
        <li id="li-logoff">
          <div class="icons-menu logoff">
            <i class="fa-solid fa-power-off"></i>
            <a href="#">Sair</a>
          </div>
        </li>
      </ul>

    </nav>
    <!-- Fim Sidebar  -->
    <main id="content">
      <!-- Menu -->
      <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">

          <button type="button" id="sidebarCollapse" class="btn text-white" style="background-color: #77B800;">
            <i class="fas fa-align-left"></i>
            <span>Menu</span>
          </button>

        </div>
      </nav>
      <!-- Fim Menu -->

      <header class="d-flex align-items-center gap-4 justify-content-between" id="header__btn">
        <div class="search-container">
          <form action="" method="post">
            <input type="text" placeholder="Buscar entrada" name="search">
            <button type="submit"><i class="fa fa-search"></i></button>
          </form>
        </div>
      </header>

      <!-- Tabela de Entrada -->

      <div class="table-responsive table-wrapper-scroll-y my-custom-scrollbar"
        style="margin-top: 40px; border-radius: 8px;  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.15);">
        <table class="table">
          <thead style="box-shadow: 0px 4px 4px rgb(0 0 0 / 5%);
                  border-radius: 8px;">
            <tr>
              <th scope="col">Lorem</th>
              <th scope="col">Lorem</th>
              <th scope="col">Lorem</th>
              <th scope="col">Lorem</th>
              <th scope="col">Lorem</th>
              <th scope="col">Lorem</th>
              <th scope="col">Lorem</th>
              <th scope="col">Lorem</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <th scope="row">lorem</th>
              <td>lorem</td>
              <td>lorem</td>
              <td>lorem</td>
              <td>lorem</td>
              <td>lorem</td>
              <td>lorem</td>
              <td>lorem</td>
              

            </tr>
            <tr>
              <th scope="row">Lorem</th>
              <td>lorem</td>
              <td>Lorem</td>
              <td>Lorem</td>
              <td>lorem</td>
              <td>Lorem</td>
              <td>Lorem</td>
              <td>Lorem</td>

            </tr>
            <tr>
              <th scope="row">lorem</th>
              <td>lorem</td>
              <td>lorem</td>
              <td>lorem</td>
              <td>lorem</td>
              <td>lorem</td>
              <td>lorem</td>
              <td>lorem</td>
              

            </tr>
            <tr>
              <th scope="row">Lorem</th>
              <td>lorem</td>
              <td>Lorem</td>
              <td>Lorem</td>
              <td>lorem</td>
              <td>Lorem</td>
              <td>Lorem</td>
              <td>Lorem</td>

            </tr>
            <tr>
              <th scope="row">lorem</th>
              <td>lorem</td>
              <td>lorem</td>
              <td>lorem</td>
              <td>lorem</td>
              <td>lorem</td>
              <td>lorem</td>
              <td>lorem</td>
              

            </tr>
            <tr>
              <th>Lorem</th>
              <td>lorem</td>
              <td>Lorem</td>
              <td>Lorem</td>
              <td>lorem</td>
              <td>Lorem</td>
              <td>Lorem</td>
              <td>Lorem</td>

            </tr>
            <tr>
              <th scope="row">lorem</th>
              <td>lorem</td>
              <td>lorem</td>
              <td>lorem</td>
              <td>lorem</td>
              <td>lorem</td>
              <td>lorem</td>
              <td>lorem</td>
              

            </tr>
            <tr>
              <th scope="row">Lorem</th>
              <td>lorem</td>
              <td>Lorem</td>
              <td>Lorem</td>
              <td>lorem</td>
              <td>Lorem</td>
              <td>Lorem</td>
              <td>Lorem</td>

            </tr>
            <tr>
              <th scope="row">lorem</th>
              <td>lorem</td>
              <td>lorem</td>
              <td>lorem</td>
              <td>lorem</td>
              <td>lorem</td>
              <td>lorem</td>
              <td>lorem</td>
              

            </tr>
            <tr>
              <th scope="row">Lorem</th>
              <td>lorem</td>
              <td>Lorem</td>
              <td>Lorem</td>
              <td>lorem</td>
              <td>Lorem</td>
              <td>Lorem</td>
              <td>Lorem</td>

            </tr>

          </tbody>
        </table>
      </div>

    </main>

    <!-- jQuery CDN - Slim version (=without AJAX) -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
      integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
      crossorigin="anonymous"></script>
    <!-- Popper.JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"
      integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ"
      crossorigin="anonymous"></script>
    <!-- Bootstrap JS -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"
      integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm"
      crossorigin="anonymous"></script>
    <!-- jQuery Custom Scroller CDN -->
    <script
      src="https://cdnjs.cloudflare.com/ajax/libs/malihu-custom-scrollbar-plugin/3.1.5/jquery.mCustomScrollbar.concat.min.js"></script>

    <script type="text/javascript">
      $(document).ready(function () {
        $("#sidebar").mCustomScrollbar({
          theme: "minimal"
        });

        $('#sidebarCollapse').on('click', function () {
          $('#sidebar, #content').toggleClass('active');
          $('.collapse.in').toggleClass('in');
          $('a[aria-expanded=true]').attr('aria-expanded', 'false');
        });
      });
    </script>
</body>

</html>