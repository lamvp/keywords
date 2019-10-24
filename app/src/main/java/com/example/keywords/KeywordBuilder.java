package com.example.keywords;

public class KeywordBuilder {

    public static String breakKeywordsIntoTwoLines(String keyword) {
        final String SPACE = " ";
        keyword = keyword.trim();
        if (!keyword.contains(SPACE)) {
            return keyword;
        }
        final int keywordLength = keyword.length();
        final int middle = keywordLength / 2;

        /**
         * if the keyword length is odd then the middle character is fine.
         * If it is even then there are two middle characters, they are the character in middle-1 and middle.
         */
        final String charAtMiddle = keyword.charAt(middle)+"";

        /**
         * The middle character is a space should be the right point to break the keyword in lines.
         */
        if (charAtMiddle.equalsIgnoreCase(SPACE)) {
            return keywordsInTwoLinesBuilder(keyword, middle);
        }

        final int nearestSpaceBeforeMiddleChar = keyword.substring(0, middle).lastIndexOf(SPACE);
        final int nearestSpaceAfterMiddleChar = keyword.indexOf(SPACE, middle);


        if (nearestSpaceBeforeMiddleChar == -1) {
            return keywordsInTwoLinesBuilder(keyword, nearestSpaceAfterMiddleChar);
        }

        if (nearestSpaceAfterMiddleChar == -1) {
            return keywordsInTwoLinesBuilder(keyword, nearestSpaceBeforeMiddleChar);
        }

        /**
         * Default break point is set to the space after middle index
         */
        int breakLineIndex = nearestSpaceAfterMiddleChar;

        final int beforeMiddleLinesDefference = keyword.substring(nearestSpaceBeforeMiddleChar + 1).length()
                - keyword.substring(0, nearestSpaceBeforeMiddleChar).length();
        final int afterMiddleLinesDefference = keyword.substring(0, nearestSpaceAfterMiddleChar).length()
                - keyword.substring(nearestSpaceAfterMiddleChar + 1).length();

        if (beforeMiddleLinesDefference < afterMiddleLinesDefference) {
            breakLineIndex = nearestSpaceBeforeMiddleChar;
        }
        return keywordsInTwoLinesBuilder(keyword, breakLineIndex);
    }

    private static String keywordsInTwoLinesBuilder(final String keyword, final int breakLineIndex) {
        return keyword.substring(0, breakLineIndex) + "\n" + keyword.substring(breakLineIndex + 1);
    }
}
