package y;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class o implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f14412a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public x.e f14413b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public l f14414c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f14415d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final g f14416e = new g(this);
    public int f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f14417g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final f f14418h = new f(this);
    public final f i = new f(this);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f14419j = 1;

    public o(x.e eVar) {
        this.f14413b = eVar;
    }

    public static void b(f fVar, f fVar2, int i) {
        fVar.f14399l.add(fVar2);
        fVar.f = i;
        fVar2.f14398k.add(fVar);
    }

    public static f h(x.d dVar) {
        x.d dVar2 = dVar.f;
        if (dVar2 == null) {
            return null;
        }
        x.e eVar = dVar2.f14117d;
        int iC = v.e.c(dVar2.f14118e);
        if (iC == 1) {
            return eVar.f14127d.f14418h;
        }
        if (iC == 2) {
            return eVar.f14129e.f14418h;
        }
        if (iC == 3) {
            return eVar.f14127d.i;
        }
        if (iC == 4) {
            return eVar.f14129e.i;
        }
        if (iC != 5) {
            return null;
        }
        return eVar.f14129e.f14405k;
    }

    public static f i(x.d dVar, int i) {
        x.d dVar2 = dVar.f;
        if (dVar2 == null) {
            return null;
        }
        x.e eVar = dVar2.f14117d;
        o oVar = i == 0 ? eVar.f14127d : eVar.f14129e;
        int iC = v.e.c(dVar2.f14118e);
        if (iC == 1 || iC == 2) {
            return oVar.f14418h;
        }
        if (iC == 3 || iC == 4) {
            return oVar.i;
        }
        return null;
    }

    public final void c(f fVar, f fVar2, int i, g gVar) {
        fVar.f14399l.add(fVar2);
        fVar.f14399l.add(this.f14416e);
        fVar.f14396h = i;
        fVar.i = gVar;
        fVar2.f14398k.add(fVar);
        gVar.f14398k.add(fVar);
    }

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public final int g(int i, int i10) {
        if (i10 == 0) {
            x.e eVar = this.f14413b;
            int i11 = eVar.f14155v;
            int iMax = Math.max(eVar.f14154u, i);
            if (i11 > 0) {
                iMax = Math.min(i11, i);
            }
            if (iMax != i) {
                return iMax;
            }
        } else {
            x.e eVar2 = this.f14413b;
            int i12 = eVar2.f14158y;
            int iMax2 = Math.max(eVar2.f14157x, i);
            if (i12 > 0) {
                iMax2 = Math.min(i12, i);
            }
            if (iMax2 != i) {
                return iMax2;
            }
        }
        return i;
    }

    public long j() {
        if (this.f14416e.f14397j) {
            return r0.f14395g;
        }
        return 0L;
    }

    public abstract boolean k();

    /* JADX WARN: Removed duplicated region for block: B:28:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l(x.d r12, x.d r13, int r14) {
        /*
            Method dump skipped, instruction units count: 232
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y.o.l(x.d, x.d, int):void");
    }
}
