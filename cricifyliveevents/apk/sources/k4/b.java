package k4;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f6904v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ b0 f6905w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ s f6906x;

    public /* synthetic */ b(b0 b0Var, s sVar, int i) {
        this.f6904v = i;
        this.f6905w = b0Var;
        this.f6906x = sVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6904v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                b0 b0Var = this.f6905w;
                if (!b0Var.j()) {
                    if (b0Var.f6928x) {
                        s sVar = this.f6906x;
                        if (!b0.k(sVar)) {
                            if (b0Var.i(sVar)) {
                                b0Var.f6928x = false;
                            }
                        }
                    }
                    b0Var.f6911e.getClass();
                    break;
                }
                break;
            case 1:
                this.f6905w.f6912g.Q(this.f6906x, Integer.MIN_VALUE, 9, d1.S(new r0(1)));
                break;
            case 2:
                this.f6905w.f6912g.Q(this.f6906x, Integer.MIN_VALUE, 7, d1.S(new h2.e(27)));
                break;
            case 3:
                this.f6905w.f6912g.Q(this.f6906x, Integer.MIN_VALUE, 12, d1.S(new r0(0)));
                break;
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                this.f6905w.f6912g.Q(this.f6906x, Integer.MIN_VALUE, 11, d1.S(new h2.e(25)));
                break;
            case g1.h.STRING_FIELD_NUMBER /* 5 */:
                this.f6905w.f6912g.Q(this.f6906x, Integer.MIN_VALUE, 3, d1.S(new r0(7)));
                break;
            case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                this.f6905w.f6912g.Q(this.f6906x, Integer.MIN_VALUE, 1, d1.S(new h2.e(22)));
                break;
            case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                d1 d1Var = this.f6905w.f6912g;
                d1Var.getClass();
                s sVar2 = this.f6906x;
                d1Var.Q(sVar2, Integer.MIN_VALUE, 1, d1.S(new androidx.fragment.app.e(11, d1Var, sVar2)));
                break;
            case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                d1 d1Var2 = this.f6905w.f6912g;
                d1Var2.getClass();
                s sVar3 = this.f6906x;
                d1Var2.Q(sVar3, Integer.MIN_VALUE, 1, d1.S(new androidx.fragment.app.e(11, d1Var2, sVar3)));
                break;
            default:
                this.f6905w.f6912g.Q(this.f6906x, Integer.MIN_VALUE, 1, d1.S(new h2.e(22)));
                break;
        }
    }
}
