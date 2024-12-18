# Advent of Code Solutions

Solutions to the [Advent of Code](https://adventofcode.com/) problem sets.

![build](https://github.com/ChrisTopping/advent-of-code/actions/workflows/build.yaml/badge.svg)

### Results

```results
Year Day Part Name                                          Result          Duration (s)
========================================================================================
2015 1   1    Not Quite Lisp                                74              0.013
2015 1   2    Not Quite Lisp                                1795            0.009
2015 2   1    I Was Told There Would Be No Math             1606483         0.017
2015 2   2    I Was Told There Would Be No Math             3842356         0.010
2015 3   1    Perfectly Spherical Houses in a Vacuum        2081            0.010
2015 3   2    Perfectly Spherical Houses in a Vacuum        2341            0.017
2015 4   1    The Ideal Stocking Stuffer                    117946          0.322
2015 4   2    The Ideal Stocking Stuffer                    3938038         4.295
2015 5   1    Doesn't He Have Intern-Elves For This?        258             0.016
2015 5   2    Doesn't He Have Intern-Elves For This?        53              0.008
2015 6   1    Probably a Fire Hazard                        569999          0.064
2015 6   2    Probably a Fire Hazard                        17836115        0.059
========================================================================================
2021 1   1    Sonar Sweep                                   1400            0.003
2021 1   2    Sonar Sweep                                   1429            0.005
2021 2   1    Dive!                                         1580000         0.002
2021 2   2    Dive!                                         1251263225      0.001
2021 3   1    Binary Diagnostic                             3374136         0.015
2021 3   2    Binary Diagnostic                             4432698         0.009
2021 4   1    Giant Squid                                   31424           0.037
2021 4   2    Giant Squid                                   23042           0.044
2021 5   1    Hydrothermal Venture                          6189            0.065
2021 5   2    Hydrothermal Venture                          19164           0.029
2021 6   1    Lanternfish                                   387413          0.005
2021 6   2    Lanternfish                                   1738377086345   0.002
2021 7   1    The Treachery of Whales                       345197          0.006
2021 7   2    The Treachery of Whales                       96361630        0.004
2021 8   1    Seven Segment Search                          272             0.008
2021 8   2    Seven Segment Search - Frequency              1007675         0.065
2021 8   2    Seven Segment Search - Frequency Density      1007675         0.011
2021 8   2    Seven Segment Search - Naive                  1007675         0.053
2021 9   1    Smoke Basin                                   537             0.010
2021 9   2    Smoke Basin - Set                             1142757         0.054
2021 9   2    Smoke Basin - Counting                        1142757         0.004
2021 10  1    Syntax Scoring                                311895          0.007
2021 10  2    Syntax Scoring                                2904180541      0.008
2021 11  1    Dumbo Octopus                                 1655            0.003
2021 11  2    Dumbo Octopus                                 337             0.007
========================================================================================
2022 1   1    Calorie Counter                               66306           0.012
2022 1   2    Calorie Counter                               195292          0.001
2022 2   1    Rock Paper Scissors                           9759            0.011
2022 2   2    Rock Paper Scissors                           12429           0.006
2022 3   1    Rucksack Reorganization                       7980            0.008
2022 3   2    Rucksack Reorganization                       2881            0.008
2022 4   1    Camp Cleanup                                  582             0.002
2022 4   2    Camp Cleanup                                  893             0.001
2022 5   1    Supply Stacks                                 TDCHVHJTG       0.015
2022 5   2    Supply Stacks                                 NGCMPJLHV       0.006
2022 6   1    Tuning Trouble                                1578            0.003
2022 6   2    Tuning Trouble                                2178            0.002
2022 7   1    No Space Left On Device                       1084134         0.021
2022 7   2    No Space Left On Device                       6183184         0.010
2022 8   1    Treetop Tree House                            1543            0.091
2022 8   2    Treetop Tree House                            595080          0.056
2022 9   1    Rope Bridge                                   6057            0.019
2022 9   2    Rope Bridge                                   2514            0.031
2022 10  1    Cathode-Ray Tube                              11960           0.001
2022 10  2    Cathode-Ray Tube                              
####...##..##..####.###...##..#....#..#.
#.......#.#..#.#....#..#.#..#.#....#..#.
###.....#.#....###..#..#.#....#....####.
#.......#.#....#....###..#.##.#....#..#.
#....#..#.#..#.#....#....#..#.#....#..#.
####..##...##..#....#.....###.####.#..#. 0.001
========================================================================================
2023 1   1    Trebuchet?!                                   54940           0.019
2023 1   2    Trebuchet?!                                   54208           0.019
2023 2   1    Cube Conundrum                                2162            0.012
2023 2   2    Cube Conundrum                                72513           0.006
2023 3   1    Gear Ratios                                   525119          0.063
2023 3   2    Gear Ratios                                   76504829        0.038
2023 4   1    Scratchcards                                  23235           0.012
2023 4   2    Scratchcards                                  5920640         0.010
2023 6   1    Wait For It                                   219849          0.001
2023 6   2    Wait For It                                   29432455        0.000
2023 7   1    Camel Cards                                   246424613       0.063
2023 8   1    Haunted Wasteland                             13019           0.013
2023 8   2    Haunted Wasteland                             13524038372771  0.042
2023 9   1    Mirage Maintenance                            1934898178      0.007
2023 9   2    Mirage Maintenance                            1129            0.007
========================================================================================
2024 1   1    Historian Hysteria                            1530215         0.006
2024 1   2    Historian Hysteria                            26800609        0.004
2024 2   1    Red-Nosed Reports                             252             0.008
2024 2   2    Red-Nosed Reports                             324             0.011
2024 3   1    Mull It Over                                  173731097       0.005
2024 3   2    Mull It Over                                  93729253        0.005
========================================================================================

Solved 78 solutions with a total duration: 5.953 seconds.
```
---

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
    public Integer solve(Stream<String> inputStream) {
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