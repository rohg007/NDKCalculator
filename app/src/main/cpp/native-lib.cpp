#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_rohg007_android_jniapp_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Hello from the other side";
    return env->NewStringUTF(hello.c_str());
}

extern "C" JNIEXPORT jint JNICALL
Java_com_rohg007_android_jniapp_MainActivity_add(JNIEnv* env, jobject, jint x, jint y){
    return x+y;
}

extern "C" JNIEXPORT jint JNICALL
Java_com_rohg007_android_jniapp_MainActivity_sub(JNIEnv* env, jobject, jint x, jint y){
    return x-y;
}

extern "C" JNIEXPORT jint JNICALL
Java_com_rohg007_android_jniapp_MainActivity_mul(JNIEnv* env, jobject, jint x, jint y){
    return x*y;
}

extern "C" JNIEXPORT jint JNICALL
Java_com_rohg007_android_jniapp_MainActivity_div(JNIEnv* env, jobject, jint x, jint y){
    return x/y;
}