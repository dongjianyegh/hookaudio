package com.example.hookaudio;

import android.media.AudioRecord;
import android.os.Handler;
import android.util.Log;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * @author dongjianye on 1/8/21
 */
class HookAudioRecord {

    static void hookAudioRecord(XC_LoadPackage.LoadPackageParam lpparam, final String inputName) {
        XposedHelpers.findAndHookConstructor("android.media.AudioRecord", lpparam.classLoader,
                int.class, int.class, int.class, int.class, int.class, new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        try {
                            Log.d("dongjianye", String.format("%s:AudioRecord:Construct(audioSource:%d, sample:%d, channel:%d, format:%d, buffer:%d)[Thread:(id:%d, name:%s)]",
                                    inputName,
                                    param.args[0],
                                    param.args[1],
                                    param.args[2],
                                    param.args[3],
                                    param.args[4],
                                    Thread.currentThread().getId(),
                                    Thread.currentThread().getName()));
                        } catch (Throwable ignored) {
                            ignored.printStackTrace();
                        }
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                    }
                });

        XposedHelpers.findAndHookMethod("android.media.AudioRecord",
                lpparam.classLoader,
                "startRecording",
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        try {
                            Log.d("dongjianye", String.format("%s:AudioRecord:startRecording()[Thread:(id:%d, name:%s)]",
                                    inputName,
                                    Thread.currentThread().getId(), Thread.currentThread().getName()));
                        } catch (Throwable ignored) {
                            ignored.printStackTrace();
                        }
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                    }


                });

        XposedHelpers.findAndHookMethod("android.media.AudioRecord", lpparam.classLoader, "read",
                byte[].class, int.class, int.class, int.class, new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        try {
                            Log.d("dongjianye", String.format("%s:AudioRecord:read(offsetInBytes:%d, sizeInBytes:%d, readMode:%d)[Thread:(id:%d, name:%s)]",
                                    inputName,
                                    (Integer)param.args[1],
                                    (Integer)param.args[2],
                                    (Integer)param.args[3],
                                    Thread.currentThread().getId(),
                                    Thread.currentThread().getName()));
                        } catch (Throwable ignored) {
                            ignored.printStackTrace();
                        }
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                    }
                });

        XposedHelpers.findAndHookMethod("android.media.AudioRecord",
                lpparam.classLoader,
                "setRecordPositionUpdateListener",
                AudioRecord.OnRecordPositionUpdateListener.class, Handler.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        try {
                            Log.d("dongjianye", String.format("%s:AudioRecord:setRecordPositionUpdateListener()[Thread:(id:%d, name:%s)]",
                                    inputName,
                                    Thread.currentThread().getId(), Thread.currentThread().getName()));
                        } catch (Throwable ignored) {
                            ignored.printStackTrace();
                        }
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                    }
                });

        XposedHelpers.findAndHookMethod("android.media.AudioRecord",
                lpparam.classLoader,
                "release",
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        try {
                            Log.d("dongjianye", String.format("%s:AudioRecord:release()[Thread:(id:%d, name:%s)]",
                                    inputName,
                                    Thread.currentThread().getId(), Thread.currentThread().getName()));
                        } catch (Throwable ignored) {
                            ignored.printStackTrace();
                        }
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                    }
                });

        XposedHelpers.findAndHookMethod("android.media.AudioRecord",
                lpparam.classLoader,
                "stop",
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        try {
                            Log.d("dongjianye", String.format("%s:AudioRecord:stop()[Thread:(id:%d, name:%s)]",
                                    inputName,
                                    Thread.currentThread().getId(), Thread.currentThread().getName()));
                        } catch (Throwable ignored) {
                            ignored.printStackTrace();
                        }
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                    }
                });
    }
}