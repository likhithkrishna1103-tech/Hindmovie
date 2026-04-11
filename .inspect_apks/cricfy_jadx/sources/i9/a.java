package i9;

import a9.l;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.PowerManager;
import android.os.SystemClock;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.m;
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
import o8.u;
import s8.c;
import s8.d;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final long f6363n = TimeUnit.DAYS.toMillis(366);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static volatile ScheduledExecutorService f6364o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Object f6365p = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f6366a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PowerManager.WakeLock f6367b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f6368c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ScheduledFuture f6369d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f6370e;
    public final HashSet f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f6371g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public b9.a f6372h;
    public final s8.a i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f6373j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final HashMap f6374k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final AtomicInteger f6375l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ScheduledExecutorService f6376m;

    public a(Context context) {
        String packageName = context.getPackageName();
        this.f6366a = new Object();
        this.f6368c = 0;
        this.f = new HashSet();
        this.f6371g = true;
        this.i = s8.a.f11610a;
        this.f6374k = new HashMap();
        this.f6375l = new AtomicInteger(0);
        u.e("wake:com.google.firebase.iid.WakeLockHolder", "WakeLock: wakeLockName must not be empty");
        context.getApplicationContext();
        WorkSource workSource = null;
        this.f6372h = null;
        if ("com.google.android.gms".equals(context.getPackageName())) {
            this.f6373j = "wake:com.google.firebase.iid.WakeLockHolder";
        } else {
            this.f6373j = "wake:com.google.firebase.iid.WakeLockHolder".length() != 0 ? "*gcore*:".concat("wake:com.google.firebase.iid.WakeLockHolder") : new String("*gcore*:");
        }
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager == null) {
            StringBuilder sb = new StringBuilder(29);
            sb.append((CharSequence) "expected a non-null reference", 0, 29);
            throw new l(sb.toString());
        }
        this.f6367b = powerManager.newWakeLock(1, "wake:com.google.firebase.iid.WakeLockHolder");
        if (d.a(context)) {
            int i = c.f11618a;
            packageName = (packageName == null || packageName.trim().isEmpty()) ? context.getPackageName() : packageName;
            if (context.getPackageManager() != null && packageName != null) {
                try {
                    ApplicationInfo applicationInfoA = u8.b.a(context).a(0, packageName);
                    if (applicationInfoA == null) {
                        Log.e("WorkSourceUtil", "Could not get applicationInfo from package: ".concat(packageName));
                    } else {
                        int i10 = applicationInfoA.uid;
                        workSource = new WorkSource();
                        Method method = d.f11620b;
                        if (method != null) {
                            try {
                                method.invoke(workSource, Integer.valueOf(i10), packageName);
                            } catch (Exception e9) {
                                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e9);
                            }
                        } else {
                            Method method2 = d.f11619a;
                            if (method2 != null) {
                                try {
                                    method2.invoke(workSource, Integer.valueOf(i10));
                                } catch (Exception e10) {
                                    Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e10);
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
                    this.f6367b.setWorkSource(workSource);
                } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e11) {
                    Log.wtf("WakeLock", e11.toString());
                }
            }
        }
        ScheduledExecutorService scheduledExecutorServiceUnconfigurableScheduledExecutorService = f6364o;
        if (scheduledExecutorServiceUnconfigurableScheduledExecutorService == null) {
            synchronized (f6365p) {
                try {
                    scheduledExecutorServiceUnconfigurableScheduledExecutorService = f6364o;
                    if (scheduledExecutorServiceUnconfigurableScheduledExecutorService == null) {
                        scheduledExecutorServiceUnconfigurableScheduledExecutorService = Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1));
                        f6364o = scheduledExecutorServiceUnconfigurableScheduledExecutorService;
                    }
                } finally {
                }
            }
        }
        this.f6376m = scheduledExecutorServiceUnconfigurableScheduledExecutorService;
    }

    public final void a(long j4) {
        this.f6375l.incrementAndGet();
        long jMax = Math.max(Math.min(Long.MAX_VALUE, f6363n), 1L);
        if (j4 > 0) {
            jMax = Math.min(j4, jMax);
        }
        synchronized (this.f6366a) {
            try {
                if (!b()) {
                    this.f6372h = b9.a.f1839v;
                    this.f6367b.acquire();
                    this.i.getClass();
                    SystemClock.elapsedRealtime();
                }
                this.f6368c++;
                if (this.f6371g) {
                    TextUtils.isEmpty(null);
                }
                b bVar = (b) this.f6374k.get(null);
                if (bVar == null) {
                    bVar = new b();
                    this.f6374k.put(null, bVar);
                }
                bVar.f6377a++;
                this.i.getClass();
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                long j7 = Long.MAX_VALUE - jElapsedRealtime > jMax ? jElapsedRealtime + jMax : Long.MAX_VALUE;
                if (j7 > this.f6370e) {
                    this.f6370e = j7;
                    ScheduledFuture scheduledFuture = this.f6369d;
                    if (scheduledFuture != null) {
                        scheduledFuture.cancel(false);
                    }
                    this.f6369d = this.f6376m.schedule(new m(13, this), jMax, TimeUnit.MILLISECONDS);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean b() {
        boolean z10;
        synchronized (this.f6366a) {
            z10 = this.f6368c > 0;
        }
        return z10;
    }

    public final void c() {
        if (this.f6375l.decrementAndGet() < 0) {
            Log.e("WakeLock", String.valueOf(this.f6373j).concat(" release without a matched acquire!"));
        }
        synchronized (this.f6366a) {
            try {
                if (this.f6371g) {
                    TextUtils.isEmpty(null);
                }
                if (this.f6374k.containsKey(null)) {
                    b bVar = (b) this.f6374k.get(null);
                    if (bVar != null) {
                        int i = bVar.f6377a - 1;
                        bVar.f6377a = i;
                        if (i == 0) {
                            this.f6374k.remove(null);
                        }
                    }
                } else {
                    Log.w("WakeLock", String.valueOf(this.f6373j).concat(" counter does not exist"));
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
        if (arrayList.size() > 0) {
            throw q4.a.k(0, arrayList);
        }
    }

    public final void e() {
        synchronized (this.f6366a) {
            try {
                if (b()) {
                    if (this.f6371g) {
                        int i = this.f6368c - 1;
                        this.f6368c = i;
                        if (i > 0) {
                            return;
                        }
                    } else {
                        this.f6368c = 0;
                    }
                    d();
                    Iterator it = this.f6374k.values().iterator();
                    while (it.hasNext()) {
                        ((b) it.next()).f6377a = 0;
                    }
                    this.f6374k.clear();
                    ScheduledFuture scheduledFuture = this.f6369d;
                    if (scheduledFuture != null) {
                        scheduledFuture.cancel(false);
                        this.f6369d = null;
                        this.f6370e = 0L;
                    }
                    if (this.f6367b.isHeld()) {
                        try {
                            try {
                                this.f6367b.release();
                                if (this.f6372h != null) {
                                    this.f6372h = null;
                                }
                            } catch (RuntimeException e9) {
                                if (!e9.getClass().equals(RuntimeException.class)) {
                                    throw e9;
                                }
                                Log.e("WakeLock", String.valueOf(this.f6373j).concat(" failed to release!"), e9);
                                if (this.f6372h != null) {
                                    this.f6372h = null;
                                }
                            }
                        } catch (Throwable th) {
                            if (this.f6372h != null) {
                                this.f6372h = null;
                            }
                            throw th;
                        }
                    } else {
                        Log.e("WakeLock", String.valueOf(this.f6373j).concat(" should be held!"));
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
