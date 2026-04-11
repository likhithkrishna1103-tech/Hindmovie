package n8;

import a2.y0;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.PowerManager;
import android.os.SystemClock;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.e;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import t7.v;
import x7.c;
import x7.d;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final long f8838n = TimeUnit.DAYS.toMillis(366);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static volatile ScheduledExecutorService f8839o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Object f8840p = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f8841a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PowerManager.WakeLock f8842b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f8843c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ScheduledFuture f8844d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f8845e;
    public final HashSet f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f8846g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public g8.a f8847h;
    public final x7.a i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f8848j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final HashMap f8849k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final AtomicInteger f8850l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ScheduledExecutorService f8851m;

    public a(Context context) {
        String packageName = context.getPackageName();
        this.f8841a = new Object();
        this.f8843c = 0;
        this.f = new HashSet();
        this.f8846g = true;
        this.i = x7.a.f14294a;
        this.f8849k = new HashMap();
        this.f8850l = new AtomicInteger(0);
        v.e("wake:com.google.firebase.iid.WakeLockHolder", "WakeLock: wakeLockName must not be empty");
        context.getApplicationContext();
        WorkSource workSource = null;
        this.f8847h = null;
        if ("com.google.android.gms".equals(context.getPackageName())) {
            this.f8848j = "wake:com.google.firebase.iid.WakeLockHolder";
        } else {
            this.f8848j = "wake:com.google.firebase.iid.WakeLockHolder".length() != 0 ? "*gcore*:".concat("wake:com.google.firebase.iid.WakeLockHolder") : new String("*gcore*:");
        }
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager == null) {
            StringBuilder sb2 = new StringBuilder(29);
            sb2.append((CharSequence) "expected a non-null reference", 0, 29);
            throw new y0(sb2.toString());
        }
        this.f8842b = powerManager.newWakeLock(1, "wake:com.google.firebase.iid.WakeLockHolder");
        if (d.a(context)) {
            int i = c.f14302a;
            packageName = (packageName == null || packageName.trim().isEmpty()) ? context.getPackageName() : packageName;
            if (context.getPackageManager() != null && packageName != null) {
                try {
                    ApplicationInfo applicationInfoB = z7.b.a(context).b(packageName, 0);
                    if (applicationInfoB == null) {
                        Log.e("WorkSourceUtil", "Could not get applicationInfo from package: ".concat(packageName));
                    } else {
                        int i10 = applicationInfoB.uid;
                        workSource = new WorkSource();
                        Method method = d.f14304b;
                        if (method != null) {
                            try {
                                method.invoke(workSource, Integer.valueOf(i10), packageName);
                            } catch (Exception e10) {
                                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e10);
                            }
                        } else {
                            Method method2 = d.f14303a;
                            if (method2 != null) {
                                try {
                                    method2.invoke(workSource, Integer.valueOf(i10));
                                } catch (Exception e11) {
                                    Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e11);
                                }
                            }
                        }
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                    Log.e("WorkSourceUtil", "Could not find package: ".concat(packageName));
                }
            }
            if (workSource != null) {
                try {
                    this.f8842b.setWorkSource(workSource);
                } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e12) {
                    Log.wtf("WakeLock", e12.toString());
                }
            }
        }
        ScheduledExecutorService scheduledExecutorServiceUnconfigurableScheduledExecutorService = f8839o;
        if (scheduledExecutorServiceUnconfigurableScheduledExecutorService == null) {
            synchronized (f8840p) {
                try {
                    scheduledExecutorServiceUnconfigurableScheduledExecutorService = f8839o;
                    if (scheduledExecutorServiceUnconfigurableScheduledExecutorService == null) {
                        scheduledExecutorServiceUnconfigurableScheduledExecutorService = Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1));
                        f8839o = scheduledExecutorServiceUnconfigurableScheduledExecutorService;
                    }
                } finally {
                }
            }
        }
        this.f8851m = scheduledExecutorServiceUnconfigurableScheduledExecutorService;
    }

    public final void a(long j5) {
        this.f8850l.incrementAndGet();
        long jMax = Math.max(Math.min(Long.MAX_VALUE, f8838n), 1L);
        if (j5 > 0) {
            jMax = Math.min(j5, jMax);
        }
        synchronized (this.f8841a) {
            try {
                if (!b()) {
                    this.f8847h = g8.a.f5330u;
                    this.f8842b.acquire();
                    this.i.getClass();
                    SystemClock.elapsedRealtime();
                }
                this.f8843c++;
                if (this.f8846g) {
                    TextUtils.isEmpty(null);
                }
                b bVar = (b) this.f8849k.get(null);
                if (bVar == null) {
                    bVar = new b();
                    this.f8849k.put(null, bVar);
                }
                bVar.f8852a++;
                this.i.getClass();
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                long j8 = Long.MAX_VALUE - jElapsedRealtime > jMax ? jElapsedRealtime + jMax : Long.MAX_VALUE;
                if (j8 > this.f8845e) {
                    this.f8845e = j8;
                    ScheduledFuture scheduledFuture = this.f8844d;
                    if (scheduledFuture != null) {
                        scheduledFuture.cancel(false);
                    }
                    this.f8844d = this.f8851m.schedule(new e(15, this), jMax, TimeUnit.MILLISECONDS);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean b() {
        boolean z2;
        synchronized (this.f8841a) {
            z2 = this.f8843c > 0;
        }
        return z2;
    }

    public final void c() {
        if (this.f8850l.decrementAndGet() < 0) {
            Log.e("WakeLock", String.valueOf(this.f8848j).concat(" release without a matched acquire!"));
        }
        synchronized (this.f8841a) {
            try {
                if (this.f8846g) {
                    TextUtils.isEmpty(null);
                }
                if (this.f8849k.containsKey(null)) {
                    b bVar = (b) this.f8849k.get(null);
                    if (bVar != null) {
                        int i = bVar.f8852a - 1;
                        bVar.f8852a = i;
                        if (i == 0) {
                            this.f8849k.remove(null);
                        }
                    }
                } else {
                    Log.w("WakeLock", String.valueOf(this.f8848j).concat(" counter does not exist"));
                }
                e();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void d() {
        HashSet hashSet = this.f;
        if (hashSet.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(hashSet);
        hashSet.clear();
        if (arrayList.size() <= 0) {
            return;
        }
        arrayList.get(0).getClass();
        throw new ClassCastException();
    }

    public final void e() {
        synchronized (this.f8841a) {
            try {
                if (b()) {
                    if (this.f8846g) {
                        int i = this.f8843c - 1;
                        this.f8843c = i;
                        if (i > 0) {
                            return;
                        }
                    } else {
                        this.f8843c = 0;
                    }
                    d();
                    Iterator it = this.f8849k.values().iterator();
                    while (it.hasNext()) {
                        ((b) it.next()).f8852a = 0;
                    }
                    this.f8849k.clear();
                    ScheduledFuture scheduledFuture = this.f8844d;
                    if (scheduledFuture != null) {
                        scheduledFuture.cancel(false);
                        this.f8844d = null;
                        this.f8845e = 0L;
                    }
                    if (this.f8842b.isHeld()) {
                        try {
                            try {
                                this.f8842b.release();
                                if (this.f8847h != null) {
                                    this.f8847h = null;
                                }
                            } catch (RuntimeException e10) {
                                if (!e10.getClass().equals(RuntimeException.class)) {
                                    throw e10;
                                }
                                Log.e("WakeLock", String.valueOf(this.f8848j).concat(" failed to release!"), e10);
                                if (this.f8847h != null) {
                                    this.f8847h = null;
                                }
                            }
                        } catch (Throwable th) {
                            if (this.f8847h != null) {
                                this.f8847h = null;
                            }
                            throw th;
                        }
                    } else {
                        Log.e("WakeLock", String.valueOf(this.f8848j).concat(" should be held!"));
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
