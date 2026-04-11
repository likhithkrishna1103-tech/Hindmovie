package i6;

import android.graphics.Path;
import g6.a0;
import g6.w;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class s implements n, j6.a, l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f6329b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f6330c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final w f6331d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final j6.n f6332e;
    public boolean f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f6328a = new Path();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c f6333g = new c(0);

    public s(w wVar, o6.a aVar, n6.n nVar) {
        this.f6329b = nVar.f8831a;
        this.f6330c = nVar.f8834d;
        this.f6331d = wVar;
        j6.n nVar2 = new j6.n((List) nVar.f8833c.f307w);
        this.f6332e = nVar2;
        aVar.d(nVar2);
        nVar2.a(this);
    }

    @Override // j6.a
    public final void b() {
        this.f = false;
        this.f6331d.invalidateSelf();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    @Override // i6.d
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
            if (r0 >= r2) goto L40
            java.lang.Object r1 = r1.get(r0)
            i6.d r1 = (i6.d) r1
            boolean r2 = r1 instanceof i6.u
            if (r2 == 0) goto L28
            r2 = r1
            i6.u r2 = (i6.u) r2
            int r3 = r2.f6341c
            r4 = 1
            if (r3 != r4) goto L28
            i6.c r1 = r5.f6333g
            java.util.ArrayList r1 = r1.f6231a
            r1.add(r2)
            r2.d(r5)
            goto L3d
        L28:
            boolean r2 = r1 instanceof i6.r
            if (r2 == 0) goto L3d
            if (r7 != 0) goto L33
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
        L33:
            i6.r r1 = (i6.r) r1
            j6.e r2 = r1.f6326b
            r2.a(r5)
            r7.add(r1)
        L3d:
            int r0 = r0 + 1
            goto L2
        L40:
            j6.n r6 = r5.f6332e
            r6.f6655m = r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: i6.s.c(java.util.List, java.util.List):void");
    }

    @Override // i6.n
    public final Path f() {
        boolean z10 = this.f;
        j6.n nVar = this.f6332e;
        Path path = this.f6328a;
        if (z10 && nVar.f6634e == null) {
            return path;
        }
        path.reset();
        if (this.f6330c) {
            this.f = true;
            return path;
        }
        Path path2 = (Path) nVar.e();
        if (path2 == null) {
            return path;
        }
        path.set(path2);
        path.setFillType(Path.FillType.EVEN_ODD);
        this.f6333g.a(path);
        this.f = true;
        return path;
    }

    @Override // l6.f
    public final void g(l6.e eVar, int i, ArrayList arrayList, l6.e eVar2) {
        s6.g.g(eVar, i, arrayList, eVar2, this);
    }

    @Override // i6.d
    public final String getName() {
        return this.f6329b;
    }

    @Override // l6.f
    public final void h(Object obj, nb.w wVar) {
        if (obj == a0.N) {
            this.f6332e.j(wVar);
        }
    }
}
