package j6;

import g6.i0;
import ka.v;
import nb.w;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g extends w {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ w f6637y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(w wVar) {
        super(21);
        this.f6637y = wVar;
    }

    @Override // nb.w
    public final Object F(v vVar) {
        Float f = (Float) ((i0) this.f6637y.f9017x);
        if (f == null) {
            return null;
        }
        return Float.valueOf(f.floatValue() * 2.55f);
    }
}
