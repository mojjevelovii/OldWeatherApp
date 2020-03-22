package ru.geekbrains.weatherApp.viewStateHolders;

public class PropertiesViewStateHolder {
    private boolean theme;
    private boolean units;
    private boolean pressure;
    private boolean wind;
    private static volatile PropertiesViewStateHolder instance;

    public static PropertiesViewStateHolder getInstance() {
        PropertiesViewStateHolder localInstance = instance;
        if (localInstance == null) {
            synchronized (PropertiesViewStateHolder.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new PropertiesViewStateHolder();
                }
            }
        }
        return localInstance;
    }

    public boolean isTheme() {
        return theme;
    }

    public void setTheme(boolean theme) {
        this.theme = theme;
    }

    public boolean isUnits() {
        return units;
    }

    public void setUnits(boolean units) {
        this.units = units;
    }

    public boolean isPressure() {
        return pressure;
    }

    public void setPressure(boolean pressure) {
        this.pressure = pressure;
    }

    public boolean isWind() {
        return wind;
    }

    public void setWind(boolean wind) {
        this.wind = wind;
    }

}
