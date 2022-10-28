## Microservicios con Spring Boot. (RAMA)
---

* Creacion de microservicios con Spring Boot, conceptos básicos. (master)
* Comunicación a traves de restTemplate y  Feign Client. (master)
* Persistencia con Spring Data JPA y MyBatis. (master)
* Authenticacion Basica. (master-basic-auth)
* JWT Auth. (master-user-auth-jwt)
* Creación del servidor de configuración usando Git, con Spring Cloud Config Server.(config)
* Registro y localización de microservicios con Eureka Server.(eureka)
* Multiples instancias. (eureka-multi-instances)
* Enrutamiento con Gateway. Balanceo de carga con Load Balanced. (gateway)
* Tolerancia a fallos con Resilience4J, patrón Circuit-Breaker. (circuit-breaker)
* Tracing con Zipkin y Sleuth. (zipkin-sleuth)
* Auth Gateway. (basic-auth-micros)
* JWT Gateway. (auth-jwt-role-micros)

---

    1 Descargar o clonar los proyectos.(git clone https://github.com/clementeqp/microservicios-SpringBoot-2022.git)
    2 Cambiar de rama (git checkout <rama>)
    2 Abrir proyecto con nuestro IDE. 
    3 Arrancar config-srv. (8081) (configurar en properties la rama)
    4 Arrancar eureka-srv. (8761)
    5 Arrancar gateway-srv. (8082)
    6 Arrancar los microservicios.
    7 Para Zipkin, ejecutar el jar primero. (9411) (java -jar zipkin-server-2.23.19-exec.jar)

    Clemente Quintana Pozo