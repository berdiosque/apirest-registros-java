# API REST para Registros de Mamíferos tomados por Cámaras Trampa

Este proyecto es una API RESTful desarrollada para centralizar y gestionar registros de mamíferos observados mediante cámaras trampa, como parte del programa **Paisaje Productivo Protegido**, iniciativa que en conjunto con empresas impulsa la conservación de la biodiversidad y el desarrollo sostenible. La API permite cargar y consultar registros, cada uno con una foto, la especie observada y el PPP donde se tomó la captura. Los registros están organizados en torno a las Especies y los PPP, los cuales tienen información adicional.


## Características

- Cargar Registros: Cada registro puede contener una foto, una especie observada y el PPP donde fue tomada la foto.
- Especies: Cada especie tiene un nombre, una descripción y una categoría de amenaza.
- Paisajes Productivos Protegidos (PPP): Cada PPP tiene un nombre, una descripción y las ecorregiones donde trabaja la empresa.
- Soporte para listar, crear, actualizar y eliminar registros, especies, categorías de amenaza, paisajes y ecorregiones.

## Endpoints Principales

### Registros
- `POST /registros`: Crea un nuevo registro de mamífero.
- `GET /registros`: Obtiene todos los registros de mamíferos.
- `GET /registros/{id}`: Obtiene un registro específico.
- `PUT /registros/{id}`: Actualiza un registro.
- `DELETE /registros/{id}`: Elimina un registro.

### Especies
- `POST /especies`: Crea una nueva especie.
- `GET /especies`: Lista todas las especies.
- `GET /especies/{id}`: Obtiene una especie específica.
- `PUT /especies/{id}`: Actualiza una especie.
- `DELETE /especies/{id}`: Elimina una especie.

### Paisajes Productivos Protegidos
- `POST /ppps`: Crea un nuevo paisaje.
- `GET /ppps`: Lista todos los paisajes.
- `GET /ppps/{id}`: Obtiene un paisaje específico.
- `PUT /ppps/{id}`: Actualiza un paisaje.
- `DELETE /ppps/{id}`: Elimina un paisaje.

### Ecorregiones
- `POST /ecorregiones`: Crea una nueva ecorregión.
- `GET /ecorregiones`: Lista todas las ecorregiones.
- `GET /ecorregiones/{id}`: Obtiene una ecorregión específica.
- `PUT /ecorregiones/{id}`: Actualiza una ecorregión.
- `DELETE /ecorregiones/{id}`: Elimina una ecorregión.

### Categorías de Amenaza
- `POST /categorias`: Crea una nueva categoría.
- `GET /categorias`: Lista todas las categorías.
- `GET /categorias/{id}`: Obtiene una categoría específica.
- `PUT /categorias/{id}`: Actualiza una categoría.
- `DELETE /categorias/{id}`: Elimina una categoría.

