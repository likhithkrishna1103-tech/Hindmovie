package u3;

import a3.i0;
import y1.a0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i0 f12100a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public t f12103d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public f f12104e;
    public int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f12105g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f12106h;
    public int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final v1.p f12107j;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f12110m;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s f12101b = new s();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final y1.t f12102c = new y1.t();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final y1.t f12108k = new y1.t(1);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final y1.t f12109l = new y1.t();

    public i(i0 i0Var, t tVar, f fVar, v1.p pVar) {
        this.f12100a = i0Var;
        this.f12103d = tVar;
        this.f12104e = fVar;
        this.f12107j = pVar;
        this.f12103d = tVar;
        this.f12104e = fVar;
        i0Var.f(pVar);
        e();
    }

    public final int a() {
        int i = !this.f12110m ? this.f12103d.f12210g[this.f] : this.f12101b.f12197j[this.f] ? 1 : 0;
        return b() != null ? i | 1073741824 : i;
    }

    public final r b() {
        if (!this.f12110m) {
            return null;
        }
        s sVar = this.f12101b;
        f fVar = sVar.f12190a;
        int i = a0.f14551a;
        int i10 = fVar.f12092a;
        r rVar = sVar.f12200m;
        if (rVar == null) {
            rVar = this.f12103d.f12205a.f12184l[i10];
        }
        if (rVar == null || !rVar.f12185a) {
            return null;
        }
        return rVar;
    }

    public final boolean c() {
        this.f++;
        if (!this.f12110m) {
            return false;
        }
        int i = this.f12105g + 1;
        this.f12105g = i;
        int[] iArr = this.f12101b.f12195g;
        int i10 = this.f12106h;
        if (i != iArr[i10]) {
            return true;
        }
        this.f12106h = i10 + 1;
        this.f12105g = 0;
        return false;
    }

    public final int d(int i, int i10) {
        y1.t tVar;
        r rVarB = b();
        if (rVarB == null) {
            return 0;
        }
        int length = rVarB.f12188d;
        s sVar = this.f12101b;
        if (length != 0) {
            tVar = sVar.f12201n;
        } else {
            byte[] bArr = rVarB.f12189e;
            int i11 = a0.f14551a;
            int length2 = bArr.length;
            y1.t tVar2 = this.f12109l;
            tVar2.H(length2, bArr);
            length = bArr.length;
            tVar = tVar2;
        }
        boolean z10 = sVar.f12198k && sVar.f12199l[this.f];
        boolean z11 = z10 || i10 != 0;
        y1.t tVar3 = this.f12108k;
        tVar3.f14609a[0] = (byte) ((z11 ? 128 : 0) | length);
        tVar3.J(0);
        i0 i0Var = this.f12100a;
        i0Var.c(tVar3, 1, 1);
        i0Var.c(tVar, length, 1);
        if (!z11) {
            return length + 1;
        }
        y1.t tVar4 = this.f12102c;
        if (!z10) {
            tVar4.G(8);
            byte[] bArr2 = tVar4.f14609a;
            bArr2[0] = 0;
            bArr2[1] = 1;
            bArr2[2] = (byte) 0;
            bArr2[3] = (byte) (i10 & 255);
            bArr2[4] = (byte) ((i >> 24) & 255);
            bArr2[5] = (byte) ((i >> 16) & 255);
            bArr2[6] = (byte) ((i >> 8) & 255);
            bArr2[7] = (byte) (i & 255);
            i0Var.c(tVar4, 8, 1);
            return length + 9;
        }
        y1.t tVar5 = sVar.f12201n;
        int iD = tVar5.D();
        tVar5.K(-2);
        int i12 = (iD * 6) + 2;
        if (i10 != 0) {
            tVar4.G(i12);
            byte[] bArr3 = tVar4.f14609a;
            tVar5.h(bArr3, 0, i12);
            int i13 = (((bArr3[2] & 255) << 8) | (bArr3[3] & 255)) + i10;
            bArr3[2] = (byte) ((i13 >> 8) & 255);
            bArr3[3] = (byte) (i13 & 255);
        } else {
            tVar4 = tVar5;
        }
        i0Var.c(tVar4, i12, 1);
        return length + 1 + i12;
    }

    public final void e() {
        s sVar = this.f12101b;
        sVar.f12193d = 0;
        sVar.f12203p = 0L;
        sVar.f12204q = false;
        sVar.f12198k = false;
        sVar.f12202o = false;
        sVar.f12200m = null;
        this.f = 0;
        this.f12106h = 0;
        this.f12105g = 0;
        this.i = 0;
        this.f12110m = false;
    }
}
