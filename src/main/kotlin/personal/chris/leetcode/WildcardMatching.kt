package personal.chris.leetcode

/**
 * To solve <a href="https://leetcode.com/problems/wildcard-matching/">44. Wildcard Matching</a>
 * HARD
 */
class WildcardMatching {

    val badStrings: MutableSet<String> = HashSet()
    val goodStrings: MutableSet<String> = HashSet()

    /**
     * @param s input string - lower case english letters
     * @param p pattern - lower case english letters plus ? and *
     *
     * ? matches any single character
     * * matches any sequence of 0 or more characters
     */
    fun isMatch(s: String, p: String): Boolean {
        if (badStrings.contains("$s/$p")) {
            return false
        }
        if (goodStrings.contains("$s/$p")) {
            return true
        }

        val result = internalIsMatch(s, p)
        if (!result) {
            badStrings.add("$s/$p")
        } else {
            goodStrings.add("$s/$p")
        }
        return result
    }


    private fun internalIsMatch(s: String, p: String): Boolean {
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

        // Cheaty heuristic: if the pattern without *'s is longer than the input it won't match
        if (p.replace("*", "").length > s.length) {
            return false
        }


        val first: Char = p[0];
        if (first == '?') {
            return isMatch(s.substring(1), p.substring(1))
        } else if (first == '*') {
            // We can either match the * to no more characters:
            val removed = isMatch(s, removeStars(p))
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

    fun removeStars(pattern: String): String {
        // * is equivalent to **
        // so instead of removing one wildcard we should remove as many as we can,
        var index = 0
        while ((index < pattern.length) && (pattern[index] == '*') ) {
            index++
        }
        return pattern.substring(index)
    }

}