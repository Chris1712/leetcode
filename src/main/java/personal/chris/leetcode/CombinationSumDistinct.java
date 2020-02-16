package personal.chris.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * To solve <a href="https://leetcode.com/problems/combination-sum-ii/">40. Combination Sum II</a>
 * MEDIUM
 */
public class CombinationSumDistinct {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> solutions = new ArrayList<>();

        for (Integer candidate : candidates) {

            if (candidate > target) {
                continue;
            } else if (candidate == target) {
                solutions.add(List.of(candidate));
            } else if (candidate < target) {
                // Recurse, but pass only candidates <= current, so that we don't get duplicate solutions

                List<Integer> filteredCandidatesList = Arrays.stream(candidates)
                        .filter(i -> i <= candidate).boxed().collect(Collectors.toList());
                filteredCandidatesList.remove(candidate); // Remove the candidate from the list, we can use each item only once
                int[] filteredCandidates = filteredCandidatesList.stream().mapToInt(Integer::intValue).toArray();

                List<List<Integer>> recursedSolutions = combinationSum2(filteredCandidates, target - candidate);
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

        solutions = solutions.stream().distinct().collect(Collectors.toList());
        return solutions;
    }
}

