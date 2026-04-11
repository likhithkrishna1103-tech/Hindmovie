package o6;

import i2.k;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f9532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g6.i f9533b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f9534c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f9535d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f9536e;
    public final long f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f9537g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List f9538h;
    public final m6.e i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f9539j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f9540k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f9541l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final float f9542m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final float f9543n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final float f9544o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final float f9545p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final m6.a f9546q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final k f9547r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final m6.b f9548s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final List f9549t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f9550u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f9551v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final l4.a f9552w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final dd.c f9553x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f9554y;

    public d(List list, g6.i iVar, String str, long j4, int i, long j7, String str2, List list2, m6.e eVar, int i10, int i11, int i12, float f, float f10, float f11, float f12, m6.a aVar, k kVar, List list3, int i13, m6.b bVar, boolean z10, l4.a aVar2, dd.c cVar, int i14) {
        this.f9532a = list;
        this.f9533b = iVar;
        this.f9534c = str;
        this.f9535d = j4;
        this.f9536e = i;
        this.f = j7;
        this.f9537g = str2;
        this.f9538h = list2;
        this.i = eVar;
        this.f9539j = i10;
        this.f9540k = i11;
        this.f9541l = i12;
        this.f9542m = f;
        this.f9543n = f10;
        this.f9544o = f11;
        this.f9545p = f12;
        this.f9546q = aVar;
        this.f9547r = kVar;
        this.f9549t = list3;
        this.f9550u = i13;
        this.f9548s = bVar;
        this.f9551v = z10;
        this.f9552w = aVar2;
        this.f9553x = cVar;
        this.f9554y = i14;
    }

    public final String a(String str) {
        int i;
        StringBuilder sbB = y.e.b(str);
        sbB.append(this.f9534c);
        sbB.append("\n");
        long j4 = this.f;
        g6.i iVar = this.f9533b;
        d dVar = (d) iVar.i.d(j4);
        if (dVar != null) {
            sbB.append("\t\tParents: ");
            sbB.append(dVar.f9534c);
            for (d dVar2 = (d) iVar.i.d(dVar.f); dVar2 != null; dVar2 = (d) iVar.i.d(dVar2.f)) {
                sbB.append("->");
                sbB.append(dVar2.f9534c);
            }
            sbB.append(str);
            sbB.append("\n");
        }
        List list = this.f9538h;
        if (!list.isEmpty()) {
            sbB.append(str);
            sbB.append("\tMasks: ");
            sbB.append(list.size());
            sbB.append("\n");
        }
        int i10 = this.f9539j;
        if (i10 != 0 && (i = this.f9540k) != 0) {
            sbB.append(str);
            sbB.append("\tBackground: ");
            sbB.append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(i10), Integer.valueOf(i), Integer.valueOf(this.f9541l)));
        }
        List list2 = this.f9532a;
        if (!list2.isEmpty()) {
            sbB.append(str);
            sbB.append("\tShapes:\n");
            for (Object obj : list2) {
                sbB.append(str);
                sbB.append("\t\t");
                sbB.append(obj);
                sbB.append("\n");
            }
        }
        return sbB.toString();
    }

    public final String toString() {
        return a("");
    }
}
