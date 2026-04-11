package w1;

import android.content.Context;
import android.content.res.Resources;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.StrictMode;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.RelativeSizeSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EdgeEffect;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.datepicker.n;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.concurrent.Future;
import ya.u;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class d implements x0.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static AudioManager f13785a;

    public static void a(long j4, ag.e eVar, int i, ArrayList arrayList, int i10, int i11, ArrayList arrayList2) {
        int i12;
        int i13;
        ArrayList arrayList3;
        long j7;
        int i14;
        int i15 = i;
        ArrayList arrayList4 = arrayList;
        ArrayList arrayList5 = arrayList2;
        if (i10 >= i11) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        for (int i16 = i10; i16 < i11; i16++) {
            if (((ag.h) arrayList4.get(i16)).a() < i15) {
                throw new IllegalArgumentException("Failed requirement.");
            }
        }
        ag.h hVar = (ag.h) arrayList.get(i10);
        ag.h hVar2 = (ag.h) arrayList4.get(i11 - 1);
        if (i15 == hVar.a()) {
            int iIntValue = ((Number) arrayList5.get(i10)).intValue();
            int i17 = i10 + 1;
            ag.h hVar3 = (ag.h) arrayList4.get(i17);
            i12 = i17;
            i13 = iIntValue;
            hVar = hVar3;
        } else {
            i12 = i10;
            i13 = -1;
        }
        if (hVar.d(i15) == hVar2.d(i15)) {
            int iMin = Math.min(hVar.a(), hVar2.a());
            int i18 = 0;
            for (int i19 = i15; i19 < iMin && hVar.d(i19) == hVar2.d(i19); i19++) {
                i18++;
            }
            long j10 = 4;
            long j11 = (eVar.f429w / j10) + j4 + ((long) 2) + ((long) i18) + 1;
            eVar.l0(-i18);
            eVar.l0(i13);
            int i20 = i15 + i18;
            while (i15 < i20) {
                eVar.l0(hVar.d(i15) & 255);
                i15++;
            }
            if (i12 + 1 == i11) {
                if (i20 != ((ag.h) arrayList4.get(i12)).a()) {
                    throw new IllegalStateException("Check failed.");
                }
                eVar.l0(((Number) arrayList5.get(i12)).intValue());
                return;
            } else {
                ag.e eVar2 = new ag.e();
                eVar.l0(((int) ((eVar2.f429w / j10) + j11)) * (-1));
                a(j11, eVar2, i20, arrayList4, i12, i11, arrayList5);
                eVar.h0(eVar2);
                return;
            }
        }
        int i21 = 1;
        for (int i22 = i12 + 1; i22 < i11; i22++) {
            if (((ag.h) arrayList4.get(i22 - 1)).d(i15) != ((ag.h) arrayList4.get(i22)).d(i15)) {
                i21++;
            }
        }
        long j12 = 4;
        long j13 = (eVar.f429w / j12) + j4 + ((long) 2) + ((long) (i21 * 2));
        eVar.l0(i21);
        eVar.l0(i13);
        for (int i23 = i12; i23 < i11; i23++) {
            int iD = ((ag.h) arrayList4.get(i23)).d(i15);
            if (i23 == i12 || iD != ((ag.h) arrayList4.get(i23 - 1)).d(i15)) {
                eVar.l0(iD & 255);
            }
        }
        ag.e eVar3 = new ag.e();
        int i24 = i12;
        while (i24 < i11) {
            byte bD = ((ag.h) arrayList4.get(i24)).d(i15);
            int i25 = i24 + 1;
            int i26 = i25;
            while (true) {
                if (i26 >= i11) {
                    i26 = i11;
                    break;
                } else if (bD != ((ag.h) arrayList4.get(i26)).d(i15)) {
                    break;
                } else {
                    i26++;
                }
            }
            if (i25 == i26 && i15 + 1 == ((ag.h) arrayList4.get(i24)).a()) {
                eVar.l0(((Number) arrayList5.get(i24)).intValue());
                arrayList3 = arrayList5;
                j7 = j13;
                i14 = i26;
            } else {
                eVar.l0(((int) ((eVar3.f429w / j12) + j13)) * (-1));
                arrayList3 = arrayList5;
                j7 = j13;
                i14 = i26;
                a(j7, eVar3, i15 + 1, arrayList, i24, i14, arrayList3);
                arrayList4 = arrayList;
            }
            j13 = j7;
            i24 = i14;
            arrayList5 = arrayList3;
        }
        eVar.h0(eVar3);
    }

    public static void b(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static boolean c(File file, Resources resources, int i) throws Throwable {
        InputStream inputStreamOpenRawResource;
        try {
            inputStreamOpenRawResource = resources.openRawResource(i);
            try {
                boolean zD = d(file, inputStreamOpenRawResource);
                b(inputStreamOpenRawResource);
                return zD;
            } catch (Throwable th) {
                th = th;
                b(inputStreamOpenRawResource);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStreamOpenRawResource = null;
        }
    }

    public static boolean d(File file, InputStream inputStream) throws Throwable {
        FileOutputStream fileOutputStream;
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file, false);
            } catch (IOException e9) {
                e = e9;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int i = inputStream.read(bArr);
                if (i == -1) {
                    b(fileOutputStream);
                    StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
                    return true;
                }
                fileOutputStream.write(bArr, 0, i);
            }
        } catch (IOException e10) {
            e = e10;
            fileOutputStream2 = fileOutputStream;
            Log.e("TypefaceCompatUtil", "Error copying resource contents to temp file: " + e.getMessage());
            b(fileOutputStream2);
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            b(fileOutputStream2);
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
            throw th;
        }
    }

    public static final float e(Context context, float f) {
        Resources resources = context.getResources();
        ge.i.d(resources, "resources");
        if (Float.isNaN(f * resources.getDisplayMetrics().density)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        return Math.round(r2);
    }

    public static void f(Serializable serializable) {
        Log.e("RootBeer", k() + String.valueOf(serializable));
        Log.e("QLog", k() + String.valueOf(serializable));
    }

    public static synchronized AudioManager g(Context context) {
        try {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                f13785a = null;
            }
            AudioManager audioManager = f13785a;
            if (audioManager != null) {
                return audioManager;
            }
            Looper looperMyLooper = Looper.myLooper();
            if (looperMyLooper != null && looperMyLooper != Looper.getMainLooper()) {
                y1.g gVar = new y1.g();
                y1.b.i().execute(new nc.i(10, applicationContext, gVar));
                gVar.b();
                AudioManager audioManager2 = f13785a;
                audioManager2.getClass();
                return audioManager2;
            }
            AudioManager audioManager3 = (AudioManager) applicationContext.getSystemService("audio");
            f13785a = audioManager3;
            audioManager3.getClass();
            return audioManager3;
        } catch (Throwable th) {
            throw th;
        }
    }

    public static float h(EdgeEffect edgeEffect) {
        if (Build.VERSION.SDK_INT >= 31) {
            return x0.c.b(edgeEffect);
        }
        return 0.0f;
    }

    public static Object i(Future future) {
        Object obj;
        boolean z10 = false;
        if (!future.isDone()) {
            throw new IllegalStateException(com.bumptech.glide.e.i("Future was expected to be done: %s", future));
        }
        while (true) {
            try {
                obj = future.get();
                break;
            } catch (InterruptedException unused) {
                z10 = true;
            } catch (Throwable th) {
                if (z10) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z10) {
            Thread.currentThread().interrupt();
        }
        return obj;
    }

    public static File j(Context context) {
        File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            return null;
        }
        String str = ".font" + Process.myPid() + "-" + Process.myTid() + "-";
        for (int i = 0; i < 100; i++) {
            File file = new File(cacheDir, str + i);
            if (file.createNewFile()) {
                return file;
            }
        }
        return null;
    }

    public static String k() {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        String methodName = stackTrace[2].getMethodName();
        String className = stackTrace[2].getClassName();
        int lineNumber = stackTrace[2].getLineNumber();
        return className.substring(className.lastIndexOf(46) + 1) + ": " + methodName + "() [" + lineNumber + "] - ";
    }

    public static u l(Object obj) {
        return obj == null ? u.f15014w : new u(obj);
    }

    public static boolean m(MotionEvent motionEvent, int i) {
        return (motionEvent.getSource() & i) == i;
    }

    public static MappedByteBuffer n(Context context, Uri uri) {
        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor;
        try {
            parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r", null);
        } catch (IOException unused) {
        }
        if (parcelFileDescriptorOpenFileDescriptor == null) {
            if (parcelFileDescriptorOpenFileDescriptor != null) {
                parcelFileDescriptorOpenFileDescriptor.close();
                return null;
            }
            return null;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
            try {
                FileChannel channel = fileInputStream.getChannel();
                MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
                fileInputStream.close();
                parcelFileDescriptorOpenFileDescriptor.close();
                return map;
            } finally {
            }
        } finally {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:71:0x0129, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static ag.m o(ag.h... r13) {
        /*
            Method dump skipped, instruction units count: 360
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w1.d.o(ag.h[]):ag.m");
    }

    public static void p(EditorInfo editorInfo, InputConnection inputConnection, TextView textView) {
        if (inputConnection == null || editorInfo.hintText != null) {
            return;
        }
        for (ViewParent parent = textView.getParent(); parent instanceof View; parent = parent.getParent()) {
        }
    }

    public static float q(EdgeEffect edgeEffect, float f, float f10) {
        if (Build.VERSION.SDK_INT >= 31) {
            return x0.c.c(edgeEffect, f, f10);
        }
        x0.b.a(edgeEffect, f, f10);
        return f;
    }

    public static final boolean r(String str) {
        ge.i.e(str, "method");
        return (str.equals("GET") || str.equals("HEAD")) ? false : true;
    }

    public static void s(x1.a aVar) {
        aVar.f14233k = -3.4028235E38f;
        aVar.f14232j = Integer.MIN_VALUE;
        CharSequence charSequence = aVar.f14225a;
        if (charSequence instanceof Spanned) {
            if (!(charSequence instanceof Spannable)) {
                aVar.f14225a = SpannableString.valueOf(charSequence);
                aVar.f14226b = null;
            }
            CharSequence charSequence2 = aVar.f14225a;
            charSequence2.getClass();
            Spannable spannable = (Spannable) charSequence2;
            for (Object obj : spannable.getSpans(0, spannable.length(), Object.class)) {
                if ((obj instanceof AbsoluteSizeSpan) || (obj instanceof RelativeSizeSpan)) {
                    spannable.removeSpan(obj);
                }
            }
        }
    }

    public static float t(int i, float f, int i10, int i11) {
        float f10;
        if (f == -3.4028235E38f) {
            return -3.4028235E38f;
        }
        if (i == 0) {
            f10 = i11;
        } else {
            if (i != 1) {
                if (i != 2) {
                    return -3.4028235E38f;
                }
                return f;
            }
            f10 = i10;
        }
        return f * f10;
    }

    public static void u(Context context) {
        h.g gVarA = new h.g(context).setTitle("Enable Low Quality Mode").a("Turn on this option to improve playback on slow networks. Video quality will be lowered to help reduce buffering and enhance stability.");
        View viewInflate = LayoutInflater.from(context).inflate(q5.l.dialog_video_set, (ViewGroup) null, false);
        int i = q5.k.sw;
        SwitchCompat switchCompat = (SwitchCompat) android.support.v4.media.session.b.l(viewInflate, i);
        if (switchCompat == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
        }
        switchCompat.setChecked(com.bumptech.glide.d.t(context).getBoolean("video_setting", false));
        switchCompat.setOnCheckedChangeListener(new v5.k(1, context));
        gVarA.setView((CoordinatorLayout) viewInflate);
        gVarA.c("Close", null);
        h.h hVarD = gVarA.d();
        hVarD.B.i.setOnClickListener(new n(13, hVarD));
    }

    public static void v(String str) {
        Log.v("RootBeer", k() + String.valueOf(str));
    }

    public static int w(int i) {
        return (i >>> 1) ^ (-(i & 1));
    }

    public static long x(long j4) {
        return (j4 >>> 1) ^ (-(1 & j4));
    }
}
