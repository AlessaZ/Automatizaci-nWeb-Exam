Feature: Product - Store

  @Login
  Scenario Outline: : Validación del precio de un producto

  Given estoy en la página de la tienda
  And me logueo con mi usuario "<email>" y clave "<pwd>"
  When navego a la categoria "<category>" y subcategoria "<subcategory>"
  And agrego 2 unidades del primer producto al carrito
  Then valido en el popup la confirmación del producto agregado
  And valido en el popup que el monto total sea calculado correctamente
  When finalizo la compra
  Then valido el titulo de la pagina del carrito
  And vuelvo a validar el calculo de precios en el carrito
    Examples:
      |          email          |       pwd       |   category   |   subcategory   | |
      | azmoralesm@gmail.com    |     qaLAB123!   |   Clothes    |        Men      | |
      | azmoralesm@pucp.edu.pe  |     qaLAB124!   |   Clothes    |        Men      | |
      | azmoralesm@gmail.com    |     qaLAB123!   |   Autos      |        Men      | |
