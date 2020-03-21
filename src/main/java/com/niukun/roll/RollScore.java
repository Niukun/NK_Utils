package com.niukun.roll;

import java.util.ArrayList;
import java.util.List;

public class RollScore {

    public int getScore(String rollLine){
        String[] scores = rollLine.split(" ");
        List<FrameScore> frameScoreList = new ArrayList<FrameScore>();
        for(int i = 0; i < scores.length; i++){
            FrameScore frameScore = getFrameScore(scores, i);
            frameScoreList.add(frameScore);
        }

        return getScoreFromList(frameScoreList, scores);
    }

    private int getScoreFromList(List<FrameScore> frameScoreList, String[] scores) {
        int result = 0;
        for(int i =0; i < frameScoreList.size(); i++){
            result += frameScoreList.get(i).score(scores, i);
        }
        return result;
    }

    private FrameScore getFrameScore(String[] scores, int index) {
        int firstScore = 0;
        int secondScore = 0;
        String score = scores[index];
        score = score.replaceAll("-", "0");
        if(score.length() == 1){
            firstScore = 10;
            if(scores[index + 1].length() == 1 && index < 8){
                if(scores[index + 2].length() == 1){
                    secondScore = 20;
                }else if(scores[index + 2].length() == 2){
                    secondScore = 10 + Integer.parseInt(scores[index + 2].substring(0,1));
                }else if(scores[index + 2].length() == 3){
                    if(scores[index + 1].equalsIgnoreCase("XXX")){
                        secondScore = 20;
                    }
                }

            }else if(scores[index + 1].length() == 2){
                secondScore = getFrameScore(scores, index+1).score(scores,index);
            }else if(scores[index + 1].length() == 3){
                if(scores[index + 1].equalsIgnoreCase("XXX")){
                    secondScore = 20;
                }
            }

        }else if(score.length() == 2){
            if(score.substring(1,2).equalsIgnoreCase("/")) {
                firstScore = 10;
                if (score.length() == 2) {
                    secondScore = Integer.parseInt(scores[index + 1].substring(0, 1));
                }

            }else{
                firstScore = Integer.parseInt(score.substring(0, 1));
                secondScore = Integer.parseInt(score.substring(1));
            }

        }else if(score.length() == 3){
            firstScore = 10;
            if(scores[index].substring(1, 3).equalsIgnoreCase("XX")){
                secondScore = 20;
            }else if(score.substring(1,2).equalsIgnoreCase("/")){
                secondScore = Integer.parseInt(scores[index].substring(2, 3));
            } else if(score.substring(1,2).equalsIgnoreCase("X")){
                secondScore = 10 + Integer.parseInt(score.substring(2,3));
            }else if(score.substring(2,3).equalsIgnoreCase("X")){
                secondScore = 10 + Integer.parseInt(score.substring(1,2));
            }

        }

        if(index < 9) {
            if(score.length() == 1){
                return new FrameScore(true);
            }
            return new FrameScore(firstScore,secondScore,true);
        }else{
            if(score.length() == 3 && score.equalsIgnoreCase("XXX")){
                FrameScore frameScore = new FrameScore(true);
                frameScore.setHasNextFrame(false);
                return frameScore;
            }
            return  new FrameScore(firstScore, secondScore, false);
        }
    }
}

class FrameScore{
    private int firstScore;
    private int secondScore;
    private boolean isTen;
    private  boolean hasNextFrame;

    public boolean isHasNextFrame() {
        return hasNextFrame;
    }

    public void setHasNextFrame(boolean hasNextFrame) {
        this.hasNextFrame = hasNextFrame;
    }

    public FrameScore(boolean isTen){
        this.isTen = isTen;
    }
    public FrameScore(int firstScore, int secondScore){
        this.firstScore = firstScore;
        this.secondScore = secondScore;
    }

    public FrameScore(int firstScore, int secondScore, boolean hasNextFrame){
        this(firstScore,secondScore);
        this.hasNextFrame = hasNextFrame;
    }

    public int score(String[] scores, int index) {
        int score = 0;
        if(this.isTen){
            if(index < 9){
                if(scores[index +1].length() == 1){
                    score += 30;
                }else if(scores[index +1].length() == 2){
                    score += score(scores, index +1);
                }else if(scores[index +1].length() == 3){

                }

            }else{
                if(scores[index].equalsIgnoreCase("XXX")){
                    score += 30;
                }else{
                    score += 10;
                }
            }
            return score;
        }else{
            return this.firstScore + this.secondScore;
        }
    }


    public int getFirstScore() {
        return firstScore;
    }

    public void setFirstScore(int firstScore) {
        this.firstScore = firstScore;
    }

    public int getSecondScore() {
        return secondScore;
    }

    public void setSecondScore(int secondScore) {
        this.secondScore = secondScore;
    }


}
