package w2;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class t implements b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13665a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f13666b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f13667c;

    public /* synthetic */ t(int i, long j5, Object obj) {
        this.f13665a = i;
        this.f13667c = obj;
        this.f13666b = j5;
    }

    @Override // w2.b0
    public final boolean h() {
        switch (this.f13665a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return true;
            case 1:
                return false;
            default:
                return true;
        }
    }

    @Override // w2.b0
    public final a0 i(long j5) {
        switch (this.f13665a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                u uVar = (u) this.f13667c;
                s1.d.h(uVar.f13676k);
                p2.c cVar = uVar.f13676k;
                long[] jArr = (long[]) cVar.f10130v;
                long[] jArr2 = (long[]) cVar.f10131w;
                int iE = s1.b0.e(jArr, s1.b0.j((((long) uVar.f13672e) * j5) / 1000000, 0L, uVar.f13675j - 1), false);
                long j8 = iE == -1 ? 0L : jArr[iE];
                long j10 = iE != -1 ? jArr2[iE] : 0L;
                int i = uVar.f13672e;
                long j11 = (j8 * 1000000) / ((long) i);
                long j12 = this.f13666b;
                c0 c0Var = new c0(j11, j10 + j12);
                if (j11 == j5 || iE == jArr.length - 1) {
                    return new a0(c0Var, c0Var);
                }
                int i10 = iE + 1;
                return new a0(c0Var, new c0((jArr[i10] * 1000000) / ((long) i), j12 + jArr2[i10]));
            case 1:
                return (a0) this.f13667c;
            default:
                y2.b bVar = (y2.b) this.f13667c;
                a0 a0VarB = bVar.i[0].b(j5);
                int i11 = 1;
                while (true) {
                    y2.e[] eVarArr = bVar.i;
                    if (i11 >= eVarArr.length) {
                        return a0VarB;
                    }
                    a0 a0VarB2 = eVarArr[i11].b(j5);
                    if (a0VarB2.f13569a.f13602b < a0VarB.f13569a.f13602b) {
                        a0VarB = a0VarB2;
                    }
                    i11++;
                }
                break;
        }
    }

    @Override // w2.b0
    public final long k() {
        switch (this.f13665a) {
        }
        return this.f13666b;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public t(long j5) {
        this(j5, 0L);
        this.f13665a = 1;
    }

    public t(long j5, long j8) {
        this.f13665a = 1;
        this.f13666b = j5;
        c0 c0Var = j8 == 0 ? c0.f13600c : new c0(0L, j8);
        this.f13667c = new a0(c0Var, c0Var);
    }
}
