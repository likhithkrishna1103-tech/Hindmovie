package g4;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f4953u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ b0 f4954v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ s f4955w;

    public /* synthetic */ b(b0 b0Var, s sVar, int i) {
        this.f4953u = i;
        this.f4954v = b0Var;
        this.f4955w = sVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4953u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                b0 b0Var = this.f4954v;
                if (!b0Var.j()) {
                    if (b0Var.f4977x) {
                        s sVar = this.f4955w;
                        if (!b0.k(sVar)) {
                            if (b0Var.i(sVar)) {
                                b0Var.f4977x = false;
                            }
                        }
                    }
                    b0Var.f4960e.getClass();
                    break;
                }
                break;
            case 1:
                this.f4954v.f4961g.K(this.f4955w, Integer.MIN_VALUE, 9, f1.M(new s0(2)));
                break;
            case 2:
                this.f4954v.f4961g.K(this.f4955w, Integer.MIN_VALUE, 7, f1.M(new b2.f(28)));
                break;
            case 3:
                this.f4954v.f4961g.K(this.f4955w, Integer.MIN_VALUE, 12, f1.M(new s0(1)));
                break;
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                this.f4954v.f4961g.K(this.f4955w, Integer.MIN_VALUE, 11, f1.M(new b2.f(26)));
                break;
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                this.f4954v.f4961g.K(this.f4955w, Integer.MIN_VALUE, 3, f1.M(new s0(8)));
                break;
            case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                this.f4954v.f4961g.K(this.f4955w, Integer.MIN_VALUE, 1, f1.M(new b2.f(23)));
                break;
            case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                f1 f1Var = this.f4954v.f4961g;
                f1Var.getClass();
                s sVar2 = this.f4955w;
                f1Var.K(sVar2, Integer.MIN_VALUE, 1, f1.M(new b2.b(f1Var, 6, sVar2)));
                break;
            case 8:
                f1 f1Var2 = this.f4954v.f4961g;
                f1Var2.getClass();
                s sVar3 = this.f4955w;
                f1Var2.K(sVar3, Integer.MIN_VALUE, 1, f1.M(new b2.b(f1Var2, 6, sVar3)));
                break;
            default:
                this.f4954v.f4961g.K(this.f4955w, Integer.MIN_VALUE, 1, f1.M(new b2.f(23)));
                break;
        }
    }
}
