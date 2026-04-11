package ka;

import android.graphics.Matrix;
import android.graphics.Path;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f7378a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f7379b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f7380c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f7381d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f7382e;
    public Object f = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Object f7383g = new ArrayList();

    public v() {
        d(0.0f, 270.0f, 0.0f);
    }

    public void a(float f) {
        float f10 = this.f7381d;
        if (f10 == f) {
            return;
        }
        float f11 = ((f - f10) + 360.0f) % 360.0f;
        if (f11 > 180.0f) {
            return;
        }
        float f12 = this.f7379b;
        float f13 = this.f7380c;
        r rVar = new r(f12, f13, f12, f13);
        rVar.f = this.f7381d;
        rVar.f7372g = f11;
        ((ArrayList) this.f7383g).add(new p(rVar));
        this.f7381d = f;
    }

    public void b(Matrix matrix, Path path) {
        ArrayList arrayList = (ArrayList) this.f;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((t) arrayList.get(i)).a(matrix, path);
        }
    }

    public void c(float f, float f10) {
        s sVar = new s();
        sVar.f7373b = f;
        sVar.f7374c = f10;
        ((ArrayList) this.f).add(sVar);
        q qVar = new q(sVar, this.f7379b, this.f7380c);
        float fB = qVar.b() + 270.0f;
        float fB2 = qVar.b() + 270.0f;
        a(fB);
        ((ArrayList) this.f7383g).add(qVar);
        this.f7381d = fB2;
        this.f7379b = f;
        this.f7380c = f10;
    }

    public void d(float f, float f10, float f11) {
        this.f7378a = f;
        this.f7379b = 0.0f;
        this.f7380c = f;
        this.f7381d = f10;
        this.f7382e = (f10 + f11) % 360.0f;
        ((ArrayList) this.f).clear();
        ((ArrayList) this.f7383g).clear();
    }
}
