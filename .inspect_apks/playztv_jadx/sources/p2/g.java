package p2;

import aa.l0;
import androidx.media3.decoder.DecoderInputBuffer;
import h4.z;
import o2.b1;
import o2.c1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g implements c1 {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final i f10149u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final b1 f10150v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f10151w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f10152x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ i f10153y;

    public g(i iVar, i iVar2, b1 b1Var, int i) {
        this.f10153y = iVar;
        this.f10149u = iVar2;
        this.f10150v = b1Var;
        this.f10151w = i;
    }

    public final void a() {
        if (this.f10152x) {
            return;
        }
        i iVar = this.f10153y;
        l0 l0Var = iVar.A;
        int[] iArr = iVar.f10155v;
        int i = this.f10151w;
        l0Var.g(iArr[i], iVar.f10156w[i], 0, null, iVar.N);
        this.f10152x = true;
    }

    @Override // o2.c1
    public final int e(z zVar, DecoderInputBuffer decoderInputBuffer, int i) {
        i iVar = this.f10153y;
        if (iVar.z()) {
            return -3;
        }
        a aVar = iVar.P;
        b1 b1Var = this.f10150v;
        if (aVar != null && aVar.e(this.f10151w + 1) <= b1Var.t()) {
            return -3;
        }
        a();
        return b1Var.C(zVar, decoderInputBuffer, i, iVar.S);
    }

    @Override // o2.c1
    public final boolean j() {
        i iVar = this.f10153y;
        return !iVar.z() && this.f10150v.x(iVar.S);
    }

    @Override // o2.c1
    public final int q(long j5) {
        i iVar = this.f10153y;
        if (iVar.z()) {
            return 0;
        }
        boolean z2 = iVar.S;
        b1 b1Var = this.f10150v;
        int iV = b1Var.v(z2, j5);
        a aVar = iVar.P;
        if (aVar != null) {
            iV = Math.min(iV, aVar.e(this.f10151w + 1) - b1Var.t());
        }
        b1Var.H(iV);
        if (iV > 0) {
            a();
        }
        return iV;
    }

    @Override // o2.c1
    public final void b() {
    }
}
