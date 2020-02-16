package personal.chris.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * To solve <a href="https://leetcode.com/problems/combination-sum/">39. Combination Sum</a>
 * MEDIUM
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> solutions = new ArrayList<>();

        for (Integer candidate : candidates) {

            if (candidate > target) {
                continue;
            } else if (candidate == target) {
                solutions.add(List.of(candidate));
            } else if (candidate < target) {
                // Recurse, but pass only candidates <= current, so that we don't get duplicate solutions
                int[] filteredCandidates = Arrays.stream(candidates).filter(i -> i <= candidate).toArray();

                List<List<Integer>> recursedSolutions = combinationSum(filteredCandidates, target - candidate);
                if (recursedSolutions.size() > 0) {

                    for (List<Integer> recursedSolution : recursedSolutions) {
                        List<Integer> solution = new ArrayList<>();
                        solution.add(candidate);
                        solution.addAll(recursedSolution);
                        solutions.add(solution);
                    }
                }
            }

        }

        solutions.stream().filter(l -> l.size() > 1).forEach(l -> Collections.sort(l));

        return solutions;
    }
}
