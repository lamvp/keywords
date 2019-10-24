package com.example.keywords;

import org.junit.Test;

import static org.junit.Assert.*;

public class KeywordBuilderTest {
    @Test
    public void wrapText_keywordHasOddLength_and_space_in_middle_shouldBeBrokenCorrectly() {
        String keywordInTwoLines = KeywordBuilder.breakKeywordsIntoTwoLines("tu do vaa yeu thuon");
        assertEquals("tu do vaa\nyeu thuon", keywordInTwoLines);
    }

    @Test
    public void wrapText_keywordHasEvenLength_and_space_in_middle_shouldBeBrokenCorrectly() {
        String keywordInTwoLines = KeywordBuilder.breakKeywordsIntoTwoLines("tu do vaa yeu thuo");
        assertEquals("tu do vaa\nyeu thuo", keywordInTwoLines);
    }

    @Test
    public void wrapText_keywordHasEvenLength_and_characterNotSpace_in_middle_shouldBeBokenCorrecly() {
        String keywordInTwoLines = KeywordBuilder.breakKeywordsIntoTwoLines("how to learn javascript in 10 days");
        assertEquals("how to learn\njavascript in 10 days", keywordInTwoLines);
    }

    @Test
    public void wrapText_keywordHasOddLength_and_characterNotSpace_in_middle_shouldBeBokenCorrecly() {
        String keywordInTwoLines = KeywordBuilder.breakKeywordsIntoTwoLines("bo do choi lego");
        assertEquals("bo do\nchoi lego", keywordInTwoLines);
    }

    @Test
    public void wrapText_keywordBokenInIndexesHasSameDifference_preferLongerFirstLine() {
        String keywordInTwoLines = KeywordBuilder.breakKeywordsIntoTwoLines("dac nhan tam");
        assertEquals("dac nhan\ntam", keywordInTwoLines);
    }

    @Test
    public void wrapText_keywordHasNoSpace_shouldNotBeBroken() {
        String keywordInTwoLines = KeywordBuilder.breakKeywordsIntoTwoLines("IPhone8");
        assertEquals("IPhone8", keywordInTwoLines);
    }

    @Test
    public void wrapText_keywordHas2Words_and_space_shouldBeBrokenCorrected() {
        String keywordInTwoLines = KeywordBuilder.breakKeywordsIntoTwoLines("tu dien");
        assertEquals("tu\ndien", keywordInTwoLines);
    }

    @Test
    public void wrapText_keywordHasWrongSpace_shouldAlsoBeCorrected() {
        String keywordInTwoLines = KeywordBuilder.breakKeywordsIntoTwoLines(" tu do");
        assertEquals("tu\ndo", keywordInTwoLines);
    }

    @Test
    public void wrapText_emptyKeyword_shouldNotCrash() {
        String keywordInTwoLines = KeywordBuilder.breakKeywordsIntoTwoLines("   ");
        assertEquals("", keywordInTwoLines);
    }
}