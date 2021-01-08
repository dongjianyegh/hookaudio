package com.example.hookaudio;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.AudioRecord;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;

import java.lang.reflect.Method;
import java.util.ArrayList;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * @author dongjianye on 2020/12/2
 */
public class HookAudio implements IXposedHookLoadPackage {


    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {

        if (lpparam.packageName.equals("com.iflytek.inputmethod")) {
//            hookAudioRecord(lpparam, "IFly");
//            hookPopupWindow(lpparam);
//            hookAudioTrack(lpparam);
//            hookCanvas(lpparam, "IFly");

//            XposedHelpers.findAndHookMethod("com.iflytek.inputmethod.common.util.ThirdVibratorUtil",lpparam.classLoader,
//                    "isThirdVibratorType",
//                    Context.class,
//                    new XC_MethodHook() {
//                        @Override
//                        protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//                            super.beforeHookedMethod(param);
//
//                            try {
//                                Log.d("dongjianye", String.format("ThirdVibratorUtil.isThirdVibratorType()[Thread:(id:%d, name:%s)][class:%s]",
//                                        Thread.currentThread().getId(), Thread.currentThread().getName(), param.thisObject.getClass().getName()));
//                            } catch (Throwable ignored) {
//                                ignored.printStackTrace();
//                            }
//                        }
//
//                        @Override
//                        protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                            super.afterHookedMethod(param);
//                        }
//                    });

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


//            XposedHelpers.findAndHookMethod("com.iflytek.common.util.system.PhoneInfoUtils",lpparam.classLoader,
//                    "isMeizu",
//                    new XC_MethodHook() {
//                        @Override
//                        protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//                            super.beforeHookedMethod(param);
//
//                            try {
//                                Log.d("dongjianye", String.format("PhoneInfoUtils:isMeizu()[Thread:(id:%d, name:%s)]",
//                                        Thread.currentThread().getId(), Thread.currentThread().getName()));
//                            } catch (Throwable ignored) {
//                                ignored.printStackTrace();
//                            }
//                        }
//
//                        @Override
//                        protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                            super.afterHookedMethod(param);
//                            param.setResult(true);
//                        }
//                    });



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

//        if (lpparam.packageName.equals("com.baidu.input")) {
//            hookAudioRecord(lpparam, "Baidu");
//            hookCanvas(lpparam, "Baidu");
//            hookAudioTrack(lpparam);
//            hookPopupWindow(lpparam);
//
//            XposedHelpers.findAndHookMethod("com.baidu.gfp",lpparam.classLoader,
//                    "i",
//                    String.class, String.class,
//                    new XC_MethodHook() {
//                        @Override
//                        protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//                            super.beforeHookedMethod(param);
//
//                            try {
//                                Log.d("dongjianye", String.format("baidu.gfp.i(%s, %s)[Thread:(id:%d, name:%s)][class:%s]",
//                                        param.args[0], param.args[1],
//                                        Thread.currentThread().getId(), Thread.currentThread().getName(), param.thisObject.getClass().getName()));
//                            } catch (Throwable ignored) {
//                                ignored.printStackTrace();
//                            }
//                        }
//
//                        @Override
//                        protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                            super.afterHookedMethod(param);
//                        }
//                    });
//        }

//        if (lpparam.packageName.equals("com.sohu.inputmethod.sogou")) {
//            hookCanvas(lpparam, "Sogou");
//        }

//        if (lpparam.packageName.equals("com.google.android.inputmethod.latin")) {
//            hookCanvas(lpparam, "Gboard");
//        }

//        if (lpparam.packageName.equals("com.touchtype.swiftkey")) {
//            hookCanvas(lpparam, "Swift");
//        }
    }

    private void hookCanvas(XC_LoadPackage.LoadPackageParam lpparam, final String inputName) {
        XposedHelpers.findAndHookMethod("android.graphics.Canvas", lpparam.classLoader,
                "drawText",
                CharSequence.class, int.class, int.class, float.class, float.class, Paint.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        try {
                            try {
                                if ("Q".equals(param.args[0])) {
                                    Log.d("dongjianye", Log.getStackTraceString(new Throwable()));
                                }
                            } catch (Throwable e) {
                            }


                            Log.d("dongjianye", String.format("%s:Canvas:draw(%s)[Thread:(id:%d, name:%s)]",
                                    inputName,
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

        XposedHelpers.findAndHookMethod("android.graphics.Canvas", lpparam.classLoader,
                "drawText",
                String.class, float.class, float.class, Paint.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        try {
                            try {
                                if ("Q".equals(param.args[0])) {
                                    Log.d("dongjianye", Log.getStackTraceString(new Throwable()));
                                }
                            } catch (Throwable e) {
                            }
                            Log.d("dongjianye", String.format("%s:Canvas:draw(%s)[Thread:(id:%d, name:%s)]",
                                    inputName,
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

        XposedHelpers.findAndHookMethod("android.graphics.Canvas", lpparam.classLoader,
                "drawText",
                String.class, int.class, int.class, float.class, float.class, Paint.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        try {
                            try {
                                if ("Q".equals(param.args[0])) {
                                    Log.d("dongjianye", Log.getStackTraceString(new Throwable()));
                                }
                            } catch (Throwable e) {
                            }
                            Log.d("dongjianye", String.format("%s:Canvas:draw(%s)[Thread:(id:%d, name:%s)]",
                                    inputName,
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

        XposedHelpers.findAndHookMethod("android.graphics.Canvas", lpparam.classLoader,
                "drawText",
                char[].class, int.class, int.class, float.class, float.class, Paint.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        try {
                            Log.d("dongjianye", String.format("%s:Canvas:draw(%s)[Thread:(id:%d, name:%s)]",
                                    inputName,
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

        XposedHelpers.findAndHookMethod("android.graphics.Canvas", lpparam.classLoader,
                "drawBitmap",
                Bitmap.class, float.class, float.class, Paint.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        try {
                            Log.d("dongjianye", String.format("%s:Canvas:drawBitmap()[Thread:(id:%d, name:%s)]",
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

        XposedHelpers.findAndHookMethod("android.graphics.Canvas", lpparam.classLoader,
                "drawBitmap",
                Bitmap.class, Rect.class, RectF.class, Paint.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        try {
                            Log.d("dongjianye", String.format("%s:Canvas:drawBitmap()[Thread:(id:%d, name:%s)]",
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

        XposedHelpers.findAndHookMethod("android.graphics.Canvas", lpparam.classLoader,
                "drawBitmap",
                Bitmap.class, Rect.class, Rect.class, Paint.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        try {
                            Log.d("dongjianye", String.format("%s:Canvas:drawBitmap()[Thread:(id:%d, name:%s)]",
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

        XposedHelpers.findAndHookMethod("android.graphics.Canvas", lpparam.classLoader,
                "drawPatch",
                NinePatch.class, Rect.class, Paint.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        try {
                            Log.d("dongjianye", String.format("%s:Canvas:drawPatch(Rect:%s)[Thread:(id:%d, name:%s)]",
                                    inputName,
                                    param.args[1],
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

        XposedHelpers.findAndHookMethod("android.graphics.Canvas", lpparam.classLoader,
                "drawPatch",
                NinePatch.class, RectF.class, Paint.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        try {
                            Log.d("dongjianye", String.format("%s:Canvas:drawPatch(Rect:%s)[Thread:(id:%d, name:%s)]",
                                    inputName,
                                    param.args[1],
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

        XposedHelpers.findAndHookMethod("android.graphics.Canvas", lpparam.classLoader,
                "drawRect",
                RectF.class, Paint.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        try {
                            Log.d("dongjianye", String.format("%s:Canvas:drawRect(Rect:%s)[Thread:(id:%d, name:%s)]",
                                    inputName,
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

        XposedHelpers.findAndHookMethod("android.graphics.Canvas", lpparam.classLoader,
                "drawRect",
                RectF.class, Paint.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        try {
                            Log.d("dongjianye", String.format("%s:Canvas:drawRect(RectF:%s)[Thread:(id:%d, name:%s)]",
                                    inputName,
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

        XposedHelpers.findAndHookMethod("android.graphics.Canvas", lpparam.classLoader,
                "drawRect",
                float.class, float.class, float.class, float.class, Paint.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        try {
                            Log.d("dongjianye", String.format("%s:Canvas:drawRect(left:%f, top:%f, right:%f, bottom:%f)[Thread:(id:%d, name:%s)]",
                                    inputName,
                                    param.args[0], param.args[1], param.args[2], param.args[3],
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

        XposedHelpers.findAndHookMethod("android.graphics.Canvas", lpparam.classLoader,
                "drawRoundRect",
                RectF.class, float.class, float.class, Paint.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        try {
                            Log.d("dongjianye", String.format("%s:Canvas:drawRect(Rect:%s, rx:%f, ry:%f)[Thread:(id:%d, name:%s)]",
                                    inputName,
                                    param.args[0], param.args[1], param.args[2],
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

        XposedHelpers.findAndHookMethod("android.graphics.Canvas", lpparam.classLoader,
                "drawRoundRect",
                float.class, float.class, float.class, float.class, float.class, float.class, Paint.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        try {
                            Log.d("dongjianye", String.format("%s:Canvas:drawRect(left:%f, top:%f, right:%f, bottom:%f, rx:%f, ry:%f)[Thread:(id:%d, name:%s)]",
                                    inputName,
                                    param.args[0], param.args[1], param.args[2], param.args[3], param.args[4], param.args[5],
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

        XposedHelpers.findAndHookMethod("android.graphics.Canvas", lpparam.classLoader,
                "drawPath",
                Path.class, Paint.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        try {
                            Log.d("dongjianye", String.format("%s:Canvas:drawPath()[Thread:(id:%d, name:%s)]",
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

        XposedHelpers.findAndHookMethod("android.graphics.drawable.NinePatchDrawable", lpparam.classLoader,
                "draw",
                Canvas.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        try {
                            Log.d("dongjianye", String.format("%s:NinePatchDrawable:draw()[Thread:(id:%d, name:%s)]",
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

    private void hookAudioRecord(XC_LoadPackage.LoadPackageParam lpparam, final String inputName) {
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

    private void hookAudioTrack(XC_LoadPackage.LoadPackageParam lpparam) {
        XposedHelpers.findAndHookConstructor("android.media.AudioTrack",lpparam.classLoader,
                int.class, int.class, int.class, int.class, int.class, int.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        try {
                            Log.d("dongjianye", String.format("AudioTrack:Construct(stream:%d, sample:%d, channel:%d, format:%d, buffer:%d, mode:%d, session:%d)[Thread:(id:%d, name:%s)]",
                                    param.args[0], param.args[1], param.args[2], param.args[3], param.args[4], param.args[5],
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

        XposedHelpers.findAndHookMethod("android.media.AudioTrack",lpparam.classLoader,
                "play",
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        try {
                            Log.d("dongjianye", String.format("AudioTrack:play()[Thread:(id:%d, name:%s)]",
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

        XposedHelpers.findAndHookMethod("android.media.AudioTrack",lpparam.classLoader,
                "release",
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        try {
                            Log.d("dongjianye", String.format("AudioTrack:release()[Thread:(id:%d, name:%s)]",
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

    private void hookPopupWindow(XC_LoadPackage.LoadPackageParam lpparam) {
        XposedHelpers.findAndHookMethod(PopupWindow.class,
                "showAtLocation",
                View.class, int.class, int.class, int.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        try {
                            Log.d("dongjianye", String.format("PopupWindow:show()[Thread:(id:%d, name:%s)]",
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