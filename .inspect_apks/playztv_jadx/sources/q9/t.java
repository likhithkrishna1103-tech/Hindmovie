package q9;

import android.graphics.Matrix;
import android.graphics.Path;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f11151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f11152b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f11153c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f11154d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f11155e;
    public Object f = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Object f11156g = new ArrayList();

    public t() {
        d(0.0f, 270.0f, 0.0f);
    }

    public void a(float f) {
        float f4 = this.f11154d;
        if (f4 == f) {
            return;
        }
        float f10 = ((f - f4) + 360.0f) % 360.0f;
        if (f10 > 180.0f) {
            return;
        }
        float f11 = this.f11152b;
        float f12 = this.f11153c;
        p pVar = new p(f11, f12, f11, f12);
        pVar.f = this.f11154d;
        pVar.f11145g = f10;
        ((ArrayList) this.f11156g).add(new n(pVar));
        this.f11154d = f;
    }

    public void b(Matrix matrix, Path path) {
        ArrayList arrayList = (ArrayList) this.f;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((r) arrayList.get(i)).a(matrix, path);
        }
    }

    public void c(float f, float f4) {
        q qVar = new q();
        qVar.f11146b = f;
        qVar.f11147c = f4;
        ((ArrayList) this.f).add(qVar);
        o oVar = new o(qVar, this.f11152b, this.f11153c);
        float fB = oVar.b() + 270.0f;
        float fB2 = oVar.b() + 270.0f;
        a(fB);
        ((ArrayList) this.f11156g).add(oVar);
        this.f11154d = fB2;
        this.f11152b = f;
        this.f11153c = f4;
    }

    public void d(float f, float f4, float f10) {
        this.f11151a = f;
        this.f11152b = 0.0f;
        this.f11153c = f;
        this.f11154d = f4;
        this.f11155e = (f4 + f10) % 360.0f;
        ((ArrayList) this.f).clear();
        ((ArrayList) this.f11156g).clear();
    }
}
