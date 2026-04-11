package l4;

import android.content.ActivityNotFoundException;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.Cursor;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.GestureDetector;
import android.view.MenuItem;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.FileProvider;
import com.google.android.material.behavior.SwipeDismissBehavior;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeoutException;
import o.m3;
import org.json.JSONObject;
import qb.t1;
import t0.m0;
import v1.r1;
import v4.e1;
import vc.a1;
import vc.u0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class a implements l7.b, lb.a, n.i, o.n, o8.d, u0.o, q0.a, r9.b, se.c, e1, xc.b, w2.i, y2.d0 {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Object f7697v;

    public /* synthetic */ a(Object obj) {
        this.f7697v = obj;
    }

    public static void A(Context context, File file) {
        try {
            Uri uriD = FileProvider.d(context, context.getPackageName() + ".provider", file);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(uriD, "application/vnd.android.package-archive");
            intent.setFlags(268435456);
            intent.addFlags(1);
            context.startActivity(intent);
        } catch (ActivityNotFoundException | IllegalArgumentException | NullPointerException | SecurityException e9) {
            Toast.makeText(context, e9.getMessage(), 0).show();
        }
    }

    public static void E(File file) {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        for (File file2 : fileArrListFiles) {
            if (file2.isDirectory()) {
                E(file2);
            } else if (file2.getName().toLowerCase(Locale.US).endsWith(".apk")) {
                file2.delete();
            }
        }
    }

    public static String o(a aVar, long j4) {
        double d10 = j4 / 1024.0d;
        double d11 = d10 / 1024.0d;
        double d12 = d11 / 1024.0d;
        double d13 = d12 / 1024.0d;
        if (j4 >= 1024) {
            return j4 < 1048576 ? String.format("%.2f KB", Double.valueOf(d10)) : j4 < 1073741824 ? String.format("%.2f MB", Double.valueOf(d11)) : j4 < 1099511627776L ? String.format("%.2f GB", Double.valueOf(d12)) : String.format("%.2f TB", Double.valueOf(d13));
        }
        return j4 + " B";
    }

    public static File s(Context context, String str) {
        String lastPathSegment;
        try {
            lastPathSegment = Uri.parse(str).getLastPathSegment();
        } catch (Exception unused) {
        }
        if (TextUtils.isEmpty(lastPathSegment)) {
            lastPathSegment = "CricfyTv.apk";
        } else {
            if (lastPathSegment.contains("?")) {
                lastPathSegment = lastPathSegment.substring(0, lastPathSegment.indexOf(63));
            }
            if (!lastPathSegment.toLowerCase().endsWith(".apk")) {
                lastPathSegment = lastPathSegment.concat(".apk");
            }
        }
        return new File(context.getExternalFilesDir(null), lastPathSegment);
    }

    public void C(d8.j jVar, Thread thread, Throwable th) {
        nb.l lVar = (nb.l) this.f7697v;
        synchronized (lVar) {
            String str = "Handling uncaught exception \"" + th + "\" from thread " + thread.getName();
            if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                Log.d("FirebaseCrashlytics", str, null);
            }
            t1.l();
            try {
                nb.x.a(lVar.f8959e.f9742a.b(new nb.j(lVar, System.currentTimeMillis(), th, thread, jVar)));
            } catch (TimeoutException unused) {
                Log.e("FirebaseCrashlytics", "Cannot send reports. Timed out while fetching settings.", null);
            } catch (Exception e9) {
                Log.e("FirebaseCrashlytics", "Error handling uncaught exception", e9);
            }
        }
    }

    public JSONObject D() throws Throwable {
        FileInputStream fileInputStream;
        JSONObject jSONObject;
        FileInputStream fileInputStream2 = null;
        if (Log.isLoggable("FirebaseCrashlytics", 3)) {
            Log.d("FirebaseCrashlytics", "Checking for cached settings...", null);
        }
        try {
            File file = (File) this.f7697v;
            if (file.exists()) {
                fileInputStream = new FileInputStream(file);
                try {
                    try {
                        jSONObject = new JSONObject(nb.f.i(fileInputStream));
                        fileInputStream2 = fileInputStream;
                    } catch (Exception e9) {
                        e = e9;
                        Log.e("FirebaseCrashlytics", "Failed to fetch cached settings", e);
                        nb.f.b(fileInputStream, "Error while closing settings cache file.");
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    fileInputStream2 = fileInputStream;
                    nb.f.b(fileInputStream2, "Error while closing settings cache file.");
                    throw th;
                }
            } else {
                if (Log.isLoggable("FirebaseCrashlytics", 2)) {
                    Log.v("FirebaseCrashlytics", "Settings file does not exist.", null);
                }
                jSONObject = null;
            }
            nb.f.b(fileInputStream2, "Error while closing settings cache file.");
            return jSONObject;
        } catch (Exception e10) {
            e = e10;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            nb.f.b(fileInputStream2, "Error while closing settings cache file.");
            throw th;
        }
    }

    public a F(int i) {
        if (i == 16) {
            i = 12;
        }
        ((AudioAttributes.Builder) this.f7697v).setUsage(i);
        return this;
    }

    public /* bridge */ void G(int i) {
        F(i);
    }

    public void H(a aVar) {
        z5.b bVar = new z5.b(this, aVar);
        hd.e eVar = (hd.e) this.f7697v;
        eVar.getClass();
        synchronized (eVar.f) {
            ((md.j) eVar.f5925a).d(new ff.h(1, eVar, bVar));
        }
    }

    @Override // q0.a
    public Cursor b(Uri uri, String[] strArr, String[] strArr2) {
        ContentProviderClient contentProviderClient = (ContentProviderClient) this.f7697v;
        if (contentProviderClient == null) {
            return null;
        }
        try {
            return contentProviderClient.query(uri, strArr, "query = ?", strArr2, null, null);
        } catch (RemoteException e9) {
            Log.w("FontsProvider", "Unable to query the content provider", e9);
            return null;
        }
    }

    @Override // u0.o
    public boolean c(View view) {
        SwipeDismissBehavior swipeDismissBehavior = (SwipeDismissBehavior) this.f7697v;
        if (!swipeDismissBehavior.w(view)) {
            return false;
        }
        boolean z10 = view.getLayoutDirection() == 1;
        int i = swipeDismissBehavior.f2787y;
        int width = (!(i == 0 && z10) && (i != 1 || z10)) ? view.getWidth() : -view.getWidth();
        WeakHashMap weakHashMap = m0.f11777a;
        view.offsetLeftAndRight(width);
        view.setAlpha(0.0f);
        return true;
    }

    @Override // q0.a
    public void close() {
        ContentProviderClient contentProviderClient = (ContentProviderClient) this.f7697v;
        if (contentProviderClient != null) {
            contentProviderClient.release();
        }
    }

    @Override // y2.d0
    public void d() {
        y2.j jVar = (y2.j) this.f7697v;
        Surface surface = jVar.f14684s1;
        if (surface != null) {
            jVar.f14670e1.i(surface);
            jVar.f14687v1 = true;
        }
    }

    @Override // l7.b
    public z6.b0 e(z6.b0 b0Var, x6.h hVar) {
        Resources resources = (Resources) this.f7697v;
        if (b0Var == null) {
            return null;
        }
        return new g7.d(resources, b0Var);
    }

    @Override // y2.d0
    public void f() {
        y2.j jVar = (y2.j) this.f7697v;
        if (jVar.f14684s1 != null) {
            jVar.N0(0, 1);
        }
    }

    @Override // w2.i
    public i4.e g(w2.k kVar, long j4, long j7, IOException iOException, int i) {
        ((j2.d) this.f7697v).f6528a.x(iOException);
        return w2.o.f13883e;
    }

    @Override // qd.a
    public Object get() {
        return new u0((a1) ((xc.c) this.f7697v).get());
    }

    @Override // o8.d
    public void h(l8.b bVar) {
        o8.e eVar = (o8.e) this.f7697v;
        if (bVar.f7878w == 0) {
            eVar.n(null, eVar.t());
            return;
        }
        o8.c cVar = eVar.f9634p;
        if (cVar != null) {
            cVar.b(bVar);
        }
    }

    @Override // v4.e1
    public int i() {
        v4.h0 h0Var = (v4.h0) this.f7697v;
        return h0Var.f13259o - h0Var.C();
    }

    @Override // w2.i
    public void k(w2.k kVar, long j4, long j7) {
        boolean z10;
        j2.d dVar = (j2.d) this.f7697v;
        synchronized (x2.c.f14289b) {
            z10 = x2.c.f14290c;
        }
        if (z10) {
            dVar.a();
        } else {
            dVar.f6528a.x(new IOException(new ConcurrentModificationException()));
        }
    }

    @Override // y2.d0
    public void l() {
        g2.i0 i0Var = ((y2.j) this.f7697v).f9948c0;
        if (i0Var != null) {
            i0Var.a();
        }
    }

    @Override // v4.e1
    public int m(View view) {
        return (view.getTop() - ((v4.i0) view.getLayoutParams()).f13262b.top) - ((ViewGroup.MarginLayoutParams) ((v4.i0) view.getLayoutParams())).topMargin;
    }

    public b p() {
        return new b(((AudioAttributes.Builder) this.f7697v).build());
    }

    @Override // lb.a
    public void q(Bundle bundle) {
        ((eb.c) ((eb.b) this.f7697v)).a("clx", "_ae", bundle);
    }

    public synchronized void r() {
        ((SharedPreferences) this.f7697v).edit().clear().commit();
    }

    @Override // v4.e1
    public View t(int i) {
        return ((v4.h0) this.f7697v).u(i);
    }

    @Override // v4.e1
    public int u() {
        return ((v4.h0) this.f7697v).F();
    }

    @Override // v4.e1
    public int v(View view) {
        return view.getBottom() + ((v4.i0) view.getLayoutParams()).f13262b.bottom + ((ViewGroup.MarginLayoutParams) ((v4.i0) view.getLayoutParams())).bottomMargin;
    }

    public void w(Set set) {
        Object objD;
        int[] iArr;
        ge.i.e(set, "tableIds");
        if (set.isEmpty()) {
            return;
        }
        se.x xVar = (se.x) this.f7697v;
        do {
            objD = xVar.d();
            int[] iArr2 = (int[]) objD;
            int length = iArr2.length;
            iArr = new int[length];
            for (int i = 0; i < length; i++) {
                iArr[i] = set.contains(Integer.valueOf(i)) ? iArr2[i] + 1 : iArr2[i];
            }
            d5.a aVar = te.c.f12021b;
            if (objD == null) {
                objD = aVar;
            }
        } while (!xVar.e(objD, iArr));
    }

    @Override // n.i
    public boolean x(n.k kVar, MenuItem menuItem) {
        boolean zOnMenuItemSelected;
        o.n nVar = ((ActionMenuView) this.f7697v).V;
        if (nVar != null) {
            Toolbar toolbar = (Toolbar) ((a) nVar).f7697v;
            Iterator it = ((CopyOnWriteArrayList) toolbar.f606e0.f7867x).iterator();
            while (true) {
                if (!it.hasNext()) {
                    m3 m3Var = toolbar.f608g0;
                    zOnMenuItemSelected = m3Var != null ? ((h.h0) ((p6.c) m3Var).f10035w).f.onMenuItemSelected(0, menuItem) : false;
                } else if (((androidx.fragment.app.j0) it.next()).f1007a.p()) {
                    zOnMenuItemSelected = true;
                    break;
                }
            }
            if (zOnMenuItemSelected) {
                return true;
            }
        }
        return false;
    }

    @Override // n.i
    public void y(n.k kVar) {
        n.i iVar = ((ActionMenuView) this.f7697v).Q;
        if (iVar != null) {
            iVar.y(kVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r6v4, types: [fe.p, xd.h] */
    @Override // se.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object z(se.d r6, xd.c r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof se.a
            if (r0 == 0) goto L13
            r0 = r7
            se.a r0 = (se.a) r0
            int r1 = r0.B
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.B = r1
            goto L18
        L13:
            se.a r0 = new se.a
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f11673z
            int r1 = r0.B
            rd.l r2 = rd.l.f11003a
            r3 = 1
            if (r1 == 0) goto L33
            if (r1 != r3) goto L2b
            te.g r6 = r0.f11672y
            com.bumptech.glide.c.C(r7)     // Catch: java.lang.Throwable -> L29
            goto L56
        L29:
            r7 = move-exception
            goto L60
        L2b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L33:
            com.bumptech.glide.c.C(r7)
            te.g r7 = new te.g
            vd.h r1 = r0.f14484w
            ge.i.b(r1)
            r7.<init>(r6, r1)
            r0.f11672y = r7     // Catch: java.lang.Throwable -> L5e
            r0.B = r3     // Catch: java.lang.Throwable -> L5e
            java.lang.Object r6 = r5.f7697v     // Catch: java.lang.Throwable -> L5e
            xd.h r6 = (xd.h) r6     // Catch: java.lang.Throwable -> L5e
            java.lang.Object r6 = r6.j(r7, r0)     // Catch: java.lang.Throwable -> L5e
            wd.a r0 = wd.a.f14143v
            if (r6 != r0) goto L51
            goto L52
        L51:
            r6 = r2
        L52:
            if (r6 != r0) goto L55
            return r0
        L55:
            r6 = r7
        L56:
            r6.p()
            return r2
        L5a:
            r4 = r7
            r7 = r6
            r6 = r4
            goto L60
        L5e:
            r6 = move-exception
            goto L5a
        L60:
            r6.p()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: l4.a.z(se.d, xd.c):java.lang.Object");
    }

    public a(o8.e eVar) {
        Objects.requireNonNull(eVar);
        this.f7697v = eVar;
    }

    public a(View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            t0.v vVar = new t0.v(17, view);
            vVar.f11814x = view;
            this.f7697v = vVar;
            return;
        }
        this.f7697v = new kf.i(17, view);
    }

    public a(Context context) {
        boolean zIsEmpty;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.android.gms.appid", 0);
        this.f7697v = sharedPreferences;
        File file = new File(context.getNoBackupFilesDir(), "com.google.android.gms.appid-no-backup");
        if (file.exists()) {
            return;
        }
        try {
            if (file.createNewFile()) {
                synchronized (this) {
                    zIsEmpty = sharedPreferences.getAll().isEmpty();
                }
                if (zIsEmpty) {
                    return;
                }
                Log.i("FirebaseMessaging", "App restored, clearing state");
                r();
            }
        } catch (IOException e9) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Error creating file in no backup dir: " + e9.getMessage());
            }
        }
    }

    public a(Context context, GestureDetector.SimpleOnGestureListener simpleOnGestureListener) {
        this.f7697v = new GestureDetector(context, simpleOnGestureListener, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(fe.p pVar) {
        this.f7697v = (xd.h) pVar;
    }

    public a(int i, boolean z10) {
        switch (i) {
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                this.f7697v = new SparseArray();
                break;
            default:
                this.f7697v = new AudioAttributes.Builder();
                break;
        }
    }

    @Override // y2.d0
    public void a(r1 r1Var) {
    }

    @Override // w2.i
    public /* synthetic */ void B(w2.k kVar, long j4, long j7, int i) {
    }

    @Override // w2.i
    public void n(w2.k kVar, long j4, long j7, boolean z10) {
    }
}
