# RASP

# Application testing :
# 1. Testing "Root detection":
In order to test root detection, it is necessary to download Genymotion desktop emulator available on the following web page :   https://www.genymotion.com/blog/2-12-oreo-final/ . 
The download button can be found at the bottom of the page. It is possible to download a regular or trial version of the emulator. 
![alt text](https://github.com/rackilea/Zavrsni_rad_RASP/blob/master/upute-slike/Genymotion_download.PNG)

Before downloading, you must register. Then you need to download the emulator (Without virtualbox option) and install the downloaded .exe file.
![alt text](https://github.com/rackilea/Zavrsni_rad_RASP/blob/master/upute-slike/download.PNG)

When installing, it is enough to support all of the default settings. After successful installation, you need to log in or select "Personal Use" in the Genymotion application. 

![alt text](https://github.com/rackilea/Zavrsni_rad_RASP/blob/master/upute-slike/personal_use.PNG)

Then select the desired emulator/device that will be used for testing the application (recommended device : Samsung Galaxy S8 - 7.0.0 - API24 - 1440x2960). After selecting the device, click the "Next" button twice and then the "Finish" button once.
![alt text](https://github.com/rackilea/Zavrsni_rad_RASP/blob/master/upute-slike/add_device.PNG)
![alt text](https://github.com/rackilea/Zavrsni_rad_RASP/blob/master/upute-slike/choose_device.PNG)

If the emulator does not start automatically, it can be started by clicking "Start".
![alt text](https://github.com/rackilea/Zavrsni_rad_RASP/blob/master/upute-slike/start_device.PNG)

Next step is to launch the test app in Android Studio. If you don't have Android Studio installed, it is available at the following link: https://developer.android.com/studio/index.html . Also, when installing Android Studio, it's enough to support all the default settings. 
When launching the app from Android Studio(by clicking on the Run button![alt text](https://github.com/rackilea/Zavrsni_rad_RASP/blob/master/upute-slike/Run.PNG)), you need to select Genymotion device, as it is shown on the following photo. 

![alt text](https://github.com/rackilea/Zavrsni_rad_RASP/blob/master/upute-slike/select_deployment_tagret.PNG)

Before the application is triggered, a popup appears asking for a permission for Superuser options. It is necessary to confirm this option.
![alt text](https://github.com/rackilea/Zavrsni_rad_RASP/blob/master/upute-slike/allow_SU.PNG)

After running the app, you should see the next screen.
![alt text](https://github.com/rackilea/Zavrsni_rad_RASP/blob/master/upute-slike/device_rooted.PNG)

# 2. Testing "Debug detection":
For this test we also need Android Studio and an Android device or emulator(the above mentioned Genymotion emulator can be used as well).
To test debug detection, the app from Android Studio can be started by clicking the Run button( ![alt text](https://github.com/rackilea/Zavrsni_rad_RASP/blob/master/upute-slike/Run.PNG)) or by clicking the Degub button(![alt text](https://github.com/rackilea/Zavrsni_rad_RASP/blob/master/upute-slike/Run_with_debugger.PNG)). 
If we started the application with the Run option, after starting the application, it is necessary to start the debugger afterwards by clicking the "Attach degubber to Android proccess" icon (![alt text](https://github.com/rackilea/Zavrsni_rad_RASP/blob/master/upute-slike/Attach_debugger.PNG)). App will check every two seconds to see if the debugger is active and in accordance with that information will handle the labels and send a warning. Debugger is released by pressing the Stop button(![alt text](https://github.com/rackilea/Zavrsni_rad_RASP/blob/master/upute-slike/Stop.PNG)).
During the change of startup and shutdown of the debugging process, the following two screens will be seen :
![alt text](https://github.com/rackilea/Zavrsni_rad_RASP/blob/master/upute-slike/Screenshot_20180420-172416.png)

![alt text](https://github.com/rackilea/Zavrsni_rad_RASP/blob/master/upute-slike/Screenshot_20180420-172503.png)
