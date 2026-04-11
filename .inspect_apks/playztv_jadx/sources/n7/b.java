package n7;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import c2.o;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import q7.f;
import t7.v;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public q7.a f8826a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c8.d f8827b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f8828c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f8829d = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public d f8830e;
    public final Context f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f8831g;

    public b(Context context) {
        v.h(context);
        Context applicationContext = context.getApplicationContext();
        this.f = applicationContext != null ? applicationContext : context;
        this.f8828c = false;
        this.f8831g = -1L;
    }

    public static a a(Context context) {
        b bVar = new b(context);
        try {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            bVar.c();
            a aVarE = bVar.e();
            d(aVarE, SystemClock.elapsedRealtime() - jElapsedRealtime, null);
            return aVarE;
        } finally {
        }
    }

    public static void d(a aVar, long j5, Throwable th) {
        if (Math.random() <= 0.0d) {
            HashMap map = new HashMap();
            map.put("app_context", "1");
            if (aVar != null) {
                map.put("limit_ad_tracking", true != aVar.f8824b ? "0" : "1");
                String str = aVar.f8825c;
                if (str != null) {
                    map.put("ad_id_size", Integer.toString(str.length()));
                }
            }
            if (th != null) {
                map.put("error", th.getClass().getName());
            }
            map.put("tag", "AdvertisingIdClient");
            map.put("time_spent", Long.toString(j5));
            new c(map).start();
        }
    }

    public final void b() {
        v.g("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            try {
                if (this.f == null || this.f8826a == null) {
                    return;
                }
                try {
                    if (this.f8828c) {
                        w7.a.b().c(this.f, this.f8826a);
                    }
                } catch (Throwable th) {
                    Log.i("AdvertisingIdClient", "AdvertisingIdClient unbindService failed.", th);
                }
                this.f8828c = false;
                this.f8827b = null;
                this.f8826a = null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void c() {
        v.g("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            try {
                if (this.f8828c) {
                    b();
                }
                Context context = this.f;
                try {
                    context.getPackageManager().getPackageInfo("com.android.vending", 0);
                    int iB = f.f11040b.b(context, 12451000);
                    if (iB != 0 && iB != 2) {
                        throw new IOException("Google Play services not available");
                    }
                    q7.a aVar = new q7.a();
                    Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                    intent.setPackage("com.google.android.gms");
                    try {
                        if (!w7.a.b().a(context, intent, aVar, 1)) {
                            throw new IOException("Connection failure");
                        }
                        this.f8826a = aVar;
                        try {
                            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                            IBinder iBinderA = aVar.a();
                            int i = c8.c.f2588d;
                            IInterface iInterfaceQueryLocalInterface = iBinderA.queryLocalInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                            this.f8827b = iInterfaceQueryLocalInterface instanceof c8.d ? (c8.d) iInterfaceQueryLocalInterface : new c8.b(iBinderA);
                            this.f8828c = true;
                        } catch (InterruptedException unused) {
                            throw new IOException("Interrupted exception");
                        } catch (Throwable th) {
                            throw new IOException(th);
                        }
                    } finally {
                        IOException iOException = new IOException(th);
                    }
                } catch (PackageManager.NameNotFoundException unused2) {
                    throw new o();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final a e() {
        a aVar;
        v.g("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            try {
                if (!this.f8828c) {
                    synchronized (this.f8829d) {
                        d dVar = this.f8830e;
                        if (dVar == null || !dVar.f8837x) {
                            throw new IOException("AdvertisingIdClient is not connected.");
                        }
                    }
                    try {
                        c();
                        if (!this.f8828c) {
                            throw new IOException("AdvertisingIdClient cannot reconnect.");
                        }
                    } catch (Exception e10) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.", e10);
                    }
                }
                v.h(this.f8826a);
                v.h(this.f8827b);
                try {
                    c8.b bVar = (c8.b) this.f8827b;
                    bVar.getClass();
                    Parcel parcelObtain = Parcel.obtain();
                    parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    boolean z2 = true;
                    Parcel parcelC = bVar.c(parcelObtain, 1);
                    String string = parcelC.readString();
                    parcelC.recycle();
                    c8.b bVar2 = (c8.b) this.f8827b;
                    bVar2.getClass();
                    Parcel parcelObtain2 = Parcel.obtain();
                    parcelObtain2.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    int i = c8.a.f2586a;
                    parcelObtain2.writeInt(1);
                    Parcel parcelC2 = bVar2.c(parcelObtain2, 2);
                    if (parcelC2.readInt() == 0) {
                        z2 = false;
                    }
                    parcelC2.recycle();
                    aVar = new a(string, z2, 0);
                } catch (RemoteException e11) {
                    Log.i("AdvertisingIdClient", "GMS remote exception ", e11);
                    throw new IOException("Remote exception");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        f();
        return aVar;
    }

    public final void f() {
        synchronized (this.f8829d) {
            d dVar = this.f8830e;
            if (dVar != null) {
                dVar.f8836w.countDown();
                try {
                    this.f8830e.join();
                } catch (InterruptedException unused) {
                }
            }
            long j5 = this.f8831g;
            if (j5 > 0) {
                this.f8830e = new d(this, j5);
            }
        }
    }

    public final void finalize() throws Throwable {
        b();
        super.finalize();
    }
}
