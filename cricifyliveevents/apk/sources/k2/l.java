package k2;

import android.net.Uri;
import java.util.ArrayList;
import ua.i0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class l extends m {
    public final j A;
    public final p6.c B;

    public l(v1.p pVar, i0 i0Var, r rVar, ArrayList arrayList) {
        super(pVar, i0Var, rVar, arrayList);
        Uri.parse(((b) i0Var.get(0)).f6827a);
        long j4 = rVar.f6888e;
        j jVar = j4 <= 0 ? null : new j(rVar.f6887d, j4, null);
        this.A = jVar;
        this.B = jVar == null ? new p6.c(25, new j(0L, -1L, null)) : null;
    }

    @Override // k2.m
    public final String a() {
        return null;
    }

    @Override // k2.m
    public final j2.i d() {
        return this.B;
    }

    @Override // k2.m
    public final j e() {
        return this.A;
    }
}
