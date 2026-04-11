package j6;

import nb.w;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i extends k {
    @Override // j6.e
    public final Object f(t6.a aVar, float f) {
        return Float.valueOf(m(aVar, f));
    }

    public final float l() {
        return m(this.f6632c.e(), c());
    }

    public final float m(t6.a aVar, float f) {
        float f10;
        Object obj = aVar.f11932b;
        Object obj2 = aVar.f11932b;
        if (obj == null || aVar.f11933c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        w wVar = this.f6634e;
        if (wVar != null) {
            f10 = f;
            Float f11 = (Float) wVar.G(aVar.f11936g, aVar.f11937h.floatValue(), (Float) obj2, (Float) aVar.f11933c, f10, d(), this.f6633d);
            if (f11 != null) {
                return f11.floatValue();
            }
        } else {
            f10 = f;
        }
        if (aVar.i == -3987645.8f) {
            aVar.i = ((Float) obj2).floatValue();
        }
        float f12 = aVar.i;
        if (aVar.f11938j == -3987645.8f) {
            aVar.f11938j = ((Float) aVar.f11933c).floatValue();
        }
        return s6.g.f(f12, aVar.f11938j, f10);
    }
}
