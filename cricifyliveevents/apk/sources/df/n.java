package df;

import androidx.media3.decoder.DecoderInputBuffer;
import c.x;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class n implements bf.d, b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3717a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f3718b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f3719c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3720d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String[] f3721e;
    public final List[] f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean[] f3722g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Object f3723h;
    public final Object i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Object f3724j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Object f3725k;

    public n(String str, e eVar, int i) {
        this.f3717a = str;
        this.f3718b = eVar;
        this.f3719c = i;
        String[] strArr = new String[i];
        for (int i10 = 0; i10 < i; i10++) {
            strArr[i10] = "[UNINITIALIZED]";
        }
        this.f3721e = strArr;
        int i11 = this.f3719c;
        this.f = new List[i11];
        this.f3722g = new boolean[i11];
        this.f3723h = sd.q.f11670v;
        final int i12 = 0;
        this.i = android.support.v4.media.session.b.F(new fe.a(this) { // from class: df.m

            /* JADX INFO: renamed from: w, reason: collision with root package name */
            public final /* synthetic */ n f3716w;

            {
                this.f3716w = this;
            }

            /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, rd.c] */
            @Override // fe.a
            public final Object b() {
                switch (i12) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        return this.f3716w.f3718b.a();
                    default:
                        n nVar = this.f3716w;
                        bf.d[] dVarArr = (bf.d[]) nVar.f3724j.getValue();
                        ge.i.e(dVarArr, "typeParams");
                        int iHashCode = (nVar.b().hashCode() * 31) + Arrays.hashCode(dVarArr);
                        int iD = nVar.d();
                        int i13 = 1;
                        while (true) {
                            int iHashCode2 = 0;
                            if (iD > 0) {
                                int i14 = iD - 1;
                                int i15 = i13 * 31;
                                String strB = nVar.j(nVar.d() - iD).b();
                                if (strB != null) {
                                    iHashCode2 = strB.hashCode();
                                }
                                i13 = i15 + iHashCode2;
                                iD = i14;
                            } else {
                                int iD2 = nVar.d();
                                int iHashCode3 = 1;
                                while (true) {
                                    if (!(iD2 > 0)) {
                                        return Integer.valueOf((((iHashCode * 31) + i13) * 31) + iHashCode3);
                                    }
                                    int i16 = iD2 - 1;
                                    int i17 = iHashCode3 * 31;
                                    w8.e eVarC = nVar.j(nVar.d() - iD2).c();
                                    iHashCode3 = i17 + (eVarC != null ? eVarC.hashCode() : 0);
                                    iD2 = i16;
                                }
                            }
                        }
                        break;
                }
            }
        });
        this.f3724j = android.support.v4.media.session.b.F(new x(this));
        final int i13 = 1;
        this.f3725k = android.support.v4.media.session.b.F(new fe.a(this) { // from class: df.m

            /* JADX INFO: renamed from: w, reason: collision with root package name */
            public final /* synthetic */ n f3716w;

            {
                this.f3716w = this;
            }

            /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, rd.c] */
            @Override // fe.a
            public final Object b() {
                switch (i13) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        return this.f3716w.f3718b.a();
                    default:
                        n nVar = this.f3716w;
                        bf.d[] dVarArr = (bf.d[]) nVar.f3724j.getValue();
                        ge.i.e(dVarArr, "typeParams");
                        int iHashCode = (nVar.b().hashCode() * 31) + Arrays.hashCode(dVarArr);
                        int iD = nVar.d();
                        int i132 = 1;
                        while (true) {
                            int iHashCode2 = 0;
                            if (iD > 0) {
                                int i14 = iD - 1;
                                int i15 = i132 * 31;
                                String strB = nVar.j(nVar.d() - iD).b();
                                if (strB != null) {
                                    iHashCode2 = strB.hashCode();
                                }
                                i132 = i15 + iHashCode2;
                                iD = i14;
                            } else {
                                int iD2 = nVar.d();
                                int iHashCode3 = 1;
                                while (true) {
                                    if (!(iD2 > 0)) {
                                        return Integer.valueOf((((iHashCode * 31) + i132) * 31) + iHashCode3);
                                    }
                                    int i16 = iD2 - 1;
                                    int i17 = iHashCode3 * 31;
                                    w8.e eVarC = nVar.j(nVar.d() - iD2).c();
                                    iHashCode3 = i17 + (eVarC != null ? eVarC.hashCode() : 0);
                                    iD2 = i16;
                                }
                            }
                        }
                        break;
                }
            }
        });
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.util.Map] */
    @Override // bf.d
    public final int a(String str) {
        ge.i.e(str, "name");
        Integer num = (Integer) this.f3723h.get(str);
        if (num != null) {
            return num.intValue();
        }
        return -3;
    }

    @Override // bf.d
    public final String b() {
        return this.f3717a;
    }

    @Override // bf.d
    public final w8.e c() {
        return bf.f.f1914d;
    }

    @Override // bf.d
    public final int d() {
        return this.f3719c;
    }

    @Override // bf.d
    public final String e(int i) {
        return this.f3721e[i];
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, rd.c] */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.lang.Object, rd.c] */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof n) {
            bf.d dVar = (bf.d) obj;
            if (this.f3717a.equals(dVar.b()) && Arrays.equals((bf.d[]) this.f3724j.getValue(), (bf.d[]) ((n) obj).f3724j.getValue())) {
                int iD = dVar.d();
                int i = this.f3719c;
                if (i == iD) {
                    for (int i10 = 0; i10 < i; i10++) {
                        if (ge.i.a(j(i10).b(), dVar.j(i10).b()) && ge.i.a(j(i10).c(), dVar.j(i10).c())) {
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    @Override // bf.d
    public boolean f() {
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, java.util.Map] */
    @Override // df.b
    public final Set g() {
        return this.f3723h.keySet();
    }

    @Override // bf.d
    public final List getAnnotations() {
        return sd.p.f11669v;
    }

    @Override // bf.d
    public final boolean h() {
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, rd.c] */
    public int hashCode() {
        return ((Number) this.f3725k.getValue()).intValue();
    }

    @Override // bf.d
    public final List i(int i) {
        List list = this.f[i];
        return list == null ? sd.p.f11669v : list;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, rd.c] */
    @Override // bf.d
    public final bf.d j(int i) {
        return ((ze.a[]) this.i.getValue())[i].d();
    }

    @Override // bf.d
    public final boolean k(int i) {
        return this.f3722g[i];
    }

    public final void l(String str, boolean z10) {
        int i = this.f3720d + 1;
        this.f3720d = i;
        String[] strArr = this.f3721e;
        strArr[i] = str;
        this.f3722g[i] = z10;
        this.f[i] = null;
        if (i == this.f3719c - 1) {
            HashMap map = new HashMap();
            int length = strArr.length;
            for (int i10 = 0; i10 < length; i10++) {
                map.put(strArr[i10], Integer.valueOf(i10));
            }
            this.f3723h = map;
        }
    }

    public final String toString() {
        return sd.j.l0(com.bumptech.glide.f.I(0, this.f3719c), ", ", this.f3717a.concat("("), ")", new l(0, this), 24);
    }
}
