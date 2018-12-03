# Filosofi a cena
Il progetto é stato realizzato con l'ausilio di LibGDX e Java 1.8

Il programma si puó avviare con  un parametro da console per scegliere il numero di filosofi

per esempio: `java -jar filosofi.jar 10` fa partire il programma con 10 filosofi

per compilare il programma: `gradlew desktop:dist`

quando un filosofo sta mangiando si illumina

![presentazione](https://i.imgur.com/d51S3j1.png)

## Le classi del progetto sono divise in 2 packages: gui e model.

## Nel package gui si trovano le seguenti classi:
1. FilosofiGame che contiene il codice che esegue il rendering degli sprite e muove gli oggetti
2. FilosofoSprite (extends SpriteBatch) che contiene il codice che gestisce lo sprite di un Filosofo
3. ForchettaSprite (extends SpriteBatch) che contiene il codice che gestisce lo sprite di una Forchetta.

## Nel package model si trovano le seguenti classi:

1. Filosofo (implements Runnable) codice che gestisce il comportamento di un filosofo
2. Forchetta codice che contiene la risorsa forchetta


Il progetto si basa sull'utilizzo dei ReentrantLock. 

Ogni forchetta ne contiene uno ed esso viene usato dai Filosofi per prendere le forchette

