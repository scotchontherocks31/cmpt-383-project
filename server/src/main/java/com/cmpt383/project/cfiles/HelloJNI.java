package com.cmpt383.project.cfiles;

public class HelloJNI {
    static {
        System.loadLibrary("hello"); // Load native library hello.dll (Windows) or libhello.so (Unixes)
                                     //  at runtime
                                     // This library contains a native method called sayHello()
     }
   
     // Declare an instance native method sayHello() which receives no parameter and returns void
    public native void sayHello();
}