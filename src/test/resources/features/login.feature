@Login

Feature: Login OrangeHRM

  Scenario: Login exitoso

    Given Yo esté en la pagina de login de HRM

    When Ingrese el usuario y contraseña

    And Haga click en el boton ingresar

    Then El usuario debe de ver el dashboard