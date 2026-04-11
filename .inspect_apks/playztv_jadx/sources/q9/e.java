package q9;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Looper;
import com.google.android.gms.internal.measurement.d7;
import com.google.android.gms.internal.measurement.e9;
import com.google.android.gms.internal.measurement.f7;
import com.google.android.gms.internal.measurement.g8;
import com.google.android.gms.internal.measurement.g9;
import com.google.android.gms.internal.measurement.i8;
import com.google.android.gms.internal.measurement.j7;
import com.google.android.gms.internal.measurement.k9;
import com.google.android.gms.internal.measurement.l7;
import com.google.android.gms.internal.measurement.m8;
import com.google.android.gms.internal.measurement.m9;
import com.google.android.gms.internal.measurement.o8;
import com.google.android.gms.internal.measurement.x6;
import com.google.android.gms.internal.measurement.z6;
import ea.y;
import f2.b0;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;
import k8.c0;
import k8.e0;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import org.json.JSONObject;
import p1.g0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class e implements bb.e, e7.b, f2.n, h2.s, id.l, e0 {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f11089u;

    public /* synthetic */ e(int i) {
        this.f11089u = i;
    }

    public static final String c(byte[] bArr, byte[][] bArr2, int i) {
        int i10;
        boolean z2;
        int i11;
        int i12;
        byte[] bArr3 = PublicSuffixDatabase.f9586e;
        int length = bArr.length;
        int i13 = 0;
        while (i13 < length) {
            int i14 = (i13 + length) / 2;
            while (i14 > -1 && bArr[i14] != 10) {
                i14--;
            }
            int i15 = i14 + 1;
            int i16 = 1;
            while (true) {
                i10 = i15 + i16;
                if (bArr[i10] == 10) {
                    break;
                }
                i16++;
            }
            int i17 = i10 - i15;
            int i18 = i;
            boolean z10 = false;
            int i19 = 0;
            int i20 = 0;
            while (true) {
                if (z10) {
                    i11 = 46;
                    z2 = false;
                } else {
                    byte b10 = bArr2[i18][i19];
                    byte[] bArr4 = ve.b.f13497a;
                    int i21 = b10 & 255;
                    z2 = z10;
                    i11 = i21;
                }
                byte b11 = bArr[i15 + i20];
                byte[] bArr5 = ve.b.f13497a;
                i12 = i11 - (b11 & 255);
                if (i12 != 0) {
                    break;
                }
                i20++;
                i19++;
                if (i20 == i17) {
                    break;
                }
                if (bArr2[i18].length != i19) {
                    z10 = z2;
                } else {
                    if (i18 == bArr2.length - 1) {
                        break;
                    }
                    i18++;
                    i19 = -1;
                    z10 = true;
                }
            }
            if (i12 >= 0) {
                if (i12 <= 0) {
                    int i22 = i17 - i20;
                    int length2 = bArr2[i18].length - i19;
                    int length3 = bArr2.length;
                    for (int i23 = i18 + 1; i23 < length3; i23++) {
                        length2 += bArr2[i23].length;
                    }
                    if (length2 >= i22) {
                        if (length2 <= i22) {
                            Charset charset = StandardCharsets.UTF_8;
                            be.h.d(charset, "UTF_8");
                            return new String(bArr, i15, i17, charset);
                        }
                    }
                }
                i13 = i10 + 1;
            }
            length = i14;
        }
        return null;
    }

    public static bb.c k(c0 c0Var) {
        return new bb.c(System.currentTimeMillis() + ((long) 3600000), new b8.l(8), new bb.b(true, false, false), 10.0d, 1.2d, 60);
    }

    public static y m(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (((g0) it.next()).f9757b == null) {
                UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
                ea.u uVar = new ea.u();
                uVar.l(unsupportedOperationException);
                return uVar;
            }
        }
        return b8.h.r(list);
    }

    public static boolean n() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    @Override // id.l
    public boolean D() {
        return false;
    }

    @Override // k8.e0
    public Object a() {
        switch (this.f11089u) {
            case 16:
                j7.f3065v.get();
                Boolean bool = (Boolean) l7.f3089a.a();
                bool.getClass();
                return bool;
            case 17:
                e9.f2961v.get();
                Boolean bool2 = (Boolean) g9.i.a();
                bool2.getClass();
                return bool2;
            case 18:
                x6.f3236v.get();
                return Integer.valueOf((int) ((Long) z6.Q.a()).longValue());
            case 19:
                k9.f3082v.get();
                Boolean bool3 = (Boolean) m9.f3105b.a();
                bool3.getClass();
                return bool3;
            case 20:
                m8.f3102v.get();
                Boolean bool4 = (Boolean) o8.f3143a.a();
                bool4.getClass();
                return bool4;
            case 21:
                x6.f3236v.get();
                return Integer.valueOf((int) ((Long) z6.U.a()).longValue());
            case 22:
                g8.f3020v.get();
                Boolean bool5 = (Boolean) i8.f3059a.a();
                bool5.getClass();
                return bool5;
            case 23:
                e9.f2961v.get();
                Boolean bool6 = (Boolean) g9.f.a();
                bool6.getClass();
                return bool6;
            case 24:
                x6.f3236v.get();
                return Integer.valueOf((int) ((Long) z6.W.a()).longValue());
            case 25:
                x6.f3236v.get();
                return (String) z6.f3266c0.a();
            case 26:
                d7.f2938v.get();
                Boolean bool7 = (Boolean) f7.f2972b.a();
                bool7.getClass();
                return bool7;
            case 27:
                x6.f3236v.get();
                Long l10 = (Long) z6.f3272h.a();
                l10.getClass();
                return l10;
            case 28:
                x6.f3236v.get();
                Long l11 = (Long) z6.C.a();
                l11.getClass();
                return l11;
            default:
                x6.f3236v.get();
                return Integer.valueOf((int) ((Long) z6.f3262a0.a()).longValue());
        }
    }

    @Override // bb.e
    public bb.c b(c0 c0Var, JSONObject jSONObject) {
        return k(c0Var);
    }

    @Override // f2.n
    public /* synthetic */ f2.m e(f2.k kVar, p1.q qVar) {
        return f2.m.i;
    }

    @Override // f2.n
    public int f(p1.q qVar) {
        return qVar.f10027r != null ? 1 : 0;
    }

    @Override // md.a
    public Object get() {
        return new c7.r(0, Executors.newSingleThreadExecutor());
    }

    @Override // f2.n
    public f2.h h(f2.k kVar, p1.q qVar) {
        if (qVar.f10027r == null) {
            return null;
        }
        return new f2.q(new f2.g(new b0(), 6001));
    }

    public com.bumptech.glide.m i(com.bumptech.glide.b bVar, com.bumptech.glide.manager.g gVar, com.bumptech.glide.manager.l lVar, Context context) {
        switch (this.f11089u) {
            case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                return new jc.c(bVar, gVar, lVar, context);
            default:
                return new com.bumptech.glide.m(bVar, gVar, lVar, context);
        }
    }

    @Override // h2.s
    public s2.o j(h2.o oVar, h2.l lVar) {
        return new h2.r(oVar, lVar);
    }

    public Signature[] l(PackageManager packageManager, String str) {
        return packageManager.getPackageInfo(str, 64).signatures;
    }

    @Override // h2.s
    public s2.o x() {
        return new h2.r(h2.o.f5740l, null);
    }

    public e(Context context) {
        this.f11089u = 1;
    }

    @Override // f2.n
    public /* synthetic */ void d() {
    }

    @Override // f2.n
    public /* synthetic */ void release() {
    }

    @Override // f2.n
    public void g(Looper looper, b2.o oVar) {
    }
}
