package b0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class o implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1624a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a0.d f1625b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public l f1626c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f1627d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final g f1628e = new g(this);
    public int f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f1629g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final f f1630h = new f(this);
    public final f i = new f(this);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f1631j = 1;

    public o(a0.d dVar) {
        this.f1625b = dVar;
    }

    public static void b(f fVar, f fVar2, int i) {
        fVar.f1611l.add(fVar2);
        fVar.f = i;
        fVar2.f1610k.add(fVar);
    }

    public static f h(a0.c cVar) {
        a0.c cVar2 = cVar.f;
        if (cVar2 == null) {
            return null;
        }
        a0.d dVar = cVar2.f22d;
        int iC = y.e.c(cVar2.f23e);
        if (iC == 1) {
            return dVar.f32d.f1630h;
        }
        if (iC == 2) {
            return dVar.f34e.f1630h;
        }
        if (iC == 3) {
            return dVar.f32d.i;
        }
        if (iC == 4) {
            return dVar.f34e.i;
        }
        if (iC != 5) {
            return null;
        }
        return dVar.f34e.f1617k;
    }

    public static f i(a0.c cVar, int i) {
        a0.c cVar2 = cVar.f;
        if (cVar2 == null) {
            return null;
        }
        a0.d dVar = cVar2.f22d;
        o oVar = i == 0 ? dVar.f32d : dVar.f34e;
        int iC = y.e.c(cVar2.f23e);
        if (iC == 1 || iC == 2) {
            return oVar.f1630h;
        }
        if (iC == 3 || iC == 4) {
            return oVar.i;
        }
        return null;
    }

    public final void c(f fVar, f fVar2, int i, g gVar) {
        fVar.f1611l.add(fVar2);
        fVar.f1611l.add(this.f1628e);
        fVar.f1608h = i;
        fVar.i = gVar;
        fVar2.f1610k.add(fVar);
        gVar.f1610k.add(fVar);
    }

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public final int g(int i, int i10) {
        if (i10 == 0) {
            a0.d dVar = this.f1625b;
            int i11 = dVar.f60v;
            int iMax = Math.max(dVar.f59u, i);
            if (i11 > 0) {
                iMax = Math.min(i11, i);
            }
            if (iMax != i) {
                return iMax;
            }
        } else {
            a0.d dVar2 = this.f1625b;
            int i12 = dVar2.f63y;
            int iMax2 = Math.max(dVar2.f62x, i);
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
        if (this.f1628e.f1609j) {
            return r0.f1607g;
        }
        return 0L;
    }

    public abstract boolean k();

    /* JADX WARN: Removed duplicated region for block: B:28:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l(a0.c r12, a0.c r13, int r14) {
        /*
            Method dump skipped, instruction units count: 234
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b0.o.l(a0.c, a0.c, int):void");
    }
}
