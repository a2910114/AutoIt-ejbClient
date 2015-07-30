package com.mykhaylenko.autoit;

import java.io.File;

import autoitx4java.AutoItX;

import com.jacob.com.LibraryLoader;

public class Autoit {

    private void loadProperty(String path){
        File file = new File(path);
        System.setProperty(LibraryLoader.JACOB_DLL_PATH, file.getAbsolutePath());
    }
    
    public void openInventory(){
        loadProperty("D:\\Projects\\AutoIt\\dll\\jacob-1.18-M2-x64.dll");
        
        String logonWindowTitle = "Inventory v8.1.0.00 Logon";
        String password = "CimUser!23";
        
        AutoItX x = new AutoItX();
        x.autoItSetOption(x.OPT_MOUSE_COORD_MODE , "0"); // autoItSetOption
        
        x.run("C:\\Program Files (x86)\\Telcordia\\Granite Inventory\\Inventory Client\\Inventory Client.exe");
        x.winActivate(logonWindowTitle);
        x.winWaitActive(logonWindowTitle);
        
        x.mouseClick("primary", 137, 219, 1, 10);
        x.send(password); 
        
        x.winWait(logonWindowTitle);
        x.mouseClick("primary", 158, 334, 1, 10);
    }
}
