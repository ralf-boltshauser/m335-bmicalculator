package ch.ralfboltshauser.bmicalc;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class BmiCalculatorService extends Service {

    private float weight = 75;
    private float height = 180;


    public BmiCalculatorService() {
    }

    public static BmiCalculatorService bmiCalculatorService;

    public static BmiCalculatorService getInstance(){
        if (bmiCalculatorService == null) {
            bmiCalculatorService = new BmiCalculatorService();
        }
        return bmiCalculatorService;
    }

    @Override
    public IBinder onBind(Intent intent) {

        throw new UnsupportedOperationException("Not yet implemented");
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getBmi() {
        return getBmi(this.weight, this.height);
    }

    public float getBmi(float weight, float height) {
        return (float) ((float) weight/Math.pow(height / 100, 2));
    }

    public String getBmiClassification(float weight, float height) {
        return getBmiClassification(getBmi(weight, height));
    }

    public String getBmiClassification() {
        return getBmiClassification(getBmi());
    }

    public String getBmiClassification(float bmi) {
        if (bmi < 18.5){
            return BmiClassification.getLevel(BmiClassificationEnum.UNDERWEIGHT);
        } else if (bmi < 25){
            return BmiClassification.getLevel(BmiClassificationEnum.NORMAL);
        } else if (bmi < 30){
            return BmiClassification.getLevel(BmiClassificationEnum.OVERWEIGHT);
        } else {
            return BmiClassification.getLevel(BmiClassificationEnum.OBESE);
        }
    }
}