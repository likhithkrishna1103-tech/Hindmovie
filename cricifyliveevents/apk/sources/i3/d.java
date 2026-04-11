package i3;

import a3.b0;
import a3.c0;
import a3.d0;
import a3.w;
import f9.s0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d extends w {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c0 f6176b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ s0 f6177c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(s0 s0Var, c0 c0Var, c0 c0Var2) {
        super(c0Var);
        this.f6177c = s0Var;
        this.f6176b = c0Var2;
    }

    @Override // a3.w, a3.c0
    public final b0 j(long j4) {
        b0 b0VarJ = this.f6176b.j(j4);
        d0 d0Var = b0VarJ.f146a;
        long j7 = d0Var.f158a;
        long j10 = d0Var.f159b;
        long j11 = this.f6177c.f4390w;
        d0 d0Var2 = new d0(j7, j10 + j11);
        d0 d0Var3 = b0VarJ.f147b;
        return new b0(d0Var2, new d0(d0Var3.f158a, d0Var3.f159b + j11));
    }
}
