package t5;

import java.util.List;
import java.util.Locale;
import ub.o;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f12177a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l5.j f12178b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f12179c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f12180d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f12181e;
    public final long f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f12182g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List f12183h;
    public final r5.d i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f12184j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f12185k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f12186l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final float f12187m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final float f12188n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final float f12189o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final float f12190p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final r5.a f12191q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final o f12192r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final r5.b f12193s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final List f12194t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f12195u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f12196v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final q0.e f12197w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final zc.c f12198x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f12199y;

    public e(List list, l5.j jVar, String str, long j5, int i, long j8, String str2, List list2, r5.d dVar, int i10, int i11, int i12, float f, float f4, float f10, float f11, r5.a aVar, o oVar, List list3, int i13, r5.b bVar, boolean z2, q0.e eVar, zc.c cVar, int i14) {
        this.f12177a = list;
        this.f12178b = jVar;
        this.f12179c = str;
        this.f12180d = j5;
        this.f12181e = i;
        this.f = j8;
        this.f12182g = str2;
        this.f12183h = list2;
        this.i = dVar;
        this.f12184j = i10;
        this.f12185k = i11;
        this.f12186l = i12;
        this.f12187m = f;
        this.f12188n = f4;
        this.f12189o = f10;
        this.f12190p = f11;
        this.f12191q = aVar;
        this.f12192r = oVar;
        this.f12194t = list3;
        this.f12195u = i13;
        this.f12193s = bVar;
        this.f12196v = z2;
        this.f12197w = eVar;
        this.f12198x = cVar;
        this.f12199y = i14;
    }

    public final String a(String str) {
        int i;
        StringBuilder sbB = v.e.b(str);
        sbB.append(this.f12179c);
        sbB.append("\n");
        long j5 = this.f;
        l5.j jVar = this.f12178b;
        e eVar = (e) jVar.i.d(j5);
        if (eVar != null) {
            sbB.append("\t\tParents: ");
            sbB.append(eVar.f12179c);
            for (e eVar2 = (e) jVar.i.d(eVar.f); eVar2 != null; eVar2 = (e) jVar.i.d(eVar2.f)) {
                sbB.append("->");
                sbB.append(eVar2.f12179c);
            }
            sbB.append(str);
            sbB.append("\n");
        }
        List list = this.f12183h;
        if (!list.isEmpty()) {
            sbB.append(str);
            sbB.append("\tMasks: ");
            sbB.append(list.size());
            sbB.append("\n");
        }
        int i10 = this.f12184j;
        if (i10 != 0 && (i = this.f12185k) != 0) {
            sbB.append(str);
            sbB.append("\tBackground: ");
            sbB.append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(i10), Integer.valueOf(i), Integer.valueOf(this.f12186l)));
        }
        List list2 = this.f12177a;
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
