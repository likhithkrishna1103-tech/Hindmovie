package q7;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import t7.u;
import t7.v;
import wa.t1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f11058a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m f11059b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile u f11060c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Object f11061d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Context f11062e;

    static {
        new m(0, n.H("0\u0082\u0005È0\u0082\u0003° \u0003\u0002\u0001\u0002\u0002\u0014\u0010\u008ae\bsù/\u008eQí"));
        new m(1, n.H("0\u0082\u0006\u00040\u0082\u0003ì \u0003\u0002\u0001\u0002\u0002\u0014\u0003£²\u00ad×árÊkì"));
        f11058a = new m(2, n.H("0\u0082\u0004C0\u0082\u0003+ \u0003\u0002\u0001\u0002\u0002\t\u0000Âà\u0087FdJ0\u008d0"));
        f11059b = new m(3, n.H("0\u0082\u0004¨0\u0082\u0003\u0090 \u0003\u0002\u0001\u0002\u0002\t\u0000Õ\u0085¸l}ÓNõ0"));
        f11061d = new Object();
    }

    public static synchronized void a(Context context) {
        if (f11062e != null) {
            Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
        } else if (context != null) {
            f11062e = context.getApplicationContext();
        }
    }

    public static t b(String str, o oVar, boolean z2, boolean z10) {
        try {
            c();
            v.h(f11062e);
            try {
                u uVar = f11060c;
                a8.b bVar = new a8.b(f11062e.getPackageManager());
                t7.s sVar = (t7.s) uVar;
                Parcel parcelF = sVar.f();
                int i = f8.a.f4810a;
                boolean z11 = true;
                parcelF.writeInt(1);
                int iE = t1.E(parcelF, 20293);
                t1.C(parcelF, 1, str);
                t1.A(parcelF, 2, oVar);
                t1.H(parcelF, 3, 4);
                parcelF.writeInt(z2 ? 1 : 0);
                t1.H(parcelF, 4, 4);
                parcelF.writeInt(z10 ? 1 : 0);
                t1.G(parcelF, iE);
                f8.a.c(parcelF, bVar);
                Parcel parcelE = sVar.e(parcelF, 5);
                if (parcelE.readInt() == 0) {
                    z11 = false;
                }
                parcelE.recycle();
                return z11 ? t.f11068d : new s(new l(z2, str, oVar));
            } catch (RemoteException e10) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e10);
                return new t(false, "module call", e10);
            }
        } catch (b8.b e11) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e11);
            return new t(false, "module init: ".concat(String.valueOf(e11.getMessage())), e11);
        }
    }

    public static void c() {
        u sVar;
        if (f11060c != null) {
            return;
        }
        v.h(f11062e);
        synchronized (f11061d) {
            try {
                if (f11060c == null) {
                    IBinder iBinderB = b8.f.c(f11062e, b8.f.f1926c, "com.google.android.gms.googlecertificates").b("com.google.android.gms.common.GoogleCertificatesImpl");
                    int i = t7.t.f12334e;
                    if (iBinderB == null) {
                        sVar = null;
                    } else {
                        IInterface iInterfaceQueryLocalInterface = iBinderB.queryLocalInterface("com.google.android.gms.common.internal.IGoogleCertificatesApi");
                        sVar = iInterfaceQueryLocalInterface instanceof u ? (u) iInterfaceQueryLocalInterface : new t7.s(iBinderB, "com.google.android.gms.common.internal.IGoogleCertificatesApi", 1);
                    }
                    f11060c = sVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
