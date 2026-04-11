package ka;

import a3.i0;
import android.content.Context;
import com.google.android.gms.internal.measurement.a8;
import com.google.android.gms.internal.measurement.c7;
import com.google.android.gms.internal.measurement.d7;
import com.google.android.gms.internal.measurement.f7;
import com.google.android.gms.internal.measurement.n8;
import com.google.android.gms.internal.measurement.n9;
import com.google.android.gms.internal.measurement.p8;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class f implements a3.r, com.bumptech.glide.manager.k, f9.f, f9.w {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f7311v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ f f7307w = new f(11);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ f f7308x = new f(12);

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final /* synthetic */ f f7309y = new f(13);

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final /* synthetic */ f f7310z = new f(14);
    public static final /* synthetic */ f A = new f(15);
    public static final /* synthetic */ f B = new f(16);
    public static final /* synthetic */ f C = new f(17);
    public static final /* synthetic */ f D = new f(18);
    public static final /* synthetic */ f E = new f(19);
    public static final /* synthetic */ f F = new f(20);
    public static final /* synthetic */ f G = new f(21);
    public static final /* synthetic */ f H = new f(22);
    public static final /* synthetic */ f I = new f(23);
    public static final /* synthetic */ f J = new f(24);
    public static final /* synthetic */ f K = new f(25);
    public static final /* synthetic */ f L = new f(26);
    public static final /* synthetic */ f M = new f(27);
    public static final /* synthetic */ f N = new f(28);
    public static final /* synthetic */ f O = new f(29);

    public /* synthetic */ f(int i) {
        this.f7311v = i;
    }

    public static ag.h c(String str) {
        if (str.length() % 2 != 0) {
            throw new IllegalArgumentException("Unexpected hex string: ".concat(str).toString());
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i10 = i * 2;
            bArr[i] = (byte) (bg.b.a(str.charAt(i10 + 1)) + (bg.b.a(str.charAt(i10)) << 4));
        }
        return new ag.h(bArr);
    }

    public static ag.h d(String str) {
        ge.i.e(str, "<this>");
        byte[] bytes = str.getBytes(ne.a.f9126a);
        ge.i.d(bytes, "getBytes(...)");
        ag.h hVar = new ag.h(bytes);
        hVar.f433x = str;
        return hVar;
    }

    @Override // f9.f
    public /* synthetic */ String B(String str, String str2) {
        return null;
    }

    @Override // f9.w
    public Object a() {
        switch (this.f7311v) {
            case 12:
                return new Boolean(((Boolean) a8.f2321a.b()).booleanValue());
            case 13:
                List list = f9.f0.f4108a;
                Boolean bool = (Boolean) n9.f2557a.b();
                bool.getClass();
                return bool;
            case 14:
                List list2 = f9.f0.f4108a;
                Boolean bool2 = (Boolean) c7.f2353a.b();
                bool2.getClass();
                return bool2;
            case 15:
                List list3 = f9.f0.f4108a;
                d7.f2368w.get();
                return Integer.valueOf((int) ((Long) f7.f2432q0.b()).longValue());
            case 16:
                List list4 = f9.f0.f4108a;
                d7.f2368w.get();
                return (String) f7.M.b();
            case 17:
                List list5 = f9.f0.f4108a;
                d7.f2368w.get();
                Long l10 = (Long) f7.U.b();
                l10.getClass();
                return l10;
            case 18:
                List list6 = f9.f0.f4108a;
                d7.f2368w.get();
                return Integer.valueOf((int) ((Long) f7.P.b()).longValue());
            case 19:
                List list7 = f9.f0.f4108a;
                d7.f2368w.get();
                Long l11 = (Long) f7.Q.b();
                l11.getClass();
                return l11;
            case 20:
                List list8 = f9.f0.f4108a;
                d7.f2368w.get();
                Long l12 = (Long) f7.f2442v0.b();
                l12.getClass();
                return l12;
            case 21:
                List list9 = f9.f0.f4108a;
                d7.f2368w.get();
                Long l13 = (Long) f7.f2447z.b();
                l13.getClass();
                return l13;
            case 22:
                List list10 = f9.f0.f4108a;
                d7.f2368w.get();
                Long l14 = (Long) f7.f2414g0.b();
                l14.getClass();
                return l14;
            case 23:
                List list11 = f9.f0.f4108a;
                d7.f2368w.get();
                Long l15 = (Long) f7.f2430p0.b();
                l15.getClass();
                return l15;
            case 24:
                List list12 = f9.f0.f4108a;
                d7.f2368w.get();
                Long l16 = (Long) f7.G.b();
                l16.getClass();
                return l16;
            case 25:
                List list13 = f9.f0.f4108a;
                d7.f2368w.get();
                return (String) f7.f2413g.b();
            case 26:
                List list14 = f9.f0.f4108a;
                n8.f2555w.get();
                Double d10 = (Double) p8.f2576c.b();
                d10.getClass();
                return d10;
            case 27:
                List list15 = f9.f0.f4108a;
                d7.f2368w.get();
                return Integer.valueOf((int) ((Long) f7.f2408d.b()).longValue());
            case 28:
                List list16 = f9.f0.f4108a;
                d7.f2368w.get();
                return Integer.valueOf((int) ((Long) f7.f2445x.b()).longValue());
            default:
                List list17 = f9.f0.f4108a;
                d7.f2368w.get();
                return (String) f7.f2403a0.b();
        }
    }

    @Override // com.bumptech.glide.manager.k
    public com.bumptech.glide.p b(com.bumptech.glide.b bVar, com.bumptech.glide.manager.g gVar, com.bumptech.glide.manager.m mVar, Context context) {
        switch (this.f7311v) {
            case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                return new t5.c(bVar, gVar, mVar, context);
            default:
                return new com.bumptech.glide.p(bVar, gVar, mVar, context);
        }
    }

    public boolean f(CharSequence charSequence) {
        return false;
    }

    @Override // a3.r
    public i0 p(int i, int i10) {
        return new a3.o();
    }

    @Override // a3.r
    public void e() {
    }

    @Override // a3.r
    public void s(a3.c0 c0Var) {
    }
}
