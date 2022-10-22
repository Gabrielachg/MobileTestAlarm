package activity.clock;

import appiumControl.Button;
import appiumControl.Label;
import org.openqa.selenium.By;

public class SettingAlarmScreen {
    private final String hourXpath = "//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc='%s']";

    private String minuteXpath = "//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc='%s']";

    public final Button okButton = new Button(By.id("android:id/button1"));
    public final Button cancelButton = new Button(By.id("android:id/button2"));

    public final Button AMButton = new Button(By.id("android:id/am_label"));
    public final Button PMButton = new Button(By.id("android:id/pm_label"));
    public final Label minutesLabel = new Label(By.id("android:id/minutes"));
    public final Label hourLabel = new Label(By.id("android:id/hours"));

    public SettingAlarmScreen(){

    }

    public Button setHourAlarm(String hour) {
        return new Button(By.xpath(String.format(hourXpath, hour)));
    }

    public Button setMinuteAlarm(String minutes) {
        return new Button(By.xpath(String.format(minuteXpath, minutes)));
    }

    public String getMinutesForValidate(String minutes) {
        if (minutes.length() == 1) {
            minutes = "0" + minutes;
        }
        return minutes;
    }
}
