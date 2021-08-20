# dmn-abc-analysis

## Premise
Let's imagine, for the sole purpose of practicing web services programming, a company that not only does not care about optimizing its production processes, but that tries to fulfill customer orders as they arrive, without assigning them a priority.
Imagine a management that forces the production and packaging departments to a continuous reorganization of machinery tooling and the warehouse department to a continuous movement of material that is rarely used in its entirety, therefore leaving cluttered remains on the shelves.
The most embarrassing thing is that very often the fulfillment of the orders of the best customers is interrupted to satisfy a swarm of small customers, whose work orders of even a few minutes and for a handful of pieces are thrown here and there, at random.
Meanwhile, the components move back and forth, to and from the warehouse, with the consequent risk of damage.
One day, the management decides that the chaos must end.
Well, where to start?
From the Pareto principle, who states that eighty percent of the consequences come from twenty percent of the causes.
In other words, eighty percent of sales comes from orders placed by twenty percent of customers, and it is to these that the utmost attention should be paid!
Furthermore, framing everything in a perspective of logistical efficiency for which the components that are needed are ordered, when they are needed and in the strictly necessary quantity; making sure that there is no reflux of material that is only partially used and potentially contaminated.

## Scaffolding
```
mvn io.quarkus:quarkus-maven-plugin:2.1.3.Final:create -DprojectGroupId=local.example -DprojectArtifactId=dmn-abc-analysis -Dextensions="dmn" -DnoExamples
```
