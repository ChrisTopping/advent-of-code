# Advent of Code Solutions

Solutions to the [Advent of Code](https://adventofcode.com/) problem sets.

![build](https://github.com/ChrisTopping/advent-of-code/actions/workflows/build.yaml/badge.svg)

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

To run a selection of solutions, use the following solverArguments:

* `year` - filter solutions by year
* `day` - filter solutions by day
* `part` - filter solutions by part
* `tag` - filter solutions by tag
* `latest` - filter latest N solutions
* `verbose` - adds verbose logging
* `average` - averages the run duration across a given number of iterations
* `fastest` - filters only fastest solution for each unique problem

E.g:

```shell
./gradlew run --args="year=2020,2021 day=1,2,3 part=2, tags=O(n),algebra latest=2 verbose=true average=100, fastest=true"
```

Tags can be negated using the `!` character, e.g. the following will run all solutions which do not contain
the `alternative` tag:

```shell
./gradlew run --args="tags=!alternative"
```

## Adding solutions

### Scrape

You can scrape data needed to create an empty solution for today's problem with the following command:

```shell
./gradlew scrape --args="today=true"
```

Or optionally, to set the result type:

```shell
./gradlew scrape --args="today=true type=<type>"
```

To create a solution for a specific day in this way, use the following command:

```shell
./gradlew scrape --args="year=<year> day=<day>"
```

And to do this while setting the result type:

```shell
./gradlew scrape --args="year<year> day=<day> type=<type>"
```

This will generate:
* a solution class for part 1
* a solution class for part 2
* a unit test for part 1
* a unit test for part 2
* an integration test for part 1
* an integration test for part 2
* a populated input file
* a blank test input file

To use this feature, create a `.env` file in the root of the project and add an entry containing your long-lived session cookie:

```text
SESSION=<your session cookie>
```

This can be obtained from inspecting cookies on the www.adventofcode.com website when logged in. The session cookies generaly do not refresh until logout.

### Generate

Use the following command to automatically generate a solution template:

```shell
./gradlew generate
```

Then enter the data when prompted.

### Manual

To manually add a solution, implement the `Solution<T>` interface and annotate it with the `@AdventOfCodeSolution`
annotation:

```java

@AdventOfCodeSolution(year = 2015, day = 1, part = 1, description = "Let It Snow")
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

Integration tests are used to verify that the final result accepted by Advent of Code is returned by the given solution.
These are written in the same way as the unit tests, but use problem data from the main `/resources` directory. 