##Microservicios con Spring Boot.

* Creacion de microservicios con Spring Boot, comunicación a traves de restTemplate y  Feign Client.
* Persistencia con Spring Data JPA y MyBatis.
* Configuración centralizada y remota con Spring Cloud Config Server.
* Registro y localización de microservicios con Spring Cloud Eureka Server.
* Enrutamiento y balanceo de cargas con gateway y load balancer.
* Tolerancia a fallos con Resilience4J, patron circuit-breaker. (implementado en usuarios).

---

Puedes descargar el proyecto en cada paso eligiendo la rama correspondiente.

    1 Descargar o clonar los proyectos. 
    2 Descargar las dependencias de cada uno. (Update Maven)
    3 Arrancar config-srv. (8081) (Modificar siempre la rama en el application.yaml)
    4 Arrancar eureka-srv. (8761)
    5 Arrancar gateway-srv. (8082) (Eliminar las url en los clientes feign y modificar el puerto al de gateway en restTemplate)
    6 Arrancar los microservicios.