package com.example.hookaudio;

import android.graphics.Canvas;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class HookSpeech {

//    static Class sClazzSpeechMultiWord;

    private static void printCandidateWord(StringBuilder builder, Object obj) {
        builder.append("CandidateWord:(");
        builder.append("mFromType:").append(XposedHelpers.getIntField(obj, "mFromType")).append(",")
                .append("nScore:").append(XposedHelpers.getIntField(obj, "nScore")).append(",")
                .append("sWord:").append(XposedHelpers.getObjectField(obj, "sWord"))
                .append(")");
    }
    private static void printSplittedWord(StringBuilder builder, Object obj) {
        builder.append("SplittedWord:(");
        ArrayList aCandidate = (ArrayList) XposedHelpers.getObjectField(obj, "aCandidate");
        builder.append("aCandidate:(");
        if (aCandidate != null) {
            for (Object candidateWord : aCandidate) {
                printCandidateWord(builder, candidateWord);
                builder.append(",");
            }
        }
        builder.append(")");
        builder.append("nIndex:").append(XposedHelpers.getIntField(obj, "nIndex")).append(",")
                .append("nPosition:").append(XposedHelpers.getIntField(obj, "nPosition"))
                .append(")");
    }
    private static void printSmsResult(StringBuilder builder, Object obj) {
        builder.append("SmsResult:(");
        ArrayList aWords = (ArrayList) XposedHelpers.getObjectField(obj, "aWords");
        builder.append("aWords:(");
        if (aWords != null) {
            for (Object splitWord : aWords) {
                printSplittedWord(builder, splitWord);
                builder.append(",");
            }
        }
        builder.append(")");
        builder.append("bDynamicWord:").append(XposedHelpers.getBooleanField(obj, "bDynamicWord")).append(",");
        builder.append("mEngineType:").append(XposedHelpers.getObjectField(obj, "mEngineType")).append(",");
        builder.append("nMultiCandCnt:").append(XposedHelpers.getIntField(obj, "nMultiCandCnt")).append(",");
        builder.append("nSentenceID:").append(XposedHelpers.getIntField(obj, "nSentenceID")).append(",");
        builder.append("rStatus:").append(XposedHelpers.getIntField(obj, "rStatus")).append(",");
        builder.append("sDnm:").append(XposedHelpers.getObjectField(obj, "sDnm")).append(",");
        builder.append("sSentence:").append(XposedHelpers.getObjectField(obj, "sSentence")).append(",");
        builder.append("translateText:").append(XposedHelpers.getObjectField(obj, "translateText")).append(",");

    }

    private static void printCandidateWord(JSONObject builder, Object obj) {
        try {
            builder.put("mFromType", XposedHelpers.getIntField(obj, "mFromType"));
            builder.put("nScore", XposedHelpers.getIntField(obj, "nScore"));
            builder.put("sWord", XposedHelpers.getObjectField(obj, "sWord"));
        } catch (Exception e) {}

    }

    private static void printSemanticItem(JSONObject builder, Object obj) {
        try {
            builder.put("action", XposedHelpers.getIntField(obj, "action"));
            builder.put("endPosition", XposedHelpers.getIntField(obj, "endPosition"));
            builder.put("startPosition", XposedHelpers.getIntField(obj, "startPosition"));
            builder.put("text", XposedHelpers.getObjectField(obj, "text"));
        } catch (Exception e) {}

    }

    private static void printSplittedWord(JSONObject builder, Object obj) {
        try {
            builder.put("nIndex", XposedHelpers.getIntField(obj, "nIndex"));
            builder.put("nPosition", XposedHelpers.getIntField(obj, "nPosition"));
            ArrayList aCandidate = (ArrayList) XposedHelpers.getObjectField(obj, "aCandidate");
            if (aCandidate != null) {
                JSONArray candidateWordList = new JSONArray();
                int i = 0;
                for (Object candidateWord : aCandidate) {
                    JSONObject wordObject = new JSONObject();
                    printCandidateWord(wordObject, candidateWord);
                    candidateWordList.put(i++, wordObject);
                }
                builder.put("aCandidate", candidateWordList);
            }
        } catch (Exception e) {}
    }


    private static void printSmsResult(JSONObject builder, Object obj) {
        try {
            ArrayList aWords = (ArrayList) XposedHelpers.getObjectField(obj, "aWords");
            if (aWords != null) {
                JSONArray array = new JSONArray();
                int i = 0;
                for (Object splitWord : aWords) {
                    JSONObject wordObject = new JSONObject();
                    printSplittedWord(wordObject, splitWord);
                    array.put(i++, wordObject);
                }
                builder.put("aWords", array);
            }

            builder.put("bDynamicWord", XposedHelpers.getBooleanField(obj, "bDynamicWord"));
            builder.put("mEngineType", XposedHelpers.getObjectField(obj, "mEngineType"));
            builder.put("nMultiCandCnt", XposedHelpers.getIntField(obj, "nMultiCandCnt"));
            builder.put("nSentenceID", XposedHelpers.getIntField(obj, "nSentenceID"));
            builder.put("rStatus", XposedHelpers.getIntField(obj, "rStatus"));
            builder.put("sDnm", XposedHelpers.getObjectField(obj, "sDnm"));
            builder.put("sSentence", XposedHelpers.getObjectField(obj, "sSentence"));
            builder.put("translateText", XposedHelpers.getObjectField(obj, "translateText"));

            JSONObject semResult = new JSONObject();
            printSemanticResult(semResult, XposedHelpers.getObjectField(obj, "semResult"));
            builder.put("semResult", semResult);
        } catch (Exception e) {}
    }

    private static void printSemanticResult(JSONObject builder, Object obj) {
        try {
            builder.put("cmd", XposedHelpers.getObjectField(obj, "cmd"));
            builder.put("cont", XposedHelpers.getObjectField(obj, "cont"));
            builder.put("error", XposedHelpers.getIntField(obj, "error"));
            builder.put("msg", XposedHelpers.getObjectField(obj, "msg"));
            builder.put("originText", XposedHelpers.getObjectField(obj, "originText"));
            builder.put("status", XposedHelpers.getIntField(obj, "status"));

            List supplementCont = (List) XposedHelpers.getObjectField(obj, "supplementCont");
            if (supplementCont != null) {
                JSONArray supplementContArray = new JSONArray();
                int i = 0;
                for (Object candidateWord : supplementCont) {
                    supplementContArray.put(i++, candidateWord);
                }
                builder.put("supplementCont", supplementContArray);
            }

            {
                ArrayList a = (ArrayList) XposedHelpers.getObjectField(obj, "a");
                if (a != null) {
                    JSONArray candidateWordList = new JSONArray();
                    int i = 0;
                    for (Object candidateWord : a) {
                        JSONObject wordObject = new JSONObject();
                        printSemanticItem(wordObject, candidateWord);
                        candidateWordList.put(i++, wordObject);
                    }
                    builder.put("a", candidateWordList);
                }
            }

        } catch (Exception e) {}
    }

    static void hookSpeechResult(XC_LoadPackage.LoadPackageParam lpparam) {

        Log.d("dongjianye", "start");
        Class sClazzSmsResult;
        Class sClazzSplittedWord;
        Class sClazzCandidateWord;
        try {
            sClazzSmsResult = lpparam.classLoader.loadClass("com.iflytek.inputmethod.speech.api.entity.SmsResult");
            sClazzSplittedWord = lpparam.classLoader.loadClass("com.iflytek.inputmethod.speech.api.entity.SplittedWord");
            sClazzCandidateWord = lpparam.classLoader.loadClass("com.iflytek.inputmethod.speech.api.entity.CandidateWord");

            Log.d("dongjianye", sClazzSmsResult == null ? "null" : sClazzSmsResult.getName());
        } catch (Throwable e) {
            sClazzSmsResult = null;
            sClazzSplittedWord = null;
            sClazzCandidateWord = null;
            Log.d("dongjianye", e.getMessage());
        }

        if (sClazzSmsResult != null) {
            XposedHelpers.findAndHookMethod("app.eda", lpparam.classLoader,
                    "onSmsResult",
                    sClazzSmsResult, boolean.class,
                    new XC_MethodHook() {
                        @Override
                        protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                            super.beforeHookedMethod(param);

                            try {
                                Log.d("dongjianye", String.format("onSmsResult(%d)[Thread:(id:%d, name:%s)][class:%s]",
                                        ((Boolean) param.args[1]) ? 1 : 0,
                                        Thread.currentThread().getId(), Thread.currentThread().getName(), param.thisObject.getClass().getName()));

                                Object smsResult = param.args[0];
                                JSONObject smsJsonObject = new JSONObject();
                                printSmsResult(smsJsonObject, smsResult);
                                Log.d("dongjianye", smsJsonObject.toString());
                            } catch (Throwable ignored) {
                                Log.d("dongjianye", ignored.getMessage());
                            }
                        }

                        @Override
                        protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                            super.afterHookedMethod(param);
                        }
                    });
        }


        Log.d("dongjianye", "hook preCommitText");
    }
}
