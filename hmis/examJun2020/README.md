# examJun2020

id | user | Nombre estudiante  | Página personal examen  
--- | --------- | ---------------------------------- | -----------------
1 | pat533 | PABLO ALMANSA TORRES | [pakar12](pakar12.md)
2 | aaf842 | ALEJO MARTIN ARIAS FILIPPO | [alejomaf](alejomaf.md)
3 | aba693 | AARON BLANCO ALVAREZ | [aaronblanco](aaronblanco.md)
4 | abm490 | ALONSO BRAVO MOYANO | [dogudo](dogudo.md)
5 | dcm228 | DIEGO CANGAS MOLDES | [diegocangas](diegocangas.md)
6 | fcg299 | FELIPE ANTONIO CANO GALERA | [fcg299](fcg299.md)
7 | icb163 | ISMAEL CRUZ BELLO | [icb163](icb163.md)
8 | ods883 | OUSAMA DAHBI SEBBAGHI | [ods883](ods883.md)
9 | peb778 | PABLO DANIEL ESTEVEZ BRETONES | [pablodaniel11](pablodaniel11.md)
10 | aff012 | ALBERTO ANGEL FUENTES FUNES | [21albertoff](21albertoff.md)
11 | jgt627 | JUAN PABLO GROSSO TARAZAGA | [jgt627](jgt627.md)
12 | fhm850 | FRANCISCO JAVIER HERNANDEZ MONTOYA | [fhm850](fhm850.md)
13 | dmj619 | DAVID MARTINEZ JIMENEZ | [dmj619](dmj619.md)
14 | dmr372 | DANIEL MARTINEZ ROSILLO | [dmr372](dmr372.md)
15 | fms528 | FRANCISCO JOSE MARTINEZ SIMON | [fms528](fms528.md)
16 | jmm497 | JOSE MARIA MORALES MIÑARRO | [jmm497](jmm497.md)
17 | lop427 | LEANDRO NICOLAS ORTEGA PONCE | [nicoop98](nicoop98.md)
18 | dor494 | DANIEL ORTEGA RUBIO | [Dor494](Dor494.md)
19 | jps105 | JUAN JOSE PALLARES SANCHEZ | [palla551](palla551.md)
20 | mps076 | MIGUEL ANGEL PUERTAS SANCHEZ | [luxor-g](luxor-g.md)
21 | rrt556 | RAMON FRANCISCO RAMOS TRISTAN | [rtyui578](rtyui578.md)
22 | trm187 | TESIFON ROBLES MARIN | [trm187](trm187.md)
23 | crl347 | CLAUDIO RODRIGUEZ LOPEZ | [Claudio1812](Claudio1812.md)
24 | ssa338 | STEFAN SEVDALINOV ALEKOV | [0](0.md)
25 | jsm406 | JUAN SOLER MARQUEZ | [juansolerual](juansolerual.md)



## EJERCICIO1 (1 punto)

Forkea este repositorio y modifica tu página .md con los enlaces a las respuestas. 
Envía tus cambios a este repositorio.


## EJERCICIO2 (4,5 puntos)

En tu pagina .md tienes la IP de una sencilla aplicación web "To-Do". 

- Crea un repositorio privado y da acceso al profesor: ualjjcanada

- Realiza con Selenium las pruebas necesarias para verificar que la aplicación web funciona correctamente. Guardalas en el repositorio (ACLARACIÓN las pruebas que grabes con Selenium IDE las guardas en formato `.side` y lo subes al repo de este ejercicio)

- Exporta tus test a JUnit WebDriver. Prueba que funcionan en JUnit

- Crea un proyecto en Jenkins que ejecute los test. 

- Indica en tu página personal del examen:
    - el **repositorio** donde has resuelto el ejercicio, 
    - el enlace a Jenkins y el nombre del **proyecto Jenkins** donde lo has resuelto


## EJERCICIO3 (4,5 puntos)

- Crea en GitHub un nuevo repositorio privado `ejecicio3examen` y da acceso al profesor: ualjjcanada

- Crea en tu máquina local un proyecto en Java con una clase con nombre `Ejercicio3` y un método llamado `diaSemana(int dia)` que recibe un numero entero y devuelve una cadena con el nombre del día de la semana: 
````
    1 -> lunes 
    2 -> martes
    ... 
    7 -> domingo
    otro valor -> ERROR!
````
- Implementa los casos de prueba necesarios utilizando JUnit y, si es posible, tests parametrizados, para obtener un 100% de cobertura del código del método `diaSemana()`, usando los valores límite adecuados donde proceda. 

- **Guarda tus cambios** en el **repositorio** privado de este ejercicio.

- Crea en Jenkins un proyecto de tipo **pipeline** que construya el ejercicio 3: compilando los fuentes y ejecutando los tests. Para esto será necesario que el proyecto esté *mavenizado*.

- Publica en Jenkins los resultados de los test y de cobertura de código.

- Añade al pipeline una fase de *análisis estático de código* en la que se ejecuten, al menos, **CheckStyle** y **FindBugs/SpotBugs**. **No** corregir los posibles errores que aparezcan. 

- Publica los resultados de CheckStyle y SpotBugs en tu proyecto Jenkins.

- **NO OLVIDES**: Indica en tu página personal del examen: 
  - el **repositorio** donde has resuelto el ejercicio, 
  - el enlace a Jenkins y el **nombre del proyecto Jenkins** donde lo has resuelto




