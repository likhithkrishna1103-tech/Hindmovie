package v3;

import java.util.ArrayList;
import java.util.Arrays;
import nb.w;
import ua.i0;
import v1.l0;
import v1.m0;
import v1.o;
import v1.p;
import y1.t;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h extends i {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final byte[] f13155o = {79, 112, 117, 115, 72, 101, 97, 100};

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final byte[] f13156p = {79, 112, 117, 115, 84, 97, 103, 115};

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f13157n;

    public static boolean e(t tVar, byte[] bArr) {
        if (tVar.a() < bArr.length) {
            return false;
        }
        int i = tVar.f14610b;
        byte[] bArr2 = new byte[bArr.length];
        tVar.h(bArr2, 0, bArr.length);
        tVar.J(i);
        return Arrays.equals(bArr2, bArr);
    }

    @Override // v3.i
    public final long b(t tVar) {
        byte[] bArr = tVar.f14609a;
        return (((long) this.i) * a3.b.k(bArr[0], bArr.length > 1 ? bArr[1] : (byte) 0)) / 1000000;
    }

    @Override // v3.i
    public final boolean c(t tVar, long j4, w wVar) {
        if (e(tVar, f13155o)) {
            byte[] bArrCopyOf = Arrays.copyOf(tVar.f14609a, tVar.f14611c);
            int i = bArrCopyOf[9] & 255;
            ArrayList arrayListA = a3.b.a(bArrCopyOf);
            if (((p) wVar.f9016w) == null) {
                o oVar = new o();
                oVar.f12892l = m0.p("audio/ogg");
                oVar.f12893m = m0.p("audio/opus");
                oVar.E = i;
                oVar.F = 48000;
                oVar.f12896p = arrayListA;
                wVar.f9016w = new p(oVar);
                return true;
            }
        } else {
            if (!e(tVar, f13156p)) {
                y1.d.h((p) wVar.f9016w);
                return false;
            }
            y1.d.h((p) wVar.f9016w);
            if (!this.f13157n) {
                this.f13157n = true;
                tVar.K(8);
                l0 l0VarR = a3.b.r(i0.l((String[]) a3.b.v(tVar, false, false).f10180v));
                if (l0VarR != null) {
                    o oVarA = ((p) wVar.f9016w).a();
                    oVarA.f12891k = l0VarR.b(((p) wVar.f9016w).f12944l);
                    wVar.f9016w = new p(oVarA);
                    return true;
                }
            }
        }
        return true;
    }

    @Override // v3.i
    public final void d(boolean z10) {
        super.d(z10);
        if (z10) {
            this.f13157n = false;
        }
    }
}
