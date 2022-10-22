package activity.clock;

import appiumControl.Button;
import org.openqa.selenium.By;

public class AlarmScreen {

    public final Button addAlarmButton = new Button(By.id("com.google.android.deskclock:id/fab"));

    public AlarmScreen(){
    }
}
