package g2;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class x implements y1.m, ta.f, y1.h {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f4945v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ int f4946w;

    public /* synthetic */ x(int i, int i10) {
        this.f4945v = i10;
        this.f4946w = i;
    }

    @Override // y1.m
    public void a(Object obj) {
        switch (this.f4945v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((v1.u0) obj).c(this.f4946w);
                break;
            case 1:
                ((v1.u0) obj).d(this.f4946w);
                break;
            default:
                h2.k kVar = (h2.k) obj;
                kVar.getClass();
                int i = this.f4946w;
                if (i == 1) {
                    kVar.f5531v = true;
                }
                kVar.f5521l = i;
                break;
        }
    }

    @Override // y1.h
    public void accept(Object obj) {
        switch (this.f4945v) {
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                ((k4.h1) obj).F(this.f4946w);
                break;
            case g1.h.STRING_FIELD_NUMBER /* 5 */:
                ((k4.h1) obj).j0(this.f4946w);
                break;
            case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                ((k4.h1) obj).g0(this.f4946w);
                break;
            default:
                ((k4.h1) obj).I0(this.f4946w);
                break;
        }
    }

    @Override // ta.f
    public Object apply(Object obj) {
        return Integer.valueOf(this.f4946w);
    }

    public /* synthetic */ x(h2.a aVar, int i, v1.v0 v0Var, v1.v0 v0Var2) {
        this.f4945v = 3;
        this.f4946w = i;
    }
}
