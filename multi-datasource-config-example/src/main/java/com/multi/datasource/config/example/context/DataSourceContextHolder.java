package com.multi.datasource.config.example.context;
/**
    ThreadLocal is a Java class that provides thread-local variables, which are variables where each thread has its own, independent copy. This is especially useful in multithreaded environments where you want to avoid sharing state between threads or manage state that each thread can access without affecting others.

    How ThreadLocal Works
    Each thread accessing a ThreadLocal variable has its own separate instance of that variable, and changes made by one thread to the variable are not visible to other threads.
    When a thread accesses a ThreadLocal variable, it retrieves the value associated with that thread.
    Java automatically cleans up these variables when the thread is done (though explicitly calling .remove() on the ThreadLocal is often good practice to prevent memory leaks).
    Example Usage
    A typical use of ThreadLocal might be in a web application where you want each HTTP request (handled by a separate thread) to have its own transaction or database session. Here’s an example of a simple ThreadLocal variable holding a DateFormat instance, so each thread has its own date formatter.

    java
    Copy code
    public class DateFormatter {
        private static final ThreadLocal<DateFormat> dateFormatThreadLocal = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));

        public static String formatDate(Date date) {
            return dateFormatThreadLocal.get().format(date);
        }
    }
    In this example, each thread calling formatDate() will use its own instance of DateFormat, which avoids thread-safety issues associated with shared instances.

    Pros and Cons
    Pros:
    Isolation: Provides each thread with its own instance, avoiding synchronization issues.
    Performance: Reduces the need for synchronization when sharing mutable objects across threads.
    Cons:
    Memory Leaks: Improper use of ThreadLocal without calling .remove() can lead to memory leaks, especially in environments like web servers where threads are reused.
    Testing and Debugging: Can make code harder to debug since state is isolated to each thread.
    Common Use Cases
    Database transactions: Holding a database connection per thread for the duration of a request.
    Session management: Storing user session details that are unique to each request.
    Locale settings: Storing user-specific locale or timezone settings that should not affect other threads.
    Using ThreadLocal wisely helps ensure thread safety in cases where each thread needs a unique instance of an object, especially in multi-threaded applications like web servers.
 */
public class DataSourceContextHolder {
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    public static void setDataSourceType(String dsType) {
        contextHolder.set(dsType);
    }

    public static String getDataSourceType() {
        return contextHolder.get();
    }

    public static void clearDataSourceType() {
        contextHolder.remove();
    }
}
