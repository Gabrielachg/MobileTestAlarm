package activity.clock;

import appiumControl.Button;
import appiumControl.Label;
import org.openqa.selenium.By;

public class Alarm {

    public final Button ringtoneButton = new Button(By.id("com.google.android.deskclock:id/choose_ringtone"));

    public final Button popupOptionDismissButton = new Button(By.id("com.google.android.deskclock:id/dismiss"));
    public final Button selectRingtoneButton = new Button(By.xpath("//*[@text='Argon']"));

    public final Label ringtoneSelectedText = new Label(By.id("com.google.android.deskclock:id/choose_ringtone"));

    public final Button labelAlarm = new Button(By.id("com.google.android.deskclock:id/edit_label"));
    public Label editLabelTextBox = new Label(By.id("com.google.android.deskclock:id/label_input_field"));
    public Button submitLabelButton = new Button(By.id("android:id/button1"));
    public Button navigateUpButton = new Button(By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"));

    public Button daysAlarmButton = new Button(By.xpath("//android.widget.CheckBox[@content-desc='Monday']"));

    public Label timeLabelAlarm = new Label(By.xpath("(//*[@resource-id='com.google.android.deskclock:id/alarm_recycler_view']//android.widget.TextView)[1]"));
    public Button expandAlarmButton = new Button(By.xpath("(//android.widget.ImageButton[@content-desc='Expand alarm'])[1]"));

    public Button deleteAlarmButton = new Button(By.id("com.google.android.deskclock:id/delete"));

    public Alarm(){}
    public Button clickExpandAlarman (String hours) {
        String expandAlarm = "//android.widget.TextView[@content-desc='%s']/following-sibling::android.widget.ImageButton[@content-desc='Expand alarm']";
        System.out.printf((expandAlarm) + "%n", hours);
        return new Button(By.xpath(String.format(expandAlarm, hours)));
    }
}
