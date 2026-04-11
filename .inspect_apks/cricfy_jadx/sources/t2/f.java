package t2;

import androidx.media3.decoder.DecoderInputBuffer;
import l4.c0;
import s2.a1;
import s2.z0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f implements a1 {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final h f11853v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final z0 f11854w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f11855x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f11856y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ h f11857z;

    public f(h hVar, h hVar2, z0 z0Var, int i) {
        this.f11857z = hVar;
        this.f11853v = hVar2;
        this.f11854w = z0Var;
        this.f11855x = i;
    }

    public final void a() {
        if (this.f11856y) {
            return;
        }
        h hVar = this.f11857z;
        f3.a aVar = hVar.B;
        int[] iArr = hVar.f11859w;
        int i = this.f11855x;
        aVar.f(iArr[i], hVar.f11860x[i], 0, null, hVar.O);
        this.f11856y = true;
    }

    @Override // s2.a1
    public final boolean b() {
        h hVar = this.f11857z;
        return !hVar.y() && this.f11854w.x(hVar.T);
    }

    @Override // s2.a1
    public final int e(long j4) {
        h hVar = this.f11857z;
        if (hVar.y()) {
            return 0;
        }
        boolean z10 = hVar.T;
        z0 z0Var = this.f11854w;
        int iV = z0Var.v(z10, j4);
        a aVar = hVar.Q;
        if (aVar != null) {
            iV = Math.min(iV, aVar.e(this.f11855x + 1) - z0Var.t());
        }
        z0Var.H(iV);
        if (iV > 0) {
            a();
        }
        return iV;
    }

    @Override // s2.a1
    public final int p(c0 c0Var, DecoderInputBuffer decoderInputBuffer, int i) {
        h hVar = this.f11857z;
        if (hVar.y()) {
            return -3;
        }
        a aVar = hVar.Q;
        z0 z0Var = this.f11854w;
        if (aVar != null && aVar.e(this.f11855x + 1) <= z0Var.t()) {
            return -3;
        }
        a();
        return z0Var.C(c0Var, decoderInputBuffer, i, hVar.T);
    }

    @Override // s2.a1
    public final void c() {
    }
}
