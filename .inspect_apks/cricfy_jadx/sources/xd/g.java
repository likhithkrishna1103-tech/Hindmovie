package xd;

import vd.i;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class g extends a {
    public g(vd.c cVar) {
        super(cVar);
        if (cVar != null && cVar.h() != i.f13722v) {
            throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext");
        }
    }

    @Override // vd.c
    public final vd.h h() {
        return i.f13722v;
    }
}
