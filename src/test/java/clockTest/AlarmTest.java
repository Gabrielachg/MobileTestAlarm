package clockTest;

import activity.clock.Alarm;
import activity.clock.AlarmScreen;
import activity.clock.MainMenu;
import activity.clock.SettingAlarmScreen;
import appiumControl.AppiumControl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AlarmTest {

    MainMenu mainMenu = new MainMenu();
    AlarmScreen alarmScreen = new AlarmScreen();
    SettingAlarmScreen settingAlarmScreen = new SettingAlarmScreen();

    Alarm alarm = new Alarm();

    @BeforeEach
    public void init(){
        mainMenu.alarmButton.click();
    }

    @Test
    public void verifyCreateAlarmAM(){
        String minutes = "20";
        String hour = "3";
        String timeAlarmSet;
        String statusDay;
        alarmScreen.addAlarmButton.click();
        settingAlarmScreen.setHourAlarm(hour).click();
        settingAlarmScreen.setMinuteAlarm(minutes).click();
        settingAlarmScreen.AMButton.click();
        statusDay = settingAlarmScreen.AMButton.getText();

        Assertions.assertEquals(minutes, settingAlarmScreen.minutesLabel.getText());
        Assertions.assertEquals(hour, settingAlarmScreen.hourLabel.getText());

        settingAlarmScreen.okButton.click();
        timeAlarmSet = hour + ":" + minutes + "\u200A" + statusDay;
        Assertions.assertEquals(timeAlarmSet, mainMenu.getTimeAlarm(timeAlarmSet).getText());
    }

    @Test
    public void verifyCreateAlarmPM(){
        String minutes = "5";
        String hour = "5";
        String timeAlarmSet;
        String statusDay;
        alarmScreen.addAlarmButton.click();
        settingAlarmScreen.setHourAlarm(hour).click();
        settingAlarmScreen.setMinuteAlarm(minutes).click();
        settingAlarmScreen.PMButton.click();
        statusDay = settingAlarmScreen.PMButton.getText();

        Assertions.assertEquals(settingAlarmScreen.getMinutesForValidate(minutes), settingAlarmScreen.minutesLabel.getText());
        Assertions.assertEquals(hour, settingAlarmScreen.hourLabel.getText());

        settingAlarmScreen.okButton.click();
        timeAlarmSet = hour + ":" + settingAlarmScreen.getMinutesForValidate(minutes) + "\u200A" + statusDay;
        Assertions.assertEquals(timeAlarmSet, mainMenu.getTimeAlarm(timeAlarmSet).getText());
    }

    @Test
    public void verifyUpdateAlarm(){
        String minutes = "20";
        String hour = "3";
        String newHour = "6";
        String newMinutes = "50";
        String timeAlarmSet;
        String statusDay;
        String ringtone;
        alarmScreen.addAlarmButton.click();
        settingAlarmScreen.setHourAlarm(hour).click();
        settingAlarmScreen.setMinuteAlarm(minutes).click();
        settingAlarmScreen.AMButton.click();
        statusDay = settingAlarmScreen.AMButton.getText();

        Assertions.assertEquals(settingAlarmScreen.getMinutesForValidate(minutes), settingAlarmScreen.minutesLabel.getText());
        Assertions.assertEquals(hour, settingAlarmScreen.hourLabel.getText());

        settingAlarmScreen.okButton.click();
        timeAlarmSet = hour + ":" + settingAlarmScreen.getMinutesForValidate(minutes) + "\u200A" + statusDay;
        Assertions.assertEquals(timeAlarmSet, mainMenu.getTimeAlarm(timeAlarmSet).getText());

        alarm.ringtoneButton.click();
        alarm.popupOptionDismissButton.click();
        alarm.selectRingtoneButton.click();
        ringtone = alarm.selectRingtoneButton.getText();
        alarm.navigateUpButton.click();
        Assertions.assertEquals(ringtone, alarm.ringtoneSelectedText.getText());

        mainMenu.clickAlarmCreated(timeAlarmSet).click();
        settingAlarmScreen.setHourAlarm(newHour).click();
        settingAlarmScreen.setMinuteAlarm(newMinutes).click();
        settingAlarmScreen.PMButton.click();
        settingAlarmScreen.okButton.click();
        String newTimeAlarm = newHour + ":" + settingAlarmScreen.getMinutesForValidate(newMinutes) + "\u200A" + "PM";
        Assertions.assertEquals(newTimeAlarm, mainMenu.getTimeAlarm(newTimeAlarm).getText());

        alarm.labelAlarm.click();
        alarm.editLabelTextBox.setText("Alarma Modificada");
        alarm.submitLabelButton.click();
        Assertions.assertEquals("Alarma Modificada", alarm.labelAlarm.getText());
    }

    @Test
    public void verifyDeleteAlam(){

        String time = alarm.timeLabelAlarm.getText();
        alarm.clickExpandAlarman(time).click();
        AppiumControl.waitTime(alarm.deleteAlarmButton);
        alarm.deleteAlarmButton.click();
        Assertions.assertFalse(mainMenu.clickAlarmCreated(time).isControlDisplayed());
    }

}
