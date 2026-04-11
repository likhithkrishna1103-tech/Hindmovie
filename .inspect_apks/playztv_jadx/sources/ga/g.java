package ga;

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
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import na.n;
import t7.v;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Object f5344k = new Object();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final s.e f5345l = new s.e(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f5346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5347b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j f5348c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final na.g f5349d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final n f5351g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final nb.b f5352h;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f5350e = new AtomicBoolean(false);
    public final AtomicBoolean f = new AtomicBoolean();
    public final CopyOnWriteArrayList i = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final CopyOnWriteArrayList f5353j = new CopyOnWriteArrayList();

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
        this.f5346a = context;
        v.d(str);
        this.f5347b = str;
        this.f5348c = jVar;
        a aVar = FirebaseInitProvider.f3584u;
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
            arrayList2.add(new na.d(i, (String) it.next()));
        }
        Trace.endSection();
        Trace.beginSection("Runtime");
        oa.j jVar2 = oa.j.f9477u;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        arrayList3.addAll(arrayList2);
        arrayList3.add(new na.d(1 == true ? 1 : 0, new FirebaseCommonRegistrar()));
        arrayList3.add(new na.d(1 == true ? 1 : 0, new ExecutorsRegistrar()));
        arrayList4.add(na.b.c(context, Context.class, new Class[0]));
        arrayList4.add(na.b.c(this, g.class, new Class[0]));
        arrayList4.add(na.b.c(jVar, j.class, new Class[0]));
        pa.b bVar = new pa.b(11);
        if ((Build.VERSION.SDK_INT >= 24 ? m0.d.e(context) : true) && FirebaseInitProvider.f3585v.get()) {
            arrayList4.add(na.b.c(aVar, a.class, new Class[0]));
        }
        na.g gVar = new na.g(arrayList3, arrayList4, bVar);
        this.f5349d = gVar;
        Trace.endSection();
        this.f5351g = new n(new c(this, i, context));
        this.f5352h = gVar.e(lb.d.class);
        d dVar = new d(this);
        a();
        if (this.f5350e.get()) {
            s7.c.f11878y.f11879u.get();
        }
        this.i.add(dVar);
        Trace.endSection();
    }

    public static g c() {
        g gVar;
        synchronized (f5344k) {
            try {
                gVar = (g) f5345l.get("[DEFAULT]");
                if (gVar == null) {
                    throw new IllegalStateException("Default FirebaseApp is not initialized in this process " + x7.b.b() + ". Make sure to call FirebaseApp.initializeApp(Context) first.");
                }
                ((lb.d) gVar.f5352h.get()).c();
            } catch (Throwable th) {
                throw th;
            }
        }
        return gVar;
    }

    public static g f(Context context) {
        synchronized (f5344k) {
            try {
                if (f5345l.containsKey("[DEFAULT]")) {
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
        AtomicReference atomicReference = e.f5341a;
        if (context.getApplicationContext() instanceof Application) {
            Application application = (Application) context.getApplicationContext();
            AtomicReference atomicReference2 = e.f5341a;
            if (atomicReference2.get() == null) {
                e eVar = new e();
                while (true) {
                    if (atomicReference2.compareAndSet(null, eVar)) {
                        s7.c.b(application);
                        s7.c.f11878y.a(eVar);
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
        synchronized (f5344k) {
            s.e eVar2 = f5345l;
            v.j("FirebaseApp name [DEFAULT] already exists!", !eVar2.containsKey("[DEFAULT]"));
            v.i(context, "Application context cannot be null.");
            gVar = new g(context, "[DEFAULT]", jVar);
            eVar2.put("[DEFAULT]", gVar);
        }
        gVar.e();
        return gVar;
    }

    public final void a() {
        v.j("FirebaseApp was deleted", !this.f.get());
    }

    public final Object b(Class cls) {
        a();
        return this.f5349d.b(cls);
    }

    public final String d() {
        StringBuilder sb2 = new StringBuilder();
        a();
        byte[] bytes = this.f5347b.getBytes(Charset.defaultCharset());
        sb2.append(bytes == null ? null : Base64.encodeToString(bytes, 11));
        sb2.append("+");
        a();
        byte[] bytes2 = this.f5348c.f5360b.getBytes(Charset.defaultCharset());
        sb2.append(bytes2 != null ? Base64.encodeToString(bytes2, 11) : null);
        return sb2.toString();
    }

    public final void e() {
        HashMap map;
        if (!(Build.VERSION.SDK_INT >= 24 ? m0.d.e(this.f5346a) : true)) {
            StringBuilder sb2 = new StringBuilder("Device in Direct Boot Mode: postponing initialization of Firebase APIs for app ");
            a();
            sb2.append(this.f5347b);
            Log.i("FirebaseApp", sb2.toString());
            Context context = this.f5346a;
            AtomicReference atomicReference = f.f5342b;
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
        StringBuilder sb3 = new StringBuilder("Device unlocked: initializing all Firebase APIs for app ");
        a();
        sb3.append(this.f5347b);
        Log.i("FirebaseApp", sb3.toString());
        na.g gVar = this.f5349d;
        a();
        boolean zEquals = "[DEFAULT]".equals(this.f5347b);
        AtomicReference atomicReference2 = gVar.f8893z;
        Boolean boolValueOf = Boolean.valueOf(zEquals);
        while (true) {
            if (atomicReference2.compareAndSet(null, boolValueOf)) {
                synchronized (gVar) {
                    map = new HashMap(gVar.f8888u);
                }
                gVar.a(map, zEquals);
                break;
            } else if (atomicReference2.get() != null) {
                break;
            }
        }
        ((lb.d) this.f5352h.get()).c();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        gVar.a();
        return this.f5347b.equals(gVar.f5347b);
    }

    public final boolean h() {
        boolean z2;
        a();
        sb.a aVar = (sb.a) this.f5351g.get();
        synchronized (aVar) {
            z2 = aVar.f11940a;
        }
        return z2;
    }

    public final int hashCode() {
        return this.f5347b.hashCode();
    }

    public final String toString() {
        p2.c cVar = new p2.c(this);
        cVar.b(this.f5347b, "name");
        cVar.b(this.f5348c, "options");
        return cVar.toString();
    }
}
