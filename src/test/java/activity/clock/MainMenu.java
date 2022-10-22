package activity.clock;

import appiumControl.Button;
import appiumControl.Label;
import org.openqa.selenium.By;

public class MainMenu {

    String xpathTime = "//android.widget.TextView[@content-desc='%s']";

    public Button clockButton = new Button(By.xpath("//rk[@content-desc='Clock']"));

    public Button alarmButton = new Button(By.xpath("//rk[@content-desc='Alarm']"));

    public Button timerButton = new Button(By.xpath("//rk[@content-desc='Timer']"));

    public Button stopWatchButton = new Button(By.xpath("//rk[@content-desc='Stopwatch']"));

    public MainMenu () {

    }

    public Button clickAlarmCreated(String time){
        return new Button(By.xpath(String.format(xpathTime, time)));
    }
    public Label getTimeAlarm(String time){
        return new Label(By.xpath(String.format(xpathTime, time)));
    }
}
