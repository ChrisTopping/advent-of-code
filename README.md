# Advent of Code Solutions

Solutions to the [Advent of Code](https://adventofcode.com/) problem sets.

## Build

Use the following command to build and test the project:

```shell
./gradlew clean build
```

Use the following command to run only unit tests:

```shell
./gradlew clean test
```

Use the following command to run only integration tests:

```shell
./gradlew clean integrationTest
```

## Run

Use the following command to run all solutions:

```shell
./gradlew run
```

To run a selection of solutions, use the following arguments:

* `year` - filter solutions by year
* `day` - filter solutions by day
* `part` - filter solutions by part
* `tag` - filter solutions by tag
* `latest` - filter latest N solutions

E.g:

```shell
./gradlew run --args="year=2020,2021 day=1,2,3 part=2, tags=O(n),algebra latest=2"
```

## Adding solutions

To add a solution, implement the `Solution<T>` interface and annotate it with the `@AdventOfCodeSolution` annotation:

```java
@AdventOfCode(year = 2015, day = 1, part = 1, description = "Let It Snow")
public class Day1Part1Solution implements Solution<Integer> {

    @Override
    public Long solve(Stream<String> inputStream) {
        ...
    }
}
```

Add the problem data to a file with the format `/year{year}/day{day}.txt` in the main `/resources` directory.

A problem can have multiple implemented solutions. 

A test can be created using the test data given during the problem, along with the given expected result for that data. 

To do so:
1. Add the test data to a file with the format `/year{year}/day{day}.txt` in the test `/resources` directory.
3. Extend `BaseTest<T>`.
4. Call the `assertSolutionIsCorrect(solution, expected)` to verify the solution returns the expected result.

Integration tests are used to verify that the final result accepted by Advent of Code is returned by the given solution. These are written in the same way as the unit tests, but use problem data from the main `/resources` directory. 