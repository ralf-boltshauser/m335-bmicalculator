package ch.ralfboltshauser.bmicalc;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.Random;

public class BmiService extends Service {
    // Binder given to clients
    private final IBinder binder = new LocalBinder();
    // Random number generator
    private final Random mGenerator = new Random();

    /**
     * Class used for the client Binder.  Because we know this service always
     * runs in the same process as its clients, we don't need to deal with IPC.
     */
    public class LocalBinder extends Binder {
        BmiService getService() {
            // Return this instance of LocalService so clients can call public methods
            return BmiService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    /** method for clients */
    public int getRandomNumber() {
        return mGenerator.nextInt(100);
    }


    private float weight = 75;
    private float height = 180;

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