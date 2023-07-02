package com.job.future.jobservice.dto.address;


import java.util.List;

public class AddressSearchResultDTO {
    private String name;
    private int code;
    private MatchesDTO matches;
    private int score;

    // Constructors, getters, setters

    public static class MatchesDTO {
        private List<Integer> y;

        // Constructor, getter, setter

        public List<Integer> getY() {
            return y;
        }

        public void setY(List<Integer> y) {
            this.y = y;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public MatchesDTO getMatches() {
        return matches;
    }

    public void setMatches(MatchesDTO matches) {
        this.matches = matches;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}