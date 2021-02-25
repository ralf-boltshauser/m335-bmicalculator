package ch.ralfboltshauser.bmicalc;

enum BmiClassificationEnum {
    UNDERWEIGHT,
    NORMAL,
    OVERWEIGHT,
    OBESE
}

public class BmiClassification {
    public static String getLevel(BmiClassificationEnum level) {

        switch(level) {
            case UNDERWEIGHT:
                return "underweight";
            case NORMAL:
                return "normal";
            case OVERWEIGHT:
                return "overweight";
            default:
                return "obese";
        }
    }
}