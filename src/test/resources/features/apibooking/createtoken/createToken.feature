# language: es

Característica: Crear un token
  Como administrador
  necesito crear un token
  para obtener permiso de actualización y eliminación de reservas

  Escenario: Creación de un token exitoso
    Dado que el administrador navegó hasta el recurso web y suministre los datos para crear el token
    Cuando el administrador realice la petición de crear token
    Entonces visualizará que se creo correctamente el token