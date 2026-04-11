package i8;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import e2.i;
import i2.q;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import l8.f;
import o8.u;
import x8.d;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public l8.a f6353a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d f6354b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f6355c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f6356d = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c f6357e;
    public final Context f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f6358g;

    public b(Context context) {
        u.g(context);
        Context applicationContext = context.getApplicationContext();
        this.f = applicationContext != null ? applicationContext : context;
        this.f6355c = false;
        this.f6358g = -1L;
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

    public static void d(a aVar, long j4, Throwable th) {
        if (Math.random() <= 0.0d) {
            HashMap map = new HashMap();
            map.put("app_context", "1");
            if (aVar != null) {
                map.put("limit_ad_tracking", true != aVar.f6352c ? "0" : "1");
                String str = aVar.f6351b;
                if (str != null) {
                    map.put("ad_id_size", Integer.toString(str.length()));
                }
            }
            if (th != null) {
                map.put("error", th.getClass().getName());
            }
            map.put("tag", "AdvertisingIdClient");
            map.put("time_spent", Long.toString(j4));
            new i(map).start();
        }
    }

    public final void b() {
        u.f("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            try {
                if (this.f == null || this.f6353a == null) {
                    return;
                }
                try {
                    if (this.f6355c) {
                        r8.a.b().c(this.f, this.f6353a);
                    }
                } catch (Throwable th) {
                    Log.i("AdvertisingIdClient", "AdvertisingIdClient unbindService failed.", th);
                }
                this.f6355c = false;
                this.f6354b = null;
                this.f6353a = null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void c() {
        u.f("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            try {
                if (this.f6355c) {
                    b();
                }
                Context context = this.f;
                try {
                    context.getPackageManager().getPackageInfo("com.android.vending", 0);
                    int iB = f.f7890b.b(context, 12451000);
                    if (iB != 0 && iB != 2) {
                        throw new IOException("Google Play services not available");
                    }
                    l8.a aVar = new l8.a();
                    Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                    intent.setPackage("com.google.android.gms");
                    try {
                        if (!r8.a.b().a(context, intent, aVar, 1)) {
                            throw new IOException("Connection failure");
                        }
                        this.f6353a = aVar;
                        try {
                            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                            IBinder iBinderA = aVar.a();
                            int i = x8.c.f14456d;
                            IInterface iInterfaceQueryLocalInterface = iBinderA.queryLocalInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                            this.f6354b = iInterfaceQueryLocalInterface instanceof d ? (d) iInterfaceQueryLocalInterface : new x8.b(iBinderA);
                            this.f6355c = true;
                        } catch (InterruptedException unused) {
                            throw new IOException("Interrupted exception");
                        } catch (Throwable th) {
                            throw new IOException(th);
                        }
                    } finally {
                        IOException iOException = new IOException(th);
                    }
                } catch (PackageManager.NameNotFoundException unused2) {
                    throw new q();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final a e() {
        a aVar;
        u.f("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            try {
                if (!this.f6355c) {
                    synchronized (this.f6356d) {
                        c cVar = this.f6357e;
                        if (cVar == null || !cVar.f6362y) {
                            throw new IOException("AdvertisingIdClient is not connected.");
                        }
                    }
                    try {
                        c();
                        if (!this.f6355c) {
                            throw new IOException("AdvertisingIdClient cannot reconnect.");
                        }
                    } catch (Exception e9) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.", e9);
                    }
                }
                u.g(this.f6353a);
                u.g(this.f6354b);
                try {
                    x8.b bVar = (x8.b) this.f6354b;
                    bVar.getClass();
                    Parcel parcelObtain = Parcel.obtain();
                    parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    boolean z10 = true;
                    Parcel parcelB = bVar.b(parcelObtain, 1);
                    String string = parcelB.readString();
                    parcelB.recycle();
                    x8.b bVar2 = (x8.b) this.f6354b;
                    bVar2.getClass();
                    Parcel parcelObtain2 = Parcel.obtain();
                    parcelObtain2.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    int i = x8.a.f14454a;
                    parcelObtain2.writeInt(1);
                    Parcel parcelB2 = bVar2.b(parcelObtain2, 2);
                    if (parcelB2.readInt() == 0) {
                        z10 = false;
                    }
                    parcelB2.recycle();
                    aVar = new a(string, z10, 0);
                } catch (RemoteException e10) {
                    Log.i("AdvertisingIdClient", "GMS remote exception ", e10);
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
        synchronized (this.f6356d) {
            c cVar = this.f6357e;
            if (cVar != null) {
                cVar.f6361x.countDown();
                try {
                    this.f6357e.join();
                } catch (InterruptedException unused) {
                }
            }
            long j4 = this.f6358g;
            if (j4 > 0) {
                this.f6357e = new c(this, j4);
            }
        }
    }

    public final void finalize() throws Throwable {
        b();
        super.finalize();
    }
}
