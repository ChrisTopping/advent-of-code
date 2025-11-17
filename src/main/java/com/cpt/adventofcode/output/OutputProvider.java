package com.cpt.adventofcode.output;

import com.cpt.adventofcode.result.Result;

import java.util.List;

public interface OutputProvider {

    String provide(List<Result<?>> results);

}
