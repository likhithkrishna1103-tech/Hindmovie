package y1;

import android.net.Uri;
import android.opengl.EGL14;
import android.opengl.EGLDisplay;
import android.opengl.GLES20;
import android.opengl.GLU;
import android.text.TextUtils;
import android.util.Log;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ExecutorService f14563a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f14564b = new Object();

    public static String a(String str, Throwable th) {
        String strReplace;
        if (th != null) {
            synchronized (f14564b) {
                Throwable cause = th;
                while (true) {
                    if (cause == null) {
                        strReplace = Log.getStackTraceString(th).trim().replace("\t", "    ");
                        break;
                    }
                    try {
                        if (cause instanceof UnknownHostException) {
                            strReplace = "UnknownHostException (no network)";
                        } else {
                            cause = cause.getCause();
                        }
                    } finally {
                    }
                }
            }
        } else {
            strReplace = null;
        }
        if (TextUtils.isEmpty(strReplace)) {
            return str;
        }
        return str + "\n  " + strReplace.replace("\n", "\n  ") + '\n';
    }

    public static void b(int i, int i10) throws k {
        GLES20.glBindTexture(i, i10);
        c();
        GLES20.glTexParameteri(i, 10240, 9729);
        c();
        GLES20.glTexParameteri(i, 10241, 9729);
        c();
        GLES20.glTexParameteri(i, 10242, 33071);
        c();
        GLES20.glTexParameteri(i, 10243, 33071);
        c();
    }

    public static void c() throws k {
        StringBuilder sb = new StringBuilder();
        boolean z10 = false;
        while (true) {
            int iGlGetError = GLES20.glGetError();
            if (iGlGetError == 0) {
                break;
            }
            if (z10) {
                sb.append('\n');
            }
            String strGluErrorString = GLU.gluErrorString(iGlGetError);
            if (strGluErrorString == null) {
                strGluErrorString = "error code: 0x" + Integer.toHexString(iGlGetError);
            }
            sb.append("glError: ");
            sb.append(strGluErrorString);
            z10 = true;
        }
        if (z10) {
            throw new k(sb.toString());
        }
    }

    public static void d(String str, boolean z10) throws k {
        if (!z10) {
            throw new k(str);
        }
    }

    public static FloatBuffer e(float[] fArr) {
        return (FloatBuffer) ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(fArr).flip();
    }

    public static void f(String str, String str2) {
        synchronized (f14564b) {
            Log.d(str, a(str2, null));
        }
    }

    public static void g(String str, String str2) {
        synchronized (f14564b) {
            Log.e(str, a(str2, null));
        }
    }

    public static void h(String str, String str2, Throwable th) {
        synchronized (f14564b) {
            Log.e(str, a(str2, th));
        }
    }

    public static synchronized Executor i() {
        try {
            if (f14563a == null) {
                int i = a0.f14551a;
                f14563a = Executors.newSingleThreadExecutor(new androidx.emoji2.text.a(1, "ExoPlayer:BackgroundExecutor"));
            }
        } catch (Throwable th) {
            throw th;
        }
        return f14563a;
    }

    public static int[] j(String str) {
        int iIndexOf;
        int[] iArr = new int[4];
        if (TextUtils.isEmpty(str)) {
            iArr[0] = -1;
            return iArr;
        }
        int length = str.length();
        int iIndexOf2 = str.indexOf(35);
        if (iIndexOf2 != -1) {
            length = iIndexOf2;
        }
        int iIndexOf3 = str.indexOf(63);
        if (iIndexOf3 == -1 || iIndexOf3 > length) {
            iIndexOf3 = length;
        }
        int iIndexOf4 = str.indexOf(47);
        if (iIndexOf4 == -1 || iIndexOf4 > iIndexOf3) {
            iIndexOf4 = iIndexOf3;
        }
        int iIndexOf5 = str.indexOf(58);
        if (iIndexOf5 > iIndexOf4) {
            iIndexOf5 = -1;
        }
        int i = iIndexOf5 + 2;
        if (i < iIndexOf3 && str.charAt(iIndexOf5 + 1) == '/' && str.charAt(i) == '/') {
            iIndexOf = str.indexOf(47, iIndexOf5 + 3);
            if (iIndexOf == -1 || iIndexOf > iIndexOf3) {
                iIndexOf = iIndexOf3;
            }
        } else {
            iIndexOf = iIndexOf5 + 1;
        }
        iArr[0] = iIndexOf5;
        iArr[1] = iIndexOf;
        iArr[2] = iIndexOf3;
        iArr[3] = length;
        return iArr;
    }

    public static void k(String str, String str2) {
        synchronized (f14564b) {
            Log.i(str, a(str2, null));
        }
    }

    public static boolean l(String str) throws k {
        EGLDisplay eGLDisplayEglGetDisplay = EGL14.eglGetDisplay(0);
        d("No EGL display.", !eGLDisplayEglGetDisplay.equals(EGL14.EGL_NO_DISPLAY));
        d("Error in eglInitialize.", EGL14.eglInitialize(eGLDisplayEglGetDisplay, new int[1], 0, new int[1], 0));
        c();
        String strEglQueryString = EGL14.eglQueryString(eGLDisplayEglGetDisplay, 12373);
        return strEglQueryString != null && strEglQueryString.contains(str);
    }

    public static String m(StringBuilder sb, int i, int i10) {
        int i11;
        int iLastIndexOf;
        if (i >= i10) {
            return sb.toString();
        }
        if (sb.charAt(i) == '/') {
            i++;
        }
        int i12 = i;
        int i13 = i12;
        while (i12 <= i10) {
            if (i12 == i10) {
                i11 = i12;
            } else if (sb.charAt(i12) == '/') {
                i11 = i12 + 1;
            } else {
                i12++;
            }
            int i14 = i13 + 1;
            if (i12 == i14 && sb.charAt(i13) == '.') {
                sb.delete(i13, i11);
                i10 -= i11 - i13;
            } else {
                if (i12 == i13 + 2 && sb.charAt(i13) == '.' && sb.charAt(i14) == '.') {
                    iLastIndexOf = sb.lastIndexOf("/", i13 - 2) + 1;
                    int i15 = iLastIndexOf > i ? iLastIndexOf : i;
                    sb.delete(i15, i11);
                    i10 -= i11 - i15;
                } else {
                    iLastIndexOf = i12 + 1;
                }
                i13 = iLastIndexOf;
            }
            i12 = i13;
        }
        return sb.toString();
    }

    public static String n(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        int[] iArrJ = j(str2);
        if (iArrJ[0] != -1) {
            sb.append(str2);
            m(sb, iArrJ[1], iArrJ[2]);
            return sb.toString();
        }
        int[] iArrJ2 = j(str);
        if (iArrJ[3] == 0) {
            sb.append((CharSequence) str, 0, iArrJ2[3]);
            sb.append(str2);
            return sb.toString();
        }
        if (iArrJ[2] == 0) {
            sb.append((CharSequence) str, 0, iArrJ2[2]);
            sb.append(str2);
            return sb.toString();
        }
        int i = iArrJ[1];
        if (i != 0) {
            int i10 = iArrJ2[0] + 1;
            sb.append((CharSequence) str, 0, i10);
            sb.append(str2);
            return m(sb, iArrJ[1] + i10, i10 + iArrJ[2]);
        }
        if (str2.charAt(i) == '/') {
            sb.append((CharSequence) str, 0, iArrJ2[1]);
            sb.append(str2);
            int i11 = iArrJ2[1];
            return m(sb, i11, iArrJ[2] + i11);
        }
        int i12 = iArrJ2[0] + 2;
        int i13 = iArrJ2[1];
        if (i12 >= i13 || i13 != iArrJ2[2]) {
            int iLastIndexOf = str.lastIndexOf(47, iArrJ2[2] - 1);
            int i14 = iLastIndexOf == -1 ? iArrJ2[1] : iLastIndexOf + 1;
            sb.append((CharSequence) str, 0, i14);
            sb.append(str2);
            return m(sb, iArrJ2[1], i14 + iArrJ[2]);
        }
        sb.append((CharSequence) str, 0, i13);
        sb.append('/');
        sb.append(str2);
        int i15 = iArrJ2[1];
        return m(sb, i15, iArrJ[2] + i15 + 1);
    }

    public static Uri o(String str, String str2) {
        return Uri.parse(n(str, str2));
    }

    public static void p(String str, String str2) {
        synchronized (f14564b) {
            Log.w(str, a(str2, null));
        }
    }

    public static void q(String str, String str2, Throwable th) {
        synchronized (f14564b) {
            Log.w(str, a(str2, th));
        }
    }
}
