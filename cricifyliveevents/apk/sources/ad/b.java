package ad;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.os.Build;
import c2.o;
import f9.c0;
import java.io.File;
import java.util.ArrayList;
import l0.e;
import nb.w;
import o8.u;
import p2.c;
import p2.k;
import p2.l;
import s7.g;
import v1.m0;
import v1.p;
import w1.d;
import y1.a0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements g, k {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Context f415v;

    public /* synthetic */ b(Context context, boolean z10) {
        this.f415v = context;
    }

    public static boolean a(String str) {
        boolean z10 = false;
        for (String str2 : a.a()) {
            String strJ = e.j(str2, str);
            if (new File(str2, str).exists()) {
                d.v(strJ + " binary detected!");
                z10 = true;
            }
        }
        return z10;
    }

    public boolean b(ArrayList arrayList) {
        PackageManager packageManager = this.f415v.getPackageManager();
        int size = arrayList.size();
        boolean z10 = false;
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            String str = (String) obj;
            try {
                packageManager.getPackageInfo(str, 0);
                d.f(str + " ROOT management app detected!");
                z10 = true;
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return z10;
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x022a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean c() {
        /*
            Method dump skipped, instruction units count: 557
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ad.b.c():boolean");
    }

    @Override // s7.g
    public Object get() {
        return (ConnectivityManager) this.f415v.getSystemService("connectivity");
    }

    @Override // p2.k
    public l u(o oVar) {
        Context context;
        int i = Build.VERSION.SDK_INT;
        if (i < 31 && ((context = this.f415v) == null || i < 28 || !context.getPackageManager().hasSystemFeature("com.amazon.hardware.tv_screen"))) {
            return new c0(20).u(oVar);
        }
        int i10 = m0.i(((p) oVar.f2037d).f12946n);
        y1.b.k("DMCodecAdapterFactory", "Creating an asynchronous MediaCodec adapter for track type " + a0.E(i10));
        return new w(5, new c(i10, 0), new c(i10, 1)).u(oVar);
    }

    public b(Context context) {
        u.g(context);
        Context applicationContext = context.getApplicationContext();
        u.g(applicationContext);
        this.f415v = applicationContext;
    }
}
