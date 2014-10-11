/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package de.octoate.kfzkennzeichen;

import java.util.*;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import org.netbeans.microedition.lcdui.SplashScreen;
import org.netbeans.microedition.lcdui.WaitScreen;
import org.netbeans.microedition.util.SimpleCancellableTask;

/**
 * @author Octoate
 */
public class KfzKennzeichen extends MIDlet implements CommandListener {

    private final static String VERSION = "0.1";
    private final static String APP_NAME_AND_VERSION = "Kfz Kennzeichen v" + VERSION;
    
    private boolean midletPaused = false;

    //data storage (contains vectors with objects)
    private Hashtable signCityIndex = new Hashtable();
    
    //<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    private SplashScreen splashScreen;
    private Form mainForm;
    private TextField textField;
    private StringItem stringItem;
    private WaitScreen waitScreen;
    private Command exitCommand;
    private Command searchCommand;
    private SimpleCancellableTask task;
    //</editor-fold>//GEN-END:|fields|0|

    /**
     * The KfzKennzeichen constructor.
     */
    public KfzKennzeichen() {
    }

    //<editor-fold defaultstate="collapsed" desc=" Generated Methods ">//GEN-BEGIN:|methods|0|
    //</editor-fold>//GEN-END:|methods|0|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: initialize ">//GEN-BEGIN:|0-initialize|0|0-preInitialize
    /**
     * Initilizes the application.
     * It is called only once when the MIDlet is started. The method is called before the <code>startMIDlet</code> method.
     */
    private void initialize() {//GEN-END:|0-initialize|0|0-preInitialize
        // write pre-initialize user code here
//GEN-LINE:|0-initialize|1|0-postInitialize
        // write post-initialize user code here
    }//GEN-BEGIN:|0-initialize|2|
    //</editor-fold>//GEN-END:|0-initialize|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: startMIDlet ">//GEN-BEGIN:|3-startMIDlet|0|3-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Started point.
     */
    public void startMIDlet() {//GEN-END:|3-startMIDlet|0|3-preAction
        // write pre-action user code here
        switchDisplayable(null, getSplashScreen());//GEN-LINE:|3-startMIDlet|1|3-postAction
        // write post-action user code here
        
        //load sign and city data
        signCityIndex = Util.GetSignCityIndex();
        
    }//GEN-BEGIN:|3-startMIDlet|2|
    //</editor-fold>//GEN-END:|3-startMIDlet|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: resumeMIDlet ">//GEN-BEGIN:|4-resumeMIDlet|0|4-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Resumed point.
     */
    public void resumeMIDlet() {//GEN-END:|4-resumeMIDlet|0|4-preAction
        // write pre-action user code here
//GEN-LINE:|4-resumeMIDlet|1|4-postAction
        // write post-action user code here
    }//GEN-BEGIN:|4-resumeMIDlet|2|
    //</editor-fold>//GEN-END:|4-resumeMIDlet|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: switchDisplayable ">//GEN-BEGIN:|5-switchDisplayable|0|5-preSwitch
    /**
     * Switches a current displayable in a display. The <code>display</code> instance is taken from <code>getDisplay</code> method. This method is used by all actions in the design for switching displayable.
     * @param alert the Alert which is temporarily set to the display; if <code>null</code>, then <code>nextDisplayable</code> is set immediately
     * @param nextDisplayable the Displayable to be set
     */
    public void switchDisplayable(Alert alert, Displayable nextDisplayable) {//GEN-END:|5-switchDisplayable|0|5-preSwitch
        // write pre-switch user code here
        Display display = getDisplay();//GEN-BEGIN:|5-switchDisplayable|1|5-postSwitch
        if (alert == null) {
            display.setCurrent(nextDisplayable);
        } else {
            display.setCurrent(alert, nextDisplayable);
        }//GEN-END:|5-switchDisplayable|1|5-postSwitch
        // write post-switch user code here
    }//GEN-BEGIN:|5-switchDisplayable|2|
    //</editor-fold>//GEN-END:|5-switchDisplayable|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: commandAction for Displayables ">//GEN-BEGIN:|7-commandAction|0|7-preCommandAction
    /**
     * Called by a system to indicated that a command has been invoked on a particular displayable.
     * @param command the Command that was invoked
     * @param displayable the Displayable where the command was invoked
     */
    public void commandAction(Command command, Displayable displayable) {//GEN-END:|7-commandAction|0|7-preCommandAction
        // write pre-action user code here
        if (displayable == mainForm) {//GEN-BEGIN:|7-commandAction|1|25-preAction
            if (command == exitCommand) {//GEN-END:|7-commandAction|1|25-preAction
                // write pre-action user code here
                exitMIDlet();//GEN-LINE:|7-commandAction|2|25-postAction
                // write post-action user code here
            } else if (command == searchCommand) {//GEN-LINE:|7-commandAction|3|30-preAction
                // write pre-action user code here
                switchDisplayable(null, getWaitScreen());//GEN-LINE:|7-commandAction|4|30-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|5|19-preAction
        } else if (displayable == splashScreen) {
            if (command == SplashScreen.DISMISS_COMMAND) {//GEN-END:|7-commandAction|5|19-preAction
                // write pre-action user code here
                switchDisplayable(null, getMainForm());//GEN-LINE:|7-commandAction|6|19-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|7|35-preAction
        } else if (displayable == waitScreen) {
            if (command == WaitScreen.FAILURE_COMMAND) {//GEN-END:|7-commandAction|7|35-preAction
                // write pre-action user code here
//GEN-LINE:|7-commandAction|8|35-postAction
                // write post-action user code here
            } else if (command == WaitScreen.SUCCESS_COMMAND) {//GEN-LINE:|7-commandAction|9|34-preAction
                // write pre-action user code here
                switchDisplayable(null, getMainForm());//GEN-LINE:|7-commandAction|10|34-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|11|7-postCommandAction
        }//GEN-END:|7-commandAction|11|7-postCommandAction
        // write post-action user code here
    }//GEN-BEGIN:|7-commandAction|12|
    //</editor-fold>//GEN-END:|7-commandAction|12|



    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: splashScreen ">//GEN-BEGIN:|17-getter|0|17-preInit
    /**
     * Returns an initiliazed instance of splashScreen component.
     * @return the initialized component instance
     */
    public SplashScreen getSplashScreen() {
        if (splashScreen == null) {//GEN-END:|17-getter|0|17-preInit
            // write pre-init user code here
            splashScreen = new SplashScreen(getDisplay());//GEN-BEGIN:|17-getter|1|17-postInit
            splashScreen.setTitle("splashScreen");
            splashScreen.setCommandListener(this);
            splashScreen.setFullScreenMode(true);
            splashScreen.setText(APP_NAME_AND_VERSION);//GEN-END:|17-getter|1|17-postInit
            // write post-init user code here
        }//GEN-BEGIN:|17-getter|2|
        return splashScreen;
    }
    //</editor-fold>//GEN-END:|17-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: mainForm ">//GEN-BEGIN:|22-getter|0|22-preInit
    /**
     * Returns an initiliazed instance of mainForm component.
     * @return the initialized component instance
     */
    public Form getMainForm() {
        if (mainForm == null) {//GEN-END:|22-getter|0|22-preInit
            // write pre-init user code here
            mainForm = new Form(APP_NAME_AND_VERSION, new Item[] { getTextField(), getStringItem() });//GEN-BEGIN:|22-getter|1|22-postInit
            mainForm.addCommand(getExitCommand());
            mainForm.addCommand(getSearchCommand());
            mainForm.setCommandListener(this);//GEN-END:|22-getter|1|22-postInit
            // write post-init user code here
        }//GEN-BEGIN:|22-getter|2|
        return mainForm;
    }
    //</editor-fold>//GEN-END:|22-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand ">//GEN-BEGIN:|24-getter|0|24-preInit
    /**
     * Returns an initiliazed instance of exitCommand component.
     * @return the initialized component instance
     */
    public Command getExitCommand() {
        if (exitCommand == null) {//GEN-END:|24-getter|0|24-preInit
            // write pre-init user code here
            exitCommand = new Command("Exit", Command.EXIT, 0);//GEN-LINE:|24-getter|1|24-postInit
            // write post-init user code here
        }//GEN-BEGIN:|24-getter|2|
        return exitCommand;
    }
    //</editor-fold>//GEN-END:|24-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField ">//GEN-BEGIN:|27-getter|0|27-preInit
    /**
     * Returns an initiliazed instance of textField component.
     * @return the initialized component instance
     */
    public TextField getTextField() {
        if (textField == null) {//GEN-END:|27-getter|0|27-preInit
            // write pre-init user code here
            textField = new TextField("Kennzeichen:", null, 32, TextField.ANY);//GEN-LINE:|27-getter|1|27-postInit
            // write post-init user code here
        }//GEN-BEGIN:|27-getter|2|
        return textField;
    }
    //</editor-fold>//GEN-END:|27-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem ">//GEN-BEGIN:|28-getter|0|28-preInit
    /**
     * Returns an initiliazed instance of stringItem component.
     * @return the initialized component instance
     */
    public StringItem getStringItem() {
        if (stringItem == null) {//GEN-END:|28-getter|0|28-preInit
            // write pre-init user code here
            stringItem = new StringItem("Suchergebnis:", null);//GEN-LINE:|28-getter|1|28-postInit
            // write post-init user code here
        }//GEN-BEGIN:|28-getter|2|
        return stringItem;
    }
    //</editor-fold>//GEN-END:|28-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: waitScreen ">//GEN-BEGIN:|31-getter|0|31-preInit
    /**
     * Returns an initiliazed instance of waitScreen component.
     * @return the initialized component instance
     */
    public WaitScreen getWaitScreen() {
        if (waitScreen == null) {//GEN-END:|31-getter|0|31-preInit
            // write pre-init user code here
            waitScreen = new WaitScreen(getDisplay());//GEN-BEGIN:|31-getter|1|31-postInit
            waitScreen.setTitle("waitScreen");
            waitScreen.setCommandListener(this);
            waitScreen.setText("Bitte warten...");
            waitScreen.setTask(getTask());//GEN-END:|31-getter|1|31-postInit
            // write post-init user code here
        }//GEN-BEGIN:|31-getter|2|
        return waitScreen;
    }
    //</editor-fold>//GEN-END:|31-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: searchCommand ">//GEN-BEGIN:|29-getter|0|29-preInit
    /**
     * Returns an initiliazed instance of searchCommand component.
     * @return the initialized component instance
     */
    public Command getSearchCommand() {
        if (searchCommand == null) {//GEN-END:|29-getter|0|29-preInit
            // write pre-init user code here
            searchCommand = new Command("Suchen", Command.ITEM, 0);//GEN-LINE:|29-getter|1|29-postInit
            // write post-init user code here
        }//GEN-BEGIN:|29-getter|2|
        return searchCommand;
    }
    //</editor-fold>//GEN-END:|29-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: task ">//GEN-BEGIN:|36-getter|0|36-preInit
    /**
     * Returns an initiliazed instance of task component.
     * @return the initialized component instance
     */
    public SimpleCancellableTask getTask() {
        if (task == null) {//GEN-END:|36-getter|0|36-preInit
            // write pre-init user code here
            task = new SimpleCancellableTask();//GEN-BEGIN:|36-getter|1|36-execute
            task.setExecutable(new org.netbeans.microedition.util.Executable() {
                public void execute() throws Exception {//GEN-END:|36-getter|1|36-execute
                    // write task-execution user code here
                    
                    //search for the city for the sign
                    String searchText = textField.getString();
                    if (searchText != null && !searchText.equals("") && searchText.length()!=0 ){
                        stringItem.setText(Util.searchForSign(signCityIndex, searchText));
                    }
                    
                }//GEN-BEGIN:|36-getter|2|36-postInit
            });//GEN-END:|36-getter|2|36-postInit
            // write post-init user code here
        }//GEN-BEGIN:|36-getter|3|
        return task;
    }
    //</editor-fold>//GEN-END:|36-getter|3|

    /**
     * Returns a display instance.
     * @return the display instance.
     */
    public Display getDisplay () {
        return Display.getDisplay(this);
    }

    /**
     * Exits MIDlet.
     */
    public void exitMIDlet() {
        switchDisplayable (null, null);
        destroyApp(true);
        notifyDestroyed();
    }

    /**
     * Called when MIDlet is started.
     * Checks whether the MIDlet have been already started and initialize/starts or resumes the MIDlet.
     */
    public void startApp() {
        if (midletPaused) {
            resumeMIDlet ();
        } else {
            initialize ();
            startMIDlet ();
        }
        midletPaused = false;
    }

    /**
     * Called when MIDlet is paused.
     */
    public void pauseApp() {
        midletPaused = true;
    }

    /**
     * Called to signal the MIDlet to terminate.
     * @param unconditional if true, then the MIDlet has to be unconditionally terminated and all resources has to be released.
     */
    public void destroyApp(boolean unconditional) {
    }

}
