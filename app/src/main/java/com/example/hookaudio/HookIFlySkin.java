package com.example.hookaudio;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.Log;

import java.lang.reflect.Method;
import java.util.ArrayList;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * @author dongjianye on 1/8/21
 */
class HookIFlySkin {

    static void hookAudioTrack(XC_LoadPackage.LoadPackageParam lpparam) {
        XposedHelpers.findAndHookMethod("com.iflytek.inputmethod.common.view.widget.GridGroup",lpparam.classLoader,
                "draw",
                Canvas.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        try {
                            Log.d("dongjianye", String.format("GridGroup:draw()[Thread:(id:%d, name:%s)][class:%s]",
                                    Thread.currentThread().getId(), Thread.currentThread().getName(), param.thisObject.getClass().getName()));
                        } catch (Throwable ignored) {
                            ignored.printStackTrace();
                        }
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                    }
                });

        XposedHelpers.findAndHookMethod("com.iflytek.inputmethod.common.view.widget.drawable.TextDrawable",lpparam.classLoader,
                "measure",
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        try {
                            Log.d("dongjianye", String.format("TextDrawable:measure()[Thread:(id:%d, name:%s)]",
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

        XposedHelpers.findAndHookMethod("com.iflytek.inputmethod.common.view.widget.drawable.TextDrawable",lpparam.classLoader,
                "setText",
                String.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        try {
                            Log.d("dongjianye", String.format("TextDrawable:setText(str:%s)[Thread:(id:%d, name:%s)]",
                                    param.args[0],
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

        Method getTextMethod = XposedHelpers.findMethodExact("com.iflytek.inputmethod.common.view.widget.drawable.TextDrawable",lpparam.classLoader, "getText");

        XposedHelpers.findAndHookMethod("com.iflytek.inputmethod.common.view.widget.drawable.TextDrawable",lpparam.classLoader,
                "draw",
                Canvas.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        try {
                            Log.d("dongjianye", String.format("TextDrawable:draw(%s)[Thread:(id:%d, name:%s)]",
                                    getTextMethod.invoke(param.thisObject),
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

        XposedHelpers.findAndHookMethod("com.iflytek.inputmethod.common.view.widget.Grid",lpparam.classLoader,
                "draw",
                Canvas.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        try {
                            Log.d("dongjianye", String.format("Grid:draw()[Thread:(id:%d, name:%s)]",
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

        XposedHelpers.findAndHookMethod("com.iflytek.inputmethod.service.data.DataUtils",lpparam.classLoader,
                "loadBitmap",
                Context.class, String.class, boolean.class, Rect.class, float.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        try {
                            Log.d("dongjianye", String.format("DataUtils:loadBitmap(str:%s, boolean:%d, rect:%s, float:%f)[Thread:(id:%d, name:%s)]",
                                    param.args[1], ((Boolean) param.args[2]) == Boolean.TRUE ? 1 : 0, param.args[3] == null ? "null" : param.args[3].toString(), (Float) param.args[4],
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

        // Hook PropFileParseFrame
        XposedHelpers.findAndHookMethod("com.iflytek.inputmethod.common.parse.PropFileParseFrame",lpparam.classLoader,
                "getPropFileFromPath",
                String.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        try {
                            Log.d("dongjianye", String.format("PropFileParseFrame:getPropFileFromPath(path:%s)[Thread:(id:%d, name:%s)][class:%s]",
                                    param.args[0],
                                    Thread.currentThread().getId(), Thread.currentThread().getName(), param.thisObject.getClass().getName()));

                        } catch (Throwable ignored) {
                            ignored.printStackTrace();
                        }
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                    }
                });

        XposedHelpers.findAndHookMethod("com.iflytek.inputmethod.common.parse.PropFileParseFrame",lpparam.classLoader,
                "registeParserSearchPath",
                int.class, String.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        try {
                            Log.d("dongjianye", String.format("PropFileParseFrame:registeParserSearchPath(type:%d, path:%s)[Thread:(id:%d, name:%s)][class:%s]",
                                    param.args[0], param.args[1],
                                    Thread.currentThread().getId(), Thread.currentThread().getName(), param.thisObject.getClass().getName()));

                        } catch (Throwable ignored) {
                            ignored.printStackTrace();
                        }
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                    }
                });


        XposedHelpers.findAndHookMethod("com.iflytek.inputmethod.common.parse.PropFileParseFrame", lpparam.classLoader,
                "registeParserSearchPath",
                int.class, ArrayList.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        try {

                            StringBuilder builder = new StringBuilder();
                            ArrayList<String> paths = (ArrayList) param.args[1];
                            if (paths != null) {
                                for (String path : paths) {
                                    builder.append(path).append(",");
                                }
                            }

                            Log.d("dongjianye", String.format("PropFileParseFrame:registeParserSearchPath(type:%d, paths:%s)[Thread:(id:%d, name:%s)][class:%s]",
                                    param.args[0], builder.toString(),
                                    Thread.currentThread().getId(), Thread.currentThread().getName(), param.thisObject.getClass().getName()));

                        } catch (Throwable ignored) {
                            ignored.printStackTrace();
                        }
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                    }
                });


        // 获取KeyboardLayoutInfo
        XposedHelpers.findAndHookMethod("app.fkp",lpparam.classLoader,
                "a",
                int.class, int.class, int.class, boolean.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        try {
                            Log.d("dongjianye", String.format("Fkp:LoadKeyboardInfo(%d, %d, %d, %s)[Thread:(id:%d, name:%s)]",
                                    param.args[0], param.args[1],param.args[2], param.args[3],
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

        // 获取KeyboardLayoutInfo
        XposedHelpers.findAndHookMethod("app.fkp",lpparam.classLoader,
                "a",
                int.class, int.class, int.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        try {
                            Log.d("dongjianye", String.format("Fkp:getLayoutIniName(%d, %d, %d)[Thread:(id:%d, name:%s)]",
                                    param.args[0], param.args[1],param.args[2],
                                    Thread.currentThread().getId(), Thread.currentThread().getName()));

                        } catch (Throwable ignored) {
                            ignored.printStackTrace();
                        }
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                        try {
                            Log.d("dongjianye", String.format("Fkp:getLayoutIniName:result(%s)[Thread:(id:%d, name:%s)]",
                                    param.getResult(),
                                    Thread.currentThread().getId(), Thread.currentThread().getName()));

                        } catch (Throwable ignored) {
                            ignored.printStackTrace();
                        }
                    }
                });

        XposedHelpers.findAndHookMethod("app.fpi",lpparam.classLoader,
                "inputKeyCode",
                int.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        try {
                            Log.d("dongjianye", String.format("fpi:inputKeyCode(%d)[Thread:(id:%d, name:%s)]",
                                    param.args[0],
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

        XposedHelpers.findAndHookMethod("app.fpi",lpparam.classLoader,
                "inputKeyCode",
                int.class, int.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        try {
                            Log.d("dongjianye", String.format("fpi:inputKeyCode(%d, %d)[Thread:(id:%d, name:%s)]",
                                    param.args[0], param.args[1],
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