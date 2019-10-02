# Stranger forms

Ivan and his friends love going to the cinema.

But when it comes to picking seats, they don't like the usual & boring "next to each other in one row" placement.

That's why they always pick their seats in a strange way. Maria should be above Ivan. Georgi should be to the right of Maria. Veronika should be above Maria.

And when they are done, they can take really strange forms (at least, strange in the eyes of the cinema owners).

Here's a way they can be placed, using the description above:

```
...*..V.*****..
..*..*MG..*.*..
....*.I...*....
```

Where:

* `.` represents an empty seat.
* `*` represents a reserved seat.
* `I`, `M`, `G` and `V` are the first letters of the respective people.

## The task

You'll be represented with an input, including the layout of the cinema & the configuration our friends want to take.

In a language of your choice, implement a program that outputs all possible combinations of placements, that are possible with the given form.

At the end, output the number of those possible configurations.

Possible configuration is a configuration where:

* Our friends can book seats in the way they want.
* They are not going outside of the cinema.
* They are not taking any already reserved seats.

## Input format

Here's one example input:

```
10 10
..*...*.**
.....**...
*.*...*..*
.**....*.*
...*..*.*.
.***...*..
*......*.*
.....**..*
..*.*.*..*
***.*.**..
6
A
BAA
FRA
CAB
DRC
EAD
GLE
```

Lets break it down:

* The first line - `10 10` represents the width & height of the cinema.
* The next 10 lines (the height) are the cinema layout itself. `.` is free, `*` is reserved.
* Next line - `6` - represents the numbre of configurations that our friends wants to make.
* Next line - `A` - that's the first letter of the name of someone, who is going to be "central" for the configuration.
* Next line - `BAA` - means - person with name `B` will be `Above` the person with name `A`.
* Next line - `FRA` - means - person with name `F` will be `Right` of the person with name `A`.
* Next line - `CAB` - means - person with name `C` will be `Above` the person with name `B`.
* Next line - `DRC` - means - person with name `D` will be `Right` of person with name `C`.
* Next line - `EAD` - means - person with name `E` will be `Above` the person with name `D`.
* Next line - `GLE` means - person with name `G` will be `Left` of the person with name `E`.

Few things to consider:

* The input will be correct - there won't be 2 people occupying the same place.
* All names are going to be unique.
* There won't be a configuration for someone not being previously introduced.

## Example

If we take the example input from above, given to stdin, our program should output all possible configurations for our friends in the cinema layout:

```
 0123456789
0..*GE.*.**
1...CD**...
2*.*B..*..*
3.**AF..*.*
4...*..*.*.
5.***...*..
6*......*.*
7.....**..*
8..*.*.*..*
9***.*.**..
----------
 0123456789
0..*...*.**
1.....**...
2*.*.GE*..*
3.**.CD.*.*
4...*B.*.*.
5.***AF.*..
6*......*.*
7.....**..*
8..*.*.*..*
9***.*.**..
----------
 0123456789
0..*...*.**
1.....**...
2*.*...*..*
3.**.GE.*.*
4...*CD*.*.
5.***B..*..
6*...AF.*.*
7.....**..*
8..*.*.*..*
9***.*.**..
----------
3
```

For convinience, we've printed the row & col numbers (starting from 0). This is not necessary but it's going to be counted as an "extra", if done so.
