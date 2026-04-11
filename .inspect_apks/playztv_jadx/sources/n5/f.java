package n5;

import android.graphics.Path;
import android.graphics.PointF;
import java.util.ArrayList;
import java.util.List;
import l5.w;
import l5.z;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f implements m, o5.a, k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f8715b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final w f8716c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final o5.j f8717d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final o5.e f8718e;
    public final s5.a f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f8720h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f8714a = new Path();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final rc.b f8719g = new rc.b(26);

    public f(w wVar, t5.b bVar, s5.a aVar) {
        this.f8715b = aVar.f11790a;
        this.f8716c = wVar;
        o5.e eVarD0 = aVar.f11792c.D0();
        this.f8717d = (o5.j) eVarD0;
        o5.e eVarD02 = aVar.f11791b.D0();
        this.f8718e = eVarD02;
        this.f = aVar;
        bVar.d(eVarD0);
        bVar.d(eVarD02);
        eVarD0.a(this);
        eVarD02.a(this);
    }

    @Override // o5.a
    public final void b() {
        this.f8720h = false;
        this.f8716c.invalidateSelf();
    }

    @Override // n5.c
    public final void c(List list, List list2) {
        int i = 0;
        while (true) {
            ArrayList arrayList = (ArrayList) list;
            if (i >= arrayList.size()) {
                return;
            }
            c cVar = (c) arrayList.get(i);
            if (cVar instanceof t) {
                t tVar = (t) cVar;
                if (tVar.f8814c == 1) {
                    ((ArrayList) this.f8719g.f11562v).add(tVar);
                    tVar.d(this);
                }
            }
            i++;
        }
    }

    @Override // n5.m
    public final Path f() {
        boolean z2 = this.f8720h;
        Path path = this.f8714a;
        if (z2) {
            return path;
        }
        path.reset();
        s5.a aVar = this.f;
        if (aVar.f11794e) {
            this.f8720h = true;
            return path;
        }
        PointF pointF = (PointF) this.f8717d.e();
        float f = pointF.x / 2.0f;
        float f4 = pointF.y / 2.0f;
        float f10 = f * 0.55228f;
        float f11 = f4 * 0.55228f;
        path.reset();
        if (aVar.f11793d) {
            float f12 = -f4;
            path.moveTo(0.0f, f12);
            float f13 = 0.0f - f10;
            float f14 = -f;
            float f15 = 0.0f - f11;
            path.cubicTo(f13, f12, f14, f15, f14, 0.0f);
            float f16 = f11 + 0.0f;
            path.cubicTo(f14, f16, f13, f4, 0.0f, f4);
            float f17 = f10 + 0.0f;
            path.cubicTo(f17, f4, f, f16, f, 0.0f);
            path.cubicTo(f, f15, f17, f12, 0.0f, f12);
        } else {
            float f18 = -f4;
            path.moveTo(0.0f, f18);
            float f19 = f10 + 0.0f;
            float f20 = 0.0f - f11;
            path.cubicTo(f19, f18, f, f20, f, 0.0f);
            float f21 = f11 + 0.0f;
            path.cubicTo(f, f21, f19, f4, 0.0f, f4);
            float f22 = 0.0f - f10;
            float f23 = -f;
            path.cubicTo(f22, f4, f23, f21, f23, 0.0f);
            path.cubicTo(f23, f20, f22, f18, 0.0f, f18);
        }
        PointF pointF2 = (PointF) this.f8718e.e();
        path.offset(pointF2.x, pointF2.y);
        path.close();
        this.f8719g.G(path);
        this.f8720h = true;
        return path;
    }

    @Override // q5.f
    public final void g(q5.e eVar, int i, ArrayList arrayList, q5.e eVar2) {
        x5.f.f(eVar, i, arrayList, eVar2, this);
    }

    @Override // n5.c
    public final String getName() {
        return this.f8715b;
    }

    @Override // q5.f
    public final void h(Object obj, p2.c cVar) {
        if (obj == z.f) {
            this.f8717d.j(cVar);
        } else if (obj == z.i) {
            this.f8718e.j(cVar);
        }
    }
}
