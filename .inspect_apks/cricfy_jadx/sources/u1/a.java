package u1;

import androidx.fragment.app.t0;
import androidx.lifecycle.o0;
import v.l;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class a extends o0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final t0 f12065e = new t0(2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final l f12066d = new l();

    @Override // androidx.lifecycle.o0
    public final void b() {
        l lVar = this.f12066d;
        if (lVar.e() > 0) {
            lVar.f(0).getClass();
            throw new ClassCastException();
        }
        int i = lVar.f12546y;
        Object[] objArr = lVar.f12545x;
        for (int i10 = 0; i10 < i; i10++) {
            objArr[i10] = null;
        }
        lVar.f12546y = 0;
        lVar.f12543v = false;
    }
}
