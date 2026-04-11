package r3;

import aa.j0;
import java.util.ArrayList;
import java.util.Arrays;
import p1.l0;
import p1.m0;
import p1.p;
import p1.q;
import s1.u;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h extends i {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final byte[] f11385o = {79, 112, 117, 115, 72, 101, 97, 100};

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final byte[] f11386p = {79, 112, 117, 115, 84, 97, 103, 115};

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f11387n;

    public static boolean e(u uVar, byte[] bArr) {
        if (uVar.a() < bArr.length) {
            return false;
        }
        int i = uVar.f11710b;
        byte[] bArr2 = new byte[bArr.length];
        uVar.h(bArr2, 0, bArr.length);
        uVar.J(i);
        return Arrays.equals(bArr2, bArr);
    }

    @Override // r3.i
    public final long b(u uVar) {
        byte[] bArr = uVar.f11709a;
        return (((long) this.i) * w2.b.l(bArr[0], bArr.length > 1 ? bArr[1] : (byte) 0)) / 1000000;
    }

    @Override // r3.i
    public final boolean c(u uVar, long j5, pb.c cVar) {
        if (e(uVar, f11385o)) {
            byte[] bArrCopyOf = Arrays.copyOf(uVar.f11709a, uVar.f11711c);
            int i = bArrCopyOf[9] & 255;
            ArrayList arrayListB = w2.b.b(bArrCopyOf);
            if (((q) cVar.f10310v) == null) {
                p pVar = new p();
                pVar.f9966l = m0.p("audio/ogg");
                pVar.f9967m = m0.p("audio/opus");
                pVar.E = i;
                pVar.F = 48000;
                pVar.f9970p = arrayListB;
                cVar.f10310v = new q(pVar);
                return true;
            }
        } else {
            if (!e(uVar, f11386p)) {
                s1.d.h((q) cVar.f10310v);
                return false;
            }
            s1.d.h((q) cVar.f10310v);
            if (!this.f11387n) {
                this.f11387n = true;
                uVar.K(8);
                l0 l0VarS = w2.b.s(j0.s((String[]) w2.b.w(uVar, false, false).f8343u));
                if (l0VarS != null) {
                    p pVarA = ((q) cVar.f10310v).a();
                    pVarA.f9965k = l0VarS.b(((q) cVar.f10310v).f10021l);
                    cVar.f10310v = new q(pVarA);
                    return true;
                }
            }
        }
        return true;
    }

    @Override // r3.i
    public final void d(boolean z2) {
        super.d(z2);
        if (z2) {
            this.f11387n = false;
        }
    }
}
