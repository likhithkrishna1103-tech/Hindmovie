package i6;

import android.graphics.Path;
import android.graphics.PointF;
import g6.a0;
import g6.w;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g implements n, j6.a, l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f6243b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final w f6244c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final j6.j f6245d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final j6.e f6246e;
    public final n6.a f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f6248h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f6242a = new Path();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c f6247g = new c(0);

    public g(w wVar, o6.a aVar, n6.a aVar2) {
        this.f6243b = aVar2.f8774a;
        this.f6244c = wVar;
        j6.e eVarD0 = aVar2.f8776c.D0();
        this.f6245d = (j6.j) eVarD0;
        j6.e eVarD02 = aVar2.f8775b.D0();
        this.f6246e = eVarD02;
        this.f = aVar2;
        aVar.d(eVarD0);
        aVar.d(eVarD02);
        eVarD0.a(this);
        eVarD02.a(this);
    }

    @Override // j6.a
    public final void b() {
        this.f6248h = false;
        this.f6244c.invalidateSelf();
    }

    @Override // i6.d
    public final void c(List list, List list2) {
        int i = 0;
        while (true) {
            ArrayList arrayList = (ArrayList) list;
            if (i >= arrayList.size()) {
                return;
            }
            d dVar = (d) arrayList.get(i);
            if (dVar instanceof u) {
                u uVar = (u) dVar;
                if (uVar.f6341c == 1) {
                    this.f6247g.f6231a.add(uVar);
                    uVar.d(this);
                }
            }
            i++;
        }
    }

    @Override // i6.n
    public final Path f() {
        boolean z10 = this.f6248h;
        Path path = this.f6242a;
        if (z10) {
            return path;
        }
        path.reset();
        n6.a aVar = this.f;
        if (aVar.f8778e) {
            this.f6248h = true;
            return path;
        }
        PointF pointF = (PointF) this.f6245d.e();
        float f = pointF.x / 2.0f;
        float f10 = pointF.y / 2.0f;
        float f11 = f * 0.55228f;
        float f12 = f10 * 0.55228f;
        path.reset();
        if (aVar.f8777d) {
            float f13 = -f10;
            path.moveTo(0.0f, f13);
            float f14 = 0.0f - f11;
            float f15 = -f;
            float f16 = 0.0f - f12;
            path.cubicTo(f14, f13, f15, f16, f15, 0.0f);
            float f17 = f12 + 0.0f;
            path.cubicTo(f15, f17, f14, f10, 0.0f, f10);
            float f18 = f11 + 0.0f;
            path.cubicTo(f18, f10, f, f17, f, 0.0f);
            path.cubicTo(f, f16, f18, f13, 0.0f, f13);
        } else {
            float f19 = -f10;
            path.moveTo(0.0f, f19);
            float f20 = f11 + 0.0f;
            float f21 = 0.0f - f12;
            path.cubicTo(f20, f19, f, f21, f, 0.0f);
            float f22 = f12 + 0.0f;
            path.cubicTo(f, f22, f20, f10, 0.0f, f10);
            float f23 = 0.0f - f11;
            float f24 = -f;
            path.cubicTo(f23, f10, f24, f22, f24, 0.0f);
            path.cubicTo(f24, f21, f23, f19, 0.0f, f19);
        }
        PointF pointF2 = (PointF) this.f6246e.e();
        path.offset(pointF2.x, pointF2.y);
        path.close();
        this.f6247g.a(path);
        this.f6248h = true;
        return path;
    }

    @Override // l6.f
    public final void g(l6.e eVar, int i, ArrayList arrayList, l6.e eVar2) {
        s6.g.g(eVar, i, arrayList, eVar2, this);
    }

    @Override // i6.d
    public final String getName() {
        return this.f6243b;
    }

    @Override // l6.f
    public final void h(Object obj, nb.w wVar) {
        if (obj == a0.f) {
            this.f6245d.j(wVar);
        } else if (obj == a0.i) {
            this.f6246e.j(wVar);
        }
    }
}
