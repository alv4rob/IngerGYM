# IngerGYM


Nombre: "IngerGYM"

# Descripción
La aplicación web simularia la gestión de un gimnasio y brindaría la oportunidad de elegir a sus clientes los horarios y las clases a las que quieren acceder respetando las medidas de aforo y sanidad impuestas. 

# Temática: 

Debido a las reestricciones por el covid y la limitación de aforo, una aplicación web para el control de las salas y las clases de un gimnasio. 
- Públicas:
Ver horarios de clases, como contactar con el gimnasio, ver tarifas , inscribirte al gimnasio. 

- Privadas:
Ver tu propio horario, seleccionar clases, disponibilidad de salas/clases, ver profesores/monitores, ver pistas disponibles, darte de baja.

# Entidades:

- PERSONA(id VARCHAR2(25), contraseña VARCHAR2(25),edad NUMBER(2),situacion_Laboral VARCHAR2(25),Rol VARCHAR2(25),Tarifa VARCHAR2(25));

- SALAS(AforoMax NUMBER(3),Horarios VARCHAR2(25),TipoSala VARCHAR2(25),numSala NUMBER(3));

- CLASES(AforoMax NUMBER(3),Horarios VARCHAR2(25),TipoSala VARCHAR2(25),profesor VARCHAR2(25),numSala NUMBER(3));
(Se relaciona con "SALAS" mediante AforoMax y numSala que los hereda de ella.)

- OPINION(id VARCHAR2(25),Horarios VARCHAR2(25),DiasTrabajo VARCHAR2(25),Rol VARCHAR2(25));
(Hereda de Persona el id y el Rol de los trabajadores.)

- CONTACTO(numero NUMBER(9),email VARCHAR2(25),id VARCHAR2(25));
(Se relaciona con persona para poder llevar un control de quien hace sugerencias en este apartado.)

# Funcionalidad de servicio interno:
El servicio interno se encarga de la gestión del aforo , la reserva de las clases por parte de los usuarios y la aplicación de las tarifas en función del cliente. Además del control de los turnos de los trabajadores.

# Integrantes
- Daniel Cáceres González; d.caceres.2018@alumnos.urjc.es
github: DCaceres2018

- Carlos Manuel Barrameda Portieles; cm.barrameda.2018@alumnos.urjc.es
github: CarlosMbp


#IMAGENES DE

![image](https://user-images.githubusercontent.com/78802315/110342172-64eaf180-802b-11eb-8618-da96f3aef5b5.png)
