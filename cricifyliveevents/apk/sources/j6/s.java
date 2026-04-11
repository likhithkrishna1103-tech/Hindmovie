package j6;

import java.util.Collections;
import nb.w;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class s extends e {
    public final Object i;

    public s(Object obj, w wVar) {
        super(Collections.EMPTY_LIST);
        j(wVar);
        this.i = obj;
    }

    @Override // j6.e
    public final float b() {
        return 1.0f;
    }

    @Override // j6.e
    public final Object e() {
        w wVar = this.f6634e;
        Object obj = this.i;
        float f = this.f6633d;
        return wVar.G(0.0f, 0.0f, obj, obj, f, f, f);
    }

    @Override // j6.e
    public final Object f(t6.a aVar, float f) {
        return e();
    }

    @Override // j6.e
    public final void h() {
        if (this.f6634e != null) {
            super.h();
        }
    }

    @Override // j6.e
    public final void i(float f) {
        this.f6633d = f;
    }
}
