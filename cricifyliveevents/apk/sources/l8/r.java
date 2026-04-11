package l8;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import qb.t1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f7910a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m f7911b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile o8.t f7912c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Object f7913d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Context f7914e;

    static {
        new m(0, n.N("0\u0082\u0005È0\u0082\u0003° \u0003\u0002\u0001\u0002\u0002\u0014\u007f¢fú§p\u0085xb±"));
        new m(1, n.N("0\u0082\u0006\u00040\u0082\u0003ì \u0003\u0002\u0001\u0002\u0002\u0014QÕÛ\u0004÷XçB\u0086<"));
        new m(2, n.N("0\u0082\u0005È0\u0082\u0003° \u0003\u0002\u0001\u0002\u0002\u0014\u0010\u008ae\bsù/\u008eQí"));
        new m(3, n.N("0\u0082\u0006\u00040\u0082\u0003ì \u0003\u0002\u0001\u0002\u0002\u0014\u0003£²\u00ad×árÊkì"));
        f7910a = new m(4, n.N("0\u0082\u0004C0\u0082\u0003+ \u0003\u0002\u0001\u0002\u0002\t\u0000Âà\u0087FdJ0\u008d0"));
        f7911b = new m(5, n.N("0\u0082\u0004¨0\u0082\u0003\u0090 \u0003\u0002\u0001\u0002\u0002\t\u0000Õ\u0085¸l}ÓNõ0"));
        f7913d = new Object();
    }

    public static synchronized void a(Context context) {
        if (f7914e != null) {
            Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
        } else if (context != null) {
            f7914e = context.getApplicationContext();
        }
    }

    public static void b() {
        o8.t rVar;
        if (f7912c != null) {
            return;
        }
        o8.u.g(f7914e);
        synchronized (f7913d) {
            try {
                if (f7912c == null) {
                    IBinder iBinderB = w8.d.c(f7914e, w8.d.f14114d, "com.google.android.gms.googlecertificates").b("com.google.android.gms.common.GoogleCertificatesImpl");
                    int i = o8.s.f9694e;
                    if (iBinderB == null) {
                        rVar = null;
                    } else {
                        IInterface iInterfaceQueryLocalInterface = iBinderB.queryLocalInterface("com.google.android.gms.common.internal.IGoogleCertificatesApi");
                        rVar = iInterfaceQueryLocalInterface instanceof o8.t ? (o8.t) iInterfaceQueryLocalInterface : new o8.r(iBinderB, "com.google.android.gms.common.internal.IGoogleCertificatesApi", 0);
                    }
                    f7912c = rVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static u c(String str, o oVar, boolean z10, boolean z11) {
        try {
            b();
            o8.u.g(f7914e);
            try {
                o8.t tVar = f7912c;
                v8.b bVar = new v8.b(f7914e.getPackageManager());
                o8.r rVar = (o8.r) tVar;
                Parcel parcelF = rVar.f();
                int i = a9.j.f373a;
                boolean z12 = true;
                parcelF.writeInt(1);
                int iW = t1.w(parcelF, 20293);
                t1.r(parcelF, 1, str);
                t1.p(parcelF, 2, oVar);
                t1.v(parcelF, 3, 4);
                parcelF.writeInt(z10 ? 1 : 0);
                t1.v(parcelF, 4, 4);
                parcelF.writeInt(z11 ? 1 : 0);
                t1.y(parcelF, iW);
                a9.j.b(parcelF, bVar);
                Parcel parcelB = rVar.b(parcelF, 5);
                if (parcelB.readInt() == 0) {
                    z12 = false;
                }
                parcelB.recycle();
                return z12 ? u.f7921d : new t(new p(z10, str, oVar));
            } catch (RemoteException e9) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e9);
                return u.c("module call", e9);
            }
        } catch (w8.a e10) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e10);
            return u.c("module init: ".concat(String.valueOf(e10.getMessage())), e10);
        }
    }
}
