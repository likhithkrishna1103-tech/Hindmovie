package n5;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;
import l5.w;
import l5.z;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class r implements m, o5.a, k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f8802b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f8803c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final w f8804d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final o5.n f8805e;
    public boolean f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f8801a = new Path();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final rc.b f8806g = new rc.b(26);

    public r(w wVar, t5.b bVar, s5.n nVar) {
        this.f8802b = nVar.f11847a;
        this.f8803c = nVar.f11850d;
        this.f8804d = wVar;
        o5.n nVar2 = new o5.n((List) nVar.f11849c.f2454v);
        this.f8805e = nVar2;
        bVar.d(nVar2);
        nVar2.a(this);
    }

    @Override // o5.a
    public final void b() {
        this.f = false;
        this.f8804d.invalidateSelf();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    @Override // n5.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(java.util.List r6, java.util.List r7) {
        /*
            r5 = this;
            r7 = 0
            r0 = 0
        L2:
            r1 = r6
            java.util.ArrayList r1 = (java.util.ArrayList) r1
            int r2 = r1.size()
            if (r0 >= r2) goto L3d
            java.lang.Object r1 = r1.get(r0)
            n5.c r1 = (n5.c) r1
            boolean r2 = r1 instanceof n5.t
            if (r2 == 0) goto L2a
            r2 = r1
            n5.t r2 = (n5.t) r2
            int r3 = r2.f8814c
            r4 = 1
            if (r3 != r4) goto L2a
            rc.b r1 = r5.f8806g
            java.lang.Object r1 = r1.f11562v
            java.util.ArrayList r1 = (java.util.ArrayList) r1
            r1.add(r2)
            r2.d(r5)
            goto L3a
        L2a:
            boolean r2 = r1 instanceof n5.q
            if (r2 == 0) goto L3a
            if (r7 != 0) goto L35
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
        L35:
            n5.q r1 = (n5.q) r1
            r7.add(r1)
        L3a:
            int r0 = r0 + 1
            goto L2
        L3d:
            o5.n r6 = r5.f8805e
            r6.f9399m = r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: n5.r.c(java.util.List, java.util.List):void");
    }

    @Override // n5.m
    public final Path f() {
        boolean z2 = this.f;
        o5.n nVar = this.f8805e;
        Path path = this.f8801a;
        if (z2 && nVar.f9379e == null) {
            return path;
        }
        path.reset();
        if (this.f8803c) {
            this.f = true;
            return path;
        }
        Path path2 = (Path) nVar.e();
        if (path2 == null) {
            return path;
        }
        path.set(path2);
        path.setFillType(Path.FillType.EVEN_ODD);
        this.f8806g.G(path);
        this.f = true;
        return path;
    }

    @Override // q5.f
    public final void g(q5.e eVar, int i, ArrayList arrayList, q5.e eVar2) {
        x5.f.f(eVar, i, arrayList, eVar2, this);
    }

    @Override // n5.c
    public final String getName() {
        return this.f8802b;
    }

    @Override // q5.f
    public final void h(Object obj, p2.c cVar) {
        if (obj == z.K) {
            this.f8805e.j(cVar);
        }
    }
}
