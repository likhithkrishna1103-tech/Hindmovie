package ua;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class l0 extends c0 {
    @Override // ua.c0
    public final c0 c(Object obj) {
        obj.getClass();
        a(obj);
        return this;
    }

    public final m0 g() {
        int i = this.f12310b;
        if (i == 0) {
            int i10 = m0.f12358x;
            return f1.E;
        }
        if (i != 1) {
            m0 m0VarJ = m0.j(i, this.f12309a);
            this.f12310b = m0VarJ.size();
            this.f12311c = true;
            return m0VarJ;
        }
        Object obj = this.f12309a[0];
        Objects.requireNonNull(obj);
        int i11 = m0.f12358x;
        return new l1(obj);
    }
}
