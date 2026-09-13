package arraymethods.class_problems;

/**
 * Problem 2 (Easy) — Duplicate Team Name Finder.
 * Reports the first duplicate team name using plain nested loops.
 *
 * Expected Output (running this file's main method):
 *
 * Duplicate Found: ByteForce
 * No Duplicates Found
 */
public class DuplicateTeamNameFinder {

    static String findDuplicateTeam(String[] teamNames) {
        for (int i = 0; i < teamNames.length; i++) {
            for (int j = i + 1; j < teamNames.length; j++) {
                if (teamNames[i].equals(teamNames[j])) {
                    return "Duplicate Found: " + teamNames[i];
                }
            }
        }
        return "No Duplicates Found";
    }

    public static void main(String[] args) {
        System.out.println(findDuplicateTeam(new String[]{"ByteForce", "CodeCrafters", "ByteForce"}));
        System.out.println(findDuplicateTeam(new String[]{"ByteForce", "CodeCrafters", "NullPointers"}));
    }
}
