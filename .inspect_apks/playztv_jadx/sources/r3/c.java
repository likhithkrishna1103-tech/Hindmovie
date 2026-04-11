package r3;

import java.util.Arrays;
import k8.o3;
import p1.m0;
import p1.p;
import p1.q;
import w2.u;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c extends i {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public u f11369n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public o3 f11370o;

    @Override // r3.i
    public final long b(s1.u uVar) {
        byte[] bArr = uVar.f11709a;
        if (bArr[0] != -1) {
            return -1L;
        }
        int i = (bArr[2] & 255) >> 4;
        if (i == 6 || i == 7) {
            uVar.K(4);
            uVar.E();
        }
        int iU = w2.b.u(i, uVar);
        uVar.J(0);
        return iU;
    }

    @Override // r3.i
    public final boolean c(s1.u uVar, long j5, pb.c cVar) {
        byte[] bArr = uVar.f11709a;
        u uVar2 = this.f11369n;
        if (uVar2 == null) {
            u uVar3 = new u(17, bArr);
            this.f11369n = uVar3;
            p pVarA = uVar3.c(Arrays.copyOfRange(bArr, 9, uVar.f11711c), null).a();
            pVarA.f9966l = m0.p("audio/ogg");
            cVar.f10310v = new q(pVarA);
            return true;
        }
        byte b10 = bArr[0];
        if ((b10 & 127) != 3) {
            if (b10 != -1) {
                return true;
            }
            o3 o3Var = this.f11370o;
            if (o3Var != null) {
                o3Var.f7356u = j5;
                cVar.f10311w = o3Var;
            }
            ((q) cVar.f10310v).getClass();
            return false;
        }
        p2.c cVarV = w2.b.v(uVar);
        u uVar4 = new u(uVar2.f13668a, uVar2.f13669b, uVar2.f13670c, uVar2.f13671d, uVar2.f13672e, uVar2.f13673g, uVar2.f13674h, uVar2.f13675j, cVarV, uVar2.f13677l);
        this.f11369n = uVar4;
        o3 o3Var2 = new o3();
        o3Var2.f7358w = uVar4;
        o3Var2.f7359x = cVarV;
        o3Var2.f7356u = -1L;
        o3Var2.f7357v = -1L;
        this.f11370o = o3Var2;
        return true;
    }

    @Override // r3.i
    public final void d(boolean z2) {
        super.d(z2);
        if (z2) {
            this.f11369n = null;
            this.f11370o = null;
        }
    }
}
