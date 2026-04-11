package jb;

import a3.c0;
import a3.i0;
import a3.r;
import ag.o;
import android.os.Looper;
import androidx.fragment.app.r0;
import androidx.media3.decoder.DecoderInputBuffer;
import cd.l;
import com.bumptech.glide.manager.g;
import com.bumptech.glide.manager.m;
import com.google.android.gms.internal.measurement.d7;
import com.google.android.gms.internal.measurement.f7;
import com.google.android.gms.internal.measurement.n8;
import com.google.android.gms.internal.measurement.p8;
import com.google.android.gms.internal.measurement.q8;
import com.google.android.gms.internal.measurement.r7;
import com.google.android.gms.internal.measurement.s8;
import f9.f0;
import f9.w;
import g1.h;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import sd.i;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements r, t7.a, g, m, w {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f6727v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ b f6723w = new b(12);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ b f6724x = new b(13);

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final /* synthetic */ b f6725y = new b(14);

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final /* synthetic */ b f6726z = new b(15);
    public static final /* synthetic */ b A = new b(16);
    public static final /* synthetic */ b B = new b(17);
    public static final /* synthetic */ b C = new b(18);
    public static final /* synthetic */ b D = new b(19);
    public static final /* synthetic */ b E = new b(20);
    public static final /* synthetic */ b F = new b(21);
    public static final /* synthetic */ b G = new b(22);
    public static final /* synthetic */ b H = new b(23);
    public static final /* synthetic */ b I = new b(24);
    public static final /* synthetic */ b J = new b(25);
    public static final /* synthetic */ b K = new b(26);
    public static final /* synthetic */ b L = new b(27);
    public static final /* synthetic */ b M = new b(28);
    public static final /* synthetic */ b N = new b(29);

    public /* synthetic */ b(int i) {
        this.f6727v = i;
    }

    public static final void d(ag.c cVar) {
        o oVar = ag.c.f419h;
        if (ag.c.i == null) {
            ag.c.i = new ag.c();
            ag.b bVar = new ag.b("Okio Watchdog");
            bVar.setDaemon(true);
            bVar.start();
        }
        long jNanoTime = System.nanoTime();
        long j4 = cVar.f475c;
        boolean z10 = cVar.f473a;
        if (j4 != 0 && z10) {
            cVar.f425g = Math.min(j4, cVar.c() - jNanoTime) + jNanoTime;
        } else if (j4 != 0) {
            cVar.f425g = jNanoTime + j4;
        } else {
            if (!z10) {
                throw new AssertionError();
            }
            cVar.f425g = cVar.c();
        }
        o oVar2 = ag.c.f419h;
        int i = oVar2.f454w + 1;
        oVar2.f454w = i;
        ag.c[] cVarArr = (ag.c[]) oVar2.f455x;
        if (i == cVarArr.length) {
            ag.c[] cVarArr2 = new ag.c[i * 2];
            i.i(0, 0, 14, cVarArr, cVarArr2);
            oVar2.f455x = cVarArr2;
        }
        oVar2.i(i, cVar);
        if (cVar.f == 1) {
            ag.c.f421k.signal();
        }
    }

    public static ag.c f() throws InterruptedException {
        o oVar = ag.c.f419h;
        ag.c cVar = ((ag.c[]) oVar.f455x)[1];
        if (cVar == null) {
            long jNanoTime = System.nanoTime();
            ag.c.f421k.await(ag.c.f422l, TimeUnit.MILLISECONDS);
            if (((ag.c[]) oVar.f455x)[1] != null || System.nanoTime() - jNanoTime < ag.c.f423m) {
                return null;
            }
            return ag.c.i;
        }
        long jNanoTime2 = cVar.f425g - System.nanoTime();
        if (jNanoTime2 > 0) {
            ag.c.f421k.await(jNanoTime2, TimeUnit.NANOSECONDS);
            return null;
        }
        oVar.n(cVar);
        cVar.f424e = 2;
        return cVar;
    }

    public static cd.b g(int i) {
        cd.b bVar = cd.b.f2151x;
        switch (i) {
            case -1:
                return bVar;
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return cd.b.f2152y;
            case 1:
                return cd.b.f2153z;
            case 2:
                return cd.b.A;
            case 3:
                return cd.b.B;
            case h.LONG_FIELD_NUMBER /* 4 */:
                return cd.b.C;
            case h.STRING_FIELD_NUMBER /* 5 */:
                return cd.b.D;
            case h.STRING_SET_FIELD_NUMBER /* 6 */:
                return cd.b.E;
            case h.DOUBLE_FIELD_NUMBER /* 7 */:
                return cd.b.F;
            case h.BYTES_FIELD_NUMBER /* 8 */:
                return cd.b.G;
            case 9:
                return cd.b.H;
            case 10:
                return cd.b.I;
            case 11:
                return cd.b.J;
            case 12:
            case 14:
            case 18:
            default:
                return bVar;
            case 13:
                return cd.b.K;
            case 15:
                return cd.b.M;
            case 16:
                return cd.b.N;
            case 17:
                return cd.b.O;
            case 19:
                return cd.b.P;
            case 20:
                return cd.b.Q;
            case 21:
                return cd.b.R;
            case 22:
                return cd.b.S;
            case 23:
                return cd.b.T;
            case 24:
                return cd.b.U;
            case 25:
                return cd.b.V;
            case 26:
                return cd.b.W;
            case 27:
                return cd.b.X;
            case 28:
                return cd.b.Y;
            case 29:
                return cd.b.Z;
            case 30:
                return cd.b.f2147a0;
            case 31:
                return cd.b.f2148b0;
        }
    }

    public static l h(int i) {
        l lVar = l.f2186x;
        switch (i) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return lVar;
            case 1:
                return l.f2187y;
            case 2:
                return l.f2188z;
            case 3:
                return l.A;
            case h.LONG_FIELD_NUMBER /* 4 */:
                return l.B;
            case h.STRING_FIELD_NUMBER /* 5 */:
                return l.C;
            case h.STRING_SET_FIELD_NUMBER /* 6 */:
                return l.D;
            case h.DOUBLE_FIELD_NUMBER /* 7 */:
                return l.E;
            case h.BYTES_FIELD_NUMBER /* 8 */:
                return l.F;
            case 9:
                return l.G;
            default:
                return lVar;
        }
    }

    public static final boolean i() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    @Override // f9.w
    public Object a() {
        switch (this.f6727v) {
            case 12:
                return new Boolean(((Boolean) r7.f2586a.b()).booleanValue());
            case 13:
                List list = f0.f4108a;
                q8.f2581w.get();
                Boolean bool = (Boolean) s8.f2624c.b();
                bool.getClass();
                return bool;
            case 14:
                List list2 = f0.f4108a;
                d7.f2368w.get();
                return (String) f7.f2422l.b();
            case 15:
                List list3 = f0.f4108a;
                d7.f2368w.get();
                return Integer.valueOf((int) ((Long) f7.f2421k0.b()).longValue());
            case 16:
                List list4 = f0.f4108a;
                d7.f2368w.get();
                return (String) f7.f2426n.b();
            case 17:
                List list5 = f0.f4108a;
                d7.f2368w.get();
                Long l10 = (Long) f7.A.b();
                l10.getClass();
                return l10;
            case 18:
                List list6 = f0.f4108a;
                d7.f2368w.get();
                return Integer.valueOf((int) ((Long) f7.K.b()).longValue());
            case 19:
                List list7 = f0.f4108a;
                d7.f2368w.get();
                Long l11 = (Long) f7.R.b();
                l11.getClass();
                return l11;
            case 20:
                List list8 = f0.f4108a;
                d7.f2368w.get();
                Long l12 = (Long) f7.f2412f0.b();
                l12.getClass();
                return l12;
            case 21:
                List list9 = f0.f4108a;
                d7.f2368w.get();
                Long l13 = (Long) f7.i.b();
                l13.getClass();
                return l13;
            case 22:
                List list10 = f0.f4108a;
                d7.f2368w.get();
                Long l14 = (Long) f7.F.b();
                l14.getClass();
                return l14;
            case 23:
                List list11 = f0.f4108a;
                d7.f2368w.get();
                return Integer.valueOf((int) ((Long) f7.f2436s0.b()).longValue());
            case 24:
                List list12 = f0.f4108a;
                d7.f2368w.get();
                return Integer.valueOf((int) ((Long) f7.f2437t.b()).longValue());
            case 25:
                List list13 = f0.f4108a;
                n8.f2555w.get();
                return (String) p8.f.b();
            case 26:
                List list14 = f0.f4108a;
                n8.f2555w.get();
                return Integer.valueOf((int) ((Long) p8.f2577d.b()).longValue());
            case 27:
                List list15 = f0.f4108a;
                d7.f2368w.get();
                return Integer.valueOf((int) ((Long) f7.f2431q.b()).longValue());
            case 28:
                List list16 = f0.f4108a;
                d7.f2368w.get();
                return Integer.valueOf((int) ((Long) f7.f2419j0.b()).longValue());
            default:
                List list17 = f0.f4108a;
                d7.f2368w.get();
                return (String) f7.Y.b();
        }
    }

    @Override // com.bumptech.glide.manager.g
    public void b(com.bumptech.glide.manager.h hVar) {
        hVar.l();
    }

    @Override // a3.r
    public void e() {
        throw new UnsupportedOperationException();
    }

    @Override // t7.a
    public Object o() {
        try {
            return new b7.h(MessageDigest.getInstance("SHA-256"));
        } catch (NoSuchAlgorithmException e9) {
            throw new RuntimeException(e9);
        }
    }

    @Override // a3.r
    public i0 p(int i, int i10) {
        throw new UnsupportedOperationException();
    }

    @Override // a3.r
    public void s(c0 c0Var) {
        throw new UnsupportedOperationException();
    }

    public b(l4.c0 c0Var, r0 r0Var) {
        this.f6727v = 9;
    }

    @Override // com.bumptech.glide.manager.g
    public void c(com.bumptech.glide.manager.h hVar) {
    }
}
