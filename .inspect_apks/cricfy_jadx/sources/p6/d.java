package p6;

import a7.g;
import android.content.Context;
import android.graphics.Rect;
import android.net.Uri;
import android.os.BadParcelableException;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.NetworkOnMainThreadException;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import androidx.fragment.app.n0;
import androidx.fragment.app.r0;
import androidx.fragment.app.y;
import com.google.android.gms.internal.measurement.h1;
import com.google.android.gms.internal.measurement.k1;
import com.google.android.material.internal.NavigationMenuView;
import com.google.android.material.navigation.NavigationView;
import d1.l1;
import da.t;
import f9.d2;
import f9.e1;
import f9.f0;
import f9.f1;
import f9.g2;
import f9.p1;
import f9.q4;
import f9.r1;
import f9.u0;
import f9.w0;
import f9.x2;
import f9.z;
import f9.z1;
import g2.i0;
import g6.b0;
import g6.n;
import h.a0;
import i2.h0;
import i2.j;
import i2.m;
import i2.p;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipInputStream;
import l0.e;
import l4.c0;
import l4.w;
import md.k;
import n.v;
import ne.h;
import se.x;
import t0.m0;
import t0.m1;
import t0.o;
import z5.i;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements e.b, i, x6.b, o, c5.b, k, v, n.i, p {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f10036v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Object f10037w;

    public /* synthetic */ d(int i, Object obj) {
        this.f10036v = i;
        this.f10037w = obj;
    }

    public static d C(String str) {
        return new d(13, (TextUtils.isEmpty(str) || str.length() > 1) ? d2.f4070w : g2.e(str.charAt(0)));
    }

    public void A(String str, String str2, Bundle bundle) {
        switch (this.f10036v) {
            case 15:
                x2 x2Var = (x2) this.f10037w;
                if (!TextUtils.isEmpty(str)) {
                    x2Var.getClass();
                    throw new IllegalStateException("Unexpected call on client side");
                }
                ((r1) x2Var.f307w).F.getClass();
                x2Var.r1("auto", "_err", bundle, true, true, System.currentTimeMillis());
                return;
            default:
                q4 q4Var = (q4) this.f10037w;
                if (!TextUtils.isEmpty(str)) {
                    q4Var.a0().v1(new z1(this, str, str2, bundle));
                    return;
                }
                r1 r1Var = q4Var.G;
                if (r1Var != null) {
                    w0 w0Var = r1Var.A;
                    r1.g(w0Var);
                    w0Var.B.b(str2, "AppId not known when logging event");
                    return;
                }
                return;
        }
    }

    public void B(String str, Bundle bundle) {
        String string;
        r1 r1Var = (r1) this.f10037w;
        p1 p1Var = r1Var.B;
        f1 f1Var = r1Var.f4367z;
        r1.g(p1Var);
        p1Var.m1();
        if (r1Var.a()) {
            return;
        }
        if (bundle.isEmpty()) {
            string = null;
        } else {
            if (true == str.isEmpty()) {
                str = "auto";
            }
            Uri.Builder builder = new Uri.Builder();
            builder.path(str);
            for (String str2 : bundle.keySet()) {
                builder.appendQueryParameter(str2, bundle.getString(str2));
            }
            string = builder.build().toString();
        }
        if (TextUtils.isEmpty(string)) {
            return;
        }
        r1.e(f1Var);
        f1Var.S.t(string);
        e1 e1Var = f1Var.T;
        r1Var.F.getClass();
        e1Var.e(System.currentTimeMillis());
    }

    public boolean D() {
        if (!H()) {
            return false;
        }
        r1 r1Var = (r1) this.f10037w;
        r1Var.F.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        f1 f1Var = r1Var.f4367z;
        r1.e(f1Var);
        return jCurrentTimeMillis - f1Var.T.c() > r1Var.f4366y.t1(null, f0.f4136k0);
    }

    @Override // md.k
    public boolean E() {
        return ((fd.c) this.f10037w).B;
    }

    @Override // i2.p
    public void F() {
        i0 i0Var = ((h0) this.f10037w).f9948c0;
        if (i0Var != null) {
            i0Var.a();
        }
    }

    @Override // i2.p
    public void G(int i, long j4, long j7) {
        i2.k kVar = ((h0) this.f10037w).f6048d1;
        Handler handler = (Handler) kVar.f6085v;
        if (handler != null) {
            handler.post(new i2.i(kVar, i, j4, j7));
        }
    }

    public boolean H() {
        f1 f1Var = ((r1) this.f10037w).f4367z;
        r1.e(f1Var);
        return f1Var.T.c() > 0;
    }

    @Override // c5.b
    public c5.a a(String str) {
        ge.i.e(str, "fileName");
        d5.d dVar = (d5.d) this.f10037w;
        String databaseName = dVar.getDatabaseName();
        if (databaseName == null) {
            if (!str.equals(":memory:")) {
                throw new IllegalArgumentException(e.k("This driver is configured to open an in-memory database but a file-based named '", str, "' was requested.").toString());
            }
        } else if (!databaseName.equals(str) && !h.r0('/', databaseName, databaseName).equals(h.r0('/', str, str))) {
            throw new IllegalArgumentException(("This driver is configured to open a database named '" + dVar.getDatabaseName() + "' but '" + str + "' was requested.").toString());
        }
        return new f5.a(dVar.Y());
    }

    @Override // i2.p
    public void b(boolean z10) {
        i2.k kVar = ((h0) this.f10037w).f6048d1;
        Handler handler = (Handler) kVar.f6085v;
        if (handler != null) {
            handler.post(new j(kVar, z10));
        }
    }

    @Override // n.v
    public void c(n.k kVar, boolean z10) {
        ((a0) this.f10037w).q(kVar);
    }

    @Override // i2.p
    public void d(int i) {
        l7.a aVar;
        h0 h0Var = (h0) this.f10037w;
        if (Build.VERSION.SDK_INT >= 35 && (aVar = h0Var.f6050f1) != null) {
            aVar.I(i);
        }
        i2.k kVar = h0Var.f6048d1;
        Handler handler = (Handler) kVar.f6085v;
        if (handler != null) {
            handler.post(new d6.i(i, 2, kVar));
        }
    }

    @Override // i2.p
    public void e(m mVar) {
        i2.k kVar = ((h0) this.f10037w).f6048d1;
        Handler handler = (Handler) kVar.f6085v;
        if (handler != null) {
            handler.post(new i2.i(kVar, mVar, 9));
        }
    }

    @Override // i2.p
    public void f(long j4) {
        i2.k kVar = ((h0) this.f10037w).f6048d1;
        Handler handler = (Handler) kVar.f6085v;
        if (handler != null) {
            handler.post(new i2.i(kVar, j4));
        }
    }

    @Override // c5.b
    public boolean g() {
        return true;
    }

    @Override // i2.p
    public void h() {
        v2.o oVar;
        h0 h0Var = (h0) this.f10037w;
        synchronized (h0Var.f4657v) {
            oVar = h0Var.M;
        }
        if (oVar != null) {
            oVar.h();
        }
    }

    @Override // e.b
    public void i(Object obj) {
        e.a aVar = (e.a) obj;
        r0 r0Var = (r0) this.f10037w;
        n0 n0Var = (n0) r0Var.D.pollLast();
        if (n0Var == null) {
            Log.w("FragmentManager", "No Activities were started for result for " + this);
            return;
        }
        String str = n0Var.f1024v;
        int i = n0Var.f1025w;
        y yVarK = r0Var.f1046c.k(str);
        if (yVarK != null) {
            yVarK.t(i, aVar.f3733v, aVar.f3734w);
            return;
        }
        Log.w("FragmentManager", "Activity result delivered for unknown Fragment " + str);
    }

    @Override // z5.i
    public void j(String str, Map map) {
        d6.k kVar = (d6.k) this.f10037w;
        kVar.d(str, kVar.f3430k, null, kVar.f3432m, map);
    }

    @Override // t0.o
    public t0.p1 k(View view, t0.p1 p1Var) {
        NavigationView navigationView = (NavigationView) this.f10037w;
        if (navigationView.f3635w == null) {
            navigationView.f3635w = new Rect();
        }
        Rect rect = navigationView.f3635w;
        int iB = p1Var.b();
        m1 m1Var = p1Var.f11791a;
        rect.set(iB, p1Var.d(), p1Var.c(), p1Var.a());
        t tVar = navigationView.D;
        tVar.getClass();
        int iD = p1Var.d();
        if (tVar.U != iD) {
            tVar.U = iD;
            int i = (tVar.f3630w.getChildCount() <= 0 && tVar.S) ? tVar.U : 0;
            NavigationMenuView navigationMenuView = tVar.f3629v;
            navigationMenuView.setPadding(0, i, 0, navigationMenuView.getPaddingBottom());
        }
        NavigationMenuView navigationMenuView2 = tVar.f3629v;
        navigationMenuView2.setPadding(0, navigationMenuView2.getPaddingTop(), 0, p1Var.a());
        m0.b(tVar.f3630w, p1Var);
        navigationView.setWillNotDraw(m1Var.k().equals(l0.c.f7601e) || navigationView.f3634v == null);
        navigationView.postInvalidateOnAnimation();
        return m1Var.c();
    }

    @Override // x6.b
    public boolean m(Object obj, File file, x6.h hVar) throws Throwable {
        InputStream inputStream = (InputStream) obj;
        g gVar = (g) this.f10037w;
        byte[] bArr = (byte[]) gVar.d(65536, byte[].class);
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
                    } catch (IOException e9) {
                        e = e9;
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
                        gVar.h(bArr);
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
                        gVar.h(bArr);
                        throw th;
                    }
                }
                fileOutputStream2.close();
                try {
                    fileOutputStream2.close();
                } catch (IOException unused3) {
                }
                gVar.h(bArr);
                return true;
            } catch (IOException e10) {
                e = e10;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // n.v
    public boolean n(n.k kVar) {
        Window.Callback callback = ((a0) this.f10037w).G.getCallback();
        if (callback == null) {
            return true;
        }
        callback.onMenuOpened(108, kVar);
        return true;
    }

    public b0 o(Context context, String str, InputStream inputStream, String str2, String str3) {
        b0 b0VarG;
        b bVar;
        c cVar = (c) this.f10037w;
        if (str2 == null) {
            str2 = "application/json";
        }
        if (str2.contains("application/zip") || str2.contains("application/x-zip") || str2.contains("application/x-zip-compressed") || str.split("\\?")[0].endsWith(".lottie")) {
            s6.c.a();
            b bVar2 = b.f10030x;
            b0VarG = str3 != null ? n.g(context, new ZipInputStream(new FileInputStream(cVar.s(str, inputStream, bVar2))), str) : n.g(context, new ZipInputStream(inputStream), null);
            bVar = bVar2;
        } else if (str2.contains("application/gzip") || str2.contains("application/x-gzip") || str.split("\\?")[0].endsWith(".tgs")) {
            s6.c.a();
            bVar = b.f10031y;
            b0VarG = str3 != null ? n.d(new GZIPInputStream(new FileInputStream(cVar.s(str, inputStream, bVar))), str) : n.d(new GZIPInputStream(inputStream), null);
        } else {
            s6.c.a();
            bVar = b.f10029w;
            b0VarG = str3 != null ? n.d(new FileInputStream(cVar.s(str, inputStream, bVar).getAbsolutePath()), str) : n.d(inputStream, null);
        }
        if (str3 != null && b0VarG.f5057a != null) {
            File file = new File(cVar.r(), c.n(str, bVar, true));
            File file2 = new File(file.getAbsolutePath().replace(".temp", ""));
            boolean zRenameTo = file.renameTo(file2);
            file2.toString();
            s6.c.a();
            if (!zRenameTo) {
                s6.c.b("Unable to rename cache file " + file.getAbsolutePath() + " to " + file2.getAbsolutePath() + ".");
            }
        }
        return b0VarG;
    }

    @Override // i2.p
    public void p() {
        ((h0) this.f10037w).f6059o1 = true;
    }

    @Override // i2.p
    public void q(Exception exc) {
        y1.b.h("MediaCodecAudioRenderer", "Audio sink error", exc);
        i2.k kVar = ((h0) this.f10037w).f6048d1;
        Handler handler = (Handler) kVar.f6085v;
        if (handler != null) {
            handler.post(new i2.i(kVar, exc, 5));
        }
    }

    public l1 r() {
        return (l1) ((x) this.f10037w).d();
    }

    public void s(fb.b bVar) {
        k1 k1Var = (k1) this.f10037w;
        ArrayList arrayList = k1Var.f2505c;
        synchronized (arrayList) {
            for (int i = 0; i < arrayList.size(); i++) {
                try {
                    if (bVar.equals(((Pair) arrayList.get(i)).first)) {
                        Log.w("FA", "OnEventListener already registered.");
                        return;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            h1 h1Var = new h1(bVar);
            arrayList.add(new Pair(bVar, h1Var));
            if (k1Var.f != null) {
                try {
                    k1Var.f.registerOnMeasurementEventListener(h1Var);
                    return;
                } catch (BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException unused) {
                    Log.w("FA", "Failed to register event listener on calling thread. Trying again on the dynamite thread.");
                }
            }
            k1Var.c(new com.google.android.gms.internal.measurement.w0(k1Var, h1Var, 4));
        }
    }

    @Override // i2.p
    public void t() {
        ((h0) this.f10037w).f6057m1 = true;
    }

    @Override // i2.p
    public void u() {
        i0 i0Var = ((h0) this.f10037w).f9948c0;
        if (i0Var != null) {
            i0Var.f4748a.f4833m0 = true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void v(d1.l1 r6) {
        /*
            r5 = this;
            java.lang.String r0 = "newState"
            ge.i.e(r6, r0)
            java.lang.Object r0 = r5.f10037w
            se.x r0 = (se.x) r0
        L9:
            java.lang.Object r1 = r0.d()
            r2 = r1
            d1.l1 r2 = (d1.l1) r2
            boolean r3 = r2 instanceof d1.d1
            if (r3 == 0) goto L16
            r3 = 1
            goto L1c
        L16:
            d1.m1 r3 = d1.m1.f3275b
            boolean r3 = ge.i.a(r2, r3)
        L1c:
            if (r3 == 0) goto L1f
            goto L29
        L1f:
            boolean r3 = r2 instanceof d1.d
            if (r3 == 0) goto L2b
            int r3 = r6.f3271a
            int r4 = r2.f3271a
            if (r3 <= r4) goto L2f
        L29:
            r2 = r6
            goto L2f
        L2b:
            boolean r3 = r2 instanceof d1.r0
            if (r3 == 0) goto L3e
        L2f:
            d5.a r3 = te.c.f12021b
            if (r1 != 0) goto L34
            r1 = r3
        L34:
            if (r2 != 0) goto L37
            r2 = r3
        L37:
            boolean r1 = r0.e(r1, r2)
            if (r1 == 0) goto L9
            return
        L3e:
            a9.l r6 = new a9.l
            r6.<init>()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: p6.d.v(d1.l1):void");
    }

    @Override // i2.p
    public void w(m mVar) {
        i2.k kVar = ((h0) this.f10037w).f6048d1;
        Handler handler = (Handler) kVar.f6085v;
        if (handler != null) {
            handler.post(new i2.i(kVar, mVar, 1));
        }
    }

    @Override // n.i
    public boolean x(n.k kVar, MenuItem menuItem) {
        return false;
    }

    @Override // n.i
    public void y(n.k kVar) {
        h.h0 h0Var = (h.h0) this.f10037w;
        Window.Callback callback = h0Var.f;
        if (h0Var.f5349e.f9308a.o()) {
            callback.onPanelClosed(108, kVar);
        } else if (callback.onPreparePanel(0, null, kVar)) {
            callback.onMenuOpened(108, kVar);
        }
    }

    public void z(int i, String str, List list, boolean z10, boolean z11) {
        u0 u0Var;
        f9.l1 l1Var = (f9.l1) this.f10037w;
        int i10 = i - 1;
        if (i10 == 0) {
            w0 w0Var = ((r1) l1Var.f307w).A;
            r1.g(w0Var);
            u0Var = w0Var.I;
        } else if (i10 != 1) {
            if (i10 == 3) {
                w0 w0Var2 = ((r1) l1Var.f307w).A;
                r1.g(w0Var2);
                u0Var = w0Var2.J;
            } else if (i10 != 4) {
                w0 w0Var3 = ((r1) l1Var.f307w).A;
                r1.g(w0Var3);
                u0Var = w0Var3.H;
            } else if (z10) {
                w0 w0Var4 = ((r1) l1Var.f307w).A;
                r1.g(w0Var4);
                u0Var = w0Var4.F;
            } else if (z11) {
                w0 w0Var5 = ((r1) l1Var.f307w).A;
                r1.g(w0Var5);
                u0Var = w0Var5.E;
            } else {
                w0 w0Var6 = ((r1) l1Var.f307w).A;
                r1.g(w0Var6);
                u0Var = w0Var6.G;
            }
        } else if (z10) {
            w0 w0Var7 = ((r1) l1Var.f307w).A;
            r1.g(w0Var7);
            u0Var = w0Var7.C;
        } else if (z11) {
            w0 w0Var8 = ((r1) l1Var.f307w).A;
            r1.g(w0Var8);
            u0Var = w0Var8.B;
        } else {
            w0 w0Var9 = ((r1) l1Var.f307w).A;
            r1.g(w0Var9);
            u0Var = w0Var9.D;
        }
        int size = list.size();
        if (size == 1) {
            u0Var.b(list.get(0), str);
            return;
        }
        if (size == 2) {
            u0Var.c(list.get(0), list.get(1), str);
        } else if (size != 3) {
            u0Var.a(str);
        } else {
            u0Var.d(str, list.get(0), list.get(1), list.get(2));
        }
    }

    public /* synthetic */ d(int i, boolean z10) {
        this.f10036v = i;
    }

    public d(c cVar, z zVar) {
        this.f10036v = 0;
        this.f10037w = cVar;
    }

    public d(d5.d dVar) {
        this.f10036v = 12;
        ge.i.e(dVar, "openHelper");
        this.f10037w = dVar;
    }

    public d(int i) {
        this.f10036v = i;
        switch (i) {
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                this.f10037w = new HashMap();
                break;
            case g1.h.STRING_FIELD_NUMBER /* 5 */:
            default:
                this.f10037w = new y1.t(10);
                break;
            case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                this.f10037w = new x(d1.m1.f3275b);
                break;
        }
    }

    public d(boolean z10) {
        this.f10036v = 22;
        this.f10037w = new AtomicBoolean(z10);
    }

    public d(EditText editText) {
        this.f10036v = 29;
        i2.k kVar = new i2.k();
        kVar.f6085v = editText;
        m1.i iVar = new m1.i(editText);
        kVar.f6086w = iVar;
        editText.addTextChangedListener(iVar);
        if (m1.a.f8019b == null) {
            synchronized (m1.a.f8018a) {
                try {
                    if (m1.a.f8019b == null) {
                        m1.a aVar = new m1.a();
                        try {
                            m1.a.f8020c = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, m1.a.class.getClassLoader());
                        } catch (Throwable unused) {
                        }
                        m1.a.f8019b = aVar;
                    }
                } finally {
                }
            }
        }
        editText.setEditableFactory(m1.a.f8019b);
        this.f10037w = kVar;
    }

    public d(Context context, c0 c0Var) {
        this.f10036v = 28;
        l4.b0 b0Var = ((w) c0Var.f7705w).f7767c;
        Collections.synchronizedSet(new HashSet());
        if (Build.VERSION.SDK_INT >= 29) {
            this.f10037w = new l4.n(context, b0Var);
        } else {
            this.f10037w = new l4.m(context, b0Var);
        }
    }
}
