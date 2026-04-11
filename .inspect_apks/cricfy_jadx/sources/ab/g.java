package ab;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Trace;
import android.util.Base64;
import android.util.Log;
import com.google.firebase.FirebaseCommonRegistrar;
import com.google.firebase.components.ComponentDiscoveryService;
import com.google.firebase.concurrent.ExecutorsRegistrar;
import com.google.firebase.provider.FirebaseInitProvider;
import hb.n;
import ib.k;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import nb.w;
import o8.u;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Object f388k = new Object();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final v.e f389l = new v.e(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f391b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j f392c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final hb.g f393d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final n f395g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final hc.b f396h;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f394e = new AtomicBoolean(false);
    public final AtomicBoolean f = new AtomicBoolean();
    public final CopyOnWriteArrayList i = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final CopyOnWriteArrayList f397j = new CopyOnWriteArrayList();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    public g(Context context, String str, j jVar) {
        ?? arrayList;
        int i = 0;
        this.f390a = context;
        u.d(str);
        this.f391b = str;
        this.f392c = jVar;
        a aVar = FirebaseInitProvider.f3046v;
        Trace.beginSection("Firebase");
        Trace.beginSection("ComponentDiscovery");
        ArrayList arrayList2 = new ArrayList();
        Bundle bundle = null;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                Log.w("ComponentDiscovery", "Context has no PackageManager.");
            } else {
                ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, (Class<?>) ComponentDiscoveryService.class), 128);
                if (serviceInfo == null) {
                    Log.w("ComponentDiscovery", ComponentDiscoveryService.class + " has no service info.");
                } else {
                    bundle = serviceInfo.metaData;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
            Log.w("ComponentDiscovery", "Application info not found.");
        }
        if (bundle == null) {
            Log.w("ComponentDiscovery", "Could not retrieve metadata, returning empty list of registrars.");
            arrayList = Collections.EMPTY_LIST;
        } else {
            arrayList = new ArrayList();
            for (String str2 : bundle.keySet()) {
                if ("com.google.firebase.components.ComponentRegistrar".equals(bundle.get(str2)) && str2.startsWith("com.google.firebase.components:")) {
                    arrayList.add(str2.substring(31));
                }
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new hb.d(i, (String) it.next()));
        }
        Trace.endSection();
        Trace.beginSection("Runtime");
        k kVar = k.f6411v;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        arrayList3.addAll(arrayList2);
        arrayList3.add(new hb.d(1 == true ? 1 : 0, new FirebaseCommonRegistrar()));
        arrayList3.add(new hb.d(1 == true ? 1 : 0, new ExecutorsRegistrar()));
        arrayList4.add(hb.b.c(context, Context.class, new Class[0]));
        arrayList4.add(hb.b.c(this, g.class, new Class[0]));
        arrayList4.add(hb.b.c(jVar, j.class, new Class[0]));
        x3.b bVar = new x3.b();
        if ((Build.VERSION.SDK_INT >= 24 ? p0.d.f(context) : true) && FirebaseInitProvider.f3047w.get()) {
            arrayList4.add(hb.b.c(aVar, a.class, new Class[0]));
        }
        hb.g gVar = new hb.g(arrayList3, arrayList4, bVar);
        this.f393d = gVar;
        Trace.endSection();
        this.f395g = new n(new c(i, this, context));
        this.f396h = gVar.g(fc.d.class);
        d dVar = new d(this);
        a();
        if (this.f394e.get()) {
            n8.c.f8862z.f8863v.get();
        }
        this.i.add(dVar);
        Trace.endSection();
    }

    public static g c() {
        g gVar;
        synchronized (f388k) {
            try {
                gVar = (g) f389l.get("[DEFAULT]");
                if (gVar == null) {
                    throw new IllegalStateException("Default FirebaseApp is not initialized in this process " + s8.b.b() + ". Make sure to call FirebaseApp.initializeApp(Context) first.");
                }
                ((fc.d) gVar.f396h.get()).c();
            } catch (Throwable th) {
                throw th;
            }
        }
        return gVar;
    }

    public static g f(Context context) {
        synchronized (f388k) {
            try {
                if (f389l.containsKey("[DEFAULT]")) {
                    return c();
                }
                j jVarA = j.a(context);
                if (jVarA == null) {
                    Log.w("FirebaseApp", "Default FirebaseApp failed to initialize because no default options were found. This usually means that com.google.gms:google-services was not applied to your gradle project.");
                    return null;
                }
                return g(context, jVarA);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static g g(Context context, j jVar) {
        g gVar;
        AtomicReference atomicReference = e.f385a;
        if (context.getApplicationContext() instanceof Application) {
            Application application = (Application) context.getApplicationContext();
            AtomicReference atomicReference2 = e.f385a;
            if (atomicReference2.get() == null) {
                e eVar = new e();
                while (true) {
                    if (atomicReference2.compareAndSet(null, eVar)) {
                        n8.c.b(application);
                        n8.c.f8862z.a(eVar);
                        break;
                    }
                    if (atomicReference2.get() != null) {
                        break;
                    }
                }
            }
        }
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        synchronized (f388k) {
            v.e eVar2 = f389l;
            u.i("FirebaseApp name [DEFAULT] already exists!", !eVar2.containsKey("[DEFAULT]"));
            u.h(context, "Application context cannot be null.");
            gVar = new g(context, "[DEFAULT]", jVar);
            eVar2.put("[DEFAULT]", gVar);
        }
        gVar.e();
        return gVar;
    }

    public final void a() {
        u.i("FirebaseApp was deleted", !this.f.get());
    }

    public final Object b(Class cls) {
        a();
        return this.f393d.b(cls);
    }

    public final String d() {
        StringBuilder sb = new StringBuilder();
        a();
        byte[] bytes = this.f391b.getBytes(Charset.defaultCharset());
        sb.append(bytes == null ? null : Base64.encodeToString(bytes, 11));
        sb.append("+");
        a();
        byte[] bytes2 = this.f392c.f404b.getBytes(Charset.defaultCharset());
        sb.append(bytes2 != null ? Base64.encodeToString(bytes2, 11) : null);
        return sb.toString();
    }

    public final void e() {
        HashMap map;
        if (!(Build.VERSION.SDK_INT >= 24 ? p0.d.f(this.f390a) : true)) {
            StringBuilder sb = new StringBuilder("Device in Direct Boot Mode: postponing initialization of Firebase APIs for app ");
            a();
            sb.append(this.f391b);
            Log.i("FirebaseApp", sb.toString());
            Context context = this.f390a;
            AtomicReference atomicReference = f.f386b;
            if (atomicReference.get() == null) {
                f fVar = new f(context);
                while (!atomicReference.compareAndSet(null, fVar)) {
                    if (atomicReference.get() != null) {
                        return;
                    }
                }
                context.registerReceiver(fVar, new IntentFilter("android.intent.action.USER_UNLOCKED"));
                return;
            }
            return;
        }
        StringBuilder sb2 = new StringBuilder("Device unlocked: initializing all Firebase APIs for app ");
        a();
        sb2.append(this.f391b);
        Log.i("FirebaseApp", sb2.toString());
        hb.g gVar = this.f393d;
        a();
        boolean zEquals = "[DEFAULT]".equals(this.f391b);
        AtomicReference atomicReference2 = gVar.A;
        Boolean boolValueOf = Boolean.valueOf(zEquals);
        while (true) {
            if (atomicReference2.compareAndSet(null, boolValueOf)) {
                synchronized (gVar) {
                    map = new HashMap(gVar.f5885v);
                }
                gVar.a(map, zEquals);
                break;
            } else if (atomicReference2.get() != null) {
                break;
            }
        }
        ((fc.d) this.f396h.get()).c();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        gVar.a();
        return this.f391b.equals(gVar.f391b);
    }

    public final boolean h() {
        boolean z10;
        a();
        mc.a aVar = (mc.a) this.f395g.get();
        synchronized (aVar) {
            z10 = aVar.f8418a;
        }
        return z10;
    }

    public final int hashCode() {
        return this.f391b.hashCode();
    }

    public final String toString() {
        w wVar = new w(this);
        wVar.v(this.f391b, "name");
        wVar.v(this.f392c, "options");
        return wVar.toString();
    }
}
