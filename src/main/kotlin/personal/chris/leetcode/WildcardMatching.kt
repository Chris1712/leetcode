package personal.chris.leetcode

/**
 * To solve <a href="https://leetcode.com/problems/wildcard-matching/">44. Wildcard Matching</a>
 * HARD
 */
class WildcardMatching {

    /**
     * @param s input string - lower case english letters
     * @param p pattern - lower case english letters plus ? and *
     *
     * ? matches any single character
     * * matches any sequence of 0 or more characters
     */
    fun isMatch(s: String, p: String): Boolean {
        // Iterate through the pattern and strip down the string

        if (p.isEmpty()) {
            // If there's no pattern left, we succeed only if there's no input left
            return s.isEmpty()
        }
        if (s.isEmpty()) {
            if (p[0] == '*') {
                return isMatch(s, p.substring(1))
            }
            return false;
        }

        val first: Char = p[0];
        if (first == '?') {
            return isMatch(s.substring(1), p.substring(1))
        } else if (first == '*') {
            // We can either match the * to no more characters:
            val removed = isMatch(s, p.substring(1))
            // Or to one more character
            val continued = isMatch(s.substring(1), p)
            // If either worked we're happy
            return removed or continued
        } else if (first == s[0]) {
            return isMatch(s.substring(1), p.substring(1))
        } else {
            return false
        }
    }

}