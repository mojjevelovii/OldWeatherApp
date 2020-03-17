package ru.geekbrains.weatherApp;

public class ViewStateHolder {
    private boolean theme;
    private boolean units;
    private boolean pressure;
    private boolean wind;
    private static volatile ViewStateHolder instance;

    public static ViewStateHolder getInstance() {
        ViewStateHolder localInstance = instance;
        if (localInstance == null) {
            synchronized (ViewStateHolder.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new ViewStateHolder();
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
