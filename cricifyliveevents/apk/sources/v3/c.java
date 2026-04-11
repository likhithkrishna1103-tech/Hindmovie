package v3;

import a3.v;
import f9.a4;
import java.util.Arrays;
import l4.c0;
import nb.w;
import v1.m0;
import v1.o;
import v1.p;
import y1.t;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends i {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public v f13139n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public a4 f13140o;

    @Override // v3.i
    public final long b(t tVar) {
        byte[] bArr = tVar.f14609a;
        if (bArr[0] != -1) {
            return -1L;
        }
        int i = (bArr[2] & 255) >> 4;
        if (i == 6 || i == 7) {
            tVar.K(4);
            tVar.E();
        }
        int iT = a3.b.t(i, tVar);
        tVar.J(0);
        return iT;
    }

    @Override // v3.i
    public final boolean c(t tVar, long j4, w wVar) {
        byte[] bArr = tVar.f14609a;
        v vVar = this.f13139n;
        if (vVar == null) {
            v vVar2 = new v(17, bArr);
            this.f13139n = vVar2;
            o oVarA = vVar2.c(Arrays.copyOfRange(bArr, 9, tVar.f14611c), null).a();
            oVarA.f12892l = m0.p("audio/ogg");
            wVar.f9016w = new p(oVarA);
            return true;
        }
        byte b8 = bArr[0];
        if ((b8 & 127) != 3) {
            if (b8 != -1) {
                return true;
            }
            a4 a4Var = this.f13140o;
            if (a4Var != null) {
                a4Var.f4008v = j4;
                wVar.f9017x = a4Var;
            }
            ((p) wVar.f9016w).getClass();
            return false;
        }
        c0 c0VarU = a3.b.u(tVar);
        v vVar3 = new v(vVar.f231a, vVar.f232b, vVar.f233c, vVar.f234d, vVar.f235e, vVar.f236g, vVar.f237h, vVar.f238j, c0VarU, vVar.f240l);
        this.f13139n = vVar3;
        a4 a4Var2 = new a4();
        a4Var2.f4010x = vVar3;
        a4Var2.f4011y = c0VarU;
        a4Var2.f4008v = -1L;
        a4Var2.f4009w = -1L;
        this.f13140o = a4Var2;
        return true;
    }

    @Override // v3.i
    public final void d(boolean z10) {
        super.d(z10);
        if (z10) {
            this.f13139n = null;
            this.f13140o = null;
        }
    }
}
