package q3;

import s1.b0;
import w2.h0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h0 f10625a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public u f10628d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public g f10629e;
    public int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f10630g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f10631h;
    public int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final p1.q f10632j;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f10635m;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t f10626b = new t();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final s1.u f10627c = new s1.u();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final s1.u f10633k = new s1.u(1);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final s1.u f10634l = new s1.u();

    public j(h0 h0Var, u uVar, g gVar, p1.q qVar) {
        this.f10625a = h0Var;
        this.f10628d = uVar;
        this.f10629e = gVar;
        this.f10632j = qVar;
        this.f10628d = uVar;
        this.f10629e = gVar;
        h0Var.d(qVar);
        e();
    }

    public final int a() {
        int i = !this.f10635m ? this.f10628d.f10735g[this.f] : this.f10626b.f10722j[this.f] ? 1 : 0;
        return b() != null ? i | 1073741824 : i;
    }

    public final s b() {
        if (this.f10635m) {
            t tVar = this.f10626b;
            g gVar = tVar.f10715a;
            int i = b0.f11647a;
            int i10 = gVar.f10617a;
            s sVar = tVar.f10725m;
            if (sVar == null) {
                s[] sVarArr = this.f10628d.f10730a.f10709l;
                sVar = sVarArr == null ? null : sVarArr[i10];
            }
            if (sVar != null && sVar.f10710a) {
                return sVar;
            }
        }
        return null;
    }

    public final boolean c() {
        this.f++;
        if (!this.f10635m) {
            return false;
        }
        int i = this.f10630g + 1;
        this.f10630g = i;
        int[] iArr = this.f10626b.f10720g;
        int i10 = this.f10631h;
        if (i != iArr[i10]) {
            return true;
        }
        this.f10631h = i10 + 1;
        this.f10630g = 0;
        return false;
    }

    public final int d(int i, int i10) {
        s1.u uVar;
        s sVarB = b();
        if (sVarB == null) {
            return 0;
        }
        int length = sVarB.f10713d;
        t tVar = this.f10626b;
        if (length != 0) {
            uVar = tVar.f10726n;
        } else {
            byte[] bArr = sVarB.f10714e;
            int i11 = b0.f11647a;
            int length2 = bArr.length;
            s1.u uVar2 = this.f10634l;
            uVar2.H(length2, bArr);
            length = bArr.length;
            uVar = uVar2;
        }
        boolean z2 = tVar.f10723k && tVar.f10724l[this.f];
        boolean z10 = z2 || i10 != 0;
        s1.u uVar3 = this.f10633k;
        uVar3.f11709a[0] = (byte) ((z10 ? 128 : 0) | length);
        uVar3.J(0);
        h0 h0Var = this.f10625a;
        h0Var.b(uVar3, 1, 1);
        h0Var.b(uVar, length, 1);
        if (!z10) {
            return length + 1;
        }
        s1.u uVar4 = this.f10627c;
        if (!z2) {
            uVar4.G(8);
            byte[] bArr2 = uVar4.f11709a;
            bArr2[0] = 0;
            bArr2[1] = 1;
            bArr2[2] = (byte) 0;
            bArr2[3] = (byte) (i10 & 255);
            bArr2[4] = (byte) ((i >> 24) & 255);
            bArr2[5] = (byte) ((i >> 16) & 255);
            bArr2[6] = (byte) ((i >> 8) & 255);
            bArr2[7] = (byte) (i & 255);
            h0Var.b(uVar4, 8, 1);
            return length + 9;
        }
        s1.u uVar5 = tVar.f10726n;
        int iD = uVar5.D();
        uVar5.K(-2);
        int i12 = (iD * 6) + 2;
        if (i10 != 0) {
            uVar4.G(i12);
            byte[] bArr3 = uVar4.f11709a;
            uVar5.h(bArr3, 0, i12);
            int i13 = (((bArr3[2] & 255) << 8) | (bArr3[3] & 255)) + i10;
            bArr3[2] = (byte) ((i13 >> 8) & 255);
            bArr3[3] = (byte) (i13 & 255);
        } else {
            uVar4 = uVar5;
        }
        h0Var.b(uVar4, i12, 1);
        return length + 1 + i12;
    }

    public final void e() {
        t tVar = this.f10626b;
        tVar.f10718d = 0;
        tVar.f10728p = 0L;
        tVar.f10729q = false;
        tVar.f10723k = false;
        tVar.f10727o = false;
        tVar.f10725m = null;
        this.f = 0;
        this.f10631h = 0;
        this.f10630g = 0;
        this.i = 0;
        this.f10635m = false;
    }
}
