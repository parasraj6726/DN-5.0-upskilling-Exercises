// Q34: Create and Use Java Modules
//
// This exercise requires a specific directory layout. 
// See the folder structure and instructions below.
//
// Directory Layout:
// modules/
//   com.utils/
//     module-info.java
//     com/utils/StringUtils.java
//   com.greetings/
//     module-info.java
//     com/greetings/Main.java
//
// ---- com.utils/module-info.java ----
// module com.utils {
//     exports com.utils;
// }
//
// ---- com/utils/StringUtils.java ----
// package com.utils;
// public class StringUtils {
//     public static String greet(String name) {
//         return "Hello, " + name + "! Welcome to Java Modules.";
//     }
// }
//
// ---- com.greetings/module-info.java ----
// module com.greetings {
//     requires com.utils;
// }
//
// ---- com/greetings/Main.java ----
// package com.greetings;
// import com.utils.StringUtils;
// public class Main {
//     public static void main(String[] args) {
//         System.out.println(StringUtils.greet("Java Developer"));
//     }
// }
//
// ---- Compile & Run Commands ----
// javac -d mods/com.utils  com.utils/module-info.java  com.utils/com/utils/StringUtils.java
// javac --module-path mods -d mods/com.greetings  com.greetings/module-info.java  com.greetings/com/greetings/Main.java
// java  --module-path mods -m com.greetings/com.greetings.Main

// Below are the actual source file contents as comments for reference.
// Create the directory layout and place the code accordingly.
public class JavaModulesReadme {
    public static void main(String[] args) {
        System.out.println("See comments in this file for module structure and compile steps.");
    }
}
