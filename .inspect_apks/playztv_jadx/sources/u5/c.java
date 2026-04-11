package u5;

import a2.f0;
import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Rect;
import android.media.AudioAttributes;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.k0;
import androidx.fragment.app.n0;
import androidx.fragment.app.v;
import c0.e;
import c6.i;
import c7.s;
import cc.h0;
import com.google.android.gms.internal.measurement.k4;
import e6.j;
import f6.f;
import g2.k;
import g2.q;
import h.b0;
import j9.g;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Objects;
import java.util.WeakHashMap;
import k8.b2;
import k8.k1;
import k8.k3;
import k8.z0;
import k8.z1;
import n.j3;
import n.t3;
import n.u3;
import n.v2;
import o2.d1;
import o2.e1;
import o2.n1;
import p1.g1;
import q0.g0;
import q0.o0;
import q0.o1;
import q0.p;
import q0.r1;
import r0.o;
import s2.n;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class c implements e.b, p, n, o, d1, j3, v2, c6.b, g, c6.g {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f12781u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Object f12782v;

    public /* synthetic */ c(int i, Object obj) {
        this.f12781u = i;
        this.f12782v = obj;
    }

    public static String c(String str, b bVar, boolean z2) {
        String strConcat = bVar.f12780u;
        if (z2) {
            strConcat = ".temp".concat(strConcat);
        }
        String strReplaceAll = str.replaceAll("\\W+", "");
        int length = 242 - strConcat.length();
        if (strReplaceAll.length() > length) {
            try {
                byte[] bArrDigest = MessageDigest.getInstance("MD5").digest(strReplaceAll.getBytes());
                StringBuilder sb2 = new StringBuilder();
                for (byte b10 : bArrDigest) {
                    sb2.append(String.format("%02x", Byte.valueOf(b10)));
                }
                strReplaceAll = sb2.toString();
            } catch (NoSuchAlgorithmException unused) {
                strReplaceAll = strReplaceAll.substring(0, length);
            }
        }
        return j.n("lottie_cache_", strReplaceAll, strConcat);
    }

    public static c q(String str) {
        return new c(23, (TextUtils.isEmpty(str) || str.length() > 1) ? b2.f7089v : z1.f(str.charAt(0)));
    }

    @Override // c6.b
    public boolean B(Object obj, File file, i iVar) throws Throwable {
        InputStream inputStream = (InputStream) obj;
        f fVar = (f) this.f12782v;
        byte[] bArr = (byte[]) fVar.d(65536, byte[].class);
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                while (true) {
                    try {
                        int i = inputStream.read(bArr);
                        if (i == -1) {
                            break;
                        }
                        fileOutputStream2.write(bArr, 0, i);
                    } catch (IOException e10) {
                        e = e10;
                        fileOutputStream = fileOutputStream2;
                        if (Log.isLoggable("StreamEncoder", 3)) {
                            Log.d("StreamEncoder", "Failed to encode data onto the OutputStream", e);
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused) {
                            }
                        }
                        fVar.h(bArr);
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                        fVar.h(bArr);
                        throw th;
                    }
                }
                fileOutputStream2.close();
                try {
                    fileOutputStream2.close();
                } catch (IOException unused3) {
                }
                fVar.h(bArr);
                return true;
            } catch (IOException e11) {
                e = e11;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // q0.p
    public r1 C(View view, r1 r1Var) {
        int i;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14 = 1;
        switch (this.f12781u) {
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                o1 o1Var = r1Var.f10492a;
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.f12782v;
                if (!Objects.equals(coordinatorLayout.H, r1Var)) {
                    coordinatorLayout.H = r1Var;
                    boolean z2 = r1Var.d() > 0;
                    coordinatorLayout.I = z2;
                    coordinatorLayout.setWillNotDraw(!z2 && coordinatorLayout.getBackground() == null);
                    if (!o1Var.n()) {
                        int childCount = coordinatorLayout.getChildCount();
                        for (int i15 = 0; i15 < childCount; i15++) {
                            View childAt = coordinatorLayout.getChildAt(i15);
                            WeakHashMap weakHashMap = o0.f10475a;
                            if (!childAt.getFitsSystemWindows() || ((e) childAt.getLayoutParams()).f2209a == null || !o1Var.n()) {
                            }
                        }
                    }
                    coordinatorLayout.requestLayout();
                }
                return r1Var;
            default:
                int iD = r1Var.d();
                b0 b0Var = (b0) this.f12782v;
                Context context = b0Var.E;
                int iD2 = r1Var.d();
                ActionBarContextView actionBarContextView = b0Var.P;
                if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                    i = 0;
                    i10 = 8;
                    i11 = 0;
                } else {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) b0Var.P.getLayoutParams();
                    if (b0Var.P.isShown()) {
                        if (b0Var.f5437x0 == null) {
                            b0Var.f5437x0 = new Rect();
                            b0Var.f5438y0 = new Rect();
                        }
                        Rect rect = b0Var.f5437x0;
                        Rect rect2 = b0Var.f5438y0;
                        rect.set(r1Var.b(), r1Var.d(), r1Var.c(), r1Var.a());
                        ViewGroup viewGroup = b0Var.V;
                        if (Build.VERSION.SDK_INT >= 29) {
                            boolean z10 = u3.f8547a;
                            t3.a(viewGroup, rect, rect2);
                            i12 = 0;
                        } else {
                            if (u3.f8547a) {
                                i12 = 0;
                            } else {
                                u3.f8547a = true;
                                i12 = 0;
                                try {
                                    Method declaredMethod = View.class.getDeclaredMethod("computeFitSystemWindows", Rect.class, Rect.class);
                                    u3.f8548b = declaredMethod;
                                    if (!declaredMethod.isAccessible()) {
                                        u3.f8548b.setAccessible(true);
                                    }
                                } catch (NoSuchMethodException unused) {
                                    Log.d("ViewUtils", "Could not find method computeFitSystemWindows. Oh well.");
                                }
                            }
                            Method method = u3.f8548b;
                            if (method != null) {
                                try {
                                    Object[] objArr = new Object[2];
                                    objArr[i12] = rect;
                                    objArr[1] = rect2;
                                    method.invoke(viewGroup, objArr);
                                } catch (Exception e10) {
                                    Log.d("ViewUtils", "Could not invoke computeFitSystemWindows", e10);
                                }
                            }
                        }
                        int i16 = rect.top;
                        int i17 = rect.left;
                        int i18 = rect.right;
                        ViewGroup viewGroup2 = b0Var.V;
                        WeakHashMap weakHashMap2 = o0.f10475a;
                        r1 r1VarA = g0.a(viewGroup2);
                        int iB = r1VarA == null ? i12 : r1VarA.b();
                        int iC = r1VarA == null ? i12 : r1VarA.c();
                        if (marginLayoutParams.topMargin == i16 && marginLayoutParams.leftMargin == i17 && marginLayoutParams.rightMargin == i18) {
                            i13 = i12;
                        } else {
                            marginLayoutParams.topMargin = i16;
                            marginLayoutParams.leftMargin = i17;
                            marginLayoutParams.rightMargin = i18;
                            i13 = 1;
                        }
                        if (i16 <= 0 || b0Var.X != null) {
                            i10 = 8;
                            View view2 = b0Var.X;
                            if (view2 != null) {
                                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
                                int i19 = marginLayoutParams2.height;
                                int i20 = marginLayoutParams.topMargin;
                                if (i19 != i20 || marginLayoutParams2.leftMargin != iB || marginLayoutParams2.rightMargin != iC) {
                                    marginLayoutParams2.height = i20;
                                    marginLayoutParams2.leftMargin = iB;
                                    marginLayoutParams2.rightMargin = iC;
                                    b0Var.X.setLayoutParams(marginLayoutParams2);
                                }
                            }
                        } else {
                            View view3 = new View(context);
                            b0Var.X = view3;
                            i10 = 8;
                            view3.setVisibility(8);
                            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams.topMargin, 51);
                            layoutParams.leftMargin = iB;
                            layoutParams.rightMargin = iC;
                            b0Var.V.addView(b0Var.X, -1, layoutParams);
                        }
                        View view4 = b0Var.X;
                        int i21 = view4 == null ? i12 : 1;
                        if (i21 != 0 && view4.getVisibility() != 0) {
                            View view5 = b0Var.X;
                            view5.setBackgroundColor((view5.getWindowSystemUiVisibility() & 8192) != 0 ? context.getColor(g.c.abc_decor_view_status_guard_light) : context.getColor(g.c.abc_decor_view_status_guard));
                        }
                        if (!b0Var.f5417c0 && i21 != 0) {
                            iD2 = i12;
                        }
                        i11 = i21;
                        i14 = i13;
                        i = i12;
                        break;
                    } else {
                        i10 = 8;
                        i = 0;
                        if (marginLayoutParams.topMargin != 0) {
                            marginLayoutParams.topMargin = 0;
                            i11 = 0;
                        } else {
                            i11 = 0;
                            i14 = 0;
                        }
                    }
                    if (i14 != 0) {
                        b0Var.P.setLayoutParams(marginLayoutParams);
                    }
                }
                View view6 = b0Var.X;
                if (view6 != null) {
                    if (i11 == 0) {
                        i = i10;
                    }
                    view6.setVisibility(i);
                }
                return o0.i(view, iD != iD2 ? r1Var.f(r1Var.b(), iD2, r1Var.c(), r1Var.a()) : r1Var);
        }
    }

    public h4.a a() {
        return new h4.a(((AudioAttributes.Builder) this.f12782v).build());
    }

    @Override // s2.n
    public void b() throws c6.c {
        d2.g gVar = (d2.g) this.f12782v;
        gVar.U.b();
        c6.c cVar = gVar.W;
        if (cVar != null) {
            throw cVar;
        }
    }

    @Override // o2.d1
    public void d(e1 e1Var) {
        k kVar = (k) this.f12782v;
        kVar.K.d(kVar);
    }

    @Override // r0.o
    public boolean e(View view) {
        DrawerLayout drawerLayout = (DrawerLayout) this.f12782v;
        if (!DrawerLayout.n(view) || drawerLayout.i(view) == 2) {
            return false;
        }
        drawerLayout.c(view, true);
        return true;
    }

    @Override // c6.g
    public void f(byte[] bArr, Object obj, MessageDigest messageDigest) {
        Long l10 = (Long) obj;
        messageDigest.update(bArr);
        synchronized (((ByteBuffer) this.f12782v)) {
            ((ByteBuffer) this.f12782v).position(0);
            messageDigest.update(((ByteBuffer) this.f12782v).putLong(l10.longValue()).array());
        }
    }

    public File g(String str) {
        File file = new File(l(), c(str, b.f12776v, false));
        if (file.exists()) {
            return file;
        }
        File file2 = new File(l(), c(str, b.f12777w, false));
        if (file2.exists()) {
            return file2;
        }
        File file3 = new File(l(), c(str, b.f12778x, false));
        if (file3.exists()) {
            return file3;
        }
        return null;
    }

    public void h(h0 h0Var) {
        ((s) ((z6.f) ((nb.b) this.f12782v).get())).a("FIREBASE_APPQUALITY_SESSION", new z6.c("json"), new b2.f(2, this)).t(new z6.a(h0Var, z6.d.f14891u, null), new b2.f(1));
    }

    public void i() {
        k kVar = (k) this.f12782v;
        int i = kVar.L - 1;
        kVar.L = i;
        if (i > 0) {
            return;
        }
        int i10 = 0;
        for (q qVar : kVar.N) {
            qVar.w();
            i10 += qVar.f4908c0.f9178a;
        }
        g1[] g1VarArr = new g1[i10];
        int i11 = 0;
        for (q qVar2 : kVar.N) {
            qVar2.w();
            int i12 = qVar2.f4908c0.f9178a;
            int i13 = 0;
            while (i13 < i12) {
                qVar2.w();
                g1VarArr[i11] = qVar2.f4908c0.a(i13);
                i13++;
                i11++;
            }
        }
        kVar.M = new n1(g1VarArr);
        kVar.K.m(kVar);
    }

    @Override // e.b
    public void j(Object obj) {
        e.a aVar = (e.a) obj;
        n0 n0Var = (n0) this.f12782v;
        k0 k0Var = (k0) n0Var.C.pollFirst();
        if (k0Var == null) {
            Log.w("FragmentManager", "No Activities were started for result for " + this);
            return;
        }
        String str = k0Var.f1294u;
        int i = k0Var.f1295v;
        v vVarO = n0Var.f1312c.o(str);
        if (vVarO != null) {
            vVarO.t(i, aVar.f4213u, aVar.f4214v);
            return;
        }
        Log.w("FragmentManager", "Activity result delivered for unknown Fragment " + str);
    }

    public File l() {
        File file = new File(((Context) ((f0) this.f12782v).f220v).getCacheDir(), "lottie_network_cache");
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public c n(int i) {
        if (i == 16) {
            i = 12;
        }
        ((AudioAttributes.Builder) this.f12782v).setUsage(i);
        return this;
    }

    public /* bridge */ void o(int i) {
        n(i);
    }

    public File p(String str, InputStream inputStream, b bVar) throws IOException {
        File file = new File(l(), c(str, bVar, true));
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int i = inputStream.read(bArr);
                    if (i == -1) {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        return file;
                    }
                    fileOutputStream.write(bArr, 0, i);
                }
            } catch (Throwable th) {
                fileOutputStream.close();
                throw th;
            }
        } finally {
            inputStream.close();
        }
    }

    public void r() {
        k3 k3Var = (k3) this.f12782v;
        k3Var.p1();
        z0 z0VarN1 = k3Var.n1();
        k1 k1Var = (k1) k3Var.f2454v;
        k1Var.H.getClass();
        if (z0VarN1.u1(System.currentTimeMillis())) {
            k3Var.n1().H.a(true);
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (runningAppProcessInfo.importance == 100) {
                k3Var.g().I.d("Detected application was in foreground");
                k1Var.H.getClass();
                t(System.currentTimeMillis());
            }
        }
    }

    public void s(long j5) {
        k3 k3Var = (k3) this.f12782v;
        k3Var.p1();
        k3Var.w1();
        if (k3Var.n1().u1(j5)) {
            k3Var.n1().H.a(true);
            ((k1) k3Var.f2454v).m().y1();
        }
        k3Var.n1().L.d(j5);
        if (k3Var.n1().H.b()) {
            t(j5);
        }
    }

    public void t(long j5) {
        k3 k3Var = (k3) this.f12782v;
        k3Var.p1();
        k1 k1Var = (k1) k3Var.f2454v;
        if (k1Var.h()) {
            k3Var.n1().L.d(j5);
            k1Var.H.getClass();
            k3Var.g().I.c(Long.valueOf(SystemClock.elapsedRealtime()), "Session started, time");
            long j8 = j5 / 1000;
            k3Var.q1().x1(j5, Long.valueOf(j8), "auto", "_sid");
            k3Var.n1().M.d(j8);
            k3Var.n1().H.a(false);
            Bundle bundle = new Bundle();
            bundle.putLong("_sid", j8);
            k3Var.q1().w1(j5, bundle, "auto", "_s");
            String strO = k3Var.n1().R.o();
            if (TextUtils.isEmpty(strO)) {
                return;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString("_ffr", strO);
            k3Var.q1().w1(j5, bundle2, "auto", "_ssr");
        }
    }

    public /* synthetic */ c(int i, boolean z2) {
        this.f12781u = i;
    }

    public c(int i) {
        this.f12781u = i;
        switch (i) {
            case 18:
                this.f12782v = new AudioAttributes.Builder();
                break;
            case 27:
                this.f12782v = ByteBuffer.allocate(8);
                break;
            default:
                this.f12782v = new HashMap();
                new HashMap();
                break;
        }
    }

    public c(Context context, int i) {
        this.f12781u = i;
        switch (i) {
            case 26:
                t7.v.h(context);
                Context applicationContext = context.getApplicationContext();
                t7.v.h(applicationContext);
                this.f12782v = applicationContext;
                break;
            default:
                this.f12782v = new c7.k(context);
                break;
        }
    }

    public c(EditText editText) {
        this.f12781u = 13;
        k4 k4Var = new k4();
        k4Var.f3070u = editText;
        g1.i iVar = new g1.i(editText);
        k4Var.f3071v = iVar;
        editText.addTextChangedListener(iVar);
        if (g1.a.f4826b == null) {
            synchronized (g1.a.f4825a) {
                try {
                    if (g1.a.f4826b == null) {
                        g1.a aVar = new g1.a();
                        try {
                            g1.a.f4827c = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, g1.a.class.getClassLoader());
                        } catch (Throwable unused) {
                        }
                        g1.a.f4826b = aVar;
                    }
                } finally {
                }
            }
        }
        editText.setEditableFactory(g1.a.f4826b);
        this.f12782v = k4Var;
    }
}
