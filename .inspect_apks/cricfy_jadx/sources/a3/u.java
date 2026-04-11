package a3;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class u implements c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f228a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f229b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f230c;

    public /* synthetic */ u(Object obj, long j4, int i) {
        this.f228a = i;
        this.f230c = obj;
        this.f229b = j4;
    }

    @Override // a3.c0
    public final boolean g() {
        switch (this.f228a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return true;
            case 1:
                return false;
            default:
                return true;
        }
    }

    @Override // a3.c0
    public final b0 j(long j4) {
        switch (this.f228a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                v vVar = (v) this.f230c;
                y1.d.h(vVar.f239k);
                l4.c0 c0Var = vVar.f239k;
                long[] jArr = (long[]) c0Var.f7705w;
                long[] jArr2 = (long[]) c0Var.f7706x;
                int iE = y1.a0.e(jArr, y1.a0.j((((long) vVar.f235e) * j4) / 1000000, 0L, vVar.f238j - 1), false);
                long j7 = iE == -1 ? 0L : jArr[iE];
                long j10 = iE != -1 ? jArr2[iE] : 0L;
                int i = vVar.f235e;
                long j11 = (j7 * 1000000) / ((long) i);
                long j12 = this.f229b;
                d0 d0Var = new d0(j11, j10 + j12);
                if (j11 == j4 || iE == jArr.length - 1) {
                    return new b0(d0Var, d0Var);
                }
                int i10 = iE + 1;
                return new b0(d0Var, new d0((jArr[i10] * 1000000) / ((long) i), j12 + jArr2[i10]));
            case 1:
                return (b0) this.f230c;
            default:
                c3.b bVar = (c3.b) this.f230c;
                b0 b0VarB = bVar.i[0].b(j4);
                int i11 = 1;
                while (true) {
                    c3.e[] eVarArr = bVar.i;
                    if (i11 >= eVarArr.length) {
                        return b0VarB;
                    }
                    b0 b0VarB2 = eVarArr[i11].b(j4);
                    if (b0VarB2.f146a.f159b < b0VarB.f146a.f159b) {
                        b0VarB = b0VarB2;
                    }
                    i11++;
                }
                break;
        }
    }

    @Override // a3.c0
    public final long l() {
        switch (this.f228a) {
        }
        return this.f229b;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public u(long j4) {
        this(j4, 0L);
        this.f228a = 1;
    }

    public u(long j4, long j7) {
        this.f228a = 1;
        this.f229b = j4;
        d0 d0Var = j7 == 0 ? d0.f157c : new d0(0L, j7);
        this.f230c = new b0(d0Var, d0Var);
    }
}
