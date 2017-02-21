//
// Created by gk on 2017/2/21.
//

#include <stdio.h>
#include <string.h>
#include <jni.h>
#include <time.h>
#include <android/log.h>

#define  LOG_TAG    "【C_LOG】"
#define  LOGI(...)  __android_log_print(ANDROID_LOG_INFO, LOG_TAG, __VA_ARGS__)
#define  LOGE(...)  __android_log_print(ANDROID_LOG_ERROR, LOG_TAG, __VA_ARGS__)

JNIEXPORT jstring JNICALL Java_com_example_gk_testndk_MainActivity_getStringFromJni (JNIEnv *env, jobject thiz)
{
    LOGE("调用 C getStringFromJni() 方法\n");
    char* str = "Hello Java! Im getStringFromJni";
    return (*env)->NewStringUTF(env, str);
}

JNIEXPORT void JNICALL Java_com_example_gk_testndk_MainActivity_postStringToJni (JNIEnv* env, jobject thiz, jstring str){
    LOGE("调用 C postStringToJni() 方法\n");
    char* string = (char*)(*env)->GetStringUTFChars(env, str, NULL);
    LOGE("%s\n", string);
    (*env)->ReleaseStringUTFChars(env, str, string);
}