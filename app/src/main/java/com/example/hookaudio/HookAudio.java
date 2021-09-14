package com.example.hookaudio;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * @author dongjianye on 2020/12/2
 */
public class HookAudio implements IXposedHookLoadPackage {


    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {

        if (lpparam.packageName.equals("com.iflytek.inputmethod")) {
//            HookInputConnection.hookInputConnection(lpparam);
//            HookSpeech.hookSpeechResult(lpparam);
        }

        if (lpparam.packageName.equals("com.baidu.input")) {
            HookBaiduIptCore.hookSpeechResult(lpparam);
        }
    }




}