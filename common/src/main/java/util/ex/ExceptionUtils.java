/**
 * Copyright (c) @2016,cmct 版权所有
 */
package util.ex;

/**
 * 异常转换
 *
 * @author losing
 * @Date 2016年8月15日
 * @since v0.1
 */
public class ExceptionUtils {

    private static final boolean HAS_UNSAFE = hasUnsafe0();
    private static final boolean IS_ANDROID = isAndroid0();

    public static boolean isAndroid() {
        return IS_ANDROID;
    }

    private static boolean hasUnsafe0() {

        if (isAndroid()) {
            return false;
        }

        try {
            boolean hasUnsafe = PlatformDependent0.hasUnsafe();
            return hasUnsafe;
        } catch (Throwable t) {
            // Probably failed to initialize PlatformDependent0.
            return false;
        }
    }

    private static boolean isAndroid0() {
        boolean android;
        try {
            Class.forName("android.app.Application", false, getSystemClassLoader());
            android = true;
        } catch (Exception e) {
            // Failed to load the class uniquely available in Android.
            android = false;
        }

        return android;
    }

    private static ClassLoader getSystemClassLoader() {
        return PlatformDependent0.getSystemClassLoader();
    }

    private static boolean hasUnsafe() {
        return HAS_UNSAFE;
    }

    public static void throwException(Throwable t) {
        if (hasUnsafe()) {
            PlatformDependent0.throwException(t);
        } else {
            ExceptionUtils.<RuntimeException>throwException0(t);
        }
    }

    @SuppressWarnings("unchecked")
    private static <E extends Throwable> void throwException0(Throwable t) throws E {
        throw (E) t;
    }
}
